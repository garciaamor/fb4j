
package facebookjavi;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;

/**
 *
 * @author Acer
 */
public class Metodos {
   
       ConfigurationBuilder cb = new ConfigurationBuilder();

FacebookFactory ff = new FacebookFactory(cb.build());
Facebook facebook = ff.getInstance(); 
    
    public ResponseList <Comment> getPostComments() throws FacebookException{
        ResponseList <Comment> c = null;
        c = facebook.getPostComments("132123553865349");
        return c;
    }
}
