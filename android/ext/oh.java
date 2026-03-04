package android.ext;

import android.view.View;

class oh extends pj {
    final MainService a;

    public oh(MainService mainService0) {
        this.a = mainService0;
        super(0x7F070137, 0x7F020049);  // string:invert_selection "Invert selection"
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        this.a.d(2);
    }
}

