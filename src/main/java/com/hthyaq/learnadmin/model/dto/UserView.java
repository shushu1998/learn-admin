package com.hthyaq.learnadmin.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserView {
    private Long id;
    private Long value;
    private String title;
    private List targetKeys;

}
