/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketstats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class BasketStatsDao {
    private static final String URL = "jdbc:mysql://localhost:3306/basket_stats";
    private static final String USUARIO = "root"; 
    private static final String SENHA = "miguel250309";      

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados: " + e.getMessage());
            return null;
        }
    }

    
    public static boolean cadastrarAtleta(Atletas atleta) {
        String sql = "INSERT INTO atletas (nome, idade, altura,peso,posicao, pontos, rebotes, assistencias, telefone, time, camp_atual, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, atleta.getNome());
        stmt.setInt(2, atleta.getIdade());
        stmt.setDouble(3, atleta.getAltura());
        stmt.setDouble(4, atleta.getPeso());
        stmt.setString(5, atleta.getPosicao());
        stmt.setDouble(6, atleta.getPontos());
        stmt.setDouble(7, atleta.getRebotes());
        stmt.setDouble(8, atleta.getAssist());
        stmt.setString(9, atleta.getTelefone());
        stmt.setString(10, atleta.getTime());
        stmt.setString(11, atleta.getCamp_atual());
        stmt.setString(12, atleta.getEmail());
        stmt.setString(13, atleta.getSenha());
        
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Erro ao cadastrar atleta: " + e.getMessage());
        return false;
    }
    }

    public static List<Atletas> listarAtletas() {
        List<Atletas> lista = new ArrayList<>();
        String sql = "SELECT * FROM atletas";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Atletas a = new Atletas();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getInt("idade"));
                a.setPeso(rs.getDouble("peso"));
                a.setAltura(rs.getDouble("altura"));
                a.setPosicao(rs.getString("posicao"));
                a.setPontos(rs.getDouble("pontos"));
                a.setRebotes(rs.getDouble("rebotes"));
                a.setAssist(rs.getDouble("assistencias"));
                a.setTelefone(rs.getString("telefone"));
                a.setTime(rs.getString("time"));
                a.setCamp_atual(rs.getString("camp_atual"));
                a.setEmail(rs.getString("email"));
                a.setSenha(rs.getString("senha"));
                
                lista.add(a);
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao listar atletas: " + e.getMessage());
        }
        return lista;
    }

 
    public static boolean cadastrarTreinador(Treinadores treinador) {
        String sql = "INSERT INTO treinadores (nome, idade, telefone, email, senha, equipe) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, treinador.getNome());
            stmt.setString(2, treinador.getIdade());
            stmt.setString(3, treinador.getTelefone());
            stmt.setString(4, treinador.getEmail());
            stmt.setString(5, treinador.getSenha());
            stmt.setString(6, treinador.getEquipe());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao cadastrar treinador: " + e.getMessage());
            return false;
        }
    }

    public static List<Treinadores> listarTreinadores() {
        List<Treinadores> lista = new ArrayList<>();
        String sql = "SELECT * FROM treinadores";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Treinadores t = new Treinadores();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setIdade(rs.getString("idade"));
                t.setTelefone(rs.getString("telefone"));
                t.setEmail(rs.getString("email"));
                t.setSenha(rs.getString("senha"));
                t.setEquipe(rs.getString("equipe"));
                
                lista.add(t);
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao listar treinadores: " + e.getMessage());
        }
        return lista;
    }
    public static void atualizarTreinador(Treinadores t) {
        String sql = "UPDATE treinadores SET nome=?, idade=?, telefone=?, email=?, equipe=? WHERE id=?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getIdade());
            stmt.setString(3, t.getTelefone());
            stmt.setString(4, t.getEmail());
            stmt.setString(5, t.getEquipe());
            stmt.setInt(6, t.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        }
    }

    public static void excluirTreinador(int id) {
        String sql = "DELETE FROM treinadores WHERE id = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
        }
        
}
public static void atualizarAtleta(Atletas atleta) {
        String sql = "UPDATE atletas SET nome=?, idade=?, peso=?, altura=?, pontos=?, rebotes=?, assistencias=?, telefone=?, time=?, camp_atual=? WHERE id=?";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, atleta.getNome());
            stmt.setInt(2, atleta.getIdade());
            stmt.setDouble(3, atleta.getPeso());
            stmt.setDouble(4, atleta.getAltura());
            stmt.setDouble(5, atleta.getPontos());
            stmt.setDouble(6, atleta.getRebotes());
            stmt.setDouble(7, atleta.getAssist());
            stmt.setString(8, atleta.getTelefone());
            stmt.setString(9, atleta.getTime());
            stmt.setString(10, atleta.getCamp_atual());
            stmt.setInt(11, atleta.getId()); 
            
            stmt.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(null, "Atleta atualizado com sucesso!");
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao atualizar atleta: " + e.getMessage());
        }
    }

    public static void excluirAtleta(int id) {
        String sql = "DELETE FROM atletas WHERE id = ?";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(null, "Atleta excluído com sucesso!");
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao excluir atleta: " + e.getMessage());
        }
    }

}
