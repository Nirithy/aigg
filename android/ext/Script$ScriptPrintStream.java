package android.ext;

import android.a.a;

class Script.ScriptPrintStream extends a {
    final boolean a;
    final Script b;

    public Script.ScriptPrintStream(Script script0, boolean z) {
        this.b = script0;
        super();
        this.a = z;
    }

    @Override  // android.a.a
    protected void a(String s) {
        this.b.a(this.a, s);
        if(this.a) {
            la.c(("script: " + s));
            return;
        }
        la.a(("script: " + s));
    }
}

