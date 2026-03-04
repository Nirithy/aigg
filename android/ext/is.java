package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.text.Editable;
import java.util.ArrayList;

class is implements DialogInterface.OnClickListener {
    final HexConverter a;
    private final ArrayList b;
    private final EditText c;
    private final int d;
    private final int e;
    private final Editable f;
    private final long g;

    is(HexConverter hexConverter0, ArrayList arrayList0, EditText editText0, int v, int v1, Editable editable0, long v2) {
        this.a = hexConverter0;
        this.b = arrayList0;
        this.c = editText0;
        this.d = v;
        this.e = v1;
        this.f = editable0;
        this.g = v2;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            if(v >= 0 && v < this.b.size()) {
                String s = (String)this.b.get(v);
                if(s == null) {
                    ct ct0 = Config.a(0x7F0B00BB);  // id:config_xor_key
                    ct0.a(new it(this, ct0, this.g, this.c, this.d, this.e, this.f));
                    ct0.d();
                }
                else {
                    try {
                        this.c.setSelection(this.d, this.e);
                        this.f.replace(this.d, this.e, s);
                    }
                    catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                        la.b("Failed replace text", indexOutOfBoundsException0);
                        this.c.setText(s);
                    }
                }
            }
            this.c.requestFocus();
        }
        catch(Throwable throwable0) {
            la.a(("HexConverter failed with " + v), throwable0);
        }
    }
}

