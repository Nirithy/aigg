package android.ext;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import luaj.Globals;
import luaj.LuaBoolean;
import luaj.LuaClosure;
import luaj.LuaDouble;
import luaj.LuaFunction;
import luaj.LuaLong;
import luaj.LuaNil;
import luaj.LuaNumber;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaThread;
import luaj.LuaValue;
import luaj.a.b;
import luaj.a.t;
import luaj.aj;
import luaj.ap;
import luaj.f;
import luaj.lib.BaseLib;
import luaj.lib.Bit32Lib;
import luaj.lib.DebugLib;
import luaj.lib.MathLib;
import luaj.lib.OsLib;
import luaj.lib.PackageLib;
import luaj.lib.StringLib;
import luaj.lib.TableLib;
import luaj.lib.TwoArgFunction;
import luaj.lib.Utf8Lib;
import luaj.o;
import luaj.z;

public class Script extends TwoArgFunction {
    final Globals a;
    private final byte ai;
    private static volatile int al;
    private volatile int am;
    private volatile byte an;
    private static WeakReference ao;
    private String ap;
    private String aq;
    private String ar;
    private String as;
    final Object b;
    final Thread c;
    final Script.Logger d;
    final int e;
    final String f;
    volatile boolean g;
    volatile int h;
    Script.Consts i;
    volatile String j;
    static volatile ArrayList k;
    static volatile int l;
    static volatile long m;
    static final LuaString[] n;
    static final int[] o;
    static final int[] p;
    volatile Script.SavedState q;
    static Script.DebugLog r;

    static {
        Script.al = 0;
        Script.ao = new WeakReference(null);
        Script.k = null;
        Script.l = 0;
        Script.m = 0L;
        Script.n = new LuaString[]{LuaString.c("address"), LuaString.c("value"), LuaString.c("flags"), LuaString.c("name"), LuaString.c("freeze"), LuaString.c("freezeType"), LuaString.c("freezeFrom"), LuaString.c("freezeTo")};
        Script.o = new int[3];
        Script.p = new int[8];
        for(int v1 = 0; v1 < Script.o.length; ++v1) {
            Script.o[v1] = LuaTable.a(Script.n[v1], 3);
        }
        for(int v = 0; v < Script.p.length; ++v) {
            Script.p[v] = LuaTable.a(Script.n[v], 7);
        }
        Script.r = null;
    }

    public Script(File file0, int v, String s) {
        this.am = 0;
        this.an = -1;
        this.g = true;
        this.h = 0;
        this.a = new Globals();
        this.c = new Script.ScriptThread(this);
        this.d = new Script.Logger();
        int v1 = Script.al;
        Script.al = v1 + 1;
        this.ai = (byte)(v1 % 5);
        this.i = null;
        this.ap = null;
        this.aq = null;
        this.ar = null;
        this.as = null;
        this.j = null;
        this.q = null;
        f.g = false;
        this.b = file0;
        this.e = v;
        this.f = s;
        this.S();
    }

    public Script(String s, int v, String s1) {
        this.am = 0;
        this.an = -1;
        this.g = true;
        this.h = 0;
        this.a = new Globals();
        this.c = new Script.ScriptThread(this);
        this.d = new Script.Logger();
        int v1 = Script.al;
        Script.al = v1 + 1;
        this.ai = (byte)(v1 % 5);
        this.i = null;
        this.ap = null;
        this.aq = null;
        this.ar = null;
        this.as = null;
        this.j = null;
        this.q = null;
        this.b = s;
        this.e = v;
        this.f = s1;
        this.S();
    }

    private void S() {
        f.a(this.a);
        t.a(this.a);
        BaseLib baseLib0 = new BaseLib();
        this.a.F(baseLib0);
        PackageLib packageLib0 = new PackageLib();
        this.a.F(packageLib0);
        Bit32Lib bit32Lib0 = new Bit32Lib();
        this.a.F(bit32Lib0);
        TableLib tableLib0 = new TableLib();
        this.a.F(tableLib0);
        StringLib stringLib0 = new StringLib();
        this.a.F(stringLib0);
        Utf8Lib utf8Lib0 = new Utf8Lib();
        this.a.F(utf8Lib0);
        MathLib mathLib0 = new MathLib();
        this.a.F(mathLib0);
        Script.IoLibSafe script$IoLibSafe0 = new Script.IoLibSafe(this);
        this.a.F(script$IoLibSafe0);
        Script.OsLibSafe script$OsLibSafe0 = new Script.OsLibSafe(this);
        this.a.F(script$OsLibSafe0);
        DebugLib debugLib0 = new DebugLib();
        this.a.F(debugLib0);
        this.T();
    }

    private void T() {
        this.a.e = new Script.ScriptPrintStream(this, false);
        this.a.f = new Script.ScriptPrintStream(this, true);
        this.a.F(this);
    }

    static int a(int v) {
        if(v != 0x4000000 && v != 0x8000000 && v != 0x10000000 && v != 0x20000000) {
            throw new o("Unknown sign: " + v + ". The sign must be one of the constants gg.SIGN_*.");
        }
        return v;
    }

    static int a(LuaTable luaTable0, LuaValue luaValue0) {
        try {
            return luaTable0.w(luaValue0).v();
        }
        catch(o o0) {
            throw Script.a(luaValue0, o0);
        }
    }

    static int a(LuaTable luaTable0, LuaValue luaValue0, int v) {
        try {
            return luaTable0.w(luaValue0).b_(v);
        }
        catch(o o0) {
            throw Script.a(luaValue0, o0);
        }
    }

    private static long a(long v, LuaValue luaValue0, LuaValue luaValue1, int v1, boolean z) {
        String s;
        long v2;
        if(luaValue1 instanceof LuaLong) {
            v2 = luaValue1.q();
            if(v1 == 16) {
                return (long)Float.floatToRawIntBits(v2);
            }
            if(v1 == 0x40) {
                return Double.doubleToRawLongBits(v2);
            }
            return v1 == 8 ? v2 ^ v : v2;
        }
        if(luaValue1 instanceof LuaDouble) {
            double f = luaValue1.o();
            if(v1 == 16) {
                return (long)Float.floatToRawIntBits(((float)f));
            }
            if(v1 == 0x40) {
                return Double.doubleToRawLongBits(f);
            }
            v2 = (long)f;
            return v1 == 8 ? v2 ^ v : v2;
        }
        try {
            s = z ? luaValue1.b_(null) : luaValue1.y();
            if(s == null) {
                return 0L;
            }
        }
        catch(o o0) {
            throw Script.a(luaValue0, o0);
        }
        String s1 = Script.a(s);
        rd rd0 = ra.a(s1, false);
        if(rd0 != null) {
            s1 = rd0.a;
        }
        return d.a(v, s1, v1);
    }

    public static Script.Consts a(ArrayList arrayList0) {
        Script.Consts script$Consts0 = (Script.Consts)Script.ao.get();
        if(script$Consts0 == null) {
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
                Script.a(new LuaTable(0, 0x40), arrayList0);
            }
            ArrayList arrayList1 = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            ArrayList arrayList9 = new ArrayList();
            ArrayList arrayList10 = new ArrayList();
            for(Object object0: arrayList0) {
                Script.Const script$Const0 = (Script.Const)object0;
                String s = script$Const0.a;
                if(s.startsWith("gg.REGION_")) {
                    arrayList1.add(script$Const0);
                }
                else if(s.startsWith("gg.TYPE_")) {
                    arrayList2.add(script$Const0);
                }
                else if(s.startsWith("gg.SIGN_FUZZY_")) {
                    arrayList3.add(script$Const0);
                }
                else if(s.startsWith("gg.SIGN_")) {
                    arrayList4.add(script$Const0);
                }
                else if(s.startsWith("gg.LOAD_")) {
                    arrayList5.add(script$Const0);
                }
                else if(s.startsWith("gg.SAVE_")) {
                    arrayList6.add(script$Const0);
                }
                else if(s.startsWith("gg.PROT_")) {
                    arrayList7.add(script$Const0);
                }
                else if(s.startsWith("gg.POINTER_")) {
                    arrayList8.add(script$Const0);
                }
                else if(s.startsWith("gg.DUMP_")) {
                    arrayList9.add(script$Const0);
                }
                else if(s.startsWith("gg.ASM_")) {
                    arrayList10.add(script$Const0);
                }
            }
            Script.Consts script$Consts1 = new Script.Consts();
            script$Consts1.a = (Script.Const[])arrayList1.toArray(new Script.Const[arrayList1.size()]);
            script$Consts1.b = (Script.Const[])arrayList2.toArray(new Script.Const[arrayList2.size()]);
            script$Consts1.c = (Script.Const[])arrayList3.toArray(new Script.Const[arrayList3.size()]);
            script$Consts1.d = (Script.Const[])arrayList4.toArray(new Script.Const[arrayList4.size()]);
            script$Consts1.e = (Script.Const[])arrayList5.toArray(new Script.Const[arrayList5.size()]);
            script$Consts1.f = (Script.Const[])arrayList6.toArray(new Script.Const[arrayList6.size()]);
            script$Consts1.g = (Script.Const[])arrayList7.toArray(new Script.Const[arrayList7.size()]);
            script$Consts1.h = (Script.Const[])arrayList8.toArray(new Script.Const[arrayList8.size()]);
            script$Consts1.i = (Script.Const[])arrayList9.toArray(new Script.Const[arrayList9.size()]);
            script$Consts1.j = (Script.Const[])arrayList10.toArray(new Script.Const[arrayList10.size()]);
            Script.ao = new WeakReference(script$Consts1);
            return script$Consts1;
        }
        return script$Consts0;
    }

    static d a(d d0, LuaTable luaTable0, byte b, boolean z) {
        long v2;
        boolean z1 = true;
        LuaString[] arr_luaString = Script.n;
        long v = Script.b(luaTable0, arr_luaString[0]);
        if(!z) {
            v &= 0xFFFFFFFFL;
        }
        int v1 = Script.b(Script.a(luaTable0, arr_luaString[2]));
        if(b == 2) {
            v2 = 0L;
        }
        else {
            LuaString luaString0 = arr_luaString[1];
            LuaValue luaValue0 = luaTable0.w(luaString0);
            if(b != 0) {
                z1 = false;
            }
            v2 = Script.a(v, luaString0, luaValue0, v1, z1);
        }
        if(d0 == null) {
            return new d(v, v2, v1);
        }
        d0.b = v;
        d0.c = v2;
        d0.d = v1;
        return d0;
    }

    static qx a(LuaTable luaTable0, boolean z) {
        qx qx0 = new qx();
        Script.a(qx0, luaTable0, 0, z);
        qx0.e = Script.a(luaTable0, Script.n[3], null);
        qx0.f = Script.a(luaTable0, Script.n[4], false);
        qx0.n(Script.a(luaTable0, Script.n[5], 0));
        long v = qx0.b;
        int v1 = qx0.d;
        LuaString luaString0 = Script.n[6];
        qx0.h = Script.a(v, luaString0, luaTable0.w(luaString0), v1, true);
        LuaString luaString1 = Script.n[7];
        qx0.i = Script.a(v, luaString1, luaTable0.w(luaString1), v1, true);
        return qx0;
    }

    static String a(File file0) {
        try {
            return file0.getCanonicalPath();
        }
        catch(IOException unused_ex) {
            return file0.getAbsolutePath();
        }
    }

    static String a(String s) {
        return !ps.d(s) && ps.e(s) == 0 ? ps.b(s) : s;
    }

    static String a(Throwable throwable0) {
        if(throwable0 instanceof pt) {
            ((pt)throwable0).a();
        }
        return throwable0.toString();
    }

    static String a(LuaTable luaTable0, LuaValue luaValue0, String s) {
        try {
            return luaTable0.w(luaValue0).b_(s);
        }
        catch(o o0) {
            throw Script.a(luaValue0, o0);
        }
    }

    static ArrayList a(ap ap0) {
        LuaTable luaTable0 = ap0.t(1);
        ArrayList arrayList0 = new ArrayList();
        qh qh0 = MainService.instance.ap;
        boolean z = qh0 == null ? false : qh0.n;
        z z1 = luaTable0.S();
        while(z1.a()) {
            d d0 = Script.a(null, z1.d().O(), 2, z);
            d0.d &= 0x7F;
            arrayList0.add(d0);
        }
        return arrayList0;
    }

    static LuaTable a(qx qx0) {
        LuaString[] arr_luaString = Script.n;
        int[] arr_v = Script.p;
        LuaTable luaTable0 = Script.b(arr_v, qx0);
        String s = qx0.e;
        if(s != null) {
            luaTable0.d(arr_luaString[3], LuaValue.m(s));
        }
        luaTable0.a(arr_v[4], arr_luaString[4], qx0.f);
        luaTable0.a(arr_v[5], arr_luaString[5], ((int)qx0.g));
        long v = qx0.b;
        int v1 = qx0.d;
        if(qx0.h != 0L || qx0.i != 0L) {
            Script.a(arr_v[6], luaTable0, arr_luaString[6], v, qx0.h, v1);
            Script.a(arr_v[7], luaTable0, arr_luaString[7], v, qx0.i, v1);
        }
        return luaTable0;
    }

    static o a(LuaValue luaValue0, LuaValue luaValue1, Throwable throwable0) {
        return new o("Failed parse item " + luaValue1.d_() + " on key \'" + luaValue0.d_() + "\': " + throwable0.getMessage(), throwable0);
    }

    private static o a(LuaValue luaValue0, o o0) {
        String s = o0.getMessage();
        return s.indexOf("bad argument:") == 0 ? new o("bad argument for key \'" + luaValue0.d_() + "\':" + s.substring(13)) : o0;
    }

    private static void a(int v, LuaTable luaTable0, LuaString luaString0, long v1, long v2, int v3) {
        if(v3 == 8) {
            v2 ^= v1;
        }
        switch(v3) {
            case 16: {
                luaTable0.a(v, luaString0, Float.intBitsToFloat(((int)v2)));
                return;
            }
            case 0x40: {
                luaTable0.a(v, luaString0, Double.longBitsToDouble(v2));
                return;
            }
            default: {
                luaTable0.a(v, luaString0, gv.a(v2, d.f(v3), false));
            }
        }
    }

    public static void a(long v) {
        Script.m = v;
    }

    public static void a(bk bk0) {
        bk0.g();
        ArrayList arrayList0 = new ArrayList();
        while(true) {
            try {
                int v = bk0.b();
                if(v == 0) {
                    break;
                }
                arrayList0.add(new d(bk0.c(), bk0.d(), v));
            }
            catch(IOException iOException0) {
                la.c("???", iOException0);
                ho.a(Thread.currentThread(), iOException0, false);
                break;
            }
        }
        Script.k = arrayList0;
        Script.l += 100;
    }

    static void a(Object object0) {
        try {
            object0.wait();
        }
        catch(InterruptedException interruptedException0) {
            la.b("Interrupted wait", interruptedException0);
            Thread.currentThread().interrupt();
            throw new o(interruptedException0);
        }
    }

    private static void a(ArrayList arrayList0, LuaTable luaTable0, String s, int v) {
        luaTable0.b(s, v);
        if(arrayList0 != null) {
            arrayList0.add(new Script.Const("gg." + s, v));
        }
    }

    public static void a(Globals globals0) {
        LuaNil.a = null;
        LuaNumber.e = null;
        LuaBoolean.a = null;
        LuaValue luaValue0 = globals0 == null ? null : globals0.j("string");
        LuaString.a = luaValue0 != null && !luaValue0.F() ? LuaValue.b(new LuaValue[]{Script.D, luaValue0}) : null;
        LuaFunction.s = null;
        LuaThread.a = null;
    }

    static void a(LuaTable luaTable0, ArrayList arrayList0) {
        Script.a(arrayList0, luaTable0, "TYPE_AUTO", 0x7F);
        Script.a(arrayList0, luaTable0, "TYPE_BYTE", 1);
        Script.a(arrayList0, luaTable0, "TYPE_WORD", 2);
        Script.a(arrayList0, luaTable0, "TYPE_DWORD", 4);
        Script.a(arrayList0, luaTable0, "TYPE_XOR", 8);
        Script.a(arrayList0, luaTable0, "TYPE_FLOAT", 16);
        Script.a(arrayList0, luaTable0, "TYPE_QWORD", 0x20);
        Script.a(arrayList0, luaTable0, "TYPE_DOUBLE", 0x40);
        Script.a(arrayList0, luaTable0, "SIGN_EQUAL", 0x20000000);
        Script.a(arrayList0, luaTable0, "SIGN_NOT_EQUAL", 0x10000000);
        Script.a(arrayList0, luaTable0, "SIGN_LESS_OR_EQUAL", 0x8000000);
        Script.a(arrayList0, luaTable0, "SIGN_GREATER_OR_EQUAL", 0x4000000);
        Script.a(arrayList0, luaTable0, "SIGN_FUZZY_EQUAL", 0x20000000);
        Script.a(arrayList0, luaTable0, "SIGN_FUZZY_NOT_EQUAL", 0x10000000);
        Script.a(arrayList0, luaTable0, "SIGN_FUZZY_LESS", 0x8000000);
        Script.a(arrayList0, luaTable0, "SIGN_FUZZY_GREATER", 0x4000000);
        Script.a(arrayList0, luaTable0, "REGION_JAVA_HEAP", 2);
        Script.a(arrayList0, luaTable0, "REGION_C_HEAP", 1);
        Script.a(arrayList0, luaTable0, "REGION_C_ALLOC", 4);
        Script.a(arrayList0, luaTable0, "REGION_C_DATA", 8);
        Script.a(arrayList0, luaTable0, "REGION_C_BSS", 16);
        Script.a(arrayList0, luaTable0, "REGION_PPSSPP", 0x40000);
        Script.a(arrayList0, luaTable0, "REGION_ANONYMOUS", 0x20);
        Script.a(arrayList0, luaTable0, "REGION_JAVA", 0x10000);
        Script.a(arrayList0, luaTable0, "REGION_STACK", 0x40);
        Script.a(arrayList0, luaTable0, "REGION_ASHMEM", 0x80000);
        Script.a(arrayList0, luaTable0, "REGION_VIDEO", 0x100000);
        Script.a(arrayList0, luaTable0, "REGION_OTHER", 0xFFE03F80);
        Script.a(arrayList0, luaTable0, "REGION_BAD", 0x20000);
        Script.a(arrayList0, luaTable0, "REGION_CODE_APP", 0x4000);
        Script.a(arrayList0, luaTable0, "REGION_CODE_SYS", 0x8000);
        Script.a(arrayList0, luaTable0, "LOAD_VALUES_FREEZE", 3);
        Script.a(arrayList0, luaTable0, "LOAD_VALUES", 2);
        Script.a(arrayList0, luaTable0, "LOAD_APPEND", 8);
        Script.a(arrayList0, luaTable0, "SAVE_AS_TEXT", 1);
        luaTable0.b("FREEZE_NORMAL", 0);
        luaTable0.b("FREEZE_MAY_INCREASE", 1);
        luaTable0.b("FREEZE_MAY_DECREASE", 2);
        luaTable0.b("FREEZE_IN_RANGE", 3);
        luaTable0.b("PROT_NONE", 0);
        Script.a(arrayList0, luaTable0, "PROT_READ", 2);
        Script.a(arrayList0, luaTable0, "PROT_WRITE", 1);
        Script.a(arrayList0, luaTable0, "PROT_EXEC", 4);
        Script.a(arrayList0, luaTable0, "POINTER_NO", 4);
        Script.a(arrayList0, luaTable0, "POINTER_READ_ONLY", 8);
        Script.a(arrayList0, luaTable0, "POINTER_WRITABLE", 16);
        Script.a(arrayList0, luaTable0, "POINTER_EXECUTABLE", 2);
        Script.a(arrayList0, luaTable0, "POINTER_EXECUTABLE_WRITABLE", 1);
        Script.a(arrayList0, luaTable0, "DUMP_SKIP_SYSTEM_LIBS", 1);
        Script.a(arrayList0, luaTable0, "TAB_SETTINGS", 0);
        Script.a(arrayList0, luaTable0, "TAB_SEARCH", 1);
        Script.a(arrayList0, luaTable0, "TAB_SAVED_LIST", 2);
        Script.a(arrayList0, luaTable0, "TAB_MEMORY_EDITOR", 3);
        Script.a(arrayList0, luaTable0, "ASM_ARM", 4);
        Script.a(arrayList0, luaTable0, "ASM_THUMB", 5);
        Script.a(arrayList0, luaTable0, "ASM_ARM64", 6);
    }

    static boolean a(LuaTable luaTable0, LuaValue luaValue0, boolean z) {
        try {
            return luaTable0.w(luaValue0).a(z);
        }
        catch(o o0) {
            throw Script.a(luaValue0, o0);
        }
    }

    byte a() {
        int v = this.am;
        this.am = v + 1;
        this.an = (byte)(v % 20);
        return (byte)(((byte)(v % 20)) + this.ai * 20 + 20);
    }

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        Context context0 = Tools.e();
        ArrayList arrayList0 = (this.e & 4) == 0 ? null : new ArrayList();
        LuaValue luaValue2 = new LuaTable(0, 0x80);
        ((LuaTable)luaValue2).d("VERSION", 101.099998f);
        ((LuaTable)luaValue2).b("VERSION_INT", gs.c());
        ((LuaTable)luaValue2).b("BUILD", 0x3F0E);
        ((LuaTable)luaValue2).d("PACKAGE", Tools.g());
        ((LuaTable)luaValue2).b("ANDROID_SDK_INT", Build.VERSION.SDK_INT);
        ((LuaTable)luaValue2).d("FILES_DIR", Tools.i().getAbsolutePath());
        ((LuaTable)luaValue2).d("CACHE_DIR", Tools.h().getAbsolutePath());
        try {
            ((LuaTable)luaValue2).d("EXT_FILES_DIR", context0.getExternalFilesDir(null).getAbsolutePath());
        }
        catch(Throwable throwable0) {
            la.c("Failed set EXT_FILES_DIR for script", throwable0);
            ((LuaTable)luaValue2).d("EXT_FILES_DIR", Tools.i().getAbsolutePath());
        }
        try {
            ((LuaTable)luaValue2).d("EXT_CACHE_DIR", context0.getExternalCacheDir().getAbsolutePath());
        }
        catch(Throwable throwable1) {
            la.c("Failed set EXT_CACHE_DIR for script", throwable1);
            ((LuaTable)luaValue2).d("EXT_CACHE_DIR", Tools.h().getAbsolutePath());
        }
        ((LuaTable)luaValue2).d("EXT_STORAGE", Tools.r());
        Script.a(((LuaTable)luaValue2), arrayList0);
        ((LuaTable)luaValue2).b("require", new Script.require(this));
        ((LuaTable)luaValue2).b("toast", new Script.toast());
        ((LuaTable)luaValue2).b("alert", new Script.alert());
        ((LuaTable)luaValue2).b("prompt", new Script.prompt(this));
        ((LuaTable)luaValue2).b("choice", new Script.choice());
        ((LuaTable)luaValue2).b("multiChoice", new Script.multiChoice());
        ((LuaTable)luaValue2).b("isVisible", new Script.isVisible());
        ((LuaTable)luaValue2).b("setVisible", new Script.setVisible(this));
        ((LuaTable)luaValue2).b("getActiveTab", new Script.getActiveTab());
        ((LuaTable)luaValue2).b("showUiButton", new Script.showUiButton(this));
        ((LuaTable)luaValue2).b("hideUiButton", new Script.hideUiButton(this));
        ((LuaTable)luaValue2).b("isClickedUiButton", new Script.isClickedUiButton());
        Script.getTargetPackage script$getTargetPackage0 = new Script.getTargetPackage();
        ((LuaTable)luaValue2).b("getTargetPackage", script$getTargetPackage0);
        ((LuaTable)luaValue2).b("getTargetInfo", new Script.getTargetInfo());
        ((LuaTable)luaValue2).b("isPackageInstalled", new Script.isPackageInstalled());
        ((LuaTable)luaValue2).b("processKill", new Script.processKill(this));
        ((LuaTable)luaValue2).b("saveVariable", new Script.saveVariable(this));
        ((LuaTable)luaValue2).b("makeRequest", new Script.makeRequest(this));
        Script.getResultsCount script$getResultsCount0 = new Script.getResultsCount();
        ((LuaTable)luaValue2).b("getResultsCount", script$getResultsCount0);
        ((LuaTable)luaValue2).b("getResults", new Script.getResults(this));
        ((LuaTable)luaValue2).b("editAll", new Script.editAll(this));
        ((LuaTable)luaValue2).b("clearResults", new Script.clearResults(this));
        ((LuaTable)luaValue2).b("removeResults", new Script.removeResults(this));
        ((LuaTable)luaValue2).b("loadResults", new Script.loadResults(this));
        ((LuaTable)luaValue2).b("getSelectedResults", new Script.getSelectedResults(this));
        ((LuaTable)luaValue2).b("setValues", new Script.setValues(this));
        ((LuaTable)luaValue2).b("getValues", new Script.getValues(this));
        ((LuaTable)luaValue2).b("getValuesRange", new Script.getValuesRange(this));
        ((LuaTable)luaValue2).b("processPause", new Script.processPause(this));
        ((LuaTable)luaValue2).b("processResume", new Script.processResume(this));
        ((LuaTable)luaValue2).b("processToggle", new Script.processToggle(this));
        ((LuaTable)luaValue2).b("isProcessPaused", new Script.isProcessPaused());
        ((LuaTable)luaValue2).b("timeJump", new Script.timeJump(this));
        ((LuaTable)luaValue2).b("setSpeed", new Script.setSpeed(this));
        ((LuaTable)luaValue2).b("getSpeed", new Script.getSpeed());
        ((LuaTable)luaValue2).b("unrandomizer", new Script.unrandomizer(this));
        ((LuaTable)luaValue2).b("gotoAddress", new Script.gotoAddress());
        ((LuaTable)luaValue2).b("getSelectedElements", new Script.getSelectedElements(this));
        ((LuaTable)luaValue2).b("getRanges", new Script.getRanges());
        ((LuaTable)luaValue2).b("setRanges", new Script.setRanges(this));
        ((LuaTable)luaValue2).b("copyMemory", new Script.copyMemory(this));
        ((LuaTable)luaValue2).b("dumpMemory", new Script.dumpMemory(this));
        ((LuaTable)luaValue2).b("loadList", new Script.loadList(this));
        ((LuaTable)luaValue2).b("saveList", new Script.saveList(this));
        ((LuaTable)luaValue2).b("clearList", new Script.clearList(this));
        ((LuaTable)luaValue2).b("addListItems", new Script.addListItems(this));
        ((LuaTable)luaValue2).b("getListItems", new Script.getListItems(this));
        ((LuaTable)luaValue2).b("removeListItems", new Script.removeListItems(this));
        ((LuaTable)luaValue2).b("getSelectedListItems", new Script.getSelectedListItems(this));
        ((LuaTable)luaValue2).b("searchNumber", new Script.searchNumber(this));
        ((LuaTable)luaValue2).b("refineNumber", new Script.refineNumber(this));
        ((LuaTable)luaValue2).b("searchAddress", new Script.searchAddress(this));
        ((LuaTable)luaValue2).b("refineAddress", new Script.refineAddress(this));
        ((LuaTable)luaValue2).b("startFuzzy", new Script.startFuzzy(this));
        ((LuaTable)luaValue2).b("searchFuzzy", new Script.searchFuzzy(this));
        Script.searchPointer script$searchPointer0 = new Script.searchPointer(this);
        ((LuaTable)luaValue2).b("searchPointer", script$searchPointer0);
        ((LuaTable)luaValue2).b("sleep", new Script.sleep());
        ((LuaTable)luaValue2).b("copyText", new Script.copyText());
        ((LuaTable)luaValue2).b("disasm", new Script.disasm(this));
        ((LuaTable)luaValue2).b("getLine", new Script.getLine(this));
        ((LuaTable)luaValue2).b("getFile", new Script.getFile(this));
        ((LuaTable)luaValue2).b("bytes", new Script.bytes(this));
        ((LuaTable)luaValue2).b("skipRestoreState", new Script.skipRestoreState(this));
        ((LuaTable)luaValue2).b("getRangesList", new Script.getRangesList(this));
        ((LuaTable)luaValue2).b("allocatePage", new Script.allocatePage(this));
        ((LuaTable)luaValue2).b("getLocale", new Script.getLocale(this));
        ((LuaTable)luaValue2).b("numberToLocale", new Script.numberToLocale(this));
        ((LuaTable)luaValue2).b("numberFromLocale", new Script.numberFromLocale(this));
        ((LuaTable)luaValue2).c(LuaValue.m("SIGN_INEQUAL").P(), LuaValue.d(0x10000000L));
        ((LuaTable)luaValue2).c(LuaValue.m("SIGN_SMALLER").P(), LuaValue.d(0x8000000L));
        ((LuaTable)luaValue2).c(LuaValue.m("SIGN_LARGER").P(), LuaValue.d(0x4000000L));
        ((LuaTable)luaValue2).c(LuaValue.m("getSelectedPackage").P(), script$getTargetPackage0);
        ((LuaTable)luaValue2).c(LuaValue.m("getResultCount").P(), script$getResultsCount0);
        ((LuaTable)luaValue2).c(LuaValue.m("internal1").P(), new Script.internal1(this));
        ((LuaTable)luaValue2).c(LuaValue.m("internal2").P(), new Script.internal2(this));
        ((LuaTable)luaValue2).c(LuaValue.m("internal3").P(), script$searchPointer0);
        luaValue1.a("gg", luaValue2);
        luaValue1.j("package").j("loaded").a("gg", luaValue2);
        LuaValue luaValue3 = luaValue1.j("os");
        luaValue3.a("exit", new Script.exit());
        luaValue3.a("remove", new Script.wrap(this, "os.remove", luaValue3.j("remove"), 1));
        luaValue3.a("rename", new Script.wrap(this, "os.rename", luaValue3.j("rename"), 2));
        luaValue3.a("tmpname", new Script.wrap(this, "os.tmpname", luaValue3.j("tmpname"), 0));
        LuaValue luaValue4 = luaValue1.j("string");
        luaValue4.a("format", new Script.format(luaValue4.j("format")));
        luaValue4.a("dump", new Script.wrap(this, "string.dump", luaValue4.j("dump"), 1));
        LuaValue luaValue5 = luaValue1.j("io");
        luaValue5.a("open", new Script.wrap(this, "io.open", luaValue5.j("open"), 2));
        luaValue5.a("input", new Script.wrap(this, "io.input", luaValue5.j("input"), 1));
        luaValue5.a("output", new Script.wrap(this, "io.output", luaValue5.j("output"), 1));
        luaValue5.a("tmpfile", new Script.wrap(this, "io.tmpfile", luaValue5.j("tmpfile"), 0));
        luaValue5.a("lines", new Script.wrap(this, "io.lines", luaValue5.j("lines"), 1));
        LuaValue luaValue6 = luaValue1.j("debug");
        luaValue6.a("debug", new Script.wrap(this, "debug.debug", luaValue6.j("debug"), 0));
        luaValue6.a("gethook", new Script.wrap(this, "debug.gethook", luaValue6.j("gethook"), 1));
        luaValue6.a("getinfo", new Script.wrap(this, "debug.getinfo", luaValue6.j("getinfo"), 3));
        luaValue6.a("getlocal", new Script.wrap(this, "debug.getlocal", luaValue6.j("getlocal"), 3));
        luaValue6.a("getmetatable", new Script.wrap(this, "debug.getmetatable", luaValue6.j("getmetatable"), 1));
        luaValue6.a("getregistry", new Script.wrap(this, "debug.getregistry", luaValue6.j("getregistry"), 0));
        luaValue6.a("getupvalue", new Script.wrap(this, "debug.getupvalue", luaValue6.j("getupvalue"), 2));
        luaValue6.a("getuservalue", new Script.wrap(this, "debug.getuservalue", luaValue6.j("getuservalue"), 1));
        luaValue6.a("sethook", new Script.wrap(this, "debug.sethook", luaValue6.j("sethook"), 4));
        luaValue6.a("setlocal", new Script.wrap(this, "debug.setlocal", luaValue6.j("setlocal"), 4));
        luaValue6.a("setmetatable", new Script.wrap(this, "debug.setmetatable", luaValue6.j("setmetatable"), 2));
        luaValue6.a("setupvalue", new Script.wrap(this, "debug.setupvalue", luaValue6.j("setupvalue"), 3));
        luaValue6.a("setuservalue", new Script.wrap(this, "debug.setuservalue", luaValue6.j("setuservalue"), 2));
        luaValue6.a("traceback", new Script.wrap(this, "debug.traceback", luaValue6.j("traceback"), 3));
        luaValue6.a("upvalueid", new Script.wrap(this, "debug.upvalueid", luaValue6.j("upvalueid"), 2));
        luaValue6.a("upvaluejoin", new Script.wrap(this, "debug.upvaluejoin", luaValue6.j("upvaluejoin"), 4));
        this.i = arrayList0 == null ? new Script.Consts() : Script.a(arrayList0);
        return luaValue2;
    }

    public void a(byte b, String s) {
        int v = (byte)(((byte)(b - 20)) / 20);
        int v1 = (byte)(((byte)(b - 20)) % 20);
        if(this.ai != v) {
            la.a(("callNotify id mismatch: " + ((int)this.ai) + " != " + v + "; " + v1 + "; " + ((int)b) + "; " + s));
            return;
        }
        int v2 = this.an;
        if(v2 == v1) {
            synchronized(this) {
                v2 = this.an;
                if(v2 == v1) {
                    this.j = s;
                    this.notifyAll();
                    return;
                }
            }
        }
        la.a(("callNotify seq mismatch: " + v2 + " != " + v1 + "; " + v + "; " + ((int)b) + "; " + s));
    }

    void a(boolean z, String s) {
        if(z) {
            this.d.a("err: ");
        }
        this.d.a(s);
        this.d.a("\n");
    }

    boolean a(String s, boolean z) {
        String s1 = Script.a(new File(s));
        String s2 = this.aq;
        if(s2 == null) {
            s2 = Script.a(Tools.l());
            this.aq = s2;
        }
        if(s1.startsWith(s2)) {
            return true;
        }
        String s3 = this.ar;
        if(s3 == null) {
            s3 = Script.a(Tools.k());
            this.ar = s3;
        }
        if(s1.startsWith(s3)) {
            return true;
        }
        String s4 = this.as;
        if(s4 == null) {
            s4 = Script.a(ty.b("null_preferences"));
            this.as = s4;
        }
        if(s4.startsWith(s1) && (s4.length() == s1.length() || s4.charAt(s1.length()) == 0x2F)) {
            return true;
        }
        if(z || !(this.b instanceof File)) {
            return false;
        }
        String s5 = this.ap;
        if(s5 == null) {
            s5 = Script.a(((File)this.b));
            this.ap = s5;
        }
        return s5.startsWith(s1) && (s5.length() == s1.length() || s5.charAt(s1.length()) == 0x2F);
    }

    static String a_(String s) {
        return ps.a(s);
    }

    public Script a_(int v) {
        this.h = v;
        this.c.interrupt();
        return this;
    }

    void a_() {
        Script.SavedState script$SavedState0 = new Script.SavedState(null);
        script$SavedState0.a = Config.i;
        this.q = script$SavedState0;
    }

    static int b(int v) {
        if(v == 0 || (v & 0xFFFFFF80) != 0) {
            throw new o("Unknown type: " + v + ". The type must be one of the constants gg.TYPE_*.");
        }
        return v;
    }

    static long b(LuaTable luaTable0, LuaValue luaValue0) {
        try {
            return luaTable0.z(luaValue0);
        }
        catch(o o0) {
            throw Script.a(luaValue0, o0);
        }
    }

    private static LuaTable b(int[] arr_v, d d0) {
        if(arr_v == null) {
            arr_v = Script.o;
        }
        LuaTable luaTable0 = new LuaTable(0, arr_v.length);
        long v = d0.b;
        int v1 = d0.d;
        luaTable0.a(arr_v[0], Script.n[0], v);
        Script.a(arr_v[1], luaTable0, Script.n[1], v, d0.c, v1);
        luaTable0.a(arr_v[2], Script.n[2], v1);
        return luaTable0;
    }

    boolean b(File file0) {
        if(file0.exists()) {
            try {
                BufferedReader bufferedReader0 = new BufferedReader(new FileReader(file0));
                int v = 0;
                while(true) {
                    String s = bufferedReader0.readLine();
                    if(s != null) {
                        String s1 = s.trim();
                        if(s1.length() == 0) {
                            continue;
                        }
                        if(v == 0) {
                            try {
                                Integer.parseInt(s1);
                                v = 1;
                                continue;
                            label_11:
                                if(s1.split("\\|").length < 10) {
                                    v = -v;
                                }
                                else {
                                    goto label_15;
                                }
                            }
                            catch(Throwable unused_ex) {
                            }
                        }
                        else {
                            goto label_11;
                        }
                    }
                    bufferedReader0.close();
                    return v > 1;
                label_15:
                    ++v;
                }
                return false;
            }
            catch(IOException iOException0) {
            }
        }
        else {
            return false;
        }
        la.a("Failed detect", iOException0);
        return false;
    }

    void b_() {
        Script.SavedState script$SavedState0 = this.q;
        if(script$SavedState0 == null) {
            return;
        }
        rx.a(new Script.1(this, script$SavedState0));
    }

    static String c(LuaTable luaTable0, LuaValue luaValue0) {
        try {
            return luaTable0.w(luaValue0).y();
        }
        catch(o o0) {
            throw Script.a(luaValue0, o0);
        }
    }

    void c(String s) {
        this.d.a("\n");
        this.d.a(s);
        this.d.a("\n");
    }

    public Script c_() {
        this.c.start();
        return this;
    }

    public static String d(String s) {
        Globals globals0 = new Globals();
        globals0.a = false;
        t.a(globals0);
        globals0.F(new BaseLib());
        globals0.F(new Bit32Lib());
        globals0.F(new TableLib());
        globals0.F(new StringLib());
        globals0.F(new Utf8Lib());
        globals0.F(new MathLib());
        globals0.F(new OsLib());
        return globals0.a(new ByteArrayInputStream(s.getBytes()), s, "t", globals0).l().d_();
    }

    void d() {
        PrintStream printStream1;
        BufferedWriter bufferedWriter0;
        String s3;
        String s2;
        LuaValue luaValue0;
        if(this.b instanceof File) {
            File file0 = (File)this.b;
            if(!file0.exists()) {
                throw new FileNotFoundException("File not found: " + file0);
            }
            String s = file0.getParentFile().getAbsolutePath();
            this.a.c(s);
            String s1 = file0.getAbsolutePath();
            luaValue0 = this.a.c_(s1);
            if(luaValue0 instanceof LuaClosure && ((LuaClosure)luaValue0).a instanceof lasm.d) {
                s2 = file0.getAbsolutePath() + '.' + "3Hn98rr" + ".lua";
                try(BufferedOutputStream bufferedOutputStream0 = new BufferedOutputStream(new FileOutputStream(s2), 0x10000)) {
                    b.a(((LuaClosure)luaValue0).a, bufferedOutputStream0, false, false);
                    File file1 = new File(file0.getAbsolutePath() + ".tail");
                    if(file1.exists()) {
                        FileInputStream fileInputStream0 = new FileInputStream(file1);
                        byte[] arr_b = new byte[0x10000];
                        int v;
                        while((v = fileInputStream0.read(arr_b)) > 0) {
                            bufferedOutputStream0.write(arr_b, 0, v);
                        }
                        fileInputStream0.close();
                    }
                }
                this.c(Tools.c(0x7F070322) + ":\n" + s2);  // string:assembled "Successfully assembled to file:"
                return;
            }
            s3 = file0.getName();
        }
        else {
            String s4 = this.b.toString();
            ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(s4.getBytes());
            luaValue0 = this.a.a(byteArrayInputStream0, s4, "t", this.a);
            s3 = "string";
        }
        String s5 = String.valueOf(s3) + '_' + "3Hn98sQ" + '_' + "1jBVSV";
        if((this.e & 1) != 0) {
            LuaClosure luaClosure0 = luaValue0.k();
            String s6 = String.valueOf(this.f) + '/' + s5 + ".lasm";
            PrintStream printStream0 = aj.b;
            try {
                aj.b = new PrintStream(s6);
                aj.a(luaClosure0.a);
                aj.b.close();
                aj.a(luaClosure0, s6 + ".tail");
            }
            catch(Throwable throwable1) {
                la.c(("Failed disassemble " + luaClosure0 + " into \'" + s6 + '\''), throwable1);
            }
            aj.b = printStream0;
        }
        if((this.e & 2) != 0) {
            this.a.i.d(String.valueOf(this.f) + '/' + s5);
        }
        if((this.e & 4) == 0) {
            bufferedWriter0 = null;
        }
        else {
            try {
                bufferedWriter0 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(String.valueOf(this.f) + '/' + s5 + ".log.txt")), 0x10000);
            }
            catch(Throwable throwable2) {
                la.b("Failed open log file", throwable2);
                bufferedWriter0 = null;
            }
        }
        Script.DebugLog script$DebugLog0 = bufferedWriter0 == null ? null : new Script.DebugLog(bufferedWriter0, this.a);
        try {
            Script.r = script$DebugLog0;
            printStream1 = aj.b;
            aj.b = this.a.e;
            Script.a(this.a);
            luaValue0.l();
            aj.b = printStream1;
        }
        catch(Throwable throwable3) {
            aj.b = printStream1;
            if(bufferedWriter0 != null) {
                try {
                    Script.r = null;
                    bufferedWriter0.close();
                }
                catch(Throwable throwable4) {
                    la.b("Failed close log", throwable4);
                }
            }
            if((this.e & 2) != 0) {
                this.a.i.S();
            }
            Script.a(null);
            throw throwable3;
        }
        if(bufferedWriter0 != null) {
            try {
                Script.r = null;
                bufferedWriter0.close();
            }
            catch(Throwable throwable5) {
                la.b("Failed close log", throwable5);
            }
        }
        if((this.e & 2) != 0) {
            this.a.i.S();
        }
        Script.a(null);
    }

    public Script f() {
        return this.a_(1);
    }
}

