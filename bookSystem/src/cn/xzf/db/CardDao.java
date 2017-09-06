package cn.xzf.db;

import java.util.List;

import cn.xzf.entityAll.Card;
import cn.xzf.util.ExRowMapper;
import cn.xzf.util.Execute;

public class CardDao 
{
	Execute ecu=new Execute();
	public List<Card> findAll()
	{
		String sql="select * from card";
		return ecu.queeryForlist(sql,new ExRowMapper<Card>(Card.class));
	}
	public void save(Card card) 
	{
		String sql="insert into card (stuname,cardnum,tel,address,createtime)values(?,?,?,?)";
		ecu.executeUp(sql,card.getStuname(),card.getCardnum(),card.getTel(),card.getAddress(),card.getCreatetime());
	}
	public void update(Card card)
	{
		String sql="update card set stuname=?,cardnum=?,tel=?,address=? where id=?";
		ecu.executeUp(sql,card.getStuname(),card.getCardnum(),card.getTel(),card.getAddress(),card.getId());
	}
	public void delete(int id)
	{
		String sql="delete from card where id=?";
		ecu.executeUp(sql,id);
	}
	public Card findByid(int id)
	{
		String sql="select * from card where id=?";
		return ecu.findQuery(sql,new ExRowMapper<Card>(Card.class),id);
	}
	public Card findByName(String name)
	{
		String sql="select * from card where stuname=?";
		return ecu.findQuery(sql,new ExRowMapper<Card>(Card.class),name);
	}
	public Card findBycardnum(String cardnum)
	{
		String sql="select id from card where cardnum=?";
		return ecu.findQuery(sql, new ExRowMapper<Card>(Card.class), cardnum);
	}
}
