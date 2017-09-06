package cn.xzf.db;

import java.util.List;

import cn.xzf.entityAll.Borrow;
import cn.xzf.util.ExRowMapper;
import cn.xzf.util.Execute;

public class BorrowDao 
{
	private Execute ecu=new Execute();
	public void save(Borrow borrow)
	{
		String sql="insert into borrow(bid,cid,createtime)values(?,?,?)";
		ecu.executeUp(sql,borrow.getBid(),borrow.getCid(),borrow.getCreatetime());
	}
	public List<Borrow> findAll(int cid)
	{
		String sql="select * from borrow where cid=?";
		return ecu.queeryForlist(sql,new ExRowMapper<Borrow>(Borrow.class),cid);
	}
	public void delete(Integer pk) 
	{
		String sql="delete from borrow where bid=?";
		ecu.executeUp(sql,pk);
	}
}
