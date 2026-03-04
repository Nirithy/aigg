package android.ext;

public class gr extends Thread {
    public gr(Runnable runnable0, String s) {
        super(runnable0, s);
        this.setDaemon(true);
        ho.a(this);
    }

    public gr(String s) {
        super(s);
        this.setDaemon(true);
        ho.a(this);
    }
}

