package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Cat extends Pets{

    public Cat(int id, String name, LocalDate birthDate, String commands) {
        super(id, name, birthDate, commands);
    }

    public Cat() {
    }
}
