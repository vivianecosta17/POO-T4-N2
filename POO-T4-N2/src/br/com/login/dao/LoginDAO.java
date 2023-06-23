/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.login.model.Login;

/**
 *
 * @author Jennifer
 */
public class LoginDAO {
    
    public void cadastrarUsuario(String nome, String email, String senha) throws SQLException{
        Connection Conexao = new Conexao().getConnection();
        String sql = "insert into login (nome, email, senha) values ('"+nome+"', '"+email+"', '"+senha+"')";
        System.out.println(sql);
        PreparedStatement statment = Conexao.prepareStatement(sql);
        statment.execute();
        Conexao.close();
        
    }
    
    public Login Login(String email, String senha) throws SQLException{
        Login usuario = null;
        Connection Conexao = new Conexao().getConnection();
        String sql = "select nome, email, senha from login where email = '"+email+"' and senha = '"+senha+"';";
        System.out.println(sql);
        PreparedStatement statment = Conexao.prepareStatement(sql);
        ResultSet rs = statment.executeQuery();
        
        if (rs.next()){
            usuario = new Login(rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
            System.out.println("Possui");
            
            
        } else {
            System.out.println("Nao possui");
            
            
        }
        
        Conexao.close();
        return usuario;
    }
}
