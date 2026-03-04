package luaj;

import android.ext.Tools;
import android.ext.la;
import android.ext.qk;
import android.ext.rx;
import java.io.DataInputStream;
import java.io.InputStream;

public class f {
    public static final e a;
    public static String b;
    public static final byte[] c;
    public static final byte[] d;
    public final DataInputStream e;
    String f;
    public static volatile boolean g;
    private int h;
    private int i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private static final LuaValue[] p;
    private static final al[] q;
    private static final l[] r;
    private static final ao[] s;
    private static final int[] t;
    private byte[] u;

    static {
        f.a = (InputStream inputStream0, String s) -> {
            String s1 = s == null ? null : f.a(s);
            f f0 = new f(inputStream0, s1);
            f0.g();
            if(s == null) {
                return null;
            }
            if(f0.o != 0 && f0.o != 1 && f0.o != 4) {
                throw new o("unsupported int size: " + f0.o);
            }
            return f.a(f0.f(), LuaString.c(s1));
        };
        f.b = null;
        f.c = new byte[]{27, 76, 0x75, 97};
        f.d = new byte[]{25, -109, 13, 10, 26, 10};
        f.p = new LuaValue[0];
        f.q = new al[0];
        f.r = new l[0];
        f.s = new ao[0];
        f.t = new int[0];
        f.g = false;
    }

    private f(InputStream inputStream0, String s) {
        this.u = new byte[0x200];
        this.f = s;
        this.e = new DataInputStream(inputStream0);
    }

    public static String a(String s) {
        if(s.startsWith("@") || s.startsWith("=")) {
            return s.substring(1);
        }
        return s.startsWith("\u001B") ? "=?" : s;
    }

    public static LuaValue a(long v) {
        if((0x7FFFFFFFFFFFFFFFL & v) == 0L) {
            return LuaValue.y;
        }
        int v1 = ((int)(v >> 52 & 0x7FFL)) - 0x3FF;
        return v1 >= 0 && v1 < 0x1F && ((1L << 52 - v1) - 1L & (0xFFFFFFFFFFFFFL & v)) == 0L ? LuaLong.b((v >> 0x3F == 0L ? 1 << v1 | ((int)((0xFFFFFFFFFFFFFL & v) >> 52 - v1)) : -(1 << v1 | ((int)((0xFFFFFFFFFFFFFL & v) >> 52 - v1))))) : LuaValue.c(Double.longBitsToDouble(v));
    }

    // 检测为 Lambda 实现
    public static al a(InputStream inputStream0, String s) [...]

    private static al a(al al0, LuaString luaString0) {
        if(al0.w == null) {
            al0.w = luaString0;
        }
        for(int v = 0; v < al0.s.length; ++v) {
            f.a(al0.s[v], al0.w);
        }
        return al0;
    }

    public static void a(Globals globals0) {
        globals0.n = f.a;
    }

    int a() {
        this.e.readFully(this.u, 0, 4);
        return this.j ? this.u[3] << 24 | (this.u[2] & 0xFF) << 16 | (this.u[1] & 0xFF) << 8 | this.u[0] & 0xFF : this.u[0] << 24 | (this.u[1] & 0xFF) << 16 | (this.u[2] & 0xFF) << 8 | this.u[3] & 0xFF;
    }

    void a(al al0) {
        int v = this.a();
        LuaValue[] arr_luaValue = v <= 0 ? f.p : new LuaValue[v];
        for(int v1 = 0; true; ++v1) {
            if(v1 >= v) {
                al0.q = arr_luaValue;
                int v2 = this.a();
                al[] arr_al = v2 <= 0 ? f.q : new al[v2];
                for(int v3 = 0; v3 < v2; ++v3) {
                    arr_al[v3] = this.f();
                }
                al0.s = arr_al;
                return;
            }
            switch(this.e.readByte()) {
                case -2: {
                    arr_luaValue[v1] = LuaLong.b(this.a());
                    break;
                }
                case 0: {
                    arr_luaValue[v1] = LuaValue.u;
                    break;
                }
                case 1: {
                    arr_luaValue[v1] = this.e.readUnsignedByte() == 0 ? LuaValue.w : LuaValue.v;
                    break;
                }
                case 3: {
                    arr_luaValue[v1] = this.e();
                    break;
                }
                case 4: {
                    arr_luaValue[v1] = this.d();
                    break;
                }
                default: {
                    throw new IllegalStateException("bad constant");
                }
            }
        }
    }

    void b(al al0) {
        int v = this.a();
        al0.v = v <= 0 ? f.s : new ao[v];
        for(int v1 = 0; v1 < v; ++v1) {
            boolean z = this.e.readByte() != 0;
            int v2 = this.e.readByte();
            ao[] arr_ao = al0.v;
            arr_ao[v1] = new ao(null, z, v2 & 0xFF);
        }
    }

    int[] b() {
        int v = this.a();
        if(v == 0) {
            return f.t;
        }
        if(this.u.length < v << 2) {
            this.u = new byte[v << 2];
        }
        this.e.readFully(this.u, 0, v << 2);
        int[] arr_v = new int[v];
        int v2 = 0;
        for(int v1 = 0; v2 < v; v1 += 4) {
            arr_v[v2] = this.j ? this.u[v1 + 3] << 24 | (this.u[v1 + 2] & 0xFF) << 16 | (this.u[v1 + 1] & 0xFF) << 8 | this.u[v1] & 0xFF : this.u[v1] << 24 | (this.u[v1 + 1] & 0xFF) << 16 | (this.u[v1 + 2] & 0xFF) << 8 | this.u[v1 + 3] & 0xFF;
            ++v2;
        }
        return arr_v;
    }

    long c() {
        if(this.j) {
            return ((long)this.a()) & 0xFFFFFFFFL | ((long)this.a()) << 0x20;
        }
        int v = this.a();
        return ((long)this.a()) & 0xFFFFFFFFL | ((long)v) << 0x20;
    }

    void c(al al0) {
        LuaString luaString0 = this.d();
        if(luaString0 != null) {
            al0.w = luaString0;
        }
        al0.t = this.b();
        int v = this.a();
        al0.u = v <= 0 ? f.r : new l[v];
        for(int v1 = 0; v1 < v; ++v1) {
            LuaString luaString1 = this.d();
            int v2 = this.a();
            int v3 = this.a();
            l[] arr_l = al0.u;
            arr_l[v1] = new l(luaString1, v2, v3);
        }
        int v4 = this.a();
        for(int v5 = 0; v5 < v4; ++v5) {
            ao ao0 = al0.v[v5];
            ao0.a = this.d();
        }
    }

    LuaString d() {
        int v = this.l == 8 ? ((int)this.c()) : this.a();
        if(v == 0) {
            return null;
        }
        byte[] arr_b = new byte[v];
        this.e.readFully(arr_b, 0, v);
        return LuaString.b(arr_b, 0, arr_b.length - 1);
    }

    LuaValue e() {
        return this.o == 1 ? LuaLong.b(this.a()) : f.a(this.c());
    }

    public al f() {
        al al0 = new al();
        al0.x = this.a();
        al0.y = this.a();
        al0.z = this.e.readUnsignedByte();
        al0.A = this.e.readUnsignedByte();
        al0.B = this.e.readUnsignedByte();
        if(al0.B < al0.z) {
            throw new o("Damaged script 2: .maxstacksize (" + al0.B + ") < .numparams (" + al0.z + ")");
        }
        al0.r = this.b();
        this.a(al0);
        this.b(al0);
        this.c(al0);
        return al0;
    }

    public void g() {
        this.h = this.e.readByte() & 0xFF;
        this.i = this.e.readByte() & 0xFF;
        int v1 = this.e.readByte();
        this.j = v1 != 0;
        this.k = this.e.readByte() & 0xFF;
        this.l = this.e.readByte() & 0xFF;
        this.m = this.e.readByte() & 0xFF;
        this.n = this.e.readByte() & 0xFF;
        this.o = this.e.readByte() & 0xFF;
        String s = this.h == 82 ? "" : "" + qk.a(0x7F070332) + " " + Tools.a(qk.a(0x7F070338), new Object[]{"\'52\'", "\'" + Integer.toHexString(this.h) + "\'"}) + "\n";  // string:unknown_version "Unknown version."
        if(this.i != 0) {
            s = s + qk.a(0x7F070333) + " " + Tools.a(qk.a(0x7F070338), new Object[]{"\'0\'", "\'" + this.i + "\'"}) + "\n";  // string:unknown_format "Unknown format."
        }
        if(v1 != 0 && v1 != 1) {
            s = s + qk.a(0x7F070334) + " " + Tools.a(qk.a(0x7F070338), new Object[]{"\'0\' " + qk.a(0x7F070339) + " \'1\'", "\'" + (v1 & 0xFF) + "\'"}) + "\n";  // string:unknown_endianness "Unknown endianness."
        }
        if(this.k != 4) {
            s = s + Tools.a(qk.a(0x7F070335), new Object[]{"int"}) + " " + Tools.a(qk.a(0x7F070338), new Object[]{"\'4\'", "\'" + this.k + "\'"}) + "\n";  // string:unknown_size_s "Unknown size of __s__."
        }
        if(this.l != 4) {
            s = s + Tools.a(qk.a(0x7F070335), new Object[]{"size_t"}) + " " + Tools.a(qk.a(0x7F070338), new Object[]{"\'4\'", "\'" + this.l + "\'"}) + "\n";  // string:unknown_size_s "Unknown size of __s__."
        }
        if(this.m != 4) {
            s = s + qk.a(0x7F070336) + " " + Tools.a(qk.a(0x7F070338), new Object[]{"\'4\'", "\'" + this.m + "\'"}) + "\n";  // string:unknown_size_instr "Unknown size of instruction."
        }
        if(this.n != 4 && this.n != 8) {
            s = s + qk.a(0x7F070337) + " " + Tools.a(qk.a(0x7F070338), new Object[]{"\'4\' " + qk.a(0x7F070339) + " \'8\'", "\'" + this.n + "\'"}) + "\n";  // string:unknown_size_num "Unknown size of Lua number."
        }
        if(s.length() > 0) {
            if(f.g || rx.c()) {
                String s1 = "-------------------\n" + qk.a(0x7F070331).trim() + "\n\n" + s + "\n" + qk.a(0x7F07033B).trim() + "\n-------------------\n";  // string:invalid_header_1 "Invalid binary script header."
                Tools.a(s1.trim(), 1);
                aj.b.println(s1);
            }
            else {
                f.g = true;
                j j0 = new j();
                j0.a = s.trim();
                synchronized(j0) {
                    rx.a(new g(this, j0));
                    try {
                        j0.wait();
                    }
                    catch(InterruptedException interruptedException0) {
                        la.b("Interrupted wait", interruptedException0);
                        Thread.currentThread().interrupt();
                        throw new o(interruptedException0);
                    }
                    if(j0.a != null) {
                        throw new o(qk.a(0x7F070331).trim() + "\n\n" + s + "\n" + qk.a(0x7F07033B).trim());  // string:invalid_header_1 "Invalid binary script header."
                    }
                }
            }
        }
        for(int v = 0; true; ++v) {
            if(v >= f.d.length) {
                return;
            }
            int v3 = this.e.readByte();
            if(v3 != f.d[v]) {
                throw new o("Unexpected byte in luac tail of header, index = " + v + " (" + (v3 & 0xFF) + ", not " + (f.d[v] & 0xFF) + ")");
            }
        }
    }
}

