package cn.coget.apps.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * APP 列表 vo
 *
 * author: sin
 * time: 2020/7/3 11:51 下午
 */
@Data
@Accessors(chain = true)
public class AppList2VO implements Serializable {

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("父类id")
    private Integer parentId;

    @ApiModelProperty("app 名字")
    private String name;

    @ApiModelProperty("logo 地址")
    private String logo;

    @ApiModelProperty("app 类型：Android、iOS")
    private String tags;

    @ApiModelProperty("发布信息")
    private Publish publish;

    //
    // publish 信息

    @Data
    @Accessors(chain = true)
    public static class Publish implements Serializable{

        @ApiModelProperty("包大小（MB单位）如：12.03MB")
        private Double packageSize;

        @ApiModelProperty("安装包地址")
        private String packageAddress;

        @ApiModelProperty("版本")
        private String version;

        @ApiModelProperty("主题")
        private String subject;

        @ApiModelProperty("描述")
        private String updateInformation;

        @ApiModelProperty("创建时间")
        private Date createdTime;
    }
}
