package facebookjavi;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

public class FacebookJavi {

    public static void main(String[] args) throws FacebookException, MalformedURLException {
     
       ConfigurationBuilder cb = new ConfigurationBuilder();

FacebookFactory ff = new FacebookFactory(cb.build());
Facebook facebook = ff.getInstance(); 
       

/*
int opcion=0;

opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una accion:\n1. Publicar un estado.\n2. Publicar una foto\n3. Dar Like a publicaciones \n4. Comentar una publicación \n5. Obtener los comentarios de un post \n6. Buscar un tema" ));

switch (opcion) {
                case 1:
                    //PUBLICAR UN ESTADO   (FUNCIONA)
                    String publi = JOptionPane.showInputDialog("Introduce el estado que quieres publicar"); 
                    facebook.postStatusMessage(publi);
                    JOptionPane.showMessageDialog(null," Post publicado");
                    break;
                case 2:
                    //PUBLICAR UN LINK (FUNCIONA)
    
                    PostUpdate post = new PostUpdate(new URL("http://www.celtavigo.net/es/"))
                    .picture(new URL("http://www.celtavigo.net/images/Plantilla1516/06%20radoja.jpg"))
                    .name("Nemanja Radoja")
                    .caption("celtavigo.net")
                    .description("Nemanja Radoja, mediocentro serbio que juega en el Celta de Vigo, prueba switch 2");
                    facebook.postFeed(post);
                    JOptionPane.showMessageDialog(null," Imagen publicada ");
                    break;
                case 3:
                    //DARLE LIKE A UN POST PONIENDO EL ID (FUNCIONA)
                    String postid=JOptionPane.showInputDialog("Introduce el ID del post");
                    //Ejemplo = 132123553865349
                    facebook.likePost(postid);
                    JOptionPane.showMessageDialog(null,"Le has dado Like a la publicación indicada");
                    break;
                case 4:
                    //COMENTAR UN ESTADO  (FUNCIONA)
                    String postid2=JOptionPane.showInputDialog("Introduce el ID del post");
                    String msg=JOptionPane.showInputDialog("Introduce el comentario");
                    facebook.commentPost(postid2,msg);
                    JOptionPane.showMessageDialog(null,"Has comentado el estado");
                    break;
                /*case 5:
                    //COMENTAR UN ESTADO  (FUNCIONA)
                    String postid2=JOptionPane.showInputDialog("Introduce el ID del post");
                    String msg=JOptionPane.showInputDialog("Introduce el comentario");
                    facebook.commentPost(postid2,msg);
                    JOptionPane.showMessageDialog(null,"Has comentado el estado");
                    break;
            }
    
    */
    

        Metodos metodos = new Metodos();
        metodos.getPostComments();
    
    
    
    
    
    
    
    
    
    
  
    }
    
}
