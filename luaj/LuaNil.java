package luaj;

public class LuaNil extends LuaValue {
    public static LuaValue a;

    @Override  // luaj.LuaValue
    public boolean A() {
        return false;
    }

    @Override  // luaj.LuaValue
    public boolean F() {
        return true;
    }

    @Override  // luaj.LuaValue
    public LuaFunction a(LuaFunction luaFunction0) {
        return luaFunction0;
    }

    @Override  // luaj.LuaValue
    public LuaString a(LuaString luaString0) {
        return luaString0;
    }

    @Override  // luaj.LuaValue
    public LuaTable a(LuaTable luaTable0) {
        return luaTable0;
    }

    @Override  // luaj.LuaValue
    public boolean a(boolean z) {
        return z;
    }

    @Override  // luaj.LuaValue
    public long a_(long v) {
        return v;
    }

    @Override  // luaj.LuaValue
    public double b(double f) {
        return f;
    }

    @Override  // luaj.LuaValue
    public int b_(int v) {
        return v;
    }

    @Override  // luaj.LuaValue
    public String b_(String s) {
        return s;
    }

    @Override  // luaj.LuaValue
    public String d_() {
        return "nil";
    }

    @Override  // luaj.LuaValue
    public int e_() {
        return 0;
    }

    @Override  // luaj.LuaValue
    public boolean equals(Object object0) {
        return object0 instanceof LuaNil;
    }

    @Override  // luaj.LuaValue
    public String f_() {
        return "nil";
    }

    @Override  // luaj.LuaValue
    public LuaValue i() {
        return LuaNil.a;
    }

    @Override  // luaj.LuaValue
    public boolean i_() {
        return false;
    }

    @Override  // luaj.LuaValue
    public LuaValue k_() {
        return LuaValue.v;
    }

    @Override  // luaj.LuaValue
    public LuaValue t(LuaValue luaValue0) {
        return luaValue0;
    }

    @Override  // luaj.LuaValue
    public String toString() {
        return "nil";
    }
}

