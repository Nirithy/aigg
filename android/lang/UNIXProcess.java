package android.lang;

import android.ext.la;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.Executor;

final class UNIXProcess extends Process {
    private int a;
    private boolean b;
    private OutputStream c;
    private InputStream d;
    private InputStream e;
    private static final Executor f;
    private final int pid;

    static {
        UNIXProcess.f = (Executor)UNIXProcess.a(new n());
        UNIXProcess.initIDs();
    }

    UNIXProcess(byte[] arr_b, byte[] arr_b1, int v, byte[] arr_b2, int v1, byte[] arr_b3, int[] arr_v, boolean z) {
        this.pid = this.forkAndExec(arr_b, arr_b1, v, arr_b2, v1, arr_b3, arr_v, z);
        try {
            UNIXProcess.a(new o(this, arr_v));
        }
        catch(PrivilegedActionException privilegedActionException0) {
            throw (IOException)privilegedActionException0.getException();
        }
    }

    static FileDescriptor a(int v) {
        FileDescriptor fileDescriptor0 = new FileDescriptor();
        try {
            Field field0 = FileDescriptor.class.getDeclaredField("descriptor");
            field0.setAccessible(true);
            field0.set(fileDescriptor0, v);
            return fileDescriptor0;
        }
        catch(Throwable throwable0) {
            throw new RuntimeException("Failed set fd", throwable0);
        }
    }

    public static Object a(PrivilegedAction privilegedAction0) {
        return AccessController.doPrivileged(privilegedAction0);
    }

    public static Object a(PrivilegedExceptionAction privilegedExceptionAction0) {
        return AccessController.doPrivileged(privilegedExceptionAction0);
    }

    void a(int[] arr_v) {
        r r0 = arr_v[0] == -1 ? r.a : new t(arr_v[0]);
        this.c = r0;
        q q0 = arr_v[1] == -1 ? q.a : new s(arr_v[1]);
        this.d = q0;
        q q1 = arr_v[2] == -1 ? q.a : new s(arr_v[2]);
        this.e = q1;
        p p0 = new p(this);
        UNIXProcess.f.execute(p0);
    }

    void b(int v) {
        synchronized(this) {
            this.a = v;
            this.b = true;
            this.notifyAll();
        }
        if(this.d instanceof s) {
            ((s)this.d).a();
        }
        if(this.e instanceof s) {
            ((s)this.e).a();
        }
        if(this.c instanceof t) {
            ((t)this.c).a();
        }
    }

    @Override
    public void destroy() {
        synchronized(this) {
            if(!this.b) {
                UNIXProcess.destroyProcess(this.pid);
            }
        }
        try {
            this.c.close();
        }
        catch(IOException unused_ex) {
        }
        try {
            this.d.close();
        }
        catch(IOException unused_ex) {
        }
        try {
            this.e.close();
        }
        catch(IOException unused_ex) {
        }
    }

    private static native void destroyProcess(int arg0) {
    }

    private static FileInputStream e(int v) {
        Field field0;
        FileInputStream fileInputStream0 = new FileInputStream(UNIXProcess.a(v));
        try {
            try {
                field0 = FileInputStream.class.getDeclaredField("isFdOwner");
            }
            catch(NoSuchFieldException unused_ex) {
                field0 = FileInputStream.class.getDeclaredField("shouldClose");
            }
            field0.setAccessible(true);
            field0.set(fileInputStream0, Boolean.TRUE);
        }
        catch(Throwable throwable0) {
            la.a("Failed set isFdOwner", throwable0);
        }
        return fileInputStream0;
    }

    @Override
    public int exitValue() {
        synchronized(this) {
            if(!this.b) {
                throw new IllegalThreadStateException("process hasn\'t exited");
            }
            return this.a;
        }
    }

    private static FileOutputStream f(int v) {
        Field field0;
        FileOutputStream fileOutputStream0 = new FileOutputStream(UNIXProcess.a(v));
        try {
            try {
                field0 = FileOutputStream.class.getDeclaredField("isFdOwner");
            }
            catch(NoSuchFieldException unused_ex) {
                field0 = FileOutputStream.class.getDeclaredField("shouldClose");
            }
            field0.setAccessible(true);
            field0.set(fileOutputStream0, Boolean.TRUE);
        }
        catch(Throwable throwable0) {
            la.a("Failed set isFdOwner", throwable0);
        }
        return fileOutputStream0;
    }

    private native int forkAndExec(byte[] arg1, byte[] arg2, int arg3, byte[] arg4, int arg5, byte[] arg6, int[] arg7, boolean arg8) {
    }

    @Override
    public InputStream getErrorStream() {
        return this.e;
    }

    @Override
    public InputStream getInputStream() {
        return this.d;
    }

    @Override
    public OutputStream getOutputStream() {
        return this.c;
    }

    private static native void initIDs() {
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("Process[pid=");
        stringBuilder0.append(this.pid);
        if(this.b) {
            stringBuilder0.append(", hasExited=true, exitcode=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(']');
            return stringBuilder0.toString();
        }
        stringBuilder0.append(", hasExited=false]");
        return stringBuilder0.toString();
    }

    @Override
    public int waitFor() {
        synchronized(this) {
            while(!this.b) {
                this.wait();
            }
            return this.a;
        }
    }

    private native int waitForProcessExit(int arg1) {
    }
}

