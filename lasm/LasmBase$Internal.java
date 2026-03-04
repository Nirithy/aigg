package lasm;

import luaj.LuaValue;

class LasmBase.Internal extends LuaValue {
    int a;
    i b;

    LasmBase.Internal(i i0, int v) {
        this.b = i0;
        this.a = v;
    }

    @Override  // luaj.LuaValue
    public int e_() {
        return this.a;
    }

    @Override  // luaj.LuaValue
    public String f_() {
        return null;
    }
}

