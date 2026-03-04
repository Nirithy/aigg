package android.fix;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.ext.ConfigListAdapter;
import android.ext.Tools;
import android.ext.la;
import android.ext.qv;
import android.ext.rx;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

public class d extends ContextThemeWrapper {
    private static volatile boolean a;
    private static Configuration b;
    private static Locale c;
    private Configuration d;
    private Resources e;

    static {
        d.a = true;
        d.b = null;
        d.c = Locale.getDefault();
    }

    public d(Context context0) {
        super(context0, 0x7F090004);  // style:FixTheme
        this.d = null;
        this.e = null;
    }

    public static Configuration a(Configuration configuration0) {
        Configuration configuration1 = d.b(configuration0);
        d.a(configuration1, null);
        return configuration1;
    }

    public static void a(Configuration configuration0, Locale locale0) {
        if(locale0 != null) {
            d.c = locale0;
        }
        Configuration configuration1 = configuration0 == null ? d.b : configuration0;
        if(configuration1 == null) {
            configuration1 = Tools.e().getResources().getConfiguration();
        }
        Configuration configuration2 = d.b(configuration1);
        if(!configuration2.equals(d.b)) {
            d.b = configuration2;
        }
    }

    public static boolean a() {
        return d.a;
    }

    private boolean a(Intent intent0) {
        String[] arr_s = {"am", "start", intent0.toUri(5)};
        la.b(("Try exec intent: " + intent0 + "; " + Arrays.toString(arr_s)));
        try {
            Process process0 = Tools.a(arr_s);
            process0.getInputStream().close();
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(process0.getErrorStream()));
            StringBuilder stringBuilder0 = new StringBuilder();
            String s;
            while((s = bufferedReader0.readLine()) != null) {
                stringBuilder0.append(s);
                stringBuilder0.append('\n');
            }
            bufferedReader0.close();
            if(stringBuilder0.length() > 0) {
                la.b(("Failed exec intent: " + intent0 + "; " + Arrays.toString(arr_s) + ":\n" + stringBuilder0.toString()));
                return false;
            }
            return true;
        }
        catch(Throwable throwable0) {
            la.b(("Failed exec intent: " + intent0 + "; " + Arrays.toString(arr_s)), throwable0);
            return false;
        }
    }

    public static boolean a(Throwable throwable0, Context context0, Intent intent0) {
        String s = throwable0.getMessage();
        if(!rx.c() && s != null && s.contains("Looper.prepare()")) {
            rx.a(new f(context0, intent0));
            return true;
        }
        return false;
    }

    public static Configuration b(Configuration configuration0) {
        ConfigListAdapter.a(configuration0, d.c);
        return new Configuration(configuration0);
    }

    public static d b(Context context0) {
        try {
            Class.forName("com.wobian.wv.wb.WBContext");
            return new e(context0);
        }
        catch(Throwable unused_ex) {
            return new d(context0);
        }
    }

    @Override  // android.content.ContextWrapper
    public boolean bindService(Intent intent0, ServiceConnection serviceConnection0, int v) {
        try {
            return super.bindService(intent0, serviceConnection0, v);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            la.a(illegalArgumentException0);
            return false;
        }
    }

    public static Context c(Context context0) {
        return context0 != null && !(context0 instanceof d) ? d.b(context0) : context0;
    }

    public static void d(Context context0) {
        if(context0 instanceof d) {
            d d0 = (d)context0;
            try {
                LayoutInflater.from(d0);
            }
            catch(AssertionError assertionError0) {
                try {
                    LayoutInflater.from(d0.getBaseContext());
                    la.c("Failed use fix for LayoutInflater", assertionError0);
                    d.a = false;
                }
                catch(AssertionError assertionError1) {
                    la.c("Can not get LayoutInflater", assertionError1);
                }
            }
            la.c("Check LayoutInflater - ok");
        }
    }

    @Override  // android.view.ContextThemeWrapper
    public AssetManager getAssets() {
        return this.getResources().getAssets();
    }

    @Override  // android.content.ContextWrapper
    public File getCacheDir() {
        try {
            return super.getCacheDir();
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
            return Tools.h();
        }
    }

    @Override  // android.content.ContextWrapper
    public File getExternalCacheDir() {
        try {
            return super.getExternalCacheDir();
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
            return null;
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
            return null;
        }
    }

    @Override  // android.content.ContextWrapper
    public File getExternalFilesDir(String s) {
        try {
            return super.getExternalFilesDir(s);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
            return null;
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
            return null;
        }
    }

    @Override  // android.content.ContextWrapper
    public File getFilesDir() {
        try {
            return super.getFilesDir();
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
            return Tools.i();
        }
    }

    @Override  // android.content.ContextWrapper
    public PackageManager getPackageManager() {
        try {
            return super.getPackageManager();
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
            return Tools.m();
        }
    }

    @Override  // android.content.ContextWrapper
    public String getPackageName() {
        try {
            return super.getPackageName();
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
            return Tools.g();
        }
    }

    @Override  // android.view.ContextThemeWrapper
    public Resources getResources() {
        Resources resources0 = null;
        Configuration configuration0 = d.b;
        Configuration configuration1 = this.d;
        Resources resources1 = this.e;
        if(configuration1 != configuration0 || resources1 != null && !resources1.getConfiguration().equals(configuration1)) {
            this.d = configuration0;
            Resources resources2 = super.getResources();
            if(configuration0 == null) {
                resources1 = resources2;
            }
            else {
                try {
                    resources2.updateConfiguration(configuration0, null);
                    if(resources1 != null && resources1 != resources2) {
                        resources1.updateConfiguration(configuration0, null);
                    }
                }
                catch(Throwable throwable0) {
                    la.c("Failed set locale", throwable0);
                }
                if(Build.VERSION.SDK_INT >= 17) {
                    try {
                        resources0 = this.createConfigurationContext(configuration0);
                    }
                    catch(Throwable throwable1) {
                        la.a(throwable1);
                    }
                }
                resources1 = resources0 == null ? resources2 : ((Context)resources0).getResources();
            }
            resources0 = resources2;
        }
        if(resources1 == null) {
            resources1 = resources0 == null ? super.getResources() : resources0;
        }
        this.e = resources1;
        return resources1;
    }

    @Override  // android.content.ContextWrapper
    public SharedPreferences getSharedPreferences(String s, int v) {
        return qv.a(super.getSharedPreferences(s, v));
    }

    @Override  // android.view.ContextThemeWrapper
    public Object getSystemService(String s) {
        return k.a(super.getSystemService(s));
    }

    @Override  // android.content.ContextWrapper
    public void startActivity(Intent intent0) {
        try {
            super.startActivity(intent0);
        }
        catch(Throwable throwable0) {
            if((intent0 == null || !"android.intent.action.WEB_SEARCH".equals(intent0.getAction())) && !d.a(throwable0, this, intent0) && !this.a(intent0)) {
                throw throwable0;
            }
        }
    }

    @Override  // android.content.ContextWrapper
    public boolean startInstrumentation(ComponentName componentName0, String s, Bundle bundle0) {
        try {
            return super.startInstrumentation(componentName0, s, bundle0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.content.ContextWrapper
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver0) {
        try {
            super.unregisterReceiver(broadcastReceiver0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            la.a(illegalArgumentException0);
        }
    }
}

