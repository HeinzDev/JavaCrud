
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UsuarioDAO {
    
    Connection conn;
    
    public ResultSet autenticacaoUsuario(UsuarioDTO objuserDTO){
        conn = new ConnectBD().conectaBD();
        
        
        try {
            String sql = "select * from logindata where Nome_Jogador = ? and Time_Jogador = ? and Senha = ? ";
            //preparação do uso SQL (PreparedStatement), execução do autenticador.
            PreparedStatement sttm = conn.prepareStatement(sql);
            
            //uso do encapsulamento (DTO) para substituição dos parâmetros (?) do comando SQL
            sttm.setString(1, objuserDTO.getNome_usuario());
            sttm.setString(2, objuserDTO.getTime_usuario());
            sttm.setString(3, objuserDTO.getSenha_usuario());
            
            //execução da query sql
            ResultSet rst = sttm.executeQuery();
            return rst;
            
            
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO :" + error);
            return null;
            
        }
        
    }
}
