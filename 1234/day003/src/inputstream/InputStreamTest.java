package inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 测试FileInputStream 和 FileOutputStream的使用
 * @author sunpan
 * 结论：
 * 	1.对于文本文件（.txt,.java,.c,.cpp）使用字符流处理
 * 	2.对于非文本文件（.jpg,.mp3,.mp4,.doc,.ppt....）使用字节流处理
 * 
 * 
 *
 */
public class InputStreamTest {

	public static void main(String[] args){
		testInputStream1();
	}
	
	//使用字节流FileInputStream处理文本文件，可能会出现乱码
	public static void testInputStream() {
		//2.创建流
		FileInputStream fis = null;
		try {
			//1.创建File对象
			File file = new File("D:\\java\\eclipse-workspace\\day003\\helloworld.txt");
			fis = new FileInputStream(file);
			//3.input操作,读数据
			byte[] buffer = new byte[5];
			int len = fis.read(buffer);
			while(len != -1) {
				String str = new String(buffer,0,len);
				System.out.print(str);
				len = fis.read(buffer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4.关闭流
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//使用字节流FileInputStream处理非文本文件:实现对非文本文件的复制
	public static void testInputStream1() {
		//2.创建流
		InputStream fis = null;
		OutputStream fos = null;
		try {
			//1.创建File对象
			File file1 = new File("D:\\java\\eclipse-workspace\\day003\\微信图片_20210422211248.jpg");
			File file2 = new File("D:\\java\\eclipse-workspace\\day003\\88888888.jpg");
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			//3.读入操作
			byte[] b = new byte[10];
			int len = fis.read(b);
			while (len != -1) {
				fos.write(b, 0, len);
				len = fis.read(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4.关闭流
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
