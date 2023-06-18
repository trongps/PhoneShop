
package phone_shop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trong Phan Sy
 */
public class DBContext {
    private Connection conn = null;

    public DBContext() {
        try{
            String usr = "sa";
//            String pass="swp12345";
            String pass="12345";
          String url = "jdbc:sqlserver://localhost:1433;databaseName=PhoneShop";
//          "localhost" replace by "ec2-52-91-104-16.compute-1.amazonaws.com"
//            String url = "jdbc:sqlserver://ec2-52-91-104-16.compute-1.amazonaws.com:1433;databaseName=PhoneShop";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url,usr,pass);
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public void close() throws SQLException{
        if(conn != null){
            conn.close();
        }
    }
}
