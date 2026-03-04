package android.ext;

import android.widget.TextView;

class qj implements Runnable {
    final qi a;
    private final TextView b;

    qj(qi qi0, TextView textView0) {
        this.a = qi0;
        this.b = textView0;
        super();
    }

    @Override
    public void run() {
        if(this.b.getTag() == this.a.a) {
            qh qh0 = this.a.a;
            Tools.a(this.b, qh0.e, 0x30);
        }
    }
}

