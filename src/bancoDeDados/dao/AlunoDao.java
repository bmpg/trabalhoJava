package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import trabalhojavanp1.objetos.Aluno;

public class AlunoDao {

	private Connection connection;

	public AlunoDao() {
		this.connection = (Connection) new ConnectionFactory();
	}

	public void inserirAluno(Aluno aluno) throws SQLException {

		PreparedStatement query = this.connection
				.prepareStatement("INSERT INTO alunos(matricula, nome, endereco) VALUES(?, ?, ?)");
		query.setString(1, aluno.getMatricula());
		query.setString(2, aluno.getNome());
		query.setNString(3, aluno.getEndereco());
		
		query.execute();
		query.close();
		this.connection.close();
	}

	public void deletarAluno(Aluno aluno) throws SQLException {

		PreparedStatement query = this.connection
				.prepareStatement("DELETE FROM alunos WHERE matricula = ?");
		query.setString(1, aluno.getMatricula());
			
		query.execute();
		query.close();
		this.connection.close();
	}

	public void alterarAluno(Aluno aluno) throws SQLException {

		PreparedStatement query = this.connection
				.prepareStatement("UPDATE alunos SET nome = ?, endereco = ? WHERE matricula = ? ");
		query.setString(1, aluno.getNome());
		query.setString(2, aluno.getEndereco());
		query.setString(3, aluno.getMatricula());
		
		query.execute();
		query.close();
		this.connection.close();
	}

}
