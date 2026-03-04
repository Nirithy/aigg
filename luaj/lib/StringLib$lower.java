package luaj.lib;

import java.util.Locale;
import luaj.LuaValue;

final class StringLib.lower extends OneArgFunction {
    @Override  // luaj.lib.OneArgFunction
    public LuaValue a(LuaValue luaValue0) {
        return StringLib.lower.m(luaValue0.y().toLowerCase(Locale.US));
    }
}

