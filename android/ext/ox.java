package android.ext;

class ox implements Runnable {
    final ow a;

    ox(ow ow0) {
        this.a = ow0;
        super();
    }

    @Override
    public void run() {
        this.a.notifyDataSetChanged();
    }
}

