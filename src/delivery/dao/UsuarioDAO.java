package delivery.dao;

import delivery.modelo.Usuario;
import delivery.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends BaseDAO{
    
    public ArrayList<Usuario>listar() {
        String query = "select * from usuario";
        ArrayList<Usuario> c = new ArrayList<Usuario>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario vo = new Usuario();
                vo.setId(rs.getInt("id"));
                vo.setLogin(rs.getString("login"));
                vo.setClave(rs.getString("clave"));
                vo.setTipo(rs.getString("tipo"));
                vo.setEstado(rs.getString("estado"));
                
                c.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return c;
    }
    
    public Usuario insertar (Usuario vo) 
        {
        String query = "insert into usuario(login,clave, tipo,estado) values(?,?,?,?)";    
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            
            stmt.setString(1, vo.getLogin());
            stmt.setString(2, vo.getClave());
            stmt.setString(3, vo.getTipo());
            stmt.setString(4, vo.getEstado());
            
            int res = stmt.executeUpdate();
            if (res != 1) {
                throw new SQLException("No se pudo INSERTAR");
            }
            
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return vo;
    }
}
