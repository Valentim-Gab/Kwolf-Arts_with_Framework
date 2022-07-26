package ufsm.csi.kwolf_arts2.dao;

import ufsm.csi.kwolf_arts2.model.Arte;
import ufsm.csi.kwolf_arts2.model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class ArteDAO {
    private String sql;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Arte> getArtesTotal() {
        ArrayList<Arte> artesTotal = new ArrayList<>();

        try(Connection connection = new ConectaDBPostgres().getConexao()){

            this.sql = "select * from ARTE AA, ARTISTA A where " +
                    "id_comprador is null and AA.id_artista = A.id_artista;";

            Statement statement = connection.createStatement();
            this.resultSet = statement.executeQuery(this.sql);

            while (this.resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_comprador((resultSet.getInt("id_artista")));
                usuario.setPrimeiro_nome(resultSet.getString("primeiro_nome"));
                usuario.setSegundo_nome(resultSet.getString("segundo_nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setTipo_conta(resultSet.getString("tipo_conta"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setNacionalidade(resultSet.getString("nacionalidade"));

                Arte arte = new Arte(
                        this.resultSet.getInt("ID_ARTE"),
                        this.resultSet.getString("NOME"),
                        this.resultSet.getString("COPYRIGHT"),
                        this.resultSet.getFloat("VALOR"),
                        this.resultSet.getString("ADICIONAL"),
                        this.resultSet.getString("IMAGEM"),
                        usuario
                );
                artesTotal.add(arte);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return artesTotal;
    }

    public ArrayList<Arte> getArtesPesquisa(String pesquisa) {
        ArrayList<Arte> artesPesquisa = new ArrayList<>();
        try(Connection connection = new ConectaDBPostgres().getConexao()){

            this.sql = "select * from ARTE AA, ARTISTA A " +
                    "where AA.id_comprador is null " +
                    "and AA.id_artista = A.id_artista " +
                    "and LOWER(AA.NOME) like ?;";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setString(1, pesquisa.toLowerCase() + '%');
            resultSet = preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_comprador((resultSet.getInt("id_artista")));
                usuario.setPrimeiro_nome(resultSet.getString("primeiro_nome"));
                usuario.setSegundo_nome(resultSet.getString("segundo_nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setTipo_conta(resultSet.getString("tipo_conta"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setNacionalidade(resultSet.getString("nacionalidade"));

                Arte arte = new Arte(
                        this.resultSet.getInt("ID_ARTE"),
                        this.resultSet.getString("NOME"),
                        this.resultSet.getString("COPYRIGHT"),
                        this.resultSet.getFloat("VALOR"),
                        this.resultSet.getString("ADICIONAL"),
                        this.resultSet.getString("IMAGEM"),
                        usuario
                );
                artesPesquisa.add(arte);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return artesPesquisa;
    }

    public ArrayList<Arte> getArtes(int id) {
        ArrayList<Arte> artes = new ArrayList<>();

        try(Connection connection = new ConectaDBPostgres().getConexao()){

            this.sql = "select * from" +
                    " ARTE " +
                    "where" +
                    " id_artista = ? ";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                Arte arte = new Arte(
                        this.resultSet.getInt("ID_ARTE"),
                        this.resultSet.getString("NOME"),
                        this.resultSet.getString("COPYRIGHT"),
                        this.resultSet.getFloat("VALOR"),
                        this.resultSet.getString("ADICIONAL"),
                        this.resultSet.getString("IMAGEM"),
                        this.resultSet.getDate("data_cadastro")
                );
                artes.add(arte);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return artes;
    }

    public ArrayList<Arte> getArtesCompradas(int id) {
        ArrayList<Arte> artesCompradas = new ArrayList<>();

        try(Connection connection = new ConectaDBPostgres().getConexao()){

            this.sql = "select * from" +
                    " ARTE " +
                    "where" +
                    " id_comprador = ? ";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                Arte arte = new Arte(
                        this.resultSet.getInt("ID_ARTE"),
                        this.resultSet.getString("NOME"),
                        this.resultSet.getString("COPYRIGHT"),
                        this.resultSet.getFloat("VALOR"),
                        this.resultSet.getString("ADICIONAL"),
                        this.resultSet.getString("IMAGEM"),
                        this.resultSet.getDate("data_cadastro")
                );
                artesCompradas.add(arte);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return artesCompradas;
    }
    public Arte getArteUnica(int id) {

    Arte arte = null;

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = "select * from ARTE AA, ARTISTA A where " +
                    "id_arte = ? and AA.id_artista = A.id_artista;";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_comprador((resultSet.getInt("id_artista")));
                usuario.setPrimeiro_nome(resultSet.getString("primeiro_nome"));
                usuario.setSegundo_nome(resultSet.getString("segundo_nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setTipo_conta(resultSet.getString("tipo_conta"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setNacionalidade(resultSet.getString("nacionalidade"));

                arte = new Arte(
                        this.resultSet.getInt("ID_ARTE"),
                        this.resultSet.getString("NOME"),
                        this.resultSet.getString("COPYRIGHT"),
                        this.resultSet.getFloat("VALOR"),
                        this.resultSet.getString("ADICIONAL"),
                        this.resultSet.getString("IMAGEM"),
                        this.resultSet.getDate("data_cadastro")
                );
                arte.setUsuario(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arte;
    }

    public Arte getVerArte(int id) {

        Arte arte = null;

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = "select * from ARTE where id_arte = ?";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                arte = new Arte(
                        this.resultSet.getInt("ID_ARTE"),
                        this.resultSet.getString("NOME"),
                        this.resultSet.getString("COPYRIGHT"),
                        this.resultSet.getFloat("VALOR"),
                        this.resultSet.getString("ADICIONAL"),
                        this.resultSet.getString("IMAGEM"),
                        this.resultSet.getDate("data_cadastro")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arte;
    }

    public String cadastrarArte(Arte a) {

        try (Connection connection = new ConectaDBPostgres().getConexao()){

            //BEGIN
            connection.setAutoCommit(false);

            this.sql = "insert into ARTE (" +
                    "    nome, " +
                    "    copyright, " +
                    "    valor, " +
                    "    adicional, " +
                    "    imagem, " +
                    "    id_artista, " +
                    "    data_cadastro " +
                    ") values (" +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    CURRENT_DATE" +
                    ");";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, a.getNome());
            this.preparedStatement.setString(2, a.getCopyright());
            this.preparedStatement.setFloat(3, a.getValor());
            this.preparedStatement.setString(4, a.getAdicional());
            this.preparedStatement.setString(5, a.getImagem());
            this.preparedStatement.setInt(6, a.getUsuario().getId_comprador());

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

    public String editarArte(Arte a) {

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "update" +
                    "    ARTE " +
                    "set" +
                    "    nome = ?, " +
                    "    copyright = ?, " +
                    "    valor = ?, " +
                    "    adicional = ? " +
                    "where" +
                    "    id_arte = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, a.getNome());
            this.preparedStatement.setString(2, a.getCopyright());
            this.preparedStatement.setFloat(3, a.getValor());
            this.preparedStatement.setString(4, a.getAdicional());
            this.preparedStatement.setInt(5, a.getId_arte());
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

    public String confirmarCompra(int id_comprador, int id_arte) {

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "update" +
                    "    ARTE " +
                    "set" +
                    "    id_comprador = ?, " +
                    "    id_artista = null " +
                    "where" +
                    "    id_arte = ?;";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id_comprador);
            this.preparedStatement.setInt(2, id_arte);
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

    public String deletarArte(int id) {
        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "delete from ARTE where ID_ARTE = ?";
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
