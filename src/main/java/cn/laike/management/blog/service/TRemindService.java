package cn.laike.management.blog.service;

import cn.laike.management.blog.entity.TRemind;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.awt.*;
import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author weiZiHao
 * @since 2020-08-01
 */
public interface TRemindService extends IService<TRemind> {

    /**
     * 根据日期查询数据 为时间轴提供
     *
     * @param
     * @return
     */
    List<TRemind> findByDate(Long userId) throws ParseException;

    /**
     * 查找用户事项全部提醒时间与事项
     *
     * @return
     */
    List<TRemind> findAllTReminds(Long userId);
    /**
     * 根据提醒时间查询用户的所有信息
     *
     * @return
     * @throws ParseException 
     */
    List<TRemind> getByremindtime(TRemind tRemind) throws ParseException;

    /**
     * 增加
     *
     * @param tRemind
     * @throws ParseException 
     */
    void addRemind(TRemind tRemind) throws ParseException;

    /**
     * 查询单个Matter的Reminds
     *
     * @param remindId 从Matter中拿到的remindId
     * @return
     */
    List<TRemind> findRemindForMatter(String remindId);
    /**
     * 查询单个Matter的Reminds
     *
     * @param remindId 从Matter中拿到的remindId
     * @return
     */
    List<TRemind> getBymatterId(Long matterId);
    /**
     * 根据remind删除
     * @param remindId
     */
    void delByRemindId(Long remindId);

}
