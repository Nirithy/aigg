package android.ext;

public class to implements Runnable {
    final Runnable a;

    public to(Runnable runnable0) {
        this.a = runnable0;
    }

    public static Runnable a(Runnable runnable0) {
        return !(runnable0 instanceof to) ? new to(runnable0) : runnable0;
    }

    @Override
    public void run() {
        try {
            this.a.run();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }
}

