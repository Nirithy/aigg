package android.ext;

import android.view.View;

class gy extends ku {
    final gx a;
    private final EditTextPath b;

    gy(gx gx0, EditTextPath editTextPath0) {
        this.a = gx0;
        this.b = editTextPath0;
        super();
    }

    @Override  // android.ext.ku
    protected boolean a(View view0, boolean z) {
        return view0 == this.b;
    }
}

