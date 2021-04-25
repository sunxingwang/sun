package inputstream;
/**
 * 缓冲流的使用
 * 	BufferedInputStream
 * 	BufferedOutputStream
 * 	BufferedReader
 * 	BufferedWriter
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamTest {
	

	public static void main(String[] args) {
		testBufferedStream();
	}
	
	//使用Buffered缓冲流加快复制速度
	public static void testBufferedStream() {
		//2.创建流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			//1.创建File对象
			File file1 = new File("D:\\java\\eclipse-workspace\\day003\\微信图片_20210422211248.jpg");
			File file2 = new File("D:\\java\\eclipse-workspace\\day003\\微信图片.jpg");
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			//3。读入操作
			byte[] b = new byte[10];
			int len = bis.read(b);
			while(len!=-1) {
				bos.write(b,0,len);
				len = bis.read(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4.关闭流
			try {
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (bis != null)
					bis.close();
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
