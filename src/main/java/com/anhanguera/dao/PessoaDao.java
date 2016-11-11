package com.anhanguera.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.anhanguera.dao.mapper.PessoaMapper;
import com.anhanguera.entity.PessoaEntity;

@Repository
public class PessoaDao extends BaseDao{

	private String tableName = "Pessoa";
	private String primaryKey = "idPessoa";
	
	public List<PessoaEntity> list(int id){
		List<PessoaEntity> result = new  ArrayList<PessoaEntity>();
		String sql = "SELECT * FROM " + tableName + " ";
		
		if (id == 0){
			result = jdbcTemplate.query(sql, new PessoaMapper());
		}else{
			sql += " WHERE " + primaryKey + "=?";
			result = jdbcTemplate.query(sql, new PessoaMapper(), id);
		}
		
		return result;
	}
}
