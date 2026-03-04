package android.ext;

public class pg {
    long a;
    String b;
    int c;
    private CharSequence d;

    public pg(long v, CharSequence charSequence0, String s, int v1) {
        this.a = v;
        this.d = charSequence0;
        this.b = s;
        this.c = v1;
    }

    public CharSequence a() {
        return Tools.a(new CharSequence[]{Tools.a(d.b(this.a, 0), Tools.e(0x7F0A0003)), Tools.a((": " + this.d), -1)});  // color:address
    }
}

