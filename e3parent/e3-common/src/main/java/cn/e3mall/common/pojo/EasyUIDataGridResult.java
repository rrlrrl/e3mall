package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2018/1/16.
 */
public class EasyUIDataGridResult implements Serializable{

    private long total;
    private List rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
