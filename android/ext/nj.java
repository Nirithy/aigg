package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class nj implements DialogInterface.OnClickListener {
    final MainService a;

    nj(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        ConfigListAdapter.a(null);
    }
}

