package android.ext;

import android.view.View;

public class hy extends pj {
    static boolean a;
    static boolean b;
    static boolean c;
    static boolean d;

    static {
        hy.a = false;
        hy.b = true;
        hy.c = true;
        hy.d = true;
    }

    public hy() {
        super(0x7F070216, 0x7F02003E);  // string:execute_script "Execute script"
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        new hz(this, null).onClick(view0);
    }
}

