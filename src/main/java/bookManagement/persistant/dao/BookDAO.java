package bookManagement.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import bookManagement.persistant.dto.BookRequestDTO;
import bookManagement.persistant.dto.BookResponseDTO;
@Service
public class BookDAO {
	static Connection con=MyConnection.getConnection();
	
	public int insertData(BookRequestDTO dto) {
		int result=0;
		String stmt="Insert into book(book_code,book_title,book_author,book_price) values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(stmt);
			ps.setString(1, dto.getBookCode());
			ps.setString(2, dto.getBookTitle());
			ps.setString(3, dto.getBookAuthor());
			ps.setDouble(4, dto.getBookPrice());
		
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int updateData(BookRequestDTO dto) {
		int result=0;
		String stmt="Update book set book_title=?,book_author=?,book_price=? where book_code=?";
		try {
			PreparedStatement ps=con.prepareStatement(stmt);
			ps.setString(4, dto.getBookCode());
			ps.setString(1, dto.getBookTitle());
			ps.setString(2, dto.getBookAuthor());
			ps.setDouble(3, dto.getBookPrice());
		
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}
	public int deleteData(String bookCode) {
		int result=0;
		String stmt="Delete from book where book_code=?";
		try {
			PreparedStatement ps=con.prepareStatement(stmt);
			ps.setString(1, bookCode);
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}
	public BookResponseDTO selectData(BookRequestDTO dto) {
		BookResponseDTO response=new BookResponseDTO();
		String stmt="select * from book where book_code=?";
		try {
			PreparedStatement ps=con.prepareStatement(stmt);
			ps.setString(1, dto.getBookCode());
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				response.setBookCode(rs.getString(1));
				response.setBookTitle(rs.getString(2));
				response.setBookAuthor(rs.getString(3));
				response.setBookPrice(rs.getDouble(4));
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return response;
		
	}
	public ArrayList<BookResponseDTO> selectAll() {
		ArrayList<BookResponseDTO> list=new ArrayList<>();
		
		String stmt="select * from book";
		try {
			PreparedStatement ps=con.prepareStatement(stmt);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BookResponseDTO response=new BookResponseDTO();
				response.setBookCode(rs.getString(1));
				response.setBookTitle(rs.getString(2));
				response.setBookAuthor(rs.getString(3));
				response.setBookPrice(rs.getDouble(4));
				list.add(response);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
		
	}
}
