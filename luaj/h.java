package luaj;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class h implements DialogInterface.OnClickListener {
    final g a;
    private final j b;

    h(g g0, j j0) {
        this.a = g0;
        this.b = j0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.b.a = null;
    }
}

