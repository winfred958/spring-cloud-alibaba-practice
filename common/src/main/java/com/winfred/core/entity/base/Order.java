package com.winfred.core.entity.base;

import lombok.Getter;
import lombok.Setter;

public class Order {

  public static final String ASC = "ASC";
  public static final String DESC = "DESC";

  /**
   * 排序列
   */
  @Getter
  @Setter
  private String column;
  /**
   * 排序规则
   */
  @Setter
  private String rule;

  public Order() {
  }

  public Order(String column, String rule) {
    super();
    this.column = column;
    this.rule = rule;
  }

  public String getRule() {
    if (null == this.column) {
      // 共存
      this.rule = null;
      return rule;
    }
    if (null == this.rule) {
      this.rule = ASC;
      return rule;
    }
    if (this.rule.trim().equalsIgnoreCase(DESC)) {
      this.rule = DESC;
    } else {
      this.rule = ASC;
    }
    return rule;
  }
}
