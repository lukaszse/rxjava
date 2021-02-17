package lesson_2;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Disposing {

    public static void main(String[] args) throws InterruptedException {

        @NonNull
        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS);

        Disposable d = src.subscribe(element -> System.out.println("Observer 1: " + element));
        Thread.sleep(5000);
        d.dispose();

        src.subscribe(element -> System.out.println("Observer 2: " + element));
        Thread.sleep(10000);
    }
}
