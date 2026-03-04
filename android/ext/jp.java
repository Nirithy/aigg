package android.ext;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.util.Base64;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import catch_.me_.if_.you_.can_.ActivityMain;
import catch_.me_.if_.you_.can_.AnalyticsService;
import catch_.me_.if_.you_.can_.Application;
import catch_.me_.if_.you_.can_.FileProvider;
import catch_.me_.if_.you_.can_.Instrumentation;
import catch_.me_.if_.you_.can_.MainActivity;
import catch_.me_.if_.you_.can_.R.attr;
import catch_.me_.if_.you_.can_.R.color;
import catch_.me_.if_.you_.can_.R.dimen;
import catch_.me_.if_.you_.can_.R.drawable;
import catch_.me_.if_.you_.can_.R.id;
import catch_.me_.if_.you_.can_.R.layout;
import catch_.me_.if_.you_.can_.R.mipmap;
import catch_.me_.if_.you_.can_.R.raw;
import catch_.me_.if_.you_.can_.R.string;
import catch_.me_.if_.you_.can_.R.style;
import catch_.me_.if_.you_.can_.R.xml;
import catch_.me_.if_.you_.can_.R;
import catch_.me_.if_.you_.can_.Receiver;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import jeb.synthetic.FIN;
import jeb.synthetic.TWR;

public class jp {
    private static String A;
    private static final Object B;
    static byte a;
    static byte[][] b;
    static final boolean[] c;
    File d;
    static jp e;
    volatile AlertDialog f;
    static volatile ko g;
    public static volatile WeakReference h;
    public static volatile WeakReference i;
    public static volatile WeakReference j;
    public static volatile WeakReference k;
    static volatile int l;
    private static final String[] m;
    private final RandomAccessFile[] n;
    private final File o;
    private final String p;
    private final String q;
    private final kj[] r;
    private final MessageDigest s;
    private final MessageDigest t;
    private Manifest u;
    private static final Runnable v;
    private static volatile int w;
    private static volatile boolean x;
    private byte[] y;
    private static volatile WeakReference z;

    static {
        jp.m = new String[]{"classes.dex", "AndroidManifest.xml", "resources.arsc", "META-INF/MANIFEST.MF", "META-INF/CERT.SF", "META-INF/CERT.RSA"};
        jp.a = 0;
        jp.b = null;
        jp.c = new boolean[]{false, true, false, true, true, true};
        jp.g = null;
        jp.h = new WeakReference(null);
        jp.v = new jq();
        jp.i = new WeakReference(null);
        jp.j = new WeakReference(null);
        jp.k = new WeakReference(null);
        jp.w = 0;
        jp.x = false;
        jp.l = 0;
        jp.z = new WeakReference(null);
        jp.A = null;
        jp.B = new Object();
    }

    private jp() {
        this.n = new RandomAccessFile[jp.m.length];
        this.r = new kj[jp.m.length];
        this.f = null;
        this.s = MessageDigest.getInstance("SHA1");
        this.t = MessageDigest.getInstance("SHA1");
        File file0 = this.b(true);
        file0.mkdirs();
        this.o = file0;
        la.a(("Int dir: " + file0.getAbsolutePath()));
        if(jp.g.c == null) {
            File file1 = this.b(false);
            file1.mkdirs();
            ko ko0 = jp.g;
            ko0.c = new File(file1, "temp.apk").getAbsolutePath();
        }
        this.d = new File(jp.g.c);
        la.a(("Apk: " + this.d.getAbsolutePath()));
        if(jp.g.d == null) {
            ko ko1 = jp.g;
            ko1.d = this.j();
        }
        if(jp.g.e == null) {
            jp.g.e = "Uktgocbdxrp";
        }
        this.p = jp.g.d;
        this.q = jp.g.e;
        la.a(("package: catch_.me_.if_.you_.can_ -> " + this.p));
    }

    private static int a(InputStream inputStream0, MessageDigest messageDigest0, byte[] arr_b, int v) {
        int v1 = v;
        while(v1 > 0) {
            int v2 = inputStream0.read(arr_b, 0, (v1 <= arr_b.length ? v1 : arr_b.length));
            if(v2 <= 0) {
                break;
            }
            v1 -= v2;
            messageDigest0.update(arr_b, 0, v2);
        }
        return v;
    }

    private static int a(InputStream inputStream0, byte[] arr_b) {
        return jp.a(inputStream0, arr_b, 0, arr_b.length);
    }

    private static int a(InputStream inputStream0, byte[] arr_b, int v, int v1) {
        for(int v2 = 0; true; v2 += v3) {
            if(v2 >= v1) {
                return v2;
            }
            int v3 = inputStream0.read(arr_b, v + v2, v1 - v2);
            if(v3 <= 0) {
                return v2 == 0 ? -1 : v2;
            }
        }
    }

    private static int a(ZipEntry zipEntry0) {
        String s = zipEntry0.getName();
        int v;
        for(v = 0; true; ++v) {
            if(v >= jp.m.length) {
                return -1;
            }
            if(jp.m[v].equals(s)) {
                break;
            }
        }
        return v;
    }

    private static Intent a(Intent intent0, boolean z) {
        if(z) {
            Context context0 = Tools.e();
            try {
                for(Object object0: Tools.m().queryIntentActivities(intent0, 0x10000)) {
                    ResolveInfo resolveInfo0 = (ResolveInfo)object0;
                    try {
                        context0.grantUriPermission(resolveInfo0.activityInfo.packageName, intent0.getData(), 1);
                    }
                    catch(Throwable throwable1) {
                        la.b(("Failed grant 0 " + intent0 + "; " + resolveInfo0), throwable1);
                    }
                }
            }
            catch(Throwable throwable0) {
                la.b(("Failed grant 1 " + intent0), throwable0);
            }
            try {
                context0.grantUriPermission("com.android.packageinstaller", intent0.getData(), 1);
            }
            catch(Throwable throwable2) {
                la.b(("Failed grant 2 " + intent0), throwable2);
            }
            return intent0;
        }
        return intent0;
    }

    static ko a() {
        if(jp.g == null) {
            ko ko0 = new ko();
            ko0.a = jp.b();
            jp.g = ko0;
        }
        return jp.g;
    }

    private String a(InputStream inputStream0) {
        this.s.reset();
        try(DigestInputStream digestInputStream0 = new DigestInputStream(inputStream0, this.s)) {
            byte[] arr_b = this.r();
            while(true) {
                if(digestInputStream0.read(arr_b) == -1) {
                    break;
                }
            }
        }
        return Base64.encodeToString(this.s.digest(), 2);
    }

    public static final String a(InputStream inputStream0, MessageDigest messageDigest0) {
        int v;
        try {
            byte[] arr_b = new byte[0x2000];
            ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr_b).order(ByteOrder.LITTLE_ENDIAN);
            while(true) {
                if(jp.a(inputStream0, arr_b, 0, 8) == -1) {
                    return ir.a(messageDigest0);
                }
                messageDigest0.update(arr_b, 0, 8);
                kh kh0 = new kh(byteBuffer0);
                if(kh0.a == 0x200) {
                    byte[] arr_b1 = new byte[260];
                    jp.a(inputStream0, arr_b1, 0, 4);
                    messageDigest0.update(arr_b1);
                    jp.a(inputStream0, arr_b1, 4, 0x100);
                    v = kh0.c - 0x10C;
                }
                else {
                    v = kh0.a == 2 ? kh0.b - 8 : kh0.c - 8;
                }
                jp.a(inputStream0, messageDigest0, arr_b, v);
            }
        }
        catch(Throwable throwable0) {
            la.c("hash fail", throwable0);
            return throwable0.toString();
        }
    }

    private String a(ZipEntry zipEntry0, ZipInputStream zipInputStream0, int v) {
        this.s.reset();
        DigestOutputStream digestOutputStream0 = new DigestOutputStream(this.f(v), this.s);
        this.t.reset();
        DigestInputStream digestInputStream0 = new DigestInputStream(zipInputStream0, this.t);
        try {
            byte[] arr_b = this.r();
            int v1;
            while((v1 = digestInputStream0.read(arr_b)) != -1) {
                digestOutputStream0.write(arr_b, 0, v1);
            }
            digestOutputStream0.flush();
        }
        catch(Throwable throwable0) {
            digestOutputStream0.close();
            String s = Base64.encodeToString(this.s.digest(), 2);
            String s1 = Base64.encodeToString(this.t.digest(), 2);
            la.a(("extract " + zipEntry0.getName() + ": " + s1 + " -> " + s));
            throw throwable0;
        }
        digestOutputStream0.close();
        String s2 = Base64.encodeToString(this.s.digest(), 2);
        String s3 = Base64.encodeToString(this.t.digest(), 2);
        la.a(("extract " + zipEntry0.getName() + ": " + s3 + " -> " + s2));
        this.a(zipEntry0, v, s2, s3);
        return s2;
    }

    private String a(ZipEntry zipEntry0, ZipOutputStream zipOutputStream0, int v) {
        int v2;
        byte[] arr_b;
        zipOutputStream0.putNextEntry(zipEntry0);
        this.s.reset();
        DigestInputStream digestInputStream0 = new DigestInputStream(this.d(v), this.s);
        long v1 = 0L;
        try {
            arr_b = this.r();
            while(true) {
            label_5:
                v2 = digestInputStream0.read(arr_b);
                switch(v2) {
                    case -1: {
                        goto label_8;
                    }
                    case 0: {
                    }
                }
            }
        }
        catch(Throwable throwable0) {
            goto label_18;
        }
        goto label_14;
    label_8:
        digestInputStream0.close();
        String s = Base64.encodeToString(this.s.digest(), 2);
        la.a(("put " + zipEntry0.getName() + ": " + s + "; " + v1));
        zipOutputStream0.flush();
        zipOutputStream0.closeEntry();
        return s;
        try {
        label_14:
            zipOutputStream0.write(arr_b, 0, v2);
            v1 += (long)v2;
        }
        catch(Throwable throwable0) {
        label_18:
            digestInputStream0.close();
            String s1 = Base64.encodeToString(this.s.digest(), 2);
            la.a(("put " + zipEntry0.getName() + ": " + s1 + "; " + v1));
            throw throwable0;
        }
        goto label_5;
    }

    public static void a(int v, int v1, Intent intent0) {
        ko ko0 = jp.g;
        la.a(("instance: " + jp.e + "; " + ko0));
        if(ko0 != null) {
            ko0.h = ko0.h + "\nget: " + v1 + " for: " + v + " with: " + intent0;
            if(jp.e != null) {
                switch(v) {
                    case 1: {
                        if(Tools.e(jp.e.p)) {
                            ko0.g &= -2;
                            return;
                        }
                        jp.a((qk.a(0x7F070153) + "\n\n" + Tools.c(0x7F070256) + ":\n" + jp.e.d.getAbsolutePath()), 1, v1, jp.e.p());  // string:failed_install "Failed to install app. Retry?"
                        return;
                    }
                    case 2: {
                        jp.a(qk.a(0x7F070154), 2, v1, jp.a("catch_.me_.if_.you_.can_"));  // string:failed_uninstall "Failed to uninstall app. Retry?"
                    }
                }
            }
        }
    }

    private void a(Intent intent0, int v) {
        jp.g.g |= v;
        Handler handler0 = rx.a();
        jr jr0 = new jr(this, v);
        handler0.postDelayed(jr0, 300000L);
        ar.d.startActivityForResult(intent0, v);
        while((jp.g.g & v) == v) {
            try {
                Thread.sleep(500L);
                if(v != 1 || !Tools.e(this.p)) {
                    continue;
                }
                jp.g.g &= -2;
            }
            catch(InterruptedException interruptedException0) {
                la.c("Interrupted wait", interruptedException0);
                if(true) {
                    break;
                }
            }
        }
        handler0.removeCallbacks(jr0);
        rx.a(new js(this));
    }

    private void a(kn kn0) {
        byte[] arr_b = new byte[8];
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr_b).order(ByteOrder.LITTLE_ENDIAN);
        kn0.a(0L);
        while(true) {
            if(kn0.b(arr_b) == -1) {
                return;
            }
            kh kh0 = new kh(byteBuffer0);
            if(kh0.a == 0x200) {
                kn0.a(4);
                Charset charset0 = ps.a(true);
                kn0.a(Arrays.copyOf(this.p.getBytes(charset0), 60));
                return;
            }
            if(kh0.a == 2) {
                kn0.a(kh0.b - 8);
            }
            else {
                kn0.a(kh0.c - 8);
            }
        }
    }

    static void a(ko ko0) {
        jp.g = ko0;
    }

    private void a(OutputStream outputStream0) {
        byte[] arr_b;
        arr_b = new byte[((int)this.e(4))];
        try(InputStream inputStream0 = this.d(4)) {
            int v = 0;
            for(int v1 = 0; true; ++v1) {
                if(v1 >= 10 || v >= arr_b.length) {
                    break;
                }
                int v2 = inputStream0.read(arr_b, v, arr_b.length - v);
                if(v2 < 0) {
                    la.b(("Failed read cert 1: " + v2 + ' ' + v + ' ' + arr_b.length));
                    break;
                }
                v += v2;
            }
            if(v < arr_b.length) {
                la.b(("Failed read cert 2: " + v + ' ' + arr_b.length));
            }
        }
        ux ux0 = new ux();
        ux0.a(jp.i());
        ux0.a(arr_b);
        byte[] arr_b1 = ux0.a();
        outputStream0.write(Base64.decode("MIIGrgYJKoZIhvcNAQcCoIIGnzCCBpsCAQExCzAJBgUrDgMCGgUAMAsGCSqGSIb3DQEHAaCCBKwwggSoMIIDkKADAgECAgkAk26svgfyAd8wDQYJKoZIhvcNAQEFBQAwgZQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRAwDgYDVQQKEwdBbmRyb2lkMRAwDgYDVQQLEwdBbmRyb2lkMRAwDgYDVQQDEwdBbmRyb2lkMSIwIAYJKoZIhvcNAQkBFhNhbmRyb2lkQGFuZHJvaWQuY29tMB4XDTA4MDIyOTAxMzM0NloXDTM1MDcxNzAxMzM0NlowgZQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRAwDgYDVQQKEwdBbmRyb2lkMRAwDgYDVQQLEwdBbmRyb2lkMRAwDgYDVQQDEwdBbmRyb2lkMSIwIAYJKoZIhvcNAQkBFhNhbmRyb2lkQGFuZHJvaWQuY29tMIIBIDANBgkqhkiG9w0BAQEFAAOCAQ0AMIIBCAKCAQEA1pMZBN7GCySx7cdi4NnYJT4+zWzrHeL/Boyo6LyozWvTeG6nCqds5g67D5k1Wf/ZPnepQ+foPUtkuOT+otPmVvHiZ6gbv7IwtXjCBEO+THIYuEb1IRWG8DihTonCvjh/jr7Pj8rD2h7jMMnqk9Cnw9xK81AiDVAIBzLggJcX7moFM1nmppTsLLPyhKCkZsh6lNg7MQk6ZzcuL2QSwG5tQvFYGN/+A4HMDNRE2mzdw7gkWBlIAbMlZBNPv96YySh3SNv1Z2pUDYFUyLvKB7niR1UzEcRrmvdv3uzMjmnnyKLQjngmIJQ/mXJ9PAT+cpkdmd+brjigshd/ox1bav7pHwIBA6OB/DCB+TAdBgNVHQ4EFgQUSFkAVj0nLEauEYYFpHQZrAnKjBEwgckGA1UdIwSBwTCBvoAUSFkAVj0nLEauEYYFpHQZrAnKjBGhgZqkgZcwgZQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRAwDgYDVQQKEwdBbmRyb2lkMRAwDgYDVQQLEwdBbmRyb2lkMRAwDgYDVQQDEwdBbmRyb2lkMSIwIAYJKoZIhvcNAQkBFhNhbmRyb2lkQGFuZHJvaWQuY29tggkAk26svgfyAd8wDAYDVR0TBAUwAwEB/zANBgkqhkiG9w0BAQUFAAOCAQEAeq+WjOtQxEEFURjQ2quvAVuKdlonpxWiwrRPIhQV/9rOAwlav6Qt9wcIcmwgaeXDbt2uBAC+KUUsCEvCfrahfqydvhgsIE6xUxH0Vdgktlbb5NwiQJEtdYb+iJUdAaj+ta5aQmBTXfg0MQUkIkaMNuIsKl75lNYd1zBq5Mn2lRujwS8dGRTdxh8aYtot+Cf2A/6lYDssVA29fAGcNrqymkJxwRffUjzbxfOBekng76YMvX90F356Txk9Q/QiB3JmbkxNg+G9WoYIfPNPLewh4kXKbCuwFuaDY4BQ0sQw7qfCahxJ03YKWKt/GoLMk4tIMThDJL0EAfoSFjpQVw5oTTGCAcowggHGAgEBMIGiMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbQIJAJNurL4H8gHfMAkGBSsOAwIaBQAwDQYJKoZIhvcNAQEBBQAEggEA", 0));
        outputStream0.write(arr_b1);
        outputStream0.flush();
    }

    public static void a(Runnable runnable0) {
        boolean z = false;
        Intent intent0 = ar.d.getIntent();
        if(intent0 != null && intent0.getBooleanExtra("catch_.me_.if_.you_.can_.fromInstaller", false)) {
            z = true;
        }
        la.a(("removeInstaller: " + z + " + " + ar.c));
        if(ar.c || z) {
            ar.c = true;
            la.a((runnable0 + ": 30"));
            ty.a("catch_.me_.if_.you_.can_", runnable0);
            la.a((runnable0 + ": 40"));
            return;
        }
        runnable0.run();
    }

    private static void a(String s, int v, int v1, Intent[] arr_intent) {
        rx.a(new kc(v1, s, v, arr_intent));
    }

    private static void a(StringBuilder stringBuilder0, ZipEntry zipEntry0) {
        if(zipEntry0 == null) {
            return;
        }
        stringBuilder0.append('-');
        stringBuilder0.append(zipEntry0.getSize());
        stringBuilder0.append(' ');
    }

    private void a(Manifest manifest0, OutputStream outputStream0) {
        outputStream0.write("Signature-Version: 1.0\r\n".getBytes());
        outputStream0.write("Created-By: 1.0 (Android SignApk)\r\n".getBytes());
        this.s.reset();
        PrintStream printStream0 = new PrintStream(new DigestOutputStream(new kk(null), this.s), true, "UTF-8");
        manifest0.write(printStream0);
        printStream0.flush();
        outputStream0.write(("SHA1-Digest-Manifest: " + Base64.encodeToString(this.s.digest(), 2) + "\r\n\r\n").getBytes());
        for(Object object0: manifest0.getEntries().entrySet()) {
            String s = "Name: " + ((String)((Map.Entry)object0).getKey()) + "\r\n";
            printStream0.print(s);
            for(Object object1: ((Attributes)((Map.Entry)object0).getValue()).entrySet()) {
                printStream0.print(((Map.Entry)object1).getKey() + ": " + ((Map.Entry)object1).getValue() + "\r\n");
            }
            printStream0.print("\r\n");
            printStream0.flush();
            outputStream0.write(s.getBytes());
            outputStream0.write(("SHA1-Digest: " + Base64.encodeToString(this.s.digest(), 2) + "\r\n\r\n").getBytes());
        }
        outputStream0.flush();
    }

    private void a(ZipEntry zipEntry0, int v) {
        OutputStream outputStream0 = null;
        try {
            switch(v) {
                case 1: {
                    this.t();
                    break;
                }
                case 0: 
                case 2: {
                    kn kn0 = new kn(this, v, null);
                    if(v == 0) {
                        this.b(kn0);
                    }
                    else {
                        this.a(kn0);
                    }
                    break;
                }
                case 3: {
                    this.u = this.b(zipEntry0);
                    Map map0 = this.u.getEntries();
                    for(int v1 = 0; v1 < jp.m.length; ++v1) {
                        Attributes attributes0 = (Attributes)map0.get(jp.m[v1]);
                        if(attributes0 != null) {
                            attributes0.putValue("SHA1-Digest", this.a(this.d(v1)));
                        }
                    }
                    if(jp.a != 0) {
                        map0.put((jp.a == 1 ? "lib/armeabi/libAndroid.so" : "lib/arm64-v8a/libAndroid.so"), ((Attributes)map0.remove("res/raw/ydw3a")));
                        map0.put((jp.a == 1 ? "lib/x86/libAndroid.so" : "lib/x86_64/libAndroid.so"), ((Attributes)map0.remove("res/raw/ydw3x")));
                    }
                    Manifest manifest0 = this.u;
                    outputStream0 = this.f(3);
                    manifest0.write(outputStream0);
                    break;
                }
                case 4: {
                    if(this.u != null) {
                        Manifest manifest1 = this.u;
                        outputStream0 = this.f(4);
                        this.a(manifest1, outputStream0);
                    }
                    break;
                }
                case 5: {
                    outputStream0 = this.f(5);
                    this.a(outputStream0);
                    break;
                }
                default: {
                    throw new IOException("unknown index: " + v);
                }
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(outputStream0, throwable0);
            throw throwable0;
        }
        if(outputStream0 != null) {
            outputStream0.close();
        }
    }

    private void a(ZipEntry zipEntry0, int v, String s, String s1) {
        this.s.reset();
        DigestInputStream digestInputStream0 = new DigestInputStream(this.d(v), this.s);
        try {
            byte[] arr_b = this.r();
            while(digestInputStream0.read(arr_b) != -1) {
            }
        }
        catch(Throwable throwable0) {
            digestInputStream0.close();
            String s2 = Base64.encodeToString(this.s.digest(), 2);
            la.a(("check hash for " + zipEntry0.getName() + " [" + v + "]: " + s2 + " : " + s1 + " -> " + s));
            throw throwable0;
        }
        digestInputStream0.close();
        String s3 = Base64.encodeToString(this.s.digest(), 2);
        la.a(("check hash for " + zipEntry0.getName() + " [" + v + "]: " + s3 + " : " + s1 + " -> " + s));
        if(!s.equals(s3)) {
            throw new ki("check hash for " + zipEntry0.getName() + " [" + v + "]: " + s3 + " != " + s1 + " -> " + s);
        }
    }

    private void a(ZipEntry zipEntry0, ZipInputStream zipInputStream0, ZipOutputStream zipOutputStream0) {
        int v = jp.a(zipEntry0);
        ZipEntry zipEntry1 = new ZipEntry(zipEntry0);
        if(v != -1) {
            this.b(zipEntry1, v);
            if(this.r[v] == null) {
                la.b(("List: " + v + " is null!"));
                return;
            }
            kj kj0 = this.r[v];
            kj0.c = this.a(zipEntry1, zipOutputStream0, v);
            return;
        }
        this.b(zipEntry1, zipInputStream0, zipOutputStream0);
    }

    static void a(boolean z) {
        try {
            jp.b("installer.fail").createNewFile();
        }
        catch(IOException iOException0) {
            la.c("Failed set install flag", iOException0);
        }
        if(z) {
            rx.a(new kb());
        }
    }

    private static byte[] a(byte[] arr_b, int v, int v1) [...] // 潜在的解密器

    @TargetApi(14)
    public static Intent[] a(File file0) {
        int v4;
        boolean z = Build.VERSION.SDK_INT >= 14;
        Intent[] arr_intent = new Intent[(z ? 4 : 2)];
        int v = Build.VERSION.SDK_INT < 24 ? 0 : 1;
        boolean z1 = jp.x;
        int v1 = 0;
        for(int v2 = 0; v2 < 2; ++v2) {
            int v3 = (v2 == 0 ? 1 : 0) ^ v;
            Uri uri0 = v3 == 0 ? FileProvider.a(Tools.e(), y.d, file0) : Uri.fromFile(file0);
            if(z) {
                Intent intent0 = new Intent("android.intent.action.INSTALL_PACKAGE");
                intent0.setDataAndType(uri0, "application/vnd.android.package-archive");
                intent0.addFlags(1);
                intent0.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                intent0.putExtra("android.intent.extra.RETURN_RESULT", true);
                arr_intent[v1] = jp.a(intent0, !z1 && v3 == 0);
                v4 = v1 + 1;
            }
            else {
                v4 = v1;
            }
            Intent intent1 = new Intent("android.intent.action.VIEW");
            intent1.setDataAndType(uri0, "application/vnd.android.package-archive");
            intent1.addFlags(1);
            v1 = v4 + 1;
            arr_intent[v4] = jp.a(intent1, !z1 && v3 == 0);
        }
        jp.x = true;
        return arr_intent;
    }

    @TargetApi(14)
    public static Intent[] a(String s) {
        int v = 1;
        boolean z = Build.VERSION.SDK_INT >= 14;
        Intent[] arr_intent = new Intent[(z ? 2 : 1)];
        if(z) {
            Intent intent0 = new Intent("android.intent.action.UNINSTALL_PACKAGE");
            intent0.setData(Uri.fromParts("package", s, null));
            intent0.putExtra("android.intent.extra.RETURN_RESULT", true);
            intent0.putExtra("android.intent.extra.UNINSTALL_ALL_USERS", true);
            arr_intent[0] = intent0;
        }
        else {
            v = 0;
        }
        Intent intent1 = new Intent("android.intent.action.DELETE");
        intent1.setData(Uri.fromParts("package", s, null));
        arr_intent[v] = intent1;
        return arr_intent;
    }

    RandomAccessFile a(int v) {
        RandomAccessFile randomAccessFile0 = this.n[v];
        if(randomAccessFile0 == null) {
            randomAccessFile0 = new RandomAccessFile(this.g(v), "rw");
            la.a(("RAF new: " + v + ' ' + randomAccessFile0.getFD()));
            this.n[v] = randomAccessFile0;
        }
        la.a(("RAF get: " + v + ' ' + randomAccessFile0.getFD()));
        return randomAccessFile0;
    }

    private static File b(String s) {
        File file0 = Tools.l();
        file0.mkdirs();
        return new File(file0, s.replace('/', '@'));
    }

    @SuppressLint({"SdCardPath"})
    @TargetApi(19)
    private File b(boolean z) {
        ArrayList arrayList0 = new ArrayList();
        if(z) {
            arrayList0.add(Tools.i());
            arrayList0.add(Tools.h());
        }
        try {
            arrayList0.add(ar.f.getExternalCacheDir());
        }
        catch(Throwable throwable0) {
            la.c("Fail get path", throwable0);
        }
        if(Build.VERSION.SDK_INT >= 19) {
            try {
                File[] arr_file = ar.f.getExternalCacheDirs();
            label_11:
                for(int v = 0; v < arr_file.length; ++v) {
                    arrayList0.add(arr_file[v]);
                }
            }
            catch(Throwable throwable1) {
                la.c("Fail get path", throwable1);
                if(true) {
                    goto label_18;
                }
                goto label_11;
            }
        }
        try {
        label_18:
            arrayList0.add(ar.f.getExternalFilesDir(null));
        }
        catch(Throwable throwable2) {
            la.c("Fail get path", throwable2);
        }
        if(Build.VERSION.SDK_INT >= 19) {
            try {
                File[] arr_file1 = ar.f.getExternalFilesDirs(null);
            label_25:
                for(int v1 = 0; v1 < arr_file1.length; ++v1) {
                    arrayList0.add(arr_file1[v1]);
                }
            }
            catch(Throwable throwable3) {
                la.c("Fail get path", throwable3);
                if(true) {
                    goto label_32;
                }
                goto label_25;
            }
        }
        try {
        label_32:
            arrayList0.add(Environment.getExternalStorageDirectory());
        }
        catch(Throwable throwable4) {
            la.c("Fail get path", throwable4);
        }
        try {
            arrayList0.add(new File("/sdcard/Android/data/" + Tools.g() + "/files"));
            arrayList0.add(new File("/mnt/sdcard/Android/data/" + Tools.g() + "/files"));
            arrayList0.add(new File("/sdcard/Android/data/" + Tools.g() + "/cache"));
            arrayList0.add(new File("/mnt/sdcard/Android/data/" + Tools.g() + "/cache"));
        }
        catch(Throwable throwable5) {
            la.c("Fail get path", throwable5);
        }
        arrayList0.add(new File("/sdcard"));
        arrayList0.add(new File("/mnt/sdcard"));
        arrayList0.add(new File("/data/local/tmp"));
        arrayList0.add(Tools.h());
        arrayList0.add(Tools.i());
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("Failed getDir: ");
        Iterator iterator0 = arrayList0.iterator();
        while(true) {
            if(!iterator0.hasNext()) {
                throw new RuntimeException(stringBuilder0.toString());
            }
            Object object0 = iterator0.next();
            File file0 = (File)object0;
            String s = this.b(file0);
            if(s == null) {
                return file0;
            }
            if(file0 != null) {
                stringBuilder0.append(file0.getAbsolutePath());
                stringBuilder0.append(": ");
                stringBuilder0.append(s);
                stringBuilder0.append("; ");
            }
        }
    }

    private static String b(int v) [...] // 潜在的解密器

    private String b(File file0) {
        if(file0 == null) {
            la.a(("path: " + null + " - null"));
            return "is null";
        }
        file0.mkdirs();
        try {
            File file1 = new File(file0, "temp.apk");
            file1.delete();
            byte[] arr_b = "We need test read/write to this file".getBytes();
            byte[] arr_b1 = new byte[arr_b.length];
            FileOutputStream fileOutputStream0 = new FileOutputStream(file1);
            Tools.a(file1, 0x180);
            fileOutputStream0.write(arr_b);
            fileOutputStream0.close();
            FileInputStream fileInputStream0 = new FileInputStream(file1);
            int v = fileInputStream0.read(arr_b1);
            fileInputStream0.close();
            if(v != arr_b.length) {
                return "Length mismatch: " + v + " != " + arr_b.length;
            }
            if(!Arrays.equals(arr_b1, arr_b)) {
                return "Data mismatch: \'" + new String(arr_b1) + "\' != \'" + new String(arr_b) + '\'';
            }
            file1.delete();
            la.a(("path: " + file0 + " - success"));
            return null;
        }
        catch(IOException iOException0) {
            la.a(("path: " + file0 + " - fail: " + iOException0.getMessage()));
            return iOException0.getMessage();
        }
    }

    public static final String b(InputStream inputStream0, MessageDigest messageDigest0) {
        try {
            byte[] arr_b = new byte[0x2000];
            ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr_b).order(ByteOrder.LITTLE_ENDIAN);
            int v = jp.a(inputStream0, arr_b, 0, 0x40);
            messageDigest0.update(arr_b, 56, 8);
            byteBuffer0.position(56);
            int v1 = byteBuffer0.getInt();
            int v2 = jp.a(inputStream0, messageDigest0, arr_b, byteBuffer0.getInt() + 0x3CF0 - v);
            byte[] arr_b1 = new byte[(v1 - 10168) * 4];
            int v3 = jp.a(inputStream0, arr_b1);
            ByteBuffer byteBuffer1 = ByteBuffer.wrap(arr_b1).order(ByteOrder.LITTLE_ENDIAN);
            int v4 = byteBuffer1.getInt(0);
            int v5 = byteBuffer1.getInt((v1 - 10169) * 4);
            la.a(("DBG: " + v3 + "; " + arr_b1.length + ", " + v4 + "; " + v5));
            byte[] arr_b2 = new byte[v5 - v4];
            jp.a(inputStream0, messageDigest0, arr_b, v4 - (v2 + v + v3));
            jp.a(inputStream0, arr_b2);
            int v6 = Tools.a(arr_b2, "\u0017Lcar$".getBytes(ps.a(false)));
            messageDigest0.update(arr_b2, 0, v6);
            if(arr_b2.length > v6 + 1700) {
                messageDigest0.update(arr_b2, v6 + 1700, arr_b2.length - (v6 + 1700));
            }
            jp.a(inputStream0, messageDigest0, arr_b, 0x7FFFFFFF);
            return ir.a(messageDigest0);
        }
        catch(Throwable throwable0) {
            la.c("hash fail", throwable0);
            return throwable0.toString();
        }
    }

    private Manifest b(ZipEntry zipEntry0) {
        Manifest manifest0;
        try {
            this.s.reset();
            DigestInputStream digestInputStream0 = new DigestInputStream(this.d(3), this.s);
            try {
                manifest0 = new Manifest(digestInputStream0);
            }
            finally {
                digestInputStream0.close();
            }
            la.a(("Manifest: " + Base64.encodeToString(this.s.digest(), 2) + " -> " + this.r[3]));
            return manifest0;
        }
        catch(IOException iOException0) {
            throw new IOException("Failed get manifest: " + Base64.encodeToString(this.s.digest(), 2) + " -> " + this.r[3], iOException0);
        }
    }

    private void b(kn kn0) {
        byte[] arr_b = new byte[8];
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr_b).order(ByteOrder.LITTLE_ENDIAN);
        kn0.a(56L);
        kn0.a(arr_b, 0, 8);
        byteBuffer0.position(0);
        int v = byteBuffer0.getInt();
        int v1 = byteBuffer0.getInt();
        byte[] arr_b1 = new byte[(v - 10168) * 4];
        kn0.a(((long)(v1 + 0x3CF0)));
        kn0.b(arr_b1);
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(arr_b1).order(ByteOrder.LITTLE_ENDIAN);
        int[] arr_v = new int[v - 10168];
        for(int v2 = 0; v2 < v - 10168; ++v2) {
            arr_v[v2] = byteBuffer1.getInt();
        }
        byte[] arr_b2 = new byte[arr_v[arr_v.length - 1] - arr_v[0]];
        kn0.a(((long)arr_v[0]));
        kn0.b(arr_b2);
        int v3 = Tools.a(arr_b2, "\u0017Lcar$".getBytes(ps.a(false)));
        if(v3 < 0) {
            la.a("fixDex fail 1");
            return;
        }
        byte[] arr_b3 = (String.valueOf(this.q) + '~').getBytes(ps.a(false));
        System.arraycopy(arr_b3, 0, arr_b2, v3 + 6, arr_b3.length);
        int v4 = Arrays.binarySearch(arr_v, v3 + arr_v[0]);
        if(v4 < 0) {
            la.a("fixDex fail 2");
            return;
        }
        int v5 = 24 - this.p.length();
        Class[] arr_class = jp.s();
        for(int v6 = 0; v6 < arr_class.length; ++v6) {
            String s = arr_class[v6].getName().replace(y.d, this.p);
            int v7 = s.length();
            String s1 = s.replace('.', '/');
            byteBuffer1.putInt((v4 + 2 + 2 * v6) * 4, arr_v[v4 + 2 + 2 * v6] - v5);
            byte[] arr_b4 = (((char)(v7 + 2)) + 'L' + s1 + ';' + '\u0000' + ((char)(v7 + 2 + v5 * 2)) + 'L' + s1 + '=' + new String(new char[v5 * 2]).replace('\u0000', '=') + '\u0000').getBytes(ps.a(false));
            System.arraycopy(arr_b4, 0, arr_b2, arr_v[v6 * 2 + (v4 + 1)] - arr_v[0], arr_b4.length);
        }
        byte[] arr_b5 = (this.p.replace('.', '/') + new String(new char[v5]).replace('\u0000', '~')).getBytes(ps.a(false));
        System.arraycopy(arr_b5, 0, arr_b2, arr_v[arr_class.length * 2 + (v4 + 1)] - arr_v[0] + 2, arr_b5.length);
        kn0.a(((long)(v1 + v4 * 4 + 0x3CF4)));
        kn0.b(arr_b1, (v4 + 1) * 4, arr_class.length * 8);
        kn0.a(((long)arr_v[v4]));
        kn0.b(arr_b2, arr_v[v4] - arr_v[0], arr_v[arr_class.length * 2 + (v4 + 1) + 1] - arr_v[v4]);
        byte[] arr_b6 = this.r();
        kn0.a(0x20L);
        this.s.reset();
        int v8;
        while((v8 = kn0.b(arr_b6)) != -1) {
            this.s.update(arr_b6, 0, v8);
        }
        kn0.a(12L);
        kn0.a(this.s.digest());
        Adler32 adler320 = new Adler32();
        kn0.a(12L);
        int v9;
        while((v9 = kn0.b(arr_b6)) != -1) {
            adler320.update(arr_b6, 0, v9);
        }
        kn0.a(8L);
        byteBuffer1.putInt(0, ((int)adler320.getValue()));
        kn0.b(byteBuffer1.array(), 0, 4);
    }

    private void b(ZipEntry zipEntry0, int v) {
        int v2;
        long v1;
        byte[] arr_b;
        InputStream inputStream0;
        CRC32 cRC320;
        try {
            la.a(("updateEntry f: " + u.a(zipEntry0)));
            cRC320 = new CRC32();
            try(inputStream0 = this.d(v)) {
                arr_b = this.r();
                v1 = 0L;
                while(true) {
                label_7:
                    v2 = inputStream0.read(arr_b);
                    switch(v2) {
                        case -1: {
                            goto label_11;
                        }
                        case 0: {
                        }
                    }
                }
            }
        }
        catch(Throwable throwable0) {
            goto label_22;
        }
        goto label_17;
    label_11:
        zipEntry0.setCrc(cRC320.getValue());
        long v3 = this.e(v);
        zipEntry0.setSize(v3);
        zipEntry0.setCompressedSize((zipEntry0.getMethod() == 0 ? v3 : -1L));
        la.a(("updateEntry t: " + u.a(zipEntry0) + ' ' + v3 + ' ' + v1));
        return;
        try {
        label_17:
            TWR.useResource$NT(inputStream0);
            cRC320.update(arr_b, 0, v2);
            v1 = ((long)v2) + v1;
        }
        catch(Throwable throwable0) {
        label_22:
            TWR.moot$NT();
            throw throwable0;
        }
        goto label_7;
    }

    private void b(ZipEntry zipEntry0, ZipInputStream zipInputStream0, ZipOutputStream zipOutputStream0) {
        if(zipEntry0.getMethod() != 0) {
            zipEntry0.setCompressedSize(-1L);
        }
        if(jp.a != 0) {
            String s = zipEntry0.getName();
            String s1 = null;
            if("res/raw/ydw3a".equals(s)) {
                s1 = jp.a == 1 ? "lib/armeabi/libAndroid.so" : "lib/arm64-v8a/libAndroid.so";
            }
            if("res/raw/ydw3x".equals(s)) {
                s1 = jp.a == 1 ? "lib/x86/libAndroid.so" : "lib/x86_64/libAndroid.so";
            }
            if(s1 != null) {
                try {
                    Field field0 = ZipEntry.class.getDeclaredField("name");
                    field0.setAccessible(true);
                    field0.set(zipEntry0, s1);
                }
                catch(Throwable throwable0) {
                    la.a(throwable0);
                }
            }
        }
        zipOutputStream0.putNextEntry(zipEntry0);
        byte[] arr_b = this.r();
        int v;
        while((v = zipInputStream0.read(arr_b)) != -1) {
            zipOutputStream0.write(arr_b, 0, v);
        }
        zipOutputStream0.flush();
        zipOutputStream0.closeEntry();
    }

    public static boolean b() {
        jp.h();
        try {
            if(new File("/data/GG.skip.install").exists()) {
                return false;
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return "catch_.me_.if_.you_.can_".equals(Tools.g()) && !jp.b("installer.fail").exists();
        }
        return "catch_.me_.if_.you_.can_".equals(Tools.g()) && !jp.b("installer.fail").exists();
    }

    public static final String c(InputStream inputStream0, MessageDigest messageDigest0) {
        int v5;
        String s;
        int v2;
        try {
            byte[] arr_b = new byte[0x4000];
            int v1 = jp.a(inputStream0, arr_b);
            try {
                PackageInfo packageInfo0 = Tools.k(Tools.g());
                v2 = packageInfo0.versionCode;
                s = packageInfo0.versionName;
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
                v2 = 0x3F0E;
                s = 101.099998f;
            }
            byte[][] arr2_b = {("\u0000" + ((char)y.d.length()) + y.d + '\u0000').getBytes(ps.a(true)), ("\u0000" + ((char)y.e.length()) + y.e + '\u0000').getBytes(ps.a(true)), ("\u0000" + ((char)s.length()) + s + '\u0000').getBytes(ps.a(true)), new byte[]{44, 0, 2, 0x7F}, new byte[]{0, 0, 3, 0x7F}, new byte[]{1, 0, 3, 0x7F}, new byte[]{4, 0, 3, 0x7F}, new byte[]{2, 0, 3, 0x7F}, new byte[]{3, 0, 3, 0x7F}, new byte[]{7, 0, 3, 0x7F}, new byte[]{5, 0, 3, 0x7F}, new byte[]{6, 0, 3, 0x7F}, jp.a(jp.a(null, 4, v2), 0, 0x10000008)};
            for(int v = 0; true; ++v) {
                if(v >= 13) {
                    int v3 = ByteBuffer.wrap(arr_b).order(ByteOrder.LITTLE_ENDIAN).getInt(16);
                    System.arraycopy(new byte[v3 * 4], 0, arr_b, 36, v3 * 4);
                    messageDigest0.update(arr_b, 0, v1);
                    return ir.a(messageDigest0);
                }
                byte[] arr_b1 = arr2_b[v];
                int v4 = Tools.a(arr_b, arr_b1);
                if(v4 >= 0) {
                    switch(v) {
                        case 0: {
                            v5 = 56;
                            break;
                        }
                        case 1: {
                            v5 = 0x20;
                            break;
                        }
                        default: {
                            v5 = arr_b1.length;
                        }
                    }
                    System.arraycopy(new byte[v5], 0, arr_b, v4, v5);
                }
            }
        }
        catch(Throwable throwable0) {
            la.c("hash fail", throwable0);
            return throwable0.toString();
        }
    }

    public static void c() {
        jp.k();
        new hx(() -> {
            jp.b = new byte[jp.m.length][];
            try {
                jp.e = new jp();
                jp.e.l();
                rx.a(new jv());
            }
            catch(Throwable throwable0) {
                la.c("Failed install", throwable0);
                String s = throwable0.getMessage();
                if(s != null && (s.contains("ENOSPC") || s.contains("o space left"))) {
                    rx.a(new jw(s));
                    return;
                }
                if(!(throwable0 instanceof ki)) {
                    ho.a(Thread.currentThread(), throwable0, false);
                }
                jp.a(false);
                rx.a(new jy(throwable0));
            }
        }, "Installer").start();
    }

    private static void c(int v) {
        if(jp.g.b != v) {
            jp.w = 0;
        }
        jp.g.b = v;
    }

    private InputStream d(int v) {
        if(jp.c[v]) {
            if(jp.b == null || jp.b[v] == null) {
                throw new ki("memCache is null 1: " + v + ' ' + jp.b);
            }
            return new ByteArrayInputStream(jp.b[v]);
        }
        la.a(("getInputStream: " + v));
        return new kl(this.a(v), null);
    }

    // 检测为 Lambda 实现
    static void d() [...]

    private long e(int v) {
        if(jp.c[v]) {
            if(jp.b == null || jp.b[v] == null) {
                throw new ki("memCache is null 2: " + v + ' ' + jp.b);
            }
            return (long)jp.b[v].length;
        }
        return this.a(v).length();
    }

    static void e() {
        int v = jp.g.b + jp.w;
        int v1 = v <= 1000 ? v : 1000;
        ProgressBar progressBar0 = (ProgressBar)jp.i.get();
        if(progressBar0 != null) {
            progressBar0.setMax(1000);
            progressBar0.setProgress(v1);
        }
        TextView textView0 = (TextView)jp.j.get();
        if(textView0 != null) {
            textView0.setText(Tools.a("%.1f %%", new Object[]{((double)(100.0 * ((double)v1) / 1000.0))}));
        }
        if(jp.w < 0xC7) {
            ++jp.w;
        }
        if(jp.g.b == 600) {
            if(jp.w == 60) {
                TextView textView1 = (TextView)jp.k.get();
                String s = jp.g.c;
                if(textView1 != null && s != null) {
                    textView1.setText(qk.a(0x7F070152) + "\n\n" + Tools.c(0x7F070256) + ":\n" + s);  // string:installing "__app_name__ performs a reinstallation of itself with a random 
                                                                                                     // name to exclude detection by games. Wait."
                }
            }
            if(jp.w == 0xC6 && jp.e != null) {
                jp.a((qk.a(0x7F070153) + "\n\n" + Tools.c(0x7F070256) + ":\n" + jp.e.d.getAbsolutePath()), 1, 0xFFFFFF85, jp.e.p());  // string:failed_install "Failed to install app. Retry?"
            }
        }
    }

    private OutputStream f(int v) {
        km km0;
        boolean z = jp.c[v];
        if(z) {
            km0 = null;
        }
        else {
            try {
                la.a(("getOutputStream: " + v));
                km0 = new km(this.a(v), null);
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
                km0 = null;
            }
            if(km0 == null) {
                la.a(("Use mem cache for " + v));
                jp.c[v] = true;
                z = true;
            }
        }
        if(z) {
            if(v == 1) {
                return new jt(this, 9000, 1);
            }
            switch(v) {
                case 3: 
                case 4: {
                    return new jt(this, 75000, v);
                }
                case 5: {
                    return new jt(this, 2000, 5);
                }
                default: {
                    return new jt(this, 0x2000, v);
                }
            }
        }
        return km0;
    }

    void f() {
        if(this.f != null) {
            try {
                Tools.a(this.f);
                this.f = null;
            }
            catch(Throwable throwable0) {
                la.b("Exception on dismiss", throwable0);
            }
        }
    }

    private File g(int v) {
        File file0 = new File(this.o, jp.m[v].replace('/', '@'));
        if(file0.exists()) {
            Tools.a(file0, 0x180);
        }
        return file0;
    }

    public static String g() {
        ZipEntry zipEntry4;
        String s;
        int v9;
        int v6;
        if(jp.A == null) {
            synchronized(jp.B) {
                if(jp.A == null) {
                    long v1 = System.currentTimeMillis();
                    StringBuilder stringBuilder0 = new StringBuilder();
                    try {
                        ZipFile zipFile0 = new ZipFile(jp.v());
                        ZipEntry zipEntry0 = null;
                        long v2 = 0L;
                        int v3 = 0;
                        long v4 = 0L;
                        int v5 = FIN.finallyOpen$NT();
                        Enumeration enumeration0 = zipFile0.entries();
                        ZipEntry zipEntry1 = null;
                        for(ZipEntry zipEntry2 = null; true; zipEntry2 = zipEntry4) {
                            if(!enumeration0.hasMoreElements()) {
                                jp.a(stringBuilder0, zipEntry0);
                                if(zipEntry1 == null) {
                                    v6 = v3;
                                }
                                else {
                                    v2 += zipEntry1.getSize();
                                    v6 = v3 + 1;
                                }
                                long v7 = zipEntry2 == null ? v4 : zipEntry2.getCrc() + v4;
                                stringBuilder0.append(v2);
                                stringBuilder0.append(' ');
                                stringBuilder0.append(v6);
                                stringBuilder0.append(' ');
                                stringBuilder0.append(Long.toHexString(v7));
                                FIN.finallyCodeBegin$NT(v5);
                                zipFile0.close();
                                FIN.finallyCodeEnd$NT(v5);
                                break;
                            }
                            ZipEntry zipEntry3 = (ZipEntry)enumeration0.nextElement();
                            boolean z = zipEntry3.getName().contains("META-INF");
                            int v8 = jp.a(zipEntry3);
                            jp.a(stringBuilder0, zipEntry0);
                            if(zipEntry1 == null) {
                                v9 = v3;
                            }
                            else {
                                v2 += zipEntry1.getSize();
                                v9 = v3 + 1;
                            }
                            long v10 = zipEntry2 == null ? v4 : v4 + zipEntry2.getCrc();
                            if(v8 != 0 && v8 != 1 && v8 != 2) {
                                zipEntry4 = z ? null : zipEntry3;
                                zipEntry0 = null;
                            }
                            else {
                                stringBuilder0.append(v8);
                                stringBuilder0.append('-');
                                MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-384");
                                long v11 = System.currentTimeMillis();
                                InputStream inputStream0 = zipFile0.getInputStream(zipEntry3);
                                switch(v8) {
                                    case 0: {
                                        s = jp.b(inputStream0, messageDigest0);
                                        break;
                                    }
                                    case 2: {
                                        s = jp.a(inputStream0, messageDigest0);
                                        break;
                                    }
                                    default: {
                                        s = jp.c(inputStream0, messageDigest0);
                                    }
                                }
                                la.a(("HH: " + v8 + " = " + (System.currentTimeMillis() - v11)));
                                stringBuilder0.append(zipEntry3.getMethod());
                                stringBuilder0.append('-');
                                stringBuilder0.append(zipEntry3.getTime());
                                stringBuilder0.append('-');
                                stringBuilder0.append(s);
                                zipEntry4 = null;
                                zipEntry0 = zipEntry3;
                            }
                            if(z) {
                                zipEntry3 = null;
                            }
                            v4 = v10;
                            v3 = v9;
                            zipEntry1 = zipEntry3;
                        }
                    }
                    catch(Throwable throwable0) {
                        la.c("Failed get hashes", throwable0);
                        stringBuilder0.append("e:");
                        stringBuilder0.append(throwable0);
                    }
                    jp.A = stringBuilder0.toString();
                    la.a(("HH: " + (System.currentTimeMillis() - v1)));
                }
            }
        }
        return jp.A;
    }

    private static void h() {
        try {
            File file0 = jp.b("version.gg");
            byte[] arr_b = ("16142" + ':' + 101.099998f).getBytes();
            if(file0.exists()) {
                try {
                    FileInputStream fileInputStream0 = new FileInputStream(file0);
                    try {
                        byte[] arr_b1 = new byte[arr_b.length];
                        if(fileInputStream0.read(arr_b1) != arr_b1.length || !Arrays.equals(arr_b1, arr_b)) {
                            jp.b("installer.fail").delete();
                            File file1 = Tools.l();
                            String[] arr_s = file1.list();
                            if(arr_s != null) {
                                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                                    String s = arr_s[v1];
                                    if(s.startsWith("lib") && s.endsWith(".so") || "gr".equals(s)) {
                                        new File(file1, s).delete();
                                    }
                                }
                            }
                        }
                    }
                    finally {
                        fileInputStream0.close();
                    }
                }
                catch(Throwable throwable1) {
                    la.c("Fail get version", throwable1);
                }
            }
            FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
            Tools.a(file0, 0x180);
            try {
                fileOutputStream0.write(arr_b);
            }
            finally {
                fileOutputStream0.close();
            }
        }
        catch(Throwable throwable0) {
            la.c("Fail set version", throwable0);
        }
    }

    private static PrivateKey i() {
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec0 = new PKCS8EncodedKeySpec(Base64.decode("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDWkxkE3sYLJLHtx2Lg2dglPj7NbOsd4v8GjKjovKjNa9N4bqcKp2zmDrsPmTVZ/9k+d6lD5+g9S2S45P6i0+ZW8eJnqBu/sjC1eMIEQ75Mchi4RvUhFYbwOKFOicK+OH+Ovs+PysPaHuMwyeqT0KfD3ErzUCINUAgHMuCAlxfuagUzWeamlOwss/KEoKRmyHqU2DsxCTpnNy4vZBLAbm1C8VgY3/4DgcwM1ETabN3DuCRYGUgBsyVkE0+/3pjJKHdI2/VnalQNgVTIu8oHueJHVTMRxGua92/e7MyOaefIotCOeCYglD+Zcn08BP5ymR2Z35uuOKCyF3+jHVtq/ukfAgEDAoIBAQCPDLtYlIQHbcvz2kHrO+VuKX8znfIT7KoEXcXwfcXeR+JQScSxxPNECdIKZiORVTt++nDX7/Ao3O3QmKnB4pmPS+xFGr0qdssjpdatgn7doWXQL04WDln1exY0W9cpev+0fzUKhy08FJd12/G34G/X6DH3isFeNVqvd0BVug/0RXWihnmONcUztAJ25E5YNqHadWSt+vU4pJOpvxDyE6ZXrBIpHBvlaZf8atJ7maf8iXfSZUzrqnx1O5zaTGRnGo7o/UdrfuLDfpVXnXBEHm+rk6QTq2ZKyZj6JZQ/K1LB+cXqZO9KG8oBSecXohQBeJYIDEikB9xHdsvelr1MoYR7AoGBAOrAmRccm5UnjAe/npdFGIVXkXaep7Ur9rqT4NaoSMSnDRim6Kii2lNoZ2szvvKYuxRNmvi1u60iRvQsLM10duqyG+FKdx+S5632ALWTKvdH97l3VYcRCrDYAyMYdotYavF8bcT9QKgYHoWHb18KLL27A4afIXmrVXCnWXp1e2GbAoGBAOn+9xk0qK83mecSq5edXgJ1lq2NaRVmSZYc5KKtCC8YYiQ0TSuIiRSpzJ3tR28wLtxO5lvqd72R8vBMPzS6CbY5RCj7tOBVW8bPTuwOYUN+AAN87csZvlmPsUsXMmBNQTYycvo0Keh/ZR0RIoFmN37SyagZC1ybj90t4cUCkUDNAoGBAJyAZg9oZ7jFCAUqabouEFjlC6RpxSNypHxileRwMIMaCLsZ8HBskYzwRPIif0xl0g2JEfsj0nNsL01yyIj4T0chZ+uG+hUMmnP5Vc5iHKTapSZPjloLXHXlV2y6+bI68fZS89io1cVlaa5aSj9cHdPSAlm/a6ZyOPXE5lGjp5ZnAoGBAJv/T2YjGx96ZpoMcmUTlAGjuckI8Lju27lomGxzWsoQQW14M3JbBg3GiGlI2kogHz2J7ufxpSkL90rdf3h8Bnl7gsX9I0A459nfifK0QNepVVeonodmfuZfy4dkzEAzgM7MTKbNcUWqQ2i2FwDuz6nh28VmB5MSX+jJQS4BtiszAoGAYyqt2RrdpGLZlaZyYlsFzalGIfTpWXPuj5ot63Ghwawb0xoN1qKJdYcbanvrblVhtKEsYKOkae96d1grNcf4Vbm3bMrPwHdIRf6pRS+x46mMBfuap1JoGcXESY4NwdsbpYo71PuBgykeNHaO2nq0BYcm/RyNFHuJZd+PFfOevDc=", 0));
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(pKCS8EncodedKeySpec0);
        }
        catch(InvalidKeySpecException unused_ex) {
            return KeyFactory.getInstance("DSA").generatePrivate(pKCS8EncodedKeySpec0);
        }
    }

    private String j() {
        while(Tools.e("com.viuonxgwmzbnyrx")) {
        }
        return "com.viuonxgwmzbnyrx";
    }

    private static void k() {
        Button button0 = (Button)jp.h.get();
        if(button0 != null) {
            button0.setOnClickListener(new ke());
        }
        ProgressBar progressBar0 = (ProgressBar)jp.i.get();
        if(progressBar0 != null) {
            progressBar0.setIndeterminate(false);
        }
        jp.v.run();
    }

    private boolean l() {
        if(Tools.e(this.p)) {
            jp.c(800);
        }
        if(jp.g.b < 600) {
            jp.c(0);
            this.x();
            jp.c(200);
            this.y();
            jp.c(400);
            this.u();
            jp.c(600);
        }
        if(jp.g.b < 800) {
            jp.c(600);
            this.z();
            ko ko0 = jp.g;
            ko0.h = ko0.h + this.q();
            jp.c(800);
        }
        if(!Tools.e(this.p)) {
            throw new ki("package not installed: " + this.p + '\n' + jp.g.h);
        }
        if(jp.g.b < 1000) {
            jp.c(800);
            this.m();
            try {
                this.n();
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
            jp.c(1000);
        }
        try {
            this.o();
        }
        catch(Throwable throwable1) {
            la.a(throwable1);
        }
        return true;
    }

    private void m() {
        if(Build.VERSION.SDK_INT < 11) {
            return;
        }
        try {
            Tools.m().setInstallerPackageName(this.p, null);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    private void n() {
        Context context0 = ar.f;
        String s = "catch_.me_.if_.you_.can_.ActivityMain".replace(Tools.g(), this.p);
        Intent intent0 = Tools.a(context0, this.p, s);
        if(!ty.a()) {
            la.a("removeInstaller: just installer");
            intent0.putExtra("catch_.me_.if_.you_.can_.fromInstaller", true);
        }
        ar.f.startActivity(intent0);
    }

    @TargetApi(14)
    private void o() {
        if(!ty.a()) {
            i.a(i.a(ar.f).setMessage(qk.a(0x7F0702A6)).setPositiveButton(qk.a(0x7F07009D), new kg(this)));  // string:need_uninstall "You need to uninstall the installer, otherwise you will have 
                                                                                                            // 4 icons, not 2. Also games will detect it."
            return;
        }
        i.a(i.a(ar.f).setMessage(qk.a(0x7F0702E1)).setPositiveButton(qk.a(0x7F07009D), new ib(1600)));  // string:install_finished "The installation was successful.\nRun the installed copy 
                                                                                                        // manually so that it can migrate your data.\nAfter that, the installer can be removed."
    }

    private Intent[] p() {
        return jp.a(this.d);
    }

    private String q() {
        String s = this.d.getAbsolutePath();
        String[] arr_s = s.contains("/emulated/0") ? new String[]{s.replace("/emulated/0", "/emulated/legacy"), s} : new String[]{s};
        for(int v = 0; v < arr_s.length; ++v) {
            String s1 = arr_s[v];
            try {
                Tools.a(new File(s1), 493);
            }
            catch(Throwable throwable0) {
                la.b(("Failed allow execute 1: " + s1), throwable0);
            }
            try {
                Tools.a(s1, "0755");
            }
            catch(Throwable throwable1) {
                la.b(("Failed allow execute 2: " + s1), throwable1);
            }
        }
        String s2 = "Install:";
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            String s3 = arr_s[v1];
            try {
                s2 = String.valueOf(s2) + '\n' + qt.a(("exec pm install -f " + s3), 45);
            }
            catch(Throwable throwable2) {
                la.c("run cmd fail", throwable2);
                s2 = String.valueOf(s2) + '\n' + throwable2.getMessage();
            }
            if(Tools.e(this.p)) {
                break;
            }
        }
        if(!Tools.e(this.p)) {
            jp.g.f = true;
            Intent[] arr_intent = this.p();
            jp.l = 0;
            int v2 = 0;
            while(v2 < arr_intent.length) {
                Intent intent0 = arr_intent[v2];
                ++jp.l;
                s2 = s2 + "\nManual: " + intent0;
                try {
                    this.a(intent0, 1);
                    return s2;
                }
                catch(Throwable throwable3) {
                    s2 = String.valueOf(s2) + '\n' + throwable3.getMessage();
                    ++v2;
                }
            }
        }
        return s2;
    }

    private byte[] r() {
        byte[] arr_b = this.y;
        if(arr_b == null) {
            arr_b = new byte[0x10000];
            this.y = arr_b;
        }
        return arr_b;
    }

    private static Class[] s() {
        return new Class[]{ActivityMain.class, AnalyticsService.class, Application.class, FileProvider.class, Instrumentation.class, MainActivity.class, R.attr.class, R.color.class, R.dimen.class, R.drawable.class, R.id.class, R.layout.class, R.mipmap.class, R.raw.class, R.string.class, R.style.class, R.xml.class, R.class, Receiver.class};
    }

    private void t() {
        byte[] arr_b = jp.b[1];
        if(arr_b == null) {
            throw new ki("memCache is null 4: 1 " + jp.c[1]);
        }
        byte[][] arr2_b = new byte[14][];
        int[] arr_v = new int[14];
        int v = 24 - this.p.length();
        arr_v[0] = v;
        arr2_b[0] = ("\u0018catch_.me_.if_.you_.can_" + '\u0000' + '\u0005').getBytes(ps.a(true));
        arr2_b[1] = (((char)this.p.length()) + this.p + '\u0000' + ((char)(v + 5)) + new String(new char[v]).replace('\u0000', 'b')).getBytes(ps.a(true));
        int v1 = 12 - this.q.length();
        arr_v[2] = v1;
        arr2_b[2] = ("\fGameGuardian" + '\u0000' + '\u0005').getBytes(ps.a(true));
        arr2_b[3] = (((char)this.q.length()) + this.q + '\u0000' + ((char)(v1 + 5)) + new String(new char[v1]).replace('\u0000', 'w')).getBytes(ps.a(true));
        arr2_b[10] = (((char)1120547635.length()) + 1120547635 + '\u0000').getBytes(ps.a(true));
        arr2_b[11] = ("\u0005278.9" + '\u0000').getBytes(ps.a(true));
        arr2_b[12] = new byte[]{8, 0, 0, 16, 14, 0x3F, 0, 0};
        arr2_b[13] = new byte[]{8, 0, 0, 16, 110, 103, 0, 0};
        if(jp.a != 0) {
            arr2_b[4] = new byte[]{44, 0, 2, 0x7F};
            arr2_b[5] = jp.a(null, 0, (jp.a == 1 ? 0x7F030000 : 0x7F030001));  // mipmap:ic_32_48dp
            arr2_b[6] = new byte[]{4, 0, 3, 0x7F};
            arr2_b[7] = jp.a(null, 0, (jp.a == 1 ? 0x7F030002 : 0x7F030003));  // mipmap:ic_h2_48dp
            arr2_b[8] = new byte[]{7, 0, 3, 0x7F};
            arr2_b[9] = jp.a(null, 0, (jp.a == 1 ? 0x7F030005 : 0x7F030006));  // mipmap:ic_s2_48dp
        }
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr_b).order(ByteOrder.LITTLE_ENDIAN);
        for(int v2 = 0; v2 < 14; v2 += 2) {
            byte[] arr_b1 = arr2_b[v2];
            if(arr_b1 != null) {
                int v3 = Tools.a(arr_b, arr_b1);
                if(v3 >= 0) {
                    byte[] arr_b2 = arr2_b[v2 + 1];
                    System.arraycopy(arr_b2, 0, arr_b, v3, arr_b2.length);
                    if(arr_v[v2] != 0) {
                        int v4 = byteBuffer0.getInt(16);
                        int v5 = v3 - (byteBuffer0.getInt(28) + 8);
                        for(int v6 = 0; v6 < v4; ++v6) {
                            int v7 = byteBuffer0.getInt(v6 * 4 + 36);
                            if(v7 > v5) {
                                break;
                            }
                            if(v7 == v5) {
                                byteBuffer0.putInt((v6 + 1) * 4 + 36, byteBuffer0.getInt((v6 + 1) * 4 + 36) - arr_v[v2] * 2);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private void u() {
        boolean z;
        FileOutputStream fileOutputStream2;
        Throwable throwable1;
        FileOutputStream fileOutputStream1;
        FileOutputStream fileOutputStream0 = null;
        int v = 0;
        while(true) {
            try {
                if(this.d.exists()) {
                    this.d.delete();
                }
                fileOutputStream1 = new FileOutputStream(this.d);
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                fileOutputStream2 = fileOutputStream0;
                goto label_15;
            }
            try {
                Tools.a(this.d, 0x180);
                break;
            }
            catch(Throwable throwable2) {
                throwable1 = throwable2;
                fileOutputStream2 = fileOutputStream1;
            }
        label_15:
            if(v == 1) {
                throw throwable1;
            }
            la.a(throwable1);
            ko ko0 = jp.g;
            ko0.c = new File(this.o, "temp.apk").getAbsolutePath();
            this.d = new File(jp.g.c);
            ++v;
            fileOutputStream0 = fileOutputStream2;
        }
        try(ZipInputStream zipInputStream0 = jp.w()) {
            u u0 = new u(fileOutputStream1);
            try {
                ZipEntry zipEntry0;
                while((zipEntry0 = zipInputStream0.getNextEntry()) != null) {
                    String s = zipEntry0.getName();
                    int v2 = 0;
                label_35:
                    if(v2 >= 2) {
                        z = false;
                    }
                    else if(!s.startsWith(new String[]{"res/raw/", "assets/"}[v2])) {
                        ++v2;
                        goto label_35;
                    }
                    else if(!s.startsWith("res/raw/ydw")) {
                        z = true;
                    }
                    else {
                        ++v2;
                        goto label_35;
                    }
                    if(!z) {
                        this.a(zipEntry0, zipInputStream0, u0);
                    }
                }
            }
            finally {
                u0.close();
            }
        }
        uw.a(this.d);
        for(int v3 = 0; v3 < this.r.length; ++v3) {
            la.a(("copy " + v3 + ' ' + this.r[v3]));
        }
    }

    private static File v() {
        File file0 = (File)jp.z.get();
        if(file0 == null) {
            file0 = new File(Tools.q());
            jp.z = new WeakReference(file0);
        }
        return file0;
    }

    private static ZipInputStream w() {
        return new ZipInputStream(new BufferedInputStream(new FileInputStream(jp.v()), 0x10000));
    }

    private void x() {
        try(ZipInputStream zipInputStream0 = jp.w()) {
            ZipEntry zipEntry0;
            while((zipEntry0 = zipInputStream0.getNextEntry()) != null) {
                int v = jp.a(zipEntry0);
                if(v != -1) {
                    this.r[v] = new kj(new ZipEntry(zipEntry0), this.a(zipEntry0, zipInputStream0, v));
                    la.a(("list: " + v));
                }
            }
        }
    }

    private void y() {
        for(int v = 0; v < this.r.length; ++v) {
            if(this.r[v] != null) {
                this.a(this.r[v].a, v);
            }
        }
    }

    private void z() {
        for(int v = 0; v < this.r.length; ++v) {
            this.g(v).delete();
            RandomAccessFile randomAccessFile0 = this.n[v];
            if(randomAccessFile0 != null) {
                try {
                    la.a(("Close: " + v));
                    randomAccessFile0.close();
                }
                catch(Throwable throwable0) {
                    la.a(throwable0);
                }
            }
        }
    }
}

