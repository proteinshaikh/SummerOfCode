import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Albumservice service;

    @GetMapping("/albums")
    public String albums(){
        return service.getAlbums();
    }

}
