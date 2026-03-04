package android.ext;

class pe {
    int a;
    short[] b;

    private pe(int v, short[] arr_v) {
        this.a = v;
        this.b = arr_v;
    }

    pe(int v, short[] arr_v, pe pe0) {
        this(v, arr_v);
    }
}

