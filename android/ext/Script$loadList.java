package android.ext;

import java.io.File;
import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;

final class Script.loadList extends Script.ApiFunction {
    final Script d;

    Script.loadList(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.loadList(string file [, int flags = 0]) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        if(v != 2) {
            return super.a(writer0, v, luaValue0);
        }
        return luaValue0.h_() ? Script.loadList.a(writer0, this.d.i.e, luaValue0) : super.a(writer0, 2, luaValue0);
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        File file0 = new File(ap0.r(1));
        if(!file0.exists()) {
            return LuaValue.m(("File \'" + file0.getAbsolutePath() + "\' not found"));
        }
        if(!file0.isFile()) {
            return LuaValue.m(("Path \'" + file0.getAbsolutePath() + "\' is not a file"));
        }
        if(!file0.canRead()) {
            return LuaValue.m(("File \'" + file0.getAbsolutePath() + "\' can not be read"));
        }
        int v = ap0.d(2, 0);
        try {
            kx.a(MainService.instance.ap.f, file0.getAbsolutePath(), v | 4);
            return LuaValue.v;
        }
        catch(Throwable throwable0) {
            la.c(("Failed load list: " + file0.getAbsolutePath() + "; " + v), throwable0);
            return LuaValue.m(Script.a(throwable0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 2;
    }
}

