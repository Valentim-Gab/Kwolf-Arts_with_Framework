package ufsm.csi.kwolf_arts2.dao;

import ufsm.csi.kwolf_arts2.model.Usuario;

import java.sql.*;

public class UsuarioDAO {

    private String sql;

    private Statement statement;

    private ResultSet resultSet;

    private PreparedStatement preparedStatement;

    private String status;

    public Usuario getComprador(String email, String senha) {
        Usuario usuario = null;

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = " select * from" +
                    "    COMPRADOR C " +
                    "where" +
                    "    C.EMAIL = ? " +
                    "and" +
                    "    C.SENHA = ? ";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId_comprador((resultSet.getInt("id_comprador")));
                usuario.setPrimeiro_nome(resultSet.getString("primeiro_nome"));
                usuario.setSegundo_nome(resultSet.getString("segundo_nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setTipo_conta(resultSet.getString("tipo_conta"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setNacionalidade(resultSet.getString("nacionalidade"));
                usuario.setData_nascimento(resultSet.getDate("data_nascimento"));
                usuario.setData_cadastro(resultSet.getDate("data_cadastro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    public Usuario getCompradorUnico(int id) {

        Usuario usuario = null;

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = " select * from" +
                    "    COMPRADOR C " +
                    "where" +
                    "    C.id_comprador = ? ";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId_comprador((resultSet.getInt("id_comprador")));
                usuario.setPrimeiro_nome(resultSet.getString("primeiro_nome"));
                usuario.setSegundo_nome(resultSet.getString("segundo_nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setTipo_conta(resultSet.getString("tipo_conta"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setNacionalidade(resultSet.getString("nacionalidade"));
                usuario.setData_nascimento(resultSet.getDate("data_nascimento"));
                usuario.setData_cadastro(resultSet.getDate("data_cadastro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public String cadastrarComprador(Usuario u) {

        try (Connection connection = new ConectaDBPostgres().getConexao()){

            //BEGIN
            connection.setAutoCommit(false);

            this.sql = "insert into COMPRADOR (primeiro_nome, segundo_nome, email, cpf, senha, tipo_conta, data_cadastro, data_nascimento) " +
                    "values (?,?,?,?,?,?,CURRENT_DATE, ?);";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, u.getPrimeiro_nome());
            this.preparedStatement.setString(2, u.getSegundo_nome());
            this.preparedStatement.setString(3, u.getEmail());
            this.preparedStatement.setString(4, u.getCpf());
            this.preparedStatement.setString(5, u.getSenha());
            this.preparedStatement.setString(6, u.getTipo_conta());
            this.preparedStatement.setDate(7, u.getData_nascimento());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if (this.resultSet.getInt(1) > 0) {
                this.status = "OK";
                connection.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }
        return this.status;
    }

    public String editarComprador(Usuario u) {

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "update" +
                    "    COMPRADOR " +
                    "set" +
                    "    primeiro_nome = ?, " +
                    "    segundo_nome = ?, " +
                    "    email = ?, " +
                    "    cpf = ?, " +
                    "    senha = ?, " +
                    "    telefone = ?, " +
                    "    nacionalidade = ?, " +
                    "    data_nascimento = ? " +
                    "where" +
                    "    id_comprador = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, u.getPrimeiro_nome());
            this.preparedStatement.setString(2, u.getSegundo_nome());
            this.preparedStatement.setString(3, u.getEmail());
            this.preparedStatement.setString(4, u.getCpf());
            this.preparedStatement.setString(5, u.getSenha());
            this.preparedStatement.setString(6, u.getTelefone());
            this.preparedStatement.setString(7, u.getNacionalidade());
            this.preparedStatement.setDate(8, u.getData_nascimento());
            this.preparedStatement.setInt(9, u.getId_comprador());
            this.preparedStatement.executeUpdate();

            if (this.preparedStatement.getUpdateCount() > 0) {
                this.status = "OK";
                connection.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }

    public String deletarComprador(int id) {
        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "delete from COMPRADOR where ID_COMPRADOR = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();

            if (this.preparedStatement.getUpdateCount() > 0) {
                this.status = "OK";
                connection.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }
}
