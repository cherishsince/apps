package cn.coget.apps.service.impl;

import cn.coget.apps.controller.AppPublishListRequest;
import cn.coget.apps.convert.AppServiceConvert;
import cn.coget.apps.dao.AppDao;
import cn.coget.apps.dao.AppPublishDao;
import cn.coget.apps.dataobject.AppDO;
import cn.coget.apps.dataobject.AppPublishDO;
import cn.coget.apps.service.AppService;
import cn.coget.apps.supper.PageResult;
import cn.coget.apps.vo.AppListVO;
import cn.coget.apps.vo.AppPublishListVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<AppListVO> getChildApps(Long parentId) {
        // TODO: 2020/7/4 需要修改
        List<AppDO> childApps = appDao.selectChildApps(parentId);
        return AppServiceConvert.INSTANCE.convertToAppListVO(childApps);
    }

    @Override
    public PageResult<AppPublishListVO> appPublishList(AppPublishListRequest request) {
        // 分页查询
        IPage<AppPublishDO> page = appPublishDao.selectPage(
                new Page<AppPublishDO>().setPages(request.getPageNo()).setSize(request.getPageSize()),
                new LambdaQueryWrapper<>()
        );
        // 转换 vo 返回
        List<AppPublishListVO> appPublishVOList = AppServiceConvert.INSTANCE.convertToPublishListVO(page.getRecords());
        return new PageResult<AppPublishListVO>().setList(appPublishVOList).setTotal(page.getTotal());
    }
}
