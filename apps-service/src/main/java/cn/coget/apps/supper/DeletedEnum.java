package cn.coget.apps.supper;

import lombok.Getter;

/**
 * {@link BaseDO#getDeleted()} delete 状态
 *
 * @author Sin
 * @time 2019-03-22 21:15
 */
@Getter
public enum DeletedEnum {

    DELETED_NO(0, "正常(未删除)"),
    DELETED_YES(1, "删除");

    private Integer value;
    private String name;

    DeletedEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
