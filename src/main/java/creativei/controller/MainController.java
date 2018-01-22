package creativei.controller;

import creativei.entity.Branch;
import creativei.manager.BranchManager;
import creativei.vo.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Aayush on 12/7/2017.
 */
@RestController
public class MainController {

    @Autowired
    BranchManager branchManager;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    @PostMapping("/creativei/upload")
    public String uploadLocalityDate() throws IOException {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("LocalityData.csv"), ',');
            String[] record = null;
            while ((record = reader.readNext()) != null) {
                System.out.println(record);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                reader.close();;
            }
        }
        return null;
    }


}
