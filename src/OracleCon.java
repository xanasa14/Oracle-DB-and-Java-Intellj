import java.sql.*;
import java.util.Calendar;

class OracleCon{
    public static void main(String args[]){

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "MYONLINEEDU", "oracle"
            );
            Statement stmt  = con.createStatement();

//
            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into SOCCERPLAYERS (ID, Sname, Sposition, Snumber, Sage)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt (1, 888);
            preparedStmt.setString (2, "Rooney");
            preparedStmt.setString(3, "FWD");
         //   preparedStmt.setDate   (3, startDate);
            preparedStmt.setInt(4, 50);
            preparedStmt.setInt    (5, 36);

            // execute the preparedstatement
            preparedStmt.execute();
            //


//

            ResultSet rs = stmt.executeQuery("SELECT * FROM SOCCERPLAYERS");

            while (rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
                + rs.getString(3) + " " + rs.getString(4));
            }
            con.close();




        }
        catch(Exception e ){
            System.out.println(e);
        }

    }

}