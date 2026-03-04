package android.ext;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPOutputStream;

class ll implements Runnable {
    @Override
    public void run() {
        String s5;
        byte[] arr_b;
        try {
            lh.a = Boolean.FALSE;
            try {
                StringBuilder stringBuilder0 = new StringBuilder();
                SharedPreferences sharedPreferences0 = Tools.s();
                for(int v1 = 0; v1 < 4; ++v1) {
                    if(sharedPreferences0.contains("used-" + v1)) {
                        String s = sharedPreferences0.getString("used-" + v1, "");
                        if(s.length() != 0) {
                            if(stringBuilder0.length() != 0) {
                                stringBuilder0.append('&');
                            }
                            stringBuilder0.append(v1);
                            stringBuilder0.append('=');
                            stringBuilder0.append(s);
                        }
                    }
                }
                SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
                for(int v = 0; v < 4; ++v) {
                    sharedPreferences$Editor0.remove("used-" + v);
                }
                sharedPreferences$Editor0.commit();
                arr_b = stringBuilder0.toString().getBytes();
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
                arr_b = null;
            }
            URLConnection uRLConnection0 = new URL(Tools.a("http://gameguardian.net/GG_logs/version.php?s=%d&v=%s&l=%s&t=%s&a=%d&o=%s&u=%s", new Object[]{Build.VERSION.SDK_INT, 1120547635, ad.c(), qk.a(0x7F070083), eu.b(), lh.p(), "su"}) + pj.e() + ConfigListAdapter.d()).openConnection();  // string:lang_code "~~~en_US~~~"
            if(arr_b != null) {
                try {
                    uRLConnection0.setDoOutput(true);
                    GZIPOutputStream gZIPOutputStream0 = new GZIPOutputStream(uRLConnection0.getOutputStream());
                    gZIPOutputStream0.write(arr_b);
                    gZIPOutputStream0.close();
                }
                catch(Throwable throwable2) {
                    la.a(throwable2);
                }
            }
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(uRLConnection0.getInputStream()));
            StringBuilder stringBuilder1 = new StringBuilder();
            String s1 = "";
            int v2 = gs.a(1120547635);
            String s2 = null;
            int v3 = gs.a("101.1");
            String s3 = null;
            while(true) {
                String s4 = bufferedReader0.readLine();
                if(s4 == null) {
                    s5 = s3;
                    goto label_50;
                }
                s5 = s3 == null ? s4 : s3;
                if("".equals(s1)) {
                    if(gs.a(s4) <= v2) {
                    label_50:
                        bufferedReader0.close();
                        la.a(("Server version: " + (s5 == null ? "null" : String.valueOf(s5) + ' ' + gs.a(s5))));
                        if(s5 != null && gs.a(s5) > v2) {
                            lh.a = Boolean.TRUE;
                            rx.a(new lm(this, stringBuilder1, s5));
                        }
                        return;
                    }
                    s2 = s4;
                }
                stringBuilder1.append(s4);
                stringBuilder1.append('\n');
                if(s4.contains("ARMv5") && gs.a(s2) > v3) {
                    try {
                        y.a = Float.parseFloat(s2);
                        v3 = gs.a(s2);
                        s1 = s4;
                        s3 = s5;
                        continue;
                    }
                    catch(NumberFormatException numberFormatException0) {
                        la.b(("Failed parse as float \'" + s2 + "\'"), numberFormatException0);
                    }
                }
                s1 = s4;
                s3 = s5;
            }
        }
        catch(Throwable throwable0) {
            la.c("checkNewVersion", throwable0);
        }
    }
}

