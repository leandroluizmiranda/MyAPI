package com.anhanguera.endpoint;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.dao.PessoaDao;
import com.anhanguera.entity.PessoaEntity;

@RestController(value="/pessoa")
public class PessoaController {

	PessoaDao dao = new PessoaDao();
	
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
}
