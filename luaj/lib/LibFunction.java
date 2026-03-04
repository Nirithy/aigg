package luaj.lib;

import luaj.LuaFunction;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;

public abstract class LibFunction extends LuaFunction {
    protected int aj;
    protected String ak;

    @Override  // luaj.LuaValue
    public LuaValue a(LuaValue luaValue0) {
        return this.l();
    }

    @Override  // luaj.LuaValue
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return this.a(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        return this.a(luaValue0, luaValue1);
    }

    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2, LuaValue luaValue3) {
        return this.a(luaValue0, luaValue1, luaValue2);
    }

    protected void a(LuaValue luaValue0, Class class0, String[] arr_s) {
        this.a(luaValue0, class0, arr_s, 0);
    }

    protected void a(LuaValue luaValue0, Class class0, String[] arr_s, int v) {
        try {
            for(int v1 = 0; true; ++v1) {
                if(v1 >= arr_s.length) {
                    return;
                }
                LibFunction libFunction0 = (LibFunction)class0.newInstance();
                libFunction0.aj = v + v1;
                libFunction0.ak = arr_s[v1];
                luaValue0.a(libFunction0.ak, libFunction0);
            }
        }
        catch(Exception exception0) {
            throw new o("bind failed: " + exception0);
        }
    }

    @Override  // luaj.LuaValue
    public ap a_(ap ap0) {
        switch(ap0.j_()) {
            case 0: {
                return this.l();
            }
            case 1: {
                return this.a(ap0.g());
            }
            case 2: {
                return this.a(ap0.g(), ap0.c(2));
            }
            case 3: {
                return this.a(ap0.g(), ap0.c(2), ap0.c(3));
            }
            default: {
                return this.a(ap0.g(), ap0.c(2), ap0.c(3), ap0.c(4));
            }
        }
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaFunction
    public String d_() {
        return this.ak == null ? "function: LuaFunction" : "function: " + this.ak;
    }

    @Override  // luaj.LuaValue
    public LuaValue l() {
        return LibFunction.a(1, "value expected");
    }
}

