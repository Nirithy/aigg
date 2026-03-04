package android.ext;

import android.view.View;
import android.view.WindowManager.LayoutParams;

class bs implements Runnable {
    final bq a;
    private final View b;
    private final WindowManager.LayoutParams c;

    bs(bq bq0, View view0, WindowManager.LayoutParams windowManager$LayoutParams0) {
        this.a = bq0;
        this.b = view0;
        this.c = windowManager$LayoutParams0;
        super();
    }

    @Override
    public void run() {
        try {
            Tools.b(this.b, this.c);
        }
        catch(Throwable throwable0) {
            la.c(("Failed show test view(" + this.c.type + ", " + this.c.flags + "): " + this.b + "; " + this.c), throwable0);
        }
        synchronized(this) {
            this.notify();
        }
    }
}

