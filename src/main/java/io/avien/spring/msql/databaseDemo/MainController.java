package io.avien.spring.msql.databaseDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private userRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody User addNewUser(@RequestParam String name, @RequestParam String email){

        User SpringUser = new User();
        SpringUser.setName(name);
        SpringUser.setEmail(email);
        userRepository.save(SpringUser);
        return SpringUser;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
