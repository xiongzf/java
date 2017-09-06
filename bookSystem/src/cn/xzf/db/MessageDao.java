package cn.xzf.db;

import java.util.List;

import cn.xzf.entityAll.Message;
import cn.xzf.util.ExRowMapper;
import cn.xzf.util.Execute;

public class MessageDao 
{
	private Execute ecu=new Execute();
	public List<Message> findByName(String stuname)
	{
		String sql="select * from message where stuname=?";
		return ecu.queeryForlist(sql,new ExRowMapper<Message>(Message.class),stuname);
	}
	public void save(Message message)
	{
		String sql="insert into message (stuname,message,createtime)values(?,?,?)";
		ecu.executeUp(sql,message.getStuname(),message.getMessage(),message.getCreatetime());
	}
	public void delete(int id)
	{
		String sql="delete from message where id=?";
		ecu.executeUp(sql,id);
	}
	public void update(Message message)
	{
		String sql="update message set reply=?,admname=? where id=?";
		ecu.executeUp(sql,message.getReply(),message.getAdmname(),message.getId());
	}
	public Message findByid(Integer id) 
	{
		String sql="select * from message where id=?";
		return ecu.findQuery(sql,new ExRowMapper<Message>(Message.class), id);
	}
	public List<Message> findAll()
	{
		String sql="select * from message";
		return ecu.queeryForlist(sql,new ExRowMapper<Message>(Message.class));
	}
}
