package android.ext;

class Script.setValues.1 implements Runnable {
    final Script.setValues a;
    private final Object b;

    Script.setValues.1(Script.setValues script$setValues0, Object object0) {
        this.a = script$setValues0;
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

