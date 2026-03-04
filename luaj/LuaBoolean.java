package luaj;

public final class LuaBoolean extends LuaValue {
    public static LuaValue a;
    public final boolean b;

    LuaBoolean(boolean z) {
        this.b = z;
    }

    @Override  // luaj.LuaValue
    public boolean a(boolean z) {
        return this.b;
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public String d_() {
        return this.b ? "true" : "false";
    }

    @Override  // luaj.LuaValue
    public int e_() {
        return 1;
    }

    @Override  // luaj.LuaValue
    public String f_() {
        return "boolean";
    }

    @Override  // luaj.LuaValue
    public boolean h() {
        return this.b;
    }

    @Override  // luaj.LuaValue
    public LuaValue i() {
        return LuaBoolean.a;
    }

    @Override  // luaj.LuaValue
    public boolean i_() {
        return this.b;
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public LuaValue k_() {
        return this.b ? LuaBoolean.w : LuaValue.v;
    }

    @Override  // luaj.LuaValue
    public boolean n_() {
        return true;
    }
}

