package cn.coget.apps.controller;

import cn.coget.apps.vo.supper.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * APP(用户API)
 *
 * author: sin
 * time: 2020/7/3 11:46 下午
 */
@RestController
@Api(tags = "APP(用户API)")
public class UsersAppController {

    @GetMapping("app-list")
    @ApiOperation("APP列表(全部返回)")
    public CommonResult<?> appList() {
        return CommonResult.success(null);
    }
}
