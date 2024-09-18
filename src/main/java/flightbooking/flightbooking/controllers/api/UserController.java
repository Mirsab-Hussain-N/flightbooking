package flightbooking.flightbooking.controllers.api;

import java.lang.Iterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import flightbooking.flightbooking.Response;
import flightbooking.flightbooking.entity.*;
import flightbooking.flightbooking.repository.*;
// import trainbookingapp.trainbookingapp.Response;
// import trainbookingapp.trainbookingapp.entity.User;
// import trainbookingapp.trainbookingapp.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping(path = "/login")
  public Response login(
    @RequestParam String username,
    @RequestParam String password
  ) {
    Iterable<User> iterator = userRepository.findAll();

    for (User user : iterator) {
      if (
        user.getUsername().equals(username) &&
        user.getPassword().equals(password)
      ) {
        Response response = new Response();
        response.message = user.getAadhar();
        response.status = 200;
        return response;
      }
    }
    Response response = new Response();
    response.message = "Username or Password is incorrect";
    response.status = 400;
    return response;
  }
  
  // @GetMapping(path = "/register")
  // public Response register(@ModelAttribute User user) {
  //     // User user = userRepository.findByEmail(user.);
  //     String emailId = user.getEmail();
  //     Response response = new Response();
  //     if (emailId != null) {
  //         response.message = "User exists with this email";
  //         response.status = 500;
  //         return response;
  //     }else{
  //         userRepository.save(user);
  //         response.message = "Registration Successful";
  //         response.status = 200;
  //         return response;
  //     }
  // }

  @GetMapping(path = "/register")
  public Response login(@ModelAttribute User user) {
    String email = user.getEmail();
    
    userRepository.save(user);
    Response response = new Response();
    response.message = "Registration Successful";
    response.status = 200;
    return response;
  }
  

  @GetMapping(path = "/get-user")
  public User getUser(@RequestParam String aadhar) {
    User user = userRepository.findByAadhar(aadhar);
    return user;
  }

  @GetMapping("/change-password")
  public Response changePassword(
    @RequestParam String email,
    @RequestParam String password
  ) {
    User user = userRepository.findByEmail(email);
    user.setPassword(password);
    userRepository.save(user);
    Response response = new Response();
    response.message = "Password Changed Successfully";
    response.status = 200;
    return response;
  }

  @GetMapping("/get-user-by-aadhar")
  public User getUserByAadhar(@RequestParam String aadhar) {
    User user = userRepository.findByAadhar(aadhar);
    return user;
  }
}
