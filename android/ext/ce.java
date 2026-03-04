package android.ext;

class ce extends Config.OptionMultiChoice {
    ce(int v, int v1, int[] arr_v, int v2, String s, boolean z, int v3) {
        super(v, v1, arr_v, v2, s, z, v3);
    }

    @Override  // android.ext.cz
    protected void b() {
        super.b();
        if(this.j == null) {
            this.j = new cf(this);
        }
        this.a(true);
    }
}

