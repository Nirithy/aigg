package android.ext;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Script.Logger {
    final OutputStream a;
    final FileInputStream b;
    final StringBuilder c;
    int d;

    Script.Logger() {
        FileInputStream fileInputStream0;
        BufferedOutputStream bufferedOutputStream0;
        File file0;
        StringBuilder stringBuilder0 = null;
        super();
        try {
            file0 = new File(Tools.i(), "1772644610068.tmp");
            file0.createNewFile();
            bufferedOutputStream0 = new BufferedOutputStream(new FileOutputStream(file0));
        }
        catch(Throwable throwable0) {
            fileInputStream0 = null;
            bufferedOutputStream0 = null;
            goto label_19;
        }
        try {
            fileInputStream0 = new FileInputStream(file0);
        }
        catch(Throwable throwable0) {
            fileInputStream0 = null;
            goto label_19;
        }
        try {
            file0.delete();
            goto label_21;
        }
        catch(Throwable throwable1) {
            throwable0 = throwable1;
        }
    label_19:
        la.a(throwable0);
        stringBuilder0 = new StringBuilder();
    label_21:
        this.c = stringBuilder0;
        this.a = bufferedOutputStream0;
        this.b = fileInputStream0;
        this.d = 0;
    }

    public void a(String s) {
        StringBuilder stringBuilder0 = this.c;
        if(stringBuilder0 == null) {
            try {
                byte[] arr_b = s.getBytes();
                this.a.write(arr_b);
                this.d = arr_b.length + this.d;
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
            return;
        }
        stringBuilder0.append(s);
    }

    @Override
    public String toString() {
        int v = 0x40000;
        if(this.d < 0) {
            return "must be called only once";
        }
        StringBuilder stringBuilder0 = this.c;
        if(stringBuilder0 == null) {
            try {
                int v1 = this.d;
                this.d = -1;
                this.a.close();
                if(v1 > 0x40000) {
                    this.b.skip(((long)(v1 - 0x40000)));
                }
                else {
                    v = v1;
                }
                byte[] arr_b = new byte[v];
                int v2 = this.b.read(arr_b);
                this.b.close();
                la.a(("Log script size: read = " + v2 + "; used = " + v + "; full = " + v1));
                if(v2 > 0) {
                    return new String(arr_b, 0, v2);
                }
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
            return "";
        }
        return stringBuilder0.toString();
    }
}

