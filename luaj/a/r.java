package luaj.a;

class r {
    int a;
    final s b;
    final f c;
    final f d;

    r() {
        this.b = new s();
        this.c = new f();
        this.d = new f();
    }

    void a(int v, int v1) {
        this.d.a = -1;
        this.c.a = -1;
        this.a = v;
        this.b.e = v1;
    }

    public void a(r r0) {
        this.d.a = r0.d.a;
        this.a = r0.a;
        this.c.a = r0.c.a;
        this.b.d = r0.b.d;
        this.b.a = r0.b.a;
        this.b.b = r0.b.b;
        this.b.c = r0.b.c;
        this.b.e = r0.b.e;
    }

    boolean a() {
        return this.c.a != this.d.a;
    }

    boolean b() {
        return this.a == 5 && this.c.a == -1 && this.d.a == -1;
    }
}

