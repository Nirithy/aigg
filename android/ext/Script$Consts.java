package android.ext;

import java.io.IOException;
import java.io.Writer;

class Script.Consts {
    Script.Const[] a;
    Script.Const[] b;
    Script.Const[] c;
    Script.Const[] d;
    Script.Const[] e;
    Script.Const[] f;
    Script.Const[] g;
    Script.Const[] h;
    Script.Const[] i;
    Script.Const[] j;

    Script.Consts() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    static boolean a(Writer writer0, long v) {
        try {
            if(v == 0L || v == -1L) {
                writer0.write(Long.toString(v));
                return true;
            }
            writer0.write("0x");
            writer0.write(Long.toHexString(v));
            return true;
        }
        catch(IOException iOException0) {
            la.b("Writer fail", iOException0);
            return false;
        }
    }

    static boolean a(Writer writer0, String s) {
        try {
            writer0.write("\"");
            if(s.length() <= 0xFFFF) {
                s = s.replace("\"", "\\\"");
            }
            writer0.write(s);
            writer0.write("\"");
            return true;
        }
        catch(IOException iOException0) {
            la.b("Writer fail", iOException0);
            return false;
        }
    }

    static boolean a(Writer writer0, Script.Const[] arr_script$Const, int v) {
        try {
            boolean z = true;
            int v2 = v;
            for(int v1 = 0; true; ++v1) {
                if(v1 >= arr_script$Const.length) {
                    if(z || v2 != 0) {
                        writer0.write(Integer.toString(v2));
                    }
                    return true;
                }
                Script.Const script$Const0 = arr_script$Const[v1];
                int v3 = script$Const0.b;
                if((v2 & v3) == v3) {
                    writer0.write(script$Const0.a);
                    v2 &= ~v3;
                    if(v2 != 0) {
                        writer0.write(" | ");
                    }
                    z = false;
                }
            }
        }
        catch(IOException iOException0) {
            la.b("Writer fail", iOException0);
            return false;
        }
    }

    static boolean b(Writer writer0, String s) {
        return Script.Consts.a(writer0, Script.a_(s));
    }
}

