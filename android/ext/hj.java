package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class hj implements DialogInterface.OnClickListener {
    final he a;

    hj(he he0) {
        this.a = he0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.e.setVisibility((v == 3 ? 0 : 8));
    }
}

