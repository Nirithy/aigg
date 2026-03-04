package android.ext;

import android.content.Context;
import android.content.DialogInterface;
import java.util.Arrays;

class cc extends Config.OptionMultiChoice {
    private CharSequence[] o;
    private CharSequence[] p;
    private int[] q;

    cc(int v, int v1, int[] arr_v, int v2, String s, boolean z) {
        super(v, v1, arr_v, v2, s, z);
    }

    @Override  // android.ext.ct
    protected void a() {
        this.b = 0x4003F;
    }

    @Override  // android.ext.Config$OptionMultiChoice
    public boolean a(DialogInterface dialogInterface0, int v) {
        boolean z = super.a(dialogInterface0, v);
        if(z) {
            qm qm0 = MainService.instance.h;
            if(qm0 != null) {
                qm0.write("gg.setRanges(");
                Script.Consts.a(qm0, qm0.a.a, this.d);
                qm0.write(")\n");
            }
        }
        return z;
    }

    @Override  // android.ext.cz
    protected void b() {
        super.b();
        if(this.n == null) {
            int[] arr_v = new int[15];
            int[] arr_v1 = new int[15];
            CharSequence[] arr_charSequence = new CharSequence[15];
            arr_v[0] = 2;
            arr_v1[0] = Tools.e(0x7F0A0012);  // color:region_good
            arr_charSequence[0] = Tools.a("Jh: Java heap", arr_v1[0]);
            arr_v[1] = 1;
            arr_v1[1] = Tools.e(0x7F0A0012);  // color:region_good
            arr_charSequence[1] = Tools.a("Ch: C++ heap", arr_v1[1]);
            arr_v[2] = 4;
            arr_v1[2] = Tools.e(0x7F0A0012);  // color:region_good
            arr_charSequence[2] = Tools.a("Ca: C++ alloc", arr_v1[2]);
            arr_v[3] = 8;
            arr_v1[3] = Tools.e(0x7F0A0012);  // color:region_good
            arr_charSequence[3] = Tools.a("Cd: C++ .data", arr_v1[3]);
            arr_v[4] = 16;
            arr_v1[4] = Tools.e(0x7F0A0012);  // color:region_good
            arr_charSequence[4] = Tools.a("Cb: C++ .bss", arr_v1[4]);
            arr_v[5] = 0x40000;
            arr_v1[5] = Tools.e(0x7F0A0012);  // color:region_good
            arr_charSequence[5] = Tools.a("PS: PPSSPP", arr_v1[5]);
            arr_v[6] = 0x20;
            arr_v1[6] = Tools.e(0x7F0A0012);  // color:region_good
            arr_charSequence[6] = Tools.a("A: Anonymous", arr_v1[6]);
            arr_v[7] = 0x10000;
            arr_v1[7] = Tools.e(0x7F0A0016);  // color:region_other
            arr_charSequence[7] = Tools.a("J: Java", arr_v1[7]);
            arr_v[8] = 0x40;
            arr_v1[8] = Tools.e(0x7F0A0016);  // color:region_other
            arr_charSequence[8] = Tools.a("S: Stack", arr_v1[8]);
            arr_v[9] = 0x80000;
            arr_v1[9] = Tools.e(0x7F0A0016);  // color:region_other
            arr_charSequence[9] = Tools.a("As: Ashmem", arr_v1[9]);
            arr_v[10] = 0x100000;
            arr_v1[10] = Tools.e(0x7F0A0016);  // color:region_other
            arr_charSequence[10] = Tools.a("V: Video", arr_v1[10]);
            arr_v[11] = 0xFFE03F80;
            arr_v1[11] = Tools.e(0x7F0A0017);  // color:region_slow
            arr_charSequence[11] = Tools.a(qk.a("O: Other (__slow__)"), arr_v1[11]);
            arr_v[12] = 0x20000;
            arr_v1[12] = Tools.e(0x7F0A0013);  // color:region_bad
            arr_charSequence[12] = Tools.a(qk.a("B: Bad (__dangerous__)"), arr_v1[12]);
            arr_v[13] = 0x4000;
            arr_v1[13] = Tools.e(0x7F0A0014);  // color:region_code
            arr_charSequence[13] = Tools.a(qk.a("Xa: Code app (__dangerous__)"), arr_v1[13]);
            arr_v[14] = 0x8000;
            arr_v1[14] = Tools.e(0x7F0A0015);  // color:region_system_code
            arr_charSequence[14] = Tools.a(qk.a("Xs: Code system (__dangerous__)"), arr_v1[14]);
            CharSequence[] arr_charSequence1 = new CharSequence[15];
            for(int v = 0; v < 15; ++v) {
                arr_charSequence1[v] = Tools.a(arr_charSequence[v].toString().split(":")[0], arr_v1[v]);
            }
            this.q = arr_v1;
            this.n = arr_v;
            this.p = arr_charSequence;
            this.o = arr_charSequence1;
            this.l = null;
            RegionList.a(arr_v, arr_charSequence1, arr_v1);
        }
        CharSequence[] arr_charSequence2 = new CharSequence[this.n.length];
        CharSequence[] arr_charSequence3 = this.p;
        Context context0 = Tools.e();
        for(int v1 = 0; v1 < arr_charSequence3.length; ++v1) {
            String s = arr_charSequence3[v1].toString();
            try {
                s = s + " [" + Tools.a(context0, RegionList.a(v1)) + ']';
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
                ho.a(Thread.currentThread(), throwable0, false);
            }
            arr_charSequence2[v1] = Tools.a(s, this.q[v1]);
        }
        this.m = arr_charSequence2;
    }

    @Override  // android.ext.ct
    public CharSequence c() {
        int v2;
        if(this.n == null) {
            this.b();
        }
        CharSequence[] arr_charSequence = new CharSequence[this.n.length * 2];
        int v = 0;
        int v1;
        for(v1 = 0; v < this.n.length; v1 = v2) {
            if((this.n[v] & this.d) == this.n[v]) {
                if(v1 > 0) {
                    arr_charSequence[v1] = ",";
                    ++v1;
                }
                v2 = v1 + 1;
                arr_charSequence[v1] = this.o[v];
            }
            else {
                v2 = v1;
            }
            ++v;
        }
        return Tools.a(((CharSequence[])Arrays.copyOf(arr_charSequence, v1)));
    }
}

