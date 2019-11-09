
package com.dranawhite.common.model;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;

/**
 * @author dranawhite
 * @version : BiRequest.java, v 0.1 2019-10-11 15:29 dranawhite Exp $$
 */
@Setter
@Getter
public class DranaRequest<T> {

    @NotNull
    private T data;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
