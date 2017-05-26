package com.bit.dbms8.dbcon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bit.dbms8.config.DbConn;

public class NamesCon {

	public static void main(String[] args) {
		
              Connection conn=null;
              PreparedStatement pst=null;
              
              String namesFile="src/com/bit/dbms8/doc/names.txt";
              FileReader fileReader =null;
              BufferedReader buffer=null;
              
              try {
            	  
            	 fileReader=new FileReader(namesFile);
            	 buffer=new BufferedReader(fileReader);
            	 
				Class.forName(DbConn.DB_Driver);
				System.out.println(DbConn.Msg.Msg_Conn_Success);
				
				conn= DriverManager.getConnection(
						DbConn.DB_URL,
						DbConn.DB_User,
						DbConn.DB_PASSWD
						);
				
				String reader=new String();
				//
				String sql="insert into names values(0,?,?,?);";
				pst=conn.prepareStatement(sql);
				int cnt =0;
				while(true){
					reader=buffer.readLine();
					if(reader ==null) break;
					
					System.out.println(++cnt);
					//0:영문이름,1:한글발음,2:의미
					String[] names=reader.split(":");
					pst.setString(1,names[0]);
					pst.setString(2,names[1]);
					pst.setString(3,names[2]);
					
					pst.executeUpdate();
					
				}
				buffer.close();
				fileReader.close();
				System.out.println(DbConn.Msg.Msg_DbInsert_Sucess);
						
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		
		
		
	}

}
