package android.ext;

class tq {
    private static final ThreadLocal a;

    static {
        tq.a = new tr();
    }

    private tq() {
    }

    tq(tq tq0) {
    }

    public boolean a(int v) {
        int v1 = (int)(((Integer)tq.a.get()));
        if((v1 & v) == 0) {
            tq.a.set(((int)(v1 | v)));
            return true;
        }
        return false;
    }

    public void b(int v) {
        Integer integer0 = (int)(((int)(((Integer)tq.a.get()))) & ~v);
        tq.a.set(integer0);
    }
}

