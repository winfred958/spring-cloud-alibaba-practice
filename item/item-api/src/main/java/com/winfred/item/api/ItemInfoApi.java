package com.winfred.item.api;

import com.winfred.item.entity.ItemInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/info")
public interface ItemInfoApi {

  @RequestMapping(value = "/{item_sn}")
  ItemInfo getItemList(@PathVariable(value = "item_sn") String itemSn);
}
