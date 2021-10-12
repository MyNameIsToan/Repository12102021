package com.springsecurity01.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "t_token")
@Data
public class Token extends BaseEntity {

    @Column(length = 1000)
    private String token;

    private Date tokenExpDate;

}