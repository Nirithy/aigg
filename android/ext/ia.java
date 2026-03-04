package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ia implements DialogInterface.OnClickListener {
    final hz a;
    private final int b;

    ia(hz hz0, int v) {
        this.a = hz0;
        this.b = v;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        MainService.instance.p();
        this.a.onClick(null, this.b);
    }
}

