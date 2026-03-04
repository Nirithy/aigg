package android.ext;

class nv implements Runnable {
    final MainService a;

    nv(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        la.a(("doCheckLibs: " + this.a.k()));
    }
}

