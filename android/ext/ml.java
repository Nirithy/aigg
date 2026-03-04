package android.ext;

class ml implements Runnable {
    final MainService a;

    ml(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        this.a.i = null;
        this.a.Z.e();
    }
}

