package android.ext;

class lj implements Runnable {
    @Override
    public void run() {
        lg.a("AndroidService", "wait 4");
        rx.a().removeCallbacks(this);
        lh.k();
    }
}

