package me.repizelogin.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;

public class Conexao {
	
	public static Connection con = null;
	
	public static void open() {
		
		String url = "jdbc:mysql://144.217.170.82:3306/s391_VOKEPVP";
		String user = "u391_rpz9PWe24P";
		String pass = "7r5gWD183PZJQj9uDpF1UTs4";
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			Bukkit.getConsoleSender().sendMessage("�a[REPIZE] Login MySQL (Conectado)!");
			tabela();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("�c[REPIZE] Nao foi possivel se conectar ao login MySQL.");
		}
 	}
	
	private static void tabela() {
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("create table if not exists logins(UUID varchar(64), senha varchar(16))");
			Bukkit.getConsoleSender().sendMessage("�a[REPIZE] �aTabela criada com sucesso. (Login)");
			stm.executeUpdate();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("�c[REPIZE] Nao foi possivel criar a tabela. (Login)");
		}
	}
	
}
