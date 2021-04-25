package qita;

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * �����Ĵ�������
 * 	1.��׼�����������
 * 	��ϰ�⣺�Ӽ��������ַ�����Ҫ�󽫶�ȡ���������ַ���ת�ɴ�д�����Ȼ������������������
 * 	ֱ�������롰e�����ߡ�exit��ʱ���Ƴ�����
 * 	2.��ӡ��
 * 	3.������
 * @author sunpan
 *
 */
public class QiTaTest {

	public static void main(String[] args) {
		test1();
	}
	
	/*
	 * 1.��׼�����������:
	 * System.in :��׼��������
	 * System.out :��׼�������
	 * ��ϰ�⣺�Ӽ��������ַ�����Ҫ�󽫶�ȡ���������ַ���ת�ɴ�д�����Ȼ������������������
	 * ֱ�������롰e�����ߡ�exit��ʱ���Ƴ�����
	 */
	public static void test1() {
		//����1
		//1.�Ӽ��������ַ���
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("�����룺");
			String str = scan.next();
			if (str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")) {
				System.out.println("�������");
				break;
			}else {
				String str1 = str.toUpperCase();
				System.out.println(str1);
			}
		}
		
		
	}
	
	public static void test2()  {
		BufferedReader br = null;
		try {
			//1.����������
			
			InputStreamReader isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			//2.������
			while(true) {
				System.out.println("�����룺");
				String str = br.readLine();
				if("e".equalsIgnoreCase(str)||"exit".equalsIgnoreCase(str)) {
					System.out.println("�������");
					break;
				}
				
				String string = str.toUpperCase();
				System.out.println(string);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		
	}
	
	
}
