package android.ext;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class uk {
    public static boolean a;

    static {
        uk.a = false;
        TrustManager[] arr_trustManager = {new ul()};
        um um0 = new um();
        try {
            System.setProperty("jsse.enableSNIExtension", "false");
            SSLContext sSLContext0 = SSLContext.getInstance("SSL");
            sSLContext0.init(null, arr_trustManager, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext0.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(um0);
        }
        catch(GeneralSecurityException generalSecurityException0) {
            throw new ExceptionInInitializerError(generalSecurityException0);
        }
    }

    public static boolean a(String s) {
        return uk.a(s, false);
    }

    public static boolean a(String s, boolean z) {
        if(Boolean.TRUE.equals(lh.a)) {
            la.a("NLV - log not sended");
            return true;
        }
        if(z) {
            Future future0 = Executors.newSingleThreadExecutor().submit(new un(s));
            try {
                return ((Boolean)future0.get()).booleanValue();
            }
            catch(Throwable throwable0) {
                la.b("sendLog", throwable0);
                return false;
            }
        }
        new gr(new uo(s), "sendLog").start();
        return true;
    }

    public static byte[] a(byte[] arr_b) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(arr_b.length);
        GZIPOutputStream gZIPOutputStream0 = new GZIPOutputStream(byteArrayOutputStream0);
        gZIPOutputStream0.write(arr_b);
        gZIPOutputStream0.close();
        byte[] arr_b1 = byteArrayOutputStream0.toByteArray();
        byteArrayOutputStream0.close();
        return Base64.encode(arr_b1, 0);
    }

    static boolean b(byte[] arr_b) {
        try {
            URLConnection uRLConnection0 = new URL("http://gameguardian.net/GG_logs/usage.php").openConnection();
            uRLConnection0.setDoOutput(true);
            OutputStream outputStream0 = uRLConnection0.getOutputStream();
            byte[] arr_b1 = uk.a(arr_b);
            outputStream0.write(arr_b1);
            outputStream0.close();
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(uRLConnection0.getInputStream()));
            StringBuilder stringBuilder0 = new StringBuilder();
            while(true) {
                String s = bufferedReader0.readLine();
                if(s == null) {
                    boolean z = "OK".equals(stringBuilder0.toString());
                    la.a(("UsageStats compress from " + arr_b.length + " to " + arr_b1.length + ", sended: " + z));
                    return z;
                }
                stringBuilder0.append(s);
            }
        }
        catch(Exception exception0) {
            la.a("UsageStats send fail", exception0);
            return false;
        }
    }
}

