package cn.coget.apps.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * APP 发布
 *
 * 说明：记录发布的版本记录
 *
 * author: sin
 * time: 2020/7/3 11:37 下午
 */
@Data
@Accessors(chain = true)
@TableName("app_publish")
public class AppPublishDO extends BaseDO {

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * app编号
     */
    private Integer appId;
    /**
     * 包大小（MB单位）如：12.03MB
     */
    private Double packageSize;
    /**
     * 安装包地址
     */
    private String packageAddress;
    /**
     * 版本
     */
    private String version;

    //
    // 主题和描述，是一组内容

    /**
     * 主题
     */
    private String subject;
    /**
     * 更新信息
     */
    private String updateInformation;
}
