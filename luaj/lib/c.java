package luaj.lib;

import android.ext.Tools;
import android.ext.la;
import android.ext.qk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

class c {
    File a;
    OutputStream b;
    File c;
    DataOutputStream d;
    final BaseLib e;

    c(BaseLib baseLib0, String s) {
        this.e = baseLib0;
        super();
        this.a = new File(s + ".load");
        this.b = new BufferedOutputStream(new FileOutputStream(this.a));
        this.c = new File(s + ".load.tmp");
        this.d = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(this.c)));
    }

    int a(byte[] arr_b, int v, int v1) {
        String s = Integer.toOctalString(v1);
        int v2 = s.length();
        int v3 = 0;
        int v4;
        for(v4 = 0; v3 < v2; v4 = (v5 & 0xFF) - 0x30 + v4) {
            int v5 = s.charAt(v3);
            arr_b[v - v2 + v3] = (byte)v5;
            ++v3;
        }
        return v4;
    }

    void a() {
        byte[] arr_b2;
        try {
            this.b.close();
            this.d.close();
            int v = ((int)this.c.length()) / 4;
            if(v > 0) {
                Tools.b((qk.a(0x7F0702CE) + ": " + v));  // string:debug_load "Dump all code loads"
                BufferedInputStream bufferedInputStream0 = new BufferedInputStream(new FileInputStream(this.a));
                DataInputStream dataInputStream0 = new DataInputStream(new BufferedInputStream(new FileInputStream(this.c)));
                byte[] arr_b = this.e.b;
                if(arr_b == null) {
                    byte[] arr_b1 = new byte[0x2000];
                    this.e.b = arr_b1;
                    arr_b2 = arr_b1;
                }
                else {
                    arr_b2 = arr_b;
                }
                byte[] arr_b3 = new byte[0x200];
                this.a(arr_b3, 0, "load_0000000.lua");
                this.a(arr_b3, 100, "0000666\u00000000000\u00000002004\u000000000000000\u000000000000000\u0000000000\u0000 0");
                this.a(arr_b3, 0x101, "ustar00\u0000root");
                this.a(arr_b3, 297, "sdcard_r");
                int v1 = 0xFFFFFFC0;
                for(int v2 = 0; v2 < 0x200; ++v2) {
                    int v3 = arr_b3[v2];
                    if(v3 != 0) {
                        v1 += v3 & 0xFF;
                    }
                }
                BufferedOutputStream bufferedOutputStream0 = new BufferedOutputStream(new FileOutputStream(this.a.getAbsolutePath() + ".tar"));
                int v4 = 0;
                while(true) {
                    if(v4 >= v) {
                        bufferedOutputStream0.write(new byte[0x400], 0, 0x400);
                        bufferedOutputStream0.close();
                        bufferedInputStream0.close();
                        dataInputStream0.close();
                        break;
                    }
                    int v5 = dataInputStream0.readInt();
                    String s = Integer.toString(v4);
                    int v6 = s.length();
                    int v7 = 12 - v6;
                    int v9 = v1;
                    for(int v8 = 0; v8 < v6; ++v8) {
                        int v10 = s.charAt(v8);
                        v9 += (v10 & 0xFF) - 0x30;
                        arr_b3[v7 + v8] = (byte)v10;
                    }
                    this.a(arr_b3, 0x7C, "00000000000\u000000000000000\u0000000000\u0000");
                    this.a(arr_b3, 0x9A, this.a(arr_b3, 0x87, v5) + v9);
                    bufferedOutputStream0.write(arr_b3, 0, 0x200);
                    int v11 = v5;
                label_51:
                    if(v11 <= 0) {
                        if(v5 % 0x200 > 0) {
                            int v12 = 0x200 - v5 % 0x200;
                            Arrays.fill(arr_b2, 0, v12, 0);
                            bufferedOutputStream0.write(arr_b2, 0, v12);
                        }
                        ++v4;
                        continue;
                    }
                    int v13 = bufferedInputStream0.read(arr_b2, 0, (v11 <= arr_b2.length ? v11 : arr_b2.length));
                    if(v13 <= 0) {
                        goto label_51;
                    }
                    bufferedOutputStream0.write(arr_b2, 0, v13);
                    v11 -= v13;
                    goto label_51;
                }
            }
            this.a.delete();
            this.c.delete();
        }
        catch(Throwable throwable0) {
            la.a(("Failed end log load for " + this.a), throwable0);
        }
    }

    void a(byte[] arr_b, int v, String s) {
        int v2 = s.length();
        for(int v1 = 0; v1 < v2; ++v1) {
            arr_b[v + v1] = (byte)s.charAt(v1);
        }
    }
}

