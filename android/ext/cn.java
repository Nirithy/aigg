package android.ext;

import android.content.DialogInterface;
import java.util.Locale;

class cn extends cz {
    cn(int v, int v1, int[] arr_v, int v2, String s, boolean z) {
        super(v, v1, arr_v, v2, s, z);
    }

    private String a(String s) {
        try {
            if(s.length() == 0) {
                Locale locale0 = ad.b();
                return Tools.c(0x7F07023D) + String.format(locale0, "\n[%,.1f | %.2e]", -1234.0, -0.0);  // string:default_ "Default:"
            }
            return s + String.format(ad.a(s), "\n[%,.1f | %.2e]", -1234.0, -0.0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return s;
        }
    }

    @Override  // android.ext.ct
    protected void a() {
        if(this.d > 0) {
            String[] arr_s = this.f();
            if(this.d < arr_s.length) {
                ad.a(ad.a(arr_s[this.d]));
            }
        }
    }

    @Override  // android.ext.cz
    public boolean a(DialogInterface dialogInterface0, int v) {
        boolean z = super.a(dialogInterface0, v);
        if(z) {
            ConfigListAdapter.c();
        }
        return z;
    }

    @Override  // android.ext.cz
    protected void b() {
        super.b();
        if(this.m == null) {
            String[] arr_s = this.f();
            CharSequence[] arr_charSequence = new CharSequence[arr_s.length];
            for(int v = 0; v < arr_s.length; ++v) {
                arr_charSequence[v] = this.a(arr_s[v]);
            }
            this.m = arr_charSequence;
        }
    }

    private String[] f() {
        return new String[]{"", "en_US", "in_ID", "ru_RU"};
    }
}

