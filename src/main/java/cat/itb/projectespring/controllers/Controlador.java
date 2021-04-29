package cat.itb.projectespring.controllers;



import cat.itb.projectespring.model.Comic;
import cat.itb.projectespring.model.Usuari;
import cat.itb.projectespring.model.services.ComicService;
import cat.itb.projectespring.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class Controlador {

    String name;
    @Autowired
    private UserService userService;
    @Autowired
    private ComicService comicService;

    @GetMapping("/")
    public String inici(Model m){

        m.addAttribute("comicList", comicService.comics());
        m.addAttribute("Comic",new Comic());
        return "home";

    }

    @GetMapping("/home")
    public String listComics(Model m){

        m.addAttribute("comicList", comicService.comics());
        m.addAttribute("Comic",new Comic());
        return "home";

    }

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {

        model.addAttribute("Usuari", new Usuari());
        return "register";

    }

    @PostMapping("/registration")
    public String afegirSubmit(@ModelAttribute("Usuari") Usuari e){

        e.setRol("USER");
        userService.afegir(e);
        return "redirect:/login";

    }

    @RequestMapping(value ="/delete/{name}", method = RequestMethod.POST)
    public String removeComic(@PathVariable("name") String comic){

        comicService.deleteComicByName(comic);
        return "redirect:/";

    }

    @GetMapping("/userList")
    public String list(Model m){

        m.addAttribute("userList", userService.llistat());
        return "userList";

    }

    @RequestMapping("/add")
    public String add(Model model) {

        model.addAttribute("Comic", new Comic());
        return "addComic";

    }

    @PostMapping("/addComic")
    public String addComic(@ModelAttribute("Comic") Comic c){

        comicService.add(c);
        return "redirect:/";

    }

    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String updateComic(@PathVariable("name") String comic, Model m){

        name = comic;
        m.addAttribute("Comic", comicService.searchByName(comic));

        return "updateComic";

    }

    @PostMapping("/updateComic")
    public String updateComicPost(@ModelAttribute("Comic") Comic c){

        comicService.updateComic(c, name);
        return "redirect:/";

    }
}