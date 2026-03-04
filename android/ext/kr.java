package android.ext;

import android.inputmethodservice.Keyboard;

class kr implements Runnable {
    final InternalKeyboard a;
    private final Keyboard b;

    kr(InternalKeyboard internalKeyboard0, Keyboard keyboard0) {
        this.a = internalKeyboard0;
        this.b = keyboard0;
        super();
    }

    @Override
    public void run() {
        this.a.setKeyboard(this.b);
    }
}

