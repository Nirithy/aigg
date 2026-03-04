package android.ext;

class Script.toast.1 implements Runnable {
    final Script.toast a;
    private final String b;
    private final boolean c;

    Script.toast.1(Script.toast script$toast0, String s, boolean z) {
        this.a = script$toast0;
        this.b = s;
        this.c = z;
        super();
    }

    @Override
    public void run() {
        Tools.a(qk.a(this.b), (this.c ? 0 : 1));
    }
}

