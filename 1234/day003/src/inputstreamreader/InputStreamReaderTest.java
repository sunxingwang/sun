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
 * ת������
 * 	�����ַ�����Ҳ���ڴ�����
 * 	InputStreamReader    InputStream-->Reader ����һ���ֽڵ�������ת��Ϊ�ַ���������
 * 	OutputStreamWriter   OutputStream-->Writer  ����һ���ַ��������ת��Ϊ�ֽڵ������
 * @author sunpan
 *
 */
public class InputStreamReaderTest {
	public static void main(String[] args) {
		testInputStreamReader();
	}
	
	//ʹ��InputStreamReaderת����,�������ֽ�����ȡ�ı��ĵ�������ݾͲ����������
	public static void testInputStreamReader() {
		//2.������
		FileInputStream fis = null;
		//InputStreamReader isr = new InputStreamReader(fis);//ʹ��ϵͳĬ�ϵ��ַ���
				//����2 "utf-8" ָ�����ַ��������ֽ�ת��Ϊ�ַ���һ�ַ�ʽ��ʹ�������ַ����������ļ������Ծ���
		InputStreamReader isr = null;
		try {
			//1.����File����
			File file = new File("D:\\java\\eclipse-workspace\\day003\\helloworld.txt");
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis,"utf-8");
			//3.�������
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
			//4.�ر���
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

	//ʹ��InputStreamReader��OutputStreamWriter������ת���ı��ı����ʽ
	public static void testStreamReader() {
		//2.������
		FileInputStream fis = null;
		FileOutputStream fos = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		try {
			//1.����File����
			File file1= new File("D:\\java\\eclipse-workspace\\day003\\helloworld.txt");
			File file2= new File("D:\\java\\eclipse-workspace\\day003\\�������.txt");
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			
			isr = new InputStreamReader(fis,"utf-8");
			osw = new OutputStreamWriter(fos,"gbk");
			//3.��д����
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
			//4.�ر���
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
