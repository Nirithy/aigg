package android.ext;

class li implements Runnable {
    private boolean a;

    li() {
        this.a = false;
    }

    @Override
    public void run() {
        if(this.a) {
            return;
        }
        this.a = true;
        lh.a();
    }
}

