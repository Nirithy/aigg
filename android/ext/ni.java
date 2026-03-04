package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ni implements DialogInterface.OnClickListener {
    final MainService a;

    ni(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.d(true);
    }
}

