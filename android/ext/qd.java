package android.ext;

import java.io.File;

public class qd {
    public static String a(String s, String s1) {
        String s2 = Tools.r() + "/Notes";
        if(s == null) {
            return Tools.s().getString(s1, s2);
        }
        new qw().a(s1, s, s2).commit();
        return null;
    }

    public static String a(String s, String s1, String s2) {
        qh qh0 = MainService.instance.ap;
        if(qh0 == null) {
            return qd.a(null, s) + "/file" + s2;
        }
        String s3 = qh0.c;
        String s4 = Tools.s().getString(s3 + s1, null);
        return s4 == null ? qd.a(null, s) + '/' + s3 + s2 : s4;
    }

    public static void a(String s, String s1, String s2, String s3) {
        File file0 = new File(s.trim());
        String s4 = file0.getParent();
        if(s1 != null && s4 != null && s4.length() > 0) {
            qd.a(s4, s1);
        }
        qh qh0 = MainService.instance.ap;
        if(qh0 != null) {
            String s5 = qh0.c;
            new qw().a(s5 + s2, file0.getAbsolutePath(), qd.a(null, s1) + '/' + s5 + s3).commit();
        }
    }
}

