package inputstreamreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 转换流：
 * 	属于字符流，也属于处理流
 * 	InputStreamReader    InputStream-->Reader ：将一个字节的输入流转换为字符的输入流
 * 	OutputStreamWriter   OutputStream-->Writer  ：将一个字符的输出流转换为字节的输出流
 * @author sunpan
 *
 */
public class InputStreamReaderTest {
	public static void main(String[] args) {
		testInputStreamReader();
	}
	
	//使用InputStreamReader转换流,这样用字节流读取文本文档里的内容就不会出现乱码
	public static void testInputStreamReader() {
		//2.创建流
		FileInputStream fis = null;
		//InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
				//参数2 "utf-8" 指明了字符集，把字节转换为字符的一种方式；使用拿种字符集，根据文件的属性决定
		InputStreamReader isr = null;
		try {
			//1.创建File对象
			File file = new File("D:\\java\\eclipse-workspace\\day003\\helloworld.txt");
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis,"utf-8");
			//3.读入操作
			char[] ch = new char[5];
			int len = isr.read(ch);
			while(len != -1) {
				String str = new String(ch,0,len);
				System.out.print(str);
				len = isr.read(ch);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4.关闭流
			try {
				if (isr!=null)
					isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (fis!=null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	//使用InputStreamReader和OutputStreamWriter，可以转换文本的编码格式
	public static void testStreamReader() {
		//2.创建流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		try {
			//1.创建File对象
			File file1= new File("D:\\java\\eclipse-workspace\\day003\\helloworld.txt");
			File file2= new File("D:\\java\\eclipse-workspace\\day003\\你好世界.txt");
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			
			isr = new InputStreamReader(fis,"utf-8");
			osw = new OutputStreamWriter(fos,"gbk");
			//3.读写操作
			char[] chs= new char[10];
			int len = isr.read(chs);
			while(len != -1) {
				osw.write(chs, 0, len);
				len = isr.read(chs);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4.关闭流
			try {
				if (osw != null)
					osw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (isr != null)
					isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
