package com.dranawhite.api.model;

import com.dranawhite.common.validate.annotation.DeleteGroup;
import com.dranawhite.common.validate.annotation.InsertGroup;
import com.dranawhite.common.validate.annotation.UpdateGroup;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dranawhite
 * @version : DranaRequest.java, v 0.1 2019-07-26 14:10 dranawhite Exp $$
 */
@Setter
@Getter
public class DranaRequest<T> extends BaseRequest {

    @Valid
    @NotNull(groups = {Default.class, InsertGroup.class, UpdateGroup.class, DeleteGroup.class})
    private T data;

}
