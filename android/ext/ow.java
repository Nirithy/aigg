package android.ext;

import android.fix.i;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SectionIndexer;
import android.widget.TextView;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Locale;

class ow extends BaseAdapterLC implements ur, Filterable, SectionIndexer {
    String a;
    short[] b;
    volatile int c;
    private Filter d;
    private final byte[] e;
    private volatile long f;
    private ByteBuffer g;
    private long h;
    private int i;
    private boolean[] j;
    private pe k;
    private int l;
    private long m;
    private final h n;
    private final CharSequence[] o;
    private long p;
    private static ai q;
    private static int[] r;
    private int s;
    private int t;
    private static volatile CharSequence[] u;
    private static volatile int[] v;
    private pa w;

    static {
        ow.q = null;
        ow.r = null;
    }

    public ow() {
        this.a = "";
        this.d = null;
        this.b = null;
        this.i = -1;
        this.j = null;
        this.c = 0xFFFFC181;
        this.k = null;
        this.l = 2;
        this.m = 0L;
        this.n = new h();
        this.o = new CharSequence[2];
        this.p = 1L;
        this.s = 0;
        this.t = 0;
        this.w = null;
        this.c = Tools.s().getInt("memory-editor-format", 0xFFFFC181);
        this.l();
        this.e = new byte[8200];
        this.g = ByteBuffer.wrap(this.e);
        this.g.order(ByteOrder.LITTLE_ENDIAN);
        this.h = 0L;
        this.f = 0L;
        MainService.instance.u.setText(this.q());
    }

    private static int a(int v, short[] arr_v) {
        if(arr_v != null) {
            v = Arrays.binarySearch(arr_v, ((short)v));
            if(v < 0) {
                return -v - 2 >= 0 ? -v - 2 : 0;
            }
        }
        return v;
    }

    private static int a(int v, short[] arr_v, int v1) {
        if(arr_v == null || v < 0) {
            return v;
        }
        return v >= arr_v.length ? v - arr_v.length + (0x2000 >> v1) : arr_v[v];
    }

    private int a(long v, long v1, int v2, StringBuilder stringBuilder0, int v3, int v4, int v5, int v6) {
        if((((long)(v6 - 1)) & v) == 0L && (this.c & 1 << v3) != 0) {
            stringBuilder0.append(d.a(v, v1, v4));
            stringBuilder0.append("\n");
            return v2 == 0 ? v5 : v2;
        }
        return v2;
    }

    private static int a(TextView textView0, CharSequence charSequence0, int v, int v1) {
        ow.a(textView0, charSequence0);
        return charSequence0 == null || v >= v1 ? v : v1;
    }

    private int a(boolean z, g g0, long v, long v1, int v2, TextView textView0, int v3, int v4, int v5, int v6) {
        String s1;
        if((((long)(v6 - 1)) & v) == 0L && (this.c & 1 << v3) != 0) {
            if(z) {
                String s = d.a(v, v1, v4);
                h h0 = this.n;
                g0.a(v, v4, h0);
                if(h0.b) {
                    s = s + " (" + d.b(v, h0.a, v4) + ')';
                }
                s1 = String.valueOf(s) + d.g(v4) + ';';
            }
            else {
                s1 = "?";
            }
            ow.a(textView0, s1);
            return v2 == 0 ? v5 : v2;
        }
        ow.a(textView0, null);
        return v2;
    }

    private View a(ViewGroup viewGroup0) {
        View view0 = i.a(0x7F040022, viewGroup0, false);  // layout:service_memory_item
        us us0 = new us(view0, this);
        us0.a = (TextView)view0.findViewById(0x7F0B0123);  // id:value_dword
        us0.b = (TextView)view0.findViewById(0x7F0B0124);  // id:value_float
        us0.p = (TextView)view0.findViewById(0x7F0B0125);  // id:value_double
        us0.q = (TextView)view0.findViewById(0x7F0B0126);  // id:value_word
        us0.r = (TextView)view0.findViewById(0x7F0B0127);  // id:value_byte
        us0.s = (TextView)view0.findViewById(0x7F0B0128);  // id:value_qword
        us0.t = (TextView)view0.findViewById(0x7F0B0129);  // id:value_xor
        return view0;
    }

    static void a(uq uq0, long v, long v1, int v2, boolean z, int v3) {
        CharSequence charSequence4;
        CharSequence charSequence3;
        String s;
        CharSequence charSequence2;
        int[] arr_v;
        CharSequence charSequence1;
        ai ai1;
        CharSequence charSequence0;
        ai ai0;
        TextView textView0 = uq0.j;
        if((1L & v) == 0L && (v2 & 0x20) != 0) {
            if(ow.q == null) {
                ai0 = new ai();
                ow.q = ai0;
            }
            else {
                ai0 = ow.q;
            }
            charSequence0 = ai.b(ai0, v, v1) + ';';
        }
        else {
            charSequence0 = null;
        }
        int v4 = ow.a(textView0, charSequence0, v3, 2);
        TextView textView1 = uq0.i;
        if((3L & v) == 0L && (v2 & 16) != 0) {
            if(ow.q == null) {
                ai1 = new ai();
                ow.q = ai1;
            }
            else {
                ai1 = ow.q;
            }
            charSequence1 = ai.a(ai1, v, v1) + ';';
        }
        else {
            charSequence1 = null;
        }
        int v5 = ow.a(textView1, charSequence1, v4, 4);
        TextView textView2 = uq0.k;
        if((3L & v) == 0L && (v2 & 0x40) != 0) {
            if(ow.r == null) {
                arr_v = ag.a();
                ow.r = arr_v;
            }
            else {
                arr_v = ow.r;
            }
            charSequence2 = ag.a(arr_v, v, ((int)v1), new StringBuilder()).append(';').toString();
        }
        else {
            charSequence2 = null;
        }
        qs qs0 = null;
        int v6 = ow.a(textView2, charSequence2, v5, 4);
        boolean z1 = false;
        if((v2 & 1) == 0) {
            ow.a(uq0.e, null);
        }
        else {
            if(z) {
                if(v6 != 8) {
                    v1 &= (1L << v6 * 8) - 1L;
                }
                s = ts.a(v6 * 2, v1) + "h;";
                qh qh0 = MainService.instance.ap;
                if(v6 == 4 || qh0 != null && qh0.n && v6 == 8) {
                    qs0 = RegionList.b(v1);
                }
            }
            else {
                s = "?";
            }
            ow.a(uq0.e, s);
            int v7 = qs.a(qs0);
            uq0.e.setTextColor(v7);
            if(v6 == 1) {
                z1 = true;
            }
        }
        if(z1 || (v2 & 2) == 0) {
            ow.a(uq0.f, null);
        }
        else {
            String s1 = z ? ts.a(v6 * 2, (v6 == 8 ? Long.reverseBytes(v1) >> 0x40 - v6 * 8 : Long.reverseBytes(v1) >> 0x40 - v6 * 8 & (1L << v6 * 8) - 1L)) + "r;" : "?";
            ow.a(uq0.f, s1);
        }
        TextView textView3 = uq0.g;
        if((v2 & 4) == 0) {
            charSequence3 = null;
        }
        else {
            charSequence3 = z ? "\'" + ow.b(v1, v6) + "\';" : "?";
        }
        ow.a(textView3, charSequence3);
        TextView textView4 = uq0.h;
        if((v2 & 8) == 0) {
            charSequence4 = null;
        }
        else {
            charSequence4 = z ? "\"" + ow.c(v1, v6) + "\";" : "?";
        }
        ow.a(textView4, charSequence4);
    }

    private void a(us us0, int v) {
        boolean z;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = us0.c.getLayoutParams();
        viewGroup$LayoutParams0.height = (Config.q & 1 << Tools.t() + 4) == 0 ? Tools.b() : -2;
        if(v == 0 || v == this.getCount() - 1) {
            us0.c.setVisibility(4);
            us0.d.setVisibility(8);
            us0.e.setVisibility(8);
            us0.f.setVisibility(8);
            us0.g.setVisibility(0);
            us0.h.setVisibility(8);
            us0.i.setVisibility(8);
            us0.j.setVisibility(8);
            us0.k.setVisibility(8);
            us0.a.setVisibility(8);
            us0.b.setVisibility(8);
            us0.p.setVisibility(8);
            us0.q.setVisibility(8);
            us0.r.setVisibility(8);
            us0.s.setVisibility(8);
            us0.t.setVisibility(8);
            us0.l.setVisibility(8);
            us0.a(false, -2);
            long[] arr_v = this.a(v != 0);
            us0.g.setText(qk.a(0x7F070100) + ' ' + d.b(arr_v[0], 0x20));  // string:goto_address "Go to the address:"
            return;
        }
        us0.c.setVisibility(0);
        us0.d.setVisibility(0);
        us0.l.setVisibility(0);
        us0.o = v;
        long v1 = this.a(v);
        us0.l.setText(this.e(v1));
        us0.d.setText(d.b(v1, 0x20));
        try {
            z = this.j[v];
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            la.c("ArrayAdapter getView failed", indexOutOfBoundsException0);
            z = false;
        }
        us0.c.setChecked(z);
        us0.a(z, this.i);
        long v2 = this.g.getLong(((int)(0x1FFFL & v1)));
        boolean z1 = this.g();
        g g0 = MainService.instance.ao;
        int v3 = this.a(z1, g0, v1, v2, this.a(z1, g0, v1, v2, this.a(z1, g0, v1, v2, this.a(z1, g0, v1, v2, this.a(z1, g0, v1, v2, this.a(z1, g0, v1, v2, this.a(z1, g0, v1, v2, 0, us0.p, 9, 0x40, 8, 4), us0.s, 12, 0x20, 8, 4), us0.b, 8, 16, 4, 4), us0.a, 7, 4, 4, 4), us0.t, 13, 8, 4, 4), us0.q, 10, 2, 2, 2), us0.r, 11, 1, 1, 1);
        if(v3 == 0) {
            v3 = 1 << this.m();
        }
        ow.a(us0, v1, v2, this.c, z1, v3);
    }

    private static void a(TextView textView0, CharSequence charSequence0) {
        if(charSequence0 == null) {
            textView0.setVisibility(8);
            return;
        }
        textView0.setVisibility(0);
        textView0.setText(charSequence0);
    }

    private long[] a(boolean z) {
        long v = this.n();
        if(!z) {
            return v == 0L ? new long[]{0L, 0L} : new long[]{v - 1L, v};
        }
        return v + 0x2000L == 0L ? new long[]{-1L, 0L} : new long[]{v + 0x2000L, v + 0x2000L};
    }

    public int a(boolean[] arr_z, SparseIntArray sparseIntArray0) {
        int v = arr_z.length - 1;
        int v2 = 0;
        for(int v1 = 1; v1 < v; ++v1) {
            if(arr_z[v1]) {
                v2 |= d.a(this.a(v1), false, sparseIntArray0);
            }
        }
        if((Config.B & 0x400) != 0) {
            int v3 = this.p();
            return Integer.bitCount(v3) != 1 || (v2 & v3) == 0 ? v2 : v2 & v3;
        }
        return v2;
    }

    public long a(int v) {
        return this.a(((long)this.d(v - 1)));
    }

    public long a(long v) {
        return (v << this.m()) + this.n();
    }

    String a(ai ai0, int[] arr_v, int v) {
        if(!this.g()) {
            return "";
        }
        long v1 = this.a(((long)v));
        long v2 = this.g.getLong(((int)(0x1FFFL & v1)));
        StringBuilder stringBuilder0 = new StringBuilder();
        int v3 = this.a(v1, v2, this.a(v1, v2, this.a(v1, v2, this.a(v1, v2, this.a(v1, v2, this.a(v1, v2, this.a(v1, v2, 0, stringBuilder0, 9, 0x40, 8, 4), stringBuilder0, 12, 0x20, 8, 4), stringBuilder0, 8, 16, 4, 4), stringBuilder0, 7, 4, 4, 4), stringBuilder0, 13, 8, 4, 4), stringBuilder0, 10, 2, 2, 2), stringBuilder0, 11, 1, 1, 1);
        if(v3 == 0) {
            v3 = 1 << this.m();
        }
        boolean z = false;
        if((this.c & 1) != 0) {
            if(v3 != 8) {
                v2 &= (1L << v3 * 8) - 1L;
            }
            stringBuilder0.append(ts.a(v3 * 2, v2));
            stringBuilder0.append("\n");
            if(v3 == 1) {
                z = true;
            }
        }
        if(!z && (this.c & 2) != 0) {
            stringBuilder0.append(ts.a(v3 * 2, (v3 == 8 ? Long.reverseBytes(v2) >> 0x40 - v3 * 8 : Long.reverseBytes(v2) >> 0x40 - v3 * 8 & (1L << v3 * 8) - 1L)));
            stringBuilder0.append("\n");
        }
        if((this.c & 4) != 0) {
            stringBuilder0.append(ow.b(v2, v3));
            stringBuilder0.append("\n");
        }
        if((this.c & 8) != 0) {
            stringBuilder0.append(ow.c(v2, v3));
            stringBuilder0.append("\n");
        }
        if((this.c & 16) != 0) {
            stringBuilder0.append(ai.a(ai0, v1, v2));
            stringBuilder0.append("\n");
        }
        if((this.c & 0x20) != 0) {
            stringBuilder0.append(ai.b(ai0, v1, v2));
            stringBuilder0.append("\n");
        }
        if((this.c & 0x40) != 0) {
            ag.a(arr_v, v1, ((int)v2), stringBuilder0);
            stringBuilder0.append("\n");
        }
        return stringBuilder0.toString();
    }

    public void a(long v, int v1) {
        if((0xFFFFFFFFFFFFE000L & v) != this.h) {
            this.h = 0xFFFFFFFFFFFFE000L & v;
            Arrays.fill(this.j, false);
            this.notifyDataSetChanged();
        }
        Tools.a(MainService.instance.J, this.d(v), v1);
    }

    public void a(bk bk0) {
        long v;
        try {
            v = this.n();
            bk0.g();
            long v1 = bk0.c();
            int v2 = bk0.b();
            if(v1 != v) {
                throw new RuntimeException("Offset mismatch: " + v1 + " (" + Long.toHexString(v1).toUpperCase(Locale.US) + ") != " + v + " (" + Long.toHexString(v).toUpperCase(Locale.US) + ")");
            }
            if(v2 < 0x2000) {
                throw new RuntimeException("Size mismatch: " + v2 + " (" + Integer.toHexString(v2).toUpperCase(Locale.US) + ") != " + 0x2000 + " (" + "2000" + ")");
            }
            bk0.a(this.e, 0, v2);
        }
        catch(RuntimeException | IOException runtimeException0) {
            la.b("Failed load data to memory editor", runtimeException0);
            Arrays.fill(this.e, 0);
        }
        this.f = v;
        MainService.instance.J.post(new ox(this));
    }

    public boolean[] a() {
        return this.j;
    }

    public static String b(long v, int v1) {
        byte[] arr_b = {((byte)(((int)(0xFFL & v)))), ((byte)(((int)((0xFF00L & v) >> 8)))), ((byte)(((int)((0xFF0000L & v) >> 16)))), ((byte)(((int)((0xFF000000L & v) >> 24)))), ((byte)(((int)((0xFF00000000L & v) >> 0x20)))), ((byte)(((int)((0xFF0000000000L & v) >> 40)))), ((byte)(((int)((0xFF000000000000L & v) >> 0x30)))), ((byte)(((int)((0xFF00000000000000L & v) >> 56))))};
        for(int v2 = 0; v2 < 8; ++v2) {
            if(arr_b[v2] < 0x20) {
                arr_b[v2] = 46;
            }
        }
        return new String(arr_b).substring(0, v1);
    }

    public int b(long v) {
        return this.e(((int)(v - this.n() >> this.m()))) + 1;
    }

    void b() {
        this.l();
        super.notifyDataSetChanged();
    }

    void b(int v) {
        if(v == this.c) {
            return;
        }
        int v1 = this.m();
        tp tp0 = Tools.a(MainService.instance.J);
        long v2 = this.a(tp0.a);
        long v3 = this.i >= 0 ? this.a(this.i) : -1L;
        this.c = v;
        new qw().a("memory-editor-format", this.c, 0xFFFFC181).commit();
        this.notifyDataSetChanged();
        if(v1 != this.m()) {
            tp0.a = this.b(v2);
            Tools.a(MainService.instance.J, tp0);
            if(this.i >= 0) {
                this.i = this.b(v3);
            }
        }
        MainService.instance.u.setText(this.q());
    }

    private int c(long v) [...] // Inlined contents

    static CharSequence c(int v) {
        int v3;
        CharSequence[] arr_charSequence = ow.r();
        CharSequence[] arr_charSequence1 = new CharSequence[arr_charSequence.length * 2];
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < arr_charSequence.length; v2 = v3) {
            if((1 << v1 & v) == 0) {
                v3 = v2;
            }
            else {
                if(v2 > 0) {
                    arr_charSequence1[v2] = ",";
                    ++v2;
                }
                v3 = v2 + 1;
                arr_charSequence1[v2] = arr_charSequence[v1];
            }
            ++v1;
        }
        return Tools.a(((CharSequence[])Arrays.copyOf(arr_charSequence1, v2)));
    }

    public static String c(long v, int v1) {
        byte[] arr_b = ps.a(v);
        int v2 = arr_b[8];
        if(v2 > v1) {
            v2 = v1;
        }
        if((v2 & 1) == 0) {
            ++v2;
        }
        return new String(arr_b, 0, v2 + 1, ps.a(true));
    }

    int c() {
        return 0x2000 >> this.m();
    }

    private int d(int v) {
        return ow.a(v, this.b, this.m());
    }

    private int d(long v) {
        int v1 = this.b(v);
        this.i = v1;
        return v1;
    }

    public void d() {
        MainService.instance.i();
        MainService.instance.k.c(this.n(), 0x2004);
    }

    private int e(int v) {
        return ow.a(v, this.b);
    }

    private CharSequence e(long v) {
        CharSequence[] arr_charSequence = this.o;
        long v2 = this.n();
        if(this.p != v2) {
            this.p = v2;
            for(int v3 = 0; v3 < arr_charSequence.length; ++v3) {
                arr_charSequence[v3] = RegionList.a(((long)v3) * 0x1000L + v2);
            }
        }
        for(int v1 = 0; true; ++v1) {
            if(v1 >= arr_charSequence.length) {
                return "??";
            }
            if(Tools.b(v, ((long)(v1 + 1)) * 0x1000L + v2 - 1L)) {
                return arr_charSequence[v1];
            }
        }
    }

    public void e() {
        this.d();
    }

    public void f() {
        int v3;
        long v = this.n();
        this.p = v;
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < this.o.length; v2 = v3) {
            CharSequence charSequence0 = RegionList.a(((long)v1) * 0x1000L + v);
            if(charSequence0.equals(this.o[v1])) {
                v3 = v2;
            }
            else {
                this.o[v1] = charSequence0;
                v3 = 1;
            }
            ++v1;
        }
        if(v2 != 0) {
            this.notifyDataSetChanged();
        }
    }

    boolean g() {
        return this.f == this.n();
    }

    @Override  // android.widget.Adapter
    public int getCount() {
        return this.o() + 2;
    }

    @Override  // android.widget.Filterable
    public Filter getFilter() {
        Filter filter0 = this.d;
        if(filter0 == null) {
            filter0 = new pd(this, null);
            this.d = filter0;
        }
        return filter0;
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) {
        if(v == 0 || v == this.getCount() - 1) {
            long[] arr_v = this.a(v != 0);
            return new iq(arr_v[0], arr_v[1]);
        }
        long v1 = this.a(v);
        int v2 = d.a(v1, false);
        int v3 = this.p();
        if((v2 & v3) != 0) {
            return new d(v1, this.g.getLong(((int)(0x1FFFL & v1))), v2 & v3);
        }
        int v4 = d.a(v1, true);
        return new d(v1, this.g.getLong(((int)(0x1FFFL & v1))), v4);
    }

    @Override  // android.widget.Adapter
    public long getItemId(int v) {
        return this.a(v);
    }

    @Override  // android.widget.SectionIndexer
    public int getPositionForSection(int v) {
        return this.b(0x100L * ((long)v) + this.h);
    }

    @Override  // android.widget.SectionIndexer
    public int getSectionForPosition(int v) {
        int v1 = (int)((this.a(v) - this.n()) / 0x100L);
        if(v1 < 0) {
            v1 = 0;
        }
        return v1 < 0x20 ? v1 : 0x1F;
    }

    @Override  // android.widget.SectionIndexer
    public Object[] getSections() {
        Object[] arr_object = new Object[0x20];
        for(int v = 0; v < 0x20; ++v) {
            arr_object[v] = d.b(this.h + ((long)v) * 0x100L, 4);
        }
        return arr_object;
    }

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        if(view0 == null || !(view0.getTag() instanceof us)) {
            view0 = this.a(viewGroup0);
        }
        us us0 = (us)view0.getTag();
        if(us0.a()) {
            view0 = this.a(viewGroup0);
            us0 = (us)view0.getTag();
        }
        this.a(us0, v);
        return view0;
    }

    static int[] h() {
        if(ow.v == null) {
            int v = Tools.e(0x7F0A0014);  // color:region_code
            int[] arr_v = {-1, -1, -1, -1, v, Tools.e(0x7F0A0015), v, d.k(4), d.k(16), d.k(0x40), d.k(2), d.k(1), d.k(0x20), d.k(8)};  // color:region_system_code
            ow.v = arr_v;
            return arr_v;
        }
        return ow.v;
    }

    @Override  // android.widget.BaseAdapter
    public boolean hasStableIds() {
        return false;
    }

    static CharSequence[] i() {
        return new CharSequence[]{qk.a(0x7F070134), qk.a(0x7F070135), qk.a(0x7F070148), "UTF-16LE", Tools.a(qk.a(0x7F070312), new Object[]{"ARM (x32)"}), Tools.a(qk.a(0x7F070312), new Object[]{"Thumb"}), Tools.a(qk.a(0x7F070312), new Object[]{"ARM (x64)"}), qk.a(0x7F070009), qk.a(0x7F07000B), qk.a(0x7F07000D), qk.a(0x7F070008), qk.a(0x7F070007), qk.a(0x7F07000C), qk.a(0x7F07000A)};  // string:format_hex "Hex (little-endian) notation"
    }

    public void j() {
        int v1;
        boolean z = MainService.instance.r() == 2;
        CharSequence[] arr_charSequence = ow.i();
        int v = this.c;
        if(z) {
            CharSequence[] arr_charSequence1 = (CharSequence[])Arrays.copyOf(arr_charSequence, 7);
            v1 = SavedListAdapter.a;
            arr_charSequence = arr_charSequence1;
        }
        else {
            v1 = v;
        }
        boolean[] arr_z = new boolean[arr_charSequence.length];
        CharSequence[] arr_charSequence2 = ow.r();
        int[] arr_v = ow.h();
        for(int v2 = 0; v2 < arr_charSequence.length; ++v2) {
            arr_charSequence[v2] = Tools.a((arr_charSequence2[v2] + ": " + arr_charSequence[v2]), arr_v[v2]);
            arr_z[v2] = (1 << v2 & v1) != 0;
        }
        oy oy0 = new oy(this, z, arr_z);
        android.ext.i.a(android.ext.i.a(Tools.o()).setCustomTitle(Tools.d(0x7F070133)).setMultiChoiceItems(arr_charSequence, arr_z, new oz(this, arr_z)).setPositiveButton(qk.a(0x7F07009B), oy0).setNeutralButton(qk.a(0x7F07023E), oy0).setNegativeButton(qk.a(0x7F07009C), null));  // string:value_format "Value format"
    }

    public pj k() {
        pa pa0 = this.w;
        if(pa0 == null) {
            pa0 = new pa(this);
            this.w = pa0;
        }
        return pa0;
    }

    private void l() {
        int v = this.getCount();
        boolean[] arr_z = this.j;
        pe pe0 = this.k;
        int v1 = this.m();
        short[] arr_v = this.b;
        if(arr_z == null || v != arr_z.length || pe0 == null || v1 != pe0.a || arr_v != this.b) {
            boolean[] arr_z1 = new boolean[v];
            this.j = arr_z1;
            if(pe0 != null) {
                int v2 = pe0.a;
                short[] arr_v1 = pe0.b;
                for(int v3 = 1; v3 < v - 1; ++v3) {
                    int v4 = ow.a(v3 - 1, arr_v, v1) << v1;
                    if((v4 & (1 << v2) - 1) == 0) {
                        int v5 = v4 >> v2;
                        int v6 = ow.a(v5, arr_v1);
                        if(v5 == ow.a(v6, arr_v1, v2) && v6 + 1 >= 0 && v6 + 1 < arr_z.length && arr_z[v6 + 1]) {
                            arr_z1[v3] = true;
                        }
                    }
                }
            }
            this.k = new pe(v1, arr_v, null);
        }
    }

    private int m() {
        int v = this.l;
        int v1 = this.c;
        if((0x400000000L | ((long)v1)) != this.m) {
            if((v1 & 0x800) == 0) {
                v = (v1 & 0x420) == 0 ? 2 : 1;
            }
            else {
                v = 0;
            }
            this.l = v;
            this.m = 0x400000000L | ((long)v1);
        }
        return v;
    }

    private long n() {
        return this.h;
    }

    @Override  // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.getFilter().filter(this.a);
        this.b();
    }

    private int o() {
        return this.b == null ? this.c() : this.b.length;
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        uq uq0 = (uq)compoundButton0.getTag();
        if(uq0 == null) {
            return;
        }
        try {
            this.j[uq0.o] = z;
            MainService.instance.E();
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            la.c("ArrayAdapter onCheckedChanged failed", indexOutOfBoundsException0);
        }
        uq0.a(z, this.i);
    }

    private int p() {
        int v = this.c;
        if(v != this.t) {
            int v1 = 0;
            int v2 = 0;
            while(v2 < 14) {
                int v3 = (1 << v2 & v) == 0 ? v1 : new int[]{0, 0, 0, 0, 4, 2, 4, 4, 16, 0x40, 2, 1, 0x20, 8}[v2] | v1;
                ++v2;
                v1 = v3;
            }
            this.t = v;
            this.s = v1;
        }
        return this.s;
    }

    private CharSequence q() {
        return ow.c(this.c);
    }

    private static CharSequence[] r() {
        if(ow.u == null) {
            CharSequence[] arr_charSequence = {qk.a(0x7F07001A), qk.a(0x7F07001B), "S", "J", "A", "T", "A8", qk.a(0x7F070011), qk.a(0x7F070013), qk.a(0x7F070015), qk.a(0x7F070010), qk.a(0x7F07000F), qk.a(0x7F070014), qk.a(0x7F070012)};  // string:hex "h"
            int[] arr_v = ow.h();
            for(int v = 0; v < 14; ++v) {
                arr_charSequence[v] = Tools.a(arr_charSequence[v], arr_v[v]);
            }
            ow.u = arr_charSequence;
            return arr_charSequence;
        }
        return ow.u;
    }
}

