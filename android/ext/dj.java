package android.ext;

class dj implements Runnable {
    final dh a;

    dj(dh dh0) {
        this.a = dh0;
        super();
    }

    @Override
    public void run() {
        MainService.instance.k.e();
    }
}

