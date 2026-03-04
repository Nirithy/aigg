package android.ext;

class nu implements Runnable {
    final MainService a;

    nu(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        try {
            this.a.k.k(2);
        }
        catch(Throwable unused_ex) {
        }
    }
}

