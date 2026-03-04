package android.ext;

import android.view.View;

class oa extends pj {
    final MainService a;

    oa(MainService mainService0, int v, int v1) {
        this.a = mainService0;
        super(v, v1);
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        Tools.a(0x7F070119);  // string:speedhack_open "You can open speedhack by long pressing on the floating __app_name__ 
                              // icon."
        this.a.g();
        this.a.onLongClick(null);
    }
}

