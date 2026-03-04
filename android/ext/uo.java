package android.ext;

class uo implements Runnable {
    private final String a;

    uo(String s) {
        this.a = s;
        super();
    }

    @Override
    public void run() {
        synchronized(this) {
            uk.b(this.a.getBytes());
        }
    }
}

