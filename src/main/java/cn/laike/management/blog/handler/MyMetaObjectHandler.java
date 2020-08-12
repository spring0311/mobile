package cn.laike.management.blog.handler;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("start insert fill ....");
		this.setFieldValByName("createTime", new Date(), metaObject); // 起始版本 3.3.0(推荐使用)
		this.setFieldValByName("modifyTime", new Date(), metaObject); // 起始版本 3.3.0(推荐使用)


	}

	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("start update fill ....");
		this.setFieldValByName("modifyTime", new Date(), metaObject); // 起始版本 3.3.0(推荐使用)
	}

}
