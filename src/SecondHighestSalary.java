import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SecondHighestSalary {
    public static void main(String[] args) {
        List<Person> l = new ArrayList<>();

        Person p1 = new Person("Alice", 100000, 1);
        Person p2 = new Person("Bob", 50000, 2);
        Person p3 = new Person("Alice", 50000, 3);

        l.add(p1);
        l.add(p2);
        l.add(p3);

        l.sort(Comparator.comparing(Person::getSalary).reversed().thenComparing(Person::getName));

        int cnt = 1;
        for(Person p : l) {
            if(cnt == 2) {
                System.out.println("2nd highest salary is earned by " + p.getName() + " and salary is "+p.getSalary());
                break;
            }
            cnt++;
        }
    }
}

class Person {
    private String name;
    private long salary;
    private long id;

    public Person(String n, long s, long id) {
        name = n;
        salary = s;
        this.id = id;
    }

    public long getSalary() {
        return this.salary;
    }

    public String getName() {
        return this.name;
    }
}
