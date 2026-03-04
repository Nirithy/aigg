package android.ext;

import android.content.Context;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.DialogInterface;
import android.fix.j;
import android.os.Build.VERSION;
import android.util.AttributeSet;

public class MultiChoiceButton extends SystemSpinner implements DialogInterface.OnMultiChoiceClickListener {
    protected int a;

    public MultiChoiceButton(Context context0) {
        super(context0);
    }

    public MultiChoiceButton(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public MultiChoiceButton(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // android.ext.SystemSpinner
    protected void a() {
        j j0 = this.d;
        int v = j0.size();
        CharSequence[] arr_charSequence = new CharSequence[v];
        boolean[] arr_z = new boolean[arr_charSequence.length];
        this.a = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = j0.keyAt(v - 1 - v1);
            arr_charSequence[v1] = (CharSequence)j0.valueAt(v - 1 - v1);
            boolean z = (this.b & v2) != 0;
            arr_z[v1] = z;
            this.onClick(null, v1, z);
        }
        i.a(i.a(Tools.f(this.getContext())).setMultiChoiceItems(arr_charSequence, arr_z, this).setNegativeButton(qk.a(0x7F0700A1), null).setNeutralButton(qk.a(0x7F07023E), this).setPositiveButton(qk.a(0x7F07009D), this));  // string:cancel "Cancel"
    }

    @Override  // android.ext.SystemSpinner
    public void onClick(DialogInterface dialogInterface0, int v) {
        int v3;
        int v1 = this.d.size();
        if(v == -1) {
            v3 = 0;
            for(int v2 = 0; v2 < v1; ++v2) {
                if((this.a & 1 << v2) != 0) {
                    v3 |= this.d.keyAt(v1 - 1 - v2);
                }
            }
        }
        else {
            v3 = 0;
        }
        this.setSelected(v3);
        Tools.a(dialogInterface0);
    }

    @Override  // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(DialogInterface dialogInterface0, int v, boolean z) {
        if(z) {
            this.a |= 1 << v;
            return;
        }
        this.a &= ~(1 << v);
    }

    @Override  // android.ext.SystemSpinner
    public void setSelected(int v) {
        j j0 = this.d;
        if(j0 != null) {
            int v1 = j0.size();
            bp bp0 = new bp();
            for(int v2 = 0; v2 < v1; ++v2) {
                if((j0.keyAt(v1 - 1 - v2) & v) != 0) {
                    if(bp0.b() != 0) {
                        bp0.a(",");
                    }
                    CharSequence charSequence0 = (CharSequence)j0.valueAt(v1 - 1 - v2);
                    bp0.a(charSequence0.subSequence(0, charSequence0.toString().indexOf(58)));
                }
            }
            if(Build.VERSION.SDK_INT < 11) {
                Tools.a(this, Tools.b(0x7F020002));  // drawable:btn_default_normal_holo_dark
            }
            this.setText(bp0.a());
            this.b = v;
            if(this.c != null) {
                this.c.onClick(null, v);
            }
        }
    }
}

