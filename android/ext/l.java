package android.ext;

import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;

class l implements DialogInterface.OnDismissListener {
    private final Runnable a;

    l(Runnable runnable0) {
        this.a = runnable0;
        super();
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        la.a((this.a + ": 40_"));
        rx.a().postDelayed(this.a, 5000L);
    }
}

