package android.ext;

import android.view.View;

public class b extends pj {
    public b() {
        super(0x7F0702F8, 0x7F020019);  // string:change_address_type "Change address / type"
    }

    public static void a(String s) {
        new c(s).onClick(null);
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        new c(null).onClick(view0);
    }
}

