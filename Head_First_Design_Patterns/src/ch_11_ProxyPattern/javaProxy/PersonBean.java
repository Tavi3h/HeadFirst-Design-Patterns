package ch_11_ProxyPattern.javaProxy;

public interface PersonBean {
	
	/*
	 * 在该服务中，权限分类：
	 * 1、顾客可以设置自己的信息，同时防止别人更改
	 * 2、HotOrNot评分则相反，自己不能更改自己的评分，但是他人可以设置你的评分。
	 * 3、getter方法则任何人均可以调用
	 */
	
	String getName();
	String getGender();
	String getInterests();
	int getHotOrNotRating();
	
	void setName(String name); 
	void setGender(String gender);
	void setInterests(String interests);
	void setHotOrNotRating(int rating);
	
}
