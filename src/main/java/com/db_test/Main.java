package com.db_test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
        This is the testing Main Class. (Document Comment)
        Created by: ...........
        Created date: .........
 */
public class Main {

    /*
    *return method can be used as testing
    * method call pho lout pl main method ko use
    * data connection will have database, ip address and port
    * */
    private String ip = "localhost";
    private String port = "3306";
    private String db_name = "test";
    private String username = "root";
    private String password = "";
    protected Connection get_DB_Connection() {
        /*
        class not found so yin library error
        * */
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db_name ,username, password);
            System.out.println("Successful Connection");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Connection con = m.get_DB_Connection();

        try{
            if(con != null) {
                con.close();
                System.out.println("Connection is closed");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
