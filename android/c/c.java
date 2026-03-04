package android.c;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;

public class c extends ContentProvider {
    private static final String[] a;

    static {
        c.a = new String[]{"_display_name", "_size"};
    }

    public static Uri a(Context context0, String s, File file0) {
        return new Uri.Builder().scheme("content").authority(s).encodedPath(file0.getAbsolutePath()).build();
    }

    private static File a(Uri uri0) {
        String s = uri0.getPath();
        if(s == null || !s.endsWith(".apk")) {
            return new File("/wrong_path/" + s);
        }
        if(!s.startsWith("/")) {
            s = "/" + s;
        }
        return new File(s);
    }

    private static Object[] a(Object[] arr_object, int v) {
        Object[] arr_object1 = new Object[v];
        System.arraycopy(arr_object, 0, arr_object1, 0, v);
        return arr_object1;
    }

    private static String[] a(String[] arr_s, int v) {
        String[] arr_s1 = new String[v];
        System.arraycopy(arr_s, 0, arr_s1, 0, v);
        return arr_s1;
    }

    @Override  // android.content.ContentProvider
    public void attachInfo(Context context0, ProviderInfo providerInfo0) {
        super.attachInfo(context0, providerInfo0);
        if(providerInfo0.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if(!providerInfo0.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    @Override  // android.content.ContentProvider
    public int delete(Uri uri0, String s, String[] arr_s) {
        return 0;
    }

    @Override  // android.content.ContentProvider
    public String getType(Uri uri0) {
        return "application/vnd.android.package-archive";
    }

    @Override  // android.content.ContentProvider
    public Uri insert(Uri uri0, ContentValues contentValues0) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override  // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override  // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri0, String s) {
        return ParcelFileDescriptor.open(c.a(uri0), 0x10000000);
    }

    @Override  // android.content.ContentProvider
    public Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        int v2;
        File file0 = c.a(uri0);
        if(arr_s == null) {
            arr_s = c.a;
        }
        String[] arr_s2 = new String[arr_s.length];
        Object[] arr_object = new Object[arr_s.length];
        int v = 0;
        int v1;
        for(v1 = 0; v < arr_s.length; v1 = v2) {
            String s2 = arr_s[v];
            if("_display_name".equals(s2)) {
                arr_s2[v1] = "_display_name";
                v2 = v1 + 1;
                arr_object[v1] = file0.getName();
            }
            else if("_size".equals(s2)) {
                arr_s2[v1] = "_size";
                v2 = v1 + 1;
                arr_object[v1] = file0.length();
            }
            else {
                v2 = v1;
            }
            ++v;
        }
        String[] arr_s3 = c.a(arr_s2, v1);
        Object[] arr_object1 = c.a(arr_object, v1);
        Cursor cursor0 = new MatrixCursor(arr_s3, 1);
        ((MatrixCursor)cursor0).addRow(arr_object1);
        return cursor0;
    }

    @Override  // android.content.ContentProvider
    public int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        throw new UnsupportedOperationException("No external updates");
    }
}

