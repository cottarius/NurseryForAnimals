package model;

import java.time.LocalDate;
import java.util.List;

public class Camel extends PackAnimals{

    public Camel(int id, String name, LocalDate birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
}
