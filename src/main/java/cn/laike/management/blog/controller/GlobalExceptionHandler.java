package cn.laike.management.blog.controller;


import cn.laike.management.blog.service.ex.ServiceException;
import cn.laike.management.blog.service.ex.UserNotFoundException;
import cn.laike.management.blog.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//可以加参数@ExceptionHandler(参数) 参数为出现某种异常才会执行,用于规定异常范围
    @ExceptionHandler(ServiceException.class)
	public JsonResult<Void> handleException(Throwable e) {

		JsonResult<Void> jsonResult=new JsonResult<>(e);

		if (e instanceof UserNotFoundException){
			jsonResult.setState("4000");
		}else if(e instanceof UserNotFoundException){
			jsonResult.setState("4001");
		}


		return jsonResult;
	}

}
