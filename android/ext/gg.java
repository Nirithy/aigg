package android.ext;

class gg implements Runnable {
    final ex a;

    gg(ex ex0) {
        this.a = ex0;
        super();
    }

    @Override
    public void run() {
        MainService.instance.a(MainService.instance.S);
    }
}

