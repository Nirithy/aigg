package android.ext;

class ii implements Runnable {
    final FloatPanel a;

    ii(FloatPanel floatPanel0) {
        this.a = floatPanel0;
        super();
    }

    @Override
    public void run() {
        la.a(this.a.a("show"));
        if(this.a.c) {
            return;
        }
        this.a.e();
    }
}

