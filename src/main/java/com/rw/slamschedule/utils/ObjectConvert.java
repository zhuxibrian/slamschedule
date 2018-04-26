package com.rw.slamschedule.utils;

import com.rw.slamschedule.domain.CommandHistory;
import com.rw.slamschedule.domain.CommandMapper;
import com.rw.slamschedule.domain.Slam;
import com.rw.slamschedule.domain.Todo;

public class ObjectConvert {

    public static Todo commandMapper2Todo(Integer terminalId, Integer buttonId, Integer commandMapperId) {
        Todo todo = new Todo();
        todo.setTerminalId(terminalId);
        todo.setButtonId(buttonId);
        todo.setCommandMapperId(commandMapperId);
        return todo;
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
