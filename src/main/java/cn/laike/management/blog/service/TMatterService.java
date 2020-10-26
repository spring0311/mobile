package cn.laike.management.blog.service;

import cn.laike.management.blog.entity.TMatter;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sun
 * @since 2020-07-23
 */
@Service
public interface TMatterService extends IService<TMatter> {

    /**
     * 查找matter
     *
     * @param tMatter
     * @return
     */
    List<TMatter> findMatters(TMatter tMatter);

    /**
     * 新增
     *
     * @param tMatter
     */
    void createMatter(TMatter tMatter) throws ParseException;

    /**
     * 修改matter
     *
     * @param tMatter
     */
    void updateMatter(TMatter tMatter);
    void updateMatters(TMatter tMatter);
    /**
     * 删除
     *
     * @param tMatter
     */
    void deleteMatter(TMatter tMatter);
}
