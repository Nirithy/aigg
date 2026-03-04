package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.i;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class cw extends ct implements DialogInterface.OnShowListener, View.OnClickListener {
    int k;
    int l;
    long m;
    private WeakReference n;
    private WeakReference o;
    private boolean p;
    private boolean q;
    private int r;

    public cw(int v, int v1, int v2, int v3, long v4, int v5, String s, boolean z) {
        super(v, v1, v5, s, z);
        this.n = new WeakReference(null);
        this.o = new WeakReference(null);
        this.p = false;
        this.q = true;
        this.r = 8;
        this.k = v2;
        this.l = v3;
        this.m = v4;
    }

    public cw(int v, int v1, int v2, int v3, long v4, int v5, String s, boolean z, int v6) {
        this(v, v1, v2, v3, v4, v5, s, z);
        this.h = v6;
    }

    public cw(int v, int v1, int v2, int v3, long v4, int v5, String s, boolean z, boolean z1, boolean z2) {
        this(v, v1, v2, v3, v4, v5, s, z);
        this.p = z1;
        this.q = z2;
    }

    public cw(int v, int v1, int v2, int v3, long v4, int v5, String s, boolean z, boolean z1, boolean z2, int v6) {
        this(v, v1, v2, v3, v4, v5, s, z, z1, z2);
        this.r = v6;
    }

    @Override  // android.ext.ct
    public boolean a(DialogInterface dialogInterface0, int v) {
        EditText editText0 = (EditText)this.o.get();
        if(editText0 == null) {
            return false;
        }
        try {
            String s = re.c(editText0.getText().toString().trim());
            pv pv0 = ps.i(s);
            long v1 = (long)this.l;
            long v2 = this.m;
            if(!this.e && (pv0.a < v1 || pv0.a > v2)) {
                throw new NumberFormatException(Tools.a(qk.a(0x7F070122), new Object[]{s}) + Tools.a(" [%,d, %,d]", new Object[]{v1, v2}));  // string:number_out_of_range "Number \'__s__\' out of possible range:"
            }
            iw.a(s, this.r);
            if(this.e) {
                this.d = (int)pv0.a;
                this.f = (int)(pv0.a >> 0x20);
            }
            else {
                this.d = Math.max(((int)Math.min(pv0.a, this.m)), this.l);
            }
            Config.c();
            Tools.b(this.n);
            return true;
        }
        catch(NumberFormatException numberFormatException0) {
            re.a(numberFormatException0, editText0);
            return false;
        }
    }

    protected void b() {
        View view0 = i.a(0x7F04000E, null);  // layout:option_edit
        TextView textView0 = (TextView)view0.findViewById(0x7F0B000E);  // id:message
        textView0.setText(qk.a(this.a));
        if(this.h != -1 && this.h != 0) {
            Tools.j(textView0);
            textView0.setOnClickListener(new cx(this));
        }
        ((TextView)view0.findViewById(0x7F0B002C)).setText(Tools.a(qk.a(0x7F0700CE), new Object[]{Tools.a("%,d", new Object[]{((long)(this.e ? 0x8000000000000000L : ((long)this.l)))}), Tools.a("%,d", new Object[]{((long)(this.e ? 0x7FFFFFFFFFFFFFFFL : this.m))})}));  // id:hint
        ((TextView)view0.findViewById(0x7F0B004E)).setText(this.f());  // id:unit
        TextView textView1 = (TextView)view0.findViewById(0x7F0B002D);  // id:default_
        textView1.setText(Tools.c(0x7F07023D) + ": " + Tools.a("%,d", new Object[]{this.b}));  // string:default_ "Default:"
        textView1.setOnClickListener(this);
        EditText editText0 = (EditText)view0.findViewById(0x7F0B004D);  // id:number
        editText0.setText(Tools.a("%,d", new Object[]{((long)(this.e ? this.e() : ((long)this.d)))}));
        editText0.setDataType(this.r);
        this.o = new WeakReference(editText0);
        HexConverter hexConverter0 = (HexConverter)view0.findViewById(0x7F0B0042);  // id:number_converter
        hexConverter0.setTag(new Object[]{editText0, 4});
        hexConverter0.setVisibility((this.p ? 0 : 8));
        hexConverter0.setUseXor(this.q);
        AlertDialog alertDialog0 = android.ext.i.c().setView(InternalKeyboard.a(view0)).setPositiveButton(0x7F07009D, this).setNegativeButton(0x7F0700A1, null).create();  // string:ok "OK"
        android.ext.i.a(alertDialog0, this);
        this.n = new WeakReference(alertDialog0);
        android.ext.i.a(alertDialog0, editText0);
    }

    @Override  // android.ext.ct
    public void d() {
        this.b();
    }

    private String f() {
        return this.k == 0 ? "" : qk.a(this.k);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 != null && view0.getId() == 0x7F0B002D) {  // id:default_
            EditText editText0 = (EditText)this.o.get();
            if(editText0 != null) {
                editText0.setText(Tools.a("%,d", new Object[]{this.b}));
            }
            return;
        }
        this.onClick(((DialogInterface)this.n.get()), -1);
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this, ((EditText)this.o.get()));
    }

    @Override  // android.ext.ct
    public String toString() {
        return qk.a(this.a) + ' ' + Tools.a("%,d", new Object[]{this.d}) + ' ' + this.f();
    }
}

