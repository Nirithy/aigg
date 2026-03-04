package android.ext;

class mw implements Runnable {
    final MainService a;

    mw(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        this.a.x();
    }
}

