package luaj.lib;

import luaj.LuaBoolean;
import luaj.LuaFunction;
import luaj.LuaNil;
import luaj.LuaNumber;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaThread;
import luaj.LuaValue;

final class DebugLib.setmetatable extends TwoArgFunction {
    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        LuaTable luaTable0 = luaValue1.a(null);
        switch(luaValue0.e_()) {
            case 0: {
                LuaNil.a = luaTable0;
                return luaValue0;
            }
            case 1: {
                LuaBoolean.a = luaTable0;
                return luaValue0;
            }
            case 3: {
                LuaNumber.e = luaTable0;
                return luaValue0;
            }
            case 4: {
                LuaString.a = luaTable0;
                return luaValue0;
            }
            case 6: {
                LuaFunction.s = luaTable0;
                return luaValue0;
            }
            case 8: {
                LuaThread.a = luaTable0;
                return luaValue0;
            }
            default: {
                luaValue0.v(luaTable0);
                return luaValue0;
            }
        }
    }
}

