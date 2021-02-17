package lesson_2;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObservers {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Orange", "Black", "Red");

        source.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

        source.subscribe(System.out::println, Throwable::printStackTrace);

        source.subscribe(System.out::println);

    }
}
