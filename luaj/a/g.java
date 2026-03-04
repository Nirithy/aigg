package luaj.a;

import lasm.d;

public class g extends c {
    final d q;

    public g(d d0) {
        this.q = d0;
        this.e = new h(null, null);
    }

    @Override  // luaj.a.c
    public int b(int v, int v1, int v2) {
        return super.b(v, v1, v2);
    }

    @Override  // luaj.a.c
    public int d(int v, int v1, int v2) {
        return super.d(v, v1, v2);
    }

    @Override  // luaj.a.c
    public int d(int v, int v1, int v2, int v3) {
        return super.d(v, v1, v2, v3);
    }

    public void f(int v, int v1, int v2) {
        if(v2 <= 0x1FF) {
            this.d(36, v, v1, v2);
            return;
        }
        this.d(36, v, v1, 0);
        this.h(v2, this.e.e);
    }

    @Override  // luaj.a.c
    int h(int v, int v1) {
        return this.q.a(v);
    }

    @Override  // luaj.a.c
    public int i(int v, int v1) {
        return super.i(v, v1);
    }
}

