package com.pl;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClasssloder extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> hello = new HelloClasssloder().loadClass("Hello");
        Method helloMethod = hello.getMethod("hello");
        helloMethod.invoke(hello.newInstance());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = null;
        try {
            ClassPathResource classPathResource = new ClassPathResource("Hello.xlass");
            FileInputStream fileInputStream = new FileInputStream(classPathResource.getFile().getPath());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[2048];
            int n;
            while ((n = fileInputStream.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fileInputStream.close();
            bos.close();
            bytes = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 -bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

}
