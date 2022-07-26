package ufsm.csi.kwolf_arts2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ufsm.csi.kwolf_arts2.dao.ArteDAO;
import ufsm.csi.kwolf_arts2.dao.ArtistaDAO;
import ufsm.csi.kwolf_arts2.model.Usuario;
import ufsm.csi.kwolf_arts2.service.UsuarioService;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    ArteDAO arteDao = new ArteDAO();
    ArtistaDAO aDao = new ArtistaDAO();

    @GetMapping("/")
    public RedirectView respondeBarra() {
        return new RedirectView("/home", true);
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        String url = "index";

        if (usuario_logado != null) {
            if (usuario_logado.getTipo_conta().equals("A")) {
                url = "indexArtista";
                model.addAttribute("artes", new ArteDAO().getArtes(usuario_logado.getId_comprador()));
            } else {
                model.addAttribute("artes", arteDao.getArtesTotal());
            }
        } else {
            model.addAttribute("artes", arteDao.getArtesTotal());
        }

        return url;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public RedirectView login(@RequestParam String email, String senha, String tipo_conta,
                              HttpSession session, RedirectAttributes attributes) {
        String url;
        Usuario usuario = new UsuarioService().autenticado(email.toLowerCase(), senha, tipo_conta);

        if (usuario != null) {
            session.setAttribute("usuario_logado", usuario);
            url = "/home";
        } else {
            attributes.addFlashAttribute("erro", "Email ou senha incorretos");
            url = "/login";
        }

        return new RedirectView(url, true);
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @GetMapping("/sair")
    public RedirectView sair(HttpSession session) {
        session.invalidate();
        return new RedirectView("/home", true);
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }

    @GetMapping("/artistas-populares")
    public String artistasPopulares(Model model){
        model.addAttribute("artista", aDao.getArtistasPopulares());

        return "artistasPopulares";
    }
}
