package android.ext;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

public class u extends ZipOutputStream {
    private boolean a;
    private v b;
    private ZipEntry c;
    private final CRC32 d;
    private int e;
    private byte[] f;

    public u(OutputStream outputStream0) {
        super(new v(new BufferedOutputStream(outputStream0, 0x10000)));
        this.a = false;
        this.c = null;
        this.d = new CRC32();
        this.e = 0;
        this.f = null;
        this.b = v.b;
        this.setComment("");
    }

    public static String a(ZipEntry zipEntry0) {
        return zipEntry0 == null ? "null" : zipEntry0.getName() + ", method: " + zipEntry0.getMethod() + ", crc: 0x" + Long.toHexString(zipEntry0.getCrc()) + ", size: " + zipEntry0.getSize() + ", compressed size: " + zipEntry0.getCompressedSize();
    }

    @Override
    public void closeEntry() {
        try {
            if(this.c != null && this.c.getMethod() == 0) {
                if(this.c.getCrc() != this.d.getValue()) {
                    la.b(("CRC mismatch: " + u.a(this.c) + " != " + this.d.getValue()));
                    this.c.setCrc(this.d.getValue());
                }
                if(this.c.getSize() != ((long)this.e)) {
                    la.b(("Size mismatch: " + u.a(this.c) + " != " + this.e));
                    this.c.setSize(((long)this.e));
                }
                if(this.c.getCompressedSize() != this.c.getSize()) {
                    la.b(("CompressedSize mismatch: " + u.a(this.c) + " != " + this.c.getSize()));
                    this.c.setCompressedSize(this.c.getSize());
                }
            }
            super.closeEntry();
            this.a = false;
            this.c = null;
            this.d.reset();
            this.e = 0;
        }
        catch(ZipException zipException0) {
            throw new RuntimeException("Failed close entry: " + u.a(this.c), zipException0);
        }
    }

    @Override
    public void putNextEntry(ZipEntry zipEntry0) {
        zipEntry0.setComment("");
        this.c = zipEntry0;
        if(this.a) {
            this.closeEntry();
        }
        if(zipEntry0.getMethod() == 0) {
            this.flush();
            zipEntry0.setExtra(new byte[(4 - (this.b.a + 30 + zipEntry0.getName().length()) % 4) % 4]);
            zipEntry0.setCompressedSize(zipEntry0.getSize());
        }
        super.putNextEntry(zipEntry0);
        this.a = true;
        this.d.reset();
        this.e = 0;
    }

    @Override
    public void setComment(String s) {
        super.setComment("");
    }

    @Override
    public void write(int v) {
        byte[] arr_b = this.f;
        if(arr_b == null) {
            arr_b = new byte[1];
            this.f = arr_b;
        }
        arr_b[0] = (byte)(v & 0xFF);
        this.write(arr_b, 0, 1);
    }

    @Override
    public void write(byte[] arr_b) {
        this.write(arr_b, 0, arr_b.length);
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        super.write(arr_b, v, v1);
        this.d.update(arr_b, v, v1);
        this.e += v1;
    }
}

