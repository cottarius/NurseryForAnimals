package model;

public enum AnimalType {
    Cat,
    Dog,
    Hamster,
    Horse,
    Camel,
    Donkey;

    public static AnimalType getAnimalType (int number) {
        return switch (number) {
            case 1 -> AnimalType.Cat;
            case 2 -> AnimalType.Dog;
            case 3 -> AnimalType.Hamster;
            case 4 -> AnimalType.Horse;
            case 5 -> AnimalType.Donkey;
            default -> null;
        };
    }
}
