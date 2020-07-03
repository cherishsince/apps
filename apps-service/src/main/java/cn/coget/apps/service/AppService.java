package cn.coget.apps.service;

import cn.coget.apps.controller.AppPublishListRequest;
import cn.coget.apps.supper.PageResult;
import cn.coget.apps.vo.AppListVO;

import java.util.List;

/**
 * APP service
 *
 * author: sin
 * time: 2020/7/3 11:50 下午
 */
public interface AppService {

    /**
     * app - 列表
     *
     * @return
     */
    List<AppListVO> appList();

    List<AppListVO> appList2();

    /**
     * app发布 - 列表
     *
     * @param request
     * @return
     */
    PageResult<AppListVO> appPublishList(AppPublishListRequest request);
}
