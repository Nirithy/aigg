package luaj;

import android.ext.Script.ApiFunction;
import android.ext.la;
import android.ext.ts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LuaTable extends LuaValue implements ah {
    private static final LuaString a;
    private LuaValue[] b;
    private ad[] c;
    private static final ad[] d;
    private static volatile Set e;
    private static volatile int f;
    protected int o;
    protected ah p;

    static {
        LuaTable.a = LuaTable.m("n");
        LuaTable.d = new ad[0];
        LuaTable.e = null;
        LuaTable.f = 0;
    }

    public LuaTable() {
        this.b = LuaTable.B;
        this.c = LuaTable.d;
    }

    public LuaTable(int v, int v1) {
        this.a(v, v1);
    }

    public LuaTable(ap ap0, int v) {
        int v2 = Math.max(ap0.j_() - (v - 1), 0);
        this.a(v2, 1);
        LuaLong luaLong0 = LuaTable.d(v2);
        this.b(LuaTable.a, luaLong0);
        for(int v1 = 1; v1 <= v2; ++v1) {
            this.a(v1, ap0.c(v1 + (v - 1)));
        }
    }

    public LuaTable(LuaValue[] arr_luaValue, LuaValue[] arr_luaValue1, ap ap0) {
        int v1 = arr_luaValue == null ? 0 : arr_luaValue.length;
        int v2 = arr_luaValue1 == null ? 0 : arr_luaValue1.length;
        this.a((ap0 == null ? 0 : ap0.j_()) + v2, v1 >> 1);
        for(int v3 = 0; v3 < v2; ++v3) {
            this.b(v3 + 1, arr_luaValue1[v3]);
        }
        if(ap0 != null) {
            int v5 = ap0.j_();
            for(int v4 = 1; v4 <= v5; ++v4) {
                this.b(v2 + v4, ap0.c(v4));
            }
        }
        for(int v = 0; v < v1; v += 2) {
            if(!arr_luaValue[v + 1].F()) {
                this.c(arr_luaValue[v], arr_luaValue[v + 1]);
            }
        }
    }

    @Override  // luaj.LuaValue
    public ap A(LuaValue luaValue0) {
        ad ad1;
        int v;
        if(luaValue0.F()) {
            v = 0;
        }
        else if(luaValue0.q_()) {
            v = luaValue0.p();
            if(v <= 0 || v > this.b.length) {
                goto label_4;
            }
        }
        else {
        label_4:
            if(this.c.length == 0) {
                LuaTable.f(("invalid key to \'next\' 1: " + luaValue0));
            }
            int v1 = this.M(luaValue0);
            ad ad0 = this.c[v1];
            boolean z = false;
            while(true) {
                if(ad0 == null) {
                    if(!z) {
                        LuaTable.f(("invalid key to \'next\' 2: " + luaValue0));
                    }
                    v = this.b.length + 1 + v1;
                    break;
                }
                if(z) {
                    ae ae0 = ad0.a();
                    if(ae0 != null) {
                        return ae0.f();
                    }
                }
                else if(ad0.b(luaValue0)) {
                    z = true;
                }
                ad0 = ad0.u_();
            }
        }
        while(true) {
            if(v >= this.b.length) {
                for(int v2 = v - this.b.length; true; ++v2) {
                    if(v2 >= this.c.length) {
                        return LuaTable.u;
                    }
                    ad1 = this.c[v2];
                label_28:
                    if(ad1 != null) {
                        break;
                    }
                }
                ae ae1 = ad1.a();
                if(ae1 == null) {
                    ad1 = ad1.u_();
                    goto label_28;
                }
                return ae1.f();
            }
            if(this.b[v] != null) {
                LuaValue luaValue1 = this.p == null ? this.b[v] : this.p.a(this.b, v);
                if(luaValue1 != null) {
                    return LuaTable.b(LuaLong.b(v + 1), luaValue1);
                }
            }
            ++v;
        }
    }

    @Override  // luaj.LuaValue
    public ap B(LuaValue luaValue0) {
        int v = luaValue0.v();
        LuaValue luaValue1 = this.c_(v + 1);
        return luaValue1.F() ? LuaTable.x : LuaTable.b(LuaLong.b(v + 1), luaValue1);
    }

    protected static boolean C(LuaValue luaValue0) {
        switch(luaValue0.e_()) {
            case 1: 
            case 3: {
                return false;
            }
            case 4: {
                return luaValue0.M() > 0x20;
            }
            default: {
                return true;
            }
        }
    }

    public void D(LuaValue luaValue0) {
        int v = this.L();
        if(v >= 0xFFFFFF) {
            throw new o("array too big: " + v + " >= " + 0xFFFFFF);
        }
        if(this.p != null && this.p.V()) {
            this.ag();
        }
        if(v > 1) {
            if(luaValue0.F()) {
                luaValue0 = null;
            }
            this.f(v, luaValue0);
        }
    }

    @Override  // luaj.ah
    public LuaValue E(LuaValue luaValue0) {
        return luaValue0;
    }

    @Override  // luaj.LuaValue
    public LuaValue K() {
        LuaValue luaValue0 = this.I(LuaTable.P);
        return luaValue0.i_() ? luaValue0.a(this) : LuaLong.b(this.M());
    }

    private ae L(LuaValue luaValue0) {
        if(this.o > 0) {
            ad ad0 = this.c[this.M(luaValue0)];
            while(ad0 != null) {
                ae ae0 = ad0.a(luaValue0);
                if(ae0 == null) {
                    ad0 = ad0.u_();
                    continue;
                }
                return ae0;
            }
        }
        return null;
    }

    @Override  // luaj.LuaValue
    public int L() {
        if(this.p != null) {
            LuaValue luaValue0 = this.K();
            if(!luaValue0.q_()) {
                throw new o("table length is not an integer: " + luaValue0);
            }
            return luaValue0.p();
        }
        return this.M();
    }

    private int M(LuaValue luaValue0) {
        return luaValue0.hashCode() & this.c.length - 1;
    }

    @Override  // luaj.LuaValue
    public int M() {
        int v2;
        int v = this.P();
        int v1 = 0;
        if(v != 0 && this.d(v).F()) {
            v2 = v;
        }
        else {
            v2 = v + 1;
            v1 = v;
            while(!this.d(v2).F()) {
                v1 = v2;
                v2 += this.o_() + v + 1;
            }
        }
        while(v2 > v1 + 1) {
            int v3 = (v1 + v2) / 2;
            if(this.d(v3).F()) {
                v2 = v3;
            }
            else {
                v1 = v3;
            }
        }
        return v1;
    }

    private void N(LuaValue luaValue0) {
        if(this.c.length > 0) {
            int v = this.M(luaValue0);
            for(ad ad0 = this.c[v]; ad0 != null; ad0 = ad0.u_()) {
                ae ae0 = ad0.a(luaValue0);
                if(ae0 != null) {
                    ad[] arr_ad = this.c;
                    arr_ad[v] = this.c[v].a(ae0);
                    --this.o;
                    return;
                }
            }
        }
    }

    @Override  // luaj.LuaValue
    public boolean N() {
        return true;
    }

    @Override  // luaj.LuaValue
    public LuaTable O() {
        return this;
    }

    public int P() {
        return this.b.length;
    }

    public z S() {
        return new z(this);
    }

    public LuaValue[] T() {
        ArrayList arrayList0 = new ArrayList();
        z z0 = this.S();
        while(z0.a()) {
            arrayList0.add(z0.c());
        }
        LuaValue[] arr_luaValue = new LuaValue[arrayList0.size()];
        arrayList0.toArray(arr_luaValue);
        return arr_luaValue;
    }

    @Override  // luaj.ah
    public boolean U() {
        return false;
    }

    @Override  // luaj.ah
    public boolean V() {
        return false;
    }

    @Override  // luaj.ah
    public LuaValue W() {
        return this;
    }

    public int X() {
        return this.o;
    }

    public static int a(LuaValue luaValue0, int v) {
        return luaValue0.hashCode() & v;
    }

    private int a(int[] arr_v) {
        int v = 1;
        int v1 = 0;
        for(int v2 = 0; v2 < 0x1F && v <= this.b.length; ++v2) {
            int v3 = Math.min(this.b.length, 1 << v2);
            int v4 = 0;
            while(v <= v3) {
                if(this.b[v - 1] != null) {
                    ++v4;
                }
                ++v;
            }
            arr_v[v2] = v4;
            v1 += v4;
        }
        int v5 = 0;
        while(v5 < this.c.length) {
            ad ad0 = this.c[v5];
            int v6 = v1;
            while(ad0 != null) {
                int v7 = ad0.b(0x7FFFFFFF);
                if(v7 > 0) {
                    int v8 = LuaTable.e(v7);
                    ++arr_v[v8];
                    ++v6;
                }
                ad0 = ad0.u_();
            }
            ++v5;
            v1 = v6;
        }
        return v1;
    }

    private Appendable a(String s, Appendable appendable0, Map map0) {
        List list1;
        String s4;
        String s2;
        int v5;
        Set set0 = LuaTable.e;
        if(set0 != null) {
            set0.add(this);
        }
        appendable0.append("{ -- ");
        appendable0.append(this.aa());
        appendable0.append("(");
        appendable0.append(Integer.toHexString(this.hashCode()));
        appendable0.append(")\n");
        int v = this.L();
        int v1 = LuaTable.f + v;
        LuaTable.f = v1;
        List list0 = null;
        int v2 = v == 0 ? 1 : ((int)Math.max(1.0, Math.min(10.0, Math.log10(Math.abs(v)) + 1.0)));
        String s1 = null;
        z z0 = this.S();
        boolean z1 = s.length() > 0;
        boolean z2 = s.length() == 1;
        int v3 = 1;
        int v4 = 1;
        while(z0.a()) {
            LuaValue luaValue0 = z0.c();
            if(!z2 || map0 == null || map0.get(luaValue0) != null) {
                if(v1 >= 10000 || v3 == 0) {
                    v5 = v3;
                }
                else {
                    if(luaValue0.q_()) {
                        if(luaValue0.p() == v4) {
                            v5 = v3;
                            ++v4;
                            goto label_33;
                        }
                        else {
                            ++v4;
                        }
                    }
                    v5 = 0;
                }
            label_33:
                if(luaValue0.Q()) {
                    v3 = v5;
                }
                else {
                    LuaValue luaValue1 = z0.d();
                    if(luaValue1.Q()) {
                        v3 = v5;
                    }
                    else {
                        Appendable appendable1 = v5 == 0 ? new StringBuilder() : appendable0;
                        if(z1) {
                            appendable1.append(s);
                        }
                        appendable1.append("\t[");
                        if(luaValue0.q_()) {
                            ts.a(appendable1, v2, ' ', Integer.toString(luaValue0.p()));
                            s2 = null;
                        }
                        else if(set0 != null && luaValue0 instanceof LuaTable) {
                            if(set0.contains(((LuaTable)luaValue0))) {
                                appendable1.append("{ -- table(");
                                appendable1.append(Integer.toHexString(((LuaTable)luaValue0).hashCode()));
                                appendable1.append(")\n");
                                if(z1) {
                                    appendable1.append(s);
                                }
                                appendable1.append("\t\t-- *** RECURSION ***\n");
                                if(z1) {
                                    appendable1.append(s);
                                }
                                appendable1.append("\t}");
                            }
                            else {
                                if(s1 == null) {
                                    s1 = String.valueOf(s) + '\t';
                                }
                                ((LuaTable)luaValue0).a(s1, appendable1, map0);
                            }
                            s2 = null;
                        }
                        else if(luaValue0 instanceof LuaString) {
                            appendable1.append('\'');
                            s2 = luaValue0.d_();
                            if(s2.indexOf(39) >= 0) {
                                s2 = s2.replace("\'", "\\\'");
                            }
                            appendable1.append(s2);
                            appendable1.append('\'');
                        }
                        else {
                            appendable1.append(luaValue0.d_());
                            s2 = null;
                        }
                        appendable1.append("] = ");
                        CharSequence charSequence0 = null;
                        if(set0 != null && luaValue1 instanceof LuaTable) {
                            if(set0.contains(((LuaTable)luaValue1))) {
                                appendable1.append("{ -- table(");
                                appendable1.append(Integer.toHexString(((LuaTable)luaValue1).hashCode()));
                                appendable1.append(")\n");
                                if(z1) {
                                    appendable1.append(s);
                                }
                                appendable1.append("\t\t-- *** RECURSION ***\n");
                                if(z1) {
                                    appendable1.append(s);
                                }
                                appendable1.append("\t}");
                            }
                            else {
                                if(s1 == null) {
                                    s1 = String.valueOf(s) + '\t';
                                }
                                ((LuaTable)luaValue1).a(s1, appendable1, map0);
                            }
                            appendable1.append(',');
                        }
                        else if(luaValue1 instanceof LuaString) {
                            appendable1.append('\'');
                            String s3 = luaValue1.d_();
                            if(s3.indexOf(39) >= 0) {
                                s3 = s3.replace("\'", "\\\'");
                            }
                            appendable1.append(s3);
                            appendable1.append("\',");
                        }
                        else if(luaValue1 instanceof LuaLong) {
                            boolean z3 = s2 != null && luaValue0 instanceof LuaString;
                            if(!z3 || !s2.equals("address")) {
                                appendable1.append(luaValue1.d_());
                                if(z3) {
                                    if(s2.equals("flags")) {
                                        switch(luaValue1.p()) {
                                            case 1: {
                                                charSequence0 = "gg.TYPE_BYTE";
                                                break;
                                            }
                                            case 2: {
                                                charSequence0 = "gg.TYPE_WORD";
                                                break;
                                            }
                                            case 4: {
                                                charSequence0 = "gg.TYPE_DWORD";
                                                break;
                                            }
                                            case 8: {
                                                charSequence0 = "gg.TYPE_XOR";
                                                break;
                                            }
                                            case 16: {
                                                charSequence0 = "gg.TYPE_FLOAT";
                                                break;
                                            }
                                            case 0x20: {
                                                charSequence0 = "gg.TYPE_QWORD";
                                                break;
                                            }
                                            case 0x40: {
                                                charSequence0 = "gg.TYPE_DOUBLE";
                                            }
                                        }
                                    }
                                    else if(s2.equals("freezeType")) {
                                        switch(luaValue1.p()) {
                                            case 0: {
                                                charSequence0 = "gg.FREEZE_NORMAL";
                                                break;
                                            }
                                            case 1: {
                                                charSequence0 = "gg.FREEZE_MAY_INCREASE";
                                                break;
                                            }
                                            case 2: {
                                                charSequence0 = "gg.FREEZE_MAY_DECREASE";
                                                break;
                                            }
                                            case 3: {
                                                charSequence0 = "gg.FREEZE_IN_RANGE";
                                            }
                                        }
                                    }
                                }
                            }
                            else {
                                appendable1.append("0x");
                                appendable1.append(Long.toHexString(luaValue1.q()));
                            }
                            appendable1.append(',');
                        }
                        else {
                            appendable1.append(luaValue1.d_());
                            if(!(luaValue1 instanceof Script.ApiFunction)) {
                                appendable1.append(',');
                            }
                        }
                        s4 = s1;
                        if(charSequence0 != null) {
                            appendable1.append(" -- ");
                            appendable1.append(charSequence0);
                        }
                        appendable1.append('\n');
                        if(v5 == 0) {
                            if(list0 == null) {
                                int v6 = v - (v4 - 1);
                                list1 = v6 < 0 ? new ArrayList() : new ArrayList(v6);
                            }
                            else {
                                list1 = list0;
                            }
                            list1.add(appendable1.toString());
                            v3 = 0;
                            s1 = s4;
                            list0 = list1;
                        }
                        else {
                            v3 = v5;
                            s1 = s4;
                        }
                    }
                }
            }
        }
        if(list0 != null) {
            try {
                Collections.sort(list0);
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
            for(Object object0: list0) {
                appendable0.append(((String)object0));
            }
        }
        if(z1) {
            appendable0.append(s);
        }
        appendable0.append('}');
        return appendable0;
    }

    private void a(int v, int v1, LuaValue luaValue0) {
        while(v * 2 <= v1) {
            int v2 = v * 2;
            v2 = v2 >= v1 || !this.b(v2, v2 + 1, luaValue0) ? v * 2 : v2 + 1;
            if(!this.b(v, v2, luaValue0)) {
                break;
            }
            LuaValue luaValue1 = this.c_(v);
            this.a(v, this.c_(v2));
            this.a(v2, luaValue1);
            v = v2;
        }
    }

    public String a(Appendable appendable0, Map map0) [...] // 潜在的解密器

    @Override  // luaj.LuaValue
    public LuaTable a(LuaTable luaTable0) {
        return this;
    }

    public LuaValue a(LuaString luaString0, int v, int v1) {
        a a0 = new a();
        if(v <= v1) {
            a0.a(this.c_(v).z());
            while(v < 0x7FFFFFFF) {
                ++v;
                if(v > v1) {
                    break;
                }
                a0.a(luaString0);
                a0.a(this.c_(v).z());
            }
        }
        return a0.b();
    }

    @Override  // luaj.ah
    public LuaValue a(LuaValue[] arr_luaValue, int v) {
        return arr_luaValue[v];
    }

    public ap a(long v, long v1) {
        if(v1 < v) {
            return LuaTable.x;
        }
        long v2 = v1 - v;
        if(v2 < 0L) {
            throw new o("too many results to unpack: greater 9223372036854775807");
        }
        if(v2 >= 0xFFFFFFL) {
            throw new o("too many results to unpack: " + v2 + " (max is " + 0xFFFFFFL + ')');
        }
        int v3 = (int)(v2 + 1L);
        boolean z = ((long)(((int)v))) == v && ((long)(((int)v1))) == v1;
        if(v3 <= 0) {
            return LuaTable.x;
        }
        if(v3 == 1) {
            return z ? this.c_(((int)v)) : this.w(LuaLong.b(v));
        }
        if(v3 == 2) {
            return z ? LuaTable.b(this.c_(((int)v)), this.c_(((int)(v + 1L)))) : LuaTable.b(this.w(LuaLong.b(v)), this.w(LuaLong.b(v + 1L)));
        }
        try {
            LuaValue[] arr_luaValue = new LuaValue[v3];
            while(true) {
                --v3;
                if(v3 < 0) {
                    return LuaTable.c(arr_luaValue);
                }
                arr_luaValue[v3] = z ? this.c_(((int)(((long)v3) + v))) : this.w(LuaLong.b(((long)v3) + v));
            }
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            la.c(("OOM on unpack: " + v3), outOfMemoryError0);
            throw new o("too many results to unpack [out of memory]: " + v3);
        }
    }

    public void a(int v, int v1) {
        if(v1 > 0 && v1 < 2) {
            v1 = 2;
        }
        this.b = v <= 0 ? LuaTable.B : new LuaValue[1 << LuaTable.e(v)];
        this.c = v1 <= 0 ? LuaTable.d : new ad[1 << LuaTable.e(v1)];
        this.o = 0;
    }

    public void a(int v, LuaString luaString0, double f) {
        ad[] arr_ad = this.c;
        ad ad0 = ((double)(((float)f))) == f ? new w(luaString0, ((float)f)) : new u(luaString0, f);
        if(arr_ad[v] != null) {
            ad0 = arr_ad[v].a(ad0);
        }
        arr_ad[v] = ad0;
        ++this.o;
    }

    public void a(int v, LuaString luaString0, float f) {
        ad[] arr_ad = this.c;
        ad ad0 = new w(luaString0, f);
        if(arr_ad[v] != null) {
            ad0 = arr_ad[v].a(ad0);
        }
        arr_ad[v] = ad0;
        ++this.o;
    }

    public void a(int v, LuaString luaString0, int v1) {
        ad[] arr_ad = this.c;
        ad ad0 = new y(luaString0, v1);
        if(arr_ad[v] != null) {
            ad0 = arr_ad[v].a(ad0);
        }
        arr_ad[v] = ad0;
        ++this.o;
    }

    public void a(int v, LuaString luaString0, long v1) {
        ad[] arr_ad = this.c;
        ad ad0 = ((long)(((int)v1))) == v1 ? new y(luaString0, ((int)v1)) : new ab(luaString0, v1);
        if(arr_ad[v] != null) {
            ad0 = arr_ad[v].a(ad0);
        }
        arr_ad[v] = ad0;
        ++this.o;
    }

    public void a(int v, LuaString luaString0, boolean z) {
        ad[] arr_ad = this.c;
        ad ad0 = new s(luaString0, z);
        if(arr_ad[v] != null) {
            ad0 = arr_ad[v].a(ad0);
        }
        arr_ad[v] = ad0;
        ++this.o;
    }

    @Override  // luaj.LuaValue
    public void a(int v, LuaValue luaValue0) {
        if(this.p == null || !this.d(v).F() || !LuaTable.d(this, LuaLong.b(v), luaValue0)) {
            this.b(v, luaValue0);
        }
    }

    private int af() {
        int v = 0;
        int v1;
        for(v1 = 0; v < this.c.length; v1 = v2) {
            ad ad0 = this.c[v];
            int v2 = v1;
            while(ad0 != null) {
                if(ad0.a() != null) {
                    ++v2;
                }
                ad0 = ad0.u_();
            }
            ++v;
        }
        return v1;
    }

    private void ag() {
        for(int v = 0; v < this.b.length; ++v) {
            this.p.a(this.b, v);
        }
    }

    private boolean b(int v, int v1, LuaValue luaValue0) {
        LuaValue luaValue1 = this.c_(v);
        LuaValue luaValue2 = this.c_(v1);
        if(luaValue1 == null || luaValue2 == null) {
            return false;
        }
        return luaValue0 == null ? luaValue1.p(luaValue2) : luaValue0.a(luaValue1, luaValue2).i_();
    }

    private static LuaValue[] b(LuaValue[] arr_luaValue, int v) {
        LuaValue[] arr_luaValue1 = new LuaValue[v];
        System.arraycopy(arr_luaValue, 0, arr_luaValue1, 0, arr_luaValue.length);
        return arr_luaValue1;
    }

    public LuaValue b(int v, int v1) {
        if(v != 0) {
            if(v > v1) {
                return LuaTable.x;
            }
            v1 = v;
        }
        LuaValue luaValue0 = this.c_(v1);
        LuaValue luaValue1 = luaValue0;
        while(!luaValue1.F()) {
            luaValue1 = this.c_(v1 + 1);
            this.a(v1, luaValue1);
            ++v1;
        }
        return luaValue0.F() ? LuaTable.x : luaValue0;
    }

    @Override  // luaj.LuaValue
    public void b(int v, LuaValue luaValue0) {
        if(luaValue0 != null && !this.e(v, luaValue0)) {
            this.d(LuaLong.b(v), luaValue0);
        }
    }

    @Override  // luaj.LuaValue
    public void b(LuaValue luaValue0, LuaValue luaValue1) {
        if(luaValue0 == null || !luaValue0.A() && !this.I(LuaTable.E).B()) {
            throw new o("value (\'" + luaValue0 + "\') can not be used as a table index");
        }
        if(this.p == null || !this.x(luaValue0).F() || !LuaTable.d(this, luaValue0, luaValue1)) {
            this.c(luaValue0, luaValue1);
        }
    }

    @Override  // luaj.LuaValue
    public boolean b(LuaValue luaValue0) {
        if(this == luaValue0) {
            return true;
        }
        return luaValue0.N() ? LuaTable.g(this, luaValue0) : false;
    }

    public static int c(int v, int v1) [...] // Inlined contents

    public void c(int v, LuaValue luaValue0) {
        while(!luaValue0.F()) {
            LuaValue luaValue1 = this.c_(v);
            this.a(v, luaValue0);
            luaValue0 = luaValue1;
            ++v;
        }
    }

    @Override  // luaj.LuaValue
    public void c(LuaValue luaValue0, LuaValue luaValue1) {
        if(luaValue0 != null && luaValue1 != null && (!luaValue0.q_() || !this.e(luaValue0.p(), luaValue1))) {
            this.d(luaValue0, luaValue1);
        }
    }

    @Override  // luaj.LuaValue
    public LuaValue c_(int v) {
        LuaValue luaValue0 = this.d(v);
        return !luaValue0.F() || this.p == null ? luaValue0 : LuaTable.i(this, LuaTable.d(v));
    }

    @Override  // luaj.LuaValue
    public LuaValue d(int v) {
        LuaValue luaValue0;
        if(v > 0 && v <= this.b.length) {
            if(this.p == null) {
                luaValue0 = this.b[v - 1];
                return luaValue0 == null ? LuaTable.u : luaValue0;
            }
            luaValue0 = this.p.a(this.b, v - 1);
            return luaValue0 == null ? LuaTable.u : luaValue0;
        }
        return this.y(LuaLong.b(v));
    }

    public void d(LuaValue luaValue0, LuaValue luaValue1) {
        int v = 0;
        if(luaValue1.F()) {
            this.N(luaValue0);
            return;
        }
        if(this.c.length > 0) {
            v = this.M(luaValue0);
            for(ad ad0 = this.c[v]; ad0 != null; ad0 = ad0.u_()) {
                ae ae0 = ad0.a(luaValue0);
                if(ae0 != null) {
                    ad[] arr_ad = this.c;
                    arr_ad[v] = this.c[v].a(ae0, luaValue1);
                    return;
                }
            }
        }
        if(this.o >= this.c.length) {
            if(this.p != null && this.p.V() || !luaValue0.q_() || luaValue0.p() <= 0) {
                this.z(-1);
            }
            else {
                this.z(luaValue0.p());
                if(this.e(luaValue0.p(), luaValue1)) {
                    return;
                }
            }
            v = this.M(luaValue0);
        }
        ad ad1 = this.p == null ? LuaTable.f(luaValue0, luaValue1) : this.p.e(luaValue0, luaValue1);
        ad[] arr_ad1 = this.c;
        if(this.c[v] != null) {
            ad1 = this.c[v].a(ad1);
        }
        arr_ad1[v] = ad1;
        ++this.o;
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public String d_() {
        return "{ -- table(7343b248)\n}";
    }

    @Override  // luaj.LuaValue
    public void d_(int v) {
        if(v > this.b.length) {
            this.b = LuaTable.b(this.b, 1 << LuaTable.e(v));
        }
    }

    static int e(int v) {
        int v2;
        int v1 = v - 1;
        if(v1 < 0) {
            return 0x80000000;
        }
        if((0xFFFF0000 & v1) == 0) {
            v2 = 0;
        }
        else {
            v2 = 16;
            v1 >>>= 16;
        }
        if((0xFF00 & v1) != 0) {
            v2 += 8;
            v1 >>>= 8;
        }
        if((v1 & 0xF0) != 0) {
            v2 += 4;
            v1 >>>= 4;
        }
        switch(v1) {
            case 0: {
                return 0;
            }
            case 1: {
                return v2 + 1;
            }
            case 2: 
            case 3: {
                return v2 + 2;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                return v2 + 3;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return v2 + 4;
            }
            default: {
                return v2;
            }
        }
    }

    private boolean e(int v, LuaValue luaValue0) {
        if(v > 0 && v <= this.b.length) {
            LuaValue[] arr_luaValue = this.b;
            if(luaValue0.F()) {
                luaValue0 = null;
            }
            else if(this.p != null) {
                luaValue0 = this.p.E(luaValue0);
            }
            arr_luaValue[v - 1] = luaValue0;
            return true;
        }
        return false;
    }

    @Override  // luaj.ah
    public ad e(LuaValue luaValue0, LuaValue luaValue1) {
        return LuaTable.f(luaValue0, luaValue1);
    }

    @Override  // luaj.LuaValue
    public int e_() {
        return 5;
    }

    protected static v f(LuaValue luaValue0, LuaValue luaValue1) {
        if(luaValue0.q_()) {
            return new x(luaValue0.p(), luaValue1);
        }
        if(luaValue1 instanceof LuaBoolean) {
            return new s(luaValue0, luaValue1.i_());
        }
        if(luaValue1 instanceof LuaLong) {
            long v = luaValue1.q();
            return ((long)(((int)v))) == v ? new y(luaValue0, ((int)v)) : new ab(luaValue0, v);
        }
        if(luaValue1 instanceof LuaDouble) {
            double f = luaValue1.o();
            return ((double)(((float)f))) == f ? new w(luaValue0, ((float)f)) : new u(luaValue0, f);
        }
        return new ac(luaValue0, luaValue1);
    }

    private void f(int v, LuaValue luaValue0) {
        this.g(v, luaValue0);
        while(v > 1) {
            LuaValue luaValue1 = this.c_(v);
            this.a(v, this.c_(1));
            this.a(1, luaValue1);
            --v;
            this.a(1, v, luaValue0);
        }
    }

    @Override  // luaj.LuaValue
    public String f_() {
        return "table";
    }

    private void g(int v, LuaValue luaValue0) {
        for(int v1 = v / 2; v1 > 0; --v1) {
            this.a(v1, v, luaValue0);
        }
    }

    @Override  // luaj.LuaValue
    public LuaValue i() {
        return this.p == null ? null : this.p.W();
    }

    public int o_() {
        return this.c.length;
    }

    @Override  // luaj.LuaValue
    public LuaValue v(LuaValue luaValue0) {
        int v = 1;
        int v1 = this.p == null || !this.p.U() ? 0 : 1;
        int v2 = this.p == null || !this.p.V() ? 0 : 1;
        this.p = LuaTable.J(luaValue0);
        if(v1 == (this.p == null || !this.p.U() ? 0 : 1)) {
            if(this.p == null || !this.p.V()) {
                v = 0;
            }
            if(v2 != v) {
                this.z(0);
                return this;
            }
        }
        else {
            this.z(0);
        }
        return this;
    }

    @Override  // luaj.LuaValue
    public LuaValue w(LuaValue luaValue0) {
        LuaValue luaValue1 = this.x(luaValue0);
        return !luaValue1.F() || this.p == null ? luaValue1 : LuaTable.i(this, luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue x(LuaValue luaValue0) {
        LuaValue luaValue1;
        if(luaValue0.q_()) {
            int v = luaValue0.p();
            if(v > 0 && v <= this.b.length) {
                if(this.p == null) {
                    luaValue1 = this.b[v - 1];
                    return luaValue1 == null ? LuaTable.u : luaValue1;
                }
                luaValue1 = this.p.a(this.b, v - 1);
                return luaValue1 == null ? LuaTable.u : luaValue1;
            }
        }
        return this.y(luaValue0);
    }

    protected LuaValue y(LuaValue luaValue0) {
        ae ae0 = this.L(luaValue0);
        return ae0 == null ? LuaTable.u : ae0.t_();
    }

    private void z(int v) {
        ad ad2;
        int v13;
        ad[] arr_ad1;
        LuaValue[] arr_luaValue1;
        if(this.p != null && (this.p.U() || this.p.V())) {
            this.o = this.af();
            if(this.p.V()) {
                this.ag();
            }
        }
        int[] arr_v = new int[0x20];
        int v1 = this.a(arr_v);
        if(v > 0) {
            ++v1;
            int v2 = LuaTable.e(v);
            ++arr_v[v2];
        }
        int v3 = arr_v[0];
        int v4 = 0;
        for(int v5 = 1; v5 < 0x20; ++v5) {
            v3 += arr_v[v5];
            if(v1 * 2 < 1 << v5) {
                break;
            }
            if(v3 >= 1 << v5 - 1) {
                v4 = 1 << v5;
            }
        }
        LuaValue[] arr_luaValue = this.b;
        ad[] arr_ad = this.c;
        int v6 = v <= 0 || v > v4 ? 0 : -1;
        if(v4 == arr_luaValue.length) {
            arr_luaValue1 = this.b;
        }
        else {
            arr_luaValue1 = new LuaValue[v4];
            if(v4 > arr_luaValue.length) {
                int v7 = LuaTable.e(arr_luaValue.length + 1);
                int v8 = LuaTable.e(v4);
                while(v7 < v8 + 1) {
                    v6 += arr_v[v7];
                    ++v7;
                }
            }
            else if(arr_luaValue.length > v4) {
                int v9 = LuaTable.e(v4 + 1);
                int v10 = LuaTable.e(arr_luaValue.length);
                while(v9 < v10 + 1) {
                    v6 -= arr_v[v9];
                    ++v9;
                }
            }
            System.arraycopy(arr_luaValue, 0, arr_luaValue1, 0, Math.min(arr_luaValue.length, v4));
        }
        int v11 = (v >= 0 && v <= v4 ? 0 : 1) + (this.o - v6);
        if(v11 > 0) {
            int v12 = v11 >= 2 ? 1 << LuaTable.e(v11) : 2;
            arr_ad1 = new ad[v12];
            v13 = v12 - 1;
        }
        else {
            v13 = 0;
            arr_ad1 = LuaTable.d;
        }
        for(int v14 = 0; v14 < arr_ad.length; ++v14) {
            for(ad ad0 = arr_ad[v14]; ad0 != null; ad0 = ad0.u_()) {
                int v15 = ad0.b(v4);
                if(v15 > 0) {
                    ae ae0 = ad0.a();
                    if(ae0 != null) {
                        arr_luaValue1[v15 - 1] = ae0.t_();
                    }
                }
                else if(!(ad0 instanceof t)) {
                    int v16 = ad0.a(v13);
                    arr_ad1[v16] = ad0.b(arr_ad1[v16]);
                }
            }
        }
        while(v4 < arr_luaValue.length) {
            LuaValue luaValue0 = arr_luaValue[v4];
            if(luaValue0 != null) {
                int v17 = ((int)(((long)(v4 + 1)) >>> 0x20 ^ ((long)(v4 + 1)))) & v13;
                if(this.p == null) {
                label_79:
                    ad2 = LuaTable.f(LuaTable.d(v4 + 1), luaValue0);
                }
                else {
                    ad ad1 = this.p.e(LuaTable.d(v4 + 1), luaValue0);
                    if(ad1 == null) {
                        ++v4;
                        continue;
                    }
                    else {
                        ad2 = ad1;
                        goto label_80;
                    }
                    goto label_79;
                }
            label_80:
                if(arr_ad1[v17] != null) {
                    ad2 = arr_ad1[v17].a(ad2);
                }
                arr_ad1[v17] = ad2;
            }
            ++v4;
        }
        this.c = arr_ad1;
        this.b = arr_luaValue1;
        this.o -= v6;
    }

    public long z(LuaValue luaValue0) {
        ae ae0 = this.L(luaValue0);
        if(ae0 == null) {
            return this.p == null ? LuaTable.u.w() : LuaTable.i(this, luaValue0).w();
        }
        if(ae0 instanceof y) {
            return (long)((y)ae0).h();
        }
        return ae0 instanceof ab ? ((ab)ae0).h() : ae0.t_().w();
    }
}

