package inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ����FileInputStream �� FileOutputStream��ʹ��
 * @author sunpan
 * ���ۣ�
 * 	1.�����ı��ļ���.txt,.java,.c,.cpp��ʹ���ַ�������
 * 	2.���ڷ��ı��ļ���.jpg,.mp3,.mp4,.doc,.ppt....��ʹ���ֽ�������
 * 
 * 
 *
 */
public class InputStreamTest {

	public static void main(String[] args){
		testInputStream1();
	}
	
	//ʹ���ֽ���FileInputStream�����ı��ļ������ܻ��������
	public static void testInputStream() {
		//2.������
		FileInputStream fis = null;
		try {
			//1.����File����
			File file = new File("D:\\java\\eclipse-workspace\\day003\\helloworld.txt");
			fis = new FileInputStream(file);
			//3.input����,������
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
			//4.�ر���
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//ʹ���ֽ���FileInputStream������ı��ļ�:ʵ�ֶԷ��ı��ļ��ĸ���
	public static void testInputStream1() {
		//2.������
		InputStream fis = null;
		OutputStream fos = null;
		try {
			//1.����File����
			File file1 = new File("D:\\java\\eclipse-workspace\\day003\\΢��ͼƬ_20210422211248.jpg");
			File file2 = new File("D:\\java\\eclipse-workspace\\day003\\88888888.jpg");
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			//3.�������
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
			//4.�ر���
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
