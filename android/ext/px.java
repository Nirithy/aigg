package android.ext;

import java.util.Comparator;

class px implements Comparator {
    private final StringBuilder a;

    px(StringBuilder stringBuilder0) {
        this.a = stringBuilder0;
        super();
    }

    public int a(qb qb0, qb qb1) {
        int v1;
        int v = 68;
        boolean z = qb0.c;
        boolean z1 = qb1.c;
        if(z == z1) {
            v1 = pp.a(qb0.b, qb1.b);
        }
        else if(z) {
            v1 = -1;
        }
        else {
            v1 = 1;
        }
        this.a.append(((char)(z ? 68 : 70)));
        this.a.append(':');
        this.a.append(qb0);
        this.a.append(':');
        this.a.append(qb0.b);
        this.a.append('\n');
        StringBuilder stringBuilder0 = this.a;
        if(!z1) {
            v = 70;
        }
        stringBuilder0.append(((char)v));
        this.a.append(':');
        this.a.append(qb1);
        this.a.append(':');
        this.a.append(qb1.b);
        this.a.append('\n');
        this.a.append(v1);
        this.a.append('\n');
        return v1;
    }

    @Override
    public int compare(Object object0, Object object1) {
        return this.a(((qb)object0), ((qb)object1));
    }
}

