package android.ext;

class rr implements Runnable {
    final ShowApp a;

    rr(ShowApp showApp0) {
        this.a = showApp0;
        super();
    }

    @Override
    public void run() {
        if(this.a.a(this.a.i)) {
            this.a.i = null;
        }
    }
}

