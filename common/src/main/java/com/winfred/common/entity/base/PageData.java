package com.winfred.common.entity.base;

import java.util.List;


public class PageData {
    /**
     * 当前页
     */
    private Integer page;
    /**
     * 当前页面显示数
     */
    private Integer size;
    /**
     * 总页数
     */
    private Integer total_page;
    /**
     * 数据总数
     */
    private Integer total;
    private List<Object> list;

    @Deprecated
    public PageData(Integer page, Integer size, Integer total_size, List<Object> list) {
        this.page = page;
        this.size = size;
        this.total = total_size;
        this.list = list;
    }

    public PageData(Integer size, Integer total_size, List<Object> list) {
        this.size = size;
        this.total = total_size;
        this.list = list;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal_page() {
        if (this.total % this.size == 0) {
            this.total_page = this.total / this.size;
        } else {
            this.total_page = this.total / this.size + 1;
        }
        return total_page;
    }

    public void setTotal_page(Integer total_page) {
        this.total_page = total_page;
    }

    public Integer getTotal_size() {
        return total;
    }

    public void setTotal_size(Integer total_size) {
        this.total = total_size;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }


}
