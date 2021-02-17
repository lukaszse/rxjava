package lesson_3;

import io.reactivex.rxjava3.core.Observable;

public class Operators {


    public static void main(String[] args) {
        Observable.just(60, 55, 22, 33)
                .filter(e -> e > 30)
                .sorted()
                .subscribe(e -> System.out.println("Grade with: " + e));
    }

}
