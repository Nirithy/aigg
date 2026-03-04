package android.ext;

import luaj.o;

public final class Script.OsExit extends o {
    final int a;

    public Script.OsExit(int v) {
        super("called os.exit(" + v + ')');
        this.a = v;
    }
}

