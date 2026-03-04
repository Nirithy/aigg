package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class my implements DialogInterface.OnClickListener {
    final MainService a;

    my(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.q();
    }
}

