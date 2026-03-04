package luaj.lib;

import luaj.LuaValue;

class TableLibFunction extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue l() {
        return TableLibFunction.a(1, "table expected, got no value");
    }
}

