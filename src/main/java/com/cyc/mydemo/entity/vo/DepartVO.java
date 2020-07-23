package com.cyc.mydemo.entity.vo;

import com.cyc.mydemo.entity.Depart;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DepartVO {
    private Long id;
    @NotEmpty
    private String name;
}
