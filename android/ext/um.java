package android.ext;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class um implements HostnameVerifier {
    @Override  // javax.net.ssl.HostnameVerifier
    public boolean verify(String s, SSLSession sSLSession0) {
        return true;
    }
}

