package com.example.bananaking.mananger.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * Created by jerry on 2018/7/20.
 *
 * @author jerry
 */
@Data
public class FbResponse<T> {

    @JsonProperty("data")
    private List<T> data;

    @JsonProperty("paging")
    private Paging paging;

    public boolean hasNextPage() {
        return Objects.nonNull(getAfterPageHash());
    }

    public boolean hasPreviousPage() {
        return Objects.nonNull(getBeforePageHash());
    }

    public String getAfterPageHash() {
        if (Objects.nonNull(paging) &&
            Objects.nonNull(paging.getCursors()) &&
            Objects.nonNull(paging.getCursors().getAfter())) {

            return paging.getCursors().getAfter();
        }
        return null;
    }

    public String getBeforePageHash() {
        if (Objects.nonNull(paging) &&
            Objects.nonNull(paging.getCursors()) &&
            Objects.nonNull(paging.getCursors().getBefore())) {

            return paging.getCursors().getBefore();
        }
        return null;
    }
}
