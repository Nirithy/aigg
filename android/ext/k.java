package android.ext;

import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;

class k implements DialogInterface.OnShowListener {
    private final Runnable a;

    k(Runnable runnable0) {
        this.a = runnable0;
        super();
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        la.a((this.a + ": 30_"));
        rx.a().removeCallbacks(this.a);
    }
}

