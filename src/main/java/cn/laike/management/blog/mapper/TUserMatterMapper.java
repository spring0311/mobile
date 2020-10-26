package cn.laike.management.blog.mapper;

import cn.laike.management.blog.entity.TUserMatter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author sun
 * @since 2020-07-24
 */
public interface TUserMatterMapper extends BaseMapper<TUserMatter> {

    /**
     * @param tUserMatter
     */
    void updateByUserIdAndMatterId(@Param("tUserMatter") TUserMatter tUserMatter);
    void updateByUserIdAndMatterIds(@Param("tUserMatter") TUserMatter tUserMatter);
    /**
     * 根据userId查询matterId
     *
     * @param userId
     * @return
     */
    List<Long> selectMatterIds(Long userId);
}
