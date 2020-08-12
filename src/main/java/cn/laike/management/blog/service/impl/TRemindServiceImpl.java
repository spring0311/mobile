package cn.laike.management.blog.service.impl;

import cn.laike.management.blog.entity.TMatter;
import cn.laike.management.blog.entity.TRemind;
import cn.laike.management.blog.mapper.TMatterMapper;
import cn.laike.management.blog.mapper.TRemindMapper;
import cn.laike.management.blog.mapper.TUserMatterMapper;
import cn.laike.management.blog.service.TRemindService;
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
            map.put("matter_id", matterId);
            List<TRemind> list = tRemindMapper.selectByMap(map);
            tReminds.addAll(list);
        }
        //Remind 注入 Matter
        TMatter tMatter = new TMatter();
        for (TRemind t : tReminds
        ) {
            tMatter = tMatterMapper.selectById(t.getMatterId());
            t.setTMatter(tMatter);
        }
        return tReminds;
    }

    @Override
    public void addRemind(TRemind tRemind) {
        tRemindMapper.insert(tRemind);
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
