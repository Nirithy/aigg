package android.ext;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

public class la {
    static volatile boolean a;
    static volatile BufferedWriter b;
    static final Runnable c;
    static String d;
    public static String e;
    static StringBuilder f;
    private static long g;

    static {
        la.a = false;
        la.b = null;
        la.g = 0L;
        la.c = () -> {
            if(la.b != null) {
                long v = System.currentTimeMillis();
                if(v - la.g > 5000L || true) {
                    try {
                        try {
                            la.b.flush();
                        }
                        catch(NullPointerException unused_ex) {
                        }
                        la.g = v;
                        return true;
                    }
                    catch(IOException iOException0) {
                        lg.a("AndroidService", "Log write: I/O", iOException0);
                        return false;
                    }
                }
            }
            return false;
        };
        la.d = "/last_run.log";
        la.e = "- none -";
        la.f = null;
    }

    public static int a(String s) {
        return la.a("AndroidService", s);
    }

    public static int a(String s, String s1) {
        return lg.a(s, s1);
    }

    public static int a(String s, String s1, Throwable throwable0) {
        return lg.a(s, s1, throwable0);
    }

    public static int a(String s, Throwable throwable0) {
        return la.a("AndroidService", s, throwable0);
    }

    public static int a(Throwable throwable0) {
        return la.b("Bad implementation", throwable0);
    }

    // 检测为 Lambda 实现
    public static void a() [...]

    public static void a(Process process0, InputStream inputStream0) {
        if(process0 == null) {
            return;
        }
        new le("runLogOnProcessErrStream", inputStream0, process0).start();
    }

    // 检测为 Lambda 实现
    public static boolean a(boolean z) [...]

    public static int b(String s) {
        return la.b("AndroidService", s);
    }

    public static int b(String s, String s1) {
        return lg.b(s, s1);
    }

    public static int b(String s, String s1, Throwable throwable0) {
        return lg.b(s, s1, throwable0);
    }

    public static int b(String s, Throwable throwable0) {
        return la.b("AndroidService", s, throwable0);
    }

    public static String b(Throwable throwable0) {
        if(throwable0 == null) {
            return "";
        }
        Throwable throwable1 = throwable0;
        while(true) {
            if(throwable1 == null) {
                StringWriter stringWriter0 = new StringWriter();
                PrintWriter printWriter0 = new PrintWriter(stringWriter0);
                try {
                    throwable0.printStackTrace(printWriter0);
                    goto label_19;
                }
                catch(OutOfMemoryError unused_ex) {
                    printWriter0.write("OutOfMemoryError 1\n");
                }
                catch(Throwable throwable2) {
                    printWriter0.write("Exception on printStackTrace: " + throwable2.getMessage());
                    if(false) {
                        goto label_13;
                    }
                    goto label_19;
                }
            label_13:
                while(throwable0 != null) {
                    try {
                        printWriter0.write(throwable0.toString());
                        printWriter0.write("\n");
                        throwable0 = throwable0.getCause();
                    }
                    catch(OutOfMemoryError unused_ex) {
                        printWriter0.write("OutOfMemoryError 2\n");
                        break;
                    }
                }
            label_19:
                printWriter0.flush();
                String s = stringWriter0.toString();
                return s == null ? "" : s;
            }
            if(throwable1 instanceof UnknownHostException) {
                return "";
            }
            throwable1 = throwable1.getCause();
        }
    }

    public static void b() {
        rx.c(() -> rx.c(new lc()));
    }

    public static int c(String s) {
        return la.c("AndroidService", s);
    }

    public static int c(String s, String s1) {
        return lg.c(s, s1);
    }

    public static int c(String s, String s1, Throwable throwable0) {
        return lg.c(s, s1, throwable0);
    }

    public static int c(String s, Throwable throwable0) {
        return la.c("AndroidService", s, throwable0);
    }

    public static int d(String s) {
        int v = s.length();
        for(int v1 = 0; v1 < v; v1 += 1003) {
            la.a(s.substring(v1, (v1 + 1003 >= v ? v : v1 + 1003)));
        }
        return 0;
    }
}

