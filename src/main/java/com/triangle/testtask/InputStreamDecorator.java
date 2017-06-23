package com.triangle.testtask;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamDecorator extends InputStream {

	private final InputStream inputStream; 
	
	public InputStreamDecorator(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return inputStream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return inputStream.read(b, off, len);
    }

	@Override
	public void close() throws IOException {
		//Leaving the method blank to prevent closing input stream when closing Scanner
	}
}