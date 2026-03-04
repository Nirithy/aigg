package luaj;

public final class a {
    private static final byte[] a;
    private byte[] b;
    private int c;
    private int d;
    private LuaValue e;

    static {
        a.a = new byte[0];
    }

    public a() {
        this(0x40);
    }

    public a(int v) {
        this.b = new byte[v];
        this.c = 0;
        this.d = 0;
        this.e = null;
    }

    public a(LuaValue luaValue0) {
        this.b = a.a;
        this.d = 0;
        this.c = 0;
        this.e = luaValue0;
    }

    public LuaValue a() {
        return this.e != null ? this.e : this.b();
    }

    public final a a(byte b) {
        this.a(0, 1);
        int v = this.c;
        this.c = v + 1;
        this.b[this.d + v] = b;
        return this;
    }

    // This method was un-flattened
    public final a a(int v) {
        int v4;
        byte[] arr_b;
        int v3;
        int v2;
        int v1;
        if(v < 0 || v > 0x10FFFF) {
            throw new IllegalArgumentException("Code point (" + v + ") out of range [0; " + 0x10FFFF + "]");
        }
        if(v <= 0x7F) {
            v1 = 1;
            v2 = 0;
            this.a(0, 1);
            v3 = this.c + this.d;
            arr_b = this.b;
        }
        else if(v <= 0x7FF) {
            v1 = 2;
            v2 = 0xC0;
            this.a(0, 2);
            v3 = this.c + this.d;
            arr_b = this.b;
            arr_b[v3 + 1] = (byte)(v & 0x3F | 0x80);
            v >>= 6;
        }
        else {
            if(v <= 0xFFFF) {
                v1 = 3;
                v2 = 0xE0;
                this.a(0, 3);
                v3 = this.c + this.d;
                arr_b = this.b;
                arr_b[v3 + 2] = (byte)(v & 0x3F | 0x80);
                v >>= 6;
                v4 = 1;
            }
            else {
                v1 = 4;
                v2 = 0xF0;
                this.a(0, 4);
                v3 = this.c + this.d;
                arr_b = this.b;
                arr_b[v3 + 3] = (byte)(v & 0x3F | 0x80);
                v >>= 6;
                v4 = 2;
            }
            while(true) {
                arr_b[v3 + v4] = (byte)(v & 0x3F | 0x80);
                v >>= 6;
                --v4;
                if(v4 <= 0) {
                    break;
                }
            }
        }
        arr_b[v3] = (byte)(v2 | v);
        this.c += v1;
        return this;
    }

    public final a a(String s) {
        byte[] arr_b = s.getBytes();
        return this.a(arr_b, 0, arr_b.length);
    }

    public final a a(LuaString luaString0) {
        this.a(0, luaString0.d);
        luaString0.a(0, this.b, this.d + this.c, luaString0.d);
        this.c = luaString0.d + this.c;
        return this;
    }

    public a a(LuaValue luaValue0) {
        this.b = a.a;
        this.c = 0;
        this.d = 0;
        this.e = luaValue0;
        return this;
    }

    public final a a(byte[] arr_b, int v, int v1) {
        this.a(0, v1);
        System.arraycopy(arr_b, v, this.b, this.d + this.c, v1);
        this.c += v1;
        return this;
    }

    public final void a(int v, int v1) {
        if(this.e != null) {
            LuaString luaString0 = this.e.t();
            this.e = null;
            this.c = luaString0.d;
            this.d = v;
            this.b = new byte[this.c + v + v1];
            System.arraycopy(luaString0.b, luaString0.c, this.b, this.d, this.c);
            return;
        }
        if(this.d + this.c + v1 > this.b.length || this.d < v) {
            int v2 = this.c + v + v1;
            if(v2 < 0x20) {
                v2 = 0x20;
            }
            else if(v2 < this.c * 2) {
                v2 = this.c * 2;
            }
            this.b(v2, (v == 0 ? 0 : v2 - this.c - v1));
        }
    }

    private final void b(int v, int v1) {
        if(v != this.b.length) {
            byte[] arr_b = new byte[v];
            System.arraycopy(this.b, this.d, arr_b, v1, this.c);
            this.b = arr_b;
            this.d = v1;
        }
    }

    public final LuaString b() {
        this.b(this.c, 0);
        return LuaString.a(this.b, this.d, this.c);
    }

    public final a b(LuaValue luaValue0) {
        this.a(luaValue0.t());
        return this;
    }

    public String c() [...] // 潜在的解密器

    public a c(LuaValue luaValue0) {
        return this.a(luaValue0.u(this.a()));
    }

    // 去混淆评级： 低(20)
    @Override
    public String toString() {
        return "";
    }
}

