
package cn.xzf.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cn.xzf.date.GetDate;
import cn.xzf.db.BookDao;
import cn.xzf.db.BorrowDao;
import cn.xzf.db.CardDao;
import cn.xzf.db.MessageDao;
import cn.xzf.db.StudentDao;
import cn.xzf.entityAll.Admin;
import cn.xzf.entityAll.Book;
import cn.xzf.entityAll.Borrow;
import cn.xzf.entityAll.Card;
import cn.xzf.entityAll.Message;
import cn.xzf.entityAll.Student;
import cn.xzf.util.ExRowMapper;
import cn.xzf.util.Execute;

public class ServiceDB 
{
	BookDao bd=new BookDao();
	BorrowDao bdo=new BorrowDao();
	CardDao cd=new CardDao();
	GetDate gd=new GetDate();
	StudentDao sd=new StudentDao();
	MessageDao md=new MessageDao();
	public Book Borrowbook(String id)
	{
		Integer pk=Integer.parseInt(id);
		Book bok=bd.findByid(pk);
		Book book=bok;
		int num=bok.getNownum();
		bok.setNownum((num-1));
		bok.setId(pk);
		bd.borrow(bok);
		return book;
	}
	public void SavaBorrow(String id,String bid)
	{
		GetDate gd=new GetDate();
		
		Borrow borrow=new Borrow();
		borrow.setBid(Integer.valueOf(bid));
		borrow.setCid(Integer.valueOf(id));
		borrow.setCreatetime(gd.getNowDate());
		bdo.save(borrow);
	}
	public void ExportExcel(OutputStream os)
	{
		Workbook wb=new HSSFWorkbook();//创建工作表
		Sheet st=wb.createSheet("书籍统计");
		Row title=st.createRow(0);
		
		Cell c1=title.createCell(0);
		Cell c2=title.createCell(1);
		Cell c3=title.createCell(2);
		Cell c4=title.createCell(3);
		Cell c5=title.createCell(4);
		Cell c6=title.createCell(5);
		
		c1.setCellValue("书籍名称");
		c2.setCellValue("作者");
		c3.setCellValue("出版社");
		c4.setCellValue("ISBN");
		c5.setCellValue("总数量");
		c6.setCellValue("剩余数量");
		
		List<Book>list=bd.findAll();
		
		for(int i=0;i<list.size();i++)
		{
			Book book=list.get(i);
			
			Row row=st.createRow(i+1);
			
			Cell c11=row.createCell(0);
			Cell c21=row.createCell(1);
			Cell c31=row.createCell(2);
			Cell c41=row.createCell(3);
			Cell c51=row.createCell(4);
			Cell c61=row.createCell(5);
			
			c11.setCellValue(book.getBookname());
			c21.setCellValue(book.getAuthor());
			c31.setCellValue(book.getPublish());
			c41.setCellValue(book.getIsbn());
			c51.setCellValue(book.getTotal());
			c61.setCellValue(book.getNownum());
		}
		try {
			wb.write(os);
			os.flush();
			os.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void ImportExcel(InputStream is)
	{
		try 
		{
			Workbook wb = new HSSFWorkbook(is);
			Sheet sheet=wb.getSheetAt(0);
			for(int i=1;i<=sheet.getLastRowNum();i++)
			{
				Row row=sheet.getRow(i);
				if(row==null)
				{
					break;
				}
				Book book=new Book();
				for(int j=0;j<row.getLastCellNum();i++)
				{
					Cell cell=row.getCell(j);
					if(j==0)
					{
						book.setBookname(cell.getStringCellValue());
					}else if(j==1)
					{
						book.setAuthor(cell.getStringCellValue());
					}else if(j==2)
					{
						book.setPublish(cell.getStringCellValue());
					}else if(j==3)
					{
						book.setIsbn(cell.getStringCellValue());
					}else if(j==4)
					{
						Double d=cell.getNumericCellValue();
						book.setTotal(d.intValue());
						book.setNownum(d.intValue());
					}
				}
				bd.save(book);
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		} 
	}
	public void CardDelete(String id)
	{
		Integer pk=Integer.parseInt(id);
		cd.delete(pk);
	}
	public void CardNew(String stuname,String cardnum,String tel,String address)
	{
		Card card=new Card();
		Student student=new Student();
		student.setUsername(stuname);
		student.setPassword(DigestUtils.shaHex("0000"));
		sd.save(student);
		
		card.setAddress(address);
		card.setCreatetime(gd.getNowDate());
		card.setStuname(stuname);
		card.setCardnum(cardnum);
		card.setTel(tel);
		
		cd.save(card);
	}
	public Card CardUpdate(String id)
	{
		Integer pk=Integer.parseInt(id);
		Card card=cd.findByid(pk);
		return card;
	}
	public void CardUpdateP(String stuname,String cardnum,String tel,String address,String id)
	{
		Card card=new Card();
		
		card.setAddress(address);
		card.setStuname(stuname);
		card.setTel(tel);
		card.setCardnum(cardnum);
		card.setId(Integer.valueOf(id));
		
		cd.update(card);
	}
	public void Del(String id)
	{
		Integer pk=Integer.parseInt(id);
		bd.delete(pk);
	}
	public List<Book> FindAllBook()
	{
		List<Book> list=bd.findAll();
		return list;
	}
	public void MessageDel(String id)
	{
		Integer pk=Integer.parseInt(id);
		md.delete(pk);
	}
	public List<Message> FindAllMessage()
	{
		List<Message> list=md.findAll();
		return list;
	}
	public void NewBook(String bookname,String author,String publish,String isbn,String total)
	{
		Book book=new Book();
		book.setBookname(bookname);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setIsbn(isbn);
		book.setTotal(Integer.valueOf(total));
		book.setNownum(Integer.valueOf(total));
		book.setCreatetime(gd.getNowDate());
		
		bd.save(book);
	}
	public Message ReplayG(String id)
	{
		Integer pk=Integer.parseInt(id);
		MessageDao md=new MessageDao();
		Message message=md.findByid(pk) ;
		return message;
	}
	public void ReplayP(Admin admin,String id,String reply )
	{
		Integer pk=Integer.parseInt(id);
		Message message=new Message();
		message.setReply(reply);
		message.setAdmname(admin.getUsername());
		message.setId(pk);
		md.update(message);
	}
	public void ReturnBook(String id)
	{
		Integer pk=Integer.parseInt(id);
		Book book=bd.findByid(pk);
		int num=book.getNownum();
		book.setNownum((num+1));
		book.setId(pk);
		bd.borrow(book);
		bdo.delete(pk);
	}
	public List<Book> Return(String cardnum)
	{
		Execute ecu=new Execute();
		String sql="select * from book where id in(select bid from borrow where cid=(select id from card where cardnum=?))";
		List<Book> list=ecu.queeryForlist(sql,new ExRowMapper<Book>(Book.class),cardnum);
		return list;
	}
	public Book UpdateG(String id)
	{
		Integer pk=Integer.parseInt(id);
		Book book=bd.findByid(pk);
		return book;
	}
	public void UpdateP(String bookname,String author,String publish,String isbn,String total,String nownum,String id)
	{
		Book book=new Book();
		
		book.setBookname(bookname);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setIsbn(isbn);
		book.setTotal(Integer.valueOf(total));
		book.setNownum(Integer.valueOf(nownum));
		book.setId(Integer.valueOf(id));
		
		bd.update(book);
	}
}
