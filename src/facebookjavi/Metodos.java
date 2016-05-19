package facebookjavi;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.User;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
 /**
                         * 
                         * Esta clase contiene todos los métodos usados en el switch de la clase principal, para solo necesitar llamarlo
                         * 
                         **/ 
public class Metodos {
    Facebook facebook = new FacebookFactory().getInstance();
                   
                        /**
                         * 
                         * 
                         * Este método nos indica el usuario conectado, en base a los tokens.
                         **/   
    public void mostrarUsuario() throws FacebookException{
                              
                    User user = facebook.getMe();
                    JOptionPane.showMessageDialog(null, "Estas conectado como : "+user.getName());
}
                    /**
                         * 
                         * Este método cambia el estado de facebook, es decir, dejar un mensaje en nuestro muro
                         * 
                         **/  
    public void publicarEstado() throws FacebookException{
                    
                    String publi = JOptionPane.showInputDialog("Introduce el estado que quieres publicar"); 
                    facebook.postStatusMessage(publi);
                    JOptionPane.showMessageDialog(null," Post publicado");
    }
    
                          /**
                         * 
                         * Este método permite postear un link, y nos deja elegir la foto que saldrá en el post, ademas de una descripción
                         * 
                         **/ 
    public void postLink() throws MalformedURLException, FacebookException{
                    
                    PostUpdate post = new PostUpdate(new URL("http://www.celtavigo.net/es/"))
                    .picture(new URL("http://www.celtavigo.net/images/Plantilla1516/06%20radoja.jpg"))
                    .name("Nemanja Radoja")
                    .caption("celtavigo.net")
                    .description("Nemanja Radoja, mediocentro serbio que juega en el Celta de Vigo, prueba switch 2");
                    facebook.postFeed(post);
                    JOptionPane.showMessageDialog(null," Imagen publicada ");
    }
    
     /**
                         * 
                         * Este método marca como me gusta un post, indicandole el ID
                         * 
                         **/ 
    public void likePost() throws FacebookException{
                    
                    String postid=JOptionPane.showInputDialog("Introduce el ID del post");
                    //Ejemplo = 132123553865349
                    facebook.likePost(postid);
                    JOptionPane.showMessageDialog(null,"Le has dado Like a la publicación indicada");
    }
     /**
                         * 
                         * Este método permite escribir un comentario en un post, indicandole el ID de dicho post
                         * 
                         **/ 
    public void comentEstado() throws FacebookException{
                    
                    String postid2=JOptionPane.showInputDialog("Introduce el ID del post");
                    String msg=JOptionPane.showInputDialog("Introduce el comentario");
                    facebook.commentPost(postid2,msg);
                    JOptionPane.showMessageDialog(null,"Has comentado el estado");
    
    }
     /**
                         * 
                         * Este método nos muestra por pantalla todos los comentarios de una foto a partir del ID de la foto
                         * 
                         **/ 
    public void obtenerComentFoto() throws FacebookException{
                    
                    //EJEMPLO ID = 132154627195575
                    
                    String fotoid = JOptionPane.showInputDialog("Introduce el Id de la foto");
                    ResponseList<Comment> comentarios = facebook.getPhotoComments(fotoid);
                    for (int i = 0; i < comentarios.size(); i++) {
                        System.out.println(comentarios.get(i).getMessage());
                    }
                    JOptionPane.showMessageDialog(null,"Los comentarios de esta foto estan por pantalla");
    
    }
     /**
                         * 
                         * Este método nos indica ciertos datos, dependiendo de lo indicado en la configuración, del usuario que indiquemos el nombre
                         * 
                         **/ 
    public void buscarUsuario() throws FacebookException{
                     //BUSCAR USUARIOS
                    //Indicando un nombre, nos da el usuario y algunos de sus datos; recomendado ser lo mas concreto posible
                    String ac ="";
                    String usuar = JOptionPane.showInputDialog("Introduce nombre a buscar");
                    ResponseList<User> results = facebook.searchUsers(usuar);
                    for (int i = 0; i < results.size(); i++) {
                        ac=ac + (results.get(i).getName());
    
                    }
                    
    }
    
    
}
