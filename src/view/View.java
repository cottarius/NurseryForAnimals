package view;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    public void headOfTable(){
        System.out.println("Id\tName\t\tType\tBirthDate\tCommands");
    }
    public void headOfShortTable() {
        System.out.println("Id\t\tName\tType");
    }
    public void menu() {
        System.out.println("База данных животных\n" +
                "1. Список всех животных\n" +
                "2. Добавить животного\n" +
                "3. Добавление новой команды животного\n" +
                "4. Выход\n" +
                "Выберите пункт меню: ");
    }
    public int inputNumber() {
        return in.nextInt();
    }
    public String inputString() {
        return in.next();
    }
}
