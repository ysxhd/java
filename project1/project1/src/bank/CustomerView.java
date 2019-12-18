package bank;
/**
 * CustomerView ��ģ�飬����˵�����ʾ�ʹ����û�����
 * @author Administrator
 *
 */
public class CustomerView {
	private CustomerList customerList = new CustomerList(10);
	public CustomerView() {
		Customer cust = new Customer("����", '��', 10, "010-454654", "abc@qq.com");
		customerList.addCustomer(cust);
		
		Customer cust1 = new Customer("����", '��', 10, "010-454654", "abc@qq.com");
		customerList.addCustomer(cust1);
	}
	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}
	/**
	 * ��ʾ������Ĳ���
	 */
	public void enterMainMenu() {
		boolean isFlag = true;
		while (isFlag) {
			
			System.out.println("\n--------------------�ͻ���Ϣ�������--------------------\n");
			System.out.println("                                                1 ��ӿͻ�");
			System.out.println("                                                2 �޸Ŀͻ�");
			System.out.println("                                                3 ɾ���ͻ�");
			System.out.println("                                                4 �ͻ��б�");
			System.out.println("                                                5 ��      ��\n");
			System.out.print("                                                  ��ѡ��1-5����");
			char menu = CMUtility.readMenuSelection(); // '1' ����1
			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.println("ȷ���Ƿ��˳���Y/N����");
				char isExit = CMUtility.readConfirmSelection();
				if(isExit == 'Y') {
					isFlag = false;
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu);
			}
		}
	}
	/**
	 * ����¿ͻ��Ĳ���
	 */
	public void addNewCustomer() {
//		System.out.println("���");
		System.out.println("---------------------------------��ӿͻ�-----------------------------------------------------------");
		System.out.println("������");
		String name = CMUtility.readString(10);
		System.out.println("�Ա�");
		char gender = CMUtility.readChar();
		System.out.println("���䣺");
		int age = CMUtility.readInt();
		System.out.println("�绰��");
		String phone = CMUtility.readString(11);
		System.out.println("���䣺");
		String email = CMUtility.readString(25);
		
	// �����ݷ�װ��һ��Customer ������
		Customer cust = new Customer(name, gender, age, phone, email);
		boolean addSuccess = customerList.addCustomer(cust);
		if(addSuccess) {
			System.out.println("������");
		}else {
			System.out.println("�������������ʧ��");
		}
		
	}
	/**
	 * �޸Ŀͻ�
	 */
	public void modifyCustomer() {
		System.out.println("�޸�");
	}
	/**
	 * ɾ���ͻ�
	 */
	public void deleteCustomer() {
		System.out.println("ɾ��");
	}
	private void listAllCustomers() {
//		System.out.println("�б�");
		System.out.println("---------------------------------------------�ͻ��б�----------------------------------------------------------------------------------------------");
		int total = customerList.getTotal();
		if(total == 0) {
			System.out.println("û�пͻ���¼��");
		}else {
			System.out.println("���\t����\t�Ա�\t����\t�绰\t\t����");
			Customer[] custs = customerList.getAllCustomers();
			for (int i = 0; i < custs.length; i++) {
				Customer cust = custs[i];
//				System.out.println((i + 1) + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge() + "\t" + cust.getPhone() + "\t" + cust.getEmail());
				System.out.println((i + 1) + "\t" + cust.info());
			}
		}
		System.out.println("---------------------------------------------�ͻ��б����----------------------------------------------------------------------------------------");
	}
	
}
