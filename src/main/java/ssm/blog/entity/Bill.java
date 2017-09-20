package ssm.blog.entity;

/**
 * 
 */
public class Bill {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCustomer_name(String customer_name){
		this.customer_name=customer_name;
	}
	public String getCustomer_name(){
		return customer_name;
	}
	public void setCustomer_contact(String customer_contact){
		this.customer_contact=customer_contact;
	}
	public String getCustomer_contact(){
		return customer_contact;
	}
	public void setCustomer_tel(String customer_tel){
		this.customer_tel=customer_tel;
	}
	public String getCustomer_tel(){
		return customer_tel;
	}
	public void setBill_name(String bill_name){
		this.bill_name=bill_name;
	}
	public String getBill_name(){
		return bill_name;
	}
	public void setBill_num(String bill_num){
		this.bill_num=bill_num;
	}
	public String getBill_num(){
		return bill_num;
	}
	public void setBill_unit_price(String bill_unit_price){
		this.bill_unit_price=bill_unit_price;
	}
	public String getBill_unit_price(){
		return bill_unit_price;
	}
	public void setBill_all_price(String bill_all_price){
		this.bill_all_price=bill_all_price;
	}
	public String getBill_all_price(){
		return bill_all_price;
	}
	public void setBill_require(String bill_require){
		this.bill_require=bill_require;
	}
	public String getBill_require(){
		return bill_require;
	}
	public void setBill_status(String bill_status){
		this.bill_status=bill_status;
	}
	public String getBill_status(){
		return bill_status;
	}
	public void setBill_percent(String bill_percent){
		this.bill_percent=bill_percent;
	}
	public String getBill_percent(){
		return bill_percent;
	}
	private Integer id;//序号
	private String customer_name;
	private String customer_contact;
	private String customer_tel;
	private String bill_name;
	private String bill_num;
	private String bill_unit_price;
	private String bill_all_price;
	private String bill_require;
	private String bill_status;
	private String bill_percent;

}