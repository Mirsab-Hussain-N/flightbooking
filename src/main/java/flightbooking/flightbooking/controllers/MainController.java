package flightbooking.flightbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//without importing the 2 packages it wont really work 
//import flightbooking.flightbooking.respository.DummyRepository; same thing 

@Controller
public class MainController {
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
    @GetMapping("/admin-register")
    public String adminRegisterPage() {
        return "admin-register-page.html";
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
}