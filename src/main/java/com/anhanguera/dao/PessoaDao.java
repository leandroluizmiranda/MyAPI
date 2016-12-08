package com.anhanguera.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.anhanguera.dao.mapper.PessoaMapper;
import com.anhanguera.entity.PessoaEntity;

@Repository
public class PessoaDao extends BaseDao{

	private String tableName = "Pessoa";
	private String primaryKey = "idPessoa";
	private ArrayList<String> columns = new ArrayList<String>();
	
	public PessoaDao(){
		columns.add("nome");
		columns.add("idade");
	}
	
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
	
	public PessoaEntity insert(PessoaEntity p){
		
		SimpleJdbcInsert i = new SimpleJdbcInsert(jdbcTemplate);
		i.setTableName(tableName);
		i.setColumnNames(columns);
		i.setGeneratedKeyName(primaryKey);
		
		Number key = i.executeAndReturnKey(new BeanPropertySqlParameterSource(p));
		
		p.setIdPessoa(key.intValue());
				
		return p;
	}
	// delete id
	public boolean delete(int id){
		
		jdbcTemplate.update("delete from "+tableName+ " where " +primaryKey+" = ?",id);
		return true;
		
	}// update
	
	public PessoaEntity update(int id,PessoaEntity p){
		
		
	String sql = "UPDATE "+tableName+" set "+columns.get(0)+" =?,"+columns.get(1)+" =? where "+primaryKey+" =?";
	jdbcTemplate.update(sql, p.getNome(),p.getIdade(),id);
	
	p.setIdPessoa(id);
	return p;
		
		
		
		
		
		
	}
	
	
	
	
	
}
