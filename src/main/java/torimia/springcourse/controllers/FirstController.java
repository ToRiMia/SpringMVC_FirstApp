package torimia.springcourse.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    //http://localhost:8080/first/calculator?a=9&b=23&action=multiplication
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action, Model model) {
        double c = 0;
        switch (action) {
            case "multiplication":
                c = a * b;
                break;
            case "addition":
                c = a + b;
                break;
            case "subtraction":
                c = a - b;
                break;
            case "division":
                c = (double) a / b;
                break;
        }
        model.addAttribute("result", "Result: " + c);
        return "first/calculator";
    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {
        model.addAttribute("message", "Hello " + name + " " + surname + "!");
        System.out.println("Hello " + name + " " + surname + "!");
        return "first/hello";
    }

    //http://localhost:8080/first/goodbye?name=Vika&surname=Arnel
    @GetMapping("/goodbye")
    public String goodByePage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Goodbye " + name + " " + surname + "!");
        return "first/goodbye";
    }
}
