package com.mycompany.bookservice;

import com.mycompany.bookservice.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {


     @GetMapping
     public String greet() {
        return"How are you";
     }
   /*   @GetMapping("/withname/{name11}/{lname}")
     public String greetWithName(@PathVariable("name11") String name,@PathVariable("name11") String lname) {
        return"How are you "+name+" "+lname+"?";
      }*/

     @GetMapping("/withnameko")
     public String greetWithName(@PathVariable("name11") String name,@PathVariable("name11") String lname) {
        return"How are you "+name+" "+lname+"?";
     }
      //https://localhost:8080/api/v1/greetings/save-employee
      @PostMapping("/save-employee")
     public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
        return employeeDTO;

    }

       }
