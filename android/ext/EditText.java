package android.ext;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Field;

public class EditText extends android.fix.EditText implements ha {
    private int a;
    private static volatile gz[] b;

    static {
        EditText.b = new gz[0];
    }

    public EditText(Context context0) {
        super(context0);
        this.a = -1;
        if(!this.isInEditMode()) {
            this.setInputType(((Config.B & 8) == 0 ? 0x80001 : 1));
        }
        this.setSingleLine(true);
        this.setSelectAllOnFocus(true);
        this.setMinEms(10);
        this.setCursorVisible(true);
        this.setFocusableInTouchMode(true);
        try {
            Field field0 = TextView.class.getDeclaredField("mCursorDrawableRes");
            field0.setAccessible(true);
            field0.set(this, 0);
        }
        catch(Exception unused_ex) {
        }
        if(!this.isInEditMode()) {
            EditText.a(this);
        }
    }

    public EditText(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = -1;
        if(!this.isInEditMode()) {
            this.setInputType(((Config.B & 8) == 0 ? 0x80001 : 1));
        }
        this.setSingleLine(true);
        this.setSelectAllOnFocus(true);
        this.setMinEms(10);
        this.setCursorVisible(true);
        this.setFocusableInTouchMode(true);
        try {
            Field field0 = TextView.class.getDeclaredField("mCursorDrawableRes");
            field0.setAccessible(true);
            field0.set(this, 0);
        }
        catch(Exception unused_ex) {
        }
        if(!this.isInEditMode()) {
            EditText.a(this);
        }
    }

    public EditText(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = -1;
        if(!this.isInEditMode()) {
            this.setInputType(((Config.B & 8) == 0 ? 0x80001 : 1));
        }
        this.setSingleLine(true);
        this.setSelectAllOnFocus(true);
        this.setMinEms(10);
        this.setCursorVisible(true);
        this.setFocusableInTouchMode(true);
        try {
            Field field0 = TextView.class.getDeclaredField("mCursorDrawableRes");
            field0.setAccessible(true);
            field0.set(this, 0);
        }
        catch(Exception unused_ex) {
        }
        if(!this.isInEditMode()) {
            EditText.a(this);
        }
    }

    @TargetApi(21)
    public EditText(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.a = -1;
        if(!this.isInEditMode()) {
            this.setInputType(((Config.B & 8) == 0 ? 0x80001 : 1));
        }
        this.setSingleLine(true);
        this.setSelectAllOnFocus(true);
        this.setMinEms(10);
        this.setCursorVisible(true);
        this.setFocusableInTouchMode(true);
        try {
            Field field0 = TextView.class.getDeclaredField("mCursorDrawableRes");
            field0.setAccessible(true);
            field0.set(this, 0);
        }
        catch(Exception unused_ex) {
        }
        if(!this.isInEditMode()) {
            EditText.a(this);
        }
    }

    private static double a(int v) {
        double f4;
        double f = ((double)Color.red(v)) / 255.0;
        double f1 = ((double)Color.green(v)) / 255.0;
        double f2 = ((double)Color.blue(v)) / 255.0;
        double f3 = f <= 0.03928 ? f / 12.92 : Math.pow((f + 0.055) / 1.055, 2.4);
        if(f1 <= 0.03928) {
            f4 = f1 / 12.92;
            return f2 <= 0.03928 ? f2 / 12.92 * 0.0722 + (f4 * 0.7152 + f3 * 0.2126) : Math.pow((f2 + 0.055) / 1.055, 2.4) * 0.0722 + (f4 * 0.7152 + f3 * 0.2126);
        }
        f4 = Math.pow((f1 + 0.055) / 1.055, 2.4);
        return f2 <= 0.03928 ? f2 / 12.92 * 0.0722 + (f4 * 0.7152 + f3 * 0.2126) : Math.pow((f2 + 0.055) / 1.055, 2.4) * 0.0722 + (f4 * 0.7152 + f3 * 0.2126);
    }

    private static int a(int v, int v1) {
        int v2 = Color.alpha(v);
        int v3 = 0xFF000000;
        for(int v4 = 0; v4 < 3; ++v4) {
            v3 |= ((v >> v4 * 8 & 0xFF) * v2 + (v1 >> v4 * 8 & 0xFF) * (0xFF - v2)) / 0xFF << v4 * 8;
        }
        return v3;
    }

    private static void a(gz gz0) {
        int v = gz0.a;
        int v1 = gz0.b;
        la.a(("checkContrast(fg, bg): " + Integer.toHexString(v) + ' ' + Integer.toHexString(v1)));
        gz0.c = (float)EditText.b(v, v1);
        gz0.d = (float)Math.abs(EditText.b(v) - EditText.b(v1));
        gz0.e = (float)EditText.c(v, v1);
        try {
            la.a(("checkContrast(fg, bg): " + gz0.c + ", " + gz0.d + ", " + gz0.e));
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    static void a(android.widget.EditText editText0) {
        Bitmap bitmap0;
        int[] arr_v = View.ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
        int v = 0xFF000000;
        Drawable drawable0 = editText0.getBackground();
        if(drawable0 != null) {
            int v1 = (int)Tools.a(36.0f);
            Rect rect0 = drawable0.copyBounds();
            int[] arr_v1 = drawable0.getState();
            drawable0.setBounds(0, 0, v1, v1);
            drawable0.setState(arr_v);
            try {
                bitmap0 = Bitmap.createBitmap(v1, v1, Bitmap.Config.ARGB_8888);
            }
            catch(OutOfMemoryError outOfMemoryError0) {
                la.b("Failed checkContrast", outOfMemoryError0);
                return;
            }
            drawable0.draw(new Canvas(bitmap0));
            v = bitmap0.getPixel(v1 / 2, v1 / 2);
            drawable0.setBounds(rect0);
            drawable0.setState(arr_v1);
        }
        int v2 = editText0.getTextColors().getColorForState(arr_v, editText0.getCurrentTextColor());
        int v3 = EditText.b(editText0);
        if(EditText.a(EditText.a(v2, v), v, EditText.a(v3, v))) {
            editText0.setTextColor(-1);
            editText0.setHighlightColor(0xFFA07070);
            editText0.setBackgroundResource(0x7F020000);  // drawable:abc_textfield_default_mtrl_alpha
        }
    }

    private static boolean a(int v, int v1, int v2) {
        float[] arr_f = {2.0f, 50.0f, 150.0f};
        return EditText.a(v, v1, new float[]{4.5f, 125.0f, 500.0f}) || EditText.a(v, v2, arr_f) || EditText.a(v2, v1, arr_f);
    }

    private static boolean a(int v, int v1, float[] arr_f) {
        gz gz0;
        gz[] arr_gz = EditText.b;
        for(int v2 = 0; true; ++v2) {
            if(v2 >= arr_gz.length) {
                gz0 = null;
            }
            else {
                gz gz1 = arr_gz[v2];
                if(gz1.a != v || gz1.b != v1) {
                    continue;
                }
                else {
                    gz0 = gz1;
                }
            }
            if(gz0 == null) {
                gz0 = new gz();
                gz0.a = v;
                gz0.b = v1;
                EditText.a(gz0);
                gz[] arr_gz1 = new gz[arr_gz.length + 1];
                System.arraycopy(arr_gz, 0, arr_gz1, 0, arr_gz.length);
                arr_gz1[arr_gz.length] = gz0;
                EditText.b = arr_gz1;
            }
            return gz0.c < arr_f[0] || gz0.d < arr_f[1] || gz0.e < arr_f[2];
        }
    }

    private static double b(int v) {
        return ((double)(Color.red(v) * 299 + Color.green(v) * 587 + Color.blue(v) * 0x72)) / 1000.0;
    }

    private static double b(int v, int v1) {
        double f = EditText.a(v);
        double f1 = EditText.a(v1);
        return f + 0.05 > f1 + 0.05 ? (f + 0.05) / (f1 + 0.05) : (f1 + 0.05) / (f + 0.05);
    }

    private static int b(android.widget.EditText editText0) {
        try {
            if(Build.VERSION.SDK_INT >= 16) {
                return editText0.getHighlightColor();
            }
        }
        catch(Throwable throwable0) {
            la.c("Failed getHighlightColor", throwable0);
        }
        try {
            Field field0 = TextView.class.getDeclaredField("mHighlightColor");
            field0.setAccessible(true);
            return field0.getInt(editText0);
        }
        catch(Throwable throwable1) {
            la.c("Failed getHighlightColor2", throwable1);
            return 0;
        }
    }

    private static double c(int v, int v1) {
        int v2 = Color.red(v);
        int v3 = Color.green(v);
        int v4 = Color.blue(v);
        int v5 = Color.red(v1);
        int v6 = Color.green(v1);
        int v7 = Color.blue(v1);
        return (double)(Math.max(v2, v5) - Math.min(v2, v5) + (Math.max(v3, v6) - Math.min(v3, v6)) + (Math.max(v4, v7) - Math.min(v4, v7)));
    }

    @Override  // android.ext.ha
    public int getDataType() {
        return this.a;
    }

    @Override  // android.ext.ha
    public void setDataType(int v) {
        this.a = v;
    }
}

