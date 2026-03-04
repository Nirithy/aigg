package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.fix.j;

class ua implements DialogInterface.OnClickListener {
    private final int a;
    private final j b;

    ua(int v, j j0) {
        this.a = v;
        this.b = j0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -3) {
            new qw().a("skip-old", this.a).commit();
            return;
        }
        for(int v1 = 0; v1 < this.b.size(); ++v1) {
            ty.a(((ud)this.b.valueAt(v1)).a, null);
        }
    }
}

