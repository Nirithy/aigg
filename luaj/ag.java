package luaj;

public class ag implements Runnable {
    public final LuaValue a;
    ap b;
    ap c;
    String d;
    public LuaFunction e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    private final Globals o;

    ag(Globals globals0, LuaThread luaThread0, LuaValue luaValue0) {
        this.b = LuaValue.x;
        this.c = LuaValue.x;
        this.d = null;
        this.n = 0;
        this.o = globals0;
        this.a = luaValue0;
    }

    @Override
    public void run() {
        synchronized(this) {
            try {
                ap ap0 = this.b;
                this.b = LuaValue.x;
                this.c = this.a.a_(ap0);
            }
            catch(Throwable throwable0) {
                try {
                    this.d = throwable0.getMessage();
                }
                catch(Throwable throwable1) {
                    this.n = 4;
                    this.notify();
                    throw throwable1;
                }
            }
        }
        this.n = 4;
        this.notify();
    }
}

