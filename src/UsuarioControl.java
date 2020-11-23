package Control;

import Model.Usuario;
import java.util.ArrayList;

public class UsuarioControl {

    private final Usuario control;

    public UsuarioControl() {
        this.control = new Usuario();
    }

    //Cadastrar Usuário
    public boolean cadastrar(String nome, String email, String endereco, String cpf, String senha, String dataNascimento, String cep) {

        int id = control.maiorID() + 1;

        Usuario objeto = new Usuario(id, nome, email, endereco, cpf, senha, dataNascimento, cep);

        if (control.cadastrarUsuarioBD(objeto)) {
            return true;
        } else {
            return false;
        }
    }

    //Editar usuário
    public boolean editar(int id, String nome, String email, String endereco, String cpf, String senha, String dataNascimento, String cep) {

        Usuario objeto = new Usuario(id, nome, email, endereco, cpf, senha, dataNascimento, cep);

        if (control.editarUsuarioBD(id, objeto)) {
            return true;
        } else {
            return false;
        }
    }

    //Deletar usuário
    public boolean apagar(int id) {

        if (control.deletarUsuarioBD(id)) {
            return true;
        } else {
            return false;
        }
    }

    //Ler lista de usuário
    public ArrayList getlistaUsuario() {

        return control.getlistaUsuario();
    }
}
