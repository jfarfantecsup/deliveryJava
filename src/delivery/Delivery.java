package delivery;

import delivery.dao.UsuarioDAO;
import delivery.modelo.Categoria;
import delivery.modelo.Usuario;

public class Delivery {

    public static void main(String[] args) {
        Delivery app = new Delivery();
        app.insertarUsuario();
    }
    
    public void insertarUsuario() {
        Usuario user = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        user.setLogin("user01");
        user.setClave("123");
        user.setTipo("A");
        user.setEstado("A");
        
        dao.insertar(user);
        
    } 
    
}
