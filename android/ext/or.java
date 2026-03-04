package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class or implements DialogInterface.OnClickListener {
    final op a;
    private final g b;

    or(op op0, g g0) {
        this.a = op0;
        this.b = g0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.b.c();
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            qm0.write("if revert ~= nil then gg.setValues(revert) end\n");
        }
    }
}

