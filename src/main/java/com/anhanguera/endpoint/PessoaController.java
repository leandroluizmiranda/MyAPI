package com.anhanguera.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.dao.PessoaDao;
import com.anhanguera.entity.PessoaEntity;
import com.anhanguera.request.SaudacaoRequest;

@RestController
@RequestMapping(value="/pessoa")
public class PessoaController {

	@Autowired
	PessoaDao dao;
	
	@RequestMapping(
			value="/list",
			method=RequestMethod.GET
	)
	public List<PessoaEntity> list(
			@RequestParam(
					value="idPessoa", defaultValue="0"
			) int id
	){
		
		return dao.list(id);
	}
	
	
	@RequestMapping(
			value="/insert",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json"
			)
	public PessoaEntity insert(@RequestBody PessoaEntity p){
		return dao.insert(p);
	}
	
	
}
