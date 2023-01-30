import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
public class conexion extends basesForm{

    public conexion(){

        /*try{
            //Se registra el druiver de mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/test", "root","1234");
            //
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from estudiantes");
            while(rs.next()){
                //salida.setText("Danny");
                System.out.println(rs.getString("idESTUDIANTES") + " " +
                        rs.getString("NOMESTUDI") + " " +
                        rs.getString("APELESTUDI") + " " +
                        rs.getString("CORREO"));
            }
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }
}
