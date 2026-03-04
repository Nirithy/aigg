package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class fl implements DialogInterface.OnClickListener {
    final ex a;

    fl(ex ex0) {
        this.a = ex0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        ConfigListAdapter.j();
    }
}

