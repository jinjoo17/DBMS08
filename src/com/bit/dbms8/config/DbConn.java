package com.bit.dbms8.config;

public class DbConn {
	
	
	public static String DB_Driver="org.gjt.mm.mysql.Driver";
	public static String DB_URL="jdbc:mysql://localhost/bitdb?useSSL=false";
	public static String DB_User="root";
	public static String DB_PASSWD="!BitCom0228";
	
	//Message
	//sub클래스
	public static class Msg{
		
		public static final String Msg_Driver_Success
		                     ="Mysql Driver Loading Susess!!";
		public static final String Msg_Conn_Success
		                     ="DB Connection Sucess!!";
		
		
		public static final String Msg_DbInsert_Sucess
		                     ="DB 추가완료";
	}

}