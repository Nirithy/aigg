package android.ext;

import android.os.Build.VERSION;
import android.os.Build;
import catch_.me_.if_.you_.can_.R.raw;

class gc extends gr {
    final ex a;

    gc(ex ex0, String s) {
        this.a = ex0;
        super(s);
    }

    @Override
    public void run() {
        int v7;
        int v4;
        int v3;
        int v2;
        InOut inOut0;
        try {
            inOut0 = this.a.e;
            String s = eu.a();
            gq gq0 = this.a.b(s);
            this.a.d = gq0;
            qt.a = "";
            inOut0.a(gq0.c, gq0.b);
            inOut0.b(true);
            MainService.instance.G();
            la.a(gq0.a, gq0.d);
            byte[] arr_b = inOut0.a();
            if(arr_b == null) {
                la.a("DI: null");
            }
            else if(arr_b.length == 7) {
                bk bk0 = new bk(arr_b);
                int v = bk0.a();
                InOut.a(v == 8);
                int v1 = bk0.a();
                if(v1 != 4) {
                    la.c(("DI: QE " + v1));
                }
                this.a.h = bk0.b();
                la.a(("DI: " + v + " " + v1 + " " + this.a.h));
            }
            else {
                la.a(("DI: " + arr_b.length));
            }
            bk bk1 = new bk(inOut0.a());
            bk1.a();
            byte[] arr_b1 = new byte[bk1.a()];
            bk1.a(arr_b1);
            this.a.j = new String(arr_b1);
            la.a(("InOut: x64: " + InOut.a + "; QE_ALIGN: " + 4 + "; " + this.a.h + "; " + this.a.j));
            this.a.l.start();
            MainService.instance.G();
            inOut0.f();
            this.a.m(0);
        }
        catch(go go0) {
            la.c("start daemon failed", go0);
            String s1 = go0.getMessage();
            StringBuilder stringBuilder0 = new StringBuilder();
            try {
                stringBuilder0.append("arm64-v8a");
                v2 = 0;
                stringBuilder0.append("; ");
                stringBuilder0.append("arm64-v8a");
                stringBuilder0.append("; ");
            }
            catch(Throwable throwable1) {
                la.b("Failed get ABI", throwable1);
            }
            if(Build.VERSION.SDK_INT >= 21) {
                try {
                    String[] arr_s = Build.SUPPORTED_ABIS;
                    for(v3 = 0; true; ++v3) {
                    label_50:
                        if(v3 >= arr_s.length) {
                            v4 = v2;
                            break;
                        }
                        String s2 = arr_s[v3];
                        stringBuilder0.append(s2);
                        stringBuilder0.append("; ");
                        if("armeabi".equals(s2)) {
                            v2 = 1;
                        }
                    }
                }
                catch(Throwable throwable2) {
                    la.b("Failed get ABI", throwable2);
                    v4 = v2;
                }
                String[] arr_s1 = Build.SUPPORTED_32_BIT_ABIS;
                int v5 = 0;
                int v6 = v4;
                while(true) {
                    if(v5 >= arr_s1.length) {
                        v7 = v6;
                    }
                    else {
                        try {
                            String s3 = arr_s1[v5];
                            stringBuilder0.append(s3);
                            stringBuilder0.append("; ");
                            if("armeabi".equals(s3)) {
                                goto label_91;
                            }
                            goto label_92;
                        }
                        catch(Throwable throwable3) {
                            la.b("Failed get ABI", throwable3);
                            v7 = v6;
                        }
                    }
                    String[] arr_s2 = Build.SUPPORTED_64_BIT_ABIS;
                    int v8 = 0;
                    v2 = v7;
                    while(v8 < arr_s2.length) {
                        try {
                            String s4 = arr_s2[v8];
                            stringBuilder0.append(s4);
                            stringBuilder0.append("; ");
                            if("armeabi".equals(s4)) {
                                goto label_87;
                            }
                            goto label_88;
                        }
                        catch(Throwable throwable4) {
                            la.b("Failed get ABI", throwable4);
                            break;
                        }
                    label_87:
                        v2 = 1;
                    label_88:
                        ++v8;
                    }
                    goto label_97;
                label_91:
                    v6 = 1;
                label_92:
                    ++v5;
                }
                v2 = 1;
                ++v3;
                goto label_50;
            }
        label_97:
            String s5 = v2 == 0 || qk.a("ydwa", R.raw.class) != 0 ? s1 : s1 + "\n\n" + Tools.c(0x7F070248) + ": " + y.a;  // string:try_arm_version "Try using the version of __app_name__ with support for older 
                                                                                                                          // ARM processors:"
            String s6 = stringBuilder0.toString();
            if(s6.contains("mips")) {
                s5 = s5 + "\n\n" + qk.a(0x7F07027A);  // string:mips_arch "This application does not support the MIPS architecture."
            }
            String s7 = s5 + "\n\nABIs: " + s6 + '\n' + eu.a + '\n' + Build.VERSION.SDK_INT + '\n' + eu.b;
            la.a(("Supported ABIs: " + s6));
            i.a(i.c().setCustomTitle(Tools.d(0x7F0700A7)).setMessage(s7).setNegativeButton(qk.a(0x7F07009D), null));  // string:failed_load_daemon "Failed to load daemon"
            inOut0.b(false);
            MainService.instance.G();
        }
        catch(Throwable throwable0) {
            la.c("start daemon failed", throwable0);
            rx.a(new gd(this));
            inOut0.b(false);
            MainService.instance.G();
        }
        ex.a();
    }
}

