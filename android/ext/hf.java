package android.ext;

import android.view.View;

class hf extends ku {
    final he a;

    hf(he he0) {
        this.a = he0;
        super();
    }

    @Override  // android.ext.ku
    protected boolean a(View view0, boolean z) {
        return this.a.n() || view0 == this.a.a;
    }
}

