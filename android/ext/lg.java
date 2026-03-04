package android.ext;

import android.util.Log;

public class lg {
    private static int a(int v, String s, String s1, Throwable throwable0) {
        String s2 = lg.a(s);
        if(s1 == null) {
            s1 = "null";
        }
        int v1 = s1.length();
        for(int v2 = 0; true; v2 = v4) {
            try {
                int v3 = v1 - v2 <= 0x3FF ? v1 - v2 : 0x3FF;
                String s3 = s1.substring(v2, v2 + v3);
                int v4 = v3 + v2;
                switch(v) {
                    case 2: {
                        Log.e(s2, s3);
                        break;
                    }
                    case 3: {
                        if(v4 == v1) {
                            try {
                                Log.e(s2, s3, throwable0);
                            }
                            catch(OutOfMemoryError unused_ex) {
                                Log.e(s2, s3);
                            }
                        }
                        else {
                            Log.e(s2, s3);
                        }
                        break;
                    }
                    case 6: {
                        Log.e(s2, s3);
                        break;
                    }
                    case 7: {
                        if(v4 == v1) {
                            try {
                                Log.e(s2, s3, throwable0);
                            }
                            catch(OutOfMemoryError unused_ex) {
                                Log.e(s2, s3);
                            }
                        }
                        else {
                            Log.e(s2, s3);
                        }
                        break;
                    }
                    case 9: {
                        Log.e(s2, s3);
                        break;
                    }
                    case 10: {
                        if(v4 == v1) {
                            try {
                                Log.e(s2, s3, throwable0);
                            }
                            catch(OutOfMemoryError unused_ex) {
                                Log.e(s2, s3);
                            }
                        }
                        else {
                            Log.e(s2, s3);
                        }
                    }
                }
            }
            catch(OutOfMemoryError unused_ex) {
                Log.e(s2, "OOM for Log 1");
            }
            if(v4 >= v1) {
                break;
            }
        }
        return 0;
    }

    public static int a(String s, String s1) {
        return lg.a(2, s, s1, null);
    }

    public static int a(String s, String s1, Throwable throwable0) {
        return lg.a(3, s, s1, throwable0);
    }

    private static String a(String s) {
        if(s == null) {
            return "null";
        }
        return s.length() <= 23 ? s : s.substring(0, 23);
    }

    public static int b(String s, String s1) {
        return lg.a(6, s, s1, null);
    }

    public static int b(String s, String s1, Throwable throwable0) {
        return lg.a(7, s, s1, throwable0);
    }

    public static int c(String s, String s1) {
        return lg.a(9, s, s1, null);
    }

    public static int c(String s, String s1, Throwable throwable0) {
        return lg.a(10, s, s1, throwable0);
    }
}

