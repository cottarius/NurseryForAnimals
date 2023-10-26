package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public abstract class Animal {
    protected int id;
    protected String name;
    protected LocalDate birthDate;
    protected String commands;
    protected static int serial = 1;

    public Animal(int id, String name, LocalDate birthDate, String commands) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public Animal() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCommands() {
        return commands;
    }
//    public void listOfCommands() {
//        System.out.printf("%s can execute commands ", name);
//        for (String command : commands) {
//            System.out.printf("%s", command);
//        }
//    }
//    public void addCommands(String newCommand) {
//        commands.add(newCommand);
//    }
//    public void getByDate(List<Animals> list) {
//        if(list.isEmpty()) {
//            System.out.println("The list is empty!");
//        }
//        list.sort(Comparator.comparing(Animals::getBirthDate));
//    }

    @Override
    public String toString() {
        return String.format("%-4d%-10s%-8s%-12s%-15s", getId(),
                getName(),
                getClass().getSimpleName(),
                getBirthDate().toString(),
                getCommands());

    }
    public String toShorterString() {
        return String.format("%-4d%-10s%-8s", getId(),
                getName(),
                getClass().getSimpleName());
    }
}
