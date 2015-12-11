/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Trev
 */
public class ActionHelper {
    
    /**
     *
     * @param input
     * @return
     */
    public String injectionReplace(String input)
    {
        String safeString = input;
        
        safeString = safeString.replaceAll("^<$", "&lt;");
        safeString = safeString.replaceAll("^>$", "&gt;");
        safeString = safeString.replaceAll("^\\($", "&#40");
        safeString = safeString.replaceAll("^\\)$", "&#41");
        safeString = safeString.replaceAll("^&$", "&#38");
        safeString = safeString.replaceAll("^|$", "&#124");
            
        return safeString;
    }
    
    /**
     *
     * @param password
     * @return
     */
    public String hashPassword(String password){
        String digest;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.reset();
            byte[] bytes = md.digest(password.getBytes());
            digest = new BigInteger(1, bytes).toString(16);
        }
        catch( NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
            digest = null;
        }
        
        return digest;
    }
}
