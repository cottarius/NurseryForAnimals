package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Hamster extends Pets {

    public Hamster(int id, String name, LocalDate birthDate, String commands) {
        super(id, name, birthDate, commands);
    }

    public Hamster() {
    }
}

