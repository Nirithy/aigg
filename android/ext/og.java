package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class og implements DialogInterface.OnClickListener {
    final of a;

    og(of of0) {
        this.a = of0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.a = v;
        this.a.b();
    }
}

