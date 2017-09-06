package cn.xzf.db;

import java.util.List;

import cn.xzf.entityAll.Book;
import cn.xzf.util.ExRowMapper;
import cn.xzf.util.Execute;

public class BookDao 
{
	private Execute ecu=new Execute();
	public List<Book> findAll()
	{
		String sql="select * from book order by id desc";
		return ecu.queeryForlist(sql,new ExRowMapper<Book>(Book.class));
	}
	public void save(Book book) 
	{
		String sql="insert into book (bookname,author,publish,isbn,total,nownum,createtime) values(?,?,?,?,?,?,?)";
		ecu.executeUp(sql,book.getBookname(),book.getAuthor(),book.getPublish(),book.getIsbn(),book.getTotal(),book.getNownum(),book.getCreatetime());
	}
	public Book findByid(int id) 
	{
		String sql="select * from book where id=?";
		return ecu.findQuery(sql,new ExRowMapper<Book>(Book.class),id);
	}
	public void update(Book book) 
	{
		String sql="update book set bookname=?,author=?,publish=?,isbn=?,total=?,nownum=? where id=?";
		ecu.executeUp(sql,book.getBookname(),book.getAuthor(),book.getPublish(),book.getIsbn(),book.getTotal(),book.getNownum(),book.getId());
	}
	public void delete(int id) 
	{
		String sql="delete from book where id=?";
		ecu.executeUp(sql,id);
	}
	public List<Book> findBys(String txt) 
	{
		String sql="select * from book where bookname like ?";
		return ecu.queeryForlist(sql,new ExRowMapper<Book>(Book.class),"%"+txt+"%");
	}
	public void borrow(Book book) 
	{
		String sql="update book set nownum=? where id=?";
		ecu.executeUp(sql,book.getNownum(),book.getId());
	}
}
