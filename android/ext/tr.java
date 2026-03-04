package android.ext;

class tr extends ThreadLocal {
    protected Integer a() {
        return 0;
    }

    @Override
    protected Object initialValue() {
        return this.a();
    }
}

