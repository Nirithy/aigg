package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.util.SparseIntArray;
import java.util.List;

class qr implements DialogInterface.OnClickListener {
    final RegionList a;
    private final EditText b;
    private final boolean c;
    private final List d;
    private final SparseIntArray e;

    qr(RegionList regionList0, EditText editText0, boolean z, List list0, SparseIntArray sparseIntArray0) {
        this.a = regionList0;
        this.b = editText0;
        this.c = z;
        this.d = list0;
        this.e = sparseIntArray0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        long v2;
        try {
            EditText editText0 = this.b;
            if(this.c) {
                int v1 = this.e.get(v);
                v2 = ((qs)this.d.get(v1)).c - 1L;
            }
            else {
                int v3 = this.e.get(v);
                v2 = ((qs)this.d.get(v3)).b;
            }
            editText0.setText(d.b(v2, 4));
            this.b.requestFocus();
        }
        catch(Throwable throwable0) {
            la.a(("RegionList failed with " + v), throwable0);
        }
        Tools.a(dialogInterface0);
    }
}

