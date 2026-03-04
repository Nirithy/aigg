package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.z;

final class Script.makeRequest extends Script.ApiFunction implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
    final Script d;
    private volatile byte e;

    Script.makeRequest(Script script0) {
        this.d = script0;
        super();
        this.e = 0;
    }

    private LuaTable a(HttpURLConnection httpURLConnection0) {
        LuaTable luaTable0 = new LuaTable();
        for(Object object0: httpURLConnection0.getHeaderFields().entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            if(s == null) {
                s = "null";
            }
            List list0 = (List)((Map.Entry)object0).getValue();
            LuaTable luaTable1 = new LuaTable();
            int v = 1;
            luaTable1.d_(list0.size());
            for(Object object1: list0) {
                luaTable1.b(v, ((String)object1));
                ++v;
            }
            luaTable0.b(s, luaTable1);
        }
        return luaTable0;
    }

    private void a(String s, LuaTable luaTable0, HttpURLConnection httpURLConnection0) {
        z z0 = luaTable0.S();
        while(z0.a()) {
            httpURLConnection0.addRequestProperty(s, z0.d().y());
        }
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.makeRequest(string url [, table headers = {} [, string data = nil]]) -> table || string";
    }

    public ap a(String s, LuaTable luaTable0, LuaString luaString0) {
        InputStream inputStream0;
        try {
            uk.a = true;
            LuaTable luaTable1 = new LuaTable();
            HttpURLConnection httpURLConnection0 = (HttpURLConnection)new URL(s).openConnection();
            z z0 = luaTable0.S();
            while(z0.a()) {
                LuaValue luaValue0 = z0.c();
                LuaValue luaValue1 = z0.d();
                if(luaValue1 instanceof LuaTable) {
                    this.a(luaValue0.y(), luaValue1.O(), httpURLConnection0);
                }
                else {
                    httpURLConnection0.addRequestProperty(luaValue0.y(), luaValue1.y());
                }
            }
            if(luaString0 == null) {
                httpURLConnection0.connect();
            }
            else {
                httpURLConnection0.setDoOutput(true);
                httpURLConnection0.setRequestMethod("POST");
                int v = luaString0.d;
                if(httpURLConnection0.getRequestProperty("Content-Length") == null) {
                    httpURLConnection0.addRequestProperty("Content-Length", Integer.toString(v));
                }
                if(httpURLConnection0.getRequestProperty("Content-Type") == null) {
                    httpURLConnection0.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpURLConnection0.connect();
                OutputStream outputStream0 = httpURLConnection0.getOutputStream();
                outputStream0.write(luaString0.b, luaString0.c, v);
                luaString0 = null;
                outputStream0.flush();
            }
            luaTable1.d("url", s);
            luaTable1.d("requestMethod", httpURLConnection0.getRequestMethod());
            luaTable1.b("code", httpURLConnection0.getResponseCode());
            luaTable1.d("message", httpURLConnection0.getResponseMessage());
            luaTable1.b("headers", this.a(httpURLConnection0));
            luaTable1.d("contentEncoding", httpURLConnection0.getContentEncoding());
            luaTable1.b("contentLength", httpURLConnection0.getContentLength());
            luaTable1.d("contentType", httpURLConnection0.getContentType());
            luaTable1.b("date", ((double)httpURLConnection0.getDate()));
            luaTable1.b("expiration", ((double)httpURLConnection0.getExpiration()));
            luaTable1.b("lastModified", ((double)httpURLConnection0.getLastModified()));
            luaTable1.b("usingProxy", (httpURLConnection0.usingProxy() ? LuaValue.v : LuaValue.w));
            if(httpURLConnection0 instanceof HttpsURLConnection) {
                luaTable1.d("cipherSuite", ((HttpsURLConnection)httpURLConnection0).getCipherSuite());
            }
            try {
                inputStream0 = httpURLConnection0.getInputStream();
            }
            catch(IOException unused_ex) {
                inputStream0 = httpURLConnection0.getErrorStream();
                luaTable1.b("error", LuaValue.v);
            }
            finally {
                httpURLConnection0.disconnect();
            }
            BufferedInputStream bufferedInputStream0 = new BufferedInputStream(inputStream0);
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            byte[] arr_b = new byte[0x2000];
            while(true) {
                int v2 = bufferedInputStream0.read(arr_b);
                if(v2 == -1) {
                    luaTable1.a("content", LuaValue.c(byteArrayOutputStream0.toByteArray()));
                    return luaTable1;
                }
                byteArrayOutputStream0.write(arr_b, 0, v2);
            }
        }
        catch(Throwable throwable0) {
            la.b(("makeRequest fail for \'" + s + "\'; data = " + luaString0 + "; headers = " + luaTable0), throwable0);
            return LuaValue.m(Script.a(throwable0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        String s = ap0.r(1);
        LuaTable luaTable0 = ap0.a(2, null);
        if(luaTable0 == null) {
            luaTable0 = new LuaTable();
        }
        LuaString luaString0 = ap0.a(3, null);
        if(this.e == 0) {
            synchronized(this) {
                rx.a(new Script.makeRequest.1(this));
                Script.a(this);
            }
        }
        return this.e != 1 ? LuaValue.m("The user did not allow access to the Internet.") : this.a(s, luaTable0, luaString0);
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 3;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.e = 1;
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        synchronized(this) {
            if(this.e == 0) {
                this.e = 2;
            }
            this.notify();
        }
    }
}

