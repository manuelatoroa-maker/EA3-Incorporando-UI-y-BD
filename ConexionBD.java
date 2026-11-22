package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public String probarConexion(String url,
                                 String usuario,
                                 String password){

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conexion =
                    DriverManager.getConnection(
                            url,
                            usuario,
                            password)) {

                return "Conexion exitosa a la base de datos";

            }

        } catch (ClassNotFoundException e) {

            return  "ERROR DRIVER:\n"
                    + e.getMessage();

        }catch (SQLException e) {

            return  "ERROR SQL:\n"
                    + e.getMessage();
        }
    }
}