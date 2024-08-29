package flightbooking.flightbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import flightbooking.flightbooking.entity.*;
import flightbooking.flightbooking.respository.*;
//without importing the 2 packages it wont really work 
//import flightbooking.flightbooking.respository.DummyRepository; same thing 
class Response{
    public String message;
    public int code;
    public Response(String message, int code){
        this.message = message;
        this.code = code;
    }
}
@RestController
public class MainController {

    @Autowired
    private DummyRepository dummyRepository;
    private RegisterRepository registoryRepository;
    //creating an instance of DummyRepository 


    //RequestParam = Request Parameters. you take user inputs for username and password and return the respective response based on password 
    @GetMapping("/login")
    public Response login(@RequestParam String username,@RequestParam String password){
        String USERNAME = "admin";
        String PASSWORD = "admin";
        if(username.equals(USERNAME) && password.equals(PASSWORD)){
            Response response = new Response("Login Successful", 0);
            return response;
        }else{
            Response response = new Response("Login Failed", 0);
            return response;
        }
    }

    //Here we are JPA is automatically inserting values into the sql table with this function
    //Therefore this is used to ADD something to database
    @GetMapping("/add")
    public Response add(@ModelAttribute Dummy user){    //now function becomes sorta dynamic
        dummyRepository.save(user);
        return new Response("Successfully Added", 0);
    }   

    //TO READ something in a database:
    @GetMapping("/get")
    public Dummy get(@RequestParam int id){
        Dummy user = dummyRepository.findById(id);
        return user;
    }
    @GetMapping("/add1")
    public Response add1(@ModelAttribute Register username){    //now function becomes sorta dynamic
        registoryRepository.save(username);
        return new Response("Successfully Added", 0);
    }   

    //TO READ something in a database:
    @GetMapping("/get1")
    public Register get1(@RequestParam String username){
        Register user = registoryRepository.findByUsername(username);
        return user;
    }
}