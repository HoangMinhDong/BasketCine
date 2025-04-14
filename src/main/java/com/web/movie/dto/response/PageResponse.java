package com.web.movie.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageResponse<T> {

    int pageNo;
    int pageSize;
    int totalPage;
    T items;
}
