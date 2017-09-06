package cn.xiongzf.models;

/**
 * Created by brks on 2017/9/6.
 */
public class UserModel {
    private int userID; //id
    private String userName; //姓名
    private String phoneNumber; //手机号
    private String address; //地址
    private String idCard; //身份证号
    private String account; //账号
    private String password; //密码
    private String createTime; //创建时间
    private String updateTime; //更新时间
    private int isDelete; //是否被删除
    private int isPower; //是否有权限

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getIsPower() {
        return isPower;
    }

    public void setIsPower(int isPower) {
        this.isPower = isPower;
    }
}
