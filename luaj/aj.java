package luaj;

import android.ext.iu;
import android.ext.la;
import android.ext.ts;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class aj extends m {
    public static PrintStream b;
    public static final String[] c;
    private static final int d;

    static {
        aj.b = System.out;
        aj.c = new String[]{"MOVE", "LOADK", "LOADKX", "LOADBOOL", "LOADNIL", "GETUPVAL", "GETTABUP", "GETTABLE", "SETTABUP", "SETUPVAL", "SETTABLE", "NEWTABLE", "SELF", "ADD", "SUB", "MUL", "DIV", "MOD", "POW", "UNM", "NOT", "LEN", "CONCAT", "JMP", "EQ", "LT", "LE", "TEST", "TESTSET", "CALL", "TAILCALL", "RETURN", "FORLOOP", "FORPREP", "TFORCALL", "TFORLOOP", "SETLIST", "CLOSURE", "VARARG", "EXTRAARG", "IDIV", "BNOT", "BAND", "BOR", "BXOR", "SHL", "SHR", null};
        aj.d = 0x80001F;
    }

    public static int a(StringBuilder stringBuilder0, al al0, int v, ak ak0) {
        CharSequence charSequence2;
        int v25;
        CharSequence charSequence1;
        int v12;
        int v11;
        int v1 = al0.B;
        int v2 = al0.v.length;
        int[] arr_v = al0.r;
        int v3 = arr_v[v];
        int v4 = aj.a(v3);
        if(ak0 != null) {
            int v5 = aj.b(al0, v);
            if(v5 != ak0.b) {
                ak0.b = v5;
                stringBuilder0.append(".line ");
                stringBuilder0.append(v5);
                stringBuilder0.append('\n');
                stringBuilder0.append(ak0.c);
            }
        }
        CharSequence charSequence0 = null;
        if(v4 < aj.c.length - 1 && v4 != 39) {
            int v6 = aj.b(v3);
            int v7 = aj.d(v3);
            int v8 = aj.e(v3);
            int v9 = aj.f(v3);
            int v10 = aj.g(v3);
            if(v4 != 2) {
                v12 = v4;
                v11 = v;
            }
            else if(v + 1 >= arr_v.length) {
                v9 = 0x7FFFFFFF;
                v11 = v;
                v12 = 1;
            }
            else {
                int v13 = arr_v[v + 1];
                if(aj.a(v13) == 39) {
                    v9 = aj.c(v13);
                    v12 = 1;
                    v11 = v + 1;
                }
                else {
                    v9 = 0x7FFFFFFE;
                    v12 = 1;
                    v11 = v;
                }
            }
            if(v12 == 33) {
                for(int v14 = 1; v14 <= 3; ++v14) {
                    charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v6 + v14);
                }
                if(ak0 != null) {
                    for(int v15 = 0; v15 <= 3; ++v15) {
                        stringBuilder0.append("; .local v");
                        stringBuilder0.append(v6 + v15);
                        stringBuilder0.append(" \"(for ");
                        switch(v15) {
                            case 0: {
                                stringBuilder0.append("index");
                                break;
                            }
                            case 1: {
                                stringBuilder0.append("limit");
                                break;
                            }
                            case 2: {
                                stringBuilder0.append("step");
                                break;
                            }
                            case 3: {
                                stringBuilder0.append("iterator");
                            }
                        }
                        stringBuilder0.append(")\"");
                        stringBuilder0.append('\n');
                        stringBuilder0.append(ak0.c);
                    }
                }
            }
            stringBuilder0.append(aj.c[v12]);
            stringBuilder0.append(' ');
        alab1:
            switch(aj.k(v12)) {
                case 0: {
                    switch(v12) {
                        case 8: {
                            stringBuilder0.append('u');
                            charSequence0 = aj.c(((StringBuilder)charSequence0), v2, v6);
                            break;
                        }
                        case 24: 
                        case 25: 
                        case 26: {
                            break;
                        }
                        default: {
                            stringBuilder0.append('v');
                            charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v6);
                        }
                    }
                    stringBuilder0.append(v6);
                    switch(v12) {
                        case 4: {
                            stringBuilder0.append("..v");
                            int v18 = v6 + v7;
                            stringBuilder0.append(v18);
                            charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v18);
                            v = v11;
                            break alab1;
                        }
                        case 0x1F: {
                            if(v7 >= 2) {
                                stringBuilder0.append("..v");
                                int v21 = v6 + v7 - 2;
                                stringBuilder0.append(v21);
                                charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v21);
                            }
                            v = v11;
                            break alab1;
                        }
                        case 34: {
                            stringBuilder0.append("..v");
                            int v22 = v8 + v6 + 2;
                            stringBuilder0.append(v22);
                            charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v22);
                            v = v11;
                            break alab1;
                        }
                        case 36: {
                            if(v7 != 0) {
                                stringBuilder0.append("..v");
                                int v23 = v6 + v7;
                                stringBuilder0.append(v23);
                                charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v23);
                            }
                            stringBuilder0.append(' ');
                            if(v8 == 0) {
                                if(v11 >= arr_v.length) {
                                    charSequence0 = aj.a(((StringBuilder)charSequence0), "no OP after SETLIST with c = 0");
                                }
                                else {
                                    int v24 = arr_v[v11 + 1];
                                    charSequence0 = aj.a(((StringBuilder)charSequence0), "c stored in next OP (as " + v24 + ")");
                                    if(v24 > 0 && (ak0 == null || (ak0.d[v11 + 1] & 0x60) == 0)) {
                                        ++v11;
                                        v8 = v24;
                                    }
                                }
                            }
                            stringBuilder0.append(v8);
                            v = v11;
                            break alab1;
                        }
                        case 29: 
                        case 30: 
                        case 38: {
                            if(v7 != 0) {
                                stringBuilder0.append("..v");
                                int v19 = v6 + v7 - 1;
                                stringBuilder0.append(v19);
                                charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v19);
                            }
                            if(v12 != 29) {
                                v = v11;
                            }
                            else if(v8 == 0) {
                                stringBuilder0.append(" SET_TOP");
                                v = v11;
                            }
                            else {
                                if(v8 > 1) {
                                    stringBuilder0.append(" v");
                                    stringBuilder0.append(v6);
                                    stringBuilder0.append("..v");
                                    int v20 = v8 + v6 - 2;
                                    stringBuilder0.append(v20);
                                    charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v20);
                                    v = v11;
                                    break alab1;
                                }
                                v = v11;
                                break alab1;
                            }
                            break alab1;
                        }
                        default: {
                            int v16 = aj.l(v12);
                            if(v16 != 0) {
                                stringBuilder0.append(' ');
                                if(v16 != 3 || !aj.h(v7)) {
                                    if(v12 != 3 && v12 != 11) {
                                        if(v16 == 1) {
                                            stringBuilder0.append('u');
                                            charSequence0 = aj.c(((StringBuilder)charSequence0), v2, v7);
                                        }
                                        else {
                                            stringBuilder0.append('v');
                                            charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v7);
                                        }
                                    }
                                    stringBuilder0.append(v7);
                                }
                                else {
                                    aj.a(stringBuilder0, al0, aj.i(v7));
                                }
                            }
                            charSequence1 = charSequence0;
                            if(v12 != 3) {
                                int v17 = aj.m(v12);
                                if(v17 == 0) {
                                    charSequence0 = charSequence1;
                                }
                                else {
                                    stringBuilder0.append((v12 == 22 ? ".." : " "));
                                    if(v17 != 3 || !aj.h(v8)) {
                                        if(v17 == 1) {
                                            charSequence0 = charSequence1;
                                        }
                                        else {
                                            stringBuilder0.append('v');
                                            charSequence0 = aj.b(((StringBuilder)charSequence1), v1, v8);
                                        }
                                        stringBuilder0.append(v8);
                                    }
                                    else {
                                        aj.a(stringBuilder0, al0, aj.i(v8));
                                        charSequence0 = charSequence1;
                                    }
                                }
                                if(v12 != 38 || al0.A != 0) {
                                    v = v11;
                                    break alab1;
                                }
                                else {
                                    charSequence0 = aj.a(((StringBuilder)charSequence0), "func not vararg");
                                    v = v11;
                                }
                            }
                            else if(v8 != 0) {
                                stringBuilder0.append(" SKIP_NEXT");
                                charSequence0 = charSequence1;
                                v = v11;
                            }
                            else {
                                charSequence0 = charSequence1;
                                v = v11;
                            }
                            break alab1;
                        }
                    }
                }
                case 1: {
                    stringBuilder0.append('v');
                    StringBuilder stringBuilder1 = aj.b(((StringBuilder)charSequence0), v1, v6);
                    stringBuilder0.append(v6);
                    if(aj.l(v12) == 3) {
                        stringBuilder0.append(' ');
                        if(v9 == 0x7FFFFFFF) {
                            stringBuilder1 = aj.a(stringBuilder1, "No OP after LOADKX");
                            v25 = 0x3FFFF;
                        }
                        else if(v9 == 0x7FFFFFFE) {
                            stringBuilder1 = aj.a(stringBuilder1, "Next OP after LOADKX not EXTRAARG");
                            v25 = 0x3FFFF;
                        }
                        else {
                            v25 = v9;
                        }
                        aj.a(stringBuilder0, al0, v25);
                        charSequence0 = stringBuilder1;
                        v = v11;
                    }
                    else {
                        stringBuilder0.append(' ');
                        if(v12 != 37 || ak0 == null) {
                            stringBuilder0.append(v9);
                            charSequence0 = stringBuilder1;
                            v = v11;
                        }
                        else if(v9 < al0.s.length) {
                            stringBuilder0.append('F');
                            v9 += ak0.a;
                            stringBuilder0.append(v9);
                            charSequence0 = stringBuilder1;
                            v = v11;
                            break;
                        }
                        else {
                            stringBuilder0.append("FUNC[");
                            stringBuilder0.append(v9);
                            stringBuilder0.append(']');
                            charSequence0 = stringBuilder1;
                            v = v11;
                        }
                    }
                    break;
                }
                case 2: {
                    if(v12 == 23 && v6 == 0) {
                        charSequence2 = charSequence0;
                    }
                    else {
                        stringBuilder0.append('v');
                        int v26 = v12 == 23 ? v6 - 1 : v6;
                        stringBuilder0.append(v26);
                        charSequence2 = aj.b(((StringBuilder)charSequence0), v1, v26);
                        stringBuilder0.append(' ');
                    }
                    int v27 = v10 + v11 + 1;
                    if(v27 >= 0 && v27 <= arr_v.length) {
                        stringBuilder0.append(":goto_");
                        stringBuilder0.append(v27);
                    }
                    else {
                        stringBuilder0.append("GOTO[");
                        stringBuilder0.append(v10);
                        stringBuilder0.append("]");
                    }
                    stringBuilder0.append("  ; ");
                    if(v10 >= 0) {
                        stringBuilder0.append('+');
                    }
                    stringBuilder0.append(v10);
                    stringBuilder0.append(' ');
                    stringBuilder0.append(((char)(v10 < 0 ? 8593 : 8595)));
                    charSequence0 = charSequence2;
                    v = v11;
                    break;
                }
                default: {
                    v = v11;
                    break alab1;
                }
            }
            if(v12 == 0x20) {
                for(int v28 = 1; v28 <= 3; ++v28) {
                    charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v6 + v28);
                }
                if(ak0 != null) {
                    if(charSequence0 == null) {
                        charSequence0 = new StringBuilder(0xA0);
                    }
                    for(int v29 = 0; v29 <= 3; ++v29) {
                        ((StringBuilder)charSequence0).append('\n');
                        ((StringBuilder)charSequence0).append(ak0.c);
                        ((StringBuilder)charSequence0).append("; .end local v");
                        ((StringBuilder)charSequence0).append(v6 + v29);
                        ((StringBuilder)charSequence0).append(" \"(for ");
                        switch(v29) {
                            case 0: {
                                ((StringBuilder)charSequence0).append("index");
                                break;
                            }
                            case 1: {
                                ((StringBuilder)charSequence0).append("limit");
                                break;
                            }
                            case 2: {
                                ((StringBuilder)charSequence0).append("step");
                                break;
                            }
                            case 3: {
                                ((StringBuilder)charSequence0).append("iterator");
                            }
                        }
                        ((StringBuilder)charSequence0).append(")\"");
                    }
                }
            }
            if(v12 == 35) {
                for(int v30 = -2; v30 <= 1; ++v30) {
                    if(v30 != 0) {
                        charSequence0 = aj.b(((StringBuilder)charSequence0), v1, v6 + v30);
                    }
                }
                if(ak0 != null) {
                    if(charSequence0 == null) {
                        charSequence0 = new StringBuilder(0xA0);
                    }
                    for(int v31 = -2; v31 <= 1; ++v31) {
                        ((StringBuilder)charSequence0).append('\n');
                        ((StringBuilder)charSequence0).append(ak0.c);
                        ((StringBuilder)charSequence0).append("; .end local v");
                        ((StringBuilder)charSequence0).append(v6 + v31);
                        ((StringBuilder)charSequence0).append(" \"(for ");
                        switch(v31) {
                            case -2: {
                                ((StringBuilder)charSequence0).append("generator");
                                break;
                            }
                            case -1: {
                                ((StringBuilder)charSequence0).append("state");
                                break;
                            }
                            case 0: {
                                ((StringBuilder)charSequence0).append("control");
                                break;
                            }
                            case 1: {
                                ((StringBuilder)charSequence0).append("key");
                            }
                        }
                        ((StringBuilder)charSequence0).append(")\"");
                    }
                }
            }
        }
        else {
            stringBuilder0.append("OP[");
            stringBuilder0.append(v4);
            stringBuilder0.append("] 0x");
            stringBuilder0.append(Integer.toHexString(v3));
        }
        if(charSequence0 != null) {
            stringBuilder0.append("  ");
            stringBuilder0.append(charSequence0);
        }
        return v;
    }

    public static int a(al al0, int v) {
        StringBuilder stringBuilder0 = new StringBuilder();
        int v1 = aj.a(stringBuilder0, al0, v, null);
        aj.b.print(stringBuilder0.toString());
        return v1;
    }

    private static StringBuilder a(StringBuilder stringBuilder0, String s) {
        if(stringBuilder0 == null) {
            stringBuilder0 = new StringBuilder(s.length() + 2);
        }
        stringBuilder0.append("; ");
        stringBuilder0.append(s);
        return stringBuilder0;
    }

    private static void a(String s, int v) {
        int v1 = s.length();
        if(v1 > v) {
            aj.b.print(s.substring(0, v));
            return;
        }
        aj.b.print(s);
        int v2 = v - v1;
        while(true) {
            --v2;
            if(v2 < 0) {
                break;
            }
            aj.b.print(' ');
        }
    }

    static void a(StringBuilder stringBuilder0, int v, int v1) {
        int v2 = aj.a(v1);
        int v3 = aj.b(v1);
        int v4 = aj.d(v1);
        int v5 = aj.e(v1);
        int v6 = aj.f(v1);
        int v7 = aj.g(v1);
        stringBuilder0.append(" ; PC ");
        stringBuilder0.append(v);
        stringBuilder0.append(" CODE ");
        ts.a(stringBuilder0, 8, v1);
        stringBuilder0.append(" OP ");
        stringBuilder0.append(v2);
        stringBuilder0.append(" A ");
        stringBuilder0.append(v3);
        stringBuilder0.append(" B ");
        stringBuilder0.append(v4);
        stringBuilder0.append(" C ");
        stringBuilder0.append(v5);
        stringBuilder0.append(" Bx ");
        stringBuilder0.append(v6);
        stringBuilder0.append(" sBx ");
        stringBuilder0.append(v7);
    }

    public static void a(StringBuilder stringBuilder0, LuaString luaString0) {
        byte[] arr_b;
        int v1;
        int v;
        String s;
        if(luaString0 == null) {
            stringBuilder0.append("nil");
            return;
        }
        stringBuilder0.append('\"');
        char[] arr_c = iu.a;
        boolean z = luaString0.s_();
        if(z) {
            s = luaString0.d_();
            v = s.length();
            v1 = 0;
            arr_b = null;
        }
        else {
            arr_b = luaString0.b;
            v = luaString0.d;
            v1 = luaString0.c;
            s = null;
        }
        for(int v2 = 0; v2 < v; ++v2) {
            int v3 = z ? s.charAt(v2) : ((char)arr_b[v1 + v2]);
            if(v3 < 0x20 || v3 > 0x7E || v3 == 34 || v3 == 92) {
                switch(v3) {
                    case 7: {
                        stringBuilder0.append('\\');
                        stringBuilder0.append('a');
                        break;
                    }
                    case 8: {
                        stringBuilder0.append('\\');
                        stringBuilder0.append('b');
                        break;
                    }
                    case 9: {
                        stringBuilder0.append('\\');
                        stringBuilder0.append('t');
                        break;
                    }
                    case 10: {
                        stringBuilder0.append('\\');
                        stringBuilder0.append('n');
                        break;
                    }
                    case 11: {
                        stringBuilder0.append('\\');
                        stringBuilder0.append('v');
                        break;
                    }
                    case 12: {
                        stringBuilder0.append('\\');
                        stringBuilder0.append('f');
                        break;
                    }
                    case 13: {
                        stringBuilder0.append('\\');
                        stringBuilder0.append('r');
                        break;
                    }
                    case 34: 
                    case 92: {
                        stringBuilder0.append('\\');
                        stringBuilder0.append(((char)v3));
                        break;
                    }
                    default: {
                        if(!z || v3 < 0x20) {
                            stringBuilder0.append("\\x");
                            stringBuilder0.append(arr_c[(v3 & 0xF0) >> 4]);
                            stringBuilder0.append(arr_c[v3 & 15]);
                        }
                        else {
                            stringBuilder0.append(((char)v3));
                        }
                    }
                }
            }
            else {
                stringBuilder0.append(((char)v3));
            }
        }
        stringBuilder0.append('\"');
    }

    static void a(StringBuilder stringBuilder0, LuaValue luaValue0) {
        if(luaValue0 == null) {
            stringBuilder0.append("null");
            return;
        }
        if(luaValue0 instanceof LuaLong) {
            stringBuilder0.append(luaValue0.w());
            return;
        }
        if(luaValue0 instanceof LuaDouble) {
            String s = Double.toString(luaValue0.x());
            stringBuilder0.append(s);
            if(s.indexOf(46) < 0) {
                stringBuilder0.append(".0");
                return;
            }
            return;
        }
        if(luaValue0.e_() != 4) {
            stringBuilder0.append(luaValue0.d_());
            return;
        }
        aj.a(stringBuilder0, ((LuaString)luaValue0));
    }

    static void a(StringBuilder stringBuilder0, al al0, int v) {
        if(v < al0.q.length) {
            aj.a(stringBuilder0, al0.q[v]);
            return;
        }
        stringBuilder0.append("CONST[");
        stringBuilder0.append(v);
        stringBuilder0.append("]");
    }

    public static void a(LuaClosure luaClosure0, int v, LuaValue[] arr_luaValue, int v1, ap ap0) {
        PrintStream printStream0 = aj.b;
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        aj.b = new PrintStream(byteArrayOutputStream0);
        aj.a(luaClosure0.a, v);
        aj.b.flush();
        aj.b.close();
        aj.b = printStream0;
        aj.a(byteArrayOutputStream0.toString(), 50);
        aj.a(arr_luaValue, v1, ap0);
        aj.b.println();
    }

    public static void a(LuaClosure luaClosure0, String s) {
        int v = luaClosure0.a.C;
        if(v >= 0 && luaClosure0.d != null) {
            File file0 = new File(luaClosure0.d);
            if(file0.exists()) {
                try {
                    FileInputStream fileInputStream0 = new FileInputStream(file0);
                    fileInputStream0.skip(((long)v));
                    FileOutputStream fileOutputStream0 = new FileOutputStream(s);
                    byte[] arr_b = new byte[0x10000];
                    while(true) {
                        int v1 = fileInputStream0.read(arr_b);
                        if(v1 <= 0) {
                            fileOutputStream0.close();
                            fileInputStream0.close();
                            return;
                        }
                        fileOutputStream0.write(arr_b, 0, v1);
                    }
                }
                catch(IOException iOException0) {
                    la.a(("Fail save tail to " + s), iOException0);
                }
            }
        }
    }

    public static void a(al al0) {
        aj.b.print("; --[=========[ Lua assembler file generated by GameGuardian " + 101.099998f + " (" + 0x3F0E + ")\n");
        aj.b(al0, "", new ak());
        aj.b.print("; ]=========] gg.require(\'" + 101.099998f + "\', " + 0x3F0E + ")\n");
    }

    static void a(al al0, String s) {
        StringBuilder stringBuilder0 = new StringBuilder(al0.w.L() + 2);
        aj.a(stringBuilder0, al0.w);
        aj.b.print("; " + al0.v.length + " upvalues, " + al0.u.length + " locals, " + al0.q.length + " constants, " + al0.s.length + " funcs\n" + s + ".source " + stringBuilder0 + "\n" + s + ".linedefined " + al0.x + "\n" + s + ".lastlinedefined " + al0.y + "\n" + s + ".numparams " + al0.z + "\n" + s + ".is_vararg " + al0.A + "\n" + s + ".maxstacksize " + al0.B + "\n");
    }

    public static void a(al al0, String s, ak ak0) {
        ak0.c = s;
        PrintStream printStream0 = aj.b;
        int v = al0.r.length;
        byte[] arr_b = aj.a(al0, null);
        ak0.d = arr_b;
        StringBuilder[] arr_stringBuilder = new StringBuilder[v * 2];
        if(al0.u != null && al0.u.length > 0) {
            l[] arr_l = al0.u;
            int[] arr_v = new int[arr_l.length];
            int v1 = 0;
            for(int v2 = 0; v2 < arr_l.length; ++v2) {
                l l0 = arr_l[v2];
                int v3 = l0.c - 1;
                if(v3 >= l0.b) {
                    int v4 = Math.min(v1 - 1, arr_v.length - 1);
                    int v5 = v1;
                    while(v4 >= 0 && arr_v[v4] < l0.b) {
                        v5 = v4;
                        --v4;
                    }
                    arr_v[v5] = v3;
                    for(int v6 = 0; v6 < 2; ++v6) {
                        int v7 = v6 == 0 ? l0.b : v3;
                        if(v7 < 0) {
                            v7 = 0;
                        }
                        if(v7 >= v) {
                            v7 = v - 1;
                        }
                        int v8 = v7 * 2 + v6;
                        StringBuilder stringBuilder0 = arr_stringBuilder[v8];
                        if(stringBuilder0 == null) {
                            stringBuilder0 = new StringBuilder();
                            arr_stringBuilder[v8] = stringBuilder0;
                        }
                        stringBuilder0.append(s);
                        stringBuilder0.append((v6 == 0 ? ".local v" : ".end local v"));
                        stringBuilder0.append(v5);
                        stringBuilder0.append(' ');
                        aj.a(stringBuilder0, l0.a);
                        stringBuilder0.append('\n');
                    }
                    v1 = v5 + 1;
                }
            }
        }
        int v9 = v * 44 >= 0x2000 ? v * 44 : 0x2000;
        if(v9 > 0x10000) {
            v9 = 0x10000;
        }
        StringBuilder stringBuilder1 = new StringBuilder(v9);
        for(int v10 = 0; v10 < v; v10 = v12 + 1) {
            stringBuilder1.append('\n');
            int v11 = arr_b[v10];
            if((v11 & 0x20) != 0) {
                stringBuilder1.append(s);
                stringBuilder1.append(":goto_");
                stringBuilder1.append(v10);
                stringBuilder1.append('\n');
            }
            StringBuilder stringBuilder2 = arr_stringBuilder[v10 * 2];
            if(stringBuilder2 != null) {
                stringBuilder1.append(stringBuilder2);
                arr_stringBuilder[v10 * 2] = null;
            }
            stringBuilder1.append(s);
            int v12 = aj.a(stringBuilder1, al0, v10, ak0);
            switch(v11 & 0x1F) {
                case 0: {
                    stringBuilder1.append(" ; garbage");
                    break;
                }
                case 3: {
                    stringBuilder1.append(" ; unused");
                }
            }
            stringBuilder1.append('\n');
            for(int v13 = v10; v13 <= v12; ++v13) {
                for(int v14 = 0; v14 < 2; ++v14) {
                    StringBuilder stringBuilder3 = arr_stringBuilder[v13 * 2 + v14];
                    if(stringBuilder3 != null) {
                        stringBuilder1.append(stringBuilder3);
                        arr_stringBuilder[v13 * 2 + v14] = null;
                    }
                }
            }
            if(stringBuilder1.length() > v9) {
                printStream0.print(stringBuilder1.toString());
                stringBuilder1.setLength(0);
            }
        }
        if(stringBuilder1.length() > 0) {
            printStream0.print(stringBuilder1.toString());
        }
    }

    public static void a(LuaValue[] arr_luaValue, int v, ap ap0) {
        aj.b.print('[');
        for(int v1 = 0; v1 < arr_luaValue.length; ++v1) {
            LuaValue luaValue0 = arr_luaValue[v1];
            if(luaValue0 == null) {
                aj.b.print("null");
            }
            else if(luaValue0.e_() == 4) {
                LuaString luaString0 = luaValue0.z();
                aj.b.print((luaString0.L() >= 0x30 ? luaString0.a(0, 0x20).d_() + "...+" + (luaString0.L() - 0x20) + 'b' : luaString0.d_()));
            }
            else {
                aj.b.print(luaValue0.d_());
            }
            if(v1 + 1 == v) {
                aj.b.print(']');
            }
            aj.b.print(" | ");
        }
        aj.b.print(ap0);
    }

    private static boolean a(byte[] arr_b, al al0, int[] arr_v, int[] arr_v1) {
        int v19;
        int v15;
        int v9;
        int v8;
        boolean z = false;
        int v = aj.c.length - 1;
        int v1 = al0.q.length;
        int v2 = al0.B;
        int v3 = 0;
        do {
            int v4 = v3;
            while(v4 >= 0 && v4 < arr_v.length) {
                int v5 = (byte)(arr_b[v4] & 0x1F);
                if(v5 == 1) {
                    break;
                }
                arr_b[v4] = (byte)(1 - v5 + arr_b[v4]);
                int v6 = arr_v[v4];
                int v7 = aj.a(v6);
                if(v7 >= v) {
                    v8 = aj.d;
                    v9 = v4;
                }
                else {
                    int v10 = aj.b(v6);
                    int v11 = aj.d(v6);
                    int v12 = aj.e(v6);
                    int v13 = aj.f(v6);
                    int v14 = aj.g(v6);
                alab1:
                    switch(aj.k(v7)) {
                        case 0: {
                            switch(v7) {
                                case 8: {
                                    if(v10 >= al0.v.length) {
                                        v15 = aj.d;
                                        goto label_31;
                                    }
                                    break;
                                }
                                case 24: 
                                case 25: 
                                case 26: {
                                    break;
                                }
                                default: {
                                    if(v10 >= v2) {
                                        v15 = aj.d;
                                        goto label_31;
                                    }
                                }
                            }
                            v15 = v6;
                        label_31:
                            switch(v7) {
                                case 4: {
                                    if(v11 + v10 >= v2) {
                                        v8 = aj.d;
                                        v9 = v4;
                                        break;
                                    }
                                    v8 = v15;
                                    v9 = v4;
                                    break;
                                }
                                case 34: {
                                    if(v10 + v12 + 2 >= v2) {
                                        v8 = aj.d;
                                        v9 = v4;
                                        break;
                                    }
                                    v8 = v15;
                                    v9 = v4;
                                    break;
                                }
                                case 36: {
                                    if(v11 + v10 >= v2) {
                                        v8 = aj.d;
                                        v9 = v4;
                                    }
                                    else if(v12 != 0) {
                                        v8 = v15;
                                        v9 = v4;
                                    }
                                    else if(v4 == arr_v.length - 1) {
                                        v8 = aj.d;
                                        v9 = v4;
                                    }
                                    else {
                                        v9 = v4 + 1;
                                        arr_b[v9] = (byte)((arr_b[v9] & 0xFFFFFFE0) + 1);
                                        v8 = v15;
                                    }
                                    break;
                                }
                                case 29: 
                                case 30: 
                                case 0x1F: 
                                case 38: {
                                    if(v11 > 0 && v10 + v11 - (v7 == 0x1F ? 2 : 1) >= v2) {
                                        v15 = aj.d;
                                    }
                                    v9 = v7 != 30 && v7 != 0x1F ? v4 : v3 - 1;
                                    v8 = v7 != 29 || v12 <= 1 || v10 < v2 && v10 + v12 - 2 < v2 ? v15 : aj.d;
                                    break;
                                }
                                default: {
                                    int v16 = aj.l(v7);
                                    if(v16 != 0) {
                                        if(v16 != 3 || !aj.h(v11)) {
                                            if(v7 != 3 && v7 != 11) {
                                                if(v16 != 1) {
                                                    if(v11 >= v2) {
                                                        v15 = aj.d;
                                                    }
                                                }
                                                else if(v11 >= al0.v.length) {
                                                    v15 = aj.d;
                                                }
                                            }
                                        }
                                        else if(aj.i(v11) >= v1) {
                                            v15 = aj.d;
                                        }
                                    }
                                    int v17 = aj.m(v7);
                                    if(v17 != 0) {
                                        if(v17 != 3 || !aj.h(v12)) {
                                            if(v17 != 1 && v12 >= v2) {
                                                v15 = aj.d;
                                            }
                                        }
                                        else if(aj.i(v12) >= v1) {
                                            v15 = aj.d;
                                        }
                                    }
                                    switch(v7) {
                                        case 3: {
                                            if(v12 == 0) {
                                                v8 = v15;
                                                v9 = v4;
                                                break;
                                            }
                                            goto label_61;
                                        }
                                        case 24: 
                                        case 25: 
                                        case 26: 
                                        case 27: 
                                        case 28: {
                                        label_61:
                                            if(v15 != aj.d && (arr_b[v4 + 2] & 0x1F) == 0) {
                                                arr_b[v4 + 2] = (byte)(arr_b[v4 + 2] + 2 | 0x40);
                                                v8 = v15;
                                                v9 = v4;
                                                break;
                                            }
                                            v8 = v15;
                                            v9 = v4;
                                            break;
                                        }
                                        default: {
                                            v8 = v15;
                                            v9 = v4;
                                        }
                                    }
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch(v7) {
                                case 1: {
                                    if(v10 >= v2 || v13 >= v1) {
                                        v8 = aj.d;
                                        v9 = v4;
                                        break alab1;
                                    }
                                    break;
                                }
                                case 2: {
                                    if(v10 >= v2 || v4 == arr_v.length - 1 || aj.a(arr_v[v4 + 1]) != 39 || aj.c(arr_v[v4 + 1]) >= v1) {
                                        v8 = aj.d;
                                        v9 = v4;
                                        break alab1;
                                    }
                                    break;
                                }
                                case 37: {
                                    if(v10 >= v2 || v13 >= al0.s.length) {
                                        v8 = aj.d;
                                        v9 = v4;
                                        break alab1;
                                    }
                                    break;
                                }
                                default: {
                                    v8 = v6;
                                    v9 = v4;
                                    break alab1;
                                }
                            }
                            v8 = v6;
                            v9 = v4;
                            break;
                        }
                        case 2: {
                            switch(v7) {
                                case 0x20: 
                                case 33: {
                                    if(v10 >= v2 - 2) {
                                        v8 = aj.d;
                                        goto label_131;
                                    }
                                    break;
                                }
                                case 35: {
                                    if(v10 >= v2 - 1) {
                                        v8 = aj.d;
                                        goto label_131;
                                    }
                                }
                            }
                            v8 = v6;
                        label_131:
                            int v18 = v14 + v4 + 1;
                            if(v18 >= 0 && v18 < arr_v.length) {
                                if(v8 != aj.d) {
                                    if(v7 == 23) {
                                        v19 = v18 - 1;
                                        arr_b[v18] = (byte)(arr_b[v18] | 0x20);
                                        v9 = v19;
                                        break;
                                    }
                                    else if((arr_b[v18] & 0x1F) == 0) {
                                        arr_b[v18] = (byte)(arr_b[v18] + 2 | 0x40);
                                    }
                                }
                                v19 = v4;
                                arr_b[v18] = (byte)(arr_b[v18] | 0x20);
                                v9 = v19;
                            }
                            else {
                                v8 = aj.d;
                                v9 = v4;
                            }
                            break;
                        }
                        case 3: {
                            v8 = v4 != 0 && aj.a(arr_v[v4 - 1]) == 2 && aj.c(v6) < v1 ? v6 : aj.d;
                            v9 = v4;
                            break;
                        }
                        default: {
                            v8 = v6;
                            v9 = v4;
                            break;
                        }
                    }
                }
                if(v8 != v6) {
                    z = true;
                }
                arr_v1[v4] = v8;
                v4 = v9 + 1;
            }
            for(v3 = 0; true; ++v3) {
                if(v3 >= arr_v.length) {
                    v3 = -1;
                    break;
                }
                if((arr_b[v3] & 0x1F) == 2) {
                    break;
                }
            }
        }
        while(v3 > 0);
        for(int v20 = 0; v20 < arr_v.length; ++v20) {
            if((arr_b[v20] & 0x1F) == 0) {
                int v21 = arr_v[v20];
                int v22 = aj.a(v21);
                switch(v22) {
                    case 0x1F: {
                        if(v20 == arr_v.length - 1) {
                            v21 = aj.d;
                        }
                        else {
                            int v24 = aj.b(v21);
                            int v25 = aj.d(v21);
                            if(v25 < 0 || v24 >= v2 || v24 + v25 - 2 >= v2 || (arr_b[v20 - 1] & 0x1F) == 0) {
                                v21 = aj.d;
                            }
                        }
                        break;
                    }
                    case 23: 
                    case 0x20: 
                    case 33: 
                    case 35: {
                        int v23 = aj.g(v21) + v20 + 1;
                        boolean z1 = v23 < 0 || v23 >= arr_v.length;
                        if(!z1) {
                            arr_b[v23] = (byte)(arr_b[v23] | 0x20);
                        }
                        if(v22 != 23) {
                            v21 = aj.d;
                        }
                        else if(!z1 && (arr_b[v23] & 0x1F) != 0 && (arr_b[v20 - 1] & 0x1F) != 0) {
                            switch(aj.a(arr_v[v20 - 1])) {
                                case 23: 
                                case 0x1F: {
                                    v21 = aj.d;
                                }
                            }
                        }
                        else {
                            v21 = aj.d;
                        }
                        break;
                    }
                    default: {
                        v21 = aj.d;
                    }
                }
                if(v21 != aj.d || v20 == arr_v.length - 1) {
                    arr_b[v20] = (byte)(arr_b[v20] + 3);
                }
                if(!z && v21 != arr_v[v20]) {
                    z = true;
                }
                arr_v1[v20] = v21;
            }
        }
        return z;
    }

    public static byte[] a(al al0, int[] arr_v) {
        int[] arr_v1 = al0.r;
        if(arr_v == null) {
            arr_v = new int[arr_v1.length];
        }
        byte[] arr_b = new byte[arr_v1.length + 2];
        int[] arr_v2 = arr_v1;
        for(int v = 0; v < 100 && aj.a(arr_b, al0, arr_v2, arr_v); ++v) {
            if(v == 0) {
                arr_v2 = new int[arr_v1.length];
            }
            System.arraycopy(arr_v, 0, arr_v2, 0, arr_v1.length);
            for(int v1 = 0; v1 < arr_v1.length; ++v1) {
                arr_b[v1] = (byte)(arr_b[v1] & 0xFFFFFFE0);
            }
        }
        return arr_b;
    }

    private static int b(al al0, int v) {
        if(v < 0) {
            return 0;
        }
        int[] arr_v = al0.t;
        if(arr_v != null && v < arr_v.length) {
            int v1 = arr_v[v];
            return v1 < 0 ? 0 : v1;
        }
        return 0;
    }

    private static StringBuilder b(StringBuilder stringBuilder0, int v, int v1) {
        if(v1 < 0) {
            return aj.a(stringBuilder0, "impossible (negative) variable v" + v1);
        }
        return v1 < v ? stringBuilder0 : aj.a(stringBuilder0, "variable v" + v1 + " out of stack (.maxstacksize = " + v + " for this func)");
    }

    static void b(al al0, String s) {
        ao[] arr_ao = al0.v;
        if(arr_ao.length == 0) {
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append('\n');
        for(int v = 0; v < arr_ao.length; ++v) {
            ao ao0 = arr_ao[v];
            stringBuilder0.append(s);
            stringBuilder0.append(".upval ");
            stringBuilder0.append(((char)(ao0.b ? 0x76 : 0x75)));
            stringBuilder0.append(((int)ao0.c));
            stringBuilder0.append(' ');
            aj.a(stringBuilder0, ao0.a);
            stringBuilder0.append(" ; u");
            stringBuilder0.append(v);
            stringBuilder0.append('\n');
        }
        aj.b.print(stringBuilder0.toString());
    }

    public static void b(al al0, String s, ak ak0) {
        al[] arr_al = al0.s;
        aj.a(al0, s);
        aj.b(al0, s);
        aj.a(al0, s, ak0);
        int v = ak0.a;
        ak0.a = v + arr_al.length;
        for(int v1 = 0; v1 < arr_al.length; ++v1) {
            aj.b.print("\n");
            aj.b.print(s);
            aj.b.print(".func F" + (v + v1) + ' ');
            aj.b(arr_al[v1], s + "\t", ak0);
            aj.b.print(s);
            aj.b.print(".end ; F" + (v + v1) + "\n");
        }
    }

    private static StringBuilder c(StringBuilder stringBuilder0, int v, int v1) {
        return v1 < v ? stringBuilder0 : aj.a(stringBuilder0, "upvalue u" + v1 + " out of upvalues list (" + v + " upvalues for this func)");
    }
}

