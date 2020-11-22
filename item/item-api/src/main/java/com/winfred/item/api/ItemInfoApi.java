package com.winfred.item.api;

import com.winfred.core.entity.base.BaseResponse;
import com.winfred.item.entity.ItemInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/info")
public interface ItemInfoApi {

  @RequestMapping(value = "/{item_sn}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  BaseResponse<ItemInfo> getItemList(@PathVariable(value = "item_sn") String itemSn);
}
