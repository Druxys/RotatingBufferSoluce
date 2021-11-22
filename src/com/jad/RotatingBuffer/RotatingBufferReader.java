package com.jad.RotatingBuffer;

class RotatingBufferReader<Data> extends RotatingBufferActor<Data> implements IRotatingBufferReader<Data>{
    public RotatingBufferReader(final RotatingBuffer<Data> buffer) {
        super(buffer);
    }

    @Override
    public Data read() {
        if ((this.getBuffer().getWriter().getIndex() != this.getIndex()) || !this.getBuffer().isEmpty()) {
            Data temp = this.getBuffer().getDataArray()[this.getIndex()];
            this.incrementIndex();
            if (this.getBuffer().getWriter().getIndex() == this.getIndex()) {
                this.getBuffer().setEmpty(true);
            }
            return temp;
        }
        return null;
    }
}
