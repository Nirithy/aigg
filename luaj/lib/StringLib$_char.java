package luaj.lib;

import luaj.LuaString;
import luaj.ap;

final class StringLib._char extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v = ap0.j_();
        byte[] arr_b = new byte[v];
        int v1 = 0;
        for(int v2 = 1; v1 < v; ++v2) {
            int v3 = ap0.o(v2);
            if(v3 < 0 || v3 >= 0x100) {
                StringLib._char.a(v2, "invalid value for string.char [0; 255]: " + v3);
            }
            arr_b[v1] = (byte)v3;
            ++v1;
        }
        return LuaString.b(arr_b);
    }
}

