package lesson_2;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Adam", "Ewa", "Kasia");
        Observable<String> source2 = Observable.empty();


        // single
        source.first("Name")
                .subscribe(System.out::println);

        Single.just("Adam").subscribe(System.out::println);


        // maybe
        source.firstElement()
                .subscribe(System.out::println);

        source2.firstElement()
                .subscribe(System.out::println, err -> System.out.println("err" + err), () -> System.out.println("completed"));


        // completable
        Completable completable = Completable.complete();

        Completable.fromRunnable(() -> System.out.println("Some process excecuting"))
                .subscribe(() -> System.out.println("Process executed successfully"), Throwable::printStackTrace);
    }
}
