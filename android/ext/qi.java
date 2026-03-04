package android.ext;

import android.widget.TextView;

class qi implements Runnable {
    final qh a;
    private final TextView b;

    qi(qh qh0, TextView textView0) {
        this.a = qh0;
        this.b = textView0;
        super();
    }

    @Override
    public void run() {
        this.a.b();
        if(this.a.e != null) {
            rx.a(new qj(this, this.b));
        }
    }
}

