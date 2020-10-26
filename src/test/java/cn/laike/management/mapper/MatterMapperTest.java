package cn.laike.management.mapper;

import cn.laike.management.blog.entity.TMatter;
import cn.laike.management.blog.entity.TRemind;
import cn.laike.management.blog.entity.TUser;
import cn.laike.management.blog.mapper.TMatterMapper;
import cn.laike.management.blog.mapper.TRemindMapper;
import cn.laike.management.blog.mapper.TUserMapper;
import cn.laike.management.blog.mapper.TUserMatterMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class MatterMapperTest {

    @Autowired
    private TMatterMapper tMatterMapper;

    @Test
    void insertTest() {
        TMatter tMatter = new TMatter();
        tMatter.setCreateTime(new Date());
        tMatter.setMatterName("测试插入");
        tMatter.setMatterText("ceshiwenben");
        tMatterMapper.insert(tMatter);
        System.out.println("结束");
    }

    @Test
    void findMattersTest() {
        TMatter tMatter = new TMatter();
        Long userId = 1l;
        tMatter.setFinish(0);
        tMatter.setUserId(userId);
        tMatter.setIsOpen(0);
        System.err.println(tMatter);
        List<TMatter> tMatters = tMatterMapper.selectMattersByMatter(tMatter);
        for (TMatter t : tMatters
        ) {
            System.err.println(t);
        }
    }

    @Test
    void findMatterNameTest() {
        TMatter tMatter = new TMatter();
        tMatter.setMatterId(14L);
        System.err.println(tMatter);
        String matterName = tMatterMapper.selectMatterName(tMatter);
        System.err.println(matterName);
    }

    @Autowired
    private TUserMatterMapper tUserMatterMapper;

    @Test
    public void selectMatterIds() {
        List<Long> matterIds = tUserMatterMapper.selectMatterIds(1L);
        matterIds.forEach(matterId -> {
            System.err.println(matterId);
        });
    }

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private TRemindMapper tRemindMapper;

    @Test
    public void testOracle() {
        TRemind test = new TRemind();
        test.setMatterId(14l);
        List<TRemind> tReminds = tRemindMapper.testSelect(test);
        tReminds.forEach(tRemind -> System.err.println(tRemind));
    }


}
