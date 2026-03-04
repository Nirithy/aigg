package android.ext;

class pm implements Runnable {
    final pl a;

    pm(pl pl0) {
        this.a = pl0;
        super();
    }

    @Override
    public void run() {
        this.a.c();
    }
}

