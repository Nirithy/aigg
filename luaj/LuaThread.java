package luaj;

public class LuaThread extends LuaValue {
    public static LuaValue a;
    public static int b;
    public static final String[] c;
    public final ag d;
    public Object e;
    public final Globals f;
    public LuaValue g;

    static {
        LuaThread.b = 0;
        LuaThread.c = new String[]{"suspended", "suspended", "running", "normal", "dead"};
    }

    public LuaThread(Globals globals0) {
        this.d = new ag(globals0, this, null);
        this.d.n = 2;
        this.f = globals0;
    }

    @Override  // luaj.LuaValue
    public LuaThread R() {
        return this;
    }

    @Override  // luaj.LuaValue
    public int e_() {
        return 8;
    }

    @Override  // luaj.LuaValue
    public String f_() {
        return "thread";
    }

    @Override  // luaj.LuaValue
    public LuaValue i() {
        return LuaThread.a;
    }

    @Override  // luaj.LuaValue
    public boolean p_() {
        return true;
    }
}

