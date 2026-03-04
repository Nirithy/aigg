package android.ext;

import android.widget.Toast;

class si implements Runnable {
    private final Toast a;

    si(Toast toast0) {
        this.a = toast0;
        super();
    }

    @Override
    public void run() {
        sf.e(this.a);
    }
}

