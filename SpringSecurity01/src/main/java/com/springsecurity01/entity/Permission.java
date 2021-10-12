package com.springsecurity01.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "t_permission")
@Data
public class Permission extends BaseEntity {

    private String permissionName;

    private String permissionKey;

}