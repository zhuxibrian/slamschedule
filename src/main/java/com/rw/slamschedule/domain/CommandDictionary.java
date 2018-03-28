package com.rw.slamschedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Copyright (C), 2018-2020, TianJin ReiWei info. Co., Ltd.
 * FileName: CommandDictionary.java
 * 子命令（submessage）类型字典表对应实体类，用于存放命令相关参数
 *
 * @author zx
 * @Date   20180209
 * @version 1.00
 */
@Entity
public class CommandDictionary {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String keyName;

    @Column
    private String valueType;

    @Column
    private String value;

    @Column
    private Long parentId;

    @Column
    private Long sonId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getSonId() {
        return sonId;
    }

    public void setSonId(Long sonId) {
        this.sonId = sonId;
    }
}
