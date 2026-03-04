package android.ext;

class cr extends cz {
    cr(int v, int v1, int[] arr_v, int v2, String s, boolean z) {
        super(v, v1, arr_v, v2, s, z);
    }

    @Override  // android.ext.cz
    protected void b() {
        super.b();
        int v1 = Config.a.length;
        if(this.n == null || this.n.length != v1 + 1) {
            int[] arr_v = new int[v1 + 1];
            CharSequence[] arr_charSequence = new CharSequence[v1 + 1];
            arr_v[0] = 0;
            arr_charSequence[0] = qk.a(0x7F07009C);  // string:no "No"
            for(int v = 0; v < v1; ++v) {
                int v2 = Config.a[v];
                arr_v[v + 1] = v2;
                arr_charSequence[v + 1] = Config.c(v2);
            }
            this.n = arr_v;
            this.m = arr_charSequence;
            this.l = null;
        }
    }

    @Override  // android.ext.cz
    public void d() {
        if(!lh.g()) {
            return;
        }
        super.d();
    }

    @Override  // android.ext.cz
    public String toString() {
        return Tools.c(this.a) + ": " + Config.c(this.d);
    }
}

