package cn.laike.management.blog.service.impl;

import cn.laike.management.blog.entity.TUser;
import cn.laike.management.blog.mapper.TUserMapper;
import cn.laike.management.blog.service.TUserService;
import cn.laike.management.blog.service.ex.PasswordNotMatchException;
import cn.laike.management.blog.service.ex.UserNotFoundException;
import cn.laike.management.blog.util.Md5Util;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author sun
 * @since 2020-07-23
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser login(TUser tUser) {
        String username = tUser.getUsername();
        String password = tUser.getPassword();
        //查询用户是否存在
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        List<TUser> list = tUserMapper.selectByMap(map);
        if (list.isEmpty()) {
            throw new UserNotFoundException("登陆失败,用户名不存在");
        }
        TUser user = list.get(0);
        //获得加密后密码
        String md5Password = Md5Util.encrypt(username.toLowerCase(), password);
        //判断解密后密码与输入的密码是否一致
        if (!user.getPassword().equals(md5Password)) {
            //否
            throw new PasswordNotMatchException("登陆失败,密码错误!");
        }
        //清理数据
        user.setPassword(null);
        return user;
    }
}
