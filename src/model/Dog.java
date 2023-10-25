package model;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Pets {

    public Dog(int id, String name, LocalDate birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
}
