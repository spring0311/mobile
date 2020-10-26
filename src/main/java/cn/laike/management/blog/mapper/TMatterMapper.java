package cn.laike.management.blog.mapper;

import cn.laike.management.blog.entity.TMatter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author weiZiHao
 * @since 2020-08-01
 */
public interface TMatterMapper extends BaseMapper<TMatter> {


    /**
     * 查找所有用户所属Matter
     *
     * @param tMatter
     * @return
     */
    List<TMatter> selectMattersByMatter(@Param(value = "tMatter") TMatter tMatter);

    /**
     * 查找matterName
     */
    String selectMatterName(@Param("tMatter") TMatter tMatter);

    /**
     * 查询最大ID
     * @return
     */
    Long selectMaxMatterId();
}
