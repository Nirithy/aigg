package android.ext;

import android.content.DialogInterface;

public class cz extends ct {
    int[] l;
    CharSequence[] m;
    int[] n;

    public cz(int v, int v1, int[] arr_v, int v2, String s, boolean z) {
        super(v, v1, v2, s, z);
        this.m = null;
        this.n = null;
        this.l = arr_v;
    }

    public cz(int v, int v1, int[] arr_v, int v2, String s, boolean z, int v3) {
        this(v, v1, arr_v, v2, s, z);
        this.h = v3;
    }

    public int a(int v) {
        this.b();
        if(this.n == null) {
            return v;
        }
        int v1;
        for(v1 = 1; true; ++v1) {
            if(v1 >= this.n.length) {
                return 0;
            }
            if(this.n[v1] == v) {
                break;
            }
        }
        return v1;
    }

    protected void a(CharSequence[] arr_charSequence) {
        int v = this.a(this.b);
        CharSequence[] arr_charSequence1 = new CharSequence[arr_charSequence.length];
        for(int v1 = 0; v1 < arr_charSequence.length; ++v1) {
            CharSequence charSequence0 = v1 != v || arr_charSequence[v1] == null ? arr_charSequence[v1] : arr_charSequence[v1] + " (" + qk.a(0x7F07023C) + ')';  // string:default_mark "default"
            arr_charSequence1[v1] = charSequence0;
        }
        i.a(i.c().setCustomTitle(Config.a(this.a, this.h, this.g)).setSingleChoiceItems(arr_charSequence1, this.a(this.d), this));
    }

    @Override  // android.ext.ct
    public boolean a(DialogInterface dialogInterface0, int v) {
        this.d = this.b(v);
        Config.c();
        Tools.a(dialogInterface0);
        return true;
    }

    public int b(int v) {
        this.b();
        return this.n == null ? v : this.n[v];
    }

    protected void b() {
    }

    @Override  // android.ext.ct
    public void d() {
        this.b();
        CharSequence[] arr_charSequence = this.m;
        if(this.l != null) {
            CharSequence[] arr_charSequence1 = new CharSequence[this.l.length];
            for(int v = 0; v < this.l.length; ++v) {
                arr_charSequence1[v] = qk.a(this.l[v]);
            }
            arr_charSequence = arr_charSequence1;
        }
        this.a(arr_charSequence);
    }

    @Override  // android.ext.ct
    public String toString() {
        CharSequence charSequence0 = null;
        try {
            int v = this.a(this.d);
            charSequence0 = this.l == null ? this.m[v] : qk.a(this.l[v]);
        }
        catch(IndexOutOfBoundsException unused_ex) {
        }
        if(charSequence0 == null) {
            charSequence0 = "int:" + this.d;
        }
        return Tools.c(this.a) + ": " + charSequence0;
    }
}

