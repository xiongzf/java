package cn.xiongzf.models;

/**
 * Created by brks on 2017/9/6.
 */
public class AdminModel {
    private int adminID; //id
    private String name; //姓名
    private String phoneNumber; //电话号码
    private String IdCard; //身份证号
    private String account; //账号
    private String password; //密码
    private int operationUser; //是否有权限操作用户
    private int operationBook; //是否有权限操作书记

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(int operationUser) {
        this.operationUser = operationUser;
    }

    public int getOperationBook() {
        return operationBook;
    }

    public void setOperationBook(int operationBook) {
        this.operationBook = operationBook;
    }
}
