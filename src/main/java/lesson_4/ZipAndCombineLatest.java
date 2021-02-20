package lesson_4;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ZipAndCombineLatest {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> scr1 = Observable.interval(200, TimeUnit.MILLISECONDS);
        Observable<Long> scr2 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.zip(scr1, scr2, (e1, e2) -> "Source 1: " + e1 + " Source 2: " + e2)
                .subscribe(System.out::println);


/*        Observable.zip(scr1, scr2, (e1, e2) -> "Source 1: " + e1 + " Source 2: " + e2)
                .subscribe(System.out::println);*/

        Thread.sleep(20000);
    }

}
