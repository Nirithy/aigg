package android.ext;

import android.content.Context;
import android.content.res.Resources;
import android.fix.g;
import android.fix.i;
import android.inputmethodservice.Keyboard.Key;
import android.inputmethodservice.Keyboard;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ScrollView;
import java.lang.ref.WeakReference;

public class InternalKeyboard extends g {
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private WeakReference g;
    private boolean h;
    private int i;

    public InternalKeyboard(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.d = true;
        this.e = false;
        this.f = 0;
        this.g = new WeakReference(null);
        this.h = false;
        this.i = -1;
        this.a(context0);
    }

    public InternalKeyboard(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.d = true;
        this.e = false;
        this.f = 0;
        this.g = new WeakReference(null);
        this.h = false;
        this.i = -1;
        this.a(context0);
    }

    public InternalKeyboard(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.d = true;
        this.e = false;
        this.f = 0;
        this.g = new WeakReference(null);
        this.h = false;
        this.i = -1;
        this.a(context0);
    }

    private int a(boolean z, boolean z1, boolean z2, boolean z3) {
        if(z) {
            if(z1) {
                return 0x7F0B0155;  // id:k_hex
            }
            if(z2) {
                return 0x7F0B0156;  // id:k_fn
            }
            return z3 ? 0x7F0B0158 : 0x7F0B0154;  // id:k_small
        }
        return 0x7F0B0157;  // id:k_ext
    }

    public static View a(View view0) {
        return InternalKeyboard.c(view0, true);
    }

    private void a(Context context0) {
        this.b = false;
        this.c = false;
        if(this.isInEditMode()) {
            return;
        }
        try {
            this.setPreviewEnabled(false);
            this.setOnKeyboardActionListener(new kq(this));
        }
        catch(Throwable throwable0) {
            la.c("Failed init internal keyboard", throwable0);
        }
    }

    private void a(Keyboard.Key keyboard$Key0) {
        if((this.f & 1) != 0 && ":".equals(keyboard$Key0.label)) {
            this.a(keyboard$Key0, "?");
        }
        if((this.f & 2) != 0 && ";".equals(keyboard$Key0.label)) {
            this.a(keyboard$Key0, "*");
        }
        if((this.f & 4) != 0 && "~".equals(keyboard$Key0.label)) {
            this.a(keyboard$Key0, "^");
        }
        if((this.f & 8) != 0 && "r".equals(keyboard$Key0.label)) {
            this.a(keyboard$Key0, "$");
        }
    }

    private void a(Keyboard.Key keyboard$Key0, String s) {
        keyboard$Key0.label = s;
        if(keyboard$Key0.codes == null) {
            keyboard$Key0.codes = new int[1];
        }
        keyboard$Key0.codes[0] = s.charAt(0);
    }

    public static void a(View view0, int v) {
        Tools.a(view0, new ks(v));
    }

    public static void a(View view0, boolean z) {
        InternalKeyboard internalKeyboard0 = (InternalKeyboard)view0.getRootView().findViewById(0x7F0B002A);  // id:keyboard
        if(internalKeyboard0 != null) {
            internalKeyboard0.b(view0, z);
            if(!z) {
                Tools.e(view0);
            }
        }
    }

    private void a(Window window0, boolean z) {
        int v1;
        WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
        View view0 = window0.getDecorView();
        int v = view0.getWidth();
        try {
            view0.measure(-2, -2);
            v1 = Math.max(v, view0.getMeasuredWidth());
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            v1 = v;
        }
        if(z) {
            int v2 = this.getWidth();
            try {
                this.measure(-2, -2);
                v1 += Math.max(v2, this.getMeasuredWidth());
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
            }
        }
        else {
            v1 += Tools.b();
        }
        windowManager$LayoutParams0.width = v1;
        if(windowManager$LayoutParams0.width >= MainService.context.getResources().getDisplayMetrics().widthPixels) {
            windowManager$LayoutParams0.width = -1;
        }
        window0.setAttributes(windowManager$LayoutParams0);
    }

    public void a() {
        this.g();
        this.b();
    }

    void a(int v) {
        int v3;
        Window window0 = this.getWindow();
        if(window0 != null) {
            View view0 = window0.getCurrentFocus();
            if(view0 instanceof EditText) {
                EditText editText0 = (EditText)view0;
                int v1 = Math.max(editText0.getSelectionStart(), 0);
                int v2 = Math.max(editText0.getSelectionEnd(), 0);
                String s = null;
                if(v < 5000) {
                    s = String.valueOf(((char)v));
                    v3 = 0;
                }
                else {
                    switch(v) {
                        case 5000: {
                            v3 = 67;
                            break;
                        }
                        case 5001: {
                            v3 = 0x70;
                            break;
                        }
                        case 5002: {
                            s = ps.a;
                            v3 = 0;
                            break;
                        }
                        case 5003: {
                            s = ".";
                            v3 = 0;
                            break;
                        }
                        case 5004: 
                        case 5005: {
                            if(v1 == v2 && (v1 == 0 && v == 5004 || v1 == editText0.getText().length() && v == 5005)) {
                                v3 = 0;
                            }
                            else {
                                v3 = v == 5004 ? 21 : 22;
                            }
                            break;
                        }
                        case 5006: {
                            this.e();
                            v3 = 0;
                            break;
                        }
                        case 5007: {
                            iw.a(editText0);
                            v3 = 0;
                            break;
                        }
                        case 5008: {
                            Tools.a(editText0);
                            v3 = 0;
                            break;
                        }
                        case 5009: {
                            this.d();
                            v3 = 0;
                            break;
                        }
                        case 5010: {
                            this.f();
                            v3 = 0;
                            break;
                        }
                        default: {
                            v3 = 0;
                        }
                    }
                }
                if(s != null) {
                    editText0.getText().replace(Math.min(v1, v2), Math.max(v1, v2), s, 0, s.length());
                    editText0.setSelection(Math.max(editText0.getSelectionStart(), editText0.getSelectionEnd()));
                }
                if(v3 != 0) {
                    try {
                        editText0.dispatchKeyEvent(new KeyEvent(0, v3));
                        editText0.dispatchKeyEvent(new KeyEvent(1, v3));
                    }
                    catch(Throwable throwable0) {
                        la.c("Failed send key to app", throwable0);
                    }
                }
            }
        }
    }

    void a(int v, int[] arr_v) {
        try {
            this.h = true;
            this.a(v);
            this.h = false;
        }
        catch(Throwable throwable0) {
            this.h = false;
            throw throwable0;
        }
    }

    public void a(Window window0) {
        this.g = new WeakReference(window0);
        if(!this.d || (Config.B & 1) == 0) {
            window0.clearFlags(0x20000);
        }
        else {
            window0.addFlags(0x20000);
        }
        this.g();
        View view0 = window0.getDecorView();
        Window.Callback window$Callback0 = window0.getCallback();
        if(window$Callback0 instanceof uv && view0.getWidth() == 0) {
            ((uv)window$Callback0).a(this);
            return;
        }
        this.b();
    }

    public void b() {
        boolean z = true;
        Window window0 = this.getWindow();
        if(window0 != null) {
            int v = MainService.context.getResources().getConfiguration().orientation;
            if(this.i != v) {
                this.i = v;
                if(v == 1) {
                    z = false;
                }
                this.a(window0, z);
            }
        }
    }

    public void b(View view0, boolean z) {
        try {
            if(view0 != null) {
                Window window0 = this.getWindow();
                if(window0 != null) {
                    Tools.a(window0, view0, z);
                }
                if(z) {
                    this.setKeyboard(false);
                    return;
                }
                this.g();
            }
        }
        catch(Throwable throwable0) {
            la.c(("Failed show/hide kbd: " + z), throwable0);
        }
    }

    public static View c(View view0, boolean z) {
        if(InternalKeyboard.c()) {
            View view1 = (KeyboardLayout)i.a(0x7F040006, null);  // layout:keyboard
            ViewGroup viewGroup0 = (ViewGroup)((KeyboardLayout)view1).findViewById((view0 instanceof ScrollView ? 0x7F0B0029 : 0x7F0B0028));  // id:kbd_frame
            viewGroup0.addView(view0);
            viewGroup0.setVisibility(0);
            InternalKeyboard internalKeyboard0 = (InternalKeyboard)((KeyboardLayout)view1).findViewById(0x7F0B002A);  // id:keyboard
            internalKeyboard0.setAllowUseInternal(z);
            Object object0 = view0.getTag();
            if(object0 instanceof kt) {
                internalKeyboard0.setFlags(((kt)object0).a);
            }
            ((KeyboardLayout)view1).a();
            return view1;
        }
        return view0;
    }

    public static boolean c() {
        try {
            return i.a(0x7F040006, null) == null ? false : true;  // layout:keyboard
        }
        catch(Throwable throwable0) {
            la.c("Check internal keyboard fail", throwable0);
            return false;
        }
    }

    private void d() {
        int v = 1;
        boolean z = (Config.B & 0x40) == 0;
        ct ct0 = Config.a(0x7F0B00BF);  // id:config_kbd_small
        if(!z) {
            v = 0;
        }
        ct0.d = v;
        Config.c();
        this.g();
    }

    private void e() {
        this.b = !this.b;
        this.g();
    }

    private void f() {
        this.c = !this.c;
        this.g();
    }

    private void g() {
        this.setKeyboard(this.d && (Config.B & 1) != 0);
    }

    public int getFlags() {
        return this.f;
    }

    private Window getWindow() {
        return (Window)this.g.get();
    }

    @Override  // android.view.View
    public void playSoundEffect(int v) {
        try {
            super.playSoundEffect(v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.view.View
    public void sendAccessibilityEvent(int v) {
        try {
            super.sendAccessibilityEvent(v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    public void setAllowUseInternal(boolean z) {
        this.d = z;
    }

    public void setFlags(int v) {
        this.f = v;
    }

    public void setHideKeyboard(boolean z) {
        boolean z1 = this.e;
        this.e = z;
        if(z1 != z) {
            this.g();
        }
    }

    private void setKeyboard(boolean z) {
        Keyboard keyboard1;
        boolean z1 = this.b;
        boolean z2 = this.c;
        boolean z3 = (Config.B & 0x40) != 0;
        int v = this.e ? 0x7F050000 : 0x7F050001;  // xml:empty
        Keyboard keyboard0 = new Keyboard(MainService.context, v, this.a(z, z1, z2, z3));
        if(this.e) {
            keyboard1 = keyboard0;
        }
        else {
            if(z1 && keyboard0.getKeys().size() == 0) {
                keyboard0 = new Keyboard(MainService.context, v, this.a(z, false, z2, z3));
                z1 = false;
            }
            if(z2 && keyboard0.getKeys().size() == 0) {
                keyboard0 = new Keyboard(MainService.context, v, this.a(z, z1, false, z3));
                z2 = false;
            }
            keyboard1 = !z3 || keyboard0.getKeys().size() != 0 ? keyboard0 : new Keyboard(MainService.context, v, this.a(z, z1, z2, false));
        }
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        for(Object object0: keyboard1.getKeys()) {
            Keyboard.Key keyboard$Key0 = (Keyboard.Key)object0;
            if(keyboard$Key0 != null) {
                sparseIntArray0.put(keyboard$Key0.y, sparseIntArray0.get(keyboard$Key0.y, 0) + 1);
                if(!z2) {
                    this.a(keyboard$Key0);
                }
                if(keyboard$Key0.codes != null && keyboard$Key0.codes.length != 0) {
                    if(keyboard$Key0.codes[0] == 5002) {
                        keyboard$Key0.label = ps.a;
                    }
                    if(keyboard$Key0.codes[0] == 5003) {
                        keyboard$Key0.label = ".";
                    }
                }
            }
        }
        Resources resources0 = this.getContext().getResources();
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getLayoutParams();
        if(viewGroup$LayoutParams0 != null && sparseIntArray0.size() > 0) {
            viewGroup$LayoutParams0.width = Math.round(resources0.getDimension(0x7F080001) * ((float)sparseIntArray0.valueAt(0)));  // dimen:key_width
            viewGroup$LayoutParams0.height = Math.round(resources0.getDimension(0x7F080002) * ((float)sparseIntArray0.size()));  // dimen:key_height
            this.setLayoutParams(viewGroup$LayoutParams0);
            la.a(("Kbd: " + sparseIntArray0.valueAt(0) + " x " + sparseIntArray0.size() + "; " + viewGroup$LayoutParams0.width + 'x' + viewGroup$LayoutParams0.height + "; " + keyboard1.getMinWidth() + 'x' + keyboard1.getHeight()));
        }
        if(this.h) {
            this.post(new kr(this, keyboard1));
            return;
        }
        this.setKeyboard(keyboard1);
    }
}

