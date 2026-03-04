package android.ext;

import android.util.SparseBooleanArray;
import android.view.View;

public class ic extends pj {
    static final SparseBooleanArray a;

    static {
        ic.a = new SparseBooleanArray();
    }

    public ic(MainService mainService0) {
        super(0x7F070090, 0x7F020024);  // string:filter "Filter"
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        new id(this, null).onClick(view0);
    }
}

