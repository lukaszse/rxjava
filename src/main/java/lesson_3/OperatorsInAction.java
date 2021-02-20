package lesson_3;

import io.reactivex.rxjava3.core.Observable;

public class OperatorsInAction {
    public static void main(String[] args) {
        Observable<Employee> employeeObservable = Observable.just(
                new Employee(1, "Kamil", 70000, 4.5),
                    new Employee(2, "Zenon", 30000, 2.5),
                    new Employee(3, "Gustaw", 70000, 4.9),
                    new Employee(4, "Kamila", 50000, 4.8),
                    new Employee(5, "Zigi", 50000, 4.1),
                    new Employee(6, "Ola", 70000, 4.5),
                    new Employee(7, "Zygfryd", 40000, 3.5),
                    new Employee(8, "Mariusz", 70000, 4.6)
                    );

        employeeObservable
                .filter(employee -> employee.getRating() > 4.5)
                .sorted((e1, e2) -> Double.compare(e1.getRating(), e2.getRating()))
                .map(employee -> employee.getName())
                .take(3)
                .subscribe(System.out::println);
    }
}


class Employee {
    int id;
    String name;
    double salary;
    double rating;

    Employee(int id, String name, double salary, double rating) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.rating = rating;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    double getRating() {
        return rating;
    }

    void setRating(float rating) {
        this.rating = rating;
    }
}