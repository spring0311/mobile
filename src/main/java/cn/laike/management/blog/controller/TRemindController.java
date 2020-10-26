package cn.laike.management.blog.controller;


import cn.laike.management.blog.entity.TRemind;
import cn.laike.management.blog.service.TRemindService;
import cn.laike.management.blog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
public class TRemindController extends BaseController {

    @Autowired
    private TRemindService tRemindService;


    @GetMapping("taday")
    public JsonResult<List<TRemind>> getTReminds(HttpSession session) throws ParseException {
        return new JsonResult<>(OK, tRemindService.findByDate(getUidFromSession(session)));
    }

    //http://localhost:8080/remind/list
    @GetMapping("list")
    public JsonResult<List<TRemind>> getAllTReminds(HttpSession session, TRemind tRemind) {
        return new JsonResult<>(OK, tRemindService.findAllTReminds(tRemind.getUserId()));
    }

    /*
     * 根据提醒时间获取事项
     */
    @GetMapping("getByremindtime")
    public JsonResult<List<TRemind>> getByremindtime(TRemind tRemind) throws ParseException {
        return new JsonResult<>(OK, tRemindService.getByremindtime(tRemind));
    }

    @GetMapping("remind/{remindId}")
    public JsonResult<List<TRemind>> getTRemindForMatter(@PathVariable("remindId") String remindId) {
        return new JsonResult<>(OK, tRemindService.findRemindForMatter(remindId));
    }

    @GetMapping("getBymatterId/{matterId}")
    public JsonResult<List<TRemind>> getTRemindForMatterBymatterId(@PathVariable("matterId") String matterId) {
        Long matterIds = Long.valueOf(0);
        if (!(matterId == null) || !(matterId == "")) {
            matterIds = Long.valueOf(matterId);
        }
        return new JsonResult<>(OK, tRemindService.getBymatterId(matterIds));
    }

    //http://localhost:8080/remind/add?
    @GetMapping("add")
    public JsonResult<Void> addRemind(TRemind tRemind) throws ParseException {
        tRemindService.addRemind(tRemind);
        return new JsonResult<>(OK);
    }

    @GetMapping("delete/{remindId}")
    public JsonResult<Void> delByRemindId(@PathVariable("remindId") String remindId) {
        Long remindIds = Long.valueOf(0);
        if (!(remindId == null) || !(remindId == "")) {
            remindIds = Long.valueOf(remindId);
        }
        tRemindService.delByRemindId(remindIds);
        return new JsonResult<>(OK);
    }
}

