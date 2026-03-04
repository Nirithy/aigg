package luaj.lib;

import java.util.Locale;
import luaj.LuaValue;

final class StringLib.upper extends OneArgFunction {
    @Override  // luaj.lib.OneArgFunction
    public LuaValue a(LuaValue luaValue0) {
        return StringLib.upper.m(luaValue0.y().toUpperCase(Locale.US));
    }
}

