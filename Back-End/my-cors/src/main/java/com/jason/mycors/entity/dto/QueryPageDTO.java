package com.jason.mycors.entity.dto;

import lombok.Data;

@Data
public class QueryPageDTO {

    private Integer pageNum = 1;

    private Integer pageSize = 10;
}
