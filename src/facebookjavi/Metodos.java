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

public class Metodos {
    Facebook facebook = new FacebookFactory().getInstance();
                   
    
    public void mostrarUsuario() throws FacebookException{
                                 
                    //OBTENER USUARIO
                    //Nos indica el usuario actual
                    User user = facebook.getMe();
                    JOptionPane.showMessageDialog(null, "Estas conectado como : "+user.getName());
}
                    
    public void publicarEstado() throws FacebookException{
                    //PUBLICAR UN ESTADO
                    //Escribe un nuevo estado de facebook
                    String publi = JOptionPane.showInputDialog("Introduce el estado que quieres publicar"); 
                    facebook.postStatusMessage(publi);
                    JOptionPane.showMessageDialog(null," Post publicado");
    }
    public void postLink() throws MalformedURLException, FacebookException{
                    //PUBLICAR UN LINK
                    //Publica un link e indica la foto que saldra en el post
                    PostUpdate post = new PostUpdate(new URL("http://www.celtavigo.net/es/"))
                    .picture(new URL("http://www.celtavigo.net/images/Plantilla1516/06%20radoja.jpg"))
                    .name("Nemanja Radoja")
                    .caption("celtavigo.net")
                    .description("Nemanja Radoja, mediocentro serbio que juega en el Celta de Vigo, prueba switch 2");
                    facebook.postFeed(post);
                    JOptionPane.showMessageDialog(null," Imagen publicada ");
    }
    public void likePost() throws FacebookException{
                    //DARLE LIKE A UN POST PONIENDO EL ID
                    //A partir del ID de un post, se le da a me gusta automaticamente
                    String postid=JOptionPane.showInputDialog("Introduce el ID del post");
                    //Ejemplo = 132123553865349
                    facebook.likePost(postid);
                    JOptionPane.showMessageDialog(null,"Le has dado Like a la publicación indicada");
    }
    
    public void comentEstado() throws FacebookException{
                    //COMENTAR UN ESTADO
                    //A partir del ID de un post, escribir un comentario para dicho post
                    String postid2=JOptionPane.showInputDialog("Introduce el ID del post");
                    String msg=JOptionPane.showInputDialog("Introduce el comentario");
                    facebook.commentPost(postid2,msg);
                    JOptionPane.showMessageDialog(null,"Has comentado el estado");
    
    }
    public void obtenerComentFoto() throws FacebookException{
                    //OBTENER COMENTARIOS DE UNA FOTO
                    //Poniendo el ID de una foto, nos facilita todos los comentarios de esa foto
                    //EJEMPLO ID = 132154627195575
                    
                    String fotoid = JOptionPane.showInputDialog("Introduce el Id de la foto");
                    ResponseList<Comment> comentarios = facebook.getPhotoComments(fotoid);
                    for (int i = 0; i < comentarios.size(); i++) {
                        System.out.println(comentarios.get(i).getMessage());
                    }
                    JOptionPane.showMessageDialog(null,"Los comentarios de esta foto estan por pantalla");
    
    }
    
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
