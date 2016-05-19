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


                        /**
                         * 
                         * Esta es la clase main, que contiene un objeto del que se llaman a los métodos y un switch a modo de menú
                         * 
                         * 
                         **/ 
public class FacebookJavi {

    public static void main(String[] args) throws FacebookException, MalformedURLException {
     
       ConfigurationBuilder cb = new ConfigurationBuilder();
       cb.setDebugEnabled(true);
        
       
FacebookFactory ff = new FacebookFactory(cb.build());
Facebook facebook = ff.getInstance(); 
      

Metodos export = new Metodos();

int opcion=0;
do{
opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una accion:\n1. Ver usuario conectado \n2. Publicar un estado.\n3. Publicar una foto\n4. Dar Like a publicaciones \n5. Comentar una publicación \n6. Obtener los comentarios de un post \n7. Buscar una persona \n8. Salir del programa" ));

switch (opcion) {
                case 1:
                    export.mostrarUsuario();
                    break;
                case 2:
                    export.publicarEstado();
                    break;
                case 3:
                    export.postLink();
                    break;
                case 4:
                    export.likePost();
                    break;
                case 5:
                    export.comentEstado();
                    break;
                case 6:
                    export.obtenerComentFoto();
                    break;
                case 7:
                    export.buscarUsuario();
                case 8:
                    //Salir de la aplicacion
                    System.exit(0);

                            }
}
    
    while (opcion<8);

        
    
  
    }
    
}
