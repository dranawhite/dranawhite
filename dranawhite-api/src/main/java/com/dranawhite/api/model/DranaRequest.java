package com.dranawhite.api.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dranawhite
 * @version : DranaRequest.java, v 0.1 2019-07-26 14:10 dranawhite Exp $$
 */
@Setter
@Getter
public class DranaRequest<T extends BaseData> extends BaseRequest {

    private T data;

}
