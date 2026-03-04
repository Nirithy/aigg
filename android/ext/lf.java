package android.ext;

class lf implements Runnable {
    final le a;

    lf(le le0) {
        this.a = le0;
        super();
    }

    @Override
    public void run() {
        MainService.instance.a(0, 20, null);
    }
}

