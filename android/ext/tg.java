package android.ext;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

class tg implements Runnable {
    private final Drawable a;
    private final int b;
    private final TextView c;

    tg(Drawable drawable0, int v, TextView textView0) {
        this.a = drawable0;
        this.b = v;
        this.c = textView0;
        super();
    }

    @Override
    public void run() {
        Drawable[] arr_drawable2;
        if(Tools.b == -1) {
            Tools.b = (int)(Tools.a(12.0f) + 0.5f);
        }
        if(this.a != null) {
            int v = (int)Tools.a(this.b);
            try {
                this.a.setBounds(0, 0, v, v);
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
        }
        try {
            Drawable[] arr_drawable = null;
            Object object0 = this.c.getTag(0x7F0B0050);  // id:icon
            int v1 = object0 instanceof Integer ? ((int)(((Integer)object0))) : 0;
            if(v1 == 0) {
                Drawable[] arr_drawable1 = this.c.getCompoundDrawables();
                if(Build.VERSION.SDK_INT >= 17) {
                    arr_drawable = this.c.getCompoundDrawablesRelative();
                    if(arr_drawable[0] != null) {
                        v1 = 4;
                    }
                    else if(arr_drawable1[0] != null) {
                        arr_drawable = arr_drawable1;
                        v1 = 2;
                    }
                    else if(Build.VERSION.SDK_INT < 18) {
                        arr_drawable = arr_drawable1;
                        v1 = 1;
                    }
                    else {
                        v1 = 3;
                    }
                }
                else if(arr_drawable1[0] == null) {
                    arr_drawable = arr_drawable1;
                    v1 = 1;
                }
                else {
                    arr_drawable = arr_drawable1;
                    v1 = 2;
                }
                this.c.setTag(0x7F0B0050, v1);  // id:icon
            }
            boolean z = v1 == 1 || v1 == 2;
            if(arr_drawable == null) {
                arr_drawable2 = z ? this.c.getCompoundDrawables() : this.c.getCompoundDrawablesRelative();
            }
            else {
                arr_drawable2 = arr_drawable;
            }
            arr_drawable2[(v1 != 1 && v1 != 3 ? 2 : 0)] = this.a;
            if(z) {
                this.c.setCompoundDrawables(arr_drawable2[0], arr_drawable2[1], arr_drawable2[2], arr_drawable2[3]);
            }
            else {
                this.c.setCompoundDrawablesRelative(arr_drawable2[0], arr_drawable2[1], arr_drawable2[2], arr_drawable2[3]);
            }
        }
        catch(StringIndexOutOfBoundsException stringIndexOutOfBoundsException0) {
            la.a(stringIndexOutOfBoundsException0);
        }
        this.c.setCompoundDrawablePadding(Tools.b);
    }
}

