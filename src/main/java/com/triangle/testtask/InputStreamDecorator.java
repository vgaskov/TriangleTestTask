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
    public long skip(long n) throws IOException {
        return inputStream.skip(n);
    }

    @Override
    public int available() throws IOException {
        return inputStream.available();
    }

    @Override
    public synchronized void mark(int readlimit) {
        inputStream.mark(readlimit);
    }
	
	@Override
	public void close() throws IOException {
		//this is to prevent closing System.in when the Scanner is closed
	}

}
