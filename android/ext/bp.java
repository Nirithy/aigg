package android.ext;

import java.util.ArrayList;
import java.util.List;

public class bp {
    private final List a;

    public bp() {
        this.a = new ArrayList();
    }

    public bp a(CharSequence charSequence0) {
        this.a.add(charSequence0);
        return this;
    }

    public bp a(String s, CharSequence[] arr_charSequence) {
        int v1 = 0;
        int v2;
        for(int v = 0; (v2 = s.indexOf("%s", v1)) >= 0; ++v) {
            this.a.add(s.substring(v1, v2));
            this.a.add(arr_charSequence[v]);
            v1 = v2 + 2;
        }
        this.a.add(s.substring(v1, s.length()));
        return this;
    }

    public CharSequence a() {
        return Tools.a(((CharSequence[])this.a.toArray(new CharSequence[this.a.size()])));
    }

    public int b() {
        return this.a.size();
    }
}

