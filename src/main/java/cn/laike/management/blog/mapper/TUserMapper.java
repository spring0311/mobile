package cn.laike.management.blog.mapper;

import cn.laike.management.blog.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author sun
 * @since 2020-07-23
 */
public interface TUserMapper extends BaseMapper<TUser> {

    /**
     * test
     *
     * @param userId
     * @return
     */
    TUser selectUsernameByUid(Long userId);

}
