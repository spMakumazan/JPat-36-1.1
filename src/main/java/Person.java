import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        if (address == null) {
            return false;
        } else {
            return !address.isEmpty();
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() throws NoSuchElementException {
        int age = this.age.getAsInt();
        this.age = OptionalInt.of(age + 1);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " " + surname);
        if (hasAge()) {
            sb.append(" (" + age.getAsInt() + ")");
        }
        if (hasAddress()) {
            sb.append(" [" + address + "]");
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}