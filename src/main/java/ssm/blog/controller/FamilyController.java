package ssm.blog.controller;

import java.text.SimpleDateFormat;
import java.text.ParseException;  
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.blog.entity.Family;
import ssm.blog.service.FamilyService;
import ssm.blog.util.JUHEUtil;
import ssm.blog.util.LunarCalendar;




/**
 * @Description 
 * @author songml
 *
 */
@Controller
@RequestMapping("/family")
public class FamilyController {
	private static Logger logger = Logger.getLogger(FamilyController.class);

	
	@Resource(name="familyService")
	private FamilyService familyService;
	
	public static final int pagesize = 10;
	
	@Value("#{setting[STR1]}")
	private String STR1; 

	@Value("#{setting[STR2]}")
	private String STR2; 
	
	@Value("#{setting[STR3]}")
	private String STR3; 
	
	@Value("#{setting[STR4]}")
	private String STR4;
	
	String gmail_id = "";
	String gmail_pas = "";
	
	@RequestMapping("/get_all")
	public String get_all(
			String c_name,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][get_all][start]");
		

		List<Family> families = familyService.get_all();
		//LunarCalendar.solarToLunar(1984,10,30);
		request.setAttribute("families", families);
		
		
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][get_all][end]");
		return "../../family/main";
	}
	
	@RequestMapping("/daily_enter_check")
	public String daily_enter_check(
			String c_name,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][daily_enter_check][start]");
		

		List<Family> families = familyService.get_all();
		request.setAttribute("families", families);
		
        for(Family fa:families){
            //logger.info("["+this.getClass()+"][daily_enter_check][fa.getName]"+fa.getName());
			//logger.info("["+this.getClass()+"][daily_enter_check][fa.getBirth]"+fa.getBirth());
			//logger.info("["+this.getClass()+"][daily_enter_check][fa.getAnimals_year]"+fa.getAnimals_year());
			//logger.info("["+this.getClass()+"][daily_enter_check][fa.getLunar_birth]"+fa.getLunar_birth());
			//logger.info("["+this.getClass()+"][daily_enter_check][fa.getLunar_birth2]"+fa.getLunar_birth2());
			//logger.info("["+this.getClass()+"][daily_enter_check][fa.getRemind_date]"+fa.getRemind_date());
			 

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");

			String remind_date = fa.getRemind_date();
			logger.info("["+this.getClass()+"][daily_enter_check][remind_date]"+remind_date);
			//Date date_db = sdf.parse(remind_date); 
			
			String sys_date = sdf.format(new Date());
			//sys_date = "2017-10-1";
			
			//logger.info("["+this.getClass()+"][daily_enter_check][sys_date]"+sys_date);
			if (sys_date.equals(remind_date)) {
				send_family_mail("今日は" + fa.getName() + "の" + fa.getAge() + "歳誕生日");
			}
				
 
			
			
        }

		
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][daily_enter_check][end]");
		return "../../family/main";
	}
	
	@RequestMapping("/update")
	public String update(
			Integer id,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][update][start]");
		logger.info("["+this.getClass()+"][update][id]"+id);
		Family fa = familyService.get_by_id(id);
		String birth = fa.getBirth();
		logger.info("["+this.getClass()+"][update][birth]"+birth);

		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int birth_year = Integer.parseInt(birth.substring(0, 4));
		logger.info("["+this.getClass()+"][update][birth_year]"+birth_year);
		int i_age = year - birth_year;
		String age = String.valueOf(i_age); 
		logger.info("["+this.getClass()+"][update][age]"+age);
		logger.info("["+this.getClass()+"][update][lunar_birth]"+fa.getLunar_birth());
		if (fa.getLunar_birth() == null || fa.getAnimals_year() == null) {
			Family fa2 = JUHEUtil.getRequest1(birth);
			fa.setLunar_birth(fa2.getLunar_birth());
			fa.setAnimals_year(fa2.getAnimals_year());
		}
		
		//lunar_birth2 
		if (fa.getLunar_birth2() == null) {
			int my_year,my_month,my_day;
			my_year = Integer.parseInt(fa.getBirth().split("-")[0]);
			my_month = Integer.parseInt(fa.getBirth().split("-")[1]);
			my_day = Integer.parseInt(fa.getBirth().split("-")[2]);
			logger.info("["+this.getClass()+"][update][my_year]"+my_year);
			logger.info("["+this.getClass()+"][update][my_month]"+my_month);
			logger.info("["+this.getClass()+"][update][my_day]"+my_day);
			int[] out = LunarCalendar.solarToLunar(my_year, my_month, my_day);
			String lunar_birth2 = String.valueOf(out[0] + "-" + out[1] + "-" + out[2]);
			logger.info("["+this.getClass()+"][update][lunar_birth2]"+lunar_birth2);
			fa.setLunar_birth2(lunar_birth2);
		}
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = df.format(date);
		fa.setM_date(today);
		
		fa.setAge(age);
		
		
		
		//remind_date modify
		//old remind_date update
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		
		String remind_date = fa.getRemind_date();
		Date today_date = new Date();
		String sys_date = sdf.format(new Date());
		if (remind_date == null){
			logger.info("["+this.getClass()+"][update][remind_date is null]");
			int my_year2,my_month2,my_day2;
			my_year2 = Integer.parseInt(fa.getLunar_birth2().split("-")[0]);
			my_month2 = Integer.parseInt(fa.getLunar_birth2().split("-")[1]);
			my_day2 = Integer.parseInt(fa.getLunar_birth2().split("-")[2]);
			
			int[] out2 = LunarCalendar.lunarToSolar(Integer.parseInt(sys_date.split("-")[0]), my_month2, my_day2,1==2);
			remind_date = String.valueOf(out2[0] + "-" + out2[1] + "-" + out2[2]);
			logger.info("["+this.getClass()+"][update][remind_date after]"+remind_date);
			fa.setRemind_date(remind_date);
		} else {
			logger.info("["+this.getClass()+"][update][remind_date]"+remind_date);
			Date remind_date_from_db = sdf.parse(remind_date); 
			int my_year3,my_month3,my_day3;
			my_year3 = Integer.parseInt(fa.getLunar_birth2().split("-")[0]);
			my_month3 = Integer.parseInt(fa.getLunar_birth2().split("-")[1]);
			my_day3 = Integer.parseInt(fa.getLunar_birth2().split("-")[2]);
			//sys_date = "2017-10-1";
			String name = fa.getName();
			if (remind_date_from_db.getTime() < today_date.getTime()){
				logger.info("["+this.getClass()+"][update][remind_date update is needed]");
				
			
				if(name.indexOf("阳历") != -1) {
					remind_date = Integer.parseInt(sys_date.split("-")[0]) + 1 + "-" + birth.split("-")[1] + "-" + birth.split("-")[2];
					
				} else {
					int[] out3 = LunarCalendar.lunarToSolar(Integer.parseInt(sys_date.split("-")[0])+1, my_month3, my_day3,1==2);
					remind_date = String.valueOf(out3[0] + "-" + out3[1] + "-" + out3[2]);
				}

			} else {
				if(name.indexOf("阳历") != -1) {
					remind_date = sys_date.split("-")[0] + "-" + birth.split("-")[1] + "-" + birth.split("-")[2];
					
				} 
				
			}
			logger.info("["+this.getClass()+"][update][remind_date after]"+remind_date);
			fa.setRemind_date(remind_date);
			
			logger.info("["+this.getClass()+"][update][name]"+name);

		}
		
		
		
		
		
		

		
		familyService.update(fa);
		
		List<Family> families = familyService.get_all();
		
		request.setAttribute("families", families);
		
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][update][end]");
		return "../../family/main";
	}

	
	private void send_family_mail(String msg)  {
		logger.info("["+this.getClass()+"][send_family_mail][start]");
			try{
				Properties property = new Properties();

				property.put("mail.smtp.host","smtp.gmail.com");

				//GmailのSMTPを使う場合
				property.put("mail.smtp.auth", "true");
				property.put("mail.smtp.starttls.enable", "true");
				property.put("mail.smtp.host", "smtp.gmail.com");
				property.put("mail.smtp.port", "587");
				property.put("mail.smtp.debug", "true");
				
				
		 
				 FileReader fileReader = new FileReader(new File("c:\\tools\\id_pas.txt"));

				 BufferedReader br = new BufferedReader(fileReader);

				 String line = null;
				 // if no more lines the readLine() returns null
				 Integer cnt_i = 0;

				 while ((line = br.readLine()) != null) {
					  //logger.info("["+this.getClass()+"][get_all][line]"+line);
					  cnt_i ++ ;
					  if (cnt_i == 1) {
						  gmail_id = line;
						  
					  } else if  (cnt_i == 2) {
						  gmail_pas = line;
					  }

				 }


				Session session = Session.getInstance(property, new javax.mail.Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication(){

						return new PasswordAuthentication(gmail_id, gmail_pas);
					}
				});

				/*
				//一般的なSMTPを使う場合

				//ポートが25の場合は省略可能
				property.put("mail.smtp.port", 25);

				Session session = 
						Session.getDefaultInstance(property, null);
				*/

				MimeMessage mimeMessage = new MimeMessage(session);

				InternetAddress toAddress = 
						new InternetAddress("bilifans@yahoo.co.jp", "誕生日");

				mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);

				InternetAddress fromAddress = 
						new InternetAddress("bilifansa@gmail.com","家庭通知");

				mimeMessage.setFrom(fromAddress);

				mimeMessage.setSubject("重要", "ISO-2022-JP");

				mimeMessage.setContent(msg, "text/html;charset=UTF-8");

				Transport.send(mimeMessage);

				//out.println("<htm><body>");
				//out.println("■お問い合わせ内容を担当者へ送信しました。");
				//out.println("<body></html>");
			}
			catch(Exception e){
				//out.println("<html><body>");
				//out.println("■担当者への送信に失敗しました");
				//out.println("<br>エラーの内容" + e);
				//out.println("</body></html>");
				logger.info("["+this.getClass()+"][get_all][error]"+e);
			}
		logger.info("["+this.getClass()+"][send_family_mail][end]");
		
	}
	
}
