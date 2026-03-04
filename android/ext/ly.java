package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ly implements DialogInterface.OnClickListener {
    private final long a;

    ly(long v) {
        this.a = v;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Config.c |= this.a;
        Config.c();
    }
}

