package android.lang;

class l extends a implements Comparable {
    protected l(String s, byte[] arr_b) {
        super(s, arr_b);
    }

    public static l a(Object object0) {
        return l.a(((String)object0));
    }

    public static l a(String s) {
        return new l(s, s.getBytes());
    }

    public static l a(byte[] arr_b) {
        return new l(new String(arr_b), arr_b);
    }

    public int a(l l0) {
        return ProcessEnvironment.c(this.a(), l0.a());
    }

    public static l b(String s) {
        ProcessEnvironment.c(s);
        return l.a(s);
    }

    @Override
    public int compareTo(Object object0) {
        return this.a(((l)object0));
    }

    // 去混淆评级： 低(20)
    @Override  // android.lang.a
    public boolean equals(Object object0) {
        return object0 instanceof l && super.equals(object0);
    }
}

