import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("У человека обязательно должно быть имя");
        }
        if (surname == null) {
            throw new IllegalStateException("У человека обязательно должна быть фамилия");
        }
        Person person;
        if (age.isPresent()) {
            person = new Person(name, surname, age.getAsInt());
        } else {
            person = new Person(name, surname);
        }
        if (address != null && !address.isEmpty()) {
            person.setAddress(address);
        }
        return person;
    }
}