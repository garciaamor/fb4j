package facebookjavi;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

public class FacebookJavi {

    public static void main(String[] args) throws FacebookException, MalformedURLException {
     
       ConfigurationBuilder cb = new ConfigurationBuilder();
       cb.setDebugEnabled(true);
        
       
FacebookFactory ff = new FacebookFactory(cb.build());
Facebook facebook = ff.getInstance(); 
      

/*String shortLivedToken = "EAACEdEose0cBAE4ZBWHbdLvWi84rTd9ikKg32ZAVe8qgf51I4B0xjNamvOCKZB5FaiURGHpUVX6VIkVrG8ZAjgYUL9MZBLlXGpQDB6TmKueXYafeKTBopmNqQO1IgkndvEfEAZBGKt5njxKVm9ZBUiDuWyb1VM0dlEo8ZAW1uf0ygCxjyrBYeVI2";
AccessToken extendedToken = facebook.extendTokenExpiration(shortLivedToken); */


int opcion=0;
do{
opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una accion:\n1. Ver usuario conectado \n2. Publicar un estado.\n3. Publicar una foto\n4. Dar Like a publicaciones \n5. Comentar una publicación \n6. Obtener los comentarios de un post \n7. Buscar una persona \n8. Salir del programa" ));

switch (opcion) {
                case 1:
                    //OBTENER USUARIO
                    /**
                     * Indica el nombre del usuario actual
                     */
                    User user = facebook.getMe();
                    JOptionPane.showMessageDialog(null, "Estas conectado como : "+user.getName());
                    break;
                case 2:
                    //PUBLICAR UN ESTADO
                    //Escribe un nuevo estado de facebook
                    String publi = JOptionPane.showInputDialog("Introduce el estado que quieres publicar"); 
                    facebook.postStatusMessage(publi);
                    JOptionPane.showMessageDialog(null," Post publicado");
                    break;
                case 3:
                    //PUBLICAR UN LINK
                    //Publica un link e indica la foto que saldra en el post
                    PostUpdate post = new PostUpdate(new URL("http://www.celtavigo.net/es/"))
                    .picture(new URL("http://www.celtavigo.net/images/Plantilla1516/06%20radoja.jpg"))
                    .name("Nemanja Radoja")
                    .caption("celtavigo.net")
                    .description("Nemanja Radoja, mediocentro serbio que juega en el Celta de Vigo, prueba switch 2");
                    facebook.postFeed(post);
                    JOptionPane.showMessageDialog(null," Imagen publicada ");
                    break;
                case 4:
                    //DARLE LIKE A UN POST PONIENDO EL ID
                    //A partir del ID de un post, se le da a me gusta automaticamente
                    String postid=JOptionPane.showInputDialog("Introduce el ID del post");
                    //Ejemplo = 132123553865349
                    facebook.likePost(postid);
                    JOptionPane.showMessageDialog(null,"Le has dado Like a la publicación indicada");
                    break;
                case 5:
                    //COMENTAR UN ESTADO
                    //A partir del ID de un post, escribir un comentario para dicho post
                    String postid2=JOptionPane.showInputDialog("Introduce el ID del post");
                    String msg=JOptionPane.showInputDialog("Introduce el comentario");
                    facebook.commentPost(postid2,msg);
                    JOptionPane.showMessageDialog(null,"Has comentado el estado");
                    break;
                case 6:
                    //OBTENER COMENTARIOS DE UNA FOTO
                    //Poniendo el ID de una foto, nos facilita todos los comentarios de esa foto
                    //EJEMPLO ID = 132154627195575
                    
                    String fotoid = JOptionPane.showInputDialog("Introduce el Id de la foto");
                    ResponseList<Comment> comentarios = facebook.getPhotoComments(fotoid);
                    for (int i = 0; i < comentarios.size(); i++) {
                        System.out.println(comentarios.get(i).getMessage());
                    }
                    JOptionPane.showMessageDialog(null,"Los comentarios de esta foto estan por pantalla");
                    break;
                case 7:
                    //BUSCAR USUARIOS
                    //Indicando un nombre, nos da el usuario y algunos de sus datos; recomendado ser lo mas concreto posible
                    String ac ="";
                    String usuar = JOptionPane.showInputDialog("Introduce nombre a buscar");
                    ResponseList<User> results = facebook.searchUsers(usuar);
                    for (int i = 0; i < results.size(); i++) {
                        ac=ac + (results.get(i).getName());
                    }
                case 8:
                    //Salir de la aplicacion
                    System.exit(0);

                            }
}
    
    while (opcion<8);

        
    
  
    }
    
}
