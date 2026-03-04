package luaj;

public abstract class LuaNumber extends LuaValue {
    public static LuaValue e;

    @Override  // luaj.LuaValue
    public LuaNumber G() {
        return this;
    }

    @Override  // luaj.LuaValue
    public LuaValue H() {
        return this;
    }

    @Override  // luaj.LuaValue
    public boolean I() {
        return true;
    }

    @Override  // luaj.LuaValue
    public boolean J() {
        return true;
    }

    @Override  // luaj.LuaValue
    public LuaValue a(LuaNumber luaNumber0) {
        return this.t().b(luaNumber0.t());
    }

    @Override  // luaj.LuaValue
    public LuaNumber b(String s) {
        return this;
    }

    @Override  // luaj.LuaValue
    public LuaValue b(LuaString luaString0) {
        return this.t().b(luaString0);
    }

    @Override  // luaj.LuaValue
    public int c(LuaString luaString0) {
        String s = luaString0.toString();
        if(s.length() > 50) {
            s = s.substring(0, 50) + "...";
        }
        throw new o("attempt to compare number with string (" + this + " with \'" + s + "\')");
    }

    @Override  // luaj.LuaValue
    public int e_() {
        return 3;
    }

    @Override  // luaj.LuaValue
    public String f_() {
        return "number";
    }

    @Override  // luaj.LuaValue
    public LuaValue i() {
        return LuaNumber.e;
    }

    @Override  // luaj.LuaValue
    public LuaValue u(LuaValue luaValue0) {
        return luaValue0.a(this);
    }
}

