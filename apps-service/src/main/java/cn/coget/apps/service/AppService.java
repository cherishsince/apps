package cn.coget.apps.service;

import cn.coget.apps.controller.AppPublishListRequest;
import cn.coget.apps.supper.PageResult;
import cn.coget.apps.vo.AppListVO;
import cn.coget.apps.vo.AppPublishListVO;

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
    List<AppListVO> getRootApps();

    List<AppListVO> getChildApps(Long parentId);

    /**
     * app发布 - 列表
     *
     * @param request
     * @return
     */
    PageResult<AppPublishListVO> appPublishList(AppPublishListRequest request);
}
