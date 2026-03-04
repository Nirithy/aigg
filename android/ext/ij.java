package android.ext;

class ij implements Runnable {
    final FloatPanel a;

    ij(FloatPanel floatPanel0) {
        this.a = floatPanel0;
        super();
    }

    @Override
    public void run() {
        la.a(this.a.a("hide"));
        if(!this.a.b) {
            return;
        }
        this.a.b = false;
        this.a.g();
    }
}

