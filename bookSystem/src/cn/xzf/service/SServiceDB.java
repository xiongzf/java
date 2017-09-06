package cn.xzf.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import cn.xzf.date.GetDate;
import cn.xzf.db.BookDao;
import cn.xzf.db.BorrowDao;
import cn.xzf.db.CardDao;
import cn.xzf.db.MessageDao;
import cn.xzf.db.StudentDao;
import cn.xzf.entityAll.Book;
import cn.xzf.entityAll.Borrow;
import cn.xzf.entityAll.Card;
import cn.xzf.entityAll.Message;
import cn.xzf.entityAll.Student;

public class SServiceDB 
{
	BookDao bd=new BookDao();
	CardDao cd=new CardDao();
	GetDate gd=new GetDate();
	MessageDao md=new MessageDao();
	public List<Book> FindByTxt(String txt)
	{
		List<Book> list=bd.findBys(txt);
		return list;
	}
	public void Sborrow(Student student,String id)
	{
		Card card=cd.findByName(student.getUsername());
		Integer pk=Integer.parseInt(id);
		BookDao bd=new BookDao();
		Book book=bd.findByid(pk);
		int num=book.getNownum();
		book.setNownum((num-1));
		book.setId(pk);
		bd.borrow(book);
		BorrowDao bod=new BorrowDao();
		Borrow borrow=new Borrow();
		borrow.setBid(pk);
		borrow.setCid(card.getId());
		borrow.setCreatetime(gd.getNowDate());
		bod.save(borrow);
	}
	public List<Borrow> SHBorrow(Student student)
	{
		Card card=cd.findByName(student.getUsername());
		BorrowDao bd=new BorrowDao();
		List<Borrow> list=bd.findAll(card.getId());
		return list;
	}
	public List<Message> SMessage(Student student)
	{
		MessageDao md=new MessageDao();
		List<Message> list=md.findByName(student.getUsername());
		return list;
	}
	public void StudentNew(Student student,String message)
	{
		Message msg=new Message();
		msg.setMessage(message);
		msg.setStuname(student.getUsername());
		msg.setCreatetime(gd.getNowDate());
		
		md.save(msg);
	}
	public void SUpdate(String password,Student student)
	{
		Integer id=student.getId();
		student.setPassword(DigestUtils.shaHex(password));
		student.setId(id);
		StudentDao sd=new StudentDao();
		sd.Pupdate(student);
	}
}
