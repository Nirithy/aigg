package luaj.lib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import luaj.LuaClosure;
import luaj.LuaFunction;
import luaj.LuaString;
import luaj.a.b;
import luaj.ap;
import luaj.o;

final class StringLib.dump extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaFunction luaFunction0 = ap0.n(1);
        if(!(luaFunction0 instanceof LuaClosure)) {
            throw new o("unable to dump given function");
        }
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try {
            boolean z = ap0.a(2, false);
            boolean z1 = ap0.a(3, false);
            b.a(((LuaClosure)luaFunction0).a, byteArrayOutputStream0, z, z1);
            return LuaString.b(byteArrayOutputStream0.toByteArray());
        }
        catch(IOException iOException0) {
            return StringLib.dump.f(iOException0.getMessage());
        }
    }
}

