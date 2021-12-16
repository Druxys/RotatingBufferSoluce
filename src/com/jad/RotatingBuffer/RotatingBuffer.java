package com.jad.RotatingBuffer;

import java.lang.reflect.Array;

public class RotatingBuffer<Data> {
    private final Data[] dataArray;
    private final RotatingBufferReader<Data> reader;
    private final RotatingBufferWriter<Data> writer;
    private boolean empty;
    private final int size;

    public RotatingBuffer(int size) {
        this.size = (size <= 0) ? 1 : size;
        this.empty = true;
        this.dataArray = (Data[]) new Object[this.getSize()];
        //Array.newInstance(dataClass, this.getSize());
        this.reader = new RotatingBufferReader<Data>(this);
        this.writer = new RotatingBufferWriter<Data>(this);
    }

    public int getSize() {
        return this.size;
    }

    Data[] getDataArray() {
        return this.dataArray;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public IRotatingBufferReader<Data> getReader() {
        return reader;
    }

    public IRotatingBufferWriter<Data> getWriter() {
        return writer;
    }

    public synchronized Data read() {
        return this.reader.read();
    }

    public synchronized boolean write(final Data data) {
        return this.writer.write(data);
    }
}
