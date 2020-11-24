package Model;

import DAO.UsuarioDAO;
import java.util.ArrayList;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String endereco;
    private String cpf;
    private String senha;
    private String dataNascimento;
    private String cep;

    public Usuario() {

    }

    public Usuario(int id, String nome, String email, String endereco, String cpf, String senha, String dataNascimento, String cep) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ArrayList getlistaUsuario() {
        return UsuarioDAO.listaUsuario;
    }

    public boolean cadastrarUsuarioBD(Usuario objeto) {
        UsuarioDAO.listaUsuario.add(objeto);
        return true;
    }

    public boolean deletarUsuarioBD(int id) {
        int indice = this.procuraIndice(id);
        UsuarioDAO.listaUsuario.remove(indice);
        return true;
    }

    public boolean editarUsuarioBD(int id, Usuario objeto) {
        int indice = this.procuraIndice(id);
        UsuarioDAO.listaUsuario.set(indice, objeto);
        return true;
    }

    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < UsuarioDAO.listaUsuario.size(); i++) {
            if (UsuarioDAO.listaUsuario.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

    public int maiorID() {
        return UsuarioDAO.maiorID();
    }

    //login
    public boolean login(String email, String senha) {
        for (int i = 0; i < UsuarioDAO.listaUsuario.size(); i++) {
            if (UsuarioDAO.listaUsuario.get(i).email.equals(email) && UsuarioDAO.listaUsuario.get(i).senha.equals(senha)) {
                return true;
            }
        }
        return false;
    }

}
