package lesson_2;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class CreatingObservables {

    public static void main(String[] args) {
        Observable<Integer> create = Observable.create( e -> {
            try {
                e.onNext(10);
                e.onNext(11);
                e.onComplete();
            } catch (Throwable t) {
                e.onError(t);
            }
        });

        create.subscribe(System.out::println);

        Observable<Integer> just = Observable.just(1,2,3);

        just.subscribe(System.out::println);

        Observable<Integer> fromIterable = Observable.fromIterable(List.of(1, 2, 3));

        fromIterable.subscribe(System.out::println);
    }

}

