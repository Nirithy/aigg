package android.ext;

import java.io.UnsupportedEncodingException;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;

final class Script.bytes extends Script.ApiFunction {
    final Script d;

    Script.bytes(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.bytes(string text [, string encoding = \'UTF-8\']) -> table";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        String s = ap0.r(1);
        String s1 = ap0.c(2, "UTF-8");
        try {
            byte[] arr_b = s.getBytes(s1);
            ap ap1 = new LuaTable();
            ((LuaTable)ap1).d_(arr_b.length);
            for(int v = 0; true; ++v) {
                if(v >= arr_b.length) {
                    return ap1;
                }
                ((LuaTable)ap1).b(v + 1, LuaValue.d(arr_b[v] & 0xFF));
            }
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new o(unsupportedEncodingException0);
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 2;
    }
}

