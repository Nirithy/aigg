package android.ext;

import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;
import luaj.lib.VarArgFunction;

final class Script.wrap extends VarArgFunction {
    final LuaValue a;
    final String b;
    final int c;
    final Script d;

    Script.wrap(Script script0, String s, LuaValue luaValue0, int v) {
        this.d = script0;
        super();
        this.a = luaValue0;
        this.b = s;
        this.c = v;
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        long v;
        Script.DebugLog script$DebugLog0 = Script.r;
        Writer writer0 = script$DebugLog0 == null ? null : script$DebugLog0.a;
        if(writer0 != null) {
            try {
                v = System.nanoTime();
                writer0.write(this.b);
                writer0.write("(");
                int v1 = ap0.j_();
                int v2 = this.c >= 0 && v1 > this.c ? this.c : v1;
                for(int v3 = 1; v3 <= v2; ++v3) {
                    if(v3 != 1) {
                        writer0.write(", ");
                    }
                    Script.ApiFunction.a(null, writer0, v3, ap0.c(v3));
                }
                writer0.write(")\n");
            }
            catch(Throwable throwable0) {
                la.b(("Failed write log for " + this.b), throwable0);
            }
            script$DebugLog0.b.d = (int)(((long)script$DebugLog0.b.d) + (System.nanoTime() - v) / 1000000L);
        }
        return this.a.a_(ap0);
    }

    @Override  // luaj.lib.LibFunction
    public String d_() {
        return this.a.d_();
    }
}

