package cn.laike.management;

import oracle.jdbc.OracleDriver;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

@SpringBootTest
class ManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void select() {
        Connection conn = getConnection();
        System.out.println("conn:" + conn);
        String sql = "select USERNAME from T_USER";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("USERNAME"));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            //oraclr6:  oracleDriver:oracle.jdbc.OracleDriver@894858
            Class.forName("oracle.jdbc.OracleDriver");
            OracleDriver oracleDriver = new OracleDriver();
            System.out.println("oracleDriver:" + oracleDriver);
            //jdbc:oracle:thin:192.168.0.167:1521:ORCL
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.56.1:1521/orcl", "c##wei", "123456");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

}
