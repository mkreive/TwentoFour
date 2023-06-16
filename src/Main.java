import java.util.Arrays;

record Person (String name, String dob, Person[] kids) {

    public Person(Person p) {
        this(p.name, p.dob, p.kids == null ? null : Arrays.copyOf(p.kids, p.kids.length));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }
};
public class Main {
    public static void main(String[] args) {

        BankCustomer john = new BankCustomer("John Snow", 500.00, 5300.00);
        System.out.println(john);
        System.out.println("_".repeat(40));

        Person ann = new Person("Ann", "01/03/2020", null);
        Person ben = new Person("Ben", "13/02/2016", null);
        Person carol = new Person("Carol", "23/12/2012", null);
        Person den = new Person("Den", "29/10/1990", new Person[]{ann});
        Person ed = new Person("Ed", "09/12/1988", new Person[]{ben, carol});

        Person[] persons = {ann, ben, carol, den, ed};
//        Person[] personsCopy = persons.clone(); // shallow copy
//        Person[] personsCopy = Arrays.copyOf(persons, persons.length); // shallow copy
        Person[] personsCopy = new Person[5]; // deep copy will be after for loop
        Arrays.setAll(personsCopy, i -> new Person(persons[i])); // deep copy


//        for (int i = 0; i < 5; i++) { // manual copy making
//            Person current = persons[i];
////            var kids = current.kids(); // shallow copy of kids
//            var kids = current.kids() == null ? null :
//                    Arrays.copyOf(current.kids(), current.kids().length); // deep copy of kids too
//            personsCopy[i] = new Person(current.name(), current.dob(), kids);
//        }

//        for (int i = 0; i < 5; i++) {
//            personsCopy[i] = new Person(persons[i]);
//        }

        var densKids = personsCopy[3].kids();
        densKids[0] = ben;
        System.out.println(persons[3]);
        System.out.println(personsCopy[3]);
















    }
}
