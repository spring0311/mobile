package cn.laike.management.service;

import cn.laike.management.blog.entity.TMatter;
import cn.laike.management.blog.entity.TUser;
import cn.laike.management.blog.mapper.TMatterMapper;
import cn.laike.management.blog.service.TMatterService;
import cn.laike.management.blog.service.TUserService;
import cn.laike.management.blog.service.ex.ServiceException;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


@SpringBootTest
public class TUserServiceTest {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TMatterService matterService;

    //maID28  1 1 1
    @Test
    public void updateMatter() {
        TMatter tMatter = new TMatter();
        tMatter.setUserId(1L);
        System.err.println(tMatter);
        List<TMatter> tMatters = matterService.findMatters(tMatter);
        tMatters.forEach(tMatter1 -> System.err.println(tMatter1));
    }

    @Test
    public void loginTest() {

        try {
            TUser tUser = new TUser();
            tUser.setPassword("1234qwer");
            tUser.setUsername("MrBird");
            TUser user = tUserService.login(tUser);

            System.err.println("\t测试完成：" + user);
        } catch (ServiceException e) {
            System.err.println(e.getClass());
            System.err.println(e.getMessage());
        }


    }


}
