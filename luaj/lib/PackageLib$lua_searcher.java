package luaj.lib;

import luaj.LuaString;
import luaj.LuaValue;
import luaj.ap;

public class PackageLib.lua_searcher extends VarArgFunction {
    final PackageLib a;

    public PackageLib.lua_searcher(PackageLib packageLib0) {
        this.a = packageLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaString luaString0 = ap0.s(1);
        LuaValue luaValue0 = this.a.h.w(PackageLib.d);
        if(!luaValue0.J()) {
            return PackageLib.lua_searcher.m("\n\tpackage.path is not a string");
        }
        ap ap1 = this.a.h.w(PackageLib.e).a_(PackageLib.lua_searcher.b(luaString0, luaValue0));
        if(!ap1.i(1)) {
            return ap1.c(2).u();
        }
        LuaString luaString1 = ap1.g().t();
        String s = luaString1.d_();
        this.a.g.i.a(null, s, true, null);
        LuaValue luaValue1 = this.a.g.c_(s);
        return luaValue1.g().B() ? LuaValue.b(luaValue1.g(), luaString1) : PackageLib.lua_searcher.b(PackageLib.lua_searcher.u, PackageLib.lua_searcher.m(("\'" + luaString1 + "\': " + luaValue1.c(2).d_())));
    }
}

