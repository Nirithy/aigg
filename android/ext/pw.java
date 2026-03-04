package android.ext;

import java.util.Comparator;

class pw implements Comparator {
    private final boolean a;

    pw(boolean z) {
        this.a = z;
        super();
    }

    public int a(qb qb0, qb qb1) {
        boolean z = qb0.c;
        if(z != qb1.c) {
            return z ? -1 : 1;
        }
        try {
            if(this.a) {
                return pp.a(qb0.b, qb1.b);
            }
            return qb0.a.lastModified() <= qb1.a.lastModified() ? 1 : -1;
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return 0;
        }
    }

    @Override
    public int compare(Object object0, Object object1) {
        return this.a(((qb)object0), ((qb)object1));
    }
}

