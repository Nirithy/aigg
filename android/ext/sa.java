package android.ext;

class sa implements Runnable {
    private final long a;

    sa(long v) {
        this.a = v;
        super();
    }

    @Override
    public void run() {
        MainService.instance.k.a(this.a);
    }
}

