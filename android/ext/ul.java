package android.ext;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class ul implements X509TrustManager {
    @Override  // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s) {
    }

    @Override  // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s) {
    }

    @Override  // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}

