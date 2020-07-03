package cn.coget.apps.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * APP 列表 vo
 *
 * author: sin
 * time: 2020/7/3 11:51 下午
 */
@Data
@Accessors(chain = true)
public class AppPublishListVO {

    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("app编号")
    private Long appId;

    @ApiModelProperty("包大小（MB单位）如：12.03MB")
    private Double packageSize;

    @ApiModelProperty("安装包地址")
    private String packageAddress;

    @ApiModelProperty("版本")
    private String version;

    //
    // 主题和描述，是一组内容

    @ApiModelProperty("主题")
    private String subject;

    @ApiModelProperty("描述")
    private String describe;

    @ApiModelProperty("关系时间")
    private Date updatedTime;

    @ApiModelProperty("创建时间")
    private Date createdTime;
}
