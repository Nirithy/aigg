package android.ext;

class tt extends ThreadLocal {
    protected char[] a() {
        return new char[16];
    }

    @Override
    protected Object initialValue() {
        return this.a();
    }
}

