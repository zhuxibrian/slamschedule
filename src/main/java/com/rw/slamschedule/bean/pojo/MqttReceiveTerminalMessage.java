package com.rw.slamschedule.bean.pojo;

public class MqttReceiveTerminalMessage extends MqttHead{

    private String buttonId;
    private String isCancel;

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }

    @Override
    public String toString() {
        return super.toString() +
                "MqttReceiveTerminalMessage{" +
                "buttonId='" + buttonId + '\'' +
                ", isCancel='" + isCancel + '\'' +
                '}';
    }
}
