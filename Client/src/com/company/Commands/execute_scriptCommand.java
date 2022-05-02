package com.company.Commands;

public class execute_scriptCommand extends AbstractCommand {
    private static final long serialVersionUID = 5;
    public String fileName;

    public execute_scriptCommand(String fileName) {
        this.fileName = fileName;
    }
}
