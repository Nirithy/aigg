package android.ext;

class gp implements Comparable {
    long a;
    int b;

    public gp(long v, int v1) {
        this.a = v;
        this.b = v1;
    }

    public int a(gp gp0) {
        long v = this.a;
        long v1 = gp0.a;
        if(v < v1) {
            return -1;
        }
        return v == v1 ? 0 : 1;
    }

    @Override
    public int compareTo(Object object0) {
        return this.a(((gp)object0));
    }
}

