package hello.springmvc.basic.requestmapping;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping")
public class MappingClassController {


    @GetMapping("/users")
    public String users() {
        return "get users";
    }

    @PostMapping("/users")
    public String addUser() {
        return "post users";
    }

    @GetMapping("/users/{userId}")
    public String user(@PathVariable String userId) {
        return "get user " + userId;
    }

    @PatchMapping("/users/{userId}")
    public String patchUser(@PathVariable String userId) {
        return "patch user " + userId;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete user " + userId;
    }
}
