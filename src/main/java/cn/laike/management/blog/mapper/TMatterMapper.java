package cn.laike.management.blog.mapper;

import cn.laike.management.blog.entity.TMatter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}
