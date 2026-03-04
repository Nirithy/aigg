package android.lang;

class p implements Runnable {
    final UNIXProcess a;

    p(UNIXProcess uNIXProcess0) {
        this.a = uNIXProcess0;
        super();
    }

    @Override
    public void run() {
        int v = this.a.pid;
        int v1 = this.a.waitForProcessExit(v);
        this.a.b(v1);
    }
}

