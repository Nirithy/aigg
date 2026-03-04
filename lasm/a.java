package lasm;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import luaj.LuaLong;
import luaj.LuaValue;
import luaj.al;

public class a extends LasmBase implements b {
    public f a;
    h b;
    public i c;
    public i d;
    private int f;
    private int g;
    private final int[] h;
    private static int[] i;
    private static int[] j;
    private static int[] k;
    private List l;
    private int[] m;
    private int n;

    static {
        a.j();
        a.k();
        a.l();
    }

    public a(InputStream inputStream0) {
        this(inputStream0, null);
    }

    public a(InputStream inputStream0, String s) {
        this.h = new int[34];
        this.l = new ArrayList();
        this.n = -1;
        try {
            this.b = new h(inputStream0, s, 1, 1);
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new RuntimeException(unsupportedEncodingException0);
        }
        this.a = new f(this.b);
        this.c = new i();
        this.f = -1;
        this.g = 0;
        for(int v = 0; v < 34; ++v) {
            this.h[v] = -1;
        }
    }

    private i a(int v) {
        i i0 = this.c;
        if(i0.g == null) {
            i i1 = this.c;
            i i2 = this.a.b();
            i1.g = i2;
            this.c = i2;
        }
        else {
            this.c = this.c.g;
        }
        this.f = -1;
        if(this.c.a == v) {
            ++this.g;
            return this.c;
        }
        this.c = i0;
        this.n = v;
        throw this.i();
    }

    public final al a() {
        if((this.f == -1 ? this.m() : this.f) == 74) {
            this.a(74);
        }
        else {
            this.h[0] = this.g;
        }
        al al0 = this.b();
        this.a(0);
        return al0;
    }

    public final void a(d d0) {
        this.a(72);
        i i0 = this.a(61);
        this.a(74);
        d0.a(i0, this.b());
        this.a(73);
        this.a(74);
    }

    public final d b() {
        d d0 = new d();
        this.a(62);
        this.a(81);
        d0.w = a.e(this.c);
        this.a(74);
        this.a(0x3F);
        this.a(0x4F);
        d0.x = a.a(this.c);
        this.a(74);
        this.a(0x40);
        this.a(0x4F);
        d0.y = a.a(this.c);
        this.a(74);
        this.a(65);
        this.a(0x4F);
        d0.z = a.a(this.c, 0xFF);
        this.a(74);
        this.a(66);
        this.a(0x4F);
        d0.A = a.a(this.c, 0xFF);
        this.a(74);
        this.a(67);
        this.a(0x4F);
        d0.a(this.c);
        this.a(74);
        while((this.f == -1 ? this.m() : this.f) == 68) {
            this.b(d0);
        }
        this.h[1] = this.g;
    label_29:
        this.c(d0);
        switch((this.f == -1 ? this.m() : this.f)) {
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 0x1F: 
            case 0x20: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 0x2F: 
            case 0x30: 
            case 49: 
            case 53: 
            case 69: 
            case 70: 
            case 76: {
                goto label_29;
            }
            default: {
                this.h[2] = this.g;
                while((this.f == -1 ? this.m() : this.f) == 72) {
                    this.a(d0);
                }
                this.h[3] = this.g;
                return d0.a();
            }
        }
    }

    public final void b(d d0) {
        i i0;
        this.a(68);
        LasmBase.Internal lasmBase$Internal0 = this.e();
        switch((this.f == -1 ? this.m() : this.f)) {
            case 56: {
                i0 = this.a(56);
                break;
            }
            case 81: {
                i0 = this.a(81);
                break;
            }
            default: {
                this.h[9] = this.g;
                this.a(-1);
                throw new g();
            }
        }
        this.a(74);
        d0.a(lasmBase$Internal0, i0);
    }

    public final LuaValue c() {
        switch((this.f == -1 ? this.m() : this.f)) {
            case 59: 
            case 77: {
                return this.g();
            }
            case 50: 
            case 56: 
            case 57: 
            case 58: 
            case 0x4F: 
            case 80: 
            case 81: 
            case 84: {
                return this.d();
            }
            default: {
                this.h[4] = this.g;
                this.a(-1);
                throw new g();
            }
        }
    }

    public final void c(d d0) {
        LuaValue luaValue2;
        i i2;
        LuaValue luaValue1;
        i i1;
        LasmBase.V lasmBase$V0 = null;
        LuaValue luaValue0 = null;
        i i0 = null;
        while(true) {
            int v = this.f == -1 ? this.m() : this.f;
            if(v != 69 && v != 70 && v != 76) {
                this.h[10] = this.g;
            alab1:
                switch((this.f == -1 ? this.m() : this.f)) {
                    case 6: {
                        i1 = this.a(6);
                        luaValue1 = this.g();
                        luaValue0 = this.d();
                        i2 = null;
                        luaValue2 = null;
                        break;
                    }
                    case 7: {
                        i1 = this.a(7);
                        luaValue1 = this.g();
                        i2 = this.a(0x4F);
                        if((this.f == -1 ? this.m() : this.f) == 55) {
                            i0 = this.a(55);
                        }
                        else {
                            this.h[15] = this.g;
                        }
                        luaValue2 = null;
                        break;
                    }
                    case 9: {
                        i1 = this.a(9);
                        luaValue1 = this.g();
                        luaValue0 = this.f();
                        i2 = null;
                        luaValue2 = null;
                        break;
                    }
                    case 10: {
                        i1 = this.a(10);
                        luaValue1 = this.g();
                        luaValue0 = this.f();
                        luaValue2 = this.c();
                        i2 = null;
                        break;
                    }
                    case 12: {
                        i1 = this.a(12);
                        luaValue1 = this.f();
                        luaValue0 = this.c();
                        luaValue2 = this.c();
                        i2 = null;
                        break;
                    }
                    case 13: {
                        i1 = this.a(13);
                        luaValue1 = this.g();
                        luaValue0 = this.f();
                        i2 = null;
                        luaValue2 = null;
                        break;
                    }
                    case 15: {
                        i1 = this.a(15);
                        luaValue1 = this.g();
                        i2 = this.a(0x4F);
                        i0 = this.a(0x4F);
                        luaValue2 = null;
                        break;
                    }
                    case 11: 
                    case 16: {
                        switch((this.f == -1 ? this.m() : this.f)) {
                            case 11: {
                                this.a(11);
                                break;
                            }
                            case 16: {
                                this.a(16);
                                break;
                            }
                            default: {
                                this.h[17] = this.g;
                                this.a(-1);
                                throw new g();
                            }
                        }
                        i1 = this.c;
                        luaValue1 = this.g();
                        luaValue0 = this.g();
                        luaValue2 = this.c();
                        i2 = null;
                        break;
                    }
                    case 26: {
                        i i4 = this.a(26);
                        luaValue1 = this.g();
                        luaValue0 = this.g();
                        this.a(75);
                        luaValue2 = this.g();
                        i2 = null;
                        i1 = i4;
                        break;
                    }
                    case 27: {
                        i1 = this.a(27);
                        int v1 = this.f == -1 ? this.m() : this.f;
                        if(v1 == 59 || v1 == 77) {
                            lasmBase$V0 = this.g();
                        }
                        else {
                            this.h[21] = this.g;
                        }
                        i2 = this.h();
                        luaValue2 = null;
                        luaValue1 = lasmBase$V0;
                        break;
                    }
                    case 28: 
                    case 29: 
                    case 30: {
                        switch((this.f == -1 ? this.m() : this.f)) {
                            case 28: {
                                this.a(28);
                                break;
                            }
                            case 29: {
                                this.a(29);
                                break;
                            }
                            case 30: {
                                this.a(30);
                                break;
                            }
                            default: {
                                this.h[23] = this.g;
                                this.a(-1);
                                throw new g();
                            }
                        }
                        i1 = this.c;
                        i2 = this.a(0x4F);
                        luaValue1 = this.c();
                        luaValue0 = this.c();
                        luaValue2 = null;
                        break;
                    }
                    case 0x1F: {
                        i1 = this.a(0x1F);
                        luaValue1 = this.g();
                        i2 = this.a(0x4F);
                        luaValue2 = null;
                        break;
                    }
                    case 0x20: {
                        i1 = this.a(0x20);
                        luaValue1 = this.g();
                        luaValue0 = this.g();
                        i2 = this.a(0x4F);
                        luaValue2 = null;
                        break;
                    }
                    case 33: {
                        i i5 = this.a(33);
                        luaValue1 = this.g();
                        if((this.f == -1 ? this.m() : this.f) == 75) {
                            this.a(75);
                            luaValue0 = this.g();
                        }
                        else {
                            this.h[24] = this.g;
                        }
                        int v2 = this.f == -1 ? this.m() : this.f;
                        if(v2 == 54 || v2 == 59 || v2 == 77) {
                            switch((this.f == -1 ? this.m() : this.f)) {
                                case 54: {
                                    i2 = this.a(54);
                                    luaValue2 = null;
                                    i1 = i5;
                                    break;
                                }
                                case 59: 
                                case 77: {
                                    a.a(((LasmBase.V)luaValue1), this.g());
                                    this.a(75);
                                    luaValue2 = this.g();
                                    i2 = null;
                                    i1 = i5;
                                    break;
                                }
                                default: {
                                    this.h[25] = this.g;
                                    this.a(-1);
                                    throw new g();
                                }
                            }
                        }
                        else {
                            this.h[26] = this.g;
                            i2 = null;
                            luaValue2 = null;
                            i1 = i5;
                        }
                        break;
                    }
                    case 35: {
                        i i7 = this.a(35);
                        int v3 = this.f == -1 ? this.m() : this.f;
                        if(v3 == 59 || v3 == 77) {
                            luaValue1 = this.g();
                            if((this.f == -1 ? this.m() : this.f) == 75) {
                                this.a(75);
                                luaValue0 = this.g();
                            }
                            else {
                                this.h[29] = this.g;
                            }
                            i2 = null;
                            luaValue2 = null;
                        }
                        else {
                            this.h[30] = this.g;
                            i2 = null;
                            luaValue2 = null;
                            luaValue1 = null;
                        }
                        i1 = i7;
                        break;
                    }
                    case 8: 
                    case 38: {
                        switch((this.f == -1 ? this.m() : this.f)) {
                            case 8: {
                                this.a(8);
                                break;
                            }
                            case 38: {
                                this.a(38);
                                break;
                            }
                            default: {
                                this.h[16] = this.g;
                                this.a(-1);
                                throw new g();
                            }
                        }
                        i i3 = this.c;
                        luaValue1 = this.g();
                        this.a(75);
                        luaValue0 = this.g();
                        i2 = null;
                        luaValue2 = null;
                        i1 = i3;
                        break;
                    }
                    case 36: 
                    case 37: 
                    case 39: {
                        switch((this.f == -1 ? this.m() : this.f)) {
                            case 36: {
                                this.a(36);
                                break;
                            }
                            case 37: {
                                this.a(37);
                                break;
                            }
                            case 39: {
                                this.a(39);
                                break;
                            }
                            default: {
                                this.h[22] = this.g;
                                this.a(-1);
                                throw new g();
                            }
                        }
                        i1 = this.c;
                        luaValue1 = this.g();
                        i2 = this.h();
                        luaValue2 = null;
                        break;
                    }
                    case 40: {
                        i i8 = this.a(40);
                        luaValue1 = this.g();
                        if((this.f == -1 ? this.m() : this.f) == 75) {
                            this.a(75);
                            luaValue0 = this.g();
                        }
                        else {
                            this.h[18] = this.g;
                        }
                        i2 = this.a(0x4F);
                        luaValue2 = null;
                        i1 = i8;
                        break;
                    }
                    case 41: {
                        i1 = this.a(41);
                        luaValue1 = this.g();
                        switch((this.f == -1 ? this.m() : this.f)) {
                            case 51: {
                                this.a(51);
                                i2 = this.a(0x4F);
                                this.a(89);
                                luaValue2 = null;
                                break alab1;
                            }
                            case 61: {
                                i2 = this.a(61);
                                luaValue2 = null;
                                break alab1;
                            }
                            default: {
                                this.h[0x1F] = this.g;
                                this.a(-1);
                                throw new g();
                            }
                        }
                    }
                    case 34: 
                    case 42: {
                        switch((this.f == -1 ? this.m() : this.f)) {
                            case 34: {
                                this.a(34);
                                break;
                            }
                            case 42: {
                                this.a(42);
                                break;
                            }
                            default: {
                                this.h[27] = this.g;
                                this.a(-1);
                                throw new g();
                            }
                        }
                        i i6 = this.c;
                        luaValue1 = this.g();
                        if((this.f == -1 ? this.m() : this.f) == 75) {
                            this.a(75);
                            luaValue0 = this.g();
                        }
                        else {
                            this.h[28] = this.g;
                        }
                        i2 = null;
                        luaValue2 = null;
                        i1 = i6;
                        break;
                    }
                    case 5: 
                    case 23: 
                    case 24: 
                    case 25: 
                    case 44: {
                        switch((this.f == -1 ? this.m() : this.f)) {
                            case 5: {
                                this.a(5);
                                break;
                            }
                            case 23: {
                                this.a(23);
                                break;
                            }
                            case 24: {
                                this.a(24);
                                break;
                            }
                            case 25: {
                                this.a(25);
                                break;
                            }
                            case 44: {
                                this.a(44);
                                break;
                            }
                            default: {
                                this.h[20] = this.g;
                                this.a(-1);
                                throw new g();
                            }
                        }
                        i1 = this.c;
                        luaValue1 = this.g();
                        luaValue0 = this.g();
                        i2 = null;
                        luaValue2 = null;
                        break;
                    }
                    case 14: 
                    case 17: 
                    case 18: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 43: 
                    case 45: 
                    case 46: 
                    case 0x2F: 
                    case 0x30: 
                    case 49: {
                        switch((this.f == -1 ? this.m() : this.f)) {
                            case 14: {
                                this.a(14);
                                break;
                            }
                            case 17: {
                                this.a(17);
                                break;
                            }
                            case 18: {
                                this.a(18);
                                break;
                            }
                            case 19: {
                                this.a(19);
                                break;
                            }
                            case 20: {
                                this.a(20);
                                break;
                            }
                            case 21: {
                                this.a(21);
                                break;
                            }
                            case 22: {
                                this.a(22);
                                break;
                            }
                            case 43: {
                                this.a(43);
                                break;
                            }
                            case 45: {
                                this.a(45);
                                break;
                            }
                            case 46: {
                                this.a(46);
                                break;
                            }
                            case 0x2F: {
                                this.a(0x2F);
                                break;
                            }
                            case 0x30: {
                                this.a(0x30);
                                break;
                            }
                            case 49: {
                                this.a(49);
                                break;
                            }
                            default: {
                                this.h[19] = this.g;
                                this.a(-1);
                                throw new g();
                            }
                        }
                        i1 = this.c;
                        luaValue1 = this.g();
                        luaValue0 = this.c();
                        luaValue2 = this.c();
                        i2 = null;
                        break;
                    }
                    case 53: {
                        this.a(53);
                        this.a(88);
                        i1 = this.a(0x4F);
                        this.a(89);
                        i2 = this.a(80);
                        luaValue2 = null;
                        luaValue1 = null;
                        break;
                    }
                    default: {
                        this.h[0x20] = this.g;
                        this.a(-1);
                        throw new g();
                    }
                }
                this.a(74);
                while((this.f == -1 ? this.m() : this.f) == 71) {
                    this.a(71);
                    LasmBase.V lasmBase$V1 = this.g();
                    this.a(81);
                    d0.a(lasmBase$V1, this.c, 1);
                    this.a(74);
                }
                this.h[33] = this.g;
                d0.a(i1, luaValue1, luaValue0, luaValue2, i2, i0);
                return;
            }
            switch((this.f == -1 ? this.m() : this.f)) {
                case 69: {
                    this.a(69);
                    this.a(0x4F);
                    d0.c(this.c);
                    this.a(74);
                    while((this.f == -1 ? this.m() : this.f) == 71) {
                        this.a(71);
                        LasmBase.V lasmBase$V2 = this.g();
                        this.a(81);
                        d0.a(lasmBase$V2, this.c, 0);
                        this.a(74);
                    }
                    this.h[13] = this.g;
                    break;
                }
                case 70: {
                    this.a(70);
                    LasmBase.V lasmBase$V3 = this.g();
                    this.a(81);
                    d0.a(lasmBase$V3, this.c);
                    this.a(74);
                    while((this.f == -1 ? this.m() : this.f) == 71) {
                        this.a(71);
                        LasmBase.V lasmBase$V4 = this.g();
                        this.a(81);
                        d0.a(lasmBase$V4, this.c, 0);
                        this.a(74);
                    }
                    this.h[12] = this.g;
                    break;
                }
                case 76: {
                    this.a(76);
                    d0.b(this.c);
                    this.a(74);
                    while((this.f == -1 ? this.m() : this.f) == 71) {
                        this.a(71);
                        LasmBase.V lasmBase$V5 = this.g();
                        this.a(81);
                        d0.a(lasmBase$V5, this.c, 0);
                        this.a(74);
                    }
                    this.h[11] = this.g;
                    break;
                }
                default: {
                    this.h[14] = this.g;
                    this.a(-1);
                    throw new g();
                }
            }
        }
    }

    public final LuaValue d() {
        switch((this.f == -1 ? this.m() : this.f)) {
            case 50: {
                this.a(50);
                this.a(88);
                this.a(0x4F);
                LuaValue luaValue0 = new LasmBase.Const(this.c);
                this.a(89);
                return luaValue0;
            }
            case 56: {
                this.a(56);
                return LuaValue.u;
            }
            case 57: {
                this.a(57);
                return LuaValue.v;
            }
            case 58: {
                this.a(58);
                return LuaValue.w;
            }
            case 0x4F: {
                this.a(0x4F);
                return LuaLong.b(a.c(this.c));
            }
            case 80: {
                this.a(80);
                return a.d(this.c);
            }
            case 81: {
                this.a(81);
                return a.e(this.c);
            }
            case 84: {
                this.a(84);
                return a.d(this.c);
            }
            default: {
                this.h[5] = this.g;
                this.a(-1);
                throw new g();
            }
        }
    }

    public final LasmBase.Internal e() {
        switch((this.f == -1 ? this.m() : this.f)) {
            case 59: 
            case 77: {
                return this.g();
            }
            case 78: {
                return this.f();
            }
            default: {
                this.h[6] = this.g;
                this.a(-1);
                throw new g();
            }
        }
    }

    public final LasmBase.U f() {
        this.a(78);
        return new LasmBase.U(this.c);
    }

    public final LasmBase.V g() {
        switch((this.f == -1 ? this.m() : this.f)) {
            case 59: {
                this.a(59);
                return new LasmBase.V(this.c);
            }
            case 77: {
                this.a(77);
                return new LasmBase.V(this.c);
            }
            default: {
                this.h[7] = this.g;
                this.a(-1);
                throw new g();
            }
        }
    }

    public final i h() {
        switch((this.f == -1 ? this.m() : this.f)) {
            case 52: {
                this.a(52);
                i i0 = this.a(60);
                this.a(89);
                return i0;
            }
            case 76: {
                return this.a(76);
            }
            default: {
                this.h[8] = this.g;
                this.a(-1);
                throw new g();
            }
        }
    }

    public g i() {
        this.l.clear();
        boolean[] arr_z = new boolean[90];
        if(this.n >= 0) {
            arr_z[this.n] = true;
            this.n = -1;
        }
        for(int v = 0; v < 34; ++v) {
            if(this.h[v] == this.g) {
                for(int v1 = 0; v1 < 0x20; ++v1) {
                    if((a.i[v] & 1 << v1) != 0) {
                        arr_z[v1] = true;
                    }
                    if((a.j[v] & 1 << v1) != 0) {
                        arr_z[v1 + 0x20] = true;
                    }
                    if((a.k[v] & 1 << v1) != 0) {
                        arr_z[v1 + 0x40] = true;
                    }
                }
            }
        }
        for(int v2 = 0; v2 < 90; ++v2) {
            if(arr_z[v2]) {
                this.m = new int[1];
                this.m[0] = v2;
                this.l.add(this.m);
            }
        }
        int[][] arr2_v = new int[this.l.size()][];
        for(int v3 = 0; v3 < this.l.size(); ++v3) {
            arr2_v[v3] = (int[])this.l.get(v3);
        }
        return new g(this.c, arr2_v, a.e);
    }

    private static void j() {
        int[] arr_v = new int[34];
        arr_v[2] = 0xFFFFFFE0;
        arr_v[16] = 0x100;
        arr_v[17] = 0x10800;
        arr_v[19] = 0x7E4000;
        arr_v[20] = 0x3800020;
        arr_v[23] = 0x70000000;
        arr_v[0x20] = 0xFFFFFFE0;
        a.i = arr_v;
    }

    private static void k() {
        a.j = new int[]{0, 0, 0x23FFFF, 0, 0xF040000, 0x7040000, 0x8000000, 0x8000000, 0x100000, 0x1000000, 0, 0, 0, 0, 0, 0x800000, 0x40, 0, 0, 256000, 0x1000, 0x8000000, 0xB0, 0, 0, 0x8400000, 0x8400000, 0x404, 0, 0, 0x8000000, 0x20080000, 0x23FFFF, 0};
    }

    private static void l() {
        a.k = new int[]{0x400, 16, 0x1060, 0x100, 0x13A000, 0x138000, 0x6000, 0x2000, 0x1000, 0x20000, 0x1060, 0x80, 0x80, 0x80, 0x1060, 0, 0, 0, 0x800, 0, 0, 0x2000, 0, 0, 0x800, 0x2000, 0x2000, 0, 0x800, 0x800, 0x2000, 0, 0, 0x80};
    }

    private int m() {
        this.d = this.c.g;
        if(this.c.g == null) {
            i i0 = this.c;
            i i1 = this.a.b();
            i0.g = i1;
            this.f = i1.a;
            return i1.a;
        }
        this.f = this.d.a;
        return this.d.a;
    }
}

