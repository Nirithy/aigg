package luaj;

import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;

class i implements DialogInterface.OnDismissListener {
    final g a;
    private final j b;

    i(g g0, j j0) {
        this.a = g0;
        this.b = j0;
        super();
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        synchronized(this.b) {
            this.b.notify();
        }
    }
}

