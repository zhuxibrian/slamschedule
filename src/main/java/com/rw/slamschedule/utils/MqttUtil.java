package com.rw.slamschedule.utils;

public class MqttUtil {

    private String objectType = null;
    private String objectRange = null;
    private String objectId = null;

    public MqttUtil(String mqttFrom) {
        String strList[] = mqttFrom.split("/");

        objectType = strList[1];

        if (strList.length > 2)
            objectRange = strList[2];

        if(strList.length>3)
            objectId = strList[3];

    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectRange() {
        return objectRange;
    }

    public void setObjectRange(String objectRange) {
        this.objectRange = objectRange;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
