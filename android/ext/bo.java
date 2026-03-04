package android.ext;

class bo implements Runnable {
    final bl a;
    private final CharSequence b;
    private final long c;
    private final long d;
    private final int e;
    private final int f;
    private final long g;
    private final String h;

    bo(bl bl0, CharSequence charSequence0, long v, long v1, int v2, int v3, long v4, String s) {
        this.a = bl0;
        this.b = charSequence0;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = v4;
        this.h = s;
        super();
    }

    @Override
    public void run() {
        this.a.b(this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}

