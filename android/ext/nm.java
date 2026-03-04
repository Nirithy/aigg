package android.ext;

class nm implements Runnable {
    final nl a;
    private final String b;

    nm(nl nl0, String s) {
        this.a = nl0;
        this.b = s;
        super();
    }

    @Override
    public void run() {
        this.a.a.j.a(true, this.b);
    }
}

