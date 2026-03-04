package android.ext;

class mz implements Runnable {
    final MainService a;

    mz(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        this.a.onLongClick(null);
    }
}

