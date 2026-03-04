package luaj.lib;

import java.util.Arrays;
import luaj.LuaString;
import luaj.ap;

final class Utf8Lib._char extends VarArgFunction {
    // This method was un-flattened
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v6;
        int v5;
        int v4;
        int v = ap0.j_();
        if(v == 0) {
            return Utf8Lib._char.ad;
        }
        byte[] arr_b = new byte[v * 4];
        int v1 = 1;
        int v2;
        for(v2 = 0; v1 <= v; v2 = v5 + v2) {
            int v3 = ap0.o(v1);
            if(v3 < 0 || v3 > 0x10FFFF) {
                Utf8Lib._char.a(v1, this.g_(), "\'" + v3 + "\': value out of range [0; " + 0x10FFFF + "]");
            }
            if(v3 <= 0x7F) {
                v4 = 0;
                v5 = 1;
            }
            else if(v3 <= 0x7FF) {
                v5 = 2;
                v4 = 0xC0;
                arr_b[v2 + 1] = (byte)(v3 & 0x3F | 0x80);
                v3 >>= 6;
            }
            else {
                if(v3 <= 0xFFFF) {
                    v5 = 3;
                    v4 = 0xE0;
                    arr_b[v2 + 2] = (byte)(v3 & 0x3F | 0x80);
                    v3 >>= 6;
                    v6 = 1;
                }
                else {
                    v5 = 4;
                    v4 = 0xF0;
                    arr_b[v2 + 3] = (byte)(v3 & 0x3F | 0x80);
                    v3 >>= 6;
                    v6 = 2;
                }
                while(true) {
                    arr_b[v2 + v6] = (byte)(v3 & 0x3F | 0x80);
                    v3 >>= 6;
                    --v6;
                    if(v6 <= 0) {
                        break;
                    }
                }
            }
            arr_b[v2] = (byte)(v4 | v3);
            ++v1;
        }
        return v2 >= arr_b.length ? LuaString.b(arr_b, 0, v2) : LuaString.b(Arrays.copyOf(arr_b, v2), 0, v2);
    }
}

