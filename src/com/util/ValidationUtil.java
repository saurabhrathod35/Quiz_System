package com.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationUtil{
	
	public static boolean isEmpty(String param) {
		boolean flag=false;
		if(param=="" || param.trim().length()<=0 || param==null)
		{
			flag=true;
		}
		return flag;	
		
	}
	public static boolean isValidLength(String param,int length)
	{
		boolean flag=false;
		if(param.length()>length)
		{
			flag=true;
		}
		return flag;
	}
	public static boolean isOnlyString(String param)
	{
		boolean flag=false;
		if(!ValidationUtil.isEmpty(param))
		{
			int i;
			for(i=0;i<param.length();i++)
			{
				if(Character.isDigit(param.charAt(i)))
				{
					break;
				}
			}
			if(i==param.length())
			{
				flag=true;
			}
		}
		return flag;
	}
	
	public static String dateConversation(String Date,String currentFormat,String newFormat) {
		
		String convertedDate=null;
		java.util.Date parseDate=null;
		
		try {
			parseDate=new SimpleDateFormat(currentFormat).parse(Date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		convertedDate=new SimpleDateFormat().format(parseDate);
		return convertedDate;
		
	}
	
	public static String getCurruntDate(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=df.format(new Date());
		return currentDate;
	}
	public static boolean isValidEmail(String email){
		boolean flag=false;
		 String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		 if(email.matches(EMAIL_REGEX)){
			 flag=true;
		 }
		return flag;
	}
	public static boolean isValidPhone(String phoneNo){
		boolean flag=false;
		 String phoneNumberPattern ="(\\d-)?(\\d{3})?\\d{3}\\d{4}";
		 if(phoneNo.matches(phoneNumberPattern)){
			 flag=true;
		 }
		return flag;
	}
}
