package cn.laike.management.blog.util;

/**
 * 用于封装响应客户端的JSON数据的属性的类
 * @author Sun
 *
 * @param <T>
 */
public class JsonResult<T> {

	private String state;//响应状态 
	private String message;//操作失败时的提示信息
	private  T data;//操作成功时候响应客户端的数据
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public JsonResult() {
		super();
	}
	public JsonResult(Throwable e) {
		super();
		this.message = e.getMessage();
	}
	public JsonResult(String state, T data) {
		super();
		this.state = state;
		this.data = data;
	}
	public JsonResult(String state) {
		super();
		this.state = state;
	}
	
	
	
}
