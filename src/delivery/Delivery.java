package delivery;

import delivery.dao.UsuarioDAO;
import delivery.modelo.Categoria;
import delivery.modelo.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Delivery {

    public static void main(String[] args) {
        Delivery app = new Delivery();
        //app.insertarUsuario();
        app.listarUsuario();
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
    public void listarUsuario() {
        Usuario user = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista = dao.listar();
        
        Iterator it = lista.iterator();
        while (it.hasNext()) {
            user = (Usuario)it.next();
            System.out.println(user.getLogin() );
        
        }
    }
    
}
