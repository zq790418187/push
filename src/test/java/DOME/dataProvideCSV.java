package DOME;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dataProvideCSV {

@DataProvider
public Iterator<Object[]> getData(){
    String path=this.getClass().getResource("test.csv").getPath();
    return readDataFromCSV(path);
}

@Test(dataProvider="getData")
public void testDataprovide(String name,String password) {
    System.out.println(name);
    System.out.println(password);
}

      public Iterator<Object[]> readDataFromCSV(String path){
            List<Object[]> list = new ArrayList<Object[]>();
            try {
                FileReader is = new FileReader(new File(path));
                BufferedReader br = new BufferedReader(is);
                while(br.ready()){
                    list.add(br.readLine().split(","));
                }
                return list.iterator();
            }catch(Exception ex){
                throw new SkipException(ex.getMessage());
            }
        }


    }

