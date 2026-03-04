package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

public class PackageLib.java_searcher extends VarArgFunction {
    final PackageLib a;

    public PackageLib.java_searcher(PackageLib packageLib0) {
        this.a = packageLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        String s = PackageLib.c(ap0.r(1));
        try {
            LuaValue luaValue0 = (LuaValue)Class.forName(s).newInstance();
            boolean z = !luaValue0.B();
            return PackageLib.java_searcher.b(luaValue0, this.a.g);
        }
        catch(ClassNotFoundException unused_ex) {
            return PackageLib.java_searcher.m(("\n\tno class \'" + s + '\''));
        }
        catch(Exception exception0) {
            return PackageLib.java_searcher.m(("\n\tjava load failed on \'" + s + "\', " + exception0));
        }
    }
}

