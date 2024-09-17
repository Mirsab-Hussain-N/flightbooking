//package trainbookingapp.trainbookingapp.controllers.api;
package flightbooking.flightbooking.controllers.api;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import flightbooking.flightbooking.EmailSenderService;
//import trainbookingapp.trainbookingapp.EmailSenderService;
import flightbooking.flightbooking.Response;
//import trainbookingapp.trainbookingapp.Response;
//import trainbookingapp.trainbookingapp.entity.VerifyUser;
import flightbooking.flightbooking.entity.*;
//import trainbookingapp.trainbookingapp.repository.VerifyUserRepository;
import flightbooking.flightbooking.repository.*;

@RestController
@RequestMapping("/api")
public class ForgotPasswordController {

  @Autowired
  private VerifyUserRepository verifyUserRepository;

  @Autowired
  private EmailSenderService emailSenderService;

  @GetMapping("/send-otp")
  public Response sendOtp(@RequestParam String email) {
    String OTP = (int) Math.floor(100000 + Math.random() * 9000000) + "";
    emailSenderService.sendEmail(
      email,
      "OTP for Train Booking App ",
      "Your OTP is " + OTP
    );
    VerifyUser verifyUser = new VerifyUser();
    verifyUser.setEmail(email);
    verifyUser.setOtp(OTP);
    verifyUserRepository.save(verifyUser);
    Response response = new Response();
    response.message = "OTP Sent Successfully";
    response.status = 200;
    return response;
  }

  // /api/verify-otp?email=r.rahul.developer@gmail.com&otp=123456
  @GetMapping("/verify-otp")
  @Transactional
  public Response verifyOtp(
    @RequestParam String email,
    @RequestParam String otp
  ) {
    VerifyUser verifyUser = verifyUserRepository.findByEmail(email);
    if (verifyUser.getOtp().equals(otp)) {
      verifyUserRepository.deleteByEmail(email);
      Response response = new Response();
      response.message = "OTP Verified Successfully";
      response.status = 200;
      return response;
    }
    Response response = new Response();
    response.message = "OTP Verification Failed";
    response.status = 400;
    return response;
  }
}
