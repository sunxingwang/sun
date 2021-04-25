package qita;

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 其他的处理流：
 * 	1.标准的输入输出流
 * 	练习题：从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作，
 * 	直到当输入“e”或者“exit”时，推出程序
 * 	2.打印流
 * 	3.数据流
 * @author sunpan
 *
 */
public class QiTaTest {

	public static void main(String[] args) {
		test1();
	}
	
	/*
	 * 1.标准的输入输出流:
	 * System.in :标准的输入流
	 * System.out :标准的输出流
	 * 练习题：从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作，
	 * 直到当输入“e”或者“exit”时，推出程序
	 */
	public static void test1() {
		//方法1
		//1.从键盘输入字符串
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入：");
			String str = scan.next();
			if (str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")) {
				System.out.println("程序结束");
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
			//1.创建输入流
			
			InputStreamReader isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			//2.读操作
			while(true) {
				System.out.println("请输入：");
				String str = br.readLine();
				if("e".equalsIgnoreCase(str)||"exit".equalsIgnoreCase(str)) {
					System.out.println("程序结束");
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
