package com.bit.dbms8.dbcon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bit.dbms8.config.DbConn;

public class BuyerCon {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;

		String namesFile = "src/com/bit/dbms8/doc/names.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(namesFile);
			buffer = new BufferedReader(fileReader);
			conn=DriverManager.getConnection(DbConn.DB_URL, 
					DbConn.DB_User,DbConn.DB_PASSWD );
			/*
			 * create table buyer( id int not null auto_increment, bucode
			 * varchar(10) not null, buname varchar(15) not null, butel
			 * varchar(15) not null, buaddr varchar(50) default "우리동네", bupoint
			 * int default 0,
			 * 
			 * primary key(id) );
			 */

			Class.forName(DbConn.DB_Driver);
			System.out.println(DbConn.Msg.Msg_Driver_Success);

			String sql = "insert into buyer(bucode,buname,butel)" + "values(?,?,?);";
			String reader = new String();

			while (true) {
				reader = buffer.readLine();
				if (reader == null)
					break;
				String[] names = reader.split(":");
				// 종료-시작 +시작
				int intTel_E = (int) (Math.random() * (9999 - 1000) + 1000);
				int intTel_F = (int) (Math.random() * (9999 - 1000) + 1000);

				String strTel = "010-" + Integer.toString(intTel_F) + "-" + Integer.toString(intTel_E);
				String strCode = Integer.toString(intTel_E);

				pst = conn.prepareStatement(sql);
				pst.setString(1, strCode);
				pst.setString(2, names[0]);
				pst.setString(3, strTel);
				pst.executeUpdate();
			}
			
			buffer.close();
			fileReader.close();
			
			System.out.println(DbConn.Msg.Msg_DbInsert_Sucess);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
