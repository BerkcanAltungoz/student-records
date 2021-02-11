//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class studentoperations {
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    String username;
    String password;
    public boolean login(String username, String password){
        String sorgu = "Select * From  student where surname = ? and studentID = ?";
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            //aşağıdakilerin yerine return rs.next(); yazabilirsin hangisi oluyorsa dene
            if(rs.next()==false){
                return false;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(studentoperations.class.getName()).log(Level.SEVERE, null, ex);
       return false;
        }
        
    }
    
    public studentoperations(){
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        
        
        try {
            con = (Connection) DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Bağlantı Başarılı...");
            
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }
        
        
    }
    
    public static void main(String[] args) {
        studentoperations operations=new studentoperations();
    }

   
    }
    

