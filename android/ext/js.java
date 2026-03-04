package android.ext;

class js implements Runnable {
    final jp a;

    js(jp jp0) {
        this.a = jp0;
        super();
    }

    @Override
    public void run() {
        this.a.f();
    }
}

