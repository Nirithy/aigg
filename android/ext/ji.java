package android.ext;

import android.view.View.OnLayoutChangeListener;
import android.view.View;

class ji implements View.OnLayoutChangeListener {
    final jh a;

    ji(jh jh0) {
        this.a = jh0;
        super();
    }

    @Override  // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        this.a.a.c();
    }
}

