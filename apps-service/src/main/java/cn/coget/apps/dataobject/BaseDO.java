package cn.coget.apps.dataobject;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * base supper
 *
 * author: sin
 * time: 2020/7/3 11:25 下午
 */
@Data
@Accessors(chain = true)
public class BaseDO implements Serializable {

    /**
     * 关系时间
     */
    private Date updatedTime;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 删除 0、正常 1、删除
     */
    @TableLogic
    private Integer deleted;
}
