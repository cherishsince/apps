package cn.coget.apps.service.impl;

import cn.coget.apps.controller.AppPublishListRequest;
import cn.coget.apps.convert.AppServiceConvert;
import cn.coget.apps.dao.AppDao;
import cn.coget.apps.dao.AppPublishDao;
import cn.coget.apps.dataobject.AppDO;
import cn.coget.apps.dataobject.AppPublishDO;
import cn.coget.apps.service.AppService;
import cn.coget.apps.vo.supper.PageResult;
import cn.coget.apps.vo.AppListVO;
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

    @Override
    public List<AppListVO> appList() {
        List<AppDO> all = appDao.selectAll();
        return AppServiceConvert.INSTANCE.convertToAppListVO(all);
    }

    @Override
    public List<AppListVO> appList2() {
        return null;
    }

    @Override
    public PageResult<AppListVO> appPublishList(AppPublishListRequest request) {
        IPage<AppPublishDO> page = appPublishDao.selectPage(
                new Page<AppPublishDO>().setPages(request.getPageNo()).setSize(request.getPageSize()),
                new LambdaQueryWrapper<>()
        );
        List<AppListVO> appListVOList = AppServiceConvert.INSTANCE.convertToPublishListVO(page.getRecords());
        return new PageResult<>().setList(appListVOList).setTotal(page.getTotal());
    }
}
