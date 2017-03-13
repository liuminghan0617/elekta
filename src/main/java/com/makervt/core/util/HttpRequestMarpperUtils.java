package com.makervt.core.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.output.ByteArrayOutputStream;

public class HttpRequestMarpperUtils extends HttpServletRequestWrapper {  
      
    private final byte[] body; // 报文  
  
    public HttpRequestMarpperUtils(HttpServletRequest request) throws IOException {  
        super(request);  
        body = readByte(request.getInputStream());  
    }  
      
    @Override  
    public BufferedReader getReader() throws IOException {  
        return new BufferedReader(new InputStreamReader(getInputStream()));  
    }  
      
    @Override  
    public ServletInputStream getInputStream() throws IOException {  
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);  
        return new ServletInputStream() {  
              
            @Override  
            public int read() throws IOException {  
                return bais.read();  
            }  
        };  
    }  
    
    private  static final byte[] readByte(InputStream inStream)  
            throws IOException {  
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
        byte[] buff = new byte[1024];  
        int rc = 0;  
        while ((rc = inStream.read(buff, 0, 1024)) > 0) {  
            swapStream.write(buff, 0, rc);  
        }  
        byte[] in2b = swapStream.toByteArray();  
        return in2b;  
    }  
  
}  