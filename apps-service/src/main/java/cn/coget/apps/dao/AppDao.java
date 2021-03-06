package cn.coget.apps.dao;

import cn.coget.apps.dataobject.AppDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * App Dao
 * <p>
 * author: sin
 * time: 2020/7/3 11:54 下午
 */
@Repository
@Mapper
public interface AppDao extends BaseMapper<AppDO> {

    default List<AppDO> selectRootApps() {
        return this.selectList(
                new LambdaQueryWrapper<AppDO>()
                        .isNull(AppDO::getParentId)
                        .orderByAsc(AppDO::getSort)
        );
    }

    default List<AppDO> selectChildApps(Integer parentId) {
        return this.selectList(
                new LambdaQueryWrapper<AppDO>()
                        .eq(AppDO::getParentId, parentId)
                        .orderByAsc(AppDO::getSort)
        );
    }
}
