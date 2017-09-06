package cn.xzf.db;

import cn.xzf.entityAll.Admin;
import cn.xzf.util.ExRowMapper;
import cn.xzf.util.Execute;

public class AdminDao 
{
	private Execute ecu=new Execute();
	public Admin findAdmin(String username)
	{
		String sql="select * from admin where username=?";
		return ecu.findQuery(sql,new ExRowMapper<Admin>(Admin.class),username);
	}
	public void update(Admin admin) 
	{
		String sql="update admin set username=?,password=?,lastaccessip=? where id=? ";
		ecu.executeUp(sql,admin.getUsername(),admin.getPassword(),admin.getLastaccessip(),admin.getId());
	}
}
