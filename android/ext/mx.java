package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class mx implements DialogInterface.OnClickListener {
    final MainService a;

    mx(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.p();
    }
}

