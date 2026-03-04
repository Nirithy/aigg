package android.ext;

class Script.removeListItems.1 implements Runnable {
    final Script.removeListItems a;
    private final long[] b;
    private final int c;
    private final Object d;

    Script.removeListItems.1(Script.removeListItems script$removeListItems0, long[] arr_v, int v, Object object0) {
        this.a = script$removeListItems0;
        this.b = arr_v;
        this.c = v;
        this.d = object0;
        super();
    }

    @Override
    public void run() {
        try {
            MainService.instance.an.a(this.b, this.c);
        }
        catch(Throwable throwable0) {
            la.c("Failed remove list items", throwable0);
        }
        synchronized(this.d) {
            this.d.notifyAll();
        }
    }
}

