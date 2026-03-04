package android.ext;

class ch extends Config.OptionMultiChoice {
    ch(int v, int v1, int[] arr_v, int v2, String s, boolean z) {
        super(v, v1, arr_v, v2, s, z);
    }

    @Override  // android.ext.cz
    protected void b() {
        super.b();
        if(this.n == null) {
            int[] arr_v = new int[4];
            CharSequence[] arr_charSequence = new CharSequence[4];
            String s = " (" + qk.a(0x7F0700C5) + ')';  // string:slow "slow"
            arr_v[0] = 1;
            arr_charSequence[0] = "1" + s;
            arr_v[1] = 2;
            arr_charSequence[1] = "2" + s;
            arr_v[2] = 4;
            arr_charSequence[2] = "3" + s;
            arr_v[3] = 8;
            arr_charSequence[3] = "4" + s;
            this.n = arr_v;
            this.m = arr_charSequence;
            this.l = null;
            if(this.j == null) {
                this.j = new ci(this);
            }
        }
    }
}

