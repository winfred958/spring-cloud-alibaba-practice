package com.winfred.common.entity.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class BasePageRequest extends PageModel implements Serializable {


    private static final long serialVersionUID = -5700842088869071012L;
    @Getter
    @Setter
    private List<Order> orders;

    @Getter
    @Setter
    private String start_date_str;

    @Getter
    @Setter
    private String end_date_str;

}
