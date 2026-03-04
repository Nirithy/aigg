package luaj.lib;

import luaj.LuaValue;

final class DebugLib.getregistry extends ZeroArgFunction {
    final DebugLib a;

    DebugLib.getregistry(DebugLib debugLib0) {
        this.a = debugLib0;
        super();
    }

    @Override  // luaj.lib.ZeroArgFunction
    public LuaValue l() {
        return this.a.ai;
    }
}

