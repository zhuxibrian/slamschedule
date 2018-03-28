package com.rw.slamschedule.domain;

import java.io.Serializable;

public class TodoPk implements Serializable{
    private String terminalId;

    private String buttonId;

    private String sendTimestamp;

    public TodoPk() {
    }

    public TodoPk(String terminalId, String buttonId, String sendTimestamp) {
        this.terminalId = terminalId;
        this.buttonId = buttonId;
        this.sendTimestamp = sendTimestamp;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getSendTimestamp() {
        return sendTimestamp;
    }

    public void setSendTimestamp(String sendTimestamp) {
        this.sendTimestamp = sendTimestamp;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((terminalId == null) ? 0 : terminalId.hashCode());
        result = PRIME * result + ((buttonId == null) ? 0 : buttonId.hashCode());
        result = PRIME * result + ((sendTimestamp == null) ? 0 : sendTimestamp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        final TodoPk other = (TodoPk)obj;
        if(terminalId == null){
            if(other.terminalId != null){
                return false;
            }
        }else if(!terminalId.equals(other.terminalId)){
            return false;
        }
        if(buttonId == null){
            if(other.buttonId != null){
                return false;
            }
        }else if(!buttonId.equals(other.buttonId)){
            return false;
        }
        if(sendTimestamp == null){
            if(other.sendTimestamp != null){
                return false;
            }
        }else if(!sendTimestamp.equals(other.sendTimestamp)){
            return false;
        }

        return true;
    }
}
