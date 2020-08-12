package cn.laike.management.blog.service;

import cn.laike.management.blog.entity.TMatter;
import cn.laike.management.blog.entity.TUserMatter;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sun
 * @since 2020-07-24
 */
public interface TUserMatterService extends IService<TUserMatter> {


    void addMatterService(Long id, TMatter tMatter);

}
