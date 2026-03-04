package luaj;

import android.ext.Script.DebugFunction;
import android.ext.la;
import luaj.lib.DebugLib;
import luaj.lib.e;

public class LuaClosure extends LuaFunction {
    public final al a;
    public an[] b;
    final Globals c;
    public String d;
    public volatile int e;
    private static final an[] f;
    private ap g;
    private static int h;

    static {
        LuaClosure.f = new an[0];
        LuaClosure.h = 0;
    }

    public LuaClosure(al al0, LuaValue luaValue0, boolean z) {
        this.d = null;
        this.g = LuaClosure.x;
        this.a = al0;
        if(al0.v != null && al0.v.length != 0) {
            int v = al0.v.length;
            an[] arr_an = new an[v];
            if(z) {
                LuaValue[] arr_luaValue = new LuaValue[v];
                arr_luaValue[0] = luaValue0;
                arr_an[0] = new an(arr_luaValue, 0);
                for(int v1 = 1; v1 < v; ++v1) {
                    arr_luaValue[v1] = LuaClosure.u;
                    arr_an[v1] = new an(arr_luaValue, v1);
                }
            }
            this.b = arr_an;
        }
        else {
            this.b = LuaClosure.f;
        }
        this.c = luaValue0 instanceof Globals ? ((Globals)luaValue0) : null;
    }

    private LuaValue[] S() {
        int v = this.a.B;
        LuaValue[] arr_luaValue = new LuaValue[v];
        System.arraycopy(LuaClosure.ag, 0, arr_luaValue, 0, v);
        return arr_luaValue;
    }

    private an a(LuaValue[] arr_luaValue, short v, an[] arr_an) {
        int v1 = -1;
        for(int v2 = 0; true; ++v2) {
            if(v2 >= arr_an.length) {
                if(v1 >= 0) {
                    an an0 = new an(arr_luaValue, ((int)v));
                    arr_an[v1] = an0;
                    return an0;
                }
                LuaClosure.f(("No space for upvalue " + arr_an.length));
                return null;
            }
            an an1 = arr_an[v2];
            if(an1 != null) {
                if(an1.b == v) {
                    return an1;
                }
            }
            else if(v1 < 0) {
                v1 = v2;
            }
        }
    }

    public static ap a(Globals globals0, LuaFunction luaFunction0, LuaValue luaValue0, ap ap0) {
        ap ap1;
        int v;
        if(globals0 != null && globals0.k != null) {
            globals0.k.a(luaFunction0, false);
        }
        try {
            v = LuaClosure.h;
            LuaClosure.h = 0;
            ap1 = LuaClosure.b(LuaClosure.v, luaValue0.a_(ap0));
            LuaClosure.h = v;
        }
        catch(Throwable throwable0) {
            try {
                o o0 = throwable0 instanceof o ? ((o)throwable0) : new p(throwable0);
                if(o0.h == null) {
                    LuaClosure.a(globals0, o0, null, 0, null);
                }
                LuaValue luaValue1 = o0.a();
                LuaBoolean luaBoolean0 = LuaClosure.w;
                if(luaValue1 == null) {
                    luaValue1 = LuaClosure.u;
                }
                ap1 = LuaClosure.b(luaBoolean0, luaValue1);
                LuaClosure.h = v;
            }
            catch(Throwable throwable1) {
                LuaClosure.h = v;
                if(globals0 != null && globals0.k != null) {
                    globals0.k.S();
                }
                throw throwable1;
            }
            if(globals0 != null && globals0.k != null) {
                globals0.k.S();
                return ap1;
            }
            return ap1;
        }
        if(globals0 != null && globals0.k != null) {
            globals0.k.S();
        }
        return ap1;
    }

    private static o a(int v, int v1, int v2) {
        return new o("Damaged script " + v + ": an attempt to get an upvalue with index " + v1 + " when there are " + v2 + " in total.");
    }

    private static void a(Globals globals0, o o0, StringBuilder stringBuilder0) {
        if(globals0 != null) {
            LuaThread luaThread0 = globals0.h;
            if(luaThread0.g != null) {
                o0.h = stringBuilder0.toString();
                try {
                    LuaValue luaValue0 = luaThread0.g;
                    LuaValue luaValue1 = o0.j == null ? LuaValue.m(o0.h) : o0.j;
                    o0.j = luaValue0.a(luaValue1);
                }
                catch(Throwable unused_ex) {
                    o0.j = LuaValue.m("error in error handling");
                }
                return;
            }
            if(globals0.k != null) {
                stringBuilder0.append('\n');
                stringBuilder0.append(globals0.k.a(globals0, o0.d));
            }
        }
        o0.h = stringBuilder0.toString();
    }

    private static void a(Globals globals0, o o0, al al0, int v, String s) {
        e e1;
        if(o0.h != null) {
            return;
        }
        if(al0 != null) {
            if(globals0 == null || globals0.k == null) {
                e1 = null;
            }
            else {
                e e0 = globals0.k.e(o0.d);
                if(e0 != null) {
                    String s1 = e0.a();
                    if(s1 == null) {
                        s1 = "?";
                    }
                    o0.f = s1;
                    o0.g = e0.c();
                }
                e1 = e0;
            }
            if(e1 == null) {
                o0.f = al0.w == null ? "?" : al0.w.d_();
                o0.g = al0.t == null || v < 0 || v >= al0.t.length ? -1 : al0.t[v];
            }
            o0.b();
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(o0.getMessage());
        if(s != null) {
            stringBuilder0.append(" (");
            stringBuilder0.append(s);
            stringBuilder0.append(")");
        }
        stringBuilder0.append("\nlevel = ");
        stringBuilder0.append(o0.d);
        if(al0 != null) {
            stringBuilder0.append(", const = ");
            stringBuilder0.append(al0.q.length);
            stringBuilder0.append(", proto = ");
            stringBuilder0.append(al0.s.length);
            stringBuilder0.append(", upval = ");
            stringBuilder0.append(al0.v.length);
            stringBuilder0.append(", vars = ");
            stringBuilder0.append(al0.B);
            stringBuilder0.append(", code = ");
            stringBuilder0.append(al0.r.length);
            stringBuilder0.append('\n');
            if(v < 0 || v >= al0.r.length) {
                stringBuilder0.append("PC ");
                stringBuilder0.append(v);
            }
            else {
                aj.a(stringBuilder0, al0, v, null);
                stringBuilder0.append('\n');
                aj.a(stringBuilder0, v, al0.r[v]);
            }
        }
        LuaClosure.a(globals0, o0, stringBuilder0);
    }

    @Override  // luaj.LuaValue
    public final LuaValue a(LuaValue luaValue0) {
        LuaValue[] arr_luaValue = this.S();
        if(this.a.z != 0) {
            arr_luaValue[0] = luaValue0;
            return this.a(arr_luaValue, LuaClosure.x, false).g();
        }
        if(this.a.A == 0) {
            luaValue0 = LuaClosure.x;
        }
        return this.a(arr_luaValue, luaValue0, false).g();
    }

    @Override  // luaj.LuaValue
    public final LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        LuaValue[] arr_luaValue = this.S();
        switch(this.a.z) {
            case 0: {
                return this.a.A == 0 ? this.a(arr_luaValue, LuaClosure.x, false).g() : this.a(arr_luaValue, LuaClosure.b(luaValue0, luaValue1), false).g();
            }
            case 1: {
                arr_luaValue[0] = luaValue0;
                if(this.a.A == 0) {
                    luaValue1 = LuaClosure.x;
                }
                return this.a(arr_luaValue, luaValue1, false).g();
            }
            default: {
                arr_luaValue[0] = luaValue0;
                arr_luaValue[1] = luaValue1;
                return this.a(arr_luaValue, LuaClosure.x, false).g();
            }
        }
    }

    @Override  // luaj.LuaValue
    public final LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        LuaValue[] arr_luaValue = this.S();
        switch(this.a.z) {
            case 0: {
                return this.a.A == 0 ? this.a(arr_luaValue, LuaClosure.x, false).g() : this.a(arr_luaValue, LuaClosure.a(luaValue0, luaValue1, luaValue2), false).g();
            }
            case 1: {
                arr_luaValue[0] = luaValue0;
                return this.a.A == 0 ? this.a(arr_luaValue, LuaClosure.x, false).g() : this.a(arr_luaValue, LuaClosure.b(luaValue1, luaValue2), false).g();
            }
            case 2: {
                arr_luaValue[0] = luaValue0;
                arr_luaValue[1] = luaValue1;
                if(this.a.A == 0) {
                    luaValue2 = LuaClosure.x;
                }
                return this.a(arr_luaValue, luaValue2, false).g();
            }
            default: {
                arr_luaValue[0] = luaValue0;
                arr_luaValue[1] = luaValue1;
                arr_luaValue[2] = luaValue2;
                return this.a(arr_luaValue, LuaClosure.x, false).g();
            }
        }
    }

    @Override  // luaj.LuaValue
    public final ap a(ap ap0, boolean z) {
        LuaValue[] arr_luaValue = this.S();
        if(this.a.B < this.a.z) {
            throw new o("Damaged script: .maxstacksize (" + this.a.B + ") < .numparams (" + this.a.z + ")");
        }
        for(int v = 0; v < this.a.z; ++v) {
            arr_luaValue[v] = ap0.c(v + 1);
        }
        return this.a.A == 0 ? this.a(arr_luaValue, LuaClosure.x, z) : this.a(arr_luaValue, ap0.e_(this.a.z + 1), z);
    }

    protected ap a(LuaValue[] arr_luaValue, ap ap0, boolean z) {
        Throwable throwable6;
        o o1;
        String s2;
        ap ap6;
        ap ap5;
        Throwable throwable2;
        ap ap4;
        int v10;
        int v9;
        int v8;
        ap ap3;
        ap ap2;
        al[] arr_al;
        String s;
        ap ap1;
        LuaBoolean luaBoolean1;
        LuaBoolean luaBoolean0;
        LuaValue luaValue1;
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        LuaValue luaValue0 = LuaClosure.x;
        int[] arr_v = this.a.r;
        LuaValue[] arr_luaValue1 = this.a.q;
        an[] arr_an = this.b;
        this.g = ap0;
        int v6 = arr_luaValue.length;
        an[] arr_an1 = this.a.s.length <= 0 ? null : new an[v6];
        Globals globals0 = this.c;
        DebugLib debugLib0 = globals0 == null ? null : globals0.k;
        if(debugLib0 != null) {
            debugLib0.a(this, this.g, arr_luaValue, z);
        }
        try {
            ++LuaClosure.h;
            luaValue1 = LuaValue.u;
            luaBoolean0 = LuaValue.v;
            luaBoolean1 = LuaValue.w;
            ap1 = LuaValue.x;
            LuaNumber luaNumber0 = LuaValue.y;
            s = this.d;
            arr_al = this.a.s;
            Thread thread0 = Thread.currentThread();
            ap2 = luaValue0;
        alab1:
            while(true) {
            label_27:
                if(thread0.isInterrupted()) {
                    throw new InterruptedException("Script thread interrupted");
                }
                if(debugLib0 != null) {
                    debugLib0.a(v4, ap2, v5);
                }
                this.e = v4;
                v = arr_v[v4];
                v1 = v >> 6 & 0xFF;
                switch(v & 0x3F) {
                    case 0: {
                        goto label_117;
                    }
                    case 1: {
                        goto label_119;
                    }
                    case 2: {
                        goto label_121;
                    }
                    case 3: {
                        goto label_127;
                    }
                    case 4: {
                        goto label_131;
                    }
                    case 5: {
                        goto label_141;
                    }
                    case 6: {
                        goto label_145;
                    }
                    case 7: {
                        goto label_150;
                    }
                    case 8: {
                        goto label_153;
                    }
                    case 9: {
                        goto label_159;
                    }
                    case 10: {
                        goto label_163;
                    }
                    case 11: {
                        goto label_167;
                    }
                    case 12: {
                        goto label_169;
                    }
                    case 13: {
                        goto label_174;
                    }
                    case 14: {
                        goto label_178;
                    }
                    case 15: {
                        goto label_182;
                    }
                    case 16: {
                        goto label_186;
                    }
                    case 17: {
                        goto label_190;
                    }
                    case 18: {
                        goto label_194;
                    }
                    case 19: {
                        goto label_198;
                    }
                    case 20: {
                        goto label_200;
                    }
                    case 21: {
                        goto label_202;
                    }
                    case 22: {
                        goto label_204;
                    }
                    case 23: {
                        goto label_216;
                    }
                    case 24: {
                        goto label_228;
                    }
                    case 25: {
                        goto label_233;
                    }
                    case 26: {
                        goto label_238;
                    }
                    case 27: {
                        goto label_243;
                    }
                    case 28: {
                        goto label_246;
                    }
                    case 29: {
                        goto label_252;
                    }
                    case 30: {
                        this.y(arr_luaValue[v1]);
                        switch(0xFF800000 & v) {
                            case 0x800000: {
                                break;
                            }
                            case 0x1000000: {
                                ap1 = arr_luaValue[v1 + 1];
                                break;
                            }
                            case 0x1800000: {
                                ap1 = LuaClosure.b(arr_luaValue[v1 + 1], arr_luaValue[v1 + 2]);
                                break;
                            }
                            case 0x2000000: {
                                ap1 = LuaClosure.a(arr_luaValue[v1 + 1], arr_luaValue[v1 + 2], arr_luaValue[v1 + 3]);
                                break;
                            }
                            default: {
                                v2 = v >>> 23;
                                ap1 = v2 <= 0 ? LuaClosure.a(arr_luaValue, v1 + 1, v5 - ap2.j_() - (v1 + 1), ap2) : LuaClosure.a(arr_luaValue, v1 + 1, v2 - 1);
                            }
                        }
                        ap3 = new am(globals0, arr_luaValue[v1], ap1);
                        if(!z) {
                            ap3 = ap3.b();
                        }
                        break alab1;
                    }
                    case 0x1F: {
                        goto label_63;
                    }
                    case 0x20: {
                        goto label_346;
                    }
                    case 33: {
                        goto label_357;
                    }
                    case 34: {
                        goto label_365;
                    }
                    case 35: {
                        goto label_379;
                    }
                    case 36: {
                        goto label_383;
                    }
                    case 37: {
                        goto label_410;
                    }
                    case 38: {
                        goto label_426;
                    }
                    case 39: {
                        throw new IllegalArgumentException("Uexecutable opcode: EXTRAARG");
                    }
                    case 40: {
                        goto label_439;
                    }
                    case 41: {
                        goto label_443;
                    }
                    case 42: {
                        goto label_445;
                    }
                    case 43: {
                        goto label_449;
                    }
                    case 44: {
                        goto label_453;
                    }
                    case 45: {
                        goto label_457;
                    }
                    case 46: {
                        goto label_461;
                    }
                    default: {
                        if((v & 0x3F) != 0x3F) {
                            throw new IllegalArgumentException("Illegal opcode: " + (v & 0x3F));
                        }
                        throw new o("Damaged script: 5");
                    }
                }
            }
        }
        catch(o o0) {
            goto label_467;
        }
        catch(StackOverflowError stackOverflowError0) {
            goto label_538;
        }
        catch(InterruptedException interruptedException0) {
            goto label_541;
        }
        catch(Throwable throwable0) {
            goto label_544;
        }
        if(arr_an1 != null) {
            while(true) {
                --v6;
                if(v6 < 0) {
                    break;
                }
                an an0 = arr_an1[v6];
                if(an0 != null) {
                    an0.b();
                }
            }
        }
        if(debugLib0 != null && !z) {
            debugLib0.S();
        }
        this.g = LuaClosure.x;
        --LuaClosure.h;
        return ap3;
        try {
        label_63:
            v2 = v >>> 23;
            switch(v2) {
                case 0: {
                    goto label_78;
                }
                case 1: {
                    goto label_91;
                }
                case 2: {
                    goto label_103;
                }
                default: {
                    ap3 = LuaClosure.a(arr_luaValue, v1, v2 - 1);
                    if(arr_an1 != null) {
                        break;
                    }
                    goto label_73;
                }
            }
        }
        catch(o o0) {
            goto label_467;
        }
        catch(StackOverflowError stackOverflowError0) {
            goto label_538;
        }
        catch(InterruptedException interruptedException0) {
            goto label_541;
        }
        catch(Throwable throwable0) {
            goto label_544;
        }
        while(true) {
            --v6;
            if(v6 < 0) {
                break;
            }
            an an1 = arr_an1[v6];
            if(an1 != null) {
                an1.b();
            }
        }
    label_73:
        if(debugLib0 != null && !z) {
            debugLib0.S();
        }
        this.g = LuaClosure.x;
        --LuaClosure.h;
        return ap3;
        try {
        label_78:
            ap3 = LuaClosure.a(arr_luaValue, v1, v5 - ap2.j_() - v1, ap2);
            if(arr_an1 != null) {
                goto label_80;
            }
            goto label_86;
        }
        catch(o o0) {
            goto label_467;
        }
        catch(StackOverflowError stackOverflowError0) {
            goto label_538;
        }
        catch(InterruptedException interruptedException0) {
            goto label_541;
        }
        catch(Throwable throwable0) {
            goto label_544;
        }
        while(true) {
        label_80:
            --v6;
            if(v6 < 0) {
                break;
            }
            an an2 = arr_an1[v6];
            if(an2 != null) {
                an2.b();
            }
        }
    label_86:
        if(debugLib0 != null && !z) {
            debugLib0.S();
        }
        this.g = LuaClosure.x;
        --LuaClosure.h;
        return ap3;
    label_91:
        if(arr_an1 != null) {
            while(true) {
                --v6;
                if(v6 < 0) {
                    break;
                }
                an an3 = arr_an1[v6];
                if(an3 != null) {
                    an3.b();
                }
            }
        }
        if(debugLib0 != null && !z) {
            debugLib0.S();
        }
        this.g = LuaClosure.x;
        --LuaClosure.h;
        return ap1;
        try {
        label_103:
            ap3 = arr_luaValue[v1];
            if(arr_an1 != null) {
                goto label_105;
            }
            goto label_111;
        }
        catch(o o0) {
            goto label_467;
        }
        catch(StackOverflowError stackOverflowError0) {
            goto label_538;
        }
        catch(InterruptedException interruptedException0) {
            goto label_541;
        }
        catch(Throwable throwable0) {
            goto label_544;
        }
        while(true) {
        label_105:
            --v6;
            if(v6 < 0) {
                break;
            }
            an an4 = arr_an1[v6];
            if(an4 != null) {
                an4.b();
            }
        }
    label_111:
        if(debugLib0 != null && !z) {
            debugLib0.S();
        }
        this.g = LuaClosure.x;
        --LuaClosure.h;
        return ap3;
        try {
            throw new IllegalArgumentException("Uexecutable opcode: EXTRAARG");
        label_117:
            arr_luaValue[v1] = arr_luaValue[v >>> 23];
            goto label_464;
        label_119:
            arr_luaValue[v1] = arr_luaValue1[v >>> 14];
            goto label_464;
        label_121:
            ++v4;
            v = arr_v[v4];
            if((v & 0x3F) != 39) {
                throw new o("EXTRAARG expected after LOADKX, got " + ((v & 0x3F) >= aj.c.length - 1 ? "UNKNOWN_OP_" + (v & 0x3F) : aj.c[v & 0x3F]));
            }
            arr_luaValue[v1] = arr_luaValue1[v >>> 6];
            goto label_464;
        label_127:
            arr_luaValue[v1] = v >>> 23 == 0 ? luaBoolean1 : luaBoolean0;
            if((0x7FC000 & v) != 0) {
                ++v4;
            }
            goto label_464;
        }
        catch(o o0) {
            goto label_467;
        }
        catch(StackOverflowError stackOverflowError0) {
            goto label_538;
        }
        catch(InterruptedException interruptedException0) {
            goto label_541;
        }
        catch(Throwable throwable0) {
            goto label_544;
        }
    label_131:
        int v7 = v >>> 23;
        while(true) {
            v2 = v7 - 1;
            if(v7 < 0) {
                goto label_464;
            }
            try {
                arr_luaValue[v1] = luaValue1;
                v7 = v2;
                ++v1;
            }
            catch(o o0) {
                break;
            }
            catch(StackOverflowError stackOverflowError0) {
                goto label_538;
            }
            catch(InterruptedException interruptedException0) {
                goto label_541;
            }
            catch(Throwable throwable0) {
                goto label_544;
            }
        }
        ++v1;
        goto label_468;
        try {
        label_141:
            if(v >>> 23 >= arr_an.length) {
                throw LuaClosure.a(1, v >>> 23, arr_an.length);
            }
            arr_luaValue[v1] = arr_an[v >>> 23].a();
            goto label_464;
        label_145:
            if(v >>> 23 >= arr_an.length) {
                throw LuaClosure.a(2, v >>> 23, arr_an.length);
            }
            v3 = v >> 14 & 0x1FF;
            arr_luaValue[v1] = arr_an[v >>> 23].a().w((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_150:
            v3 = v >> 14 & 0x1FF;
            arr_luaValue[v1] = arr_luaValue[v >>> 23].w((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_153:
            if(v1 >= arr_an.length) {
                throw LuaClosure.a(3, v1, arr_an.length);
            }
            v2 = v >>> 23;
            v3 = v >> 14 & 0x1FF;
            arr_an[v1].a().b((v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]), (v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_159:
            if(v >>> 23 >= arr_an.length) {
                throw LuaClosure.a(4, v >>> 23, arr_an.length);
            }
            arr_an[v >>> 23].a(arr_luaValue[v1]);
            goto label_464;
        label_163:
            v2 = v >>> 23;
            v3 = v >> 14 & 0x1FF;
            arr_luaValue[v1].b((v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]), (v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_167:
            arr_luaValue[v1] = new LuaTable(v >>> 23, v >> 14 & 0x1FF);
            goto label_464;
        label_169:
            LuaValue luaValue2 = arr_luaValue[v >>> 23];
            arr_luaValue[v1 + 1] = luaValue2;
            v3 = v >> 14 & 0x1FF;
            arr_luaValue[v1] = luaValue2.w((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_174:
            v2 = v >>> 23;
            v3 = v >> 14 & 0x1FF;
            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).d((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_178:
            v2 = v >>> 23;
            v3 = v >> 14 & 0x1FF;
            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).e((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_182:
            v2 = v >>> 23;
            v3 = v >> 14 & 0x1FF;
            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).f((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_186:
            v2 = v >>> 23;
            v3 = v >> 14 & 0x1FF;
            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).h((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_190:
            v2 = v >>> 23;
            v3 = v >> 14 & 0x1FF;
            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).j((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_194:
            v2 = v >>> 23;
            v3 = v >> 14 & 0x1FF;
            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).g((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
            goto label_464;
        label_198:
            arr_luaValue[v1] = arr_luaValue[v >>> 23].r();
            goto label_464;
        label_200:
            arr_luaValue[v1] = arr_luaValue[v >>> 23].k_();
            goto label_464;
        label_202:
            arr_luaValue[v1] = arr_luaValue[v >>> 23].K();
            goto label_464;
        label_204:
            v2 = v >>> 23;
            v3 = v >> 14 & 0x1FF;
            if(v3 > v2 + 1) {
                a a0 = arr_luaValue[v3].ab();
                while(true) {
                    --v3;
                    if(v3 < v2) {
                        break;
                    }
                    a0.c(arr_luaValue[v3]);
                }
                arr_luaValue[v1] = a0.a();
            }
            else {
                arr_luaValue[v1] = arr_luaValue[v3 - 1].u(arr_luaValue[v3]);
            }
            goto label_464;
        label_216:
            v4 += (v >>> 14) - 0x1FFFF;
            if(v1 > 0) {
                --v1;
                if(arr_an1 != null) {
                    v2 = v6;
                    while(true) {
                        --v2;
                        if(v2 < 0) {
                            goto label_464;
                        }
                        an an5 = arr_an1[v2];
                        if(an5 != null && an5.b >= v1) {
                            an5.b();
                            arr_an1[v2] = null;
                        }
                    }
                label_228:
                    v2 = v >>> 23;
                    v3 = v >> 14 & 0x1FF;
                    if((v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).b((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF])) != (v1 != 0)) {
                        ++v4;
                        goto label_464;
                    label_233:
                        v2 = v >>> 23;
                        v3 = v >> 14 & 0x1FF;
                        if((v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).p((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF])) != (v1 != 0)) {
                            ++v4;
                            goto label_464;
                        label_238:
                            v2 = v >>> 23;
                            v3 = v >> 14 & 0x1FF;
                            if((v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).q((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF])) != (v1 != 0)) {
                                ++v4;
                                goto label_464;
                            label_243:
                                if(arr_luaValue[v1].i_() != ((0x7FC000 & v) != 0)) {
                                    ++v4;
                                    goto label_464;
                                label_246:
                                    LuaValue luaValue3 = arr_luaValue[v >>> 23];
                                    if(luaValue3.i_() == ((0x7FC000 & v) != 0)) {
                                        arr_luaValue[v1] = luaValue3;
                                    }
                                    else {
                                        ++v4;
                                    }
                                    goto label_464;
                                label_252:
                                    this.y(arr_luaValue[v1]);
                                    if(debugLib0 != null) {
                                        try {
                                            if(arr_luaValue[v1].j()) {
                                            label_257:
                                                v8 = 0;
                                            }
                                            else {
                                                v8 = 1;
                                            }
                                            if(v8 == 0) {
                                                v9 = 0;
                                            }
                                            else if(arr_luaValue[v1].B()) {
                                                debugLib0.a(arr_luaValue[v1].C(), false);
                                                v9 = v8;
                                            }
                                            else {
                                                v9 = 0;
                                            }
                                            goto label_266;
                                        }
                                        catch(NullPointerException nullPointerException0) {
                                            goto label_331;
                                        }
                                    }
                                    goto label_257;
                                }
                            }
                        }
                    }
                }
            }
            goto label_464;
        }
        catch(o o0) {
            goto label_467;
        }
        catch(StackOverflowError stackOverflowError0) {
            goto label_538;
        }
        catch(InterruptedException interruptedException0) {
            goto label_541;
        }
        catch(Throwable throwable0) {
            goto label_544;
        }
    label_266:
        switch(v & 0xFFFFC000) {
            case 0x800000: {
                try {
                label_288:
                    ap5 = this.c(arr_luaValue[v1].a_(ap1));
                    goto label_295;
                label_290:
                    arr_luaValue[v1].l();
                    break;
                label_292:
                    arr_luaValue[v1] = this.z(arr_luaValue[v1].l());
                    break;
                label_294:
                    ap5 = this.c(arr_luaValue[v1].a_(arr_luaValue[v1 + 1]));
                    goto label_295;
                }
                catch(Throwable throwable2) {
                    goto label_315;
                }
            }
            case 0x804000: {
                goto label_290;
            }
            case 0x808000: {
                goto label_292;
            }
            case 0x1000000: {
                goto label_294;
                try {
                label_295:
                    v5 = v1 + ap5.j_();
                    ap2 = ap5;
                    break;
                }
                catch(Throwable throwable4) {
                    throwable2 = throwable4;
                    v10 = v3;
                    goto label_317;
                }
            }
            case 0x1004000: {
                try {
                    arr_luaValue[v1].a(arr_luaValue[v1 + 1]);
                    break;
                label_304:
                    arr_luaValue[v1] = this.z(arr_luaValue[v1].a(arr_luaValue[v1 + 1]));
                    break;
                label_306:
                    arr_luaValue[v1].a(arr_luaValue[v1 + 1], arr_luaValue[v1 + 2]);
                    break;
                label_308:
                    arr_luaValue[v1] = this.z(arr_luaValue[v1].a(arr_luaValue[v1 + 1], arr_luaValue[v1 + 2]));
                    break;
                label_310:
                    arr_luaValue[v1].a(arr_luaValue[v1 + 1], arr_luaValue[v1 + 2], arr_luaValue[v1 + 3]);
                    break;
                label_312:
                    arr_luaValue[v1] = this.z(arr_luaValue[v1].a(arr_luaValue[v1 + 1], arr_luaValue[v1 + 2], arr_luaValue[v1 + 3]));
                    break;
                }
                catch(Throwable throwable2) {
                }
                goto label_315;
            }
            case 0x1008000: {
                goto label_304;
            }
            case 0x1804000: {
                goto label_306;
            }
            case 0x1808000: {
                goto label_308;
            }
            case 0x2004000: {
                goto label_310;
            }
            case 0x2008000: {
                goto label_312;
            label_315:
                ap5 = ap2;
                v10 = v3;
                try {
                label_317:
                    if(v9 != 0) {
                        debugLib0.S();
                    }
                    throw throwable2;
                }
                catch(NullPointerException nullPointerException1) {
                }
                catch(o o0) {
                    goto label_325;
                }
                catch(StackOverflowError stackOverflowError0) {
                    goto label_538;
                }
                catch(InterruptedException interruptedException0) {
                    goto label_541;
                }
                catch(Throwable throwable0) {
                    goto label_544;
                }
                nullPointerException0 = nullPointerException1;
                v3 = v10;
                goto label_332;
            label_325:
                v3 = v10;
                goto label_468;
            }
            default: {
                try {
                    v2 = v >>> 23;
                    v10 = v >> 14 & 0x1FF;
                    ap4 = this.c(arr_luaValue[v1].a_((v2 <= 0 ? LuaClosure.a(arr_luaValue, v1 + 1, v5 - ap2.j_() - (v1 + 1), ap2) : LuaClosure.a(arr_luaValue, v1 + 1, v2 - 1))));
                }
                catch(Throwable throwable1) {
                    throwable2 = throwable1;
                    ap5 = ap2;
                    goto label_317;
                }
                if(v10 > 0) {
                    try {
                        ap4.b(arr_luaValue, v1, v10 - 1);
                        ap2 = ap1;
                        v3 = v10;
                        break;
                    label_280:
                        v5 = v1 + ap4.j_();
                        ap2 = ap4.ae();
                        v3 = v10;
                        break;
                    }
                    catch(Throwable throwable3) {
                    }
                    goto label_285;
                }
                else {
                    goto label_280;
                label_285:
                    throwable2 = throwable3;
                    ap5 = ap4;
                    goto label_317;
                }
                goto label_288;
            }
        }
        if(v9 != 0) {
            try {
                debugLib0.S();
                goto label_464;
            }
            catch(NullPointerException nullPointerException0) {
            }
            catch(o o0) {
                goto label_467;
            }
            catch(StackOverflowError stackOverflowError0) {
                goto label_538;
            }
            catch(InterruptedException interruptedException0) {
                goto label_541;
            }
            catch(Throwable throwable0) {
                goto label_544;
            }
        label_331:
            ap5 = ap2;
            try {
            label_332:
                String s1 = "";
                switch(v & 0xFFFFC000) {
                    case 0x800000: {
                        s1 = ((LuaValue)ap1).toString();
                        break;
                    }
                    case 0x804000: 
                    case 0x808000: {
                        break;
                    }
                    case 0x1000000: 
                    case 0x1004000: 
                    case 0x1008000: {
                        s1 = arr_luaValue[v1 + 1].toString();
                        break;
                    }
                    case 0x1804000: 
                    case 0x1808000: {
                        s1 = arr_luaValue[v1 + 1] + ", " + arr_luaValue[v1 + 2];
                        break;
                    }
                    case 0x2004000: 
                    case 0x2008000: {
                        s1 = arr_luaValue[v1 + 1] + ", " + arr_luaValue[v1 + 2] + ", " + arr_luaValue[v1 + 3];
                        break;
                    }
                    default: {
                        s1 = (v2 <= 0 ? LuaClosure.a(arr_luaValue, v1 + 1, v5 - ap5.j_() - (v1 + 1), ap5) : LuaClosure.a(arr_luaValue, v1 + 1, v2 - 1)).toString();
                    }
                }
                NullPointerException nullPointerException2 = new NullPointerException("Null from " + arr_luaValue[v1].getClass().getName() + " (" + s1 + ")");
                nullPointerException2.initCause(nullPointerException0);
                throw nullPointerException2;
            label_346:
                LuaValue luaValue4 = arr_luaValue[v1 + 1];
                LuaValue luaValue5 = arr_luaValue[v1 + 2];
                LuaValue luaValue6 = arr_luaValue[v1].d(luaValue5);
                if(!luaValue5.r(luaNumber0)) {
                    if(luaValue6.s(luaValue4)) {
                    label_353:
                        arr_luaValue[v1] = luaValue6;
                        arr_luaValue[v1 + 3] = luaValue6;
                        v4 += (v >>> 14) - 0x1FFFF;
                        goto label_464;
                    label_357:
                        LuaNumber luaNumber1 = arr_luaValue[v1].b("\'for\' initial value must be a number");
                        LuaNumber luaNumber2 = arr_luaValue[v1 + 1].b("\'for\' limit must be a number");
                        LuaNumber luaNumber3 = arr_luaValue[v1 + 2].b("\'for\' step must be a number");
                        arr_luaValue[v1] = luaNumber1.e(luaNumber3);
                        arr_luaValue[v1 + 1] = luaNumber2;
                        arr_luaValue[v1 + 2] = luaNumber3;
                        v4 += (v >>> 14) - 0x1FFFF;
                        goto label_464;
                    label_365:
                        this.y(arr_luaValue[v1]);
                        try {
                            ap6 = this.c(arr_luaValue[v1].a_(LuaClosure.b(arr_luaValue[v1 + 1], arr_luaValue[v1 + 2])));
                            v3 = v >> 14 & 0x1FF;
                        }
                        catch(NullPointerException nullPointerException3) {
                            NullPointerException nullPointerException4 = new NullPointerException("Null from " + arr_luaValue[v1].getClass().getName() + " (" + LuaClosure.b(arr_luaValue[v1 + 1], arr_luaValue[v1 + 2]) + ")");
                            nullPointerException4.initCause(nullPointerException3);
                            throw nullPointerException4;
                        }
                        while(true) {
                            --v3;
                            if(v3 < 0) {
                                ap2 = ap1;
                                goto label_464;
                            }
                            arr_luaValue[v1 + 3 + v3] = ap6.c(v3 + 1);
                        }
                    label_379:
                        if(!arr_luaValue[v1 + 1].F()) {
                            arr_luaValue[v1] = arr_luaValue[v1 + 1];
                            v4 += (v >>> 14) - 0x1FFFF;
                            goto label_464;
                        label_383:
                            v3 = v >> 14 & 0x1FF;
                            if(v3 == 0) {
                                ++v4;
                                v3 = arr_v[v4];
                            }
                            int v11 = (v3 - 1) * 50;
                            LuaValue luaValue7 = arr_luaValue[v1];
                            v2 = v >>> 23;
                            if(v2 == 0) {
                                v2 = v5 - v1 - 1;
                                int v12 = v2 - ap2.j_();
                                int v13;
                                for(v13 = 1; v13 <= v12; ++v13) {
                                    luaValue7.a(v11 + v13, arr_luaValue[v1 + v13]);
                                }
                                while(v13 <= v2) {
                                    luaValue7.a(v11 + v13, ap2.c(v13 - v12));
                                    ++v13;
                                }
                            }
                            else {
                                luaValue7.d_(v11 + v2);
                                for(int v14 = 1; v14 <= v2; ++v14) {
                                    luaValue7.a(v11 + v14, arr_luaValue[v1 + v14]);
                                }
                            }
                            goto label_464;
                        label_410:
                            al al0 = arr_al[v >>> 14];
                            LuaClosure luaClosure0 = new LuaClosure(al0, globals0, false);
                            luaClosure0.d = s;
                            ao[] arr_ao = al0.v;
                            an[] arr_an2 = luaClosure0.b;
                            for(int v15 = 0; v15 < arr_ao.length; ++v15) {
                                ao ao0 = arr_ao[v15];
                                arr_an2[v15] = ao0.b ? this.a(arr_luaValue, ao0.c, arr_an1) : arr_an[ao0.c];
                            }
                            arr_luaValue[v1] = luaClosure0;
                            goto label_464;
                        label_426:
                            v2 = v >>> 23;
                            if(v2 == 0) {
                                ap2 = this.g;
                                v2 = ap2.j_();
                                v5 = v1 + v2;
                            }
                            else {
                                ap ap7 = this.g;
                                for(int v16 = 1; v16 < v2; ++v16) {
                                    arr_luaValue[v1 + v16 - 1] = ap7.c(v16);
                                }
                            }
                            goto label_464;
                        label_439:
                            v2 = v >>> 23;
                            v3 = v >> 14 & 0x1FF;
                            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).i((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
                            goto label_464;
                        label_443:
                            arr_luaValue[v1] = arr_luaValue[v >>> 23].s();
                            goto label_464;
                        label_445:
                            v2 = v >>> 23;
                            v3 = v >> 14 & 0x1FF;
                            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).k((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
                            goto label_464;
                        label_449:
                            v2 = v >>> 23;
                            v3 = v >> 14 & 0x1FF;
                            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).l((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
                            goto label_464;
                        label_453:
                            v2 = v >>> 23;
                            v3 = v >> 14 & 0x1FF;
                            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).m((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
                            goto label_464;
                        label_457:
                            v2 = v >>> 23;
                            v3 = v >> 14 & 0x1FF;
                            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).n((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
                            goto label_464;
                        label_461:
                            v2 = v >>> 23;
                            v3 = v >> 14 & 0x1FF;
                            arr_luaValue[v1] = (v2 <= 0xFF ? arr_luaValue[v2] : arr_luaValue1[v2 & 0xFF]).o((v3 <= 0xFF ? arr_luaValue[v3] : arr_luaValue1[v3 & 0xFF]));
                        }
                    }
                }
                else if(luaValue6.q(luaValue4)) {
                    goto label_353;
                }
            label_464:
                ++v4;
                goto label_27;
            }
            catch(o o0) {
                goto label_467;
            }
            catch(StackOverflowError stackOverflowError0) {
                goto label_538;
            }
            catch(InterruptedException interruptedException0) {
                goto label_541;
            }
            catch(Throwable throwable0) {
                goto label_544;
            }
        }
        goto label_464;
    label_467:
        try {
        label_468:
            if(o0.h == null) {
                int v17 = -1;
                switch(v & 0x3F) {
                    case 8: {
                        v17 = v1;
                        v3 = -1;
                        break;
                    }
                    case 5: 
                    case 6: 
                    case 9: {
                        v17 = v >>> 23;
                        v3 = -1;
                        break;
                    }
                    case 22: {
                        int v18 = v >> 14 & 0x1FF;
                        if(v18 > (v >>> 23) + 1) {
                            if(arr_luaValue[v3].J()) {
                                if(arr_luaValue[v18].J()) {
                                    goto label_504;
                                }
                                else {
                                    v3 = v18;
                                }
                            }
                        }
                        else if(!arr_luaValue[v3 - 1].J()) {
                            --v3;
                        }
                        else if(!arr_luaValue[v3].J()) {
                        }
                        else {
                            goto label_504;
                        }
                        break;
                    }
                    case 24: {
                        v3 = -1;
                        break;
                    }
                    case 25: 
                    case 26: {
                        if(v2 <= 0xFF && !arr_luaValue[v2].J()) {
                            v3 = v2;
                        }
                        else if(v3 > 0xFF || arr_luaValue[v3].J()) {
                        label_504:
                            v3 = -1;
                        }
                        break;
                    }
                    case 10: 
                    case 27: 
                    case 29: 
                    case 30: 
                    case 34: 
                    case 36: {
                        v3 = v1;
                        break;
                    }
                    case 13: 
                    case 14: 
                    case 15: 
                    case 16: 
                    case 17: 
                    case 18: 
                    case 40: {
                        if(v2 <= 0xFF && !arr_luaValue[v2].I()) {
                            v3 = v2;
                        }
                        else if(v3 <= 0xFF && !arr_luaValue[v3].I()) {
                        }
                        else {
                            goto label_504;
                        }
                        break;
                    }
                    case 7: 
                    case 12: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 28: 
                    case 41: {
                        v3 = v >>> 23;
                        break;
                    }
                    case 42: 
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: {
                        if(v2 <= 0xFF && !arr_luaValue[v2].n()) {
                            v3 = v2;
                        }
                        else if(v3 > 0xFF || arr_luaValue[v3].n()) {
                            v3 = -1;
                        }
                        break;
                    }
                    default: {
                        goto label_504;
                    }
                }
                if(v17 >= 0) {
                    StringBuilder stringBuilder0 = new StringBuilder("upvalue \'");
                    LuaString luaString0 = v17 < this.a.v.length ? this.a.v[v17].a : "?";
                    s2 = stringBuilder0.append(luaString0).append("\'").toString();
                }
                else {
                    s2 = DebugLib.a(v4, v3, this.a);
                }
                if(s2 != null && s2.startsWith("method ") && o0 instanceof n) {
                    o0 = new n(((n)o0));
                }
                LuaClosure.a(this.c, o0, this.a, v4, s2);
            }
            o1 = o0;
            if(o1 instanceof q && LuaClosure.h == 1) {
                throwable6 = o1.getCause();
                if(throwable6 != null) {
                    la.b(("Stack overflow 1: " + throwable6.getMessage()));
                    goto label_530;
                }
            }
            throw o1;
        }
        catch(Throwable throwable5) {
            goto label_548;
        }
        try {
        label_530:
            la.b("Stack overflow 2", throwable6);
            throw o1;
        }
        catch(Throwable throwable7) {
            try {
                la.b("Stack overflow 3", throwable7);
                throw o1;
            }
            catch(Throwable unused_ex) {
                try {
                    la.b(("Stack overflow 4: " + throwable7.getMessage()));
                    throw o1;
                label_538:
                    String s3 = stackOverflowError0.getMessage();
                    throw new q((s3 == null ? "stack overflow" : "stack overflow (" + s3 + ")"), stackOverflowError0);
                label_541:
                    la.b("Interrupted closure", interruptedException0);
                    throw new o(interruptedException0);
                label_544:
                    p p0 = new p(throwable0);
                    LuaClosure.a(this.c, p0, this.a, v4, null);
                    throw p0;
                }
                catch(Throwable throwable5) {
                }
            }
        }
    label_548:
        if(arr_an1 != null) {
            int v19 = v6;
            while(true) {
                --v19;
                if(v19 < 0) {
                    break;
                }
                an an6 = arr_an1[v19];
                if(an6 != null) {
                    an6.b();
                }
            }
        }
        if(debugLib0 != null && !z) {
            debugLib0.S();
        }
        this.g = LuaClosure.x;
        --LuaClosure.h;
        throw throwable5;
    }

    @Override  // luaj.LuaValue
    public final ap a_(ap ap0) {
        return this.a(ap0, false).b();
    }

    public void b(ap ap0) {
        this.g = ap0;
    }

    private ap c(ap ap0) {
        if(ap0 == null) {
            throw new NullPointerException("return null as Varargs");
        }
        return ap0;
    }

    // 去混淆评级： 低(40)
    @Override  // luaj.LuaFunction
    public String d_() {
        return "function: null:0-0";
    }

    // 去混淆评级： 中等(50)
    @Override  // luaj.LuaFunction
    public String g_() {
        return "<null" + ':' + this.a.x + '>';
    }

    @Override  // luaj.LuaValue
    public boolean j() {
        return true;
    }

    @Override  // luaj.LuaValue
    public LuaClosure k() {
        return this;
    }

    @Override  // luaj.LuaValue
    public final LuaValue l() {
        return this.a(this.S(), LuaClosure.x, false).g();
    }

    public ap m() {
        return this.g;
    }

    private void y(LuaValue luaValue0) {
        if(luaValue0 instanceof Script.DebugFunction) {
            ((Script.DebugFunction)luaValue0).a(this);
        }
    }

    private LuaValue z(LuaValue luaValue0) {
        if(luaValue0 == null) {
            throw new NullPointerException("return null as LuaValue");
        }
        return luaValue0;
    }
}

