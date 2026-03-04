package android.ext;

class rk implements Runnable {
    final ShowApp a;

    rk(ShowApp showApp0) {
        this.a = showApp0;
        super();
    }

    @Override
    public void run() {
        if(this.a.e && this.a.a(this.a.c)) {
            this.a.e = false;
        }
    }
}

