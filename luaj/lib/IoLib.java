package luaj.lib;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import luaj.Globals;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;

public class IoLib extends TwoArgFunction {
    private IoLib.File a;
    public static final String[] b;
    public static final String[] c;
    LuaTable d;
    public Globals e;
    private IoLib.File f;
    private IoLib.File g;
    private static final LuaValue h;
    private static final LuaValue i;
    private static final LuaValue j;
    private static final LuaValue k;

    static {
        IoLib.h = IoLib.m("stdout");
        IoLib.i = IoLib.m("stderr");
        IoLib.j = IoLib.m("file");
        IoLib.k = IoLib.m("closed file");
        IoLib.b = new String[]{"close", "flush", "input", "lines", "open", "output", "popen", "read", "tmpfile", "type", "write"};
        IoLib.c = new String[]{"close", "flush", "lines", "read", "seek", "setvbuf", "write"};
    }

    public IoLib() {
        this.a = null;
        this.f = null;
        this.g = null;
    }

    public ap C(LuaValue luaValue0) {
        IoLib.File ioLib$File0;
        if(luaValue0.F()) {
            ioLib$File0 = this.d(false);
        }
        else {
            ioLib$File0 = luaValue0.J() ? this.b(3, luaValue0.y(), "w") : IoLib.d("io.output", luaValue0);
        }
        this.f = ioLib$File0;
        return this.f;
    }

    public ap D(LuaValue luaValue0) {
        IoLib.File ioLib$File0 = IoLib.M(luaValue0);
        if(ioLib$File0 != null) {
            return ioLib$File0.V() ? IoLib.k : IoLib.j;
        }
        return IoLib.u;
    }

    public ap E(LuaValue luaValue0) {
        return IoLib.c(IoLib.d("file:close", luaValue0));
    }

    public ap L(LuaValue luaValue0) {
        IoLib.d("file:flush", luaValue0).S();
        return LuaValue.v;
    }

    // 去混淆评级： 低(20)
    private static IoLib.File M(LuaValue luaValue0) {
        return luaValue0 instanceof IoLib.File ? ((IoLib.File)luaValue0) : null;
    }

    public ap S() {
        this.d(true);
        this.f.S();
        return LuaValue.v;
    }

    public ap T() {
        return this.W();
    }

    private IoLib.File U() {
        return new IoLib.StdoutFile(this, 1, null);
    }

    private IoLib.File V() {
        return new IoLib.StdoutFile(this, 2, null);
    }

    private IoLib.File W() {
        File file0 = File.createTempFile(".gg.", ".tmp");
        IoLib.File ioLib$File0 = new IoLib.FileImpl(this, file0, '¢', null);
        file0.delete();
        return ioLib$File0;
    }

    private IoLib.File X() {
        if(this.g != null) {
            return this.g;
        }
        IoLib.File ioLib$File0 = this.b(2, "-", "w");
        this.g = ioLib$File0;
        return ioLib$File0;
    }

    private static int a(IoLib.File ioLib$File0, String s, ByteArrayOutputStream byteArrayOutputStream0, int v) {
        int v1 = 0;
        do {
            int v2 = ioLib$File0.X();
            if(s.indexOf(v2) < 0) {
                return v1;
            }
            ioLib$File0.af();
            ++v1;
            if(byteArrayOutputStream0 != null) {
                if(byteArrayOutputStream0.size() >= 200) {
                    byteArrayOutputStream0.reset();
                    return 0;
                }
                byteArrayOutputStream0.write(v2);
            }
        }
        while(v <= 0 || v1 < v);
        return v1;
    }

    public static LuaValue a(IoLib.File ioLib$File0) {
        int v = ioLib$File0.W();
        if(v >= 0) {
            return v == 0 ? IoLib.ad : IoLib.a(ioLib$File0, v);
        }
        return IoLib.a(ioLib$File0, false, false);
    }

    public static LuaValue a(IoLib.File ioLib$File0, int v) {
        if(v == 0) {
            return ioLib$File0.ag() ? IoLib.u : IoLib.ad;
        }
        byte[] arr_b = new byte[v];
        int v1 = ioLib$File0.a(arr_b, 0, arr_b.length);
        return v1 < 0 ? IoLib.u : LuaString.b(arr_b, 0, v1);
    }

    public static LuaValue a(IoLib.File ioLib$File0, boolean z) {
        return IoLib.a(ioLib$File0, true, z);
    }

    public static LuaValue a(IoLib.File ioLib$File0, boolean z, boolean z1) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try {
            if(z) {
            alab1:
                int v;
                while((v = ioLib$File0.af()) >= 0) {
                    switch(v) {
                        case 10: {
                            if(!z1) {
                                break alab1;
                            }
                            byteArrayOutputStream0.write(10);
                            break alab1;
                        }
                        case 13: {
                            if(z1) {
                                break;
                            }
                            continue;
                        }
                        default: {
                            byteArrayOutputStream0.write(v);
                            continue;
                        }
                    }
                    byteArrayOutputStream0.write(13);
                }
            }
            else {
                while(true) {
                    v = ioLib$File0.af();
                    if(v < 0) {
                        break;
                    }
                    byteArrayOutputStream0.write(v);
                }
            }
        }
        catch(EOFException unused_ex) {
            v = -1;
        }
        return v < 0 && byteArrayOutputStream0.size() == 0 ? IoLib.u : LuaString.b(byteArrayOutputStream0.toByteArray());
    }

    static ap a(IOException iOException0, int v) {
        String s = iOException0.getMessage();
        StringBuilder stringBuilder0 = new StringBuilder("io error: ");
        return s == null ? IoLib.c(stringBuilder0.append(iOException0.toString()).toString(), v) : IoLib.c(stringBuilder0.append(s).toString(), v);
    }

    private static ap a(IoLib.File ioLib$File0, ap ap0) {
        int v1 = ap0.j_();
        for(int v = 1; v <= v1; ++v) {
            ioLib$File0.e(ap0.s(v));
        }
        return ioLib$File0;
    }

    private ap a(IoLib.File ioLib$File0, boolean z, ap ap0) {
        int v = ap0.j_();
        if(v > 0xFA) {
            if(z) {
                try {
                    ioLib$File0.U();
                }
                catch(IOException unused_ex) {
                }
            }
            IoLib.f(("too many arguments: " + v + " max = " + 0xFA));
        }
        try {
            return new IoLib.IoLibV(ioLib$File0, "lnext", 18, this, z, ap0);
        }
        catch(Exception exception0) {
            return IoLib.a(("lines: " + exception0), exception0);
        }
    }

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        this.e = luaValue1.c();
        LuaValue luaValue2 = new LuaTable();
        this.a(luaValue2, IoLib.IoLibV.class, IoLib.b);
        this.d = new LuaTable();
        this.a(this.d, IoLib.IoLibV.class, IoLib.c, 11);
        this.b(((LuaTable)luaValue2));
        this.b(this.d);
        this.d.c("__name", "FILE*");
        this.d.a("__index", this.d);
        IoLib.File ioLib$File0 = this.d(false);
        ((LuaTable)luaValue2).b(IoLib.h, ioLib$File0);
        IoLib.File ioLib$File1 = this.X();
        ((LuaTable)luaValue2).b(IoLib.i, ioLib$File1);
        luaValue1.a("io", luaValue2);
        if(!luaValue1.j("package").F()) {
            luaValue1.j("package").j("loaded").a("io", luaValue2);
        }
        return luaValue2;
    }

    public ap a(String s, String s1) {
        throw new o("Failed io.popen(\'" + s + "\', \'" + s1 + "\'): disabled by security reason");
    }

    public ap a(LuaValue luaValue0, String s, int v) {
        if("no".equals(s)) {
            v = 1;
        }
        else if(!"full".equals(s) && !"line".equals(s)) {
            IoLib.a(1, "file:setvbuf", "invalid value: \'" + s + "\'; must be one of \'no\', \'full\' or \'line\'");
        }
        if(v <= 0) {
            IoLib.a(2, "file:setvbuf", "invalid value \'" + v + "\'; must be positive");
        }
        IoLib.d("file:setvbuf", luaValue0).d(s, v);
        return LuaValue.v;
    }

    public ap a(LuaValue luaValue0, boolean z, ap ap0) {
        IoLib.File ioLib$File0 = IoLib.M(luaValue0);
        if(ioLib$File0 == null) {
            IoLib.a(1, "lines", "not a file: " + luaValue0);
        }
        if(ioLib$File0.V()) {
            IoLib.f("file is already closed");
        }
        ap ap1 = this.b(ioLib$File0, ap0);
        if(z && ap1.f(1) && ioLib$File0.ag()) {
            ioLib$File0.U();
        }
        return ap1;
    }

    protected IoLib.File a(String s, char c) {
        return new IoLib.FileImpl(this, this.e.d(s), c, null);
    }

    private static ap af() {
        return LuaValue.v;
    }

    public static LuaValue b(IoLib.File ioLib$File0) {
        boolean z;
        int v;
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        IoLib.a(ioLib$File0, " \t\r\n", null, 0);
        IoLib.a(ioLib$File0, "-+", byteArrayOutputStream0, 1);
        if(IoLib.a(ioLib$File0, "0", byteArrayOutputStream0, 1) <= 0) {
            v = 0;
            z = false;
        }
        else if(IoLib.a(ioLib$File0, "xX", byteArrayOutputStream0, 1) > 0) {
            v = 0;
            z = true;
        }
        else {
            v = 1;
            z = false;
        }
        int v1 = v + IoLib.a(ioLib$File0, (z ? "0123456789abcdefABCDEF" : "0123456789"), byteArrayOutputStream0, 0);
        if((IoLib.a(ioLib$File0, ".", byteArrayOutputStream0, 1) <= 0 ? v1 : IoLib.a(ioLib$File0, (z ? "0123456789abcdefABCDEF" : "0123456789"), byteArrayOutputStream0, 0) + v1) > 0 && IoLib.a(ioLib$File0, (z ? "pP" : "eE"), byteArrayOutputStream0, 1) > 0) {
            IoLib.a(ioLib$File0, "-+", byteArrayOutputStream0, 1);
            IoLib.a(ioLib$File0, "0123456789", byteArrayOutputStream0, 0);
        }
        String s = byteArrayOutputStream0.toString();
        return s.length() <= 0 ? IoLib.u : IoLib.c(s, IoLib.u);
    }

    private ap b(IoLib.File ioLib$File0, ap ap0) {
        LuaValue luaValue1;
        LuaValue luaValue0;
        int v2;
        int v = ap0.j_();
        if(v == 0) {
            return IoLib.a(ioLib$File0, false);
        }
        LuaValue[] arr_luaValue = new LuaValue[v];
        int v1 = 0;
    alab1:
        while(true) {
            if(v1 >= v) {
                v2 = v1;
            }
            else {
                luaValue0 = ap0.c(v1 + 1);
            alab2:
                switch(luaValue0.e_()) {
                    case 3: {
                        luaValue1 = IoLib.a(ioLib$File0, luaValue0.p());
                        break;
                    }
                    case 4: {
                        LuaString luaString0 = luaValue0.z();
                        if(luaString0.d < 1) {
                            break alab1;
                        }
                        int v3 = luaString0.b[luaString0.c];
                        if(v3 == 42 && luaString0.d >= 2) {
                            v3 = luaString0.b[luaString0.c + 1];
                        }
                        switch(v3) {
                            case 76: {
                                luaValue1 = IoLib.a(ioLib$File0, true);
                                break alab2;
                            }
                            case 97: {
                                luaValue1 = IoLib.a(ioLib$File0);
                                break alab2;
                            }
                            case 108: {
                                luaValue1 = IoLib.a(ioLib$File0, false);
                                break alab2;
                            }
                            case 110: {
                                luaValue1 = IoLib.b(ioLib$File0);
                                break alab2;
                            }
                            default: {
                                return IoLib.a(v1 + 1, "read", "invalid format: \'" + luaValue0 + "\'");
                            }
                        }
                    }
                    default: {
                        return IoLib.a(v1 + 1, "read", "invalid format: \'" + luaValue0 + "\'");
                    }
                }
                arr_luaValue[v1] = luaValue1;
                if(luaValue1.F()) {
                    v2 = v1 + 1;
                }
                else {
                    goto label_33;
                }
            }
            return v2 == 0 ? IoLib.u : IoLib.a(arr_luaValue, 0, v2);
        label_33:
            ++v1;
        }
        return IoLib.a(v1 + 1, "read", "invalid format: \'" + luaValue0 + "\'");
    }

    private IoLib.File b(int v, String s, String s1) {
        try {
            return this.c(v, s, s1);
        }
        catch(Exception exception0) {
            IoLib.a(("io error: " + exception0.getMessage()), exception0);
            return null;
        }
    }

    private void b(LuaTable luaTable0) {
        LuaValue[] arr_luaValue = luaTable0.T();
        for(int v = 0; v < arr_luaValue.length; ++v) {
            ((IoLib.IoLibV)luaTable0.w(arr_luaValue[v])).a = this;
        }
    }

    public ap b(LuaValue luaValue0, String s, int v) {
        if(!"set".equals(s) && !"end".equals(s) && !"cur".equals(s)) {
            IoLib.a(1, "file:seek", "invalid value: \'" + s + "\'; must be one of \'set\', \'cur\' or \'end\'");
        }
        return IoLib.d(IoLib.d("file:seek", luaValue0).c(s, v));
    }

    public ap b(ap ap0) {
        String s = ap0.c(1, null);
        IoLib.File ioLib$File0 = s == null ? this.c(false) : this.b(3, s, "r");
        IoLib.d(ioLib$File0);
        return s == null ? this.a(ioLib$File0, false, ap0.e_(2)) : this.a(ioLib$File0, true, ap0.e_(2));
    }

    private static ap c(String s, int v) {
        return IoLib.a(IoLib.u, IoLib.m(s), IoLib.d(v));
    }

    private static ap c(IoLib.File ioLib$File0) {
        if(ioLib$File0.T()) {
            return IoLib.c("cannot close standard file", 1000);
        }
        ioLib$File0.U();
        return IoLib.af();
    }

    private IoLib.File c(int v, String s, String s1) {
        int v1 = s1.length();
        for(int v2 = 0; v2 < v1; ++v2) {
            int v3 = s1.charAt(v2);
            if((v2 != 0 || "rwa".indexOf(v3) < 0) && ((v2 != 1 || v3 != 43) && (v2 < 1 || v3 != 98))) {
                v1 = -1;
            }
        }
        if(v1 <= 0) {
            IoLib.a(2, "io.open", "invalid mode: \'" + s1 + "\'");
        }
        switch(v) {
            case 1: {
                return this.U();
            }
            case 2: {
                return this.V();
            }
            default: {
                int v4 = s1.charAt(0);
                return s1.indexOf(43) <= 0 ? this.a(s, ((char)v4)) : this.a(s, ((char)(v4 + 43)));
            }
        }
    }

    private IoLib.File c(boolean z) {
        IoLib.File ioLib$File0 = this.a;
        if(ioLib$File0 == null) {
            IoLib.f("stdin not supported");
        }
        if(z && ioLib$File0.V()) {
            IoLib.f("standard input file is closed");
        }
        return ioLib$File0;
    }

    public ap c(LuaValue luaValue0, ap ap0) {
        return this.b(IoLib.d("file:read", luaValue0), ap0);
    }

    public ap c(ap ap0) {
        this.c(true);
        return this.b(this.a, ap0);
    }

    private static IoLib.File d(String s, LuaValue luaValue0) {
        IoLib.File ioLib$File0 = IoLib.M(luaValue0);
        if(ioLib$File0 == null) {
            IoLib.a(1, s, "FILE* expected, got " + luaValue0.aa());
        }
        IoLib.d(ioLib$File0);
        return ioLib$File0;
    }

    private static IoLib.File d(IoLib.File ioLib$File0) {
        if(ioLib$File0.V()) {
            IoLib.f("attempt to use a closed file");
        }
        return ioLib$File0;
    }

    private IoLib.File d(boolean z) {
        IoLib.File ioLib$File0 = this.f;
        if(ioLib$File0 == null) {
            ioLib$File0 = this.b(1, "-", "w");
            this.f = ioLib$File0;
        }
        if(z && ioLib$File0.V()) {
            IoLib.f("standard output file is closed");
        }
        return ioLib$File0;
    }

    public ap d(LuaValue luaValue0, ap ap0) {
        return IoLib.a(IoLib.d("file:write", luaValue0), ap0);
    }

    public ap d(ap ap0) {
        this.d(true);
        return IoLib.a(this.f, ap0);
    }

    public ap e(String s, String s1) {
        return this.c(3, s, s1);
    }

    public ap e(ap ap0) {
        return this.a(IoLib.d("file:lines", ap0.g()), false, ap0.e_(2));
    }

    public ap y(LuaValue luaValue0) {
        IoLib.File ioLib$File0 = luaValue0.F() ? this.d(false) : IoLib.d("io.close", luaValue0);
        IoLib.d(ioLib$File0);
        return IoLib.c(ioLib$File0);
    }

    public ap z(LuaValue luaValue0) {
        IoLib.File ioLib$File0;
        if(luaValue0.F()) {
            ioLib$File0 = this.c(false);
        }
        else {
            ioLib$File0 = luaValue0.J() ? this.b(3, luaValue0.y(), "r") : IoLib.d("io.input", luaValue0);
        }
        this.a = ioLib$File0;
        return this.a;
    }
}

