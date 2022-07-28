package ufsm.csi.kwolf_arts2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ufsm.csi.kwolf_arts2.dao.ArteDAO;
import ufsm.csi.kwolf_arts2.dao.ArtistaDAO;
import ufsm.csi.kwolf_arts2.model.Arte;
import ufsm.csi.kwolf_arts2.model.Usuario;
import javax.servlet.http.HttpSession;

@Controller
public class ArteController {
    ArteDAO arteDAO = new ArteDAO();
    ArtistaDAO aDao = new ArtistaDAO();

    @GetMapping("/minhas-compras")
    public String minhasCompras(HttpSession session, Model model) {
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        model.addAttribute("artesCompradas",
                arteDAO.getArtesCompradas(usuario_logado.getId_comprador()));

        return "arteComprada";
    }

    @GetMapping("/registre-sua-arte")
    public String registreSuaArte() {
        return "registrarArte";
    }

    @PostMapping("/registre-sua-arte")
    public RedirectView registreSuaArte(@ModelAttribute("arte") Arte arte, HttpSession session) {
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        Usuario usuario;
        usuario = aDao.getArtistaUnico(usuario_logado.getId_comprador());
        arte.setUsuario(usuario);
        arteDAO.cadastrarArte(arte);

        return new RedirectView("/home", true);
    }

    @PostMapping("/ver-arte")
    public String verArte(@RequestParam int id_arte_comprada, Model model) {
        model.addAttribute("arte", new ArteDAO().getVerArte(id_arte_comprada));

        return "verArte";
    }

    @PostMapping("/comprar-arte")
    public RedirectView comprarArte(@RequestParam int id_arte, HttpSession session,
                              RedirectAttributes attributes, Model model) {
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        String url;
        if (usuario_logado != null) {
            url =  "/comprar-arte?id_arte=" + id_arte;
        } else {
            url = "/login";
            attributes.addFlashAttribute("erro", "Faça login antes de comprar uma arte");
        }

        return new RedirectView(url, true);
    }

    @GetMapping("/comprar-arte")
    public String comprarArte(@RequestParam int id_arte, Model model) {
        model.addAttribute("arte", new ArteDAO().getArteUnica(id_arte));

        return "comprarArte";
    }

    @PostMapping("/confirmar-compra")
    public RedirectView confirmarCompra(@RequestParam int id_arte, HttpSession session) {
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        arteDAO.confirmarCompra(usuario_logado.getId_comprador(), id_arte);

        return new RedirectView("/minhas-compras", true);
    }

    @PostMapping("/deletar-arte")
    public RedirectView deletarArte(@RequestParam int id_arte) {
        arteDAO.deletarArte(id_arte);

        return new RedirectView("/home", true);
    }

    @GetMapping("/editar-arte")
    public String editarArte(@RequestParam int id_arte, Model model) {
        model.addAttribute("arte", new ArteDAO().getArteUnica(id_arte));

        return "editarArte";
    }

    @PostMapping("/editar-arte")
    public RedirectView editarArte(@ModelAttribute("arte") Arte arte) {
        arteDAO.editarArte(arte);

        return new RedirectView("/home", true);
    }

    @PostMapping("/arte-pesquisa")
    public String artePesquisa(@RequestParam String campoPesquisa, Model model) {
        model.addAttribute("artes", arteDAO.getArtesPesquisa(campoPesquisa));

        return "artePesquisa";
    }
}
