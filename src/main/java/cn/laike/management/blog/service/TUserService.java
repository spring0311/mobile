package cn.laike.management.blog.service;

import cn.laike.management.blog.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author sun
 * @since 2020-07-23
 */
public interface TUserService extends IService<TUser> {

    TUser login(TUser tUser);

}
