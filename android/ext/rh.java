package android.ext;

import android.content.Context;
import android.content.SharedPreferences;

public class rh {
    private Context a;

    protected rh(Context context0) {
        this.a = context0;
    }

    protected void U() {
        bj bj0 = bj.a;
        bj.e = true;
        if(bj0 != null) {
            la.a("BootstrapService stopSelf");
            bj0.stopSelf();
        }
        bi bi0 = bi.b;
        if(bi0 != null) {
            bi0.onDestroy();
        }
    }

    protected SharedPreferences a(String s, int v) {
        return this.a.getSharedPreferences(s, v);
    }

    protected Object a(String s) {
        return this.a.getSystemService(s);
    }
}

