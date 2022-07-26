package ufsm.csi.kwolf_arts2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ufsm.csi.kwolf_arts2.dao.ArtistaDAO;
import ufsm.csi.kwolf_arts2.dao.UsuarioDAO;
import ufsm.csi.kwolf_arts2.model.Usuario;

import javax.servlet.http.HttpSession;

@Controller
public class ContaController {
    UsuarioDAO dao = new UsuarioDAO();
    ArtistaDAO aDao = new ArtistaDAO();

    @PostMapping("/cadastrar")
    public RedirectView cadastrar(@ModelAttribute("usuario") Usuario usuario) {

        System.out.println(usuario.getTipo_conta());
        if (usuario.getTipo_conta().equals("C")) {

            dao.cadastrarComprador(usuario);
        } else if (usuario.getTipo_conta().equals("A")) {
            aDao.cadastrarArtista(usuario);
        }

        return new RedirectView("/sair", true);
    }

    @GetMapping("/minha-conta")
    public String minhaConta(Model model, HttpSession session) {
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        Usuario usuario;

        usuario = (usuario_logado.getTipo_conta().equals("C")) ?
                dao.getCompradorUnico(usuario_logado.getId_comprador()) :
                aDao.getArtistaUnico(usuario_logado.getId_comprador());

        model.addAttribute("usuario", usuario);
        return "perfilUsuario";
    }

    @PostMapping("/deletar")
    public RedirectView deletar(@RequestParam int id, String tipo_conta) {
        if (tipo_conta.equals("C")) {
            dao.deletarComprador(id);
        } else if (tipo_conta.equals("A")) {
            aDao.deletarArtista(id);
        }

        return new RedirectView("/sair", true);
    }

    @PostMapping("/editar")
    public RedirectView editar(@ModelAttribute("usuario") Usuario usuario, HttpSession session) {
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        if (usuario.getTipo_conta().equals("C")) {
            dao.editarComprador(usuario);
        } else if (usuario.getTipo_conta().equals("A")) {
            aDao.editarArtista(usuario);
        }
        usuario_logado = (usuario_logado.getTipo_conta().equals("C")) ?
                dao.getCompradorUnico(usuario_logado.getId_comprador()) :
                aDao.getArtistaUnico(usuario_logado.getId_comprador());
        session.setAttribute("usuario_logado", usuario_logado);

        return new RedirectView("/home", true);
    }

    @PostMapping("/perfil-artista")
    public String perfilArtista(@RequestParam int id_artista, Model model) {
        model.addAttribute("artista", aDao.getArtistaPerfil(id_artista));

        return "perfilArtista";
    }
}
