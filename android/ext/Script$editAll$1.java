package android.ext;

class Script.editAll.1 implements Runnable {
    final Script.editAll a;
    private final Object b;

    Script.editAll.1(Script.editAll script$editAll0, Object object0) {
        this.a = script$editAll0;
        this.b = object0;
        super();
    }

    @Override
    public void run() {
        MainService.instance.e(this.a.d.a());
        synchronized(this.b) {
            this.b.notifyAll();
        }
    }
}

