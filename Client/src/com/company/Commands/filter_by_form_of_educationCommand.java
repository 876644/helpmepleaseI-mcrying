package com.company.Commands;

import com.company.Enums.FormOfEducation;

public class filter_by_form_of_educationCommand extends AbstractCommand {

    private static final long serialVersionUID = 6;

    public static String formOfEducation;

    public filter_by_form_of_educationCommand(String formOfEducation) {
        filter_by_form_of_educationCommand.formOfEducation = formOfEducation;
    }

}
