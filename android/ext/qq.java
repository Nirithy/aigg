package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class qq implements DialogInterface.OnClickListener {
    final qp a;
    private final int b;

    qq(qp qp0, int v) {
        this.a = qp0;
        this.b = v;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        MainService.instance.q();
        this.a.onClick(null, this.b);
    }
}

