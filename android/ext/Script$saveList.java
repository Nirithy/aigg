package android.ext;

import java.io.File;
import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;

final class Script.saveList extends Script.ApiFunction {
    final Script d;

    Script.saveList(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.saveList(string file [, int flags = 0]) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        if(v != 2) {
            return super.a(writer0, v, luaValue0);
        }
        return luaValue0.h_() ? Script.saveList.a(writer0, this.d.i.f, luaValue0) : super.a(writer0, 2, luaValue0);
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        File file0 = new File(ap0.r(1));
        if(file0.isDirectory()) {
            return LuaValue.m(("Path \'" + file0.getAbsolutePath() + "\' is a directory"));
        }
        int v1 = ap0.d(2, 0);
        MainService mainService0 = MainService.instance;
        try {
            SavedListAdapter savedListAdapter0 = mainService0.an;
            int v2 = savedListAdapter0.getCount();
            qx[] arr_qx = new qx[v2];
            for(int v = 0; true; ++v) {
                if(v >= v2) {
                    kx.a(mainService0.ap.f, arr_qx, file0.getAbsolutePath(), v1);
                    return LuaValue.v;
                }
                arr_qx[v] = savedListAdapter0.b(v);
            }
        }
        catch(Throwable throwable0) {
            la.c(("Failed saved list: " + file0.getAbsolutePath() + "; " + v1), throwable0);
            return LuaValue.m(Script.a(throwable0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 2;
    }
}

