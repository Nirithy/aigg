package luaj.lib;

import luaj.ap;

final class BaseLib.ipairs extends VarArgFunction {
    BaseLib.inext a;

    BaseLib.ipairs() {
        this.a = new BaseLib.inext();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        return BaseLib.ipairs.a(this.a, ap0.t(1), BaseLib.ipairs.y);
    }
}

