package com.winfred.common.entity.base;


public class BasePageResponse extends BaseResponse {

    private PageData data;

    public BasePageResponse() {
        super();
    }

    public BasePageResponse(PageData data) {
        super();
        this.data = data;
    }

    public static BasePageResponse send(EnumResponseType type, PageData data) {
        BasePageResponse pageResponse = new BasePageResponse();
        pageResponse.setCode(type.getCode());
        pageResponse.setMessage(type.getMessage());
        pageResponse.setData(data);
        return pageResponse;
    }

    @Override
    public PageData getData() {
        return data;
    }

    /**
     * 设置分页数据返回
     *
     * @param data
     */
    public void setData(PageData data) {
        this.data = data;
    }

}

