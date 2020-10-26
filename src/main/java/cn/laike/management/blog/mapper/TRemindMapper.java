package cn.laike.management.blog.mapper;

import cn.laike.management.blog.entity.TRemind;
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
public interface TRemindMapper extends BaseMapper<TRemind> {

    List<TRemind> testSelect(@Param("tRemind") TRemind tRemind);

}
