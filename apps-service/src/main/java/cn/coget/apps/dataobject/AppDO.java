package cn.coget.apps.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 程序
 *
 * parentId-用于区分类别，如：生产版、测试版、预览版、渠道版
 *
 * author: sin
 * time: 2020/7/3 11:24 下午
 */
@Data
@Accessors(chain = true)
@TableName("app")
public class AppDO extends BaseDO {

    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 父类id
     */
    private Long parentId;
    /**
     * app 名字
     */
    private String name;
    /**
     * logo 地址
     */
    private String logo;
    /**
     * app 类型：Android、iOS、Windows
     *
     * 注意：root 级别的，这里保存的是这个 app 所有的 terminal
     */
    private String tags;
    /**
     * 描述
     */
    private String memo;
}
