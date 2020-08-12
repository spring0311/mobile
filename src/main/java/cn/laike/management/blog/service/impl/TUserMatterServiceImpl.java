package cn.laike.management.blog.service.impl;

import cn.laike.management.blog.entity.TMatter;
import cn.laike.management.blog.entity.TUserMatter;
import cn.laike.management.blog.mapper.TUserMatterMapper;
import cn.laike.management.blog.service.TMatterService;
import cn.laike.management.blog.service.TUserMatterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sun
 * @since 2020-07-24
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TUserMatterServiceImpl extends ServiceImpl<TUserMatterMapper, TUserMatter> implements TUserMatterService {


    @Autowired
    private TUserMatterMapper tUserMatterMapper;

    @Autowired
    private TMatterService tMatterService;


    @Override
    public void addMatterService(Long id, TMatter tMatter) {


    }
}
