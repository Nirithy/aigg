package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class on implements DialogInterface.OnClickListener {
    final om a;

    on(om om0) {
        this.a = om0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(this.a.a.a) {
            this.a.a.b.an.c();
        }
        else {
            this.a.a.b.h();
        }
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            qm0.write((this.a.a.a ? "\ngg.clearList()\n" : "\ngg.clearResults()\n"));
        }
    }
}

