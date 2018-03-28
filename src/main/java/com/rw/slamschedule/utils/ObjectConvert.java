package com.rw.slamschedule.utils;

import com.rw.slamschedule.bean.pojo.MqttReceiveSlamMessage;
import com.rw.slamschedule.domain.CommandHistory;
import com.rw.slamschedule.domain.CommandMapper;
import com.rw.slamschedule.domain.Slam;
import com.rw.slamschedule.domain.Todo;
import org.springframework.transaction.annotation.Transactional;

public class ObjectConvert {

    public static Todo commandMapper2Todo(String terminalId, String buttonId, Integer commandMapperId) {
        Todo todo = new Todo();
        todo.setTerminalId(terminalId);
        todo.setButtonId(buttonId);
        todo.setCommandMapperId(commandMapperId);
        return todo;
    }

    /**将获得的mqtt信息对象转化为slam*/
    public static Slam mqttReceiveSlamMessage2Slam(MqttReceiveSlamMessage mqttReceiveSlamMessage) {
        Slam slam = new Slam();

        slam.setIp(mqttReceiveSlamMessage.getIp());
        slam.setGroupId(mqttReceiveSlamMessage.getGroupId());
        slam.setLocationX(Double.valueOf(mqttReceiveSlamMessage.getX()));
        slam.setLocationY(Double.valueOf(mqttReceiveSlamMessage.getY()));
        slam.setBattery(Integer.valueOf(mqttReceiveSlamMessage.getBattery()));
        slam.setState(mqttReceiveSlamMessage.getState());
        slam.setId(mqttReceiveSlamMessage.getId());
        if (mqttReceiveSlamMessage.getBattery() == "1") {
            slam.setCharge(true);
        } else {
            slam.setCharge(false);
        }

        return slam;
    }

    public static CommandHistory todo2CommandHistory(Todo todo, CommandMapper commandMapper) {
        CommandHistory commandHistory = new CommandHistory();

        commandHistory.setButtonId(todo.getButtonId());
        commandHistory.setTerminalId(todo.getTerminalId());
        commandHistory.setReceiveTimestamp(todo.getReceiveTimestamp());
        commandHistory.setSlamId(todo.getSlamId());
        commandHistory.setFinishTimestamp(System.currentTimeMillis());
        commandHistory.setCommandString(commandMapper.toString());

        return commandHistory;
    }

}
