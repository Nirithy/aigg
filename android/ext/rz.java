package android.ext;

import android.view.View;

public class rz extends pj {
    static volatile String a;
    static volatile rz b;

    static {
        rz.a = "0";
        rz.b = null;
    }

    public rz() {
        super(0x7F07014A, 0x7F020021);  // string:time_jump "Time jump"
        rz.b = this;
    }

    public static long a(String s) {
        String s1 = s.trim();
        double f = Tools.f(s1);
        if(f < -92233720.0) {
            pt pt0 = new pt(Tools.a(qk.a(0x7F0700D1), new Object[]{s1, 0xFFFFFFFFFA80A008L}));  // string:number_less "Number \'__s__\' is less than minimum value (__d__) for this 
                                                                                                // type."
            pt0.a(s1);
            pt0.a(0xFFFFFFFFFA80A008L);
            throw pt0;
        }
        if(f > 92233720.0) {
            pt pt1 = new pt(Tools.a(qk.a(0x7F0700D2), new Object[]{s1, 0x57F5FF8L}));  // string:number_greater "Number \'__s__\' is greater than maximum value (__d__) for 
                                                                                       // this type."
            pt1.a(s1);
            pt1.a(0x57F5FF8L);
            throw pt1;
        }
        return (long)(1000000000.0 * f);
    }

    public static void a(long v) {
        if(MainService.instance.j.a(false, new sa(v))) {
            MainService.instance.k.a(v);
        }
        rz.b(v);
        qm qm0 = MainService.instance.h;
        if(qm0 != null) {
            String s = Tools.a(((double)v) / 1000000000.0);
            qm0.write("gg.timeJump(");
            Script.Consts.b(qm0, s);
            qm0.write(")\n");
        }
    }

    static void b(long v) {
        Config.a(0x7F0B00C0).d = (int)(((double)v) / 1000000000.0 * 1000.0);  // id:config_time_jump_last
        Config.c();
        TimeJumpPanel timeJumpPanel0 = MainService.instance.m;
        if(timeJumpPanel0 != null) {
            timeJumpPanel0.j();
        }
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        new sb(this, null).onClick(view0);
    }
}

