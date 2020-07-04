package cn.coget.apps.convert;

import cn.coget.apps.dataobject.AppDO;
import cn.coget.apps.dataobject.AppPublishDO;
import cn.coget.apps.vo.AppList2VO;
import cn.coget.apps.vo.AppListVO;
import cn.coget.apps.vo.AppPublishListVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * app service convert
 *
 * author: sin
 * time: 2020/7/3 11:58 下午
 */
@Mapper
public interface AppServiceConvert {

    AppServiceConvert INSTANCE = Mappers.getMapper(AppServiceConvert.class);

    List<AppListVO> convertToAppListVO(List<AppDO> appDOList);

    AppList2VO convertToAppList2VO(AppDO appDO);

    AppList2VO.Publish convertToAppList2VOPublish(AppPublishDO appPublish);

    AppPublishListVO.Publish convertToAppPublishListVOPublish(AppPublishDO appPublish);
}
