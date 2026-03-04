package android.ext;

class au implements Runnable {
    @Override
    public void run() {
        MainService.instance.d();
    }
}

