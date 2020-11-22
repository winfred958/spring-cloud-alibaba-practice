package com.winfred.item.rest;

import com.winfred.item.api.ItemInfoApi;
import com.winfred.item.entity.ItemInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemInfoRest implements ItemInfoApi {

  @Override
  public ItemInfo getItemList(@PathVariable(value = "item_sn") String itemSn) {
    return null;
  }
}
