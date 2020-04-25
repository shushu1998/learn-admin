package com.hthyaq.learnadmin.model.output;

import lombok.Data;

@Data
public class OutputFormData<T> {
    private T data;
    private String dbOperate;
    private String ClassName;
}
