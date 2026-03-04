package android.ext;

import android.view.View;

class te implements Runnable {
    private final View a;

    te(View view0) {
        this.a = view0;
        super();
    }

    @Override
    public void run() {
        try {
            MainService.instance.n.removeView(this.a);
        }
        catch(Throwable throwable0) {
            la.c(("Failed removeView: " + this.a), throwable0);
        }
    }
}

