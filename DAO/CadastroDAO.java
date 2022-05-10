package DAO;

import DTO.CadastroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CadastroDAO {

    Connection conn;
    PreparedStatement sttm;
    ResultSet rst;

    //arraylist
    ArrayList<CadastroDTO> list = new ArrayList<>();

    public void cadastrar(CadastroDTO objcadastroDTO) {
        String sql = "insert into logindata (Time_Jogador, Nome_Jogador, Senha) values (?,?,?)";

        conn = new ConnectBD().conectaBD();

        try {
            //requisitando query SQL
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, objcadastroDTO.getTime_cadastro());
            sttm.setString(2, objcadastroDTO.getNome_cadastro());
            sttm.setString(3, objcadastroDTO.getSenha_cadastro());

            sttm.execute();
            sttm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cadastro DAO -cadastrar(): " + e);

        }
    }

    public ArrayList<CadastroDTO> Pesquisar() {
        String sql = "select * from logindata";
        conn = new ConnectBD().conectaBD();

        try {

            sttm = conn.prepareStatement(sql);
            rst = sttm.executeQuery();

            //enquanto tiver mais linhas do banco ele continuara imprimindo
            while (rst.next()) {
                CadastroDTO objcadastroDTO = new CadastroDTO();

                //Linha confusa****
                /*estou atribuindo o valor (set) id a partir do valor q o Result pega do
               banco SQL, basicamente Resultset pega id do banco e em seguida atribui esse valor ao id lá no package 
               cadastroDTO que por fim mostrará os dados ao usuario*/
                objcadastroDTO.setId(rst.getInt("id"));
                objcadastroDTO.setTime_cadastro(rst.getString("Time_Jogador"));
                objcadastroDTO.setNome_cadastro(rst.getString("Nome_Jogador"));
                objcadastroDTO.setSenha_cadastro(rst.getString("Senha"));

                //quantas listas o while pegar ele retorna
                list.add(objcadastroDTO);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "CadastroDAO -pesquisar(): " + error);
        }
        return list;
    }

    public void alterar(CadastroDTO objcadastroDTO) {
        String sql = "update logindata set Time_Jogador = ?, Nome_Jogador = ?, Senha = ? where id = ?";
        conn = new ConnectBD().conectaBD();

        try {
            //requisitando query SQL
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, objcadastroDTO.getTime_cadastro());
            sttm.setString(2, objcadastroDTO.getNome_cadastro());
            sttm.setString(3, objcadastroDTO.getSenha_cadastro());
            sttm.setInt(4, objcadastroDTO.getId());

            sttm.execute();
            sttm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CadastroDAO -Alterar(): " + e);

        }

    }

    
    
    public void excluir(CadastroDTO objcadastroDTO){
            String sql = "delete from logindata where id = ?";
        conn = new ConnectBD().conectaBD();

        try {
            //requisitando query SQL
            sttm = conn.prepareStatement(sql);
            sttm.setInt(1, objcadastroDTO.getId());

            sttm.execute();
            sttm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CadastroDAO -Excluir(): " + e);

        }
    
    }
}
