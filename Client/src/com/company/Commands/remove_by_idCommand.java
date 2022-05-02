package com.company.Commands;

public class remove_by_idCommand extends AbstractCommand {
    public static Long ID;

    private static final long serialVersionUID = 11;

    public remove_by_idCommand(Long ID) {
        remove_by_idCommand.ID = ID;
    }
}
