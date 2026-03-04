package android.fix;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface;

class c implements DialogInterface.OnCancelListener {
    final a a;

    c(a a0) {
        this.a = a0;
        super();
    }

    @Override  // android.content.DialogInterface$OnCancelListener
    public void onCancel(DialogInterface dialogInterface0) {
        this.a.l();
    }
}

