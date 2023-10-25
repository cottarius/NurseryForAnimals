package model;

import java.time.LocalDate;
import java.util.List;

public abstract class Animal {
    protected int id;
    protected String name;
    protected LocalDate birthDate;
    protected List<String> commands;
    protected static int serial = 1;

    public Animal(int id, String name, LocalDate birthDate, List<String> commands) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public void setCommands(List<String> commands) {
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

    public List<String> getCommands() {
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
        return String.format("%-4d%-8s%-8s%-12s%-15s", getId(),
                getName(),
                getClass().getSimpleName(),
                getBirthDate().toString(),
                getCommands());

    }
    public String toShorterString() {
        return String.format("%-4d%-8s%-8s", getId(),
                getName(),
                getClass().getSimpleName());
    }
}
