package bank;
/**
 * CustomerView 主模块，负责菜单的显示和处理用户操作
 * @author Administrator
 *
 */
public class CustomerView {
	private CustomerList customerList = new CustomerList(10);
	public CustomerView() {
		Customer cust = new Customer("张三", '男', 10, "010-454654", "abc@qq.com");
		customerList.addCustomer(cust);
		
		Customer cust1 = new Customer("张三4645", '男', 10, "010-454654", "abc@qq.com");
		customerList.addCustomer(cust1);
	}
	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}
	/**
	 * 显示主界面的操作
	 */
	public void enterMainMenu() {
		boolean isFlag = true;
		while (isFlag) {
			
			System.out.println("\n--------------------客户信息管理软件--------------------\n");
			System.out.println("                                                1 添加客户");
			System.out.println("                                                2 修改客户");
			System.out.println("                                                3 删除客户");
			System.out.println("                                                4 客户列表");
			System.out.println("                                                5 退      出\n");
			System.out.print("                                                  请选择（1-5）：");
			char menu = CMUtility.readMenuSelection(); // '1' 而非1
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
				System.out.println("确认是否退出（Y/N）：");
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
	 * 添加新客户的操作
	 */
	public void addNewCustomer() {
//		System.out.println("添加");
		System.out.println("---------------------------------添加客户-----------------------------------------------------------");
		System.out.println("姓名：");
		String name = CMUtility.readString(10);
		System.out.println("性别：");
		char gender = CMUtility.readChar();
		System.out.println("年龄：");
		int age = CMUtility.readInt();
		System.out.println("电话：");
		String phone = CMUtility.readString(11);
		System.out.println("邮箱：");
		String email = CMUtility.readString(25);
		
	// 将数据封装道一个Customer 对象中
		Customer cust = new Customer(name, gender, age, phone, email);
		boolean addSuccess = customerList.addCustomer(cust);
		if(addSuccess) {
			System.out.println("添加完成");
		}else {
			System.out.println("数组已满，添加失败");
		}
		
	}
	/**
	 * 修改客户
	 */
	public void modifyCustomer() {
//		System.out.println("修改");
		System.out.println("-----------------修改客户-------------------------------");
		Customer cust;
		int number;
		for(; ;) {
			System.out.println("请选择待修改客户编号(-1退出)：");
			number = CMUtility.readInt();
			if(number == -1) {
				return;
			}
			cust = customerList.getCustomer(number - 1); // 客户编号是从1开始
			if(cust == null) {
				System.out.println("无法找到指定客户！");
			}else {
				break;
			}
		}
		System.out.println("姓名（" + cust.getName() + "):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.println("性别（" + cust.getGender() + "):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.println("年龄（" + cust.getAge() + "):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.println("电话（" + cust.getPhone() + "):");
		String phone = CMUtility.readString(11, cust.getPhone());
		System.out.println("邮箱（" + cust.getEmail() + "):");
		String email = CMUtility.readString(25, cust.getEmail());
		Customer c = new Customer(name, gender, age, phone, email);
		boolean isReplaced = customerList.replaceCustomer(number, c);
		if(isReplaced) {
			System.out.println("------------------修改成功---------------------------");
		}else {
			System.out.println("------------------修改失败---------------------------");
		}
	}
	/**
	 * 删除客户
	 */
	public void deleteCustomer() {
//		System.out.println("删除");
		System.out.println("--------------------删除客户----------------------------");
		int number;
		for(; ;) {
			System.out.println("请选择要删除客户编号(-1退出)：");
			number = CMUtility.readInt();
			if(number == -1) {
				return;
			}
			Customer cust = customerList.getCustomer(number - 1); // 客户编号从1开始
			if(cust == null) {
				System.out.println("无法找到指定客户！");
			}else {
				break;
			}
		}
		System.out.println("是否缺人删除（Y/N）");
		char confirmDelete = CMUtility.readConfirmSelection();
		if(confirmDelete == 'Y') {
			boolean isDelete = customerList.deleteCustomer(number - 1);
			if(isDelete) {
				System.out.println("-------------删除完成------------------");
			}else {
				System.out.println("-------------删除失败------------------");
			}
		}
		
	}
	private void listAllCustomers() {
//		System.out.println("列表");
		System.out.println("---------------------------------------------客户列表----------------------------------------------------------------------------------------------");
		int total = customerList.getTotal();
		if(total == 0) {
			System.out.println("没有客户记录！");
		}else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] custs = customerList.getAllCustomers();
			for (int i = 0; i < custs.length; i++) {
				Customer cust = custs[i];
//				System.out.println((i + 1) + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge() + "\t" + cust.getPhone() + "\t" + cust.getEmail());
				System.out.println((i + 1) + "\t" + cust.info());
			}
		}
		System.out.println("---------------------------------------------客户列表完成----------------------------------------------------------------------------------------");
	}
	
}
