import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class basesForm {
    private JPanel basesForm;
    private JLabel salida;
    public static void main(String[] args) {
        //new conexion();
        try{
            //Se registra el druiver de mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/test", "root","1234");
            String query = "select * from estudiantes";
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(query);
            //Get metadata object
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            //Create JTable and set model
            JTable table = new JTable();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            //Add columns to table model
            for(int i = 1; i<= columnCount; i++){
                model.addColumn(rsmd.getColumnName(i));
            }

            //Add rows to table model
            while(rs.next()){
                Object[] row = new Object[columnCount];
                for(int i = 1; i <= columnCount; i++){
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

            //Display JTable in JFrame
            JFrame frame =new JFrame();
            frame.add(new JScrollPane(table));

            frame.setSize(1000,1000);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Cleanup resources
            rs.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
