package android.ext;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.ActivityManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.fix.j;
import android.os.Process;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class qf {
    static final SparseIntArray a;
    static HashMap b;
    private static final Map c;
    private static final int d;
    private static final SparseIntArray e;
    private ActivityManager f;
    private PackageManager g;
    private static qf h;

    static {
        qf.d = -1;
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        qf.e = sparseIntArray0;
        qf.c = new HashMap();
        ca.c();
        qf.c();
        String[] arr_s = ca.b();
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            if(s != null && s.length() != 0) {
                try {
                    sparseIntArray0.put(Integer.parseInt(s), 1);
                }
                catch(NumberFormatException numberFormatException0) {
                    la.c(("Failed load bugged uid: " + s), numberFormatException0);
                }
            }
        }
        qf.a = new SparseIntArray();
        qf.h = null;
        qf.b = null;
    }

    public qf(ActivityManager activityManager0, PackageManager packageManager0) {
        this.f = activityManager0;
        this.g = packageManager0;
        qf.h = this;
    }

    private qg a(int v, int v1, String s, List list0, SparseArray sparseArray0) {
        String s4;
        String s3;
        String s1;
        boolean z2;
        ApplicationInfo applicationInfo0 = null;
        boolean z = true;
        if(s.indexOf(58) != -1) {
            s = s.split(":", -1)[0];
        }
        boolean z1 = s.indexOf(46) != -1 && s.indexOf(0x2F) == -1;
        qg qg0 = z1 ? this.a(s) : null;
        if(qg0 != null) {
            if(qg0.a == qf.d) {
                qg0.a = v1;
            }
            return qg0;
        }
        if(z1) {
            try {
                applicationInfo0 = Tools.j(s);
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                z2 = false;
                goto label_25;
            }
            catch(NoSuchMethodError noSuchMethodError0) {
                la.a(noSuchMethodError0);
                z2 = false;
                goto label_25;
            }
            z2 = applicationInfo0 == null ? false : true;
        }
        else {
            z2 = false;
        }
    label_25:
        if(applicationInfo0 == null) {
            if(list0 != null) {
                for(Object object0: list0) {
                    ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo0 = (ActivityManager.RunningAppProcessInfo)object0;
                    if(activityManager$RunningAppProcessInfo0 == null || activityManager$RunningAppProcessInfo0.pid != v || activityManager$RunningAppProcessInfo0.pkgList == null || activityManager$RunningAppProcessInfo0.pkgList.length <= 0) {
                        continue;
                    }
                    z2 = true;
                    s1 = activityManager$RunningAppProcessInfo0.pkgList[0];
                    goto label_36;
                }
            }
            s1 = s;
        label_36:
            if(!z2) {
                String s2 = (String)sparseArray0.get(v1);
                if(s2 != null) {
                    s1 = s2;
                    z2 = true;
                }
            }
            if(z2) {
                s3 = s1;
            }
            else {
                s3 = this.a(v1);
                if(s3 == null) {
                    s3 = s1;
                }
                else {
                    sparseArray0.put(v1, s3);
                    z2 = true;
                }
            }
            if(z2) {
                qg qg1 = this.a(s3);
                if(qg1 != null) {
                    if(qg1.a == qf.d) {
                        qg1.a = v1;
                    }
                    if(z1) {
                        qf.c.put(s, qg1);
                    }
                    return qg1;
                }
            }
            s4 = s3;
        }
        else {
            s4 = s;
        }
        qg qg2 = new qg(v1, s4);
        if(z2) {
            if(applicationInfo0 == null) {
                try {
                    ApplicationInfo applicationInfo1 = Tools.j(s4);
                    goto label_67;
                label_66:
                    applicationInfo1 = applicationInfo0;
                label_67:
                    if(applicationInfo1 != null) {
                        qg2.d = this.a(s4, applicationInfo1);
                        if(qg2.d != null) {
                            qg2.d = String.valueOf(qg2.d);
                        }
                        qg2.f = applicationInfo1.sourceDir.startsWith("/system/") || (applicationInfo1.flags & 0x80) != 0 || (applicationInfo1.flags & 1) != 0;
                        if((applicationInfo1.flags & 0x2000000) == 0) {
                            z = false;
                        }
                        qg2.g = z;
                        qg2.e = applicationInfo1.nativeLibraryDir;
                        qg2.b = applicationInfo1.uid;
                        HashMap hashMap0 = qf.b;
                        if(hashMap0 != null) {
                            Integer integer0 = (Integer)hashMap0.get(s4);
                            if(integer0 != null && ((int)integer0) != applicationInfo1.uid) {
                                la.b(("real uid: " + applicationInfo1.uid + " != " + integer0));
                                qg2.b = (int)integer0;
                            }
                        }
                        if(qg2.b != v1) {
                            la.b(("vs app: " + qg2.b + " != " + v1));
                        }
                    }
                    goto label_91;
                }
                catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                    la.c(("Package not found: " + qg2.c + " [" + qg2.a + ']'), packageManager$NameNotFoundException0);
                    goto label_91;
                }
                catch(NoSuchMethodError noSuchMethodError1) {
                    goto label_90;
                }
            }
            else {
                goto label_66;
            }
            goto label_67;
        label_90:
            la.a(noSuchMethodError1);
        }
    label_91:
        qf.c.put(s4, qg2);
        if(z1 && !s.equals(s4)) {
            qf.c.put(s, qg2);
        }
        return qg2;
    }

    private qg a(String s) {
        String s1 = Tools.g();
        if(s.equals(s1)) {
            return qf.a(s1, "GG");
        }
        return s.startsWith("com.bluestacks.") ? qf.a(s, s) : ((qg)qf.c.get(s));
    }

    private static qg a(String s, String s1) {
        qg qg0 = new qg(qf.d, s);
        if(s1 != null) {
            qg0.d = s1;
        }
        qg0.h = true;
        return qg0;
    }

    private String a(int v) {
        String s;
        boolean z;
        if(qf.e.get(v) != 1) {
            try {
                PackageManager packageManager0 = this.g;
                z = ca.a(("uid:" + v), "uid");
                try {
                    String[] arr_s = packageManager0.getPackagesForUid(v);
                    s = arr_s == null || arr_s.length <= 0 ? null : arr_s[0];
                }
                catch(Throwable throwable1) {
                    ca.a(z);
                    throw throwable1;
                }
            }
            catch(Throwable throwable0) {
                la.c("Failed getPackagesForUid", throwable0);
                return null;
            }
            try {
                ca.a(z);
                return s;
            }
            catch(Throwable throwable0) {
            }
            la.c("Failed getPackagesForUid", throwable0);
            return s;
        }
        return null;
    }

    private String a(String s, ApplicationInfo applicationInfo0) {
        String s1;
        try {
            s1 = applicationInfo0.packageName;
            String s2 = Tools.a(applicationInfo0);
            if(s2 != null) {
                return s2;
            }
        }
        catch(Throwable throwable0) {
            la.c(("Failed load label for: " + applicationInfo0.packageName), throwable0);
        }
        return s1;
    }

    private List a(List list0, List list1) {
        long v4;
        String[] arr_s2;
        String[] arr_s1;
        List[] arr_list;
        qh[] arr_qh = (qh[])list0.toArray(new qh[list0.size()]);
        for(int v = 0; v < arr_qh.length; ++v) {
            arr_qh[v].k = 0L;
        }
        try {
            arr_list = new List[]{this.f.getRunningTasks(50), null};
        }
        catch(Throwable throwable0) {
            la.c("Failed getRunningTasks", throwable0);
        }
        arr_list[1] = list1;
        int v1 = 0;
        while(v1 < 2) {
            List list2 = arr_list[v1];
            if(list2 != null) {
                boolean[] arr_z = new boolean[arr_qh.length];
                int v2 = 0;
                while(v2 < list2.size()) {
                    Object object0 = list2.get(v2);
                    if(object0 != null) {
                        String[] arr_s = null;
                        long v3 = 0L;
                        if(object0 instanceof ActivityManager.RunningTaskInfo) {
                            try {
                                arr_s1 = new String[2];
                                String s = ((ActivityManager.RunningTaskInfo)object0).topActivity == null ? null : ((ActivityManager.RunningTaskInfo)object0).topActivity.getPackageName();
                                arr_s1[0] = s;
                                String s1 = ((ActivityManager.RunningTaskInfo)object0).baseActivity == null ? null : ((ActivityManager.RunningTaskInfo)object0).baseActivity.getPackageName();
                                arr_s1[1] = s1;
                            }
                            catch(NoClassDefFoundError noClassDefFoundError0) {
                                la.b("Class not found", noClassDefFoundError0);
                                arr_s2 = arr_s;
                                goto label_49;
                            }
                            try {
                                if(arr_s1[0] != null && arr_s1[0].equals(arr_s1[1])) {
                                    arr_s1[1] = null;
                                }
                            }
                            catch(NoClassDefFoundError noClassDefFoundError0) {
                                arr_s = arr_s1;
                                la.b("Class not found", noClassDefFoundError0);
                                arr_s2 = arr_s;
                                goto label_49;
                            }
                            v3 = 1000000L;
                            arr_s2 = arr_s1;
                        }
                        else {
                            arr_s2 = null;
                        }
                    label_49:
                        if(object0 instanceof ActivityManager.RunningAppProcessInfo) {
                            try {
                                v4 = 1000L;
                                arr_s2 = ((ActivityManager.RunningAppProcessInfo)object0).pkgList;
                            }
                            catch(NoClassDefFoundError noClassDefFoundError1) {
                                la.b("Class not found", noClassDefFoundError1);
                                v4 = v3;
                            }
                        }
                        else {
                            v4 = v3;
                        }
                        if(arr_s2 != null) {
                            int v5 = arr_s2.length;
                            for(int v6 = 0; v6 < v5; ++v6) {
                                String s2 = arr_s2[v6];
                                if(s2 != null) {
                                    for(int v7 = 0; v7 < arr_qh.length; ++v7) {
                                        if(!arr_z[v7]) {
                                            qh qh0 = arr_qh[v7];
                                            if(qh0 != null && s2.equals(qh0.c)) {
                                                qh0.k += ((long)(list2.size() - v2)) * v4;
                                                arr_z[v7] = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ++v2;
                }
            }
            ++v1;
        }
        try {
            Arrays.sort(arr_qh);
        }
        catch(Throwable throwable1) {
            la.a(throwable1);
        }
        List list3 = new ArrayList(arr_qh.length);
        for(int v8 = 0; v8 < arr_qh.length; ++v8) {
            list3.add(arr_qh[v8]);
        }
        return list3;
    }

    public static void a() {
        int v = qf.c.size();
        if(v == 0) {
            return;
        }
        qf.c.clear();
        qf.c();
        la.a(("PL: " + v + " -> " + qf.c.size()));
    }

    public static void a(bk bk0) {
        qf.h.b(bk0);
    }

    private void b(bk bk0) {
        qg qg0;
        String s;
        int v8;
        int v7;
        int v6;
        int v5;
        boolean z;
        int v4;
        int v3;
        List list1;
        bk0.g();
        ArrayList arrayList0 = new ArrayList();
        qf.a.clear();
        List list0 = null;
        try {
            la.a("getRunningAppProcesses: start");
            list0 = this.f.getRunningAppProcesses();
            la.a(("getRunningAppProcesses: end " + list0.size()));
        }
        catch(Throwable throwable0) {
            la.c("Failed getRunningAppProcesses", throwable0);
        }
        list1 = list0;
        try {
            int v = Process.myPid();
            int v1 = MainService.instance.k.o();
            int v2 = MainService.instance.k.p();
            j j0 = new j();
        alab1:
            while(true) {
                do {
                    do {
                        do {
                        label_16:
                            v3 = bk0.b();
                            if(v3 == 0) {
                                break alab1;
                            }
                            v4 = bk0.b();
                            z = bk0.a() != 0;
                            v5 = bk0.b();
                            v6 = bk0.b();
                            v7 = bk0.b();
                            v8 = bk0.b();
                            if(v8 < 0 || v8 > 200) {
                                goto label_34;
                            }
                            s = bk0.a(v8, null);
                        }
                        while(v3 == v || v3 == v1 || v3 == v2);
                        qg0 = this.a(v3, v4, s, list1, j0);
                    }
                    while(qg0 == null || qg0.c.equals(Tools.g()));
                    arrayList0.add(new qh(qg0, v3, v4, s, v6, z, v5));
                }
                while(v7 == 0);
                qf.a.put(v3, v7);
                la.a(("Tracer: " + v7 + " -> " + v3));
                goto label_16;
            label_34:
                la.c(("Bad cmdline length: " + v8), new RuntimeException());
                break;
            }
        }
        catch(IOException iOException0) {
            la.c("???", iOException0);
        }
        MainService.instance.j.a(this.a(arrayList0, list1));
    }

    private static void c() {
        Map map0 = qf.c;
        String[] arr_s = ca.a();
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            if(s != null && s.length() != 0) {
                map0.put(s, qf.a(s, null));
            }
        }
    }
}

