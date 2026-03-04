package android.ext;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.util.AttributeSet;

public class SystemSpinnerType extends SystemSpinner {
    e[] a;

    public SystemSpinnerType(Context context0) {
        super(context0);
    }

    public SystemSpinnerType(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public SystemSpinnerType(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // android.ext.SystemSpinner
    protected void a() {
        int v1;
        this.a = d.a(this.d, null);
        for(int v = 0; true; ++v) {
            if(v >= this.a.length) {
                v1 = 0;
            }
            else if(this.a[v].a == this.b) {
                v1 = v;
            }
            else {
                continue;
            }
            i.a(i.a(Tools.f(this.getContext())).setSingleChoiceItems(new rw(this, MainService.context, 0x1090012, 0x1020014, this.a), v1, this));
            return;
        }
    }

    @Override  // android.ext.SystemSpinner
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.setSelected(this.a[v].a);
        Tools.a(dialogInterface0);
    }

    @Override  // android.ext.SystemSpinner
    public void setSelected(int v) {
        super.setSelected(v);
        if(Build.VERSION.SDK_INT < 11) {
            Tools.a(this, Tools.b(0x7F020002));  // drawable:btn_default_normal_holo_dark
        }
        this.setTextColor(d.k(v));
    }
}

