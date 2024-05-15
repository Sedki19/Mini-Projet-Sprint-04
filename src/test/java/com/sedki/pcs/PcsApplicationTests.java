package com.sedki.pcs;



import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.sedki.pcs.entities.Pc;
import com.sedki.pcs.repos.PcRepository;
import com.sedki.pcs.service.PcService;


@SpringBootTest
class PcsApplicationTests {

	@Autowired
	private PcRepository PcRepository;
	
	
	@Autowired
	PcService PcService;
	
	  @Test
		public void testFindByNomPcContains()
		 {
		
			Page<Pc>  prods = PcService.getAllPcsParPage(0,2);
			System.out.println(prods.getSize());
			System.out.println(prods.getTotalElements());
			System.out.println(prods.getTotalPages());
			
			prods.getContent().forEach(p -> {System.out.println(p.toString());
			                                 });	
			/*ou bien
			 for (Pc p : prods)
			{
				System.out.println(p);
			} */
		 }

	
	/*
	@Test
	public void testCreatePc() {
	Pc prod = new Pc("PC Asus",1500.500,new Date());
	PcRepository.save(prod);
	}
	
	@Test
	public void testFindPc()
	{
	Pc p = PcRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdatePc()
	{
	Pc p = PcRepository.findById(1L).get();
	p.setPrixPc(2000.0);
	PcRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeletePc()
	{
		PcRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllPcs()
	{
		List<Pc> prods = PcRepository.findAll();
		
		for (Pc p:prods)
			 System.out.println(p);
		
	}
	*/
	
	
	
}
