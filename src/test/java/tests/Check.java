package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Check extends BaseTest {

    @Test
    public void check(){
        String title = header.getPageTitle();
        Assert.assertEquals(title, "My prestashop");
    }


}
