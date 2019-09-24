package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import jdk.nashorn.internal.ir.WhileNode;
public class TitlesDao {
	public List<String> selectTitlesListDistinct(){
		Connection conn =null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		String sql ="SELECT DISTINCT title FROM titles";
		try {
			conn =DBHelper.getConnection();
			stmt =conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				list.add(rs.getString("title"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBHelper.close(rs, stmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int selectTitlesRowCount() {
		// 1.변수설정 
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM titles"; // 쿼리가 변하면 안됨 final 로 고정
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) { // 이터레이터 구현 되어있는 객채 타입 다음 다음 방식으로 찾을수 있음
				count = rs.getInt("COUNT(*)");
			}
		}catch(Exception e) {	// 자바의 변수 생명주기는 {} 안에서만 {} 앞에 만들어진 ()안의 내용또한 포함 
			
		}finally{
			try {
				DBHelper.close(rs, stmt, conn);
			}catch (Exception e) {	// 따라서 위의 catch 와 {} 가 다름으로 아무 이상없음
				e.printStackTrace();
			}
		}
		return count;
	}
}
