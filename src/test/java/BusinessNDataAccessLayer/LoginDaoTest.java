/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessNDataAccessLayer;

import PresentationLayer.LoginForm;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author user
 */
public class LoginDaoTest {
    
    public static LoginDao loginDao = new LoginDao();
   
    /**
     * Test of validate method, of class LoginDao.
     */
    @Test
    public void testValidateLoginFalse() {
        LoginForm loginForm = new LoginForm();
        boolean result = false;
        Assert.assertEquals(result,loginForm.LoginUser("kristi", "kristi1233"));
    }
    
    @Test
    public void testValidateLoginTrue(){
        LoginForm loginForm = new LoginForm();
        boolean result = true;
        Assert.assertEquals(result,loginForm.LoginUser("kristi", "kristi123"));
    }
}
