package luaj.lib;

import android.ext.ts;
import luaj.LuaValue;
import luaj.ap;

final class StringLib.packsize extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        String s = ap0.r(1);
        m m0 = new m(s);
        int v = s.length();
        int v1 = 0;
        while(m0.e < v) {
            int v2 = StringLib.a(m0, v1);
            int v3 = m0.h + m0.i;
            this.a(v1 <= 0x7FFFFFFF - v3, 1, "format result too large at pos " + m0.e);
            v1 += v3;
            if(v2 == 5 || v2 == 6) {
                StringLib.packsize.a(1, ts.a("variable-length format option \'%c\' at pos %d", new Object[]{Character.valueOf(m0.f), m0.e}));
            }
        }
        return LuaValue.d(v1);
    }
}

