package android.ext;

class nc implements Runnable {
    final MainService a;

    nc(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        this.a.F();
    }
}

