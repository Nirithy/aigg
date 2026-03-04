package android.fix;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.ext.MainService;
import android.ext.Tools;
import android.ext.la;
import android.ext.qv;
import android.ext.rx;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import java.io.File;

public class a extends Activity {
    private View a;
    private AlertDialog b;
    private Context c;

    public a() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    private void a() {
        try {
            if(this.b != null) {
                this.b.dismiss();
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    protected void attachBaseContext(Context context0) {
        super.attachBaseContext(d.c(context0));
    }

    private Context b() {
        if(this.c == null) {
            Context context0 = this.getBaseContext();
            if(context0 == null) {
                return null;
            }
            this.c = d.c(context0);
        }
        return this.c;
    }

    @Override  // android.app.Activity
    public View findViewById(int v) {
        return this.a == null ? super.findViewById(v) : this.a.findViewById(v);
    }

    @Override  // android.app.Activity
    public void finish() {
        this.a();
        this.l();
    }

    @Override  // android.view.ContextThemeWrapper
    public AssetManager getAssets() {
        Context context0 = this.b();
        return context0 == null ? super.getAssets() : context0.getAssets();
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
        catch(SecurityException securityException0) {
            la.a(securityException0);
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
        catch(SecurityException securityException0) {
            la.a(securityException0);
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
    public String getPackageName() [...] // 潜在的解密器

    @Override  // android.view.ContextThemeWrapper
    public Resources getResources() {
        Context context0 = this.b();
        return context0 == null ? super.getResources() : context0.getResources();
    }

    @Override  // android.content.ContextWrapper
    public SharedPreferences getSharedPreferences(String s, int v) {
        return qv.a(super.getSharedPreferences(s, v));
    }

    @Override  // android.app.Activity
    public Object getSystemService(String s) {
        try {
            return k.a(super.getSystemService(s));
        }
        catch(NullPointerException nullPointerException0) {
            la.a(nullPointerException0);
            return null;
        }
    }

    public void l() {
        try {
            super.finish();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        try {
            this.a();
            return super.moveTaskToBack(z);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            this.finish();
            return true;
        }
    }

    @Override  // android.app.Activity
    protected void onCreate(Bundle bundle0) {
        try {
            super.onCreate(bundle0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    public void onCreate(Bundle bundle0, PersistableBundle persistableBundle0) {
        try {
            super.onCreate(bundle0, persistableBundle0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    public void onDestroy() {
        this.a();
        try {
            super.onDestroy();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    public void onLowMemory() {
        la.a("Activity onLowMemory");
        super.onLowMemory();
        MainService.b(-1);
    }

    @Override  // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    protected void onPostCreate(Bundle bundle0) {
        try {
            super.onPostCreate(bundle0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    protected void onPostResume() {
        try {
            super.onPostResume();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    protected void onRestart() {
        try {
            super.onRestart();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    protected void onResume() {
        try {
            super.onResume();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Activity
    public void onTrimMemory(int v) {
        la.a(("Activity onTrimMemory: " + v));
        super.onTrimMemory(v);
        MainService.b(v);
    }

    @Override  // android.app.Activity
    public void setContentView(int v) {
        RuntimeException runtimeException1;
        try {
            runtimeException1 = new RuntimeException();
            super.setContentView(v);
        }
        catch(RuntimeException runtimeException0) {
            if(runtimeException1 == runtimeException0) {
                goto label_7;
            }
            else {
                try {
                    la.c("Failed call super setContentView", runtimeException0);
                    goto label_8;
                label_7:
                    runtimeException1 = runtimeException0;
                    try {
                    label_8:
                        this.getWindow().setContentView(v);
                    }
                    catch(RuntimeException runtimeException3) {
                        if(runtimeException1 == runtimeException3) {
                            runtimeException1 = runtimeException3;
                        }
                        else {
                            la.c("Failed fix call setContentView", runtimeException3);
                        }
                        if(Build.VERSION.SDK_INT >= 19) {
                            runtimeException0.addSuppressed(runtimeException3);
                        }
                        throw runtimeException0;
                    }
                    if(Build.VERSION.SDK_INT >= 11) {
                        try {
                            this.getActionBar();
                            goto label_43;
                        }
                        catch(RuntimeException runtimeException4) {
                        }
                        if(runtimeException1 == runtimeException4) {
                            goto label_42;
                        }
                        else {
                            la.c("Failed call setup action bar", runtimeException4);
                        }
                    }
                    goto label_43;
                }
                catch(RuntimeException runtimeException2) {
                    goto label_26;
                }
            }
            goto label_8;
            try {
            label_26:
                View view0 = i.a(v, null);
                this.a = view0;
                AlertDialog alertDialog0 = android.ext.i.a(this).setView(view0).setTitle(this.getTitle()).setCancelable(false).create();
                try {
                    alertDialog0.setOnCancelListener(new c(this));
                    alertDialog0.setCancelable(true);
                }
                catch(Throwable throwable1) {
                    la.a(throwable1);
                }
                this.b = alertDialog0;
                alertDialog0.show();
                goto label_43;
            }
            catch(Throwable throwable0) {
                la.c("Failed fix call setContentView", throwable0);
                if(Build.VERSION.SDK_INT >= 19) {
                    runtimeException2.addSuppressed(throwable0);
                }
                throw runtimeException2;
            }
        label_42:
            runtimeException1 = runtimeException4;
        }
    label_43:
        if(la.b(runtimeException1).contains("catch_.me_.if_.you_.can_")) {
            this.a = null;
            super.setContentView(v - 1);
        }
    }

    @Override  // android.app.Activity
    public void startActivity(Intent intent0) {
        try {
            super.startActivity(intent0);
        }
        catch(SecurityException securityException0) {
            if(intent0.getAction().equals("android.intent.action.UNINSTALL_PACKAGE")) {
                intent0.setAction("android.intent.action.DELETE");
                this.startActivity(intent0);
                return;
            }
            if(!intent0.getAction().equals("android.intent.action.INSTALL_PACKAGE")) {
                throw securityException0;
            }
            intent0.setAction("android.intent.action.VIEW");
            this.startActivity(intent0);
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            la.a(activityNotFoundException0);
        }
        catch(RuntimeException runtimeException0) {
            if(!d.a(runtimeException0, this, intent0)) {
                throw runtimeException0;
            }
        }
    }

    @Override  // android.app.Activity
    public void startActivityForResult(Intent intent0, int v) {
        try {
            super.startActivityForResult(intent0, v);
        }
        catch(SecurityException securityException0) {
            if(intent0.getAction().equals("android.intent.action.UNINSTALL_PACKAGE")) {
                intent0.setAction("android.intent.action.DELETE");
                this.startActivityForResult(intent0, v);
                return;
            }
            if(!intent0.getAction().equals("android.intent.action.INSTALL_PACKAGE")) {
                throw securityException0;
            }
            intent0.setAction("android.intent.action.VIEW");
            this.startActivityForResult(intent0, v);
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            la.a(activityNotFoundException0);
        }
        catch(RuntimeException runtimeException0) {
            String s = runtimeException0.getMessage();
            if(rx.c() || s == null || !s.contains("Looper.prepare()")) {
                throw runtimeException0;
            }
            rx.a(new b(this, intent0, v));
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
}

