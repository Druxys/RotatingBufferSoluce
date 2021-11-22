package com.jad.RotatingBuffer;

abstract class RotatingBufferActor<Data> {
    private RotatingBuffer<Data> buffer;
    private int index;

    public RotatingBufferActor(RotatingBuffer<Data> buffer) {
        this.buffer = buffer;
        this.index = 0;
    }

    protected RotatingBuffer<Data> getBuffer() {
        return this.buffer;
    }

    public int getIndex() {
        return this.index;
    }

    protected void incrementIndex() {
        this.index = (this.index + 1) % this.getBuffer().getSize();
    }
}
