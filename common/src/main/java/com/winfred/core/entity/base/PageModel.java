package com.winfred.core.entity.base;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * 分页模型
 *
 * @author kevin
 */
public class PageModel implements CleanerBean {

  /**
   * 总数
   */
  @Getter
  @Setter
  private int total;

  /**
   * 分页集合列表
   */
  @Setter
  private List list = new ArrayList();

  /**
   * 页数
   */
  @Setter
  private Integer page;

  /**
   * 偏移量
   */
  @Getter
  @Setter
  private Integer offset;

  /**
   * 页大小
   */
  @Setter
  private Integer size;

  /**
   * 分页标签需要访问的ACTION地址
   */
  @Getter
  @Setter
  protected String pagerUrl;

  @Getter
  @Setter
  private String id;

  @Getter
  @Setter
  private int recordsTotal;

  @Getter
  @Setter
  private int recordsFiltered;

  @Getter
  @Setter
  private int draw;

  @Override
  public void clean() {
    this.total = 0;
    this.list = null;

  }

  public Integer getPage() {
    if (null == this.page || this.page.compareTo(0) < 0) {
      this.page = DefaultValue.DEFAULT_PAGE_PAGE;
    }
    return page;
  }

  public Integer getSize() {
    if (null == this.size || this.size.compareTo(0) < 0) {
      this.size = DefaultValue.DEFAULT_PAGE_SIZE;
    }
    return size;
  }
}
