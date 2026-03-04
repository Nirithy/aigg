package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class oq implements DialogInterface.OnClickListener {
    final op a;

    oq(op op0) {
        this.a = op0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.a = v;
        this.a.a();
    }
}

