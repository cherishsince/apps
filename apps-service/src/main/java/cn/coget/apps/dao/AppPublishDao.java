package cn.coget.apps.dao;

import cn.coget.apps.dataobject.AppPublishDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * App Publish Dao
 *
 * author: sin
 * time: 2020/7/3 11:54 下午
 */
@Repository
@Mapper
public interface AppPublishDao extends BaseMapper<AppPublishDO> {

}
