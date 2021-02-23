package lesson_5;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Subjects {

    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> scr1 = Observable.just(5, 10, 15, 20).subscribeOn(Schedulers.computation());
        Observable<Integer> scr2 = Observable.just(50, 100, 150, 200).subscribeOn(Schedulers.computation());

//        scr1.subscribe(System.out::println);
//        scr2.subscribe(System.out::println);

        @NonNull
        Subject<Object> subject = PublishSubject.create();

        subject.subscribe(System.out::println);
        subject.subscribe(e -> System.out.println("The element is: " + e));

        scr1.subscribe(subject);
        scr2.subscribe(subject);

        Thread.sleep(8000);
    }
}
