package model;

import java.time.LocalDate;
import java.util.List;

public abstract class Pets extends Animal {
    public Pets(int id, String name, LocalDate birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
    //    @Override
//    public int compareTo(Animal animal) {
//        return this.getBirthDate().compareTo(animal.getBirthDate());
//    }
}
