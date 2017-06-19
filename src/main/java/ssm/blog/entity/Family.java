package ssm.blog.entity;

/**
 * 
 */
public class Family {

	private Integer id;//
	private String name;//
	private String birth;//
	private String remind_date;//
	private String lunar_birth;//
	private String age;//

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getRemind_date() {
		return remind_date;
	}
	public void setRemind_date(String remind_date) {
		this.remind_date = remind_date;
	}
	public String getLunar_birth() {
		return lunar_birth;
	}
	public void setLunar_birth(String lunar_birth) {
		this.lunar_birth = lunar_birth;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}