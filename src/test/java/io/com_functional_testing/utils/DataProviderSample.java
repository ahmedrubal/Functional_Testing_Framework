package io.com_functional_testing.utils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample {


    @DataProvider(name="data")
    public String[][] arrayData(){
        String[][] arrayData=new String[][]{
                {"Rubal","Ahmed"},
                {"Sony","hasan"}
        };
        return arrayData;
    }

    @Test(dataProvider = "data")
    public void testingData(String userName,String passWord){
        System.out.println(userName);
        System.out.println(passWord);

    }

}
