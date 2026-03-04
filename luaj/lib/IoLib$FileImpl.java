package luaj.lib;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import luaj.LuaString;

final class IoLib.FileImpl extends IoLib.File {
    final IoLib b;
    private final RandomAccessFile c;
    private final char d;
    private boolean e;
    private byte[] f;
    private int g;
    private boolean h;

    private IoLib.FileImpl(IoLib ioLib0, File file0, char c) {
        this.b = ioLib0;
        super(ioLib0);
        this.e = false;
        this.f = null;
        RandomAccessFile randomAccessFile0 = new RandomAccessFile(file0, (c == 0x72 ? "r" : "rw"));
        if(c != 0x72) {
            ioLib0.e.a(file0.getAbsolutePath());
        }
        switch(c) {
            case 97: 
            case 140: {
                randomAccessFile0.seek(randomAccessFile0.length());
                break;
            }
            case 0x77: 
            case 0xA2: {
                randomAccessFile0.setLength(0L);
            }
        }
        this.c = randomAccessFile0;
        this.d = c;
    }

    IoLib.FileImpl(IoLib ioLib0, File file0, char c, IoLib.FileImpl ioLib$FileImpl0) {
        this(ioLib0, file0, c);
    }

    @Override  // luaj.lib.IoLib$File
    public void S() {
        byte[] arr_b = this.f;
        int v = this.g;
        if(arr_b != null && v > 0) {
            this.c(arr_b, 0, v);
            this.g = 0;
        }
    }

    @Override  // luaj.lib.IoLib$File
    public boolean T() {
        return false;
    }

    @Override  // luaj.lib.IoLib$File
    public void U() {
        this.S();
        this.e = true;
        this.c.close();
    }

    @Override  // luaj.lib.IoLib$File
    public boolean V() {
        return this.e;
    }

    @Override  // luaj.lib.IoLib$File
    public int W() {
        this.c(false);
        return (int)(this.c.length() - this.c.getFilePointer());
    }

    @Override  // luaj.lib.IoLib$File
    public int X() {
        this.c(false);
        long v = this.c.getFilePointer();
        int v1 = this.c.read();
        this.c.seek(v);
        return v1;
    }

    @Override  // luaj.lib.IoLib$File
    public int a(byte[] arr_b, int v, int v1) {
        this.c(false);
        return this.c.read(arr_b, v, v1);
    }

    @Override  // luaj.lib.IoLib$File
    public int af() {
        this.c(false);
        return this.c.read();
    }

    private void ah() {
        if(this.f == null) {
            return;
        }
        this.S();
        this.f = null;
    }

    private void b(byte[] arr_b, int v, int v1) {
        int v12;
        int v7;
        int v6;
        int v5;
        int v2 = 0;
        if(this.f == null) {
            this.c(arr_b, v, v1);
            return;
        }
        if(v1 != 0) {
            byte[] arr_b1 = this.f;
            int v3 = this.g;
            if(this.h) {
                int v4 = v + v1 - 1;
                while(true) {
                    if(v4 < v) {
                        v5 = v3;
                        v6 = v1;
                        v7 = v;
                        goto label_41;
                    }
                    if(arr_b[v4] == 10) {
                        if(v3 > 0) {
                            this.c(arr_b1, 0, v3);
                            this.g = 0;
                            v3 = 0;
                        }
                        int v8 = v4 - v + 1;
                        this.c(arr_b, v, v8);
                        v5 = v3;
                        v6 = v1 - v8;
                        v7 = v + v8;
                        goto label_41;
                    }
                    --v4;
                }
            }
            else if(v3 <= 0 && v1 > arr_b1.length) {
            label_38:
                v5 = v3;
                v6 = v1;
                v7 = v;
            label_41:
                int v10 = v5 + v6;
                if(v10 >= arr_b1.length) {
                    int v11 = v10 / arr_b1.length * arr_b1.length;
                    if(v5 > 0) {
                        this.c(arr_b1, 0, v5);
                        v11 -= v5;
                        this.g = 0;
                    }
                    else {
                        v2 = v5;
                    }
                    this.c(arr_b, v7, v11);
                    v12 = v6 - v11;
                    v7 += v11;
                }
                else {
                    v2 = v5;
                    v12 = v6;
                }
                if(v12 > 0) {
                    System.arraycopy(arr_b, v7, arr_b1, v2, v12);
                    this.g = v12 + v2;
                }
            }
            else {
                int v9 = arr_b1.length - v3 <= v1 ? arr_b1.length - v3 : v1;
                System.arraycopy(arr_b, v, arr_b1, v3, v9);
                v += v9;
                v1 -= v9;
                v3 += v9;
                if(v3 == arr_b1.length) {
                    this.c(arr_b1, 0, v3);
                    v3 = 0;
                }
                this.g = v3;
                if(v1 != 0) {
                    goto label_38;
                }
            }
        }
    }

    private void c(boolean z) {
        switch(this.d) {
            case 0x72: {
                if(z) {
                    throw new IOException("invalid mode for write data: \'" + this.d + "\'");
                }
                break;
            }
            case 97: 
            case 0x77: {
                if(!z) {
                    throw new IOException("invalid mode for read data: \'" + this.d + "\'");
                }
                break;
            }
        }
    }

    private void c(byte[] arr_b, int v, int v1) {
        RandomAccessFile randomAccessFile0 = this.c;
        if(this.d == 140) {
            long v2 = randomAccessFile0.getFilePointer();
            randomAccessFile0.seek(randomAccessFile0.length());
            randomAccessFile0.write(arr_b, v, v1);
            randomAccessFile0.seek(v2);
            return;
        }
        randomAccessFile0.write(arr_b, v, v1);
    }

    @Override  // luaj.lib.IoLib$File
    public int c(String s, int v) {
        RandomAccessFile randomAccessFile0 = this.c;
        if("set".equals(s)) {
            randomAccessFile0.seek(((long)v));
            return (int)randomAccessFile0.getFilePointer();
        }
        if("end".equals(s)) {
            randomAccessFile0.seek(randomAccessFile0.length() + ((long)v));
            return (int)randomAccessFile0.getFilePointer();
        }
        randomAccessFile0.seek(randomAccessFile0.getFilePointer() + ((long)v));
        return (int)randomAccessFile0.getFilePointer();
    }

    @Override  // luaj.lib.IoLib$File
    public void d(String s, int v) {
        if("no".equals(s)) {
            this.ah();
            return;
        }
        boolean z = "line".equals(s);
        if(this.f == null || this.f.length != v) {
            try {
                this.ah();
                this.f = new byte[v];
                this.g = 0;
            }
            catch(OutOfMemoryError outOfMemoryError0) {
                throw new IOException("Out of memory for create buffer " + v + " bytes", outOfMemoryError0);
            }
        }
        else if(this.h != z) {
            this.S();
        }
        this.h = z;
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.lib.IoLib$File
    public String d_() {
        StringBuilder stringBuilder0 = new StringBuilder("file (");
        return this.e ? "file (closed)" : stringBuilder0.append(this.hashCode()).append(')').toString();
    }

    @Override  // luaj.lib.IoLib$File
    public void e(LuaString luaString0) {
        this.c(true);
        this.b.e.a(((long)luaString0.d));
        this.b(luaString0.b, luaString0.c, luaString0.d);
    }
}

