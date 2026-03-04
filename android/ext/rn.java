package android.ext;

class rn implements Runnable {
    final ShowApp a;

    rn(ShowApp showApp0) {
        this.a = showApp0;
        super();
    }

    @Override
    public void run() {
        if(this.a.g == null) {
            this.a.b();
            rx.a().postDelayed(this.a.j, 2000L);
        }
    }
}

