package com.anhanguera.dao;

import java.util.ArrayList;

import com.anhanguera.entity.PessoaEntity;

public class PessoaDao {

	private String tableName = "Pessoa";
	private String primaryKey = "idPessoa";
	
	public ArrayList<PessoaEntity> list(int id){
		String sql = "SELECT * FROM " + tableName + " ";
		
		if (id != 0)
			sql += " WHERE " + primaryKey + "=?";
		
		System.out.println(sql);
		//Vai no banco e retorna a lista
		
		return new ArrayList<PessoaEntity>();
	}
}
