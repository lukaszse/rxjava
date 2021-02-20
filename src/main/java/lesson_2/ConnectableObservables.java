package lesson_2;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class ConnectableObservables {

    public static void main(String[] args) throws InterruptedException {


//        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
//
//        source.subscribe(System.out::println);
//
//        Thread.sleep(10000);
//
//        source.subscribe(System.out::println);
//
//        Thread.sleep(10000);


        ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();

        source.connect();

        source.subscribe(System.out::println);

        Thread.sleep(10000);

        source.subscribe(System.out::println);

        Thread.sleep(10000);

    }
}
