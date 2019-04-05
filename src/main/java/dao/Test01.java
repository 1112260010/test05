package dao;

import java.sql.*;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String userName = "root";
        String pwd = "1234";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,userName,pwd);
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        String sql = "select count(1) as cou from userinfo where username = '"+name+"' and userpwd = '"+password+"'";
        System.out.println(sql);
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(sql);

        if(rs.next()){
            Integer count = rs.getInt("cou");
            if(count > 0){
                System.out.println("登陆成功");
            }else{
                System.out.println("登陆失败");
            }
        }
        rs.close();
        sta.close();
        con.close();
    }
}
