package com.rw.slamschedule.bean.pojo;

public class MqttSendTerminalMessage extends MqttHead{

    private String id;
    private String buttonId;
    private String buttonState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getButtonState() {
        return buttonState;
    }

    public void setButtonState(String buttonState) {
        this.buttonState = buttonState;
    }
}
