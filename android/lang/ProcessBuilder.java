package android.lang;

import android.ext.eu;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public final class ProcessBuilder {
    static final boolean a;
    private static volatile boolean b;
    private String[] c;
    private File d;
    private Map e;

    static {
        ProcessBuilder.a = !ProcessBuilder.class.desiredAssertionStatus();
        ProcessBuilder.b = false;
    }

    public ProcessBuilder(String[] arr_s) {
        this.c = arr_s;
    }

    public static Process a(String[] arr_s, String[] arr_s1, File file0) {
        if(!ProcessBuilder.b) {
            ProcessBuilder.b = true;
            eu.e();
        }
        return new ProcessBuilder(arr_s).a(arr_s1).a(file0).a();
    }

    public ProcessBuilder a(File file0) {
        this.d = file0;
        return this;
    }

    ProcessBuilder a(String[] arr_s) {
        if(!ProcessBuilder.a && this.e != null) {
            throw new AssertionError();
        }
        if(arr_s != null) {
            this.e = ProcessEnvironment.a(arr_s.length);
            if(!ProcessBuilder.a && this.e == null) {
                throw new AssertionError();
            }
            for(int v = 0; v < arr_s.length; ++v) {
                String s = arr_s[v];
                if(s.indexOf(0) != -1) {
                    s = s.replaceFirst("\u0000.*", "");
                }
                int v1 = s.indexOf(61, 0);
                if(v1 != -1) {
                    this.e.put(s.substring(0, v1), s.substring(v1 + 1));
                }
            }
        }
        return this;
    }

    public Process a() {
        String[] arr_s = (String[])this.c.clone();
        for(int v = 0; true; ++v) {
            if(v >= arr_s.length) {
                String s = arr_s[0];
                SecurityManager securityManager0 = System.getSecurityManager();
                if(securityManager0 != null) {
                    securityManager0.checkExec(s);
                }
                String s1 = this.d == null ? null : this.d.toString();
                for(int v1 = 1; true; ++v1) {
                    if(v1 >= arr_s.length) {
                        try {
                            return m.a(arr_s, this.e, s1, false);
                        }
                        catch(IOException | IllegalArgumentException iOException0) {
                            String s2 = ": " + iOException0.getMessage();
                            if(iOException0 instanceof IOException && securityManager0 != null) {
                                try {
                                    securityManager0.checkRead(s);
                                }
                                catch(SecurityException iOException0) {
                                    s2 = "";
                                }
                            }
                            throw new IOException("Cannot run program \"" + s + '\"' + (s1 == null ? "" : " (in directory \"" + s1 + "\")") + s2, iOException0);
                        }
                    }
                    if(arr_s[v1].indexOf(0) >= 0) {
                        throw new IOException("invalid null character in command");
                    }
                }
            }
            if(arr_s[v] == null) {
                throw new NullPointerException();
            }
        }
    }

    public static native boolean loaded() {
    }
}

