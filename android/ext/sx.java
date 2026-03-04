package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;

class sx implements DialogInterface.OnShowListener {
    final sw a;
    private final AlertDialog b;

    sx(sw sw0, AlertDialog alertDialog0) {
        this.a = sw0;
        this.b = alertDialog0;
        super();
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(this.b);
    }
}

