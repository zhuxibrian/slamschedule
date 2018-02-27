package com.rw.slamschedule.domain;

import javax.persistence.Column;
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
public class CommandDictionary {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String key;

    @Column
    private String valueType;

    @Column
    private String value;

    @Column
    private String parentId;

    @Column
    private String sonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSonId() {
        return sonId;
    }

    public void setSonId(String sonId) {
        this.sonId = sonId;
    }
}
