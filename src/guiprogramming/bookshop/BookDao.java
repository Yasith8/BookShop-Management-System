package guiprogramming.bookshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {
	
	private BookDatabase database;
	
	
	
	public BookDao() {
		database = new BookDatabase();
		
	}
	
	
	public void insertBook(BookEntity book) {
		
		final String INSERT_BOOK_SQL = "insert into tablebook"+
		"(authorname,bookname,editionyear,price) values"+"(?,?,?,?);";
		
		Connection con = database.getDatabaseConnection();
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(INSERT_BOOK_SQL);
			ps.setString(1, book.getAuthorName());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getEditionYear());
			ps.setString(4, book.getBookPrice());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
public ResultSet loadTableData() {
		
		final String ALL_BOOKDETAILS_SQL = "select * from tablebook";
		
		Connection con = database.getDatabaseConnection();
		
		PreparedStatement ps;
		ResultSet rs=null ;
		
		try {
			ps = con.prepareStatement(ALL_BOOKDETAILS_SQL);
			rs= ps.executeQuery();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
		
	
	}
	
	
	
}
