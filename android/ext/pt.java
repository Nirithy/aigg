package android.ext;

import java.util.ArrayList;
import java.util.Collections;

class pt extends NumberFormatException {
    private ArrayList a;
    private String b;

    public pt(String s) {
        super(s);
        this.a = null;
        this.b = null;
    }

    void a() {
        int v2;
        int v1;
        if(this.b == null) {
            String s = this.getMessage();
            if(s != null) {
                int v = s.indexOf(qk.a(0x7F070307));  // string:locale_ui "In your locale"
                if(v > 0) {
                    s = s.substring(0, v);
                    v1 = 1;
                }
                else {
                    v1 = 0;
                }
                ArrayList arrayList0 = this.a;
                if(arrayList0 == null) {
                    v2 = v1;
                }
                else {
                    Collections.sort(arrayList0, new pu(this));
                    v2 = v1;
                    for(Object object0: arrayList0) {
                        String s1 = (String)object0;
                        if(s1 != null) {
                            String s2 = Script.a_(s1);
                            if(!s1.equals(s2) && s.indexOf(s1) >= 0) {
                                s = s.replace(s1, s2);
                                v2 = 1;
                            }
                        }
                    }
                }
                String s3 = v <= 0 ? s : s + qk.a(0x7F070308) + " (en_US):\n" + Tools.a(ps.a(0x7F070309), new Object[]{Character.valueOf('.'), Character.valueOf(',')});  // string:locale_script "Scripts always use English locale"
                if(v2 != 0) {
                    this.b = s3;
                }
            }
        }
    }

    void a(long v) {
        this.a(Tools.a(qk.a("__d__"), new Object[]{v}));
    }

    void a(Object object0) {
        this.a(Tools.a(qk.a("__d__"), new Object[]{object0}));
    }

    void a(String s) {
        ArrayList arrayList0 = this.a;
        if(arrayList0 == null) {
            arrayList0 = new ArrayList();
            this.a = arrayList0;
        }
        arrayList0.add(s);
    }

    @Override
    public String getMessage() {
        return this.b == null ? super.getMessage() : this.b;
    }
}

