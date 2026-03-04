package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ht implements DialogInterface.OnClickListener {
    private final String[] a;

    ht(String[] arr_s) {
        this.a = arr_s;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            qt.a("exec setprop persist.sys.whetstone.level 0", 15);
            Tools.b(qk.a((this.a[8] + ": " + qk.a(0x7F07009D))));  // string:ok "OK"
        }
        catch(Throwable unused_ex) {
            la.b(("Failed fix " + this.a[8]));
            Tools.b(qk.a((this.a[8] + ": " + qk.a(0x7F070274))));  // string:patch_failed "Patch is not loaded."
        }
    }
}

