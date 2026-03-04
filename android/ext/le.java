package android.ext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class le extends gr {
    private final InputStream a;
    private final Process b;

    le(String s, InputStream inputStream0, Process process0) {
        this.a = inputStream0;
        this.b = process0;
        super(s);
    }

    @Override
    public void run() {
        int[] arr_v1;
        int v2;
        String s1;
        boolean z;
        int v1;
        int[] arr_v;
        int v;
        super.run();
        try {
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(this.a), 0x200);
            v = 0;
            arr_v = null;
            v1 = 0;
            z = false;
            while(true) {
            label_6:
                if(le.interrupted()) {
                    return;
                }
                if(z) {
                    try {
                        this.b.exitValue();
                        return;
                    }
                    catch(IllegalThreadStateException unused_ex) {
                        goto label_12;
                    }
                    catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    }
                    la.a(arrayIndexOutOfBoundsException0);
                }
                try {
                label_12:
                    String s = bufferedReader0.readLine();
                    if(s == null) {
                        goto label_84;
                    }
                    else {
                        s1 = s.trim();
                        if(s1.length() != 0) {
                            break;
                        }
                    }
                    z = false;
                }
                catch(IOException unused_ex) {
                    z = true;
                }
                catch(InterruptedException unused_ex) {
                    return;
                }
                catch(IllegalArgumentException illegalArgumentException0) {
                    goto label_90;
                }
            }
        }
        catch(NullPointerException nullPointerException0) {
            la.b("runLogOnProcessErrStream failed", nullPointerException0);
            return;
        }
        if(s1.startsWith("KEY: ")) {
            try {
                v2 = Integer.parseInt(s1.substring(5));
                if(arr_v == null) {
                    arr_v1 = new int[0x200];
                    goto label_22;
                }
            }
            catch(NumberFormatException numberFormatException0) {
                goto label_40;
            }
            catch(IOException unused_ex) {
                z = true;
                goto label_6;
            }
            catch(InterruptedException unused_ex) {
                return;
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                goto label_90;
            }
            catch(NullPointerException nullPointerException0) {
                la.b("runLogOnProcessErrStream failed", nullPointerException0);
                return;
            }
            arr_v1 = arr_v;
        label_22:
            if(v == arr_v1.length) {
                try {
                    arr_v = arr_v1;
                    arr_v = Arrays.copyOf(arr_v1, arr_v1.length + 0x200);
                    arr_v[v] = v2;
                    ++v;
                    z = false;
                    goto label_6;
                }
                catch(NumberFormatException numberFormatException0) {
                }
                catch(IOException unused_ex) {
                    arr_v = arr_v1;
                    z = true;
                    goto label_6;
                }
                catch(InterruptedException unused_ex) {
                    return;
                }
                catch(IllegalArgumentException illegalArgumentException0) {
                    arr_v = arr_v1;
                    goto label_90;
                }
                catch(NullPointerException nullPointerException0) {
                    la.b("runLogOnProcessErrStream failed", nullPointerException0);
                    return;
                }
                goto label_40;
            }
            else {
                arr_v = arr_v1;
            }
            try {
                arr_v[v] = v2;
                ++v;
                z = false;
                goto label_6;
            }
            catch(NumberFormatException numberFormatException0) {
            }
            catch(IOException unused_ex) {
                ++v;
                z = true;
                goto label_6;
            }
            catch(InterruptedException unused_ex) {
                return;
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                ++v;
                goto label_90;
            }
            catch(NullPointerException nullPointerException0) {
                la.b("runLogOnProcessErrStream failed", nullPointerException0);
                return;
            }
            ++v;
            try {
            label_40:
                la.b(("Failed parse: " + s1), numberFormatException0);
                z = false;
                goto label_6;
            label_48:
                if(s1.startsWith("KEY_END")) {
                    if(arr_v != null && v > 0) {
                        Config.a(Arrays.copyOf(arr_v, v));
                    }
                    v = 0;
                    arr_v = null;
                    z = false;
                    goto label_6;
                }
                else if(s1.startsWith("EVENT: ")) {
                    try {
                        int v3 = Integer.parseInt(s1.substring(7));
                        if(MainService.instance != null) {
                            MainService.instance.e(v3);
                        }
                    }
                    catch(NumberFormatException numberFormatException1) {
                        la.b(("Failed parse: " + s1), numberFormatException1);
                        z = false;
                        goto label_6;
                    }
                }
                else if(s1.startsWith("BAD_KERNEL")) {
                    rx.a(new lf(this));
                    z = false;
                    goto label_6;
                label_84:
                    le.sleep(500L);
                }
                else {
                    StringBuilder stringBuilder0 = la.f;
                    if(s1.contains(" dbg: ") || s1.endsWith("Send code: 2")) {
                        stringBuilder0 = new StringBuilder();
                        la.f = stringBuilder0;
                    }
                    if(s1.contains(" dbg: ") || s1.contains(" clocks: ") || s1.startsWith("MR[") || s1.contains("::searchDone:")) {
                        if(stringBuilder0 == null) {
                            stringBuilder0 = new StringBuilder();
                            la.f = stringBuilder0;
                        }
                        stringBuilder0.append(s1);
                        stringBuilder0.append('\n');
                    }
                    if(s1.contains("::searchDone:") || s1.endsWith("Send code: 3")) {
                        if(stringBuilder0 != null) {
                            la.e = stringBuilder0.toString();
                        }
                        la.f = null;
                        z = false;
                        goto label_6;
                    }
                }
            }
            catch(IOException unused_ex) {
                z = true;
                goto label_6;
            }
            catch(InterruptedException unused_ex) {
                return;
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                goto label_90;
            }
            catch(NullPointerException nullPointerException0) {
                la.b("runLogOnProcessErrStream failed", nullPointerException0);
                return;
            }
        }
        else {
            goto label_48;
            try {
            label_90:
                la.a(illegalArgumentException0);
                if(v1 + 1 > 30) {
                    return;
                }
                ++v1;
                z = false;
                goto label_6;
            }
            catch(NullPointerException nullPointerException0) {
                la.b("runLogOnProcessErrStream failed", nullPointerException0);
                return;
            }
        }
        z = false;
        goto label_6;
    }
}

