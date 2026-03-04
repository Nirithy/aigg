package android.ext;

class rs implements Runnable {
    final ShowApp a;

    rs(ShowApp showApp0) {
        this.a = showApp0;
        super();
    }

    @Override
    public void run() {
        if(this.a.f && this.a.a(this.a)) {
            this.a.f = false;
        }
        if(this.a.a(this.a, this.a.a)) {
            this.a.f = true;
        }
    }
}

