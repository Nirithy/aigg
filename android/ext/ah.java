package android.ext;

class ah implements Comparable {
    long a;
    int b;

    public ah(long v, int v1) {
        this.a = v;
        this.b = v1;
    }

    public int a(ah ah0) {
        long v = this.a;
        long v1 = ah0.a;
        if(v < v1) {
            return -1;
        }
        return v == v1 ? 0 : 1;
    }

    @Override
    public int compareTo(Object object0) {
        return this.a(((ah)object0));
    }
}

