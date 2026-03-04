package android.ext;

import android.content.SharedPreferences;

class hq implements Runnable {
    private final SharedPreferences a;

    hq(SharedPreferences sharedPreferences0) {
        this.a = sharedPreferences0;
        super();
    }

    @Override
    public void run() {
        this.a.edit().remove("last_exception").commit();
    }
}

