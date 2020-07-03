package cn.coget.apps.vo.supper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel("分页结果")
public final class PageResult<T> implements Serializable {

    @ApiModelProperty(value = "数据", required = true)
    private List<T> list;

    @ApiModelProperty(value = "总量", required = true)
    private Integer total;

    public List<T> getList() {
        return list;
    }

    public PageResult<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public PageResult<T> setTotal(Integer total) {
        this.total = total;
        return this;
    }

}
