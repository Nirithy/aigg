package android.ext;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.fix.Button;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

public class PathSelector extends Button implements View.OnClickListener {
    static boolean a;

    static {
        PathSelector.a = true;
    }

    public PathSelector(Context context0) {
        super(context0);
        this.a();
    }

    public PathSelector(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a();
    }

    public PathSelector(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a();
    }

    public PathSelector(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.a();
    }

    static ArrayList a(int v, File file0, String[] arr_s, String s, boolean z) {
        ArrayList arrayList0 = new ArrayList();
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            String s1 = arr_s[v1];
            String s2 = s1.toLowerCase(Locale.US);
            if(s == null || s2.startsWith(s)) {
                File file1 = new File(file0, s1);
                boolean z1 = PathSelector.a(file1);
                if(v != 0 || z1) {
                    arrayList0.add(new qb(file1, s2, z1));
                }
            }
        }
        if(arrayList0.size() > 1) {
            pw pw0 = new pw(z);
            try {
                Collections.sort(arrayList0, pw0);
                la.a(("Sort " + arrayList0.size() + " in " + 0L));
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append("Failed sort:\n");
                px px0 = new px(stringBuilder0);
                try {
                    Collections.sort(arrayList0, px0);
                }
                catch(IllegalArgumentException unused_ex) {
                    ho.b(stringBuilder0.toString());
                }
                la.a(illegalArgumentException0);
            }
            return arrayList0;
        }
        return arrayList0;
    }

    private void a() {
        this.setText("...");
        this.setOnClickListener(this);
    }

    private static void a(String s, ArrayList arrayList0, String s1, String s2) {
        int v;
        if(s2 != null) {
            if(s1 == null) {
                v = 1;
            }
            else {
                try {
                    v = 3;
                label_5:
                    int v1 = 0;
                    String s3 = s2;
                    while(true) {
                        if(v1 >= v) {
                            return;
                        }
                        if(v1 != 1) {
                        label_11:
                            if(v1 != 2) {
                            label_14:
                                File file0 = new File(s3);
                                for(int v2 = 0; true; ++v2) {
                                    String s4 = file0.getAbsolutePath();
                                    if(!s4.startsWith(s)) {
                                        break;
                                    }
                                    if(file0.isDirectory() || file0.isFile()) {
                                        String s5 = s4.substring(s.length()).split("/", -1)[0];
                                        if(!arrayList0.contains(s5)) {
                                            arrayList0.add(s5);
                                        }
                                    }
                                    file0 = file0.getParentFile();
                                    if(file0 == null || (file0.getAbsolutePath().length() <= 1 || v2 >= 20)) {
                                        break;
                                    }
                                }
                            }
                            else if(s2.startsWith(s1)) {
                                s3 = "/data/data/" + s2.substring(s1.length());
                                goto label_14;
                            }
                        }
                        else if(s2.startsWith("/data/data/")) {
                            s3 = s1 + s2.substring(11);
                            goto label_11;
                        }
                        ++v1;
                    }
                }
                catch(Throwable throwable0) {
                    la.a(throwable0);
                    return;
                }
            }
            goto label_5;
        }
    }

    static boolean a(File file0) {
        try {
            return file0.isDirectory();
        }
        catch(Throwable unused_ex) {
            return false;
        }
    }

    static String[] b(File file0) {
        String[] arr_s;
        try {
            arr_s = file0.list();
        }
        catch(SecurityException securityException0) {
            la.b(("Failed list dir: " + file0.getAbsolutePath()), securityException0);
            arr_s = null;
        }
        if(arr_s != null) {
            return arr_s;
        }
        try {
            String s = file0.getAbsolutePath();
            String s1 = s.startsWith("/data/user/") ? "/data/user/" + s.split("/", -1)[3] + "/" : "/data/user/0/";
            String s2 = String.valueOf(s) + '/';
            ArrayList arrayList0 = new ArrayList();
            PathSelector.a(s2, arrayList0, s1, "/data/anr");
            PathSelector.a(s2, arrayList0, s1, "/data/app");
            PathSelector.a(s2, arrayList0, s1, "/data/app-lib");
            PathSelector.a(s2, arrayList0, s1, "/data/app-private");
            PathSelector.a(s2, arrayList0, s1, "/data/dalvik-cache/profiles");
            PathSelector.a(s2, arrayList0, s1, "/data/dalvik-cache/x86");
            PathSelector.a(s2, arrayList0, s1, "/data/dalvik-cache/armeabi");
            PathSelector.a(s2, arrayList0, s1, "/data/dalvik-cache/armeabi-v7a");
            PathSelector.a(s2, arrayList0, s1, "/data/dalvik-cache/arm");
            PathSelector.a(s2, arrayList0, s1, "/data/dalvik-cache/arm64-v8a");
            PathSelector.a(s2, arrayList0, s1, "/data/dalvik-cache/arm64");
            PathSelector.a(s2, arrayList0, s1, "/data/dalvik-cache/x86");
            PathSelector.a(s2, arrayList0, s1, "/data/dalvik-cache/x86_64");
            PathSelector.a(s2, arrayList0, s1, "/data/local/tmp");
            PathSelector.a(s2, arrayList0, s1, "/data/misc/user");
            PathSelector.a(s2, arrayList0, s1, "/data/misc/zoneinfo");
            PathSelector.a(s2, arrayList0, s1, "/data/resource-cache");
            PathSelector.a(s2, arrayList0, s1, "/data/security");
            PathSelector.a(s2, arrayList0, s1, "/data/system/cache");
            PathSelector.a(s2, arrayList0, s1, "/data/system/registered_services");
            PathSelector.a(s2, arrayList0, s1, "/data/system/shared_prefs");
            PathSelector.a(s2, arrayList0, s1, "/data/system/users");
            PathSelector.a(s2, arrayList0, s1, "/data/tmp");
            PathSelector.a(s2, arrayList0, s1, s1);
            PathSelector.a(s2, arrayList0, s1, "/storage/emulated/legacy");
            PathSelector.a(s2, arrayList0, s1, "/storage/emulated/0");
            PathSelector.a(s2, arrayList0, s1, "/storage/emulated/sdcard0");
            PathSelector.a(s2, arrayList0, s1, "/storage/emulated/sdcard1");
            PathSelector.a(s2, arrayList0, s1, "/storage/sdcard0");
            PathSelector.a(s2, arrayList0, s1, "/storage/sdcard1");
            PathSelector.a(s2, arrayList0, s1, "/sdcard");
            PathSelector.a(s2, arrayList0, s1, Tools.r());
            Iterator iterator0 = Tools.m().getInstalledApplications(0).iterator();
            while(true) {
                if(!iterator0.hasNext()) {
                    return arrayList0.size() == 0 ? null : ((String[])arrayList0.toArray(new String[arrayList0.size()]));
                }
                Object object0 = iterator0.next();
                ApplicationInfo applicationInfo0 = (ApplicationInfo)object0;
                PathSelector.a(s2, arrayList0, s1, applicationInfo0.dataDir);
                PathSelector.a(s2, arrayList0, s1, applicationInfo0.nativeLibraryDir);
                PathSelector.a(s2, arrayList0, s1, applicationInfo0.publicSourceDir);
                PathSelector.a(s2, arrayList0, s1, applicationInfo0.sourceDir);
                if(Build.VERSION.SDK_INT >= 21 && applicationInfo0.splitPublicSourceDirs != null) {
                    String[] arr_s1 = applicationInfo0.splitPublicSourceDirs;
                    for(int v = 0; v < arr_s1.length; ++v) {
                        PathSelector.a(s2, arrayList0, s1, arr_s1[v]);
                    }
                }
                if(Build.VERSION.SDK_INT >= 24) {
                    PathSelector.a(s2, arrayList0, s1, applicationInfo0.deviceProtectedDataDir);
                }
                PathSelector.a(s2, arrayList0, s1, "/data/data/" + applicationInfo0.packageName);
                if(Build.VERSION.SDK_INT >= 21) {
                    PathSelector.a(s2, arrayList0, s1, "/data/app/" + applicationInfo0.packageName + "-1/base.apk");
                    PathSelector.a(s2, arrayList0, s1, "/data/app/" + applicationInfo0.packageName + "-2/base.apk");
                }
                else {
                    PathSelector.a(s2, arrayList0, s1, "/data/app/" + applicationInfo0.packageName + "-1.apk");
                    PathSelector.a(s2, arrayList0, s1, "/data/app/" + applicationInfo0.packageName + "-2.apk");
                }
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return null;
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        new py(this, null).onClick(view0);
    }
}

