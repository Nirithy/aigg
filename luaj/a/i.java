package luaj.a;

class i implements CharSequence {
    char[] a;
    int b;

    @Override
    public char charAt(int v) {
        return this.a[v];
    }

    @Override
    public int length() {
        return this.b;
    }

    @Override
    public CharSequence subSequence(int v, int v1) {
        return null;
    }
}

