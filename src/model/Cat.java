package model;

import java.time.LocalDate;
import java.util.List;

public class Cat extends Pets{

    public Cat(int id, String name, LocalDate birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
}
