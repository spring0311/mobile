package cn.laike.management.blog.service.impl;

import cn.laike.management.blog.entity.TMatter;
import cn.laike.management.blog.entity.TRemind;
import cn.laike.management.blog.entity.TUserMatter;
import cn.laike.management.blog.mapper.TMatterMapper;
import cn.laike.management.blog.mapper.TRemindMapper;
import cn.laike.management.blog.mapper.TUserMatterMapper;
import cn.laike.management.blog.service.TRemindService;
import cn.laike.management.blog.service.ex.UserNotFoundException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author weiZiHao
 * @since 2020-08-01
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TRemindServiceImpl extends ServiceImpl<TRemindMapper, TRemind> implements TRemindService {

    @Autowired
    private TRemindMapper tRemindMapper;

    @Autowired
    private TMatterMapper tMatterMapper;

    @Autowired
    private TUserMatterMapper tUserMatterMapper;

    @Override
    public List<TRemind> findByDate(Long userId) throws ParseException {


        return null;
    }

    /**
     * 查询单个用户的所有remind
     *
     * @param userId
     * @return
     */
    @Override
    public List<TRemind> findAllTReminds(Long userId) {
        //通过用户Id先行获取MatterId UserMatter映射表
        //获得的Matter是开启状态的 mapper.xml中写死的
        List<Long> matterIds = tUserMatterMapper.selectMatterIds(userId);
        //声明TRemind的集合 得到所有Matter对象的对应Remind
        List<TRemind> tReminds = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        for (Long matterId : matterIds
        ) {
            map.clear();
            map.put("MATTER_ID", matterId);
            map.put("MATTER_ID", matterId);
            List<TRemind> list = tRemindMapper.selectByMap(map);
            tReminds.addAll(list);
        }
        //Remind 注入 Matter
        for (TRemind t : tReminds
        ) {
            TMatter tMatter = new TMatter();
            tMatter.setMatterId(t.getMatterId());
            tMatter.setIsOpen(0);
            // tMatter = tMatterMapper.selectMattersByMatter(tMatter).get(0);
            List<TMatter> tmatter = tMatterMapper.selectMattersByMatter(tMatter);
            if (tmatter.size() <= 0) {
                tMatter = new TMatter();
            } else {
                tMatter = tMatterMapper.selectMattersByMatter(tMatter).get(0);
            }
            t.setTMatter(tMatter);
        }
        return tReminds;
    }

    @Override
    public List<TRemind> getByremindtime(TRemind tRemindy) throws ParseException {
        List<TRemind> tReminds = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        List<Long> matterIds = tUserMatterMapper.selectMatterIds(tRemindy.getUserId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        TRemind tRemind = new TRemind();
        tRemind.setRemindTime(simpleDateFormat.parse(tRemindy.getRemindTimestr()));
        for (Long matterId : matterIds
        ) {
            //  map.clear();
            map.put("matter_id", matterId);
            map.put("REMIND_TIME", tRemind.getRemindTime());
            List<TRemind> list = tRemindMapper.selectByMap(map);
            tReminds.addAll(list);
        }
        //  map.put("REMIND_TIME", tRemind.getRemindTime());
        //   List<TRemind> list = tRemindMapper.selectByMap(map);
        //   tReminds.addAll(list);
        for (TRemind t : tReminds
        ) {
            TMatter tMatter = new TMatter();
            tMatter.setMatterId(t.getMatterId());
            tMatter.setIsOpen(0);
            List<TMatter> tmatter = tMatterMapper.selectMattersByMatter(tMatter);
            if (tmatter.size() <= 0) {
                tMatter = new TMatter();
            } else {
                tMatter = tMatterMapper.selectMattersByMatter(tMatter).get(0);
            }
            t.setTMatter(tMatter);
        }
        return tReminds;
    }

    @Override
    public void addRemind(TRemind tRemind) throws ParseException {
        QueryWrapper<TRemind> remindQueryWrapper = new QueryWrapper<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        tRemind.setRemindTime(simpleDateFormat.parse(tRemind.getRemindTimestr()));
        remindQueryWrapper.setEntity(tRemind);
        List<TRemind> list = baseMapper.selectList(remindQueryWrapper);
        if (list.size() > 0) {
            throw new UserNotFoundException("提醒时间已存在");
        }
        tRemind.setIsActivate(1);
        tRemind.setUserBy(1);
        tRemindMapper.insert(tRemind);
        QueryWrapper<TUserMatter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("MATTER_ID", tRemind.getMatterId());
        queryWrapper.eq("USER_ID", tRemind.getUserId());
        TUserMatter tUserMatter = new TUserMatter();
        tUserMatter.setIsRemind(1);
        tUserMatterMapper.update(tUserMatter, queryWrapper);
    }

    @Override
    public List<TRemind> findRemindForMatter(String remindId) {
        List<Long> remindIds = getRemindIds(remindId);
        List<TRemind> tReminds = new ArrayList<>();
        TRemind tRemind = new TRemind();
        for (Long id : remindIds
        ) {
            tRemind = tRemindMapper.selectById(id);
            tReminds.add(tRemind);
        }
        return tReminds;
    }

    @Override
    public List<TRemind> getBymatterId(Long matterId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("MATTER_ID", matterId);
        List<TRemind> tRemind = tRemindMapper.selectByMap(map);
        return tRemind;
    }

    @Override
    public void delByRemindId(Long remindId) {
        tRemindMapper.deleteById(remindId);
    }

    /**
     * String转换List
     *
     * @param remindId
     * @return
     */
    private List<Long> getRemindIds(String remindId) {
        List<Long> remindIds = new ArrayList<>();
        String[] strs = remindId.split(",");
        for (String str : strs
        ) {
            Long id = Long.valueOf(str);
            remindIds.add(id);
        }
        return remindIds;
    }

    private Date getDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(date);
        date = simpleDateFormat.parse(string);
        return date;
    }
}
