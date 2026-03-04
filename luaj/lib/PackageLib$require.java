package luaj.lib;

import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;

public class PackageLib.require extends OneArgFunction {
    final PackageLib a;

    public PackageLib.require(PackageLib packageLib0) {
        this.a = packageLib0;
        super();
    }

    @Override  // luaj.lib.OneArgFunction
    public LuaValue a(LuaValue luaValue0) {
        LuaValue luaValue6;
        LuaValue luaValue5;
        ap ap0;
        LuaString luaString0 = luaValue0.z();
        LuaValue luaValue1 = this.a.h.w(PackageLib.b);
        LuaValue luaValue2 = luaValue1.w(luaString0);
        if(!luaValue2.i_()) {
            LuaValue luaValue3 = this.a.h.w(PackageLib.f);
            if(!luaValue3.N()) {
                PackageLib.require.f("\'package.searchers\' must be a table");
            }
            LuaTable luaTable0 = luaValue3.O();
            StringBuffer stringBuffer0 = new StringBuffer();
            try {
                for(int v = 1; true; ++v) {
                    LuaValue luaValue4 = luaTable0.c_(v);
                    if(luaValue4.F()) {
                        PackageLib.require.f(("module \'" + luaString0 + "\' not found: " + luaString0 + stringBuffer0));
                    }
                    ap0 = luaValue4.a_(luaString0);
                    if(ap0.g(1)) {
                        break;
                    }
                    if(ap0.i(1)) {
                        stringBuffer0.append(ap0.y(1));
                    }
                }
                luaValue1.b(luaString0, PackageLib.l);
                luaValue5 = ap0.c(2);
            }
            catch(Exception exception0) {
                luaValue6 = null;
                goto label_32;
            }
            try {
                luaValue2 = ap0.g().a(luaString0, luaValue5);
                goto label_35;
            }
            catch(Exception exception0) {
                luaValue6 = luaValue5;
            }
        label_32:
            if(exception0 instanceof o) {
                ((o)exception0).l = "error loading module \'" + luaString0 + "\'" + (luaValue6 == null ? "" : " from file \'" + luaValue6 + "\'") + ":\n";
            }
            throw exception0;
        label_35:
            if(!luaValue2.F()) {
                luaValue1.b(luaString0, luaValue2);
                return luaValue2;
            }
            luaValue2 = luaValue1.w(luaString0);
            if(luaValue2 == PackageLib.l) {
                luaValue1.b(luaString0, LuaValue.v);
                return LuaValue.v;
            }
        }
        else if(luaValue2 == PackageLib.l) {
            PackageLib.require.f(("loop or previous error loading module \'" + luaString0 + '\''));
            return luaValue2;
        }
        return luaValue2;
    }
}

