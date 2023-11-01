package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Donkey extends PackAnimals{

    public Donkey(int id, String name, LocalDate birthDate, String commands) {
        super(id, name, birthDate, commands);
    }

    public Donkey() {
    }
}
