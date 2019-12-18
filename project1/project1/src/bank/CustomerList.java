package bank;
/**
 * CustomerListΪCustomer����Ĺ���ģ�飬�ڲ�ʹ���������һ��Customer����
 * @author Administrator
 *
 */
public class CustomerList {
	private Customer[] customers; // ��������ͻ����������
	private int total; // ��¼�ѱ���ͻ����������
	/**
	 * CustomerList�Ĺ�����
	 * @param totalCustomer ָ��������Customer����ĳ���
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	/**
	 * ��ָ����customer ��ӵ�Customers������
	 * @param customer
	 * @return �Ƿ���ӳɹ�true ��ӳɹ���false���ʧ��
	 */
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}
	/**
	 * �滻ָ��λ���ϵĿͻ�
	 * @param index  
	 * @param customer
	 * @return  �滻�Ƿ�ɹ�
	 */
	public boolean replaceCustomer(int index, Customer customer) {
		if(index < 0 || index >= total) {
			return false;
		}
		customers[index] = customer;
		return true;
	}
	/**
	 * ɾ��ָ��λ���ϵ�Ԫ��
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
	 * �������й��ɵ�����
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
	 * �����ƶ�����λ���ϵĿͻ�
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
	 * ���ش洢�Ŀͻ�����
	 * @return
	 */
	public int getTotal() {
		return total;
	}
}
