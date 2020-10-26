package cn.laike.management.service;

import cn.laike.management.blog.entity.TMatter;
import cn.laike.management.blog.entity.TRemind;
import cn.laike.management.blog.service.TMatterService;
import cn.laike.management.blog.service.TRemindService;
import cn.laike.management.blog.service.TUserMatterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TUserTMatterServiceTest {

    @Autowired
    TUserMatterService tUserMatterService;

    @Autowired
    private TMatterService tMatterService;

    /**
     * TUserMatter tUserMatter = new TUserMatter();
     * tUserMatter.setUrgentOne(tMatter.getUrgentOne());
     * tUserMatter.setImportantOne(tMatter.getImportantOne());
     * tUserMatter.setUserId(tMatter.getUserId());
     * tUserMatter.setFinish(0);
     * tMatter.setDeptId(null);
     * tMatterMapper.insert(tMatter);
     * TMatter matter = tMatterMapper.findMattersByMatter(tMatter).get(0);
     * tUserMatter.setMatterId(matter.getMatterId());
     * tUserMatterMapper.insert(tUserMatter);
     */
    @Test
    public void name() throws ParseException {
        TMatter tMatter = new TMatter();
        tMatter.setMatterName("测试插入");
        tMatter.setCreateTime(new Date());
        tMatter.setEnd(new Date());
        tMatter.setMatterOpen(new Date());
        tMatter.setIsOpen(0);
        tMatter.setIsOpen(0);
        tMatter.setUrgentOne(1);
        tMatter.setImportantOne(0);
        tMatter.setUserId(1L);
        System.err.println("tMatter:" + tMatter);
        tMatterService.createMatter(tMatter);
        System.out.println("结束");
    }

    @Autowired
    private TRemindService tRemindService;

    @Test
    public void addRemind() throws ParseException {
        TRemind remind = new TRemind();
        remind.setMatterId(49L);
        remind.setRemindTime(new Date());
        tRemindService.addRemind(remind);
        System.err.println("over");
    }


}
