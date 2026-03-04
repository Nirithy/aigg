package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.fix.j;
import android.util.SparseIntArray;

public class tu implements DialogInterface.OnClickListener {
    final e[] a;
    private final String b;
    private final DialogInterface.OnClickListener c;

    public tu(j j0, SparseIntArray sparseIntArray0, String s, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.a = d.a(j0, sparseIntArray0);
        this.b = s;
        this.c = dialogInterface$OnClickListener0;
        if(j0.size() == 1) {
            this.onClick(null, 0);
            return;
        }
        i.a(i.a(Tools.o()).setCustomTitle(Tools.i(s1)).setAdapter(new tv(this, MainService.context, this.a), this).setNegativeButton(qk.a(0x7F0700A1), null));  // string:cancel "Cancel"
    }

    public tu(j j0, String s, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this(j0, null, s, s1, dialogInterface$OnClickListener0);
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            int v1 = this.a[v].a;
            if(!"0".equals(this.b)) {
                d.a(0L, this.b, v1);
            }
            if(dialogInterface0 != null) {
                Tools.a(dialogInterface0);
            }
            this.c.onClick(dialogInterface0, v1);
        }
        catch(NumberFormatException numberFormatException0) {
            re.a(numberFormatException0, null);
        }
    }
}

