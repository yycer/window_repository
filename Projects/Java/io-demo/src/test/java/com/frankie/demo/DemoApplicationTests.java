package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.nio.cs.StreamEncoder;

import javax.print.DocFlavor;
import java.io.*;
import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private String file = "D:\\Playground\\spring-boot-examples\\io-demo\\src\\main\\resources\\io.txt";
    private String charset = "UTF-8";


    @Test
    public void characterTest() {
        char s = '严';
        int result = (int) s;

    }


    @Test
    public void outputTest() throws IOException {

        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, charset);

        try {
            writer.write("姚屹晨");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }

    @Test
    public void inputTest() throws IOException{
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuffer buffer = new StringBuffer();
        char[] buf = new char[64];
        int count = 0;
        try {
            while((count = reader.read(buf)) != -1){
                buffer.append(buf, 0, count);
            }
        }finally {
            reader.close();
        }

    }

    @Test
    public void encodeTest(){
        String name = "l am 姚屹晨";

        try {
            byte[] iso8859 = name.getBytes("ISO-8859-1");
            byte[] gbk = name.getBytes("GBK");
            byte[] utf16 = name.getBytes("UTF-16");
            byte[] utf8 = name.getBytes("UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
