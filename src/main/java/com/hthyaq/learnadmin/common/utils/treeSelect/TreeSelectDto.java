package com.hthyaq.learnadmin.common.utils.treeSelect;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TreeSelectDto {
    private Integer id;
    private Integer pid;
    private String name;
}
