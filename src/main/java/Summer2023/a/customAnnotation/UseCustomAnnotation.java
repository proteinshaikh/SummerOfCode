package Summer2023.a.customAnnotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UseCustomAnnotation {

    @ValidateHeader(brand = ValidateHeader.Brand.ONE)
    @GetMapping("/")
    public String sampleGetMethod() {
        return "zeeshan";
    }
}
