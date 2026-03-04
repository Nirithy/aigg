package android.ext;

import java.io.FileInputStream;

public class Cat {
    public static void main(String[] arr_s) {
        byte[] arr_b = new byte[0x2000];
        FileInputStream fileInputStream0 = new FileInputStream(arr_s[0]);
        int v;
        while((v = fileInputStream0.read(arr_b)) >= 0) {
            System.out.write(arr_b, 0, v);
        }
        fileInputStream0.close();
    }
}

