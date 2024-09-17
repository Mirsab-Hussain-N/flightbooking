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
public class AdminController {

  @Autowired
  private AdminRepository adminRepository;

  @GetMapping(path = "/admin-login")
  public Response adminlogin(
    @RequestParam String username,
    @RequestParam String password
  ) {
    Iterable<admin> iterator = adminRepository.findAll();

    for (admin admin : iterator) {
      if (
        admin.getUsername().equals(username) &&
        admin.getPassword().equals(password)
      ) {
        Response response = new Response();
        response.message = admin.getAadhar();
        response.status = 200;
        return response;
      }
    }
    Response response = new Response();
    response.message = "Username or Password is incorrect";
    response.status = 400;
    return response;
  }

  // QUERY
  // http://localhost:8080/api/register?username=dusklight00&firstName=dusk&lastName=light&email=r.rahul.developer@gmail.com&mobileNumber=999&address=boston&city=bangalore&state=karnataka&password=password&aadhar=999&pincode=123&gender=male
  @GetMapping(path = "/admin-register")
  public Response adminlogin(@ModelAttribute admin admin) {
    adminRepository.save(admin);
    Response response = new Response();
    response.message = "Registration Successful";
    response.status = 200;
    return response;
  }

  @GetMapping(path = "/get-admin")
  public admin getAdmin(@RequestParam String aadhar) {
    admin admin = adminRepository.findByAadhar(aadhar);
    return admin;
  }

  @GetMapping("/change-admin-password")
  public Response adminchangePassword(
    @RequestParam String email,
    @RequestParam String password
  ) {
    admin admin = adminRepository.findByEmail(email);
    admin.setPassword(password);
    adminRepository.save(admin);
    Response response = new Response();
    response.message = "Password Changed Successfully";
    response.status = 200;
    return response;
  }

  @GetMapping("/get-admin-by-aadhar")
  public admin getAdminByAadhar(@RequestParam String aadhar) {
    admin admin = adminRepository.findByAadhar(aadhar);
    return admin;
  }
}
