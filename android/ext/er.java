package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class er implements DialogInterface.OnClickListener {
    final eo a;
    private final String b;

    er(eo eo0, String s) {
        this.a = eo0;
        this.b = s;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            Tools.a(this.b, true);
            return;
        }
        MainService.instance.o.setCurrentTab(1);
        MainService.instance.Q.a(this.b);
    }
}

