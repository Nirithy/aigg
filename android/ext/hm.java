package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class hm implements DialogInterface.OnClickListener {
    final hk a;

    hm(hk hk0) {
        this.a = hk0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.b = v;
        this.a.b(null);
    }
}

