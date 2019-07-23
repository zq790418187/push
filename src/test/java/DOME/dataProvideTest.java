package DOME;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvideTest {

    @DataProvider
    public Object[][] getData(){
        Object[][] peoson={
            {"lili","123"},
            {"luck","456"},
        };
        return peoson;
    }

@Test(dataProvider="getData")
public void testDataprovide(String name,String password) {
    System.out.println(name);
    System.out.println(password);
}
    }

