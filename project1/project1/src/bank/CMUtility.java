package bank;

import java.util.*;

public class CMUtility {
	private static Scanner scanner = new Scanner(System.in);
	/**
	 * ���ڽ���˵���ѡ�񡣸÷�����ȡ���̣�����û�����1-5�������ַ����򷽷����ء�����ֵΪ�û������ַ�
	 */
	public static char readMenuSelection() {
		char c;
		for(; ;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if(c != '1' && c != '2' && c != '3' && c != '4'&& c != '5') {
				System.out.println("ѡ���������������");
			}else break;
		}
		return c;
	}
	/**
	 * �Ӽ��̶�ȡһ���ַ�����������λ�����ķ���ֵ��
	 */
	public static char readChar() {
		String str = readKeyBoard(1, false);
		return str.charAt(0);
	}
	/**
	 * �Ӽ��̶�ȡһ���ַ�����������Ϊ�����ķ���ֵ��
	 * ����û��������ַ���ֱ�ӻس�����������defaultValue ��Ϊ����ֵ
	 */
	public static char readChar(char defaultValue) {
		String str = readKeyBoard(1, true);
		return (str.length() == 0) ? defaultValue : str.charAt(0);
	}
	/**
	 * �Ӽ��̶�ȡһ�����Ȳ�����2λ����������������λ�����ķ���ֵ
	 */
	public static int readInt() {
		int n;
		for(; ;) {
			String str = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NullPointerException e) {
				System.out.println("��������������������룺");
			}
		}
		return n;
	}

	/**
	 * �Ӽ��̶�ȡһ���ַ�����������Ϊ�����ķ���ֵ��
	 * ����û��������ַ���ֱ�ӻس�����������defaultVallue ��Ϊ����ֵ
	 */
	public static int readInt(int defaultValue) {
		int n;
		for(; ;) {
			String str = readKeyBoard(2, false);
			if(str.equals("")) {
				return defaultValue;
			}
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NullPointerException e) {
				System.out.println("��������������������룺");
			}
		}
		return n;
	}
	/**
	 * �Ӽ��̶�ȡһ�����Ȳ�����limit���ַ�������������λ�����ķ���ֵ
	 */
	public static String readString(int limit) {
		return readKeyBoard(limit, false);
	}
	/**
	 * �Ӽ��̶�ȡһ�����Ȳ�����limit���ַ�������������Ϊ�����ķ���ֵ
	 * ����û��������ַ���ֱ�ӻس�����������defaultValue��Ϊ����ֵ
	 */
	public static String readString(int limit, String defaultValue) {
		String str = readKeyBoard(limit, true);
		return str.equals("") ? defaultValue : str;
	}
	/**
	 * �û�ȷ��ѡ������롣�÷����Ӽ��̶�ȡy��n����������λ�����ķ���ֵ��
	 */
	public static char readConfirmSelection() {
		char c;
		for(; ;) {
			String str = readKeyBoard(1, false).toUpperCase();
			c = str.charAt(0);
			if(c == 'Y' || c == 'N') {
				break;
			}else {
				System.out.println("ѡ��������������룺");
			}
		}
		return c;
	}
	private static String readKeyBoard(int limit, boolean blankReturn) {
		String line = "";
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if(line.length() == 0) {
				if(blankReturn) return line;
				else continue;
			}
			
			if(line.length() < 1 || line.length() > limit) {
				System.out.println("���볤�ȣ�������" + limit + ")�������������룺");
				continue;
			}
			break;
		}
		return line;
	}
}
