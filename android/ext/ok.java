package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ok implements DialogInterface.OnClickListener {
    final oj a;

    ok(oj oj0) {
        this.a = oj0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.a();
    }
}

