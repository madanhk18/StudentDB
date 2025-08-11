import java.sql.DriverManager;
import java.sql.Connection;

public class DataBaseConnection {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/studentDB";
        String userName="root";
        String password="M@dan890";

        try{
            Connection con=DriverManager.getConnection(url,userName,password);
            System.out.println("Connection is Successful . You are now connected to MySQL");
            con.close();
        }catch (Exception e){
            System.out.println("Connection isn't made , ERROR");
            System.out.println(e);
        }
    }
}
