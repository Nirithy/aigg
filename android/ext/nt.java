package android.ext;

class nt implements Runnable {
    final MainService a;

    nt(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        this.a.p.show();
        this.a.aa.a(false);
    }
}

