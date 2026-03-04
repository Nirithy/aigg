package android.ext;

import android.content.DialogInterface;

public class Config.OptionMultiChoiceSh extends Config.OptionMultiChoice {
    private final int o;

    public Config.OptionMultiChoiceSh(int v, int v1, int[] arr_v, int v2, String s, boolean z, int v3) {
        super(v, v1, arr_v, v2, s, z);
        this.o = v3;
    }

    @Override  // android.ext.Config$OptionMultiChoice
    public boolean a(DialogInterface dialogInterface0, int v) {
        boolean z = super.a(dialogInterface0, v);
        if(z) {
            Tools.a(0x7F07015B);  // string:need_restart "The target app must be restarted to apply these changes."
        }
        return z;
    }

    @Override  // android.ext.cz
    protected void b() {
        super.b();
        if(this.n == null) {
            int[] arr_v = new int[this.o];
            CharSequence[] arr_charSequence = new CharSequence[arr_v.length];
            for(int v = 0; v < arr_v.length; ++v) {
                arr_v[v] = 1 << v;
                arr_charSequence[v] = Integer.toString(v + 1);
            }
            this.n = arr_v;
            this.m = arr_charSequence;
            this.l = null;
        }
    }
}

