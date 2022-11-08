package IO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ConuntryManagement {
    public static List<Conuntry> conuntries = new ArrayList<>();
    // hiển thị
    public void showAll(){
        for (Conuntry conuntry : conuntries) {
            System.out.println(conuntry);
        }
    }
    // thêm
    public void addCountry(Conuntry conuntry){
        conuntries.add(conuntry);
    }
    public void readCountryFromFile(String path) throws IOException{
        File
    }
}
