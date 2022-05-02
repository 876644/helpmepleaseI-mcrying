package com.company.Commands;

public class updateCommand extends AbstractCommand {

    public Long ID;
    private static final long serialVersionUID = 14;

    public updateCommand(Long ID) {
        this.ID = ID;
    }
}
