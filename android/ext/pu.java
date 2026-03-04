package android.ext;

import java.util.Comparator;

class pu implements Comparator {
    final pt a;

    pu(pt pt0) {
        this.a = pt0;
        super();
    }

    public int a(String s, String s1) {
        return s1.length() - s.length();
    }

    @Override
    public int compare(Object object0, Object object1) {
        return this.a(((String)object0), ((String)object1));
    }
}

