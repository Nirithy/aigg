package android.ext;

import luaj.lib.OsLib;

final class Script.OsLibSafe extends OsLib {
    final Script a;

    Script.OsLibSafe(Script script0) {
        this.a = script0;
        super();
    }

    @Override  // luaj.lib.OsLib
    protected void a(String s) {
        if(this.a.a(s, false)) {
            return;
        }
        super.a(s);
    }

    @Override  // luaj.lib.OsLib
    protected void a(String s, String s1) {
        if(this.a.a(s, false) || this.a.a(s1, false)) {
            return;
        }
        super.a(s, s1);
    }
}

