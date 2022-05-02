package com.company.Utility;

import com.company.Commands.*;
import com.company.Enums.*;
import com.company.Main;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandsObjects {


    @Annotation(name = "clear")
    public void clear(String[] args) {
        if (args.length == 0) Main.object = new clearCommand();
        else System.out.println("У этой команды нет аргумента, попробуйте ещё раз.");
    }

    @Annotation(name = "average_of_students_count")
    public void average_of_students_count(String[] args) {
        if (args.length == 0) Main.object= new average_of_students_countCommand();
        else System.out.println("У этой команды нет аргумента, попробуйте ещё раз. ");
    }

    @Annotation(name = "exit")
    public void exit(String[] args) {
        System.out.println("Клиентское приложение завершило работу.");
        System.exit(0);
    }

    @Annotation(name = "filter_by_form_of_education")
    public void filter_by_form_of_education(String[] args) {
        if (args.length == 1) {
            String str = args[0];
            if (str.equals("FULL_TIME_EDUCATION") || str.equals("DISTANCE_EDUCATION") || str.equals("EVENING_CLASSES")) {
                Main.object = new filter_by_form_of_educationCommand(str);
            }
        }else System.out.println("У этой команды должен быть один аргумент. Повторите попытку.");
    }

    @Annotation(name = "head")
    public void head(String[] args) {
        if (args.length == 0) Main.object = new headCommand();
        else System.out.println("У этой команды нет аргумента, попробуйте ещё раз. ");
    }

    @Annotation(name = "help")
    public void help(String[] args) {
        if (args.length == 0) Main.object = new helpCommand();
        else System.out.println("У этой команды нет аргумента, попробуйте ещё раз. ");
    }

    @Annotation(name = "history")
    public void history(String[] args) {
        if (args.length == 0) Main.object = new historyCommand();
        else System.out.println("У этой команды нет аргумента, попробуйте ещё раз. ");
    }

    @Annotation(name = "info")
    public void info(String[] args) {
        if (args.length == 0) Main.object = new infoCommand();
        else System.out.println("У этой команды нет аргумента, попробуйте ещё раз. ");
    }

    @Annotation(name = "remove_any_by_students_count")//
    public void remove_any_by_students_count(String[] args) {
        if ((args.length == 1) && (Pattern.compile("\\d+").matcher(args[0]).matches())) {
            Long count = Long.valueOf(args[0]);
            Main.object = new remove_any_by_students_countCommand(count);
        } else System.out.println("У этой команды должен быть один аргумент. Повторите попытку.");
    }

    @Annotation(name = "remove_by_id")//
    public void remove_by_id(String[] args) {
        if (args.length == 1 && Pattern.compile("\\d+").matcher(args[0]).matches()) {
            Long Id = Long.valueOf(args[0]);
            Main.object = new remove_by_idCommand(Id);
        } else System.out.println("У этой команды должен быть один аргумент. Повторите попытку.");
    }

    @Annotation(name = "remove_head")
    public void remove_head(String[] args) {
        if (args.length == 0) Main.object = new remove_headCommand();
         else System.out.println("У этой команды нет аргумента, попробуйте ещё раз. ");
    }

    @Annotation(name = "show")
    public void show(String[] args) {
        if (args.length == 0) Main.object = new showCommand();
         else System.out.println("У этой команды нет аргумента, попробуйте ещё раз. ");
    }

    @Annotation(name = "update")//
    public void update(String[] args) {
        if (args.length == 1 && Pattern.compile("\\d+").matcher(args[0]).matches()) {
            Long Id = Long.valueOf(args[0]);
            Main.object =  new updateCommand(Id);

        } else System.out.println("У этой команды должен быть один аргумент. Повторите попытку.");
    }

    @Annotation(name = "add")//
    public static void add(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length != 0) {

            System.out.println("У команды add нет аргумента.");

        } else {
            System.out.println("Введите имя группы: ");
            String nameG = scanner.nextLine();
            while (nameG.equals("") || !Pattern.compile("[A-Z]*[a-z]*[0-9]*").matcher(nameG).matches()) {
                System.out.println("Неправильно введены данные имени группы. Повторите попытку. Пример имени группы :R3136");
                System.out.println("Введите имя группы: ");
                nameG = scanner.nextLine();
            }

            System.out.println("Введите координату x: ");
            String x = scanner.nextLine();
            while (!Pattern.compile("[0-9](.[0-9]*)?").matcher(x).matches() || x.equals("")) {
                System.out.println("Неправильно введены данные координаты x. Повторите попытку. Пример координаты x: 2.56 ");
                System.out.println("Введите коориднату x: ");
                x = scanner.nextLine();
            }

            while (Double.parseDouble(x) > 887) {
                System.out.println("Неправильно введены данные координаты x. Повторите попытку. Пример координаты x: 2.56 ");
                System.out.println("Введите коориднату x: ");
                x = scanner.nextLine();
            }

            System.out.println("Введите координату y: ");
            String y = scanner.nextLine();
            while (!Pattern.compile("\\d+").matcher(y).matches()) {
                System.out.println("Неправильно введены данные координаты y. Повторите попытку. Пример координаты y: 2");
                System.out.println("Введите коориднату y: ");
                y = scanner.nextLine();
            }

            System.out.println("Введите колличество студентов: ");
            String studentsCount = scanner.nextLine();
            while ((!Pattern.compile("\\d+").matcher(studentsCount).matches())) {
                System.out.println("Неправильно введены данные колличество студентов. Повторите попытку. Пример колличества студентов: 56 ");
                System.out.println("Введите колличество студентов: ");
                studentsCount = scanner.nextLine();
            }
            while (Long.parseLong(studentsCount) <= 0) {
                System.out.println("Неправильно введены данные колличество студентов. Повторите попытку. Пример колличества студентов: 56 ");
                System.out.println("Введите колличество студентов: ");
                studentsCount = scanner.nextLine();
            }

            System.out.println("Введите форму образования: ");
            String formEducation = scanner.nextLine();
            while (!formEducation.equals("FULL_TIME_EDUCATION")&&!formEducation.equals("DISTANCE_EDUCATION")&&!formEducation.equals("EVENING_CLASSES")) {
                System.out.println("Неправильно введена форма образования. Повторите попытку. Пример формы образования: DISTANCE_EDUCATION ");
                System.out.println("Введите форму образования: ");
                formEducation= scanner.nextLine();
            }

            System.out.println("Введите семестр: ");
            String semesterEnum = scanner.nextLine();
            while (!semesterEnum.equals("FIFTH")&&!semesterEnum.equals("SIXTH")&&!semesterEnum.equals("SEVENTH")) {
                System.out.println("Неправильно введён семестр. Повторите попытку. Пример семестра: SEVENTH");
                System.out.println("Введите семестр: ");
                semesterEnum= scanner.nextLine();
            }

            System.out.println("Введите имя студента: ");
            String name = scanner.nextLine();
            while ( name.equals("") || !Pattern.compile("[A-Z]*[a-z]*").matcher(name).matches() ) {
                System.out.println("Неправильно введено имя студента. Повторите попытку. Пример имени: Lora");
                System.out.println("Введите имя студента: ");
                name = scanner.nextLine();
            }

            System.out.println("Введите ID паспорта: ");
            String passportID = scanner.nextLine();
            while (passportID.equals("") || (!Pattern.compile("[A-Z]*[a-z]*[0-9]*").matcher(passportID).matches())){
                System.out.println("Неправильно введены данные ID паспорта. Повторите попытку. Пример iD паспорта: i1578kL");
                System.out.println("Введите ID паспорта: ");
                passportID = scanner.nextLine();
            }
            while (((passportID).length()) > 31){
                System.out.println("Неправильно введены данные ID паспорта. Повторите попытку. Пример iD паспорта: i1578kL");
                System.out.println("Введите ID паспорта: ");
                passportID = scanner.nextLine();
            }

            System.out.println("Введите цвет глаз: ");
            String eyeColor = scanner.nextLine();
            while (!eyeColor.equals("GREEN")&&!eyeColor.equals("YELLOW")&&!eyeColor.equals("ORANGE")&&!eyeColor.equals("WHITE")){
                System.out.println("Неправильно введены данные цвета глаз. Повторите попытку. Пример цвета глаз: GREEN ");
                System.out.println("Введите цвет глаз: ");
                eyeColor = scanner.nextLine();
            }

            System.out.println("Введите цвет волос: ");
            String hairColor = scanner.nextLine();
            while (!hairColor.equals("GREEN")&&!hairColor .equals("RED")&&!hairColor .equals("YELLOW")&&!hairColor .equals("WHITE")){
                System.out.println("Неправильно введены данные цвета волос. Повторите попытку. Пример цвета волос: GREEN ");
                System.out.println("Введите цвет волос: ");
                hairColor  = scanner.nextLine();
            }

            System.out.println("Введите национальность: ");
            String nationality = scanner.nextLine();
            while (!nationality.equals("RUSSIA")&&!nationality.equals("GERMANY")&&!nationality.equals("CHINA")&&!nationality.equals("NORTH_KOREA")){
                System.out.println("Неправильно введены данные национальности. Повторите попытку. Пример национальности: RUSSIA");
                System.out.println("Введите национальность: ");
                nationality = scanner.nextLine();
            }

            Main.object = new addCommand(nameG,Double.parseDouble(x),Integer.valueOf(y),Long.valueOf(studentsCount), FormOfEducation.valueOf(formEducation), Semester.valueOf(semesterEnum),name,passportID, ColorEye.valueOf(eyeColor), ColorHair.valueOf(hairColor), Country.valueOf(nationality));
        }
    }

    @Annotation(name = "execute_script")
    public void execute_script(String[] args) {
        if (args.length == 1 && Pattern.compile("^[A-Za-z0-9+_.-]+\\.[a-zA-Z0-9]+$").matcher(args[0]).matches()) {
            String fileName = args[0];
            Main.object = new execute_scriptCommand(fileName);
        }else System.out.println("У команды execute_script должен быть один аргумент, который являеться названием файла.");
    }
}
