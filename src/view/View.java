package view;

import java.util.Date;
import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    public String addBirthDateMenu() {
        System.out.print("1. Введите год: ");
        String year = in.next();
        System.out.print("2. Введите месяц: ");
        String month = in.next();
        System.out.print("3. Введите день: ");
        String day = in.next();
        String birthdate = String.format("%s.%s.%s", year, month, day);
        return birthdate;
    }
    public void addAnimalMenu() {
        System.out.print("""
                1. Кот
                2. Собака
                3. Хомяк
                4. Лошадь
                5. Верблюд
                6. Осёл
                Выберите тип животного для создания: 
                """);
    }
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
