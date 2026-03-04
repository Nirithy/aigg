package android.ext;

import java.util.Comparator;

class ea implements Comparator {
    public int a(String s, String s1) {
        return (s + "_zzz").replace('-', '_').compareTo((s1 + "_zzz").replace('-', '_'));
    }

    @Override
    public int compare(Object object0, Object object1) {
        return this.a(((String)object0), ((String)object1));
    }
}

