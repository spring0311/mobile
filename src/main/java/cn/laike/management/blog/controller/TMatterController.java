package cn.laike.management.blog.controller;


import cn.laike.management.blog.entity.TMatter;
import cn.laike.management.blog.service.TMatterService;
import cn.laike.management.blog.service.TUserMatterService;
import cn.laike.management.blog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * Matter控制器
 * </p>
 * * 整个MatterController不能修改Remind表的数据
 * * Remind相关要到RemindController操作
 *
 * @author weizihao
 * @since 2020-07-23
 */
@Controller
@RestController
@RequestMapping("matter")
@CrossOrigin
public class TMatterController extends BaseController {


    @Autowired
    private TMatterService tMatterService;

    @Autowired
    private TUserMatterService tUserMatterService;


    //http://192.168.56.1:8080/matter/list?userId=1&isOpen=0&finish=0&sign=1&order
    @GetMapping("list")
    public JsonResult<List<TMatter>> matterList(TMatter tMatter, HttpSession session) {
        tMatter.setUserId(getUidFromSessions(tMatter.getUserId()));
        //list查询对象是  正在进行以及未完成的
        // tMatter.setUserId(1l);
        tMatter.setIsPatriarch(0);
        //判断是否完成
        if (tMatter.getFinish() == null) {
            tMatter.setFinish(0);
        }
        tMatter.setIsOpen(0);
        System.err.println("list!!!!!!!!:" + tMatter);
        List<TMatter> list = tMatterService.findMatters(tMatter);
        return new JsonResult<>(OK, list);
    }

    //http://192.168.56.1:8080/matter/add?matterName=测试&matterText=修改测试&important=1&urgent=1
    @GetMapping("add")
    public JsonResult<Void> addMatter(TMatter tMatter, HttpSession session) throws ParseException {
        tMatter.setUserId(getUidFromSessions(tMatter.getUserId()));
        // tMatter.setUserId(1L);
        tMatter.setIsPatriarch(0);
        tMatter.setDeptId(0l);
        tMatterService.createMatter(tMatter);
        return new JsonResult<>(OK);
    }

    //http://localhost:8080/matter/matter?matterId=14&deptId=1&urgent=1
    @GetMapping("matter")
    public JsonResult<TMatter> matterJsonResult(TMatter tMatter) {
        //返回的matter里只有提醒时间的ID 没有提醒时间对象
        return new JsonResult<>(OK, tMatterService.findMatters(tMatter).get(0));
    }

    /**
     * 前端需判断 用户是否可以修改Matter的信息
     *
     * @param tMatter
     * @return
     */
    //http://localhost:8080/matter/update?matterId=14&matterName=测试&matterContent=修改测试&importantOne=1&urgentOne=1&sign=1
    @GetMapping("update")
    public JsonResult<Void> updateMatter(TMatter tMatter, HttpSession session) {
        tMatter.setUserId(getUidFromSessions(tMatter.getUserId()));
        tMatterService.updateMatter(tMatter);
        return new JsonResult<>(OK);
    }

    /**
     * 前端需判断 用户是否可以修改Matter的信息
     *
     * @param tMatter
     * @return
     */
    @GetMapping("updates")
    public JsonResult<Void> updateMatters(TMatter tMatter, HttpSession session) {
        tMatter.setUserId(getUidFromSessions(tMatter.getUserId()));
        tMatterService.updateMatters(tMatter);
        return new JsonResult<>(OK);
    }

    /**
     * 前端需判断 用户删除的事项 是否是个人事项 deptId为null
     *
     * @param tMatter
     * @return
     */
    //http://localhost:8080/matter/delete?matterId=60&deptId=1&urgent=0
    @GetMapping("delete")
    public JsonResult<Void> deleteMatter(TMatter tMatter) {
        tMatterService.deleteMatter(tMatter);
        return new JsonResult<>(OK);
    }

}

