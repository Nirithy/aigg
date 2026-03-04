package android.ext;

import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;

class kq implements KeyboardView.OnKeyboardActionListener {
    final InternalKeyboard a;

    kq(InternalKeyboard internalKeyboard0) {
        this.a = internalKeyboard0;
        super();
    }

    @Override  // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void onKey(int v, int[] arr_v) {
        this.a.a(v, arr_v);
    }

    @Override  // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void onPress(int v) {
    }

    @Override  // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void onRelease(int v) {
    }

    @Override  // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void onText(CharSequence charSequence0) {
    }

    @Override  // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void swipeDown() {
    }

    @Override  // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void swipeLeft() {
    }

    @Override  // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void swipeRight() {
    }

    @Override  // android.inputmethodservice.KeyboardView$OnKeyboardActionListener
    public void swipeUp() {
    }
}

