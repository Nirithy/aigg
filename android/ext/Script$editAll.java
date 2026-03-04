package android.ext;

import android.c.a;
import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;

final class Script.editAll extends Script.ApiFunction {
    final Script d;

    Script.editAll(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.editAll(string value, int type) -> count of changed || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        if(v != 2) {
            return super.a(writer0, v, luaValue0);
        }
        return luaValue0.h_() ? Script.editAll.a(writer0, this.d.i.b, luaValue0) : super.a(writer0, 2, luaValue0);
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        int v20;
        d d1;
        String s1;
        long v15;
        long v14;
        int v13;
        long v11;
        int v10;
        pv pv1;
        long v19;
        String[] arr_s1;
        byte[] arr_b;
        char[] arr_c;
        if(!this.d.g) {
            throw new o("You must call gg.getResults before calling gg.editAll.");
        }
        try {
            int v = 0;
            String s = Script.a(ap0.r(1));
            int v1 = Script.b(ap0.o(2));
            rd rd0 = ra.a(s, false);
            int v2 = rd0 == null ? 0 : rd0.b;
            if(rd0 != null) {
                s = rd0.a;
            }
            MainService mainService0 = MainService.instance;
            a a0 = mainService0.am;
            int v3 = a0.b();
            if(v1 == 1 && ps.d(s)) {
                arr_c = null;
                arr_b = ps.a(s);
                arr_s1 = null;
            }
            else if((v1 & 6) != 0 && ps.d(s) && s.charAt(0) == 59) {
                arr_c = s.substring(1).toCharArray();
                arr_b = null;
                arr_s1 = null;
            }
            else if(s.indexOf(59) != -1) {
                String[] arr_s = s.split(";");
                if(arr_s.length == 0) {
                    arr_c = null;
                    arr_b = null;
                    arr_s1 = null;
                }
                else {
                    arr_c = null;
                    arr_b = null;
                    arr_s1 = arr_s;
                }
            }
            else {
                arr_c = null;
                arr_b = null;
                arr_s1 = null;
            }
            d d0 = new d();
            pv pv0 = null;
            pv[] arr_pv = arr_s1 == null ? null : new pv[arr_s1.length];
            int v4 = 0;
            long v5 = 0L;
            int v6 = 0;
            while(true) {
                if(v6 < v3) {
                    try {
                        a0.a(v6, d0);
                        goto label_57;
                    }
                    catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                        la.b("List changed", indexOutOfBoundsException0);
                    }
                }
                mainService0.k.g(this.d.a());
                Object object0 = new Object();
                synchronized(object0) {
                    rx.a(new Script.editAll.1(this, object0));
                    Script.a(object0);
                }
                return LuaValue.d(v);
            label_57:
                if(d0.d == v1) {
                    if(arr_b != null) {
                        int v17 = v5 + 1L == d0.b ? v4 : 0;
                        long v18 = d0.b;
                        if(v17 < arr_b.length) {
                            v13 = v17 + 1;
                            v19 = 0xFFL & ((long)arr_b[v17]);
                        }
                        else {
                            v19 = 0L;
                            v13 = v17;
                        }
                        d0.c = v19;
                        v15 = v18;
                        s1 = s;
                    }
                    else if(arr_c == null) {
                        if(arr_s1 == null) {
                            if(pv0 == null) {
                                pv1 = d.a(null, s, v1, 0x7F0700CF, d0.b);  // string:number_name "number"
                                v13 = v4;
                            }
                            else {
                                v13 = v4;
                                pv1 = pv0;
                            }
                            s1 = s;
                        }
                        else {
                            int v16 = v6 % arr_s1.length;
                            String s2 = arr_s1[v16];
                            pv1 = arr_pv[v16];
                            if(pv1 == null) {
                                pv1 = d.a(null, s2, v1, 0x7F0700CF, d0.b);  // string:number_name "number"
                                arr_pv[v16] = pv1;
                            }
                            v13 = v16;
                            s1 = s2;
                        }
                        d0.a(null, pv1, s1, d0.b, "0", 0);
                        v15 = v5;
                        pv0 = pv1;
                    }
                    else {
                        boolean z = d0.d == 2;
                        int v8 = ((long)(z ? 2 : 4)) + v5 == d0.b ? v4 : 0;
                        long v9 = d0.b;
                        if(v8 < arr_c.length) {
                            v10 = v8 + 1;
                            v11 = 0xFFFFL & ((long)arr_c[v8]);
                        }
                        else {
                            v11 = 0L;
                            v10 = v8;
                        }
                        d0.c = v11;
                        if(z) {
                            v15 = v9;
                            v13 = v10;
                        }
                        else {
                            long v12 = d0.c;
                            if(v10 < arr_c.length) {
                                v13 = v10 + 1;
                                v14 = (0xFFFFL & ((long)arr_c[v10])) << 16;
                            }
                            else {
                                v14 = 0L;
                                v13 = v10;
                            }
                            d0.c = v14 | v12;
                            v15 = v9;
                        }
                        s1 = s;
                    }
                    d0.m(v2);
                    d1 = new d();
                    v20 = v + 1;
                }
                else {
                    v15 = v5;
                    v13 = v4;
                    d1 = d0;
                    s1 = s;
                    v20 = v;
                }
                ++v6;
                v5 = v15;
                v4 = v13;
                d0 = d1;
                s = s1;
                v = v20;
            }
        }
        catch(NumberFormatException numberFormatException0) {
            return LuaValue.m(Script.a(numberFormatException0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 2;
    }
}

