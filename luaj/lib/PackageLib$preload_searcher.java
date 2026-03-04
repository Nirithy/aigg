package luaj.lib;

import luaj.LuaString;
import luaj.LuaValue;
import luaj.ap;

public class PackageLib.preload_searcher extends VarArgFunction {
    final PackageLib a;

    public PackageLib.preload_searcher(PackageLib packageLib0) {
        this.a = packageLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaString luaString0 = ap0.s(1);
        ap ap1 = this.a.h.w(PackageLib.c).w(luaString0);
        return ((LuaValue)ap1).F() ? PackageLib.preload_searcher.m(("\n\tno field package.preload[\'" + luaString0 + "\']")) : ap1;
    }
}

