package android.ext;

class pz implements Runnable {
    final py a;
    private final int b;

    pz(py py0, int v) {
        this.a = py0;
        this.b = v;
        super();
    }

    @Override
    public void run() {
        this.a.a.setSelection(this.b);
    }
}

