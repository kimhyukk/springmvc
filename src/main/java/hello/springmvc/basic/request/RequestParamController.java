package hello.springmvc.basic.request;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age = {}", username, age);

        response.getWriter().write("OK");


    }


    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username = {}, age = {}", memberName, memberAge);

        return "OK";
    }


    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {

        log.info("username = {}, age = {}", username, age);

        return "OK";
    }


    /**
     *
     * @param username
     * @param age
     * 단순 타입 (string, int, integer) @RequestParam 생략 가능 (생략 안하는걸 추천)
     */
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {

        log.info("username = {}, age = {}", username, age);

        return "OK";
    }



    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false) Integer age) {

        log.info("username = {}, age = {}", username, age);

        return "OK";
    }


    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap) {

        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));

        return "OK";
    }

}
