package android.ext;

import android.os.Build.VERSION;
import android.os.Build;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.CRC32;

public class InOut {
    public static volatile boolean a;
    public static volatile int b;
    public static volatile int byteOrderMask;
    static boolean c;
    private InputStream d;
    private OutputStream e;
    private byte[] f;
    private ByteBuffer g;
    private byte[] h;
    private ByteBuffer i;
    private byte[] j;
    private int k;
    private boolean l;
    private final ArrayList m;
    private volatile boolean n;
    private CRC32 o;

    static {
        boolean z;
        InOut.byteOrderMask = 15;
        if(Build.VERSION.SDK_INT < 21) {
            z = false;
        }
        else if(Build.SUPPORTED_64_BIT_ABIS != null && Build.SUPPORTED_64_BIT_ABIS.length > 0) {
            z = true;
        }
        else {
            z = false;
        }
        InOut.a(z);
        InOut.c = false;
    }

    public InOut() {
        this.o = null;
        this.d = null;
        this.e = null;
        this.f = new byte[4];
        this.g = ByteBuffer.wrap(this.f);
        this.g.order(ByteOrder.LITTLE_ENDIAN);
        this.h = new byte[8];
        this.i = ByteBuffer.wrap(this.h);
        this.i.order(ByteOrder.LITTLE_ENDIAN);
        this.j = new byte[0x400];
        this.m = new ArrayList();
        this.n = false;
    }

    public static String a(byte[] arr_b, int v, int v1) {
        if(arr_b.length - 1 < v) {
            la.b(("dump failed: " + arr_b.length + ' ' + v + ' ' + v1));
            return "";
        }
        if(arr_b.length < v + v1) {
            la.b(("dump fix len: " + arr_b.length + ' ' + v + ' ' + v1));
            v1 = arr_b.length - v;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v2 = v; v2 < v1; v2 = v3 + v2) {
            int v3 = v1 - v2 <= 0x20 ? v1 - v2 : 0x20;
            stringBuilder0.append(InOut.b(arr_b, v + v2, v3));
            stringBuilder0.append('\'');
            stringBuilder0.append(new String(arr_b, v + v2, v3));
            stringBuilder0.append("\'\n");
        }
        return stringBuilder0.toString();
    }

    private void a(int v, boolean z) {
        byte[] arr_b = this.j;
        int v1 = this.k;
        if(v1 + v > arr_b.length || z) {
            byte[] arr_b1 = new byte[v1 + v + 0x400];
            if(v1 > 0) {
                System.arraycopy(arr_b, 0, arr_b1, 0, v1);
            }
            this.j = arr_b1;
        }
    }

    static void a(boolean z) {
        InOut.a = z;
        InOut.b = z ? 8 : 4;
    }

    public void a(byte b) {
        this.a(1, false);
        int v = this.k;
        this.k = v + 1;
        this.j[v] = b;
    }

    public void a(byte b, byte b1, int v) {
        this.a(v + 2, this.l);
        this.l = false;
        byte[] arr_b = this.j;
        arr_b[0] = b1;
        arr_b[1] = b;
        this.k = 2;
    }

    public void a(int v) {
        this.i.putInt(0, InOut.byteOrderMask ^ v);
        this.a(this.h, 4);
    }

    public void a(long v) {
        if(InOut.a) {
            this.i.putLong(0, v);
            this.a(this.h, 8);
            return;
        }
        this.a(((int)v));
    }

    public void a(InputStream inputStream0, OutputStream outputStream0) {
        jn jn0;
        BufferedInputStream bufferedInputStream0 = new BufferedInputStream(inputStream0, 0x10000);
        if(InOut.c) {
            jn0 = bufferedInputStream0;
        }
        else {
            jo jo0 = new jo(outputStream0);
            jn0 = new jn(bufferedInputStream0);
            outputStream0 = jo0;
        }
        this.d = jn0;
        this.e = outputStream0;
    }

    public void a(byte[] arr_b, int v) {
        this.a(v, false);
        System.arraycopy(arr_b, 0, this.j, this.k, v);
        this.k += v;
    }

    public byte[] a() {
        int v = 0;
        byte[] arr_b = null;
        byte b;
        while((b = this.h()) != 2) {
            if(arr_b != null || b != 10 && b != 59) {
                if(arr_b == null) {
                    arr_b = new byte[0x1000];
                }
                if(v < arr_b.length) {
                    arr_b[v] = b;
                }
                ++v;
                if(v >= arr_b.length || v % 10 == 0) {
                    la.a(("Bad input from daemon: " + ((int)b) + '\n' + InOut.a(arr_b, 0, v)));
                }
            }
        }
        if(arr_b != null) {
            la.a(("Bad input from daemon 2: " + v + '\n' + InOut.a(arr_b, 0, v)));
        }
        int v1 = this.i();
        if(v1 > 0xA00000 || v1 < 2) {
            la.a(("Bad len from daemon: " + v1 + ' ' + InOut.a(this.f, 0, 4)));
            return null;
        }
        byte[] arr_b1 = new byte[v1];
        int v2;
        for(v2 = 0; v2 < v1; v2 += v3) {
            int v3 = this.d.read(arr_b1, v2, v1 - v2);
            if(v3 <= 0) {
                if(v2 != 0) {
                    break;
                }
                v2 = -1;
                break;
            }
        }
        if(arr_b1[v1 - 1] != 3) {
            la.a(("Bad end from daemon: " + ((int)arr_b1[v1 - 1]) + "; " + ((int)arr_b1[0]) + "; " + (v1 - 1) + "; " + v2));
            return null;
        }
        return arr_b1;
    }

    static String b(byte[] arr_b, int v, int v1) {
        if(arr_b.length - 1 < v) {
            la.b(("bytesToHex failed: " + arr_b.length + ' ' + v + ' ' + v1));
            return "";
        }
        if(arr_b.length < v + v1) {
            la.b(("bytesToHex fix len: " + arr_b.length + ' ' + v + ' ' + v1));
            v1 = arr_b.length - v;
        }
        char[] arr_c = new char[v1 * 3];
        char[] arr_c1 = iu.a;
        for(int v2 = 0; v2 < v1; ++v2) {
            int v3 = arr_b[v + v2] & 0xFF;
            arr_c[v2 * 3] = arr_c1[v3 >>> 4];
            arr_c[v2 * 3 + 1] = arr_c1[v3 & 15];
            arr_c[v2 * 3 + 2] = ' ';
        }
        return new String(arr_c);
    }

    public void b() {
        if(this.j.length > 0x10000) {
            this.l = true;
        }
    }

    public void b(long v) {
        this.i.putLong(0, v);
        this.a(this.h, 8);
    }

    public void b(boolean z) {
        this.n = z;
    }

    public void c() {
        synchronized(this) {
            if(this.n) {
                this.f();
                this.e.write(this.j, 0, this.k);
                this.e.flush();
            }
            else if(this.k > 0) {
                ArrayList arrayList0 = this.m;
                synchronized(arrayList0) {
                    byte[] arr_b = Arrays.copyOf(this.j, this.k);
                    this.m.add(arr_b);
                    if(this.m.size() > 40) {
                        byte[] arr_b1 = (byte[])this.m.remove(0);
                    }
                }
            }
            this.k = 0;
        }
    }

    public long d() {
        if(this.k < 2) {
            return 0L;
        }
        CRC32 cRC320 = this.o;
        if(cRC320 == null) {
            cRC320 = new CRC32();
            this.o = cRC320;
        }
        else {
            cRC320.reset();
        }
        cRC320.update(this.j, 2, this.k);
        return cRC320.getValue();
    }

    public void e() {
        this.k = 0;
    }

    public void f() {
        ArrayList arrayList0 = this.m;
        synchronized(arrayList0) {
            if(arrayList0.size() > 0) {
                OutputStream outputStream0 = this.e;
                for(Object object0: arrayList0) {
                    outputStream0.write(((byte[])object0));
                    outputStream0.flush();
                }
                arrayList0.clear();
                arrayList0.trimToSize();
            }
        }
    }

    public boolean g() {
        return this.n;
    }

    private byte h() {
        int v;
        do {
            v = this.d.read();
        }
        while(v == -1);
        return (byte)v;
    }

    private int i() {
        for(int v = 0; v < 4; v += v1) {
            int v1 = this.d.read(this.f, v, 4 - v);
            if(v1 <= 0) {
                break;
            }
        }
        return this.g.getInt(0);
    }
}

