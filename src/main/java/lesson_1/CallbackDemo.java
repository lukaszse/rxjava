package lesson_1;


public class CallbackDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thead is running");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CallbackDemo().runningAsync(new Callback() {
                    @Override
                    public void call() {
                        System.out.println("Callback called!");
                    }
                });
            }
        };

        Thread t = new Thread(r);
        t.start();
        Thread.sleep(2000);

        System.out.println("Main thread completed");
    }

    public void runningAsync(Callback callback) {
        System.out.println("I'm running in separate thread");
        sleep(1000);
        callback.call();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
