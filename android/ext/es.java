package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class es implements DialogInterface.OnClickListener {
    final eo a;
    private final String b;
    private final DialogInterface.OnClickListener c;

    es(eo eo0, String s, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.a = eo0;
        this.b = s;
        this.c = dialogInterface$OnClickListener0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.a(this.b, this.c);
    }
}

