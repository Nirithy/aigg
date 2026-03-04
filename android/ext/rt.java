package android.ext;

class rt implements Runnable {
    final ShowApp a;

    rt(ShowApp showApp0) {
        this.a = showApp0;
        super();
    }

    @Override
    public void run() {
        if(this.a.e && this.a.a(this.a.c)) {
            this.a.e = false;
        }
        if(this.a.a(this.a.c, this.a.d)) {
            this.a.e = true;
        }
    }
}

