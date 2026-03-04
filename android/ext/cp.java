package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;

class cp implements DialogInterface.OnShowListener {
    final co a;
    private final AlertDialog b;

    cp(co co0, AlertDialog alertDialog0) {
        this.a = co0;
        this.b = alertDialog0;
        super();
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(this.b);
    }
}

