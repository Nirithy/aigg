package luaj.a;

import java.io.DataOutputStream;
import java.io.OutputStream;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.aj;
import luaj.al;
import luaj.ao;
import luaj.f;
import luaj.l;

public class b {
    DataOutputStream a;
    boolean b;
    boolean c;
    int d;
    private boolean e;
    private int f;
    private int g;

    public b(OutputStream outputStream0, boolean z, boolean z1) {
        this.e = true;
        this.f = 0;
        this.g = 8;
        this.a = new DataOutputStream(outputStream0);
        this.b = z;
        this.c = z1;
        this.d = 0;
    }

    public static int a(al al0, OutputStream outputStream0, boolean z, boolean z1) {
        b b0 = new b(outputStream0, z, z1);
        b0.a();
        b0.b(al0, null);
        return b0.d;
    }

    void a() {
        int v = 0;
        DataOutputStream dataOutputStream0 = this.a;
        dataOutputStream0.write(f.c);
        dataOutputStream0.write(82);
        dataOutputStream0.write(0);
        if(this.e) {
            v = 1;
        }
        dataOutputStream0.write(v);
        dataOutputStream0.write(4);
        dataOutputStream0.write(4);
        dataOutputStream0.write(4);
        dataOutputStream0.write(this.g);
        dataOutputStream0.write(this.f);
        dataOutputStream0.write(f.d);
    }

    void a(double f) {
        this.a.writeLong((this.e ? Long.reverseBytes(Double.doubleToLongBits(f)) : Double.doubleToLongBits(f)));
    }

    void a(int v) {
        this.a.write(v);
    }

    void a(LuaString luaString0) {
        if(luaString0 == null) {
            luaString0 = LuaValue.m("");
        }
        int v = luaString0.K().p();
        this.b(v + 1);
        luaString0.a(this.a, 0, v);
        this.a.write(0);
    }

    void a(al al0) {
        int[] arr_v = al0.r;
        int v = arr_v.length;
        this.b(v);
        if(this.c) {
            arr_v = new int[v];
        }
        if(this.c) {
            aj.a(al0, arr_v);
        }
        for(int v1 = 0; v1 < v; ++v1) {
            this.b(arr_v[v1]);
        }
    }

    void a(al al0, LuaString luaString0) {
        if(!this.b && (luaString0 == null || !luaString0.b(al0.w))) {
            this.a(al0.w);
        }
        else {
            this.b(0);
        }
        int[] arr_v = al0.t;
        int v1 = this.b ? 0 : arr_v.length;
        this.b(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            this.b(arr_v[v2]);
        }
        l[] arr_l = al0.u;
        int v3 = this.b ? 0 : arr_l.length;
        this.b(v3);
        for(int v4 = 0; v4 < v3; ++v4) {
            l l0 = arr_l[v4];
            this.a(l0.a);
            this.b(l0.b);
            this.b(l0.c);
        }
        ao[] arr_ao = al0.v;
        int v5 = this.b ? 0 : arr_ao.length;
        this.b(v5);
        for(int v = 0; v < v5; ++v) {
            this.a(arr_ao[v].a);
        }
    }

    void b(int v) {
        DataOutputStream dataOutputStream0 = this.a;
        if(this.e) {
            v = Integer.reverseBytes(v);
        }
        dataOutputStream0.writeInt(v);
    }

    void b(al al0) {
        DataOutputStream dataOutputStream0 = this.a;
        LuaValue[] arr_luaValue = al0.q;
        this.b(arr_luaValue.length);
        for(int v1 = 0; true; ++v1) {
            if(v1 >= arr_luaValue.length) {
                int v2 = al0.s.length;
                this.b(v2);
                for(int v = 0; v < v2; ++v) {
                    this.b(al0.s[v], al0.w);
                }
                return;
            }
            LuaValue luaValue0 = arr_luaValue[v1];
            switch(luaValue0.e_()) {
                case 0: {
                    dataOutputStream0.write(0);
                    break;
                }
                case 1: {
                    dataOutputStream0.write(1);
                    this.a((luaValue0.i_() ? 1 : 0));
                    break;
                }
                case 3: {
                    switch(this.f) {
                        case 0: {
                            dataOutputStream0.write(3);
                            this.a(luaValue0.o());
                            break;
                        }
                        case 1: {
                            if(!luaValue0.h_()) {
                                throw new IllegalArgumentException("not an integer: " + luaValue0);
                            }
                            dataOutputStream0.write(3);
                            this.b(luaValue0.p());
                            break;
                        }
                        case 4: {
                            if(luaValue0.h_()) {
                                dataOutputStream0.write(-2);
                                this.b(luaValue0.p());
                            }
                            else {
                                dataOutputStream0.write(3);
                                this.a(luaValue0.o());
                            }
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException("number format not supported: " + this.f);
                        }
                    }
                    break;
                }
                case 4: {
                    dataOutputStream0.write(4);
                    this.a(((LuaString)luaValue0));
                    break;
                }
                default: {
                    throw new IllegalArgumentException("bad type for " + luaValue0);
                }
            }
        }
    }

    void b(al al0, LuaString luaString0) {
        this.b(al0.x);
        this.b(al0.y);
        this.a(al0.z);
        this.a(al0.A);
        this.a(al0.B);
        this.a(al0);
        this.b(al0);
        this.c(al0);
        this.a(al0, luaString0);
    }

    void c(al al0) {
        DataOutputStream dataOutputStream0 = this.a;
        ao[] arr_ao = al0.v;
        this.b(arr_ao.length);
        for(int v = 0; v < arr_ao.length; ++v) {
            ao ao0 = arr_ao[v];
            dataOutputStream0.writeByte((ao0.b ? 1 : 0));
            dataOutputStream0.writeByte(((int)ao0.c));
        }
    }
}

