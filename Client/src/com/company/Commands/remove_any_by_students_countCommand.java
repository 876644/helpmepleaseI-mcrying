package com.company.Commands;

public class remove_any_by_students_countCommand extends AbstractCommand {
    public static Long countOfStudents;
    private static final long serialVersionUID = 10;

    public remove_any_by_students_countCommand(Long countOfStudents) {
        remove_any_by_students_countCommand.countOfStudents = countOfStudents;
    }
}
