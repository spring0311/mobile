package cn.laike.management.blog.controller;


import cn.laike.management.blog.entity.TRemind;
import cn.laike.management.blog.service.TRemindService;
import cn.laike.management.blog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author weiZiHao
 * @since 2020-08-01
 */
@RestController
@RequestMapping("remind")
public class TRemindController extends BaseController {

    @Autowired
    private TRemindService tRemindService;


    @GetMapping("taday")
    public JsonResult<List<TRemind>> getTReminds(HttpSession session) throws ParseException {
        return new JsonResult<>(OK, tRemindService.findByDate(getUidFromSession(session)));
    }

    //http://localhost:8080/remind/list
    @GetMapping("list")
    public JsonResult<List<TRemind>> getAllTReminds(HttpSession session) {
        return new JsonResult<>(OK, tRemindService.findAllTReminds(getUidFromSession(session)));
    }

    @GetMapping("remind/{remindId}")
    public JsonResult<List<TRemind>> getTRemindForMatter(@PathVariable("remindId") String remindId) {
        return new JsonResult<>(OK, tRemindService.findRemindForMatter(remindId));
    }

    //http://localhost:8080/remind/add?
    @GetMapping("add")
    public JsonResult<Void> addRemind(TRemind tRemind) {
        tRemindService.addRemind(tRemind);
        return new JsonResult<>(OK);
    }

    @GetMapping("delete/{remindId}")
    public JsonResult<Void> delByRemindId(@PathVariable("remindId") Long remindId) {
        tRemindService.delByRemindId(remindId);
        return new JsonResult<>(OK);
    }
}

