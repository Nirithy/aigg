package android.lang;

class k extends a implements Comparable {
    protected k(String s, byte[] arr_b) {
        super(s, arr_b);
    }

    public static k a(Object object0) {
        return k.a(((String)object0));
    }

    public static k a(String s) {
        return new k(s, s.getBytes());
    }

    public static k a(byte[] arr_b) {
        return new k(new String(arr_b), arr_b);
    }

    public int a(k k0) {
        return ProcessEnvironment.c(this.a(), k0.a());
    }

    public static k b(String s) {
        ProcessEnvironment.d(s);
        return k.a(s);
    }

    @Override
    public int compareTo(Object object0) {
        return this.a(((k)object0));
    }

    // 去混淆评级： 低(20)
    @Override  // android.lang.a
    public boolean equals(Object object0) {
        return object0 instanceof k && super.equals(object0);
    }
}

