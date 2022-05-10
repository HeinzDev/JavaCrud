
package DTO;


public class CadastroDTO {
    private String nome_cadastro, time_cadastro, senha_cadastro;
    private int id;

    public String getNome_cadastro() {
        System.out.println(nome_cadastro);
        return nome_cadastro;
    }


    public void setNome_cadastro(String nome_cadastro) {
        this.nome_cadastro = nome_cadastro;
        System.out.println(nome_cadastro);
    }


    public String getTime_cadastro() {
        return time_cadastro;
    }


    public void setTime_cadastro(String time_cadastro) {
        this.time_cadastro = time_cadastro;
    }

    public String getSenha_cadastro() {
        return senha_cadastro;
    }

    public void setSenha_cadastro(String senha_cadastro) {
        this.senha_cadastro = senha_cadastro;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
        System.out.println(id);
    }
    
    
    
}
