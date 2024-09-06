package flightbooking.flightbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
public class MainController {
    @GetMapping("/index")
    public String indexPage(){
        return "index.html";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about.html";
    }

    @GetMapping("/")
    public String HomePage(){
        return "main_page.html";
    }

    @GetMapping("/main_page")
    public String mainPage(){
        return "main_page.html";
    }

    @GetMapping("/user_login_page")
    public String user_login_page(){
        return "user_login_page.html";
    }

    @GetMapping("/admin_login_page")
    public String admin_login_page(){
        return "admin_login_page.html";
    }


    @GetMapping("/search_flight_page")
    public String search_flight_page(){
        return "search_flight_page.html";
    }

    @GetMapping("/forgot_user_password_page")
    public String forgot_user_password_page(){
        return "forgot_user_password_page.html";
    }


    @GetMapping("/user_dashboard_page")
    public String user_dashboard_page(){
        return "user_dashboard_page.html";
    }
    @GetMapping("/admin_dashboard_page")
    public String admin_dashboard_page(){
        return "admin_dashboard_page.html";
    }

    @GetMapping("/user_register_page")
    public String user_register_page(){
        return "user_register_page.html";
    }

    @GetMapping("/user_logout")
    public String user_logout(){
        return "main_page.html";
    }

    @GetMapping("/reset_user_password_page")
    public String reset_user_password_page(){
        return "reset_user_password_page.html";
    }

    @GetMapping("/book_ticket_page")
    public String book_ticket_page(){
        return "book_ticket_page.html";
    }


    @GetMapping("/cancel_ticket_page")
    public String cancel_ticket_page(){
        return "cancel_ticket_page.html";
    }
    
    @GetMapping("/search_booked_ticket_details_page")
    public String search_booked_ticket_details_page(){
        return "search_booked_ticket_details_page.html";
    }
    
    @GetMapping("/passenger_detail_page")
    public String passenger_detail_page(){
        return "passenger_detail_page.html";
    }
    
    @GetMapping("/payment_page")
    public String payment_page(){
        return "payment_page.html";
    }
    
    @GetMapping("/view_booked_ticket_detail_page")
    public String view_booked_ticket_detail_page(){
        return "view_booked_ticket_detail_page.html";
    }
    
    @GetMapping("/create_flight_page")
    public String create_flight_page(){
        return "create_flight_page.html";
    }
    @GetMapping("/delete_flight_page")
    public String delete_flight_page(){
        return "delete_flight_page.html";
    }
    @GetMapping("/edit_flight_page")
    public String edit_flight_page(){
        return "edit_flight_page.html";
    }
    
    @GetMapping("/forgot_admin_password_page")
    public String forgot_admin_password_page(){
        return "forgot_admin_password_page.html";
    }
    
    @GetMapping("/reset_admin_password_page")
    public String reset_admin_password_page(){
        return "reset_admin_password_page.html";
    }
    
    @GetMapping("/admin_register_page")
    public String admin_register_page(){
        return "admin_register_page.html";
    }
    
    @GetMapping("/view_booked_ticket_page")
    public String view_booked_ticket_page(){
        return "view_booked_ticket_page.html";
    }


    @Autowired
    private DummyRepository dummyRepository;

    @Autowired
    private RegisterRepository registoryRepository;

    @Autowired
    private UserRepository userRepository;

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

    @GetMapping("/login1")
    public Response login1(@RequestParam String username, @RequestParam String password) {
        Register user = registoryRepository.findByUsername(username);
            if(user != null && password.equals(user.getPassword())){
                //return user.getAadhar();
                Response aadhaar = new Response(user.getAadhar(), 0);
                return aadhaar;
            }else{
                //return "error 404";
                Response error = new Response("error 404", 0);
                return error;
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