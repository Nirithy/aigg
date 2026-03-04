package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.widget.Button;

class ds implements DialogInterface.OnClickListener {
    private final View.OnClickListener a;
    private final AlertDialog b;

    ds(View.OnClickListener view$OnClickListener0, AlertDialog alertDialog0) {
        this.a = view$OnClickListener0;
        this.b = alertDialog0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Button button0 = this.b.getButton(-1);
        this.a.onClick(button0);
    }
}

