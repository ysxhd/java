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
		
		Customer cust1 = new Customer("����4645", '��', 10, "010-454654", "abc@qq.com");
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
//		System.out.println("�޸�");
		System.out.println("-----------------�޸Ŀͻ�-------------------------------");
		Customer cust;
		int number;
		for(; ;) {
			System.out.println("��ѡ����޸Ŀͻ����(-1�˳�)��");
			number = CMUtility.readInt();
			if(number == -1) {
				return;
			}
			cust = customerList.getCustomer(number - 1); // �ͻ�����Ǵ�1��ʼ
			if(cust == null) {
				System.out.println("�޷��ҵ�ָ���ͻ���");
			}else {
				break;
			}
		}
		System.out.println("������" + cust.getName() + "):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.println("�Ա�" + cust.getGender() + "):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.println("���䣨" + cust.getAge() + "):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.println("�绰��" + cust.getPhone() + "):");
		String phone = CMUtility.readString(11, cust.getPhone());
		System.out.println("���䣨" + cust.getEmail() + "):");
		String email = CMUtility.readString(25, cust.getEmail());
		Customer c = new Customer(name, gender, age, phone, email);
		boolean isReplaced = customerList.replaceCustomer(number, c);
		if(isReplaced) {
			System.out.println("------------------�޸ĳɹ�---------------------------");
		}else {
			System.out.println("------------------�޸�ʧ��---------------------------");
		}
	}
	/**
	 * ɾ���ͻ�
	 */
	public void deleteCustomer() {
//		System.out.println("ɾ��");
		System.out.println("--------------------ɾ���ͻ�----------------------------");
		int number;
		for(; ;) {
			System.out.println("��ѡ��Ҫɾ���ͻ����(-1�˳�)��");
			number = CMUtility.readInt();
			if(number == -1) {
				return;
			}
			Customer cust = customerList.getCustomer(number - 1); // �ͻ���Ŵ�1��ʼ
			if(cust == null) {
				System.out.println("�޷��ҵ�ָ���ͻ���");
			}else {
				break;
			}
		}
		System.out.println("�Ƿ�ȱ��ɾ����Y/N��");
		char confirmDelete = CMUtility.readConfirmSelection();
		if(confirmDelete == 'Y') {
			boolean isDelete = customerList.deleteCustomer(number - 1);
			if(isDelete) {
				System.out.println("-------------ɾ�����------------------");
			}else {
				System.out.println("-------------ɾ��ʧ��------------------");
			}
		}
		
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
