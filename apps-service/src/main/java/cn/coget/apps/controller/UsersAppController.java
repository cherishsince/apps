package cn.coget.apps.controller;

import cn.coget.apps.service.AppService;
import cn.coget.apps.supper.CommonResult;
import cn.coget.apps.supper.PageResult;
import cn.coget.apps.vo.AppList2VO;
import cn.coget.apps.vo.AppListVO;
import cn.coget.apps.vo.AppPublishListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * APP(用户API)
 *
 * author: sin
 * time: 2020/7/3 11:46 下午
 */
@RestController
@Api(tags = "APP(用户API)")
@RequestMapping("/users")
public class UsersAppController {

    @Autowired
    private AppService appService;

    @GetMapping("/app/apps")
    @ApiOperation("APP列表(全部返回)")
    public CommonResult<List<AppListVO>> appList() {
        return CommonResult.success(appService.getRootApps());
    }

    @GetMapping("/app/apps2")
    @ApiOperation("APP分类(全部返回)")
    public CommonResult<List<AppList2VO>> appList2(@RequestParam("parentId") Integer parentId) {
        return CommonResult.success(appService.getChildApps(parentId));
    }

    @PostMapping("/app/publishList")
    @ApiOperation("发布详细")
    public CommonResult<PageResult<AppPublishListVO>> publishList(@RequestBody AppPublishListRequest request) {
        return CommonResult.success(appService.publishList(request));
    }
}
