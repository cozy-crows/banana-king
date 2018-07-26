package com.example.bananaking.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by jerry on 2018/7/26.
 *
 * @author jerry
 */
@Data
@AllArgsConstructor
public class KingOfComment {

    private String psId;

    private String name;

    private Long commentCount;
}
