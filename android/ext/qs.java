package android.ext;

import android.util.SparseIntArray;

public class qs {
    final int a;
    final long b;
    final long c;
    String d;
    String e;
    private static SparseIntArray f;
    private static int g;

    static {
        qs.f = null;
        qs.g = 0xFFFFFF;
    }

    public qs(int v, long v1, long v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    public static int a(qs qs0) {
        try {
            SparseIntArray sparseIntArray0 = qs.f;
            if(sparseIntArray0 == null) {
                sparseIntArray0 = new SparseIntArray(8);
                sparseIntArray0.append(4, Tools.e(0x7F0A000C));  // color:pointer_unknown
                sparseIntArray0.append(1, Tools.e(0x7F0A000D));  // color:pointer_executable_writable
                sparseIntArray0.append(2, Tools.e(0x7F0A000E));  // color:pointer_executable
                sparseIntArray0.append(16, Tools.e(0x7F0A000F));  // color:pointer_writable
                sparseIntArray0.append(8, Tools.e(0x7F0A0010));  // color:pointer_readable
                qs.f = sparseIntArray0;
                qs.g = Tools.e(0x7F0A000C);  // color:pointer_unknown
            }
            int v = qs0 == null ? 4 : sparseIntArray0.get(qs0.f());
            return v == 4 ? qs.g : v;
        }
        catch(Throwable throwable0) {
            la.c(("Failed getPointerColor for: " + qs0), throwable0);
            return qs.g;
        }
    }

    // 去混淆评级： 低(20)
    public String a() {
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(((this.a & 0x100) == 0x100 ? "r" : "-"))).append(((this.a & 0x200) == 0x200 ? "w" : "-")).append(((this.a & 0x400) == 0x400 ? "x" : "-"));
        return (this.a & 0x800) == 0x800 ? stringBuilder0.append("s").toString() : stringBuilder0.append("p").toString();
    }

    public CharSequence b() {
        return RegionList.a[this.a & 0xFF];
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e == null ? this.d : this.e + ":bss";
    }

    public CharSequence e() {
        return Tools.a(this.toString(), RegionList.b[this.a & 0xFF]);
    }

    private int f() {
        int v = this.a;
        if((v & 0x600) == 0x600) {
            return 1;
        }
        if((v & 0x400) == 0x400) {
            return 2;
        }
        if((v & 0x200) == 0x200) {
            return 16;
        }
        return (v & 0x100) == 0x100 ? 8 : 4;
    }

    @Override
    public String toString() {
        return RegionList.a[this.a & 0xFF] + ": " + d.b(this.b, 4) + '-' + d.b(this.c, 4) + ' ' + this.a() + " \'" + this.d + '\'';
    }
}

