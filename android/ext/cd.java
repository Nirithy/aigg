package android.ext;

class cd extends Config.OptionMultiChoice {
    cd(int v, int v1, int[] arr_v, int v2, String s, boolean z) {
        super(v, v1, arr_v, v2, s, z);
    }

    @Override  // android.ext.cz
    protected void b() {
        super.b();
        this.a(true);
    }
}

