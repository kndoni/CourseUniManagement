/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessNDataAccessLayer;

import PresentationLayer.AddFriendForm;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class FriendsDaoTest {
    
  @Test
    public void testFriendValidate() {
        AddFriendForm addFriendForm1 = new AddFriendForm();
        boolean value1 = addFriendForm1.validateFriend("3");
        Assert.assertEquals(false,value1);
        
        boolean result1 = FriendsDao.UserValidate("2");
        
        Assert.assertEquals(true,result1);
    }

    /**
     * Test of UserValidate method, of class FriendsDao.
     */
    @Test
    public void testUserValidate() {
        AddFriendForm addFriendForm1 = new AddFriendForm();
        boolean value1 = addFriendForm1.validateUser("2");
        Assert.assertEquals(true,value1);
        
        boolean result1 = FriendsDao.UserValidate("2");
        
        Assert.assertEquals(true,result1);
    }

    /**
     * Test of addFriend method, of class FriendsDao.
     */
    @Test
    public void testAddFriend() {
        FriendsDao friendsDao = new FriendsDao();
        AddFriendForm addFriendForm1 = new AddFriendForm();
        int value1 = addFriendForm1.addNewFriend(1,"1");
        
        int validate= 1;
        
        boolean result1 = FriendsDao.UserValidate("1");
        
        if(result1 == true)
            validate =0;
 
         Assert.assertEquals(value1, validate);

    }

    /**
     * Test of Check method, of class FriendsDao.
     */
    @Test
    public void testCheck() {
        FriendsDao friendsDao = new FriendsDao();
        int check1 = FriendsDao.Check("1");
        
        Assert.assertEquals(1,check1);
    }
}
