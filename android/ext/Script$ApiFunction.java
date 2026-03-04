package android.ext;

import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.lib.VarArgFunction;

public abstract class Script.ApiFunction extends VarArgFunction {
    protected volatile Object a;
    static WeakReference b;
    static WeakReference c;
    private volatile ap d;
    private volatile Throwable e;
    private final boolean f;
    private String g;
    private static Map h;
    private static Map i;
    private static Map j;
    private static Map k;

    static {
        Script.ApiFunction.b = new WeakReference(null);
        Script.ApiFunction.c = new WeakReference(null);
        Script.ApiFunction.h = null;
        Script.ApiFunction.i = null;
        Script.ApiFunction.j = null;
        Script.ApiFunction.k = null;
    }

    public Script.ApiFunction() {
        this.f = this instanceof Script.BusyApiFunction;
        this.d = null;
        this.e = null;
        this.a = new Object();
    }

    static boolean a(Script.ApiFunction script$ApiFunction0, Writer writer0, int v, LuaValue luaValue0) {
        Map map0 = null;
        if(luaValue0 instanceof LuaString) {
            return Script.Consts.a(writer0, luaValue0.d_());
        }
        if(luaValue0 instanceof LuaTable) {
            if(script$ApiFunction0 != null && v == 1) {
                if(script$ApiFunction0 instanceof Script.removeResults || script$ApiFunction0 instanceof Script.loadResults || script$ApiFunction0 instanceof Script.getValues) {
                    map0 = Script.ApiFunction.h;
                    if(map0 == null) {
                        map0 = Script.ApiFunction.e(5);
                        Script.ApiFunction.h = map0;
                    }
                }
                else if(script$ApiFunction0 instanceof Script.setValues) {
                    map0 = Script.ApiFunction.i;
                    if(map0 == null) {
                        map0 = Script.ApiFunction.e(7);
                        Script.ApiFunction.i = map0;
                    }
                }
                else if(script$ApiFunction0 instanceof Script.getValuesRange || script$ApiFunction0 instanceof Script.removeListItems) {
                    map0 = Script.ApiFunction.j;
                    if(map0 == null) {
                        map0 = Script.ApiFunction.e(1);
                        Script.ApiFunction.j = map0;
                    }
                }
                else if(script$ApiFunction0 instanceof Script.addListItems) {
                    map0 = Script.ApiFunction.k;
                    if(map0 == null) {
                        map0 = Script.ApiFunction.e(0xFF);
                        Script.ApiFunction.k = map0;
                    }
                }
            }
            ((LuaTable)luaValue0).a(writer0, map0);
            return true;
        }
        writer0.write(luaValue0.d_());
        return true;
    }

    protected static boolean a(Writer writer0, LuaValue luaValue0) {
        return Script.Consts.a(writer0, luaValue0.q());
    }

    protected static boolean a(Writer writer0, Script.Const[] arr_script$Const, LuaValue luaValue0) {
        return Script.Consts.a(writer0, arr_script$Const, luaValue0.p());
    }

    abstract String a();

    protected void a(Writer writer0, ap ap0) {
        if(this instanceof Script.isVisible || this instanceof Script.internal1 || this instanceof Script.internal2 || this instanceof Script.sleep) {
            return;
        }
        writer0.write("gg.ApiFunction");
        writer0.write("(");
        this.b(writer0, ap0);
        writer0.write(")\n");
    }

    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        return Script.ApiFunction.a(this, writer0, v, luaValue0);
    }

    @Override  // luaj.lib.VarArgFunction
    public final ap a_(ap ap0) {
        long v4;
        long v3;
        long v2;
        long v1;
        ThreadLocal threadLocal0 = ap.ah;
        VarArgFunction varArgFunction0 = (VarArgFunction)threadLocal0.get();
        threadLocal0.set(this);
        try {
            LuaValue luaValue0 = ap0.g();
            if(luaValue0 instanceof LuaString && luaValue0.M() > 1000000) {
                ap0 = Script.ApiFunction.b(luaValue0.z().a(0, 1000000), ap0.e_(2));
            }
            Script.DebugLog script$DebugLog0 = Script.r;
            if(script$DebugLog0 != null) {
                try {
                    v1 = System.nanoTime();
                    this.a(script$DebugLog0.a, ap0);
                }
                catch(Throwable throwable0) {
                    la.b("Failed write log for gg.ApiFunction", throwable0);
                }
                script$DebugLog0.b.d = (int)((System.nanoTime() - v1) / 1000000L + ((long)script$DebugLog0.b.d));
            }
            ap ap1 = this.b(ap0);
            if((this instanceof Script.alert || this instanceof Script.prompt || this instanceof Script.choice || this instanceof Script.multiChoice) && script$DebugLog0 != null) {
                try {
                    v2 = System.nanoTime();
                    script$DebugLog0.a.write("--[[ return: ");
                    script$DebugLog0.a.write((ap1 == null ? "null" : ap1.toString()));
                    script$DebugLog0.a.write(" ]]\n");
                }
                catch(Throwable throwable1) {
                    la.b("Failed log for gg.ApiFunction", throwable1);
                }
                script$DebugLog0.b.d = (int)((System.nanoTime() - v2) / 1000000L + ((long)script$DebugLog0.b.d));
            }
            if(this instanceof Script.getResults && ap1 instanceof LuaTable && script$DebugLog0 != null) {
                try {
                    v3 = System.nanoTime();
                    script$DebugLog0.a.write("--[[ count: ");
                    String s = Integer.toString(((LuaTable)ap1).M());
                    script$DebugLog0.a.write(s);
                    script$DebugLog0.a.write(" ]]\n");
                }
                catch(Throwable throwable2) {
                    la.b("Failed log for gg.ApiFunction", throwable2);
                }
                script$DebugLog0.b.d = (int)((System.nanoTime() - v3) / 1000000L + ((long)script$DebugLog0.b.d));
            }
            if(ap1 == Script.ApiFunction.v && (this instanceof Script.searchNumber || this instanceof Script.refineNumber || this instanceof Script.startFuzzy || this instanceof Script.searchFuzzy || this instanceof Script.searchAddress || this instanceof Script.refineAddress) && script$DebugLog0 != null) {
                try {
                    v4 = System.nanoTime();
                    script$DebugLog0.a.write("--[[ found: ");
                    script$DebugLog0.a.write(Long.toString(MainService.instance.aj));
                    script$DebugLog0.a.write(" ]]\n");
                }
                catch(Throwable throwable3) {
                    la.b("Failed log for gg.ApiFunction", throwable3);
                }
                script$DebugLog0.b.d = (int)(((long)script$DebugLog0.b.d) + (System.nanoTime() - v4) / 1000000L);
            }
            return ap1;
        }
        finally {
            threadLocal0.set(varArgFunction0);
        }
    }

    private void b(Writer writer0, ap ap0) {
        int v = ap0.j_();
        int v1 = this.m_();
        if(v1 < 0 || v <= v1) {
            v1 = v;
        }
        for(int v2 = 1; v2 <= v1; ++v2) {
            if(v2 != 1) {
                writer0.write(", ");
            }
            if(!this.a(writer0, v2, ap0.c(v2))) {
                break;
            }
        }
    }

    public ap b(ap ap0) {
        this.d = null;
        this.e = null;
        Script.ApiFunction.1 script$ApiFunction$10 = new Script.ApiFunction.1(this, ap0);
        synchronized(this.a) {
            rx.a(script$ApiFunction$10);
            Script.a(this.a);
        }
        Throwable throwable0 = this.e;
        this.e = null;
        if(throwable0 != null) {
            this.d = null;
            throw throwable0 instanceof RuntimeException ? ((RuntimeException)throwable0) : new RuntimeException(throwable0);
        }
        ap ap1 = this.d;
        this.d = null;
        if(!this.f || ap1 != null) {
            return ap1;
        }
        String s = this.e();
        return s == null ? this.f() : LuaValue.m(s);
    }

    public void c(ap ap0) {
        ap ap1;
        Throwable throwable1 = null;
        try {
            ap1 = this.d(ap0);
            this.d = ap1;
        }
        catch(Throwable throwable0) {
            ap1 = null;
            this.e = throwable0;
            throwable1 = throwable0;
        }
        if(!this.f || ap1 != null || throwable1 != null) {
            synchronized(this.a) {
                this.a.notifyAll();
            }
        }
    }

    public ap d(ap ap0) {
        return LuaValue.u;
    }

    @Override  // luaj.lib.LibFunction
    public String d_() {
        String s = this.a();
        String s1 = s.replace("[", "").replace("]", "").replace(" ,", ",");
        Pattern pattern0 = (Pattern)Script.ApiFunction.b.get();
        if(pattern0 == null) {
            pattern0 = Pattern.compile(".*(\\(.*\\)).*");
            Script.ApiFunction.b = new WeakReference(pattern0);
        }
        String s2 = pattern0.matcher(s1).replaceAll("$1");
        Pattern pattern1 = (Pattern)Script.ApiFunction.c.get();
        if(pattern1 == null) {
            pattern1 = Pattern.compile("(?<=[\\(,])( ?)\\s*\\S*\\s*(\\S*)(\\s*=\\s*[^,\\)]*)?(?=[,\\)])");
            Script.ApiFunction.c = new WeakReference(pattern1);
        }
        return "function " + pattern1.matcher(s2).replaceAll("$1$2") + " end, -- " + s;
    }

    private static Map e(int v) {
        Map map0 = new HashMap();
        for(int v1 = 0; v1 < 8; ++v1) {
            if((1 << v1 & v) != 0) {
                map0.put(Script.n[v1], Script.ApiFunction.u);
            }
        }
        return map0;
    }

    protected String e() {
        return null;
    }

    protected ap f() {
        return LuaValue.v;
    }

    @Override  // luaj.LuaFunction
    public String g_() [...] // 潜在的解密器

    protected abstract int m_();
}

