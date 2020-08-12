package cn.laike.management.blog.service.impl;

import cn.laike.management.blog.entity.TMatter;
import cn.laike.management.blog.entity.TUserMatter;
import cn.laike.management.blog.mapper.TMatterMapper;
import cn.laike.management.blog.mapper.TRemindMapper;
import cn.laike.management.blog.mapper.TUserMatterMapper;
import cn.laike.management.blog.service.TMatterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sun
 * @since 2020-07-23
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TMatterServiceImpl extends ServiceImpl<TMatterMapper, TMatter> implements TMatterService {

    @Autowired
    private TUserMatterMapper tUserMatterMapper;
    @Autowired
    private TRemindMapper tRemindMapper;


    @Autowired
    private TMatterMapper tMatterMapper;

    /**
     * @param tMatter
     * @return
     */
    @Override
    public List<TMatter> findMatters(TMatter tMatter) {
        return tMatterMapper.selectMattersByMatter(tMatter);
    }

    @Override
    public void createMatter(TMatter tMatter) {
        TUserMatter tUserMatter = new TUserMatter();
        tUserMatter.setUrgentOne(tMatter.getUrgentOne());
        tUserMatter.setImportantOne(tMatter.getImportantOne());
        tUserMatter.setUserId(tMatter.getUserId());
        tUserMatter.setFinish(0);
        tMatterMapper.insert(tMatter);
        TMatter matter = tMatterMapper.selectMattersByMatter(tMatter).get(0);
        tUserMatter.setMatterId(matter.getMatterId());
        tUserMatterMapper.insert(tUserMatter);
    }

    @Override
    public void updateMatter(TMatter tMatter) {
        //修改映射表状态
        TUserMatter tUserMatter = new TUserMatter();
        tUserMatter.setFinish(tMatter.getFinish());
        tUserMatter.setImportantOne(tMatter.getImportantOne());
        tUserMatter.setUrgentOne(tMatter.getUrgentOne());
        tUserMatter.setMatterId(tMatter.getMatterId());
        tUserMatter.setFinish(tMatter.getFinish());
        tUserMatter.setUserId(tMatter.getUserId());
        System.err.println(tUserMatter);
        tUserMatterMapper.updateByUserIdAndMatterId(tUserMatter);
        //修改事项信息
        tMatter.setUrgent(null);
        tMatter.setImportant(null);
        this.saveOrUpdate(tMatter);
    }

    @Override
    public void deleteMatter(TMatter tMatter) {
        //删除UserMatter映射表信息
        Map<String, Object> map = new HashMap<>();
        map.put("matter_id", tMatter.getMatterId());
        tUserMatterMapper.deleteByMap(map);
        //删除提示时间表信息
        tRemindMapper.deleteByMap(map);
        //删除事项
        this.removeById(tMatter.getMatterId());
    }
}
