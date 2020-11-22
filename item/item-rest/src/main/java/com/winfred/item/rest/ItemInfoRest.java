package com.winfred.item.rest;

import com.winfred.core.entity.base.BaseResponse;
import com.winfred.item.api.ItemInfoApi;
import com.winfred.item.entity.ItemInfo;
import com.winfred.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemInfoRest implements ItemInfoApi {

  @Autowired
  private ItemService itemService;

  @Override
  public BaseResponse<ItemInfo> getItemList(@PathVariable(value = "item_sn") String itemSn) {
    ItemInfo item = itemService.getItem(itemSn);
    return BaseResponse.success(item);
  }
}
