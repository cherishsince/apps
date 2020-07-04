package cn.coget.apps.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * APP 列表 vo
 *
 * author: sin
 * time: 2020/7/3 11:51 下午
 */
@Data
@Accessors(chain = true)
public class AppListVO {

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
}
