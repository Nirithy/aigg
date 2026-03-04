package android.ext;

class cq extends cz {
    cq(int v, int v1, int[] arr_v, int v2, String s, boolean z) {
        super(v, v1, arr_v, v2, s, z);
    }

    @Override  // android.ext.cz
    protected void b() {
        int v = 20;
        super.b();
        if(this.n == null) {
            int v1 = Tools.c();
            int v2 = v1 <= 0 ? 0 : ((int)Math.floor(Math.log(((float)v1) / 5.0f) / 0.693147)) - 8;
            if(v2 <= 0) {
                v2 = 7;
            }
            if(v2 < 20) {
                v = v2;
            }
            int[] arr_v = new int[v + 2];
            CharSequence[] arr_charSequence = new CharSequence[v + 2];
            arr_v[0] = 0;
            arr_charSequence[0] = qk.a(0x7F07009C);  // string:no "No"
            arr_v[arr_v.length - 1] = 0x7FFFFFFF;
            arr_charSequence[arr_v.length - 1] = qk.a(0x7F07009B);  // string:yes "Yes"
            String s = qk.a(0x7F07010B);  // string:first_mb "The first __d__ MB"
            for(int v3 = 1; v3 <= v; ++v3) {
                int v4 = 1 << v3 + 8;
                arr_v[v3] = v4;
                arr_charSequence[v3] = Tools.a(s, new Object[]{Math.round(((float)v4) * 5.0f / 1024.0f)});
            }
            this.n = arr_v;
            this.m = arr_charSequence;
            this.l = null;
        }
    }

    private String c(int v) {
        switch(v) {
            case 0: {
                return qk.a(0x7F07009C);  // string:no "No"
            }
            case 0x7FFFFFFF: {
                return qk.a(0x7F07009B);  // string:yes "Yes"
            }
            default: {
                return Tools.a(qk.a(0x7F07010B), new Object[]{Math.round(5.0f * ((float)v) / 1024.0f)});  // string:first_mb "The first __d__ MB"
            }
        }
    }

    @Override  // android.ext.cz
    public String toString() {
        return Tools.c(this.a) + ": " + this.c(this.d);
    }
}

