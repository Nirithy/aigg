package android.ext;

class mk implements Runnable {
    final MainService a;

    mk(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        this.a.e = null;
        this.a.f = null;
        this.a.Z.c();
        this.a.j(true);
    }
}

