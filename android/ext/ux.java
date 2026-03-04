package android.ext;

import java.security.MessageDigest;
import java.security.PrivateKey;
import javax.crypto.Cipher;

public class ux {
    byte[] a;
    byte[] b;
    byte[] c;
    Cipher d;
    MessageDigest e;

    public ux() {
        this.a = new byte[]{0x30, 33};
        this.b = new byte[]{0x30, 9, 6, 5, 43, 14, 3, 2, 26, 5, 0};
        this.c = new byte[]{4, 20};
        this.e = MessageDigest.getInstance("SHA1");
        this.d = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    }

    public void a(PrivateKey privateKey0) {
        this.d.init(1, privateKey0);
    }

    public void a(byte[] arr_b) {
        this.e.update(arr_b);
    }

    public byte[] a() {
        this.d.update(this.a);
        this.d.update(this.b);
        this.d.update(this.c);
        this.d.update(this.e.digest());
        return this.d.doFinal();
    }
}

