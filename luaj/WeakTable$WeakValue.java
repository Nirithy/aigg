package luaj;

import java.lang.ref.WeakReference;

class WeakTable.WeakValue extends LuaValue {
    WeakReference a;

    protected WeakTable.WeakValue(LuaValue luaValue0) {
        this.a = new WeakReference(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue ac() {
        return (LuaValue)this.a.get();
    }

    @Override  // luaj.LuaValue
    public boolean c(LuaValue luaValue0) {
        Object object0 = this.a.get();
        return object0 != null && luaValue0.c(((LuaValue)object0));
    }

    @Override  // luaj.LuaValue
    public int e_() {
        this.b("type", "weak value");
        return 0;
    }

    @Override  // luaj.LuaValue
    public String f_() {
        this.b("typename", "weak value");
        return null;
    }

    @Override  // luaj.LuaValue
    public String toString() {
        return "weak<" + this.a.get() + '>';
    }
}

