package com.cyc.mydemo.entity;

import com.cyc.mydemo.config.LocalDateTimeAttributeConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "depart")
public class Depart {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",nullable = false,length = 20)
    private String name;

    @Column(name = "create_time",nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime createTime;

    @Column(name = "update_time",nullable = true)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime updateTime;
}
