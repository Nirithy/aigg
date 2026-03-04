package android.ext;

class nh implements Runnable {
    final MainService a;

    nh(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        if(this.a.p == null) {
            this.a.M();
        }
    }
}

