package com.winfred.item.service.impl;

import com.winfred.item.entity.ItemDescribe;
import com.winfred.item.entity.ItemInfo;
import com.winfred.item.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RefreshScope
public class ItemServiceImpl implements ItemService {

  @Value(value = "${demon.item.item_sn:xxx}")
  private String testValue;

  @Override
  public ItemInfo getItem(String itemSn) {
    ItemInfo itemInfo = new ItemInfo();
    itemInfo.setItem_sn(testValue);
    ItemDescribe itemDescribe = new ItemDescribe();
    itemDescribe.setItem_describe("xxxxxxxxxxxxxxxxxxxxxxxxx");
    itemInfo.setDescribe(itemDescribe);
    return itemInfo;
  }
}
