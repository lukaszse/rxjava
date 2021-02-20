package lesson_4;

import io.reactivex.rxjava3.core.Observable;

public class Grouping {
    public static void main(String[] args) {
        Observable<Employee2> employeeObservable = Observable.just(
                    new Employee2(1, "Kamil", 70000, 4.5),
                    new Employee2(2, "Zenon", 30000, 2.5),
                    new Employee2(3, "Gustaw", 70000, 4.9),
                    new Employee2(4, "Kamila", 50000, 4.8),
                    new Employee2(5, "Zigi", 50000, 4.5),
                    new Employee2(6, "Ola", 70000, 4.5),
                    new Employee2(7, "Zygfryd", 40000, 3.5),
                    new Employee2(8, "Mariusz", 70000, 4.6)
                    );

        employeeObservable.groupBy(Employee2::getRating)
                .flatMapSingle(Observable::toList)
                .subscribe(System.out::println);
    }
}


class Employee2 {
    int id;
    String name;
    double salary;
    double rating;

    Employee2(int id, String name, double salary, double rating) {
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