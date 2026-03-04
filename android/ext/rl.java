package android.ext;

class rl implements Runnable {
    final ShowApp a;
    private final boolean b;

    rl(ShowApp showApp0, boolean z) {
        this.a = showApp0;
        this.b = z;
        super();
    }

    @Override
    public void run() {
        if(this.a.a(this.a)) {
            this.a.f = false;
        }
        if(!this.b && this.a.a(this.a.h)) {
            this.a.h = null;
        }
    }
}

