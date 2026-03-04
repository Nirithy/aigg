package luaj;

import java.lang.ref.WeakReference;

public class WeakTable implements ah {
    private final boolean a;
    private final boolean b;
    private final LuaValue c;

    public WeakTable(boolean z, boolean z1, LuaValue luaValue0) {
        this.a = z;
        this.b = z1;
        this.c = luaValue0;
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.ah
    public LuaValue E(LuaValue luaValue0) {
        return this.b ? WeakTable.a(luaValue0) : luaValue0;
    }

    @Override  // luaj.ah
    public boolean U() {
        return this.a;
    }

    @Override  // luaj.ah
    public boolean V() {
        return this.b;
    }

    @Override  // luaj.ah
    public LuaValue W() {
        return this.c;
    }

    protected static LuaValue a(Object object0) {
        if(object0 instanceof WeakReference) {
            Object object1 = ((WeakReference)object0).get();
            return object1 instanceof WeakTable.WeakValue ? ((WeakTable.WeakValue)object1).ac() : ((LuaValue)object1);
        }
        return object0 instanceof WeakTable.WeakValue ? ((WeakTable.WeakValue)object0).ac() : ((LuaValue)object0);
    }

    protected static LuaValue a(LuaValue luaValue0) {
        switch(luaValue0.e_()) {
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return new WeakTable.WeakValue(luaValue0);
            }
            default: {
                return luaValue0;
            }
        }
    }

    @Override  // luaj.ah
    public LuaValue a(LuaValue[] arr_luaValue, int v) {
        LuaValue luaValue0 = arr_luaValue[v];
        if(luaValue0 != null) {
            luaValue0 = WeakTable.a(luaValue0);
            if(luaValue0 == null) {
                arr_luaValue[v] = null;
            }
        }
        return luaValue0;
    }

    @Override  // luaj.ah
    public ad e(LuaValue luaValue0, LuaValue luaValue1) {
        LuaValue luaValue2 = luaValue1.ac();
        if(luaValue2 == null) {
            return null;
        }
        if(this.a && !luaValue0.I() && !luaValue0.J() && !luaValue0.n_()) {
            return this.b && !luaValue2.I() && !luaValue2.J() && !luaValue2.n_() ? new at(luaValue0, luaValue2, null) : new au(luaValue0, luaValue2, null);
        }
        return this.b && !luaValue2.I() && !luaValue2.J() && !luaValue2.n_() ? new aw(luaValue0, luaValue2, null) : LuaTable.f(luaValue0, luaValue2);
    }
}

