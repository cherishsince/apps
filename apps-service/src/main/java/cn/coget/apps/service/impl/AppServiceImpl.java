package cn.coget.apps.service.impl;

import cn.coget.apps.controller.AppPublishListRequest;
import cn.coget.apps.convert.AppServiceConvert;
import cn.coget.apps.dao.AppDao;
import cn.coget.apps.dao.AppPublishDao;
import cn.coget.apps.dataobject.AppDO;
import cn.coget.apps.dataobject.AppPublishDO;
import cn.coget.apps.service.AppService;
import cn.coget.apps.supper.PageResult;
import cn.coget.apps.supper.ServiceException;
import cn.coget.apps.vo.AppList2VO;
import cn.coget.apps.vo.AppListVO;
import cn.coget.apps.vo.AppPublishListVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * APP service impl
 * <p>
 * author: sin
 * time: 2020/7/3 11:51 下午
 */
@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppDao appDao;
    @Autowired
    private AppPublishDao appPublishDao;

    public List<AppListVO> getRootApps() {
        List<AppDO> rootApps = appDao.selectRootApps();
        return AppServiceConvert.INSTANCE.convertToAppListVO(rootApps);
    }

    public List<AppList2VO> getChildApps(Integer parentId) {
        // 检查是否有 child app
        List<AppDO> childApps = appDao.selectChildApps(parentId);
        if (CollectionUtils.isEmpty(childApps)) {
            return Collections.emptyList();
        }
        // 查询最后 publish 记录，然后转换成 map
        List<Integer> publishIds = childApps.stream()
                .filter(item -> item.getLastAppPublishId() != null)
                .map(AppDO::getLastAppPublishId)
                .collect(Collectors.toList());
        Map<Integer, AppPublishDO> publishMap = Collections.emptyMap();
        // 可能都是 root 级别的 app
        if (!CollectionUtils.isEmpty(publishIds)) {
            List<AppPublishDO> publishList = appPublishDao.selectBatchIds(publishIds);
            publishMap = publishList.stream().collect(Collectors.toMap(AppPublishDO::getId, o -> o));
        }
        // 转换vo
        List<AppList2VO> result = new ArrayList<>(childApps.size());
        for (AppDO childApp : childApps) {
            // 转换 vo
            AppList2VO appList2 = AppServiceConvert.INSTANCE.convertToAppList2VO(childApp);
            // 设置最后 publish 信息
            if (publishMap.containsKey(childApp.getLastAppPublishId())) {
                AppPublishDO appPublishDO = publishMap.get(childApp.getLastAppPublishId());
                AppList2VO.Publish publish = AppServiceConvert.INSTANCE.convertToAppList2VOPublish(appPublishDO);
                appList2.setPublish(publish);
            }
            // 添加到 result
            result.add(appList2);
        }
        return result;
    }

    @Override
    public PageResult<AppPublishListVO> publishList(AppPublishListRequest request) {
        AppDO appDO = appDao.selectById(request.getAppId());
        if (appDO == null) {
            throw new ServiceException("无效的appId!");
        }
        // 分页查询
        IPage<AppPublishDO> page = appPublishDao.selectPage(
                new Page<AppPublishDO>().setPages(request.getPageNo()).setSize(request.getPageSize()),
                new LambdaQueryWrapper<AppPublishDO>().eq(AppPublishDO::getAppId, request.getAppId())
        );
        // 转换 vo 返回
        List<AppPublishListVO> result = new ArrayList<>(page.getRecords().size());
        for (AppPublishDO record : page.getRecords()) {
            AppPublishListVO vo = new AppPublishListVO();
            BeanUtils.copyProperties(appDO, vo);
            AppPublishListVO.Publish publish = AppServiceConvert.INSTANCE.convertToAppPublishListVOPublish(record);
            vo.setPublish(publish);
            result.add(vo);
        }
        return new PageResult<AppPublishListVO>().setList(result).setTotal(page.getTotal());
    }
}
