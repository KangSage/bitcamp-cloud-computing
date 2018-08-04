package bitcamp.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class FileUploadRestController {

    @Autowired ServletContext sc;

    @RequestMapping("/json-upload01")
    public Object upload01(
            String name,
            int age,
            MultipartFile photo) {

        // 새 파일명 준비
        String newfilename = UUID.randomUUID().toString();
        String path = sc.getRealPath("/files/" + newfilename);

        HashMap<String, Object> result = new HashMap<>();
        try {
            photo.transferTo(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        result.put("name", name);
        result.put("age", age);
        result.put("newfilename", newfilename);

        return result;
    }
}