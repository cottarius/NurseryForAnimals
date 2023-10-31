package view;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    public String addBirthDateMenu() {
        System.out.print("1. Введите год: ");
        String year = in.nextLine();
        System.out.print("2. Введите месяц: ");
        String month = in.nextLine();
        System.out.print("3. Введите день: ");
        String day = in.nextLine();
        return String.format("%s.%s.%s", year, month, day);
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

    public void menu() {
        System.out.print("""
                База данных животных
                1. Список всех животных
                2. Добавить животного
                3. Список по дате
                4. Добавление новой команды животного
                5. Список команд животного
                6. Выход
                help - вывод меню
                """);
    }
}
