package android.ext;

final class je {
    final String a;
    final int b;
    int c;
    String d;

    public je(String s, int v, String s1) {
        this.c = 0;
        this.a = s;
        this.b = v;
        this.d = s1;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof je && this.b == ((je)object0).b && this.a.equals(((je)object0).a);
    }

    @Override
    public int hashCode() {
        int v = this.c;
        if(v == 0) {
            v = this.a.hashCode();
            String s = "#$@$#" + this.b;
            int v2 = s.length();
            for(int v1 = 0; v1 < v2; ++v1) {
                v = v * 0x1F + s.charAt(v1);
            }
            this.c = v;
        }
        return v;
    }

    @Override
    public String toString() {
        return this.a;
    }
}

