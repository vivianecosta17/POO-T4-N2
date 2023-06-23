/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.controller;
import br.com.login.dao.Conexao;
import br.com.login.dao.LoginDAO;
import br.com.login.model.Login;
import br.com.login.view.CadastroView;
import br.com.login.view.LoginView;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Jennifer
 */
public class LoginController {
    
    public void CadastroUsuario(CadastroView view) throws SQLException{
        
    Connection Conexao = new Conexao().getConnection();
     LoginDAO Cadastro = new LoginDAO();
     Cadastro.cadastrarUsuario(view.getjTextFieldNome().getText(), view.getjTextFieldEmail().getText(), view.getjPasswordFieldSenha().getText());
    
    }
    
    public Login LoginUsuario(LoginView view) throws SQLException{
    
     Login usuario = null;  
    Connection Conexao = new Conexao().getConnection();
     LoginDAO Login = new LoginDAO();
    usuario = Login.Login(view.getjTextFieldLogin().getText(), view.getjPasswordFieldSenha().getText());
    
    return usuario;
    }
}
    
    
