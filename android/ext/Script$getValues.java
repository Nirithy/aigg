package android.ext;

import java.util.ArrayList;
import java.util.Arrays;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.z;

final class Script.getValues extends Script.BusyApiFunction {
    final ArrayList e;
    long[] f;
    int[] g;
    int h;
    final Script i;

    Script.getValues(Script script0) {
        this.i = script0;
        super(script0);
        this.e = new ArrayList();
        this.f = null;
        this.g = null;
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getValues(table values) -> table || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        long[] arr_v2;
        LuaTable luaTable0 = ap0.t(1);
        ArrayList arrayList0 = this.e;
        this.g = null;
        this.f = null;
        long[] arr_v = new long[luaTable0.P() + luaTable0.X()];
        arrayList0.clear();
        arrayList0.ensureCapacity(arr_v.length);
        qh qh0 = MainService.instance.ap;
        boolean z = qh0 == null ? false : qh0.n;
        d d0 = new d(0L, 0L, 4);
        z z1 = luaTable0.S();
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        int[] arr_v1 = new int[arr_v.length];
        while(z1.a()) {
            if(z1.b() != 0) {
                ++v1;
            }
            LuaValue luaValue0 = z1.c();
            Script.a(d0, z1.d().O(), 2, z);
            if(v2 == arr_v.length) {
                int v3 = v2 >> 1 >= 10 ? v2 >> 1 : 10;
                ho.a(Thread.currentThread(), new RuntimeException("OF " + (v + 1) + "; " + arr_v.length + "; " + luaTable0.P() + " + " + luaTable0.X() + "; " + luaValue0.h_() + ": " + luaValue0 + "; " + luaTable0.i() + "; " + luaTable0), false);
                arr_v2 = Arrays.copyOf(arr_v, v2 + v3);
                arr_v1 = Arrays.copyOf(arr_v1, v3 + v2);
                ++v;
            }
            else {
                arr_v2 = arr_v;
            }
            arr_v2[v2] = d0.b;
            arr_v1[v2] = d0.d & 0x7F;
            arrayList0.add(luaValue0);
            ++v2;
            arr_v = arr_v2;
        }
        this.h = v1;
        if(arr_v1.length != v2) {
            arr_v1 = Arrays.copyOf(arr_v1, v2);
        }
        this.g = arr_v1;
        if(arr_v.length != v2) {
            arr_v = Arrays.copyOf(arr_v, v2);
        }
        this.f = arr_v;
        if(v2 == 0) {
            this.g = null;
            this.f = null;
            return new LuaTable();
        }
        return super.b(ap0);
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        MainService.instance.k.a(this.i.a(), this.g, this.f);
        this.g = null;
        this.f = null;
        return null;
    }

    @Override  // android.ext.Script$ApiFunction
    protected ap f() {
        ArrayList arrayList0 = this.e;
        ap ap0 = new LuaTable();
        ((LuaTable)ap0).d_(this.h);
        ArrayList arrayList1 = Script.k;
        if(arrayList1 == null) {
            Script.l += 100000;
            ho.a(Thread.currentThread(), new RuntimeException("memList is null " + Script.l), false);
        }
        else {
            ++Script.l;
            Script.k = null;
            int v = 0;
            for(Object object0: arrayList1) {
                ((LuaTable)ap0).c(((LuaValue)arrayList0.get(v)), Script.b(null, ((d)object0)));
                ++v;
            }
        }
        this.g = null;
        this.f = null;
        arrayList0.clear();
        arrayList0.trimToSize();
        return ap0;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

