package android.ext;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class uw {
    public static int a(RandomAccessFile randomAccessFile0) {
        int v = randomAccessFile0.read();
        int v1 = randomAccessFile0.read();
        int v2 = randomAccessFile0.read();
        int v3 = randomAccessFile0.read();
        if((v | v1 | v2 | v3) < 0) {
            throw new EOFException();
        }
        return v + ((v1 << 8) + ((v2 << 16) + (v3 << 24)));
    }

    public static void a(File file0) {
        int v11;
        byte[] arr_b1;
        long v9;
        long v8;
        int v7;
        ByteArrayOutputStream byteArrayOutputStream0;
        long v6;
        long v5;
        int v4;
        int v3;
        long v2;
        RandomAccessFile randomAccessFile0;
        int v = 0;
        try {
            randomAccessFile0 = null;
            randomAccessFile0 = new RandomAccessFile(file0, "rw");
            long v1 = randomAccessFile0.length();
            v2 = v1 == 0L ? file0.length() : v1;
            if(v2 >= 22L) {
                randomAccessFile0.seek(v2 - 12L);
                v3 = uw.b(randomAccessFile0);
                v4 = uw.a(randomAccessFile0);
                v5 = (long)uw.a(randomAccessFile0);
                if(v3 <= 0 || v4 <= 0 || v5 <= 0L) {
                    la.b(("bad values in EOCD: " + v3 + ", " + v4 + ", " + v5));
                    goto label_12;
                }
                goto label_17;
            }
            goto label_131;
        }
        catch(IOException iOException0) {
            goto label_134;
        }
        catch(Throwable throwable0) {
            goto label_145;
        }
        try {
        label_12:
            randomAccessFile0.close();
        }
        catch(Throwable throwable1) {
            la.c("ZipAlign close fail", throwable1);
        }
        return;
        try {
        label_17:
            v6 = v5 + ((long)v4);
            if(v2 - 22L != v6) {
                la.b(("Bad EOCD offset: " + (v2 - 22L) + " != " + v6 + " = " + v5 + " + " + v4));
                goto label_20;
            }
            goto label_25;
        }
        catch(IOException iOException0) {
            goto label_134;
        }
        catch(Throwable throwable0) {
            goto label_145;
        }
        try {
        label_20:
            randomAccessFile0.close();
        }
        catch(Throwable throwable2) {
            la.c("ZipAlign close fail", throwable2);
        }
        return;
        try {
        label_25:
            byteArrayOutputStream0 = new ByteArrayOutputStream(v4 + 22);
            v7 = 0;
            v8 = v5;
            v9 = v5;
        }
        catch(Throwable throwable3) {
            try {
                la.b(("ZipAlign failed alloc: " + (v4 + 22)), throwable3);
            }
            catch(IOException iOException0) {
                goto label_134;
            }
            catch(Throwable throwable0) {
                goto label_145;
            }
            try {
                randomAccessFile0.close();
            }
            catch(Throwable throwable4) {
                la.c("ZipAlign close fail", throwable4);
            }
            return;
        }
        while(true) {
            if(v7 >= v3) {
                if(v9 != v6) {
                    try {
                        la.b(("Not all CD reads: " + v9 + " != " + v6 + " = " + v5 + " + " + v4));
                    }
                    catch(IOException iOException0) {
                        goto label_134;
                    }
                    catch(Throwable throwable0) {
                        goto label_145;
                    }
                    try {
                        randomAccessFile0.close();
                    }
                    catch(Throwable throwable5) {
                        la.c("ZipAlign close fail", throwable5);
                    }
                    return;
                }
                if(v9 == v8) {
                    v11 = 0;
                }
                else {
                    try {
                        byte[] arr_b = new byte[22];
                        randomAccessFile0.seek(v9);
                        randomAccessFile0.read(arr_b);
                        int v10 = (int)(v8 - v5);
                        arr_b[12] = (byte)(v10 & 0xFF);
                        arr_b[13] = (byte)(v10 >>> 8 & 0xFF);
                        arr_b[14] = (byte)(v10 >>> 16 & 0xFF);
                        arr_b[15] = (byte)(v10 >>> 24 & 0xFF);
                        byteArrayOutputStream0.write(arr_b);
                        v9 += 22L;
                        v8 += 22L;
                        if(v9 == v2) {
                            if(v8 <= v9) {
                                arr_b1 = byteArrayOutputStream0.toByteArray();
                                if(v8 != ((long)arr_b1.length) + v5) {
                                    la.b(("Fail check buffer length: " + v8 + " != " + v5 + arr_b1.length));
                                    goto label_62;
                                }
                                goto label_67;
                            }
                            goto label_72;
                        }
                        goto label_78;
                    }
                    catch(IOException iOException0) {
                        goto label_134;
                    }
                    catch(Throwable throwable0) {
                        goto label_145;
                    }
                    try {
                    label_62:
                        randomAccessFile0.close();
                    }
                    catch(Throwable throwable6) {
                        la.c("ZipAlign close fail", throwable6);
                    }
                    return;
                    try {
                        try {
                        label_67:
                            randomAccessFile0.seek(v5);
                            v11 = 1;
                        }
                        catch(IOException iOException0) {
                            goto label_134;
                        }
                        try {
                            randomAccessFile0.write(arr_b1);
                            randomAccessFile0.setLength(v8);
                            goto label_85;
                        }
                        catch(IOException iOException0) {
                            v = v11;
                            goto label_134;
                        }
                        try {
                        label_72:
                            la.b(("Fail check new length: " + v8 + " > " + v9));
                        }
                        catch(IOException iOException0) {
                            goto label_134;
                        }
                    }
                    catch(Throwable throwable0) {
                        goto label_145;
                    }
                    try {
                        randomAccessFile0.close();
                    }
                    catch(Throwable throwable7) {
                        la.c("ZipAlign close fail", throwable7);
                    }
                    return;
                    try {
                    label_78:
                        la.b(("Fail check end: " + v9 + " != " + v2));
                    }
                    catch(IOException iOException0) {
                        goto label_134;
                    }
                    catch(Throwable throwable0) {
                        goto label_145;
                    }
                    try {
                        randomAccessFile0.close();
                    }
                    catch(Throwable throwable8) {
                        la.c("ZipAlign close fail", throwable8);
                    }
                    return;
                }
                try {
                label_85:
                    randomAccessFile0.close();
                    randomAccessFile0 = null;
                    la.a(("ZipAlign fix: " + v9 + " => " + v8 + " (" + (v9 - v8) + ')'));
                    return;
                }
                catch(IOException iOException0) {
                }
                catch(Throwable throwable0) {
                    goto label_145;
                }
                v = v11;
                goto label_134;
            }
            try {
                if(v9 >= v6) {
                    goto label_125;
                }
                randomAccessFile0.seek(v9 + 28L);
                int v12 = uw.b(randomAccessFile0);
                int v13 = uw.b(randomAccessFile0);
                if(v12 >= 0 && v13 >= 0) {
                    byte[] arr_b2 = new byte[v12 + 46];
                    randomAccessFile0.seek(v9);
                    int v14 = 0;
                    int v15 = arr_b2.length;
                    int v16 = 0;
                    while(v16 < 10 && v14 < v15) {
                        int v17 = randomAccessFile0.read(arr_b2, v14, v15 - v14);
                        if(v17 >= 0) {
                            v14 += v17;
                            ++v16;
                        }
                        else {
                            la.b(("Failed read buf 1: " + v7 + "; " + v17 + ' ' + v14 + ' ' + v15));
                            if(true) {
                                break;
                            }
                        }
                    }
                    if(v14 < v15) {
                        la.b(("Failed read buf 2: " + v7 + "; " + v14 + ' ' + v15));
                    }
                    arr_b2[30] = 0;
                    arr_b2[0x1F] = 0;
                    byteArrayOutputStream0.write(arr_b2);
                    v9 += (long)(arr_b2.length + v13);
                    v8 += (long)arr_b2.length;
                    ++v7;
                    continue;
                }
                la.b(("bad len for " + v7 + ": " + v12 + ", " + v13));
                break;
            }
            catch(IOException iOException0) {
                goto label_134;
            }
            catch(Throwable throwable0) {
                goto label_145;
            }
        }
        try {
            randomAccessFile0.close();
        }
        catch(Throwable throwable9) {
            la.c("ZipAlign close fail", throwable9);
        }
        return;
        try {
        label_125:
            la.b(("Out from CD: " + v7 + " from " + v3 + "; " + v9 + " > " + v6 + " = " + v5 + " + " + v4));
        }
        catch(IOException iOException0) {
            goto label_134;
        }
        catch(Throwable throwable0) {
            goto label_145;
        }
        try {
            randomAccessFile0.close();
        }
        catch(Throwable throwable10) {
            la.c("ZipAlign close fail", throwable10);
        }
        return;
        try {
        label_131:
            la.b(("ZipAlign small size: " + v2 + ' ' + file0.getAbsolutePath()));
        }
        catch(IOException iOException0) {
            try {
            label_134:
                la.c("ZipAlign fail", iOException0);
                if(v != 0) {
                    throw iOException0;
                }
            }
            catch(Throwable throwable0) {
                goto label_145;
            }
            if(randomAccessFile0 != null) {
                try {
                    randomAccessFile0.close();
                }
                catch(Throwable throwable11) {
                    la.c("ZipAlign close fail", throwable11);
                }
                return;
            }
            return;
        }
        catch(Throwable throwable0) {
        label_145:
            if(randomAccessFile0 != null) {
                try {
                    randomAccessFile0.close();
                }
                catch(Throwable throwable12) {
                    la.c("ZipAlign close fail", throwable12);
                }
            }
            throw throwable0;
        }
        try {
            randomAccessFile0.close();
        }
        catch(Throwable throwable13) {
            la.c("ZipAlign close fail", throwable13);
        }
    }

    private static short b(RandomAccessFile randomAccessFile0) {
        int v = randomAccessFile0.read();
        int v1 = randomAccessFile0.read();
        if((v | v1) < 0) {
            throw new EOFException();
        }
        return (short)(v + (v1 << 8));
    }
}

