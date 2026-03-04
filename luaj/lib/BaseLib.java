package luaj.lib;

import android.ext.la;
import android.os.Build.VERSION;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import luaj.Globals;
import luaj.LuaClosure;
import luaj.LuaFunction;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;

public class BaseLib extends TwoArgFunction implements j {
    Globals a;
    byte[] b;
    private c c;

    public BaseLib() {
        this.c = null;
        this.b = null;
    }

    public void S() {
        if(this.c != null) {
            this.c.a();
        }
    }

    InputStream a(LuaString luaString0, String s, boolean z, InputStream inputStream0) {
        int v = 0;
        c c0 = this.c;
        if(c0 != null) {
            if(z) {
                try {
                    if(s != null) {
                        byte[] arr_b = this.b;
                        if(arr_b == null) {
                            arr_b = new byte[0x2000];
                            this.b = arr_b;
                        }
                        if(Build.VERSION.SDK_INT >= 21) {
                            FileDescriptor fileDescriptor0 = Os.open(s, OsConstants.O_RDONLY, 438);
                            while(true) {
                                int v1 = Os.read(fileDescriptor0, arr_b, 0, arr_b.length);
                                if(v1 <= 0) {
                                    Os.close(fileDescriptor0);
                                    goto label_22;
                                }
                                c0.b.write(arr_b, 0, v1);
                                v += v1;
                            }
                        }
                        else {
                            FileInputStream fileInputStream0 = new FileInputStream(this.a.d(s));
                            while(true) {
                                int v2 = fileInputStream0.read(arr_b);
                                if(v2 <= 0) {
                                    fileInputStream0.close();
                                label_22:
                                    if(v <= 0) {
                                        break;
                                    }
                                    c0.d.writeInt(v);
                                    return inputStream0;
                                }
                                c0.b.write(arr_b, 0, v2);
                                v += v2;
                            }
                        }
                    }
                }
                catch(Throwable throwable0) {
                    la.a(("Failed write log file from " + s), throwable0);
                    return inputStream0;
                }
            }
            else {
                if(luaString0 != null) {
                    try {
                        int v3 = luaString0.d;
                        if(v3 > 0) {
                            c0.b.write(luaString0.b, luaString0.c, v3);
                            c0.d.writeInt(v3);
                            return inputStream0;
                        }
                    }
                    catch(Throwable throwable1) {
                        la.b("Failed write log file", throwable1);
                    }
                    return inputStream0;
                }
                return new a(this, inputStream0, c0);
            }
        }
        try {
        }
        catch(Throwable throwable0) {
            la.a(("Failed write log file from " + s), throwable0);
        }
        return inputStream0;
    }

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        Globals globals0 = luaValue1.c();
        this.a = globals0;
        globals0.g = this;
        globals0.i = this;
        if(globals0.a) {
            luaValue1.a("_G", luaValue1);
            luaValue1.c("_VERSION", "Lua 5.3 (with Luaj 3.0.1)");
            luaValue1.a("assert", new BaseLib._assert());
            luaValue1.a("assert2", new BaseLib.assert2());
            luaValue1.a("collectgarbage", new BaseLib.collectgarbage());
            luaValue1.a("dofile", new BaseLib.dofile(this));
            luaValue1.a("error", new BaseLib.error());
            luaValue1.a("getmetatable", new BaseLib.getmetatable());
            luaValue1.a("load", new BaseLib.load(this));
            luaValue1.a("loadfile", new BaseLib.loadfile(this));
            luaValue1.a("pcall", new BaseLib.pcall(this));
            luaValue1.a("print", new BaseLib.print(this, this));
        }
        luaValue1.a("rawequal", new BaseLib.rawequal());
        luaValue1.a("rawget", new BaseLib.rawget());
        luaValue1.a("rawlen", new BaseLib.rawlen());
        luaValue1.a("rawset", new BaseLib.rawset());
        luaValue1.a("select", new BaseLib.select());
        if(globals0.a) {
            luaValue1.a("setmetatable", new BaseLib.setmetatable());
        }
        luaValue1.a("tonumber", new BaseLib.tonumber());
        luaValue1.a("tostring", new BaseLib.tostring());
        luaValue1.a("type", new BaseLib.type());
        if(globals0.a) {
            luaValue1.a("xpcall", new BaseLib.xpcall(this));
        }
        BaseLib.next baseLib$next0 = new BaseLib.next();
        luaValue1.a("next", baseLib$next0);
        luaValue1.a("pairs", new BaseLib.pairs(baseLib$next0));
        luaValue1.a("ipairs", new BaseLib.ipairs());
        return luaValue1;
    }

    public ap a(InputStream inputStream0, String s, String s1, LuaValue luaValue0) {
        try {
            return inputStream0 == null ? BaseLib.b(BaseLib.u, BaseLib.m(("not found: " + s))) : this.a.a(inputStream0, s, s1, luaValue0);
        }
        catch(Exception exception0) {
            return BaseLib.b(BaseLib.u, BaseLib.m(exception0.getMessage()));
        }
    }

    public ap a(String s, String s1, LuaValue luaValue0) {
        ap ap0;
        InputStream inputStream0 = this.a.g.c(s);
        if(inputStream0 == null) {
            return BaseLib.b(BaseLib.u, BaseLib.m(("cannot open " + s + ": No such file or directory")));
        }
        try {
            String s2 = this.a.d(s).getAbsolutePath();
            ap0 = this.a(inputStream0, "@" + s2, s1, luaValue0);
            if(ap0 instanceof LuaClosure) {
                ((LuaClosure)ap0).d = s2;
            }
            if(this.c != null && ap0 instanceof LuaFunction) {
                this.a(null, s, true, null);
            }
        }
        catch(Throwable unused_ex) {
            try {
                String s3 = throwable0.getMessage();
                String s4 = s3 == null ? throwable0.getClass().getName() : s3;
                return BaseLib.b(BaseLib.u, BaseLib.m(s4));
            }
            finally {
                try {
                    inputStream0.close();
                }
                catch(Exception exception0) {
                    exception0.printStackTrace();
                }
            }
        }
        try {
            inputStream0.close();
        }
        catch(Exception exception1) {
            exception1.printStackTrace();
        }
        return ap0;
    }

    @Override  // luaj.lib.j
    public InputStream c(String s) {
        File file0 = this.a.d(s);
        try {
            return new b(new FileInputStream(file0));
        }
        catch(IOException unused_ex) {
            return null;
        }
    }

    public void d(String s) {
        try {
            this.c = new c(this, s);
        }
        catch(Throwable throwable0) {
            la.a(("Failed prepare log loads for " + s), throwable0);
        }
    }

    static LuaString y(LuaValue luaValue0) {
        LuaValue luaValue1 = luaValue0.I(BaseLib.T);
        if(!luaValue1.F()) {
            LuaValue luaValue2 = luaValue1.a(luaValue0);
            LuaValue luaValue3 = luaValue2.u();
            if(luaValue3.F()) {
                throw new o("\'__tostring\' must return a string, got \'" + luaValue2.f_() + "\' (\'" + luaValue2 + "\')");
            }
            return luaValue3.z();
        }
        LuaValue luaValue4 = luaValue0.u();
        return luaValue4.F() ? BaseLib.m(luaValue0.d_()) : luaValue4.z();
    }
}

