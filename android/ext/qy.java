package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class qy implements DialogInterface.OnClickListener {
    final SavedListAdapter a;
    private final qx b;

    qy(SavedListAdapter savedListAdapter0, qx qx0) {
        this.a = savedListAdapter0;
        this.b = qx0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.b(this.b);
    }
}

