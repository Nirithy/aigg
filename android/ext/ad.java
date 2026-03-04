package android.ext;

import android.c.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.fix.d;
import android.os.Build.VERSION;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public class ad {
    private static String a;
    private static volatile String b;
    private static String c;
    private static String d;
    private static volatile Locale e;
    private static List f;
    private static final Pattern g;

    static {
        Pattern pattern0 = null;
        ad.a = "locale";
        ad.b = null;
        ad.c = "crashed-vm";
        ad.d = "crashed-vm2";
        ad.e = null;
        ad.f = new ArrayList();
        try {
            pattern0 = Pattern.compile("~~~([-_A-Za-z0-9]{1,10})~~~");
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
        ad.g = pattern0;
    }

    public static Locale a() {
        Locale locale0 = ad.e;
        if(locale0 == null) {
            locale0 = ad.b();
            ad.e = locale0;
        }
        return locale0;
    }

    public static Locale a(String s) {
        String[] arr_s = s.split("[-_]");
        return arr_s.length <= 1 ? new Locale(s) : new Locale(arr_s[0], arr_s[1]);
    }

    private static void a(Context context0) {
        if(context0 == null) {
            return;
        }
        context0.getResources();
    }

    public static void a(Class class0) {
        ad.f.add(class0);
    }

    public static void a(Locale locale0) {
        ad.e = locale0;
    }

    public static Locale b() {
        return ad.a(ad.c());
    }

    public static void b(String s) {
        Locale locale0 = ad.a(s);
        Locale.setDefault(locale0);
        d.a(null, locale0);
        ad.a(ar.f);
        ad.a(ar.e);
        ad.a(MainService.context);
        la.a(("Loaded locale: " + s));
        ad.f();
        if(!s.equals(ad.b)) {
            ad.b = s;
            qk.a();
        }
    }

    public static String c() {
        try {
            return Tools.s().getString("locale", Locale.getDefault().toString());
        }
        catch(Throwable throwable0) {
            la.c("Failed get locale", throwable0);
            return "";
        }
    }

    public static void c(String s) {
        new qw().a("locale", s).commit();
        ad.b(s);
    }

    public static void d() {
        try {
            ad.b(ad.c());
        }
        catch(Throwable throwable0) {
            la.c("Failed load locale", throwable0);
        }
    }

    public static String[] e() {
        Locale[] arr_locale1;
        String[] arr_s = b.a;
        SharedPreferences sharedPreferences0 = Tools.s();
        if(!sharedPreferences0.getBoolean("crashed-vm", false)) {
            sharedPreferences0.edit().putBoolean("crashed-vm", true).commit();
            arr_s = Tools.e().getAssets().getLocales();
            sharedPreferences0.edit().remove("crashed-vm").commit();
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add("");
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            if(s != null && !arrayList0.contains(s)) {
                arrayList0.add(s);
            }
        }
        if(sharedPreferences0.getBoolean("crashed-vm2", false)) {
            arr_locale1 = null;
        }
        else {
            sharedPreferences0.edit().putBoolean("crashed-vm2", true).commit();
            Locale[] arr_locale = Locale.getAvailableLocales();
            sharedPreferences0.edit().remove("crashed-vm2").commit();
            arr_locale1 = arr_locale;
        }
        if(arr_locale1 != null) {
            for(int v1 = 0; v1 < arr_locale1.length; ++v1) {
                Locale locale0 = arr_locale1[v1];
                if(locale0 != null) {
                    String s1 = locale0.getCountry();
                    String s2 = locale0.getLanguage();
                    String s3 = s1 != null && s1.length() != 0 ? String.valueOf(s2) + '_' + s1 : s2;
                    if(s1 != null && s1.length() != 0) {
                        s2 = String.valueOf(s2) + '-' + s1;
                    }
                    if(!arrayList0.contains(s3) && !arrayList0.contains(s2)) {
                        if(Build.VERSION.SDK_INT < 21) {
                            s2 = s3;
                        }
                        arrayList0.add(s2);
                    }
                }
            }
        }
        if(ad.g != null) {
            try {
                ZipFile zipFile0 = new ZipFile(Tools.e().getPackageResourcePath());
                InputStream inputStream0 = zipFile0.getInputStream(zipFile0.getEntry("resources.arsc"));
                byte[] arr_b = new byte[0x400];
                int v2;
                for(String s4 = ""; (v2 = inputStream0.read(arr_b)) != -1; s4 = s5.substring(0, Math.min(40, s5.length()))) {
                    String s5 = new String(arr_b, 0, v2, Charset.forName("US-ASCII"));
                    if(s5.indexOf(0x7E) != -1) {
                        Matcher matcher0 = ad.g.matcher(s4 + s5);
                        while(matcher0.find()) {
                            String s6 = matcher0.group(1);
                            String s7 = s6.replace('_', '-');
                            if(!arrayList0.contains(s6) && !arrayList0.contains(s7)) {
                                if(Build.VERSION.SDK_INT >= 21) {
                                    s6 = s7;
                                }
                                arrayList0.add(s6);
                            }
                        }
                    }
                }
                inputStream0.close();
                zipFile0.close();
                return (String[])arrayList0.toArray(new String[arrayList0.size()]);
            }
            catch(Throwable throwable0) {
                la.c("Failed load locales from apk", throwable0);
                return (String[])arrayList0.toArray(new String[arrayList0.size()]);
            }
        }
        return (String[])arrayList0.toArray(new String[arrayList0.size()]);
    }

    private static void f() {
        for(Object object0: ad.f) {
            Class class0 = (Class)object0;
            try {
                class0.getMethod("updateLocale", null).invoke(null, null);
            }
            catch(Throwable throwable0) {
                la.b(("Failed call updateLocale for " + class0.getName()), throwable0);
            }
        }
    }
}

