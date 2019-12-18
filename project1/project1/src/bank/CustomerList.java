package bank;
/**
 * CustomerList为Customer对象的管理模块，内部使用数组管理一组Customer对象
 * @author Administrator
 *
 */
public class CustomerList {
	private Customer[] customers; // 用来保存客户对象的数组
	private int total; // 记录已保存客户对象的数量
	/**
	 * CustomerList的构造器
	 * @param totalCustomer 指明创建的Customer数组的长度
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	/**
	 * 讲指定的customer 添加到Customers数组中
	 * @param customer
	 * @return 是否添加成功true 添加成功，false添加失败
	 */
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}
	/**
	 * 替换指定位置上的客户
	 * @param index  
	 * @param customer
	 * @return  替换是否成功
	 */
	public boolean replaceCustomer(int index, Customer customer) {
		if(index < 0 || index >= total) {
			return false;
		}
		customers[index] = customer;
		return true;
	}
	/**
	 * 删除指定位置上的元素
	 * @param index
	 * @return
	 */
	public boolean deleteCustomer(int index) {
		if(index < 0 || index >= total) {
			return false;
		}
		for(int i = index; i < total - 1; i ++) {
			customers[i] = customers[i + 1];
		}
		customers[--total] = null;
		return true;
	}
	/**
	 * 返回所有构成的数组
	 * @return
	 */
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for (int i = 0; i < custs.length; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	/**
	 * 返回制定索引位置上的客户
	 * @param index
	 * @return
	 */
	public Customer getCustomer(int index) {
		if(index < 0 || index >= total) {
			return null;
		}
		return customers[index];
	}
	/**
	 * 返回存储的客户数量
	 * @return
	 */
	public int getTotal() {
		return total;
	}
}
