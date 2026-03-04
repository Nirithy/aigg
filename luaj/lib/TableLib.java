package luaj.lib;

import luaj.LuaTable;
import luaj.LuaValue;

public class TableLib extends TwoArgFunction {
    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        LuaTable luaTable0 = new LuaTable();
        luaTable0.a("concat", new TableLib.concat());
        luaTable0.a("insert", new TableLib.insert());
        luaTable0.a("move", new TableLib.move());
        luaTable0.a("pack", new TableLib.pack());
        luaTable0.a("remove", new TableLib.remove());
        luaTable0.a("sort", new TableLib.sort());
        luaTable0.a("unpack", new TableLib.unpack());
        luaValue1.a("table", luaTable0);
        if(!luaValue1.j("package").F()) {
            luaValue1.j("package").j("loaded").a("table", luaTable0);
        }
        return TableLib.u;
    }
}

