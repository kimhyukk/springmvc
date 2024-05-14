package hello.springmvc.basic.response;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {


    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mv = new ModelAndView("response/hello")
                .addObject("data", "hello!");


        return mv;
    }


    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {

        model.addAttribute("data", "Hello~~");

        return "response/hello";
    }


    /**
     * url과 view의 이름이 같으면 생략 가능 (추천하지않음)
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {

        model.addAttribute("data", "Hello~~");

    }

}
