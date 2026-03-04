package android.ext;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.c.a;
import android.c.b;
import android.c.e;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.fix.i;
import android.fix.l;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.lang.ProcessBuilder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.IBinder;
import android.provider.Settings;
import android.system.Os;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.text.style.ForegroundColorSpan;
import android.util.StateSet;
import android.view.ContextThemeWrapper;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import catch_.me_.if_.you_.can_.R.raw;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    public static final Random a;
    static volatile int b;
    static InputMethodManager c;
    static volatile String[] d;
    private static int e;
    private static float f;
    private static volatile int g;
    private static Pattern h;
    private static String i;
    private static String j;
    private static String k;
    private static volatile PackageManager l;
    private static volatile String m;
    private static String n;
    private static final tq o;
    private static int[] p;
    private static volatile Object q;
    private static volatile WeakReference r;
    private static int s;
    private static WeakReference t;
    private static volatile boolean u;
    private static volatile byte v;
    private static volatile int w;

    static {
        Tools.a = new Random(System.currentTimeMillis());
        Tools.e = Build.VERSION.SDK_INT < 23 ? 1 : -1;
        Tools.f = 0.0f;
        Tools.g = -1;
        Tools.b = -1;
        Tools.h = Pattern.compile("(\\d+)");
        Tools.i = null;
        Tools.j = null;
        Tools.k = null;
        Tools.l = null;
        Tools.m = null;
        Tools.n = null;
        Tools.o = new tq(null);
        Tools.p = new int[]{0x7F070175, 60, 0x7F070174, 60, 0x7F070173, 24, 0x7F070172, 365, 0x7F070171, -1};  // string:unit_seconds_short "sec"
        Tools.q = null;
        Tools.r = new WeakReference(null);
        Tools.s = 0;
        Tools.t = new WeakReference(null);
        Tools.u = false;
        Tools.v = 0;
        Tools.d = null;
        Tools.w = -1;
    }

    public static float a(float f) {
        float f1 = Tools.f;
        if(f1 == 0.0f) {
            Context context0 = Tools.e();
            if(context0 != null) {
                f1 = context0.getResources().getDisplayMetrics().density;
            }
        }
        if(f1 == 0.0f) {
            f1 = 1.0f;
        }
        return f1 * f;
    }

    public static int a(Object object0) {
        int v2;
        if(object0 != null) {
            if(object0 instanceof a) {
                a a0 = (a)object0;
                int v = a0.b();
                v2 = 0;
                for(int v1 = 0; v1 < v; ++v1) {
                    try {
                        if(a0.b(v1)) {
                            ++v2;
                        }
                    }
                    catch(IndexOutOfBoundsException unused_ex) {
                    }
                }
                return v2;
            }
            if(object0 instanceof e) {
                int v3 = ((e)object0).b();
                v2 = 0;
                for(int v4 = 0; v4 < v3; ++v4) {
                    if(((e)object0).d(v4)) {
                        ++v2;
                    }
                }
                return v2;
            }
            if(!(object0 instanceof boolean[])) {
                throw new IllegalArgumentException();
            }
            int v5 = ((boolean[])object0).length - 1;
            v2 = 0;
            for(int v6 = 1; v6 < v5; ++v6) {
                if(((boolean[])object0)[v6]) {
                    ++v2;
                }
            }
            return v2;
        }
        return 0;
    }

    public static int a(Process process0) {
        try {
            Field field0 = process0.getClass().getDeclaredField("pid");
            field0.setAccessible(true);
            int v = field0.getInt(process0);
            field0.setAccessible(false);
            return v;
        }
        catch(Throwable unused_ex) {
            return -1;
        }
    }

    public static int a(byte[] arr_b, byte[] arr_b1) {
        if(arr_b.length == 0) {
            return -1;
        }
        int[] arr_v = Tools.b(arr_b1);
        int v = 0;
        for(int v1 = 0; true; v1 = v2) {
            if(v >= arr_b.length) {
                return -1;
            }
            int v2;
            for(v2 = v1; v2 > 0 && arr_b1[v2] != arr_b[v]; v2 = arr_v[v2 - 1]) {
            }
            if(arr_b1[v2] == arr_b[v]) {
                ++v2;
            }
            if(v2 == arr_b1.length) {
                return v - arr_b1.length + 1;
            }
            ++v;
        }
    }

    public static AlertDialog a(AlertDialog alertDialog0) {
        try {
            TextView textView0 = (TextView)alertDialog0.findViewById(0x102000B);
            if(textView0 != null) {
                Tools.a(textView0, textView0.getText().toString());
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
        return alertDialog0;
    }

    public static Intent a(Context context0, String s, String s1) {
        if(context0 == null) {
            context0 = Tools.e();
        }
        Intent intent0 = context0.getPackageManager().getLaunchIntentForPackage(s);
        if(intent0 == null) {
            intent0 = new Intent("android.intent.action.MAIN");
        }
        intent0.setPackage(s);
        if(s1 != null) {
            intent0.setClassName(s, s1);
        }
        intent0.setFlags(0x10000000);
        return intent0;
    }

    private static tn a(Class class0, tn[] arr_tn) {
        tn tn1;
        tn tn0;
        try {
            int v = Build.VERSION.SDK_INT <= 15 ? 1 : 0;
            tn0 = arr_tn[v].a();
        }
        catch(NoSuchMethodException unused_ex) {
            tn0 = null;
            int v1 = 0;
            while(v1 < arr_tn.length) {
                if(v1 == v) {
                    tn1 = tn0;
                }
                else {
                    try {
                        tn1 = tn0;
                        tn1 = arr_tn[v1].a();
                    }
                    catch(NoSuchMethodException unused_ex) {
                    }
                }
                ++v1;
                tn0 = tn1;
            }
        }
        if(tn0 == null) {
            la.a(("Methods: " + Arrays.toString(class0.getMethods())));
        }
        return tn0;
    }

    public static tp a(ListView listView0) {
        int v = listView0.getFirstVisiblePosition();
        try {
            View view0 = listView0.getChildAt(0);
            return view0 == null ? new tp(v, 0) : new tp(v, view0.getTop() - listView0.getPaddingTop());
        }
        catch(ArrayIndexOutOfBoundsException unused_ex) {
            return new tp(v, 0);
        }
    }

    public static Drawable a(Drawable drawable0) {
        if(drawable0 == null) {
            return null;
        }
        else {
            try {
                Drawable.ConstantState drawable$ConstantState0 = drawable0.getConstantState();
                return drawable$ConstantState0 == null ? drawable0 : drawable$ConstantState0.newDrawable();
            }
            catch(Throwable throwable0) {
            }
        }
        la.a(throwable0);
        return drawable0;
    }

    public static Drawable a(Drawable drawable0, int v) {
        Throwable throwable1;
        BitmapDrawable bitmapDrawable0;
        Bitmap bitmap0;
        try {
            if(!(drawable0 instanceof BitmapDrawable)) {
                return drawable0;
            }
            bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
            if(bitmap0 == null || bitmap0.getWidth() <= v + 4 && bitmap0.getHeight() <= v + 4) {
                return drawable0;
            }
            bitmapDrawable0 = new BitmapDrawable(Tools.e().getResources(), Bitmap.createScaledBitmap(bitmap0, v, v, false));
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            la.a(throwable1);
            return drawable0;
        }
        try {
            la.a(("getResized: " + bitmap0.getWidth() + 'x' + bitmap0.getHeight() + " -> " + v + 'x' + v + " in " + 0L));
            return bitmapDrawable0;
        }
        catch(Throwable throwable1) {
            drawable0 = bitmapDrawable0;
        }
        la.a(throwable1);
        return drawable0;
    }

    public static View a(String s, String s1, int v) {
        View view0 = i.a(0x7F040001, null);  // layout:dialog_title
        TextView textView0 = (TextView)view0.findViewById(0x7F0B0006);  // id:alertTitle
        textView0.setText(s);
        if(v != -1 && v != 0) {
            Tools.j(textView0);
            textView0.setOnClickListener(new sw(s, v));
        }
        if(s1 != null) {
            TextView textView1 = (TextView)view0.findViewById(0x7F0B0007);  // id:subTitle
            textView1.setText(s1);
            textView1.setVisibility(0);
        }
        return view0;
    }

    public static WindowManager.LayoutParams a(WindowManager.LayoutParams windowManager$LayoutParams0) {
        boolean z = false;
        if((Config.B & 2) == 0) {
            windowManager$LayoutParams0.flags &= 0xFEFFFFFF;
        }
        else {
            windowManager$LayoutParams0.flags |= 0x1000000;
        }
        if(rv.a) {
            if(Tools.e == -1) {
                Tools.e = Tools.a(Tools.e()) ? 1 : 0;
            }
            if(Tools.e == 0) {
                la.a("canDrawOverlays = false; fixed");
            }
            else {
                z = true;
            }
        }
        if(!z) {
            windowManager$LayoutParams0.type = 2;
            IBinder iBinder0 = ar.d.getWindow().getAttributes().token;
            if(iBinder0 == null) {
                iBinder0 = ar.d.getWindow().getDecorView().getRootView().getWindowToken();
            }
            windowManager$LayoutParams0.token = iBinder0;
            return windowManager$LayoutParams0;
        }
        if(windowManager$LayoutParams0.type == 0x7F6 && windowManager$LayoutParams0.token != null) {
            la.a(("token: null " + windowManager$LayoutParams0.token));
            windowManager$LayoutParams0.token = null;
            return windowManager$LayoutParams0;
        }
        return windowManager$LayoutParams0;
    }

    public static CharSequence a(CharSequence charSequence0) {
        if(charSequence0 instanceof Spannable) {
            tk[] arr_tk = (tk[])Tools.r.get();
            if(arr_tk == null) {
                arr_tk = new tk[]{new tk(d.i(1), d.k(1)), new tk(d.i(2), d.k(2)), new tk(d.i(4), d.k(4)), new tk(d.i(8), d.k(8)), new tk(d.i(16), d.k(16)), new tk(d.i(0x20), d.k(0x20)), new tk(d.i(0x40), d.k(0x40)), new tk(qk.a(0x7F070241), Tools.e(0x7F0A000E)), new tk(qk.a(0x7F070242), Tools.e(0x7F0A000F)), new tk(qk.a(0x7F070243), Tools.e(0x7F0A0010)), new tk(qk.a(0x7F070244), Tools.e(0x7F0A000D))};  // string:executable "executable"
                Tools.r = new WeakReference(arr_tk);
            }
            for(int v = 0; v < arr_tk.length; ++v) {
                Tools.a(charSequence0, arr_tk[v].a, arr_tk[v].b);
            }
        }
        return charSequence0;
    }

    public static CharSequence a(CharSequence charSequence0, int v) {
        Spannable spannable0;
        try {
            if(charSequence0 instanceof Spannable) {
                spannable0 = (Spannable)charSequence0;
            }
            else {
                spannable0 = new SpannableString(charSequence0);
                if(!(spannable0 instanceof CharSequence)) {
                    la.a(new RuntimeException("Class \'android.text.SpannableString\' does not implement interface \'java.lang.CharSequence\'"));
                    return charSequence0;
                }
            }
            spannable0.setSpan(new ForegroundColorSpan(v), 0, charSequence0.length(), 33);
            return spannable0;
        }
        catch(Throwable throwable0) {
            la.b("Failed colorize", throwable0);
            return charSequence0;
        }
    }

    public static CharSequence a(CharSequence charSequence0, CharSequence charSequence1, int v) {
        try {
            if(charSequence0 instanceof Spannable) {
                int v1 = charSequence1.length();
                int v2 = 0;
                String s = charSequence0.toString();
                String s1 = charSequence1.toString();
                int v3;
                while((v3 = s.indexOf(s1, v2)) >= 0) {
                    v2 = v3 + v1;
                    ((Spannable)charSequence0).setSpan(new ForegroundColorSpan(v), v3, v3 + v1, 33);
                }
            }
        }
        catch(Throwable throwable0) {
            la.b("Failed colorize text", throwable0);
        }
        return charSequence0;
    }

    public static CharSequence a(CharSequence[] arr_charSequence) {
        try {
            return TextUtils.concat(arr_charSequence);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v = 0; v < arr_charSequence.length; ++v) {
                stringBuilder0.append(arr_charSequence[v]);
            }
            return stringBuilder0.toString();
        }
    }

    public static Process a(String[] arr_s) {
        return Tools.a(arr_s, null, null);
    }

    public static Process a(String[] arr_s, String[] arr_s1) {
        return Tools.a(arr_s, arr_s1, null);
    }

    public static Process a(String[] arr_s, String[] arr_s1, File file0) {
        if(!Tools.u) {
            try {
                return Runtime.getRuntime().exec(arr_s, arr_s1, file0);
            }
            catch(Throwable throwable0) {
                String s = throwable0.getMessage();
                if(!s.contains("nknown error") && !s.contains("xec failed") && !s.contains("ead failed")) {
                    throw throwable0;
                }
                la.b(("Failed exec: " + Arrays.toString(arr_s) + "; " + arr_s1 + "; " + file0), throwable0);
            }
        }
        Process process0 = ProcessBuilder.a(arr_s, arr_s1, file0);
        Tools.u = true;
        return process0;
    }

    public static String a(double f) {
        long v3;
        StringBuilder stringBuilder0 = new StringBuilder();
        long v = Math.abs(((long)f));
        int v1 = 0;
        while(v1 < Tools.p.length) {
            int v2 = Tools.p[v1 + 1];
            if(v2 <= 0) {
                v3 = 0L;
            }
            else {
                v3 = v / ((long)v2);
                v %= (long)v2;
            }
            if(v >= 0L) {
                if(stringBuilder0.length() > 0) {
                    stringBuilder0.insert(0, ":");
                }
                if(v1 == 0) {
                    stringBuilder0.insert(0, Tools.a("%f", new Object[]{((double)(Math.abs(f) % ((double)v2)))}).replaceFirst("\\D?0+$", ""));
                }
                else {
                    stringBuilder0.insert(0, v);
                }
            }
            if(v3 == 0L) {
                break;
            }
            v1 += 2;
            v = v3;
        }
        if(stringBuilder0.length() == 0) {
            stringBuilder0.insert(0, "0");
        }
        if(f < 0.0) {
            stringBuilder0.insert(0, "-");
        }
        return stringBuilder0.toString();
    }

    public static String a(long v) {
        long v4;
        StringBuilder stringBuilder0 = new StringBuilder();
        long v1 = Math.abs(v);
        int v2 = 0;
        while(v2 < Tools.p.length) {
            int v3 = Tools.p[v2 + 1];
            if(v3 <= 0) {
                v4 = 0L;
            }
            else {
                v4 = v1 / ((long)v3);
                v1 %= (long)v3;
            }
            if(v1 > 0L) {
                if(stringBuilder0.length() > 0) {
                    stringBuilder0.insert(0, " ");
                }
                stringBuilder0.insert(0, qk.a(Tools.p[v2]));
                stringBuilder0.insert(0, " ");
                stringBuilder0.insert(0, v1);
            }
            if(v4 == 0L) {
                break;
            }
            v2 += 2;
            v1 = v4;
        }
        if(stringBuilder0.length() == 0) {
            stringBuilder0.insert(0, qk.a(Tools.p[0]));
            stringBuilder0.insert(0, "0 ");
        }
        if(v < 0L) {
            stringBuilder0.insert(0, "-");
        }
        return stringBuilder0.toString();
    }

    private static String a(long v, boolean z) {
        String s1;
        float f = (float)v;
        String s = "B";
        if(f > 900.0f) {
            s = "KB";
            f /= 1024.0f;
        }
        if(f > 900.0f) {
            s = "MB";
            f /= 1024.0f;
        }
        if(f > 900.0f) {
            s = "GB";
            f /= 1024.0f;
        }
        if(f > 900.0f) {
            s = "TB";
            f /= 1024.0f;
        }
        if(f > 900.0f) {
            f /= 1024.0f;
            s1 = "PB";
        }
        else {
            s1 = s;
        }
        if(f < 1.0f) {
            return Tools.a("%.2f", new Object[]{f}) + ' ' + s1;
        }
        if(f < 10.0f) {
            return z ? Tools.a("%.1f", new Object[]{f}) + ' ' + s1 : Tools.a("%.2f", new Object[]{f}) + ' ' + s1;
        }
        return f < 100.0f && !z ? Tools.a("%.2f", new Object[]{f}) + ' ' + s1 : Tools.a("%.0f", new Object[]{f}) + ' ' + s1;
    }

    public static String a(Context context0, long v) {
        try {
            return Formatter.formatFileSize(context0, v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            try {
                return Tools.a(v, false);
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
                return Long.toString(v);
            }
        }
    }

    public static String a(ApplicationInfo applicationInfo0) {
        CharSequence charSequence0;
        boolean z;
        PackageManager packageManager0 = Tools.l;
        if(applicationInfo0 == null || packageManager0 == null) {
            return null;
        }
        try {
            z = ca.a(applicationInfo0.packageName, "label");
            try {
                charSequence0 = applicationInfo0.loadLabel(packageManager0);
            }
            catch(Throwable throwable1) {
                ca.a(z);
                throw throwable1;
            }
        }
        catch(Throwable throwable0) {
            charSequence0 = null;
            la.c(("Failed load label for: " + applicationInfo0.packageName), throwable0);
            return charSequence0 == null ? null : charSequence0.toString();
        }
        try {
            ca.a(z);
            if(charSequence0 == null) {
                boolean z1 = ca.a(applicationInfo0.packageName, "label2");
                try {
                    charSequence0 = packageManager0.getApplicationLabel(applicationInfo0);
                }
                finally {
                    ca.a(z1);
                }
                return charSequence0 == null ? null : charSequence0.toString();
            }
            return charSequence0 == null ? null : charSequence0.toString();
        }
        catch(Throwable throwable0) {
        }
        la.c(("Failed load label for: " + applicationInfo0.packageName), throwable0);
        return charSequence0 == null ? null : charSequence0.toString();
    }

    public static String a(String s, String s1, String s2, Object object0) {
        String s3;
        try {
            s3 = String.format(ad.a(), s, object0);
        }
        catch(Throwable throwable0) {
            s3 = null;
            la.b("Format fail 1", throwable0);
        }
        if(s3 == null) {
            try {
                String s4 = String.format(ad.a(), s1, object0);
                return s4 == null ? s2 : s4;
            }
            catch(Throwable throwable1) {
                la.b("Format fail 2", throwable1);
            }
        }
        return s3 == null ? s2 : s3;
    }

    public static String a(String s, Object[] arr_object) {
        String s1;
        try {
            s1 = String.format(ad.a(), s.replace('，', ','), arr_object);
            return s1 == null ? "Failed call String.format" : s1;
        }
        catch(Throwable throwable0) {
            String s2 = "Failed String.format(\'" + s + "\', " + Arrays.toString(arr_object) + ") with \'" + ad.a() + "\' (" + qk.a(0x7F070083) + ") " + Config.a(0x7F0B00B1).d;  // string:lang_code "~~~en_US~~~"
            la.c(s2, throwable0);
            ho.b((s2 + "\n\n" + la.b(throwable0)));
            if(s != null && arr_object != null) {
                String[] arr_s = s.split("%(\\d+\\$)?([\\-#+ 0;\\(])?(\\d+)?(\\.\\d+)?([bBhHsScCdoxXeEfgGaA]|[tT][HIklMSLNpzZsQBbhAaCYyjmdeRTrDFc])", arr_object.length + 1);
                StringBuilder stringBuilder0 = new StringBuilder();
                for(int v = 0; v < arr_object.length; ++v) {
                    if(v < arr_s.length) {
                        stringBuilder0.append(arr_s[v]);
                    }
                    stringBuilder0.append(arr_object[v]);
                }
                if(arr_object.length < arr_s.length) {
                    stringBuilder0.append(arr_s[arr_object.length]);
                }
                s1 = stringBuilder0.toString().replace("%n", "\n").replace("%%", "%");
                return s1 == null ? "Failed call String.format" : s1;
            }
            return s == null ? "Failed call String.format" : s;
        }
    }

    public static final String a(byte[] arr_b) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < arr_b.length; ++v) {
            String s;
            for(s = Integer.toHexString(arr_b[v] & 0xFF).toUpperCase(Locale.US); s.length() < 2; s = "0" + s) {
            }
            stringBuilder0.append(s);
        }
        return stringBuilder0.toString();
    }

    public static String a(String[] arr_s, String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < arr_s.length; ++v) {
            String s1 = arr_s[v];
            if(stringBuilder0.length() != 0) {
                stringBuilder0.append(s);
            }
            stringBuilder0.append(s1);
        }
        return stringBuilder0.toString();
    }

    @TargetApi(23)
    static void a() {
        if(Build.VERSION.SDK_INT >= 23) {
            try {
                if(!Tools.a(Tools.e())) {
                    la.b("canDrawOverlays = false");
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        else {
            return;
        }
        la.a(throwable0);
    }

    public static void a(int v) {
        Tools.a(qk.a(v), 1);
    }

    public static void a(int v, int v1) {
        Tools.a(qk.a(v), v1);
    }

    public static void a(int v, ComponentName componentName0, int v1) {
        try {
            PackageManager packageManager0 = Tools.m();
            la.a(("hide " + v + ": " + v1 + ' ' + componentName0));
            Tools.a(componentName0.getPackageName(), null);
            packageManager0.setComponentEnabledSetting(componentName0, v1, 1);
            la.a(("hide " + (v + 1) + ": " + v1 + ' ' + componentName0));
            Tools.a(componentName0.getPackageName(), null);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    public static void a(Activity activity0) {
        try {
            Tools.g(activity0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
        try {
            Tools.g(activity0.getApplication());
        }
        catch(Throwable throwable1) {
            la.a(throwable1);
        }
        try {
            Tools.g(activity0.getApplicationContext());
        }
        catch(Throwable throwable2) {
            la.a(throwable2);
        }
    }

    public static void a(DialogInterface dialogInterface0) {
        if(dialogInterface0 == null) {
            throw new NullPointerException();
        }
        rx.a(new sv(dialogInterface0));
    }

    public static void a(Configuration configuration0) {
        int v = 0;
        if(configuration0 == null) {
            try {
                configuration0 = Tools.e().getResources().getConfiguration();
                goto label_7;
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
        }
        else {
        label_7:
            if(configuration0.orientation == 2) {
                v = 1;
            }
        }
        Tools.w = v;
    }

    public static void a(View view0) {
        rx.a(new su(view0));
    }

    public static void a(View view0, float f) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 != null) {
            viewGroup$LayoutParams0.width = (int)f;
            view0.setLayoutParams(viewGroup$LayoutParams0);
        }
    }

    public static void a(View view0, Drawable drawable0) {
        try {
            if(drawable0 == null) {
                drawable0 = new ColorDrawable(0);
            }
            view0.setFocusable(true);
            StateListDrawable stateListDrawable0 = new StateListDrawable();
            Drawable drawable1 = new ImageButton(view0.getContext()).getBackground();
            stateListDrawable0.addState(l.a, drawable1);
            stateListDrawable0.addState(l.b, drawable1);
            stateListDrawable0.addState(l.c, drawable1);
            stateListDrawable0.addState(StateSet.WILD_CARD, drawable0);
            if(Build.VERSION.SDK_INT >= 16) {
                view0.setBackground(drawable0);
            }
            else {
                view0.setBackgroundDrawable(drawable0);
            }
            int v = view0.getPaddingLeft();
            int v1 = view0.getPaddingRight();
            int v2 = view0.getPaddingTop();
            int v3 = view0.getPaddingBottom();
            if(Build.VERSION.SDK_INT >= 16) {
                view0.setBackground(stateListDrawable0);
            }
            else {
                view0.setBackgroundDrawable(stateListDrawable0);
            }
            view0.setPadding(v, v2, v1, v3);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    public static void a(View view0, View.OnFocusChangeListener view$OnFocusChangeListener0) {
        tl tl0 = (tl)view0.getTag(0x7F04000D);  // layout:memory_range
        if(tl0 == null) {
            tl0 = new tl(null);
            view0.setOnFocusChangeListener(tl0);
            view0.setTag(0x7F04000D, tl0);  // layout:memory_range
        }
        tl0.a(view$OnFocusChangeListener0);
    }

    public static void a(View view0, WindowManager.LayoutParams windowManager$LayoutParams0) {
        rx.a(new sk(windowManager$LayoutParams0, view0));
    }

    private static void a(View view0, WindowManager.LayoutParams windowManager$LayoutParams0, boolean z) {
        Tools.a(windowManager$LayoutParams0);
        rx.a(new td(z, windowManager$LayoutParams0, view0));
    }

    private static void a(ViewGroup viewGroup0) {
        if(viewGroup0 != null) {
            int v = 0;
            while(v < viewGroup0.getChildCount()) {
                try {
                    View view0 = viewGroup0.getChildAt(v);
                    if(view0 != null) {
                        view0.setSoundEffectsEnabled(false);
                        if(view0 instanceof ViewGroup) {
                            Tools.a(((ViewGroup)view0));
                        }
                    }
                    ++v;
                    continue;
                }
                catch(ArrayIndexOutOfBoundsException unused_ex) {
                }
                ++v;
            }
        }
    }

    public static void a(Window window0) {
        window0.setAttributes(Tools.a(window0.getAttributes()));
    }

    public static void a(Window window0, View view0, boolean z) {
        InputMethodManager inputMethodManager0 = (InputMethodManager)Tools.e().getSystemService("input_method");
        int v = window0.getAttributes().softInputMode & -16;
        if(z) {
            window0.clearFlags(0x20000);
            window0.setSoftInputMode(v | 5);
            inputMethodManager0.showSoftInput(view0, 0);
            return;
        }
        inputMethodManager0.hideSoftInputFromWindow(view0.getWindowToken(), 0);
        window0.addFlags(0x20000);
        window0.setSoftInputMode(v | 2);
        inputMethodManager0.hideSoftInputFromWindow(view0.getWindowToken(), 0);
    }

    public static void a(EditText editText0) {
        if(editText0 == null) {
            return;
        }
        rx.a(new sr(editText0));
    }

    @TargetApi(16)
    public static void a(ImageView imageView0, float f) {
        rx.a(new tf(imageView0, f));
    }

    public static void a(ListView listView0, int v) {
        listView0.setOnHierarchyChangeListener(new th(v));
    }

    public static void a(ListView listView0, int v, int v1) {
        listView0.setSelectionFromTop(v, v1);
        listView0.post(new tc(listView0, v, v1));
    }

    public static void a(ListView listView0, tp tp0) {
        if(tp0 == null) {
            return;
        }
        Tools.a(listView0, tp0.a, tp0.b);
    }

    public static void a(ListView listView0, CharSequence[] arr_charSequence, Drawable[] arr_drawable, int v, int v1) {
        try {
            listView0.setOnHierarchyChangeListener(new ti(v1, arr_charSequence, arr_drawable, v));
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    public static void a(TextView textView0) {
        try {
            ViewTreeObserver viewTreeObserver0 = textView0.getViewTreeObserver();
            if(viewTreeObserver0 != null) {
                viewTreeObserver0.removeOnPreDrawListener(textView0);
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    public static void a(TextView textView0, int v) {
        try {
            if(Build.VERSION.SDK_INT >= 23) {
                textView0.setTextAppearance(v);
                return;
            }
            textView0.setTextAppearance(textView0.getContext(), v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    public static void a(TextView textView0, Drawable drawable0, int v) {
        if(textView0 == null) {
            return;
        }
        rx.a(new tg(drawable0, v, textView0));
    }

    public static void a(TextView textView0, String s) {
        rx.a(new sn(textView0, s));
    }

    public static void a(File file0, int v) {
        boolean z = true;
        file0.setExecutable((v & 0x40) != 0, (v & 9) == 0);
        file0.setWritable((v & 0x80) != 0, (v & 18) == 0);
        if((v & 36) != 0) {
            z = false;
        }
        file0.setReadable((v & 0x100) != 0, z);
        if(Build.VERSION.SDK_INT >= 21) {
            try {
                Os.chmod(file0.getAbsolutePath(), v);
            }
            catch(Throwable throwable0) {
                la.b(("Failed chmod " + Integer.toOctalString(v) + " \'" + file0 + "\'"), throwable0);
            }
        }
    }

    public static void a(Object object0, int v) {
        boolean z2;
        boolean z1;
        boolean z;
        if(object0 != null) {
            if(object0 instanceof a) {
                int v1 = ((a)object0).b();
                for(int v2 = 0; v2 < v1; ++v2) {
                    if(v != 2) {
                        z = v == 1;
                    }
                    else if(((a)object0).b(v2)) {
                        z = false;
                    }
                    else {
                        z = true;
                    }
                    ((a)object0).a(v2, z);
                }
                return;
            }
            if(object0 instanceof e) {
                int v3 = ((e)object0).b();
                for(int v4 = 0; v4 < v3; ++v4) {
                    if(v != 2) {
                        z1 = v == 1;
                    }
                    else if(((e)object0).d(v4)) {
                        z1 = false;
                    }
                    else {
                        z1 = true;
                    }
                    ((e)object0).a(v4, z1);
                }
                return;
            }
            if(object0 instanceof boolean[]) {
                int v5 = ((boolean[])object0).length - 1;
                for(int v6 = 1; true; ++v6) {
                    if(v6 >= v5) {
                        return;
                    }
                    if(v != 2) {
                        z2 = v == 1;
                    }
                    else if(((boolean[])object0)[v6]) {
                        z2 = false;
                    }
                    else {
                        z2 = true;
                    }
                    ((boolean[])object0)[v6] = z2;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public static void a(String s) {
        Tools.a(s, true);
    }

    public static void a(String s, int v) {
        rx.a(new sm(s, v));
    }

    public static void a(String s, int v, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        rx.a(new sy(s, v, s1, dialogInterface$OnClickListener0));
    }

    public static void a(String s, File file0) {
        Resources resources0 = Tools.e().getResources();
        int v = qk.a(("ydw" + s), R.raw.class);
        if(v == 0) {
            la.a(("Nothing extract file " + s + ' ' + file0.getAbsolutePath()));
            throw new RuntimeException("Nothing extract");
        }
        try {
            byte[] arr_b = new byte[0x2000];
            FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
            InputStream inputStream0 = resources0.openRawResource(v);
            while(true) {
                int v1 = inputStream0.read(arr_b);
                if(v1 <= 0) {
                    inputStream0.close();
                    fileOutputStream0.close();
                    return;
                }
                fileOutputStream0.write(arr_b, 0, v1);
            }
        }
        catch(IOException iOException0) {
            la.a(("Failed extract file " + s + ' ' + file0.getAbsolutePath()), iOException0);
            throw new RuntimeException(iOException0);
        }
    }

    public static void a(String s, String s1) {
        try {
            if(Build.VERSION.SDK_INT >= 21) {
                Os.chmod(s, Integer.parseInt(s1, 8));
            }
            else if(Build.VERSION.SDK_INT >= 12) {
                Object object0 = Class.forName("libcore.io.Libcore").getField("os").get(null);
                Class.forName("libcore.io.Os").getMethod("chmod", String.class, Integer.TYPE).invoke(object0, s, Integer.parseInt(s1, 8));
            }
        }
        catch(Throwable throwable0) {
            la.b(("Failed chmod " + s1 + " \'" + s + "\'"), throwable0);
        }
        String[] arr_s = {"chmod", s1, Tools.n(s)};
        try {
            if(!Tools.a(Tools.a(arr_s), 15)) {
                la.b(("timeout fail 1: " + Arrays.toString(arr_s)), new RuntimeException());
            }
        }
        catch(Exception exception0) {
            la.b("exec", exception0);
        }
        try {
            if(!Config.C && !Tools.a(qt.b(("exec " + Tools.a(arr_s, " "))), 15)) {
                la.b(("timeout fail 2: " + Arrays.toString(arr_s)), new RuntimeException());
            }
        }
        catch(Exception exception1) {
            la.b("root", exception1);
        }
    }

    public static void a(String s, StringBuilder stringBuilder0) {
        PackageInfo packageInfo0;
        StringBuilder stringBuilder1 = stringBuilder0 == null ? new StringBuilder() : stringBuilder0;
        stringBuilder1.append("\nActivities:\n");
        if(stringBuilder0 == null) {
            la.a(stringBuilder1.toString().trim());
            stringBuilder1 = new StringBuilder();
        }
        try {
            packageInfo0 = null;
            packageInfo0 = Tools.d(s, 1);
        }
        catch(Throwable unused_ex) {
        }
        if(packageInfo0 == null) {
            stringBuilder1.append("Null for: " + s);
            if(stringBuilder0 == null) {
                la.a(stringBuilder1.toString().trim());
                new StringBuilder();
            }
        }
        else if(packageInfo0.activities == null) {
            stringBuilder1.append("Null");
            if(stringBuilder0 == null) {
                la.a(stringBuilder1.toString().trim());
                new StringBuilder();
            }
        }
        else {
            ActivityInfo[] arr_activityInfo = packageInfo0.activities;
            int v = 0;
            while(v < arr_activityInfo.length) {
                ActivityInfo activityInfo0 = arr_activityInfo[v];
                try {
                    stringBuilder1.append(activityInfo0);
                    if(activityInfo0 != null) {
                        stringBuilder1.append('\n');
                        Field[] arr_field = ActivityInfo.class.getFields();
                        int v1 = arr_field.length;
                    label_29:
                        for(int v2 = 0; v2 < v1; ++v2) {
                            Field field0 = arr_field[v2];
                            int v3 = field0.getModifiers();
                            if(Modifier.isPublic(v3) && !Modifier.isStatic(v3)) {
                                stringBuilder1.append(field0.getName());
                                stringBuilder1.append(": ");
                                try {
                                    stringBuilder1.append(field0.get(activityInfo0));
                                }
                                catch(Throwable throwable1) {
                                    stringBuilder1.append(throwable1);
                                }
                                stringBuilder1.append("; ");
                            }
                        }
                    }
                }
                catch(Throwable throwable0) {
                    stringBuilder1.append(throwable0);
                    if(true) {
                        goto label_45;
                    }
                    goto label_29;
                }
                try {
                label_45:
                    ComponentName componentName0 = new ComponentName(s, activityInfo0.name);
                    stringBuilder1.append("enabled: ");
                    stringBuilder1.append(Tools.m().getComponentEnabledSetting(componentName0));
                    stringBuilder1.append("; ");
                }
                catch(Throwable throwable2) {
                    stringBuilder1.append(throwable2);
                }
                stringBuilder1.append('\n');
                if(stringBuilder0 == null) {
                    la.a(stringBuilder1.toString().trim());
                    stringBuilder1 = new StringBuilder();
                }
                ++v;
            }
        }
    }

    @TargetApi(11)
    public static void a(String s, boolean z) {
        if(s == null) {
            return;
        }
        rx.a(new sl(s, z));
    }

    public static void a(WeakReference weakReference0) {
        if(weakReference0 != null) {
            AlertDialog alertDialog0 = (AlertDialog)weakReference0.get();
            if(alertDialog0 != null) {
                Tools.b(alertDialog0);
            }
        }
    }

    private static boolean a(int v, ViewGroup viewGroup0, int v1) {
        viewGroup0.requestLayout();
        viewGroup0.measure(-2, -2);
        int v2 = viewGroup0.getMeasuredWidth();
        boolean z = v2 <= v;
        if(v1 != 0 || !z) {
            la.a(("fixDialogButtonsSize: " + v2 + " <= " + v + " = " + z + " [" + v1 + ']'));
        }
        return z;
    }

    public static boolean a(long v, long v1) {
        int v2 = v >= v1 ? 0 : 1;
        if(v < 0L) {
            return v1 >= 0L ? 1 ^ v2 : v2;
        }
        return v1 >= 0L ? v2 : 1 ^ v2;
    }

    public static boolean a(Context context0) {
        if(Build.VERSION.SDK_INT >= 23) {
            try {
                return Settings.canDrawOverlays(context0);
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
        }
        return true;
    }

    public static boolean a(DialogInterface dialogInterface0, int v, Object object0, View.OnClickListener view$OnClickListener0) {
        if(dialogInterface0 instanceof AlertDialog) {
            Button button0 = ((AlertDialog)dialogInterface0).getButton(v);
            if(button0 != null) {
                button0.setTag(object0);
                button0.setOnClickListener(view$OnClickListener0);
                return true;
            }
        }
        return false;
    }

    public static boolean a(DialogInterface dialogInterface0, int v, Object object0, View.OnClickListener view$OnClickListener0, android.ext.EditText editText0) {
        if(editText0 != null) {
            editText0.requestFocus();
            Tools.a(editText0);
        }
        return Tools.a(dialogInterface0, v, object0, view$OnClickListener0);
    }

    public static boolean a(Process process0, int v) {
        FutureTask futureTask0 = new FutureTask(new ss(process0));
        new hx(futureTask0, "waitForTimeout: " + process0).start();
        try {
            return ((Boolean)futureTask0.get(((long)v), TimeUnit.SECONDS)).booleanValue();
        }
        catch(Exception unused_ex) {
            return Tools.b(process0);
        }
    }

    public static boolean[] a(List list0) {
        boolean[] arr_z = new boolean[list0.size()];
        int v = 0;
        for(Object object0: list0) {
            arr_z[v] = ((Boolean)object0).booleanValue();
            ++v;
        }
        return arr_z;
    }

    public static int b() {
        if(Tools.g < 0) {
            Tools.g = (int)Tools.a(48.0f);
        }
        return Tools.g;
    }

    public static int b(int v, int v1) {
        while(v1 != 0) {
            int v2 = v % v1;
            v = v1;
            v1 = v2;
        }
        return v;
    }

    public static Drawable b(int v) {
        if(Build.VERSION.SDK_INT >= 21) {
            try {
                return Tools.e().getDrawable(v);
            }
            catch(NoSuchMethodError unused_ex) {
                return Tools.e().getResources().getDrawable(v);
            }
        }
        return Tools.e().getResources().getDrawable(v);
    }

    public static Drawable b(ApplicationInfo applicationInfo0) {
        Drawable drawable0 = null;
        PackageManager packageManager0 = Tools.l;
        if(applicationInfo0 == null || packageManager0 == null) {
            return drawable0;
        }
        else {
            try {
                boolean z = ca.a(applicationInfo0.packageName, "icon");
                try {
                    drawable0 = applicationInfo0.loadIcon(packageManager0);
                }
                finally {
                    ca.a(z);
                }
                if(drawable0 == null) {
                    boolean z1 = ca.a(applicationInfo0.packageName, "icon2");
                    try {
                        return packageManager0.getApplicationIcon(applicationInfo0);
                    }
                    finally {
                        ca.a(z1);
                    }
                }
                return drawable0;
            }
            catch(Throwable throwable0) {
            }
        }
        la.c(("Failed load icon for: " + applicationInfo0.packageName), throwable0);
        return drawable0;
    }

    public static View b(String s, String s1) {
        return Tools.a(s, s1, -1);
    }

    public static Throwable b(Context context0) {
        try {
            context0.getPackageName();
            context0.getPackageManager();
            context0.getCacheDir();
            context0.getFilesDir();
            context0.getExternalCacheDir();
            context0.getExternalFilesDir(null);
            return null;
        }
        catch(Throwable throwable0) {
            return throwable0;
        }
    }

    public static void b(AlertDialog alertDialog0) {
        rx.a(new so(alertDialog0));
    }

    public static void b(View view0) {
        rx.a(new te(view0));
    }

    public static void b(View view0, float f) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 != null) {
            viewGroup$LayoutParams0.height = (int)f;
            view0.setLayoutParams(viewGroup$LayoutParams0);
        }
    }

    public static void b(View view0, WindowManager.LayoutParams windowManager$LayoutParams0) {
        la.a(("dbg2: " + view0 + ' ' + windowManager$LayoutParams0));
        Tools.a(view0, windowManager$LayoutParams0, true);
    }

    public static void b(Window window0) {
        rx.a(new sp(window0));
    }

    public static void b(String s) {
        Tools.a(s, 1);
    }

    public static void b(String s, int v) {
        Tools.a(s, v, null, null);
    }

    public static void b(WeakReference weakReference0) {
        if(weakReference0 != null) {
            AlertDialog alertDialog0 = (AlertDialog)weakReference0.get();
            if(alertDialog0 != null) {
                Tools.a(alertDialog0);
            }
        }
    }

    public static boolean b(long v, long v1) {
        return v == v1 || Tools.a(v, v1);
    }

    public static boolean b(Object object0) {
        FileInputStream fileInputStream0;
        String s;
        int v;
        File file0 = object0 instanceof File ? ((File)object0) : new File(object0.toString());
        if(file0.exists()) {
            v = file0.isFile() ? 0 : 0x7F0702F4;  // string:not_file "Path is not a file:"
        }
        else {
            v = 0x7F0701F7;  // string:file_not_found "File not found:"
        }
        if(v != 0) {
            s = Tools.c(v) + ": " + object0;
            android.ext.i.a(android.ext.i.c().setCustomTitle(Tools.d(0x7F0700AE)).setMessage(s).setPositiveButton(qk.a(0x7F07009D), null));  // string:error "Error"
            return false;
        }
        try {
            fileInputStream0 = null;
            fileInputStream0 = new FileInputStream(file0);
            fileInputStream0.read();
        }
        catch(IOException iOException0) {
            s = object0 + "\n\n" + iOException0.getMessage();
            if(fileInputStream0 != null) {
                try {
                    fileInputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            android.ext.i.a(android.ext.i.c().setCustomTitle(Tools.d(0x7F0700AE)).setMessage(s).setPositiveButton(qk.a(0x7F07009D), null));  // string:error "Error"
            return false;
        }
        catch(Throwable throwable0) {
            if(fileInputStream0 != null) {
                try {
                    fileInputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable0;
        }
        try {
            fileInputStream0.close();
        }
        catch(IOException unused_ex) {
        }
        return true;
    }

    public static boolean b(Process process0) {
        try {
            process0.exitValue();
            return true;
        }
        catch(IllegalThreadStateException unused_ex) {
            return false;
        }
    }

    public static int[] b(List list0) {
        int[] arr_v = new int[list0.size()];
        int v = 0;
        for(Object object0: list0) {
            arr_v[v] = (int)(((Integer)object0));
            ++v;
        }
        return arr_v;
    }

    private static int[] b(byte[] arr_b) {
        int[] arr_v = new int[arr_b.length];
        int v = 0;
        for(int v1 = 1; v1 < arr_b.length; ++v1) {
            while(v > 0 && arr_b[v] != arr_b[v1]) {
                v = arr_v[v - 1];
            }
            if(arr_b[v] == arr_b[v1]) {
                ++v;
            }
            arr_v[v1] = v;
        }
        return arr_v;
    }

    public static int c() {
        try {
            RandomAccessFile randomAccessFile0 = new RandomAccessFile("/proc/meminfo", "r");
            Matcher matcher0 = Tools.h.matcher(randomAccessFile0.readLine());
            for(String s = "-2"; true; s = matcher0.group(1)) {
                if(!matcher0.find()) {
                    randomAccessFile0.close();
                    return Integer.parseInt(s);
                }
            }
        }
        catch(Throwable throwable0) {
            la.b("Failed get RAM size", throwable0);
            return -1;
        }
    }

    public static int c(int v, int v1) {
        try {
            Context context0 = Tools.e();
            if(Build.VERSION.SDK_INT >= 23) {
                try {
                    return context0.getColor(v);
                }
                catch(Throwable throwable1) {
                    la.a(throwable1);
                }
            }
            return context0.getResources().getColor(v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return v1;
        }
    }

    public static Context c(Context context0) {
        while(context0 instanceof ContextWrapper) {
            context0 = ((ContextWrapper)context0).getBaseContext();
        }
        return context0;
    }

    public static ApplicationInfo c(String s, int v) {
        Object object1;
        ApplicationInfo applicationInfo1;
        ApplicationInfo applicationInfo0;
        boolean z;
        if(ca.a(s)) {
            la.c(("Failed getApplicationInfo, isBuggedPackage: " + s));
            return null;
        }
        PackageManager packageManager0 = Tools.m();
        if(packageManager0 == null) {
            applicationInfo1 = null;
        }
        else {
            try {
                z = ca.a(s, "app_info");
                try {
                    applicationInfo0 = packageManager0.getApplicationInfo(s, v);
                }
                catch(Throwable throwable1) {
                    ca.a(z);
                    throw throwable1;
                }
            }
            catch(Throwable throwable0) {
                applicationInfo0 = null;
                goto label_18;
            }
            try {
                ca.a(z);
                applicationInfo1 = applicationInfo0;
                goto label_24;
            }
            catch(Throwable throwable0) {
            }
        label_18:
            if(throwable0 instanceof PackageManager.NameNotFoundException) {
                throw (PackageManager.NameNotFoundException)throwable0;
            }
            la.c("Failed getApplicationInfo", throwable0);
            applicationInfo1 = applicationInfo0;
        }
    label_24:
        if(applicationInfo1 == null) {
            Object object0 = Tools.p();
            if(object0 != null) {
                try {
                    Class class0 = object0.getClass();
                    tn tn0 = Tools.a(class0, new tn[]{new tn(class0, "getApplicationInfo", new Class[]{String.class, Integer.TYPE, Integer.TYPE}, object0, new Object[]{s, v, 0}), new tn(class0, "getApplicationInfo", new Class[]{String.class, Integer.TYPE}, object0, new Object[]{s, v})});
                    if(tn0 == null) {
                        object1 = null;
                    }
                    else {
                        boolean z1 = ca.a(s, "app_info2");
                        try {
                            object1 = tn0.b();
                        }
                        finally {
                            ca.a(z1);
                        }
                        if(object1 == null) {
                            throw new PackageManager.NameNotFoundException(s);
                        }
                    }
                    if(object1 instanceof ApplicationInfo) {
                        return (ApplicationInfo)object1;
                    }
                }
                catch(Throwable throwable2) {
                    if(throwable2 instanceof PackageManager.NameNotFoundException) {
                        throw (PackageManager.NameNotFoundException)throwable2;
                    }
                    la.c("Failed getApplicationInfo", throwable2);
                }
            }
        }
        return applicationInfo1;
    }

    public static String c(int v) {
        return Tools.g(qk.a(v));
    }

    public static String c(String s) {
        String s1 = s.trim();
        int v = s1.length();
        for(int v1 = v - 1; v1 > 0 && s1.charAt(v1) == 0x2F; --v1) {
            --v;
        }
        return v >= s1.length() ? s1 : s1.substring(0, v);
    }

    private static String c(String s, String s1) {
        if(s != null) {
            int v = s.length();
            if(v != 0) {
                if(s1 == null) {
                    while(v != 0 && Character.isWhitespace(s.charAt(v - 1))) {
                        --v;
                    }
                    return s.substring(0, v);
                }
                if(!s1.isEmpty()) {
                    while(v != 0) {
                        int v1 = s.charAt(v - 1);
                        if(s1.indexOf(v1) == -1 && !Character.isWhitespace(((char)v1))) {
                            break;
                        }
                        --v;
                    }
                    return s.substring(0, v);
                }
            }
        }
        return s;
    }

    public static void c(AlertDialog alertDialog0) {
        boolean z1;
        int v2;
        ViewGroup viewGroup0;
        if(alertDialog0 != null) {
            Button[] arr_button = {alertDialog0.getButton(-1), alertDialog0.getButton(-2), alertDialog0.getButton(-3)};
            int v = 0;
        alab1:
            while(true) {
                if(v >= 3) {
                    viewGroup0 = null;
                    goto label_11;
                }
                Button button0 = arr_button[v];
                if(button0 != null) {
                    ViewGroup viewGroup1 = (ViewGroup)button0.getParent();
                    if(viewGroup1 == null) {
                        goto label_93;
                    }
                    else {
                        viewGroup0 = viewGroup1;
                    }
                label_11:
                    if(viewGroup0 == null) {
                        break;
                    }
                    int v1 = viewGroup0.getWidth();
                    if(v1 == 0) {
                        viewGroup0.requestLayout();
                        v1 = viewGroup0.getWidth();
                        if(v1 == 0) {
                            v1 = viewGroup0.getMeasuredWidth();
                        }
                        if(v1 == 0) {
                            viewGroup0.measure(-1, -2);
                            v2 = viewGroup0.getMeasuredWidth();
                        }
                        else {
                            v2 = v1;
                        }
                    }
                    else {
                        v2 = v1;
                    }
                    if(v2 == 0 || Tools.a(v2, viewGroup0, 0)) {
                        break;
                    }
                    for(int v3 = 0; v3 < 3; ++v3) {
                        Button button1 = arr_button[v3];
                        if(button1 != null && Build.VERSION.SDK_INT >= 14) {
                            button1.setAllCaps(false);
                        }
                    }
                    if(Tools.a(v2, viewGroup0, 5)) {
                        break;
                    }
                    for(int v4 = 0; v4 < 3; ++v4) {
                        Button button2 = arr_button[v4];
                        if(button2 != null) {
                            ColorStateList colorStateList0 = button2.getTextColors();
                            Tools.a(button2, 0x7F090002);  // style:SmallText
                            button2.setTextColor(colorStateList0);
                        }
                    }
                    if(Tools.a(v2, viewGroup0, 10)) {
                        break;
                    }
                    String[][] arr2_s = {new String[]{qk.a(0x7F0700A1), qk.a(0x7F07009C)}, new String[]{qk.a(0x7F07008C), qk.a(0x7F07009B), qk.a(0x7F07009D)}, new String[]{qk.a(0x7F0701A2), qk.a(0x7F07021F)}};  // string:cancel "Cancel"
                    for(int v5 = 0; true; ++v5) {
                        if(v5 >= 3) {
                            boolean z = false;
                            for(int v6 = 0; v6 < 3; ++v6) {
                                Button button3 = arr_button[v6];
                                if(button3 != null && button3.getText().toString().indexOf(0x20) != -1) {
                                    button3.setText(button3.getText().toString().replace(' ', '\n'));
                                    z = true;
                                }
                            }
                            if(z && Tools.a(v2, viewGroup0, 40)) {
                                break alab1;
                            }
                            if(!(viewGroup0 instanceof LinearLayout) || ((LinearLayout)viewGroup0).getOrientation() != 0) {
                                z1 = false;
                            }
                            else {
                                ((LinearLayout)viewGroup0).setOrientation(1);
                                z1 = true;
                            }
                            if(z1 && Tools.a(v2, viewGroup0, 100)) {
                                break alab1;
                            }
                            Tools.a(v2, viewGroup0, -1);
                            return;
                        }
                        boolean z2 = false;
                        String[] arr_s = arr2_s[v5];
                        if(arr_s != null) {
                            int v7 = 0;
                            for(int v8 = 0; v8 < arr_s.length; ++v8) {
                                if(arr_s[v7].length() >= arr_s[v8].length()) {
                                    v7 = v8;
                                }
                            }
                            for(int v9 = 0; v9 < 3; ++v9) {
                                Button button4 = arr_button[v9];
                                if(button4 != null) {
                                    String s = button4.getText().toString();
                                    for(int v10 = 0; v10 < arr_s.length; ++v10) {
                                        if(v10 != v7 && arr_s[v10].equals(s)) {
                                            button4.setText(arr_s[v7]);
                                            z2 = true;
                                        }
                                    }
                                }
                            }
                            if(z2 && Tools.a(v2, viewGroup0, v5 + 20)) {
                                return;
                            }
                        }
                    }
                }
            label_93:
                ++v;
            }
        }
    }

    public static void c(View view0, WindowManager.LayoutParams windowManager$LayoutParams0) {
        ViewParent viewParent0 = view0.getParent();
        View view1 = viewParent0 instanceof Tools.ViewWrapper ? ((Tools.ViewWrapper)viewParent0) : view0;
        Tools.a(view1, windowManager$LayoutParams0, false);
    }

    public static boolean c(View view0) {
        if(view0 != null && view0.getVisibility() == 0) {
            if(view0 instanceof ViewGroup) {
                ViewGroup viewGroup0 = (ViewGroup)view0;
                int v = viewGroup0.getChildCount();
                for(int v1 = 0; true; ++v1) {
                    if(v1 >= v) {
                        return false;
                    }
                    try {
                        View view1 = viewGroup0.getChildAt(v1);
                        if(view1 == null || view1.getVisibility() != 0 || !(view1 instanceof EditText) && (!(view1 instanceof ViewGroup) || !Tools.c(view1))) {
                            continue;
                        }
                        break;
                    }
                    catch(ArrayIndexOutOfBoundsException unused_ex) {
                    }
                }
                return true;
            }
            return view0 instanceof EditText;
        }
        return false;
    }

    public static PackageInfo d(String s, int v) {
        Object object1;
        PackageInfo packageInfo1;
        PackageInfo packageInfo0;
        boolean z;
        if(ca.a(s)) {
            la.c(("Failed getPackageInfo, isBuggedPackage: " + s));
            return null;
        }
        PackageManager packageManager0 = Tools.m();
        if(packageManager0 == null) {
            packageInfo1 = null;
        }
        else {
            try {
                z = ca.a(s, "pkg_info");
                try {
                    packageInfo0 = packageManager0.getPackageInfo(s, v);
                }
                catch(Throwable throwable1) {
                    ca.a(z);
                    throw throwable1;
                }
            }
            catch(Throwable throwable0) {
                packageInfo0 = null;
                goto label_18;
            }
            try {
                ca.a(z);
                packageInfo1 = packageInfo0;
                goto label_24;
            }
            catch(Throwable throwable0) {
            }
        label_18:
            if(throwable0 instanceof PackageManager.NameNotFoundException) {
                throw (PackageManager.NameNotFoundException)throwable0;
            }
            la.c("Failed getPackageInfo", throwable0);
            packageInfo1 = packageInfo0;
        }
    label_24:
        if(packageInfo1 == null) {
            Object object0 = Tools.p();
            if(object0 != null) {
                try {
                    Class class0 = object0.getClass();
                    tn tn0 = Tools.a(class0, new tn[]{new tn(class0, "getPackageInfo", new Class[]{String.class, Integer.TYPE, Integer.TYPE}, object0, new Object[]{s, v, 0}), new tn(class0, "getPackageInfo", new Class[]{String.class, Integer.TYPE}, object0, new Object[]{s, v})});
                    if(tn0 == null) {
                        object1 = null;
                    }
                    else {
                        boolean z1 = ca.a(s, "pkg_info2");
                        try {
                            object1 = tn0.b();
                        }
                        finally {
                            ca.a(z1);
                        }
                        if(object1 == null) {
                            throw new PackageManager.NameNotFoundException(s);
                        }
                    }
                    if(object1 instanceof PackageInfo) {
                        return (PackageInfo)object1;
                    }
                }
                catch(Throwable throwable2) {
                    if(throwable2 instanceof PackageManager.NameNotFoundException) {
                        throw (PackageManager.NameNotFoundException)throwable2;
                    }
                    la.c("Failed getPackageInfo", throwable2);
                }
            }
        }
        return packageInfo1;
    }

    public static View d(int v) {
        return Tools.i(qk.a(v));
    }

    public static View d(View view0) {
        if(view0 != null) {
            ViewParent viewParent0 = view0.getParent();
            if(viewParent0 != null && viewParent0 instanceof ViewGroup) {
                try {
                    ((ViewGroup)viewParent0).removeView(view0);
                }
                catch(Throwable throwable0) {
                    la.a(throwable0);
                }
                return view0;
            }
        }
        return view0;
    }

    public static String d(Context context0) [...] // 潜在的解密器

    public static void d() {
        new gr(new st(), "checkForBadContext").start();
    }

    public static boolean d(String s) {
        File file0 = new File(s);
        if(!file0.canExecute()) {
            String[] arr_s = {"chmod", "0755", Tools.n(s)};
            try {
                if(!Tools.a(Tools.a(arr_s), 15)) {
                    la.b(("timeout fail 1: " + Arrays.toString(arr_s)), new RuntimeException());
                }
            }
            catch(Exception exception0) {
                la.b("exec", exception0);
            }
            boolean z = false;
            if(Config.C) {
                z = true;
            }
            else if(!file0.canExecute()) {
                z = true;
                try {
                    if(!Tools.a(qt.b(("exec " + Tools.a(arr_s, " "))), 15)) {
                        la.b(("timeout fail 2: " + Arrays.toString(arr_s)), new RuntimeException());
                        return file0.canExecute();
                    }
                }
                catch(Exception exception1) {
                    la.b("root", exception1);
                    return file0.canExecute();
                }
            }
            if(z) {
                return file0.canExecute();
            }
        }
        return true;
    }

    public static int e(int v) {
        return Tools.c(v, -1);
    }

    public static Context e() {
        Context context0 = MainService.context;
        if(context0 == null && ar.f != null) {
            return Tools.c(ar.f) == null ? ar.e : ar.f;
        }
        return context0;
    }

    public static void e(Context context0) {
        try {
            Tools.g(context0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    public static void e(View view0) {
        rx.a(new sq(view0));
    }

    public static boolean e(String s) {
        try {
            Tools.c(s, 0);
            return true;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return false;
        }
    }

    public static double f(String s) {
        String s1 = s.trim();
        double f = 1.0;
        if(s1.startsWith("-")) {
            s1 = s1.substring(1);
            f = -1.0;
        }
        String[] arr_s = s1.split(":", Tools.p.length / 2);
        double f1 = 0.0;
        pv pv0 = new pv();
        for(int v = 0; v < arr_s.length; ++v) {
            int v1 = (arr_s.length - 1 - v) * 2 + 1;
            if(v1 < Tools.p.length) {
                double f2 = Double.longBitsToDouble(ps.a(pv0, arr_s[v], s1).a);
                f1 = f1 * ((double)Tools.p[v1]) + f2;
            }
        }
        return f * f1;
    }

    public static Context f(Context context0) {
        return context0 != null && Build.VERSION.SDK_INT < 11 ? new ContextThemeWrapper(context0, 0x7F090005) : context0;  // style:DarkFixTheme
    }

    public static String f() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("/data/");
        int v = android.os.Process.myUid();
        if(v / 100000 == 0) {
            stringBuilder0.append("data");
        }
        else {
            stringBuilder0.append("user/");
            stringBuilder0.append(v / 100000);
        }
        stringBuilder0.append('/');
        stringBuilder0.append((Tools.i == null ? y.d : Tools.i));
        return stringBuilder0.toString();
    }

    public static boolean f(View view0) {
        if(view0 == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 15 ? view0.callOnClick() : view0.performClick();
    }

    public static View g(View view0) {
        View view1 = view0.getRootView();
        if(view1 == null) {
            while(true) {
                ViewParent viewParent0 = view0.getParent();
                if(viewParent0 == null || !(viewParent0 instanceof View)) {
                    break;
                }
                view0 = (View)viewParent0;
            }
            return view0;
        }
        return view1;
    }

    public static String g() {
        return Tools.i == null ? y.d : Tools.i;
    }

    public static String g(String s) {
        return Tools.c(s, ":");
    }

    @SuppressLint({"SdCardPath"})
    private static void g(Context context0) {
        if(Tools.l == null) {
            try {
                Tools.l = context0.getPackageManager();
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
        }
        if(Tools.i == null) {
            Tools.i = "catch_.me_.if_.you_.can_";
        }
        if(Tools.i == null) {
            Tools.i = y.d;
        }
        if(Tools.j == null) {
            try {
                Tools.j = context0.getFilesDir().getAbsolutePath();
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
            }
        }
        if(Tools.k == null) {
            try {
                Tools.k = context0.getCacheDir().getAbsolutePath();
            }
            catch(Throwable throwable2) {
                la.a(throwable2);
            }
        }
        if(Tools.j == null && Tools.i != null) {
            Tools.j = Tools.f() + "/files";
        }
        if(Tools.k == null && Tools.i != null) {
            Tools.k = Tools.f() + "/cache";
        }
        if(Tools.j != null) {
            try {
                File file0 = new File(Tools.j);
                if(!file0.exists()) {
                    file0.mkdirs();
                }
            }
            catch(Throwable throwable3) {
                la.a(throwable3);
            }
        }
        if(Tools.k == null) {
            return;
        }
        else {
            try {
                File file1 = new File(Tools.k);
                if(!file1.exists()) {
                    file1.mkdirs();
                }
                return;
            }
            catch(Throwable throwable4) {
            }
        }
        la.a(throwable4);
    }

    public static File h() {
        String s = Tools.k;
        if(s == null) {
            String s1 = Tools.p("/cache");
            return s1 == null ? null : new File(s1);
        }
        return s == null ? null : new File(s);
    }

    public static void h(View view0) {
        if((Config.B & 0x20) == 0 && view0 != null) {
            View view1 = Tools.g(view0);
            view1.setSoundEffectsEnabled(false);
            if(view1 instanceof ViewGroup) {
                Tools.a(((ViewGroup)view1));
            }
        }
    }

    public static boolean h(String s) {
        Intent intent0;
        try {
            Context context0 = Tools.e();
            try {
                intent0 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", s, null));
            }
            catch(ActivityNotFoundException activityNotFoundException0) {
                la.b(("Failed open app info for: " + s), activityNotFoundException0);
                intent0 = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            }
            intent0.setFlags(0x10000000);
            context0.startActivity(intent0);
            return true;
        }
        catch(Throwable throwable0) {
            la.b(("Failed open app info for: " + s), throwable0);
            return false;
        }
    }

    public static View i(String s) {
        return Tools.b(s, null);
    }

    public static File i() {
        String s = Tools.j;
        if(s == null) {
            String s1 = Tools.p("/files");
            return s1 == null ? null : new File(s1);
        }
        return s == null ? null : new File(s);
    }

    public static void i(View view0) {
        Tools.a(view0, view0.getBackground());
    }

    public static ApplicationInfo j(String s) {
        return Tools.c(s, 0);
    }

    public static String j() {
        String s = null;
        if(Tools.n == null) {
            try {
                SharedPreferences sharedPreferences0 = Tools.s();
                if(!sharedPreferences0.contains("hidden-dir")) {
                    String s1 = Tools.v();
                    if(s1 == null) {
                        s1 = "8XUL";
                    }
                    sharedPreferences0.edit().putString("hidden-dir", s1).commit();
                }
                try {
                    s = sharedPreferences0.getString("hidden-dir", null);
                }
                catch(ClassCastException unused_ex) {
                }
                if(s == null) {
                    int v = sharedPreferences0.getInt("hidden-dir", 0);
                    if(v == 0) {
                        sharedPreferences0.edit().remove("hidden-dir").commit();
                    }
                    else {
                        s = Integer.toString(v);
                        sharedPreferences0.edit().putString("hidden-dir", s).commit();
                    }
                }
            }
            catch(Throwable throwable0) {
                la.b("Failed get num", throwable0);
                s = Tools.v();
            }
            if(s == null) {
                s = "8XUL";
            }
            Tools.n = "GG-" + s;
        }
        return Tools.n;
    }

    public static void j(View view0) {
        Tools.a(view0, Tools.b(0x7F020033));  // drawable:ic_information_white_12dp
    }

    public static PackageInfo k(String s) {
        return Tools.d(s, 0);
    }

    public static ListView k(View view0) {
        while(true) {
            if(view0 == null) {
                return null;
            }
            if(view0 instanceof ListView) {
                return (ListView)view0;
            }
            ViewParent viewParent0 = view0.getParent();
            if(!(viewParent0 instanceof View)) {
                return null;
            }
            view0 = (View)viewParent0;
        }
    }

    public static File k() {
        File file0 = Tools.h();
        if(file0 != null) {
            File file1 = new File(file0, Tools.j());
            file1.mkdirs();
            return file1;
        }
        return null;
    }

    public static File l() {
        File file0 = Tools.i();
        if(file0 != null) {
            File file1 = new File(file0, Tools.j());
            file1.mkdirs();
            return file1;
        }
        return null;
    }

    public static String l(String s) {
        return Pattern.quote(s).replace("^", "\\E^\\Q").replace("$", "\\E$\\Q").replace("?", "\\E.\\Q").replace("*", "\\E.*\\Q").replace("\\Q\\E", "");
    }

    public static void l(View view0) {
        Tools.h(Tools.g(view0));
    }

    public static PackageManager m() {
        if(Tools.l == null && Tools.o.a(1)) {
            try {
                Tools.l = ar.d.getPackageManager();
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
            Tools.o.b(1);
        }
        if(Tools.l == null && Tools.o.a(2)) {
            try {
                Tools.l = ar.d.getApplication().getPackageManager();
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
            }
            Tools.o.b(2);
        }
        if(Tools.l == null && Tools.o.a(4)) {
            try {
                Tools.l = ar.d.getApplicationContext().getPackageManager();
            }
            catch(Throwable throwable2) {
                la.a(throwable2);
            }
            Tools.o.b(4);
        }
        if(Tools.l == null && Tools.o.a(8)) {
            try {
                Tools.l = MainService.context.getPackageManager();
            }
            catch(Throwable throwable3) {
                la.a(throwable3);
            }
            Tools.o.b(8);
        }
        if(Tools.l == null && Tools.o.a(16)) {
            try {
                Tools.l = MainService.context.getApplicationContext().getPackageManager();
            }
            catch(Throwable throwable4) {
                la.a(throwable4);
            }
            Tools.o.b(16);
        }
        return Tools.l;
    }

    public static String m(String s) {
        try {
            if(Tools.v == 0 || Tools.v == 1) {
                File file0 = new File(s);
                String s1 = "/" + file0.getName();
                FileInputStream fileInputStream0 = new FileInputStream(file0);
                MappedByteBuffer mappedByteBuffer0 = fileInputStream0.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, 0x1000L);
                BufferedReader bufferedReader0 = new BufferedReader(new FileReader("/proc/self/maps"));
            alab1:
                String s2;
                while((s2 = bufferedReader0.readLine()) != null) {
                    int v = s2.indexOf(s1);
                    if(v >= 0) {
                        for(int v1 = v; true; --v1) {
                            if(v1 <= 0 || s2.charAt(v1) <= 0x20) {
                                if(v1 >= v) {
                                    break alab1;
                                }
                                s = s2.substring(v1, s2.length()).trim();
                                if(Tools.v != 0) {
                                    break alab1;
                                }
                                Tools.v = 1;
                                break alab1;
                            }
                        }
                    }
                }
                bufferedReader0.close();
                if(Tools.v == 0) {
                    Tools.v = 2;
                }
                mappedByteBuffer0.capacity();
                fileInputStream0.close();
            }
        }
        catch(IOException iOException0) {
            la.b(("Failed getNativePath: " + s), iOException0);
        }
        return s;
    }

    public static void m(View view0) {
    }

    public static long n() {
        try {
            ActivityManager.MemoryInfo activityManager$MemoryInfo0 = new ActivityManager.MemoryInfo();
            ActivityManager activityManager0 = (ActivityManager)Tools.e().getSystemService("activity");
            if(activityManager0 != null) {
                activityManager0.getMemoryInfo(activityManager$MemoryInfo0);
                return activityManager$MemoryInfo0.availMem / 0x100000L;
            }
        }
        catch(Throwable throwable0) {
            la.c("Failed get free mem", throwable0);
        }
        return -1L;
    }

    public static String n(String s) {
        return Tools.d == null ? s : s.replace(Tools.d[0], Tools.d[1]);
    }

    private static void n(View view0) {
        boolean z = true;
        if(view0 != null) {
            if(!(view0 instanceof ScrollView)) {
                if(!(view0 instanceof HorizontalScrollView)) {
                    if(!(view0 instanceof AbsListView) || view0 instanceof android.fix.ListView) {
                        z = false;
                    }
                }
                else if(view0 instanceof android.fix.HorizontalScrollView) {
                    z = false;
                }
            }
            else if(view0 instanceof android.fix.ScrollView) {
                z = false;
            }
            if(z) {
                int v1 = view0.getOverScrollMode();
                if(v1 != 2) {
                    la.a(("Clear OverScrollMode: " + v1 + " for " + view0));
                }
                view0.setOverScrollMode(2);
            }
            if(view0 instanceof ViewGroup) {
                ViewGroup viewGroup0 = (ViewGroup)view0;
                int v2 = viewGroup0.getChildCount();
                for(int v = 0; v < v2; ++v) {
                    try {
                        Tools.n(viewGroup0.getChildAt(v));
                    }
                    catch(ArrayIndexOutOfBoundsException unused_ex) {
                    }
                }
            }
        }
    }

    public static Context o() {
        return Tools.f(Tools.e());
    }

    public static boolean o(String s) {
        if(s.length() < 2 || s.charAt(0) != 0x2F) {
            android.ext.i.a(android.ext.i.c().setCustomTitle(Tools.d(0x7F0700AE)).setMessage(s + "\n\n" + qk.a(0x7F070163)).setPositiveButton(qk.a(0x7F07009D), null));  // string:error "Error"
            return false;
        }
        return true;
    }

    public static Object p() {
        if(Tools.q == null) {
            try {
                Method method0 = Class.forName("android.os.ServiceManager").getDeclaredMethod("getIServiceManager");
                method0.setAccessible(true);
                Object object0 = method0.invoke(null, b.f);
                Method method1 = object0.getClass().getDeclaredMethod("getService", String.class);
                method1.setAccessible(true);
                Object object1 = method1.invoke(object0, "package");
                Method method2 = Class.forName("android.content.pm.IPackageManager$Stub").getDeclaredMethod("asInterface", IBinder.class);
                method2.setAccessible(true);
                Tools.q = method2.invoke(null, object1);
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
            return Tools.q;
        }
        return Tools.q;
    }

    private static String p(String s) {
        if(Tools.m == null) {
            try {
                ApplicationInfo applicationInfo0 = Tools.j(y.d);
                if(applicationInfo0 != null) {
                    Tools.m = applicationInfo0.dataDir;
                }
                return Tools.m != null && s != null ? "null" + s : Tools.m;
            }
            catch(Throwable throwable0) {
            }
        }
        else {
            return Tools.m != null && s != null ? "null" + s : Tools.m;
        }
        la.a(throwable0);
        return Tools.m != null && s != null ? "null" + s : Tools.m;
    }

    public static String q() {
        String s;
        try {
            Context context0 = Tools.e();
            if(context0 == null) {
                goto label_8;
            }
            else {
                s = context0.getPackageCodePath();
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            s = null;
        }
        goto label_9;
    label_8:
        s = null;
    label_9:
        if(s == null) {
            try {
                ApplicationInfo applicationInfo0 = Tools.j(y.d);
                if(applicationInfo0 != null) {
                    s = applicationInfo0.sourceDir;
                }
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
            }
        }
        if(s == null) {
            try {
                BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/maps")));
                String s1 = null;
            alab1:
                while(true) {
                    while(true) {
                        String s2 = bufferedReader0.readLine();
                        if(s2 == null) {
                            break alab1;
                        }
                        if(!s2.contains(y.d) || !s2.contains(".apk")) {
                            break;
                        }
                        String s3 = s2.split("\\.apk", 2)[0] + ".apk";
                        if(s3.indexOf(0x40) != -1) {
                            String[] arr_s = s3.trim().split("/");
                            s1 = "/" + arr_s[arr_s.length - 1].trim().replace('@', '/');
                            break;
                        }
                        s = "/" + s3.split("/", 2)[1].trim();
                        break alab1;
                    }
                }
                bufferedReader0.close();
                return s != null || s1 == null ? s : s1;
            }
            catch(Throwable throwable2) {
                la.a(throwable2);
                return s;
            }
        }
        return s;
    }

    private static boolean q(String s) {
        try {
            File file0 = new File(s);
            String[] arr_s = file0.list();
            if(arr_s != null) {
                if(arr_s.length == 0) {
                    File file1 = new File(file0, ".gg." + System.nanoTime());
                    file1.createNewFile();
                    arr_s = file0.list();
                    file1.delete();
                }
                return arr_s.length > 0;
            }
        }
        catch(Throwable throwable0) {
            la.b(("isGoodDir: \'" + s + "\'"), throwable0);
        }
        return false;
    }

    public static String r() {
        String s;
        try {
            s = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        catch(Throwable throwable0) {
            s = null;
            la.c("Fail get sdcard path", throwable0);
        }
        if(s == null) {
            return "/sdcard";
        }
        if(s.startsWith("/storage/emulated/0")) {
            if(Tools.s == 0) {
                Tools.s = Tools.q(s) || !Tools.q(("/storage/emulated/legacy" + s.substring(19))) ? -1 : 1;
            }
            return Tools.s <= 0 ? s : "/storage/emulated/legacy" + s.substring(19);
        }
        return s;
    }

    public static String removeNewLinesChars(String s) [...] // 潜在的解密器

    public static SharedPreferences s() {
        SharedPreferences sharedPreferences0 = (SharedPreferences)Tools.t.get();
        if(sharedPreferences0 == null) {
            sharedPreferences0 = Tools.e().getSharedPreferences("null_preferences", 0);
            Tools.t = new WeakReference(sharedPreferences0);
        }
        return sharedPreferences0;
    }

    public static int t() {
        int v = Tools.w;
        if(v == -1) {
            Tools.a(null);
            return Tools.w;
        }
        return v;
    }

    private static String u() [...] // 潜在的解密器

    private static String v() {
        try {
            File file0 = Tools.i();
            if(file0 != null) {
                String[] arr_s = file0.list();
                if(arr_s != null) {
                    int v = 0;
                    while(v < arr_s.length) {
                        String s = arr_s[v];
                        if(s == null || !s.startsWith("GG-")) {
                            ++v;
                            continue;
                        }
                        return s.substring(3);
                    }
                }
            }
        }
        catch(Throwable throwable0) {
            la.b("Failed get dir", throwable0);
        }
        return null;
    }
}

