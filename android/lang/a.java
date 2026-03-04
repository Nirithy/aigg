package android.lang;

abstract class a {
    protected final String a;
    protected final byte[] b;

    protected a(String s, byte[] arr_b) {
        this.a = s;
        this.b = arr_b;
    }

    public byte[] a() {
        return this.b;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof a && ProcessEnvironment.d(this.a(), ((a)object0).a());
    }

    @Override
    public int hashCode() {
        return ProcessEnvironment.b(this.a());
    }

    @Override
    public String toString() {
        return this.a;
    }
}

