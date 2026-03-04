package android.ext;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class ir {
    public static final String a(Object object0, String s) {
        try {
            MessageDigest messageDigest0 = MessageDigest.getInstance(s);
            if(object0 instanceof File) {
                FileInputStream fileInputStream0 = new FileInputStream(((File)object0));
                byte[] arr_b = new byte[0x400];
                while(true) {
                    int v = fileInputStream0.read(arr_b);
                    if(v == -1) {
                        fileInputStream0.close();
                        break;
                    }
                    messageDigest0.update(arr_b, 0, v);
                }
            }
            else {
                messageDigest0.update(object0.toString().getBytes());
            }
            return ir.a(messageDigest0);
        }
        catch(Throwable throwable0) {
            la.c("hash fail", throwable0);
            return throwable0.toString();
        }
    }

    public static final String a(MessageDigest messageDigest0) {
        byte[] arr_b = messageDigest0.digest();
        byte[] arr_b1 = new byte[8];
        System.arraycopy(arr_b, 0, arr_b1, 0, 4);
        System.arraycopy(arr_b, arr_b.length - 4, arr_b1, 4, 4);
        return Tools.a(arr_b1);
    }
}

