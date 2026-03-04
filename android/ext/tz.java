package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.fix.j;

class tz implements DialogInterface.OnClickListener {
    private final j a;

    tz(j j0) {
        this.a = j0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        la.a("Un: no");
        ty.a(this.a);
    }
}

