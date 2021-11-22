package com.jad.RotatingBuffer;

class RotatingBufferWriter<Data> extends RotatingBufferActor<Data> implements IRotatingBufferWriter<Data> {
    public RotatingBufferWriter(final RotatingBuffer<Data> buffer) {
        super(buffer);
    }

    @Override
    public boolean write(final Data data) {
        if ((this.getBuffer().getReader().getIndex() != this.getIndex()) || this.getBuffer().isEmpty()) {
            this.getBuffer().getDataArray()[this.getIndex()] = data;
            this.getBuffer().setEmpty(false);
            this.incrementIndex();
            return true;
        }
        return false;
    }
}
