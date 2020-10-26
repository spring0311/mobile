package cn.laike.management.blog.controller;


import cn.laike.management.blog.entity.TUser;
import cn.laike.management.blog.service.TUserService;
import cn.laike.management.blog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author weizihao
 * @since 2020-07-23
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class TUserController extends BaseController {

    @Autowired
    private TUserService tUserService;


    // http://localhost:8080/user/login?username=MrBird&password=1234qwer
    @RequestMapping("login")
    public JsonResult<TUser> login(TUser tUser, HttpSession session) {
        TUser user = tUserService.login(tUser);
        session.setAttribute("user", user);
        return new JsonResult<>(OK, user);
    }


}

