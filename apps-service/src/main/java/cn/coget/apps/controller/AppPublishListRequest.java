package cn.coget.apps.controller;

import cn.coget.apps.supper.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * app 发布请求
 *
 * author: sin
 * time: 2020/7/4 12:02 上午
 */
@Data
@Accessors(chain = true)
public class AppPublishListRequest extends PageParam {

    @ApiModelProperty("app编号")
    private Integer appId;
}
