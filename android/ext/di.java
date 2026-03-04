package android.ext;

class di implements Runnable {
    final dh a;

    di(dh dh0) {
        this.a = dh0;
        super();
    }

    @Override
    public void run() {
        try {
            MainService mainService0 = MainService.instance;
            mainService0.g();
            mainService0.l.d();
            mainService0.g(false);
        }
        catch(Throwable throwable0) {
            la.c("Failed restore after take screenshot", throwable0);
        }
    }
}

