package luaj.lib;

import luaj.LuaValue;

final class DebugLib.debug extends ZeroArgFunction {
    @Override  // luaj.lib.ZeroArgFunction
    public LuaValue l() {
        return DebugLib.debug.x;
    }
}

