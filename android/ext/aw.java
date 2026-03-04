package android.ext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

class aw implements Runnable {
    final ar a;
    private final String b;

    aw(ar ar0, String s) {
        this.a = ar0;
        this.b = s;
        super();
    }

    @Override
    public void run() {
        try {
            String s = ar.e();
            File file0 = new File(s);
            FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
            ar.a(fileOutputStream0, s, this.b);
            Tools.a(file0, 420);
            Process process0 = qt.b((s.contains("/emulated/0") ? "chmod 0644 " + s.replace("/emulated/0", "/emulated/legacy") + " 2>&1 ; " + ("chmod 0644 " + s + " 2>&1 ; logcat -v threadtime -b main -b system *:V 2>&1 ; exit\n") : "chmod 0644 " + s + " 2>&1 ; logcat -v threadtime -b main -b system *:V 2>&1 ; exit\n"));
            InputStream inputStream0 = process0.getInputStream();
            byte[] arr_b = new byte[0x2000];
            if(Tools.b(process0)) {
                Tools.b((qk.a(0x7F0702A4) + ": " + qk.a(0x7F0700AE)));  // string:record_logcat "Record __logcat__"
            }
            else {
                Tools.b((qk.a(0x7F0702A4) + ": " + s));  // string:record_logcat "Record __logcat__"
            }
            while(!Thread.interrupted()) {
                int v = inputStream0.read(arr_b);
                if(v > 0) {
                    fileOutputStream0.write(arr_b, 0, v);
                    fileOutputStream0.flush();
                }
                else if(v == -1 && Tools.b(process0)) {
                    break;
                }
            }
            fileOutputStream0.close();
            Tools.b((qk.a(0x7F0702A4) + ": " + qk.a(0x7F0700B8)));  // string:record_logcat "Record __logcat__"
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            Tools.b((qk.a(0x7F0702A4) + "> " + qk.a(0x7F0700AE)));  // string:record_logcat "Record __logcat__"
        }
    }
}

