package ufsm.csi.kwolf_arts2.service;

import ufsm.csi.kwolf_arts2.dao.ArtistaDAO;
import ufsm.csi.kwolf_arts2.dao.UsuarioDAO;
import ufsm.csi.kwolf_arts2.model.Usuario;

import java.sql.SQLException;

public class UsuarioService {

    private UsuarioDAO dao;
    private ArtistaDAO aDao;

    public Usuario autenticado(String email, String senha, String tipo_conta) {

        dao = new UsuarioDAO();
        aDao = new ArtistaDAO();

        Usuario u = tipo_conta.equals("C") ? dao.getComprador(email, senha) : aDao.getArtista(email, senha);

        try {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
