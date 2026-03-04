package android.ext;

class Script.removeResults.1 implements Runnable {
    final Script.removeResults a;
    private final Object b;

    Script.removeResults.1(Script.removeResults script$removeResults0, Object object0) {
        this.a = script$removeResults0;
        this.b = object0;
        super();
    }

    @Override
    public void run() {
        MainService.instance.j(false);
        synchronized(this.b) {
            this.b.notifyAll();
        }
    }
}

