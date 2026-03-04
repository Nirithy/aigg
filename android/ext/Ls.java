package android.ext;

import java.io.File;

public class Ls {
    public static void main(String[] arr_s) {
        File[] arr_file = new File(arr_s[0]).listFiles();
        if(arr_file != null) {
            for(int v = 0; v < arr_file.length; ++v) {
                File file0 = arr_file[v];
                if(file0 != null) {
                    System.out.println(file0.getAbsolutePath());
                }
            }
        }
    }
}

