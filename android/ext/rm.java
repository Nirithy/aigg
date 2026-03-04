package android.ext;

class rm implements Runnable {
    final ShowApp a;

    rm(ShowApp showApp0) {
        this.a = showApp0;
        super();
    }

    @Override
    public void run() {
        this.a.c();
    }
}

