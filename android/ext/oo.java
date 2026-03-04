package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface;

class oo implements Runnable {
    final om a;
    private final DialogInterface b;

    oo(om om0, DialogInterface dialogInterface0) {
        this.a = om0;
        this.b = dialogInterface0;
        super();
    }

    @Override
    public void run() {
        i.c(((AlertDialog)this.b));
    }
}

