package com.example.Osoitemuistio;


	import static org.assertj.core.api.Assertions.assertThat;

	import java.util.List;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
	import org.springframework.test.context.junit4.SpringRunner;


	@RunWith(SpringRunner.class)
	@DataJpaTest
	public class OsoitemuistioRepoTests {

	    @Autowired
	    private YhteystietoRepository repository;
	    
	    @Autowired
	    private UserRepository userrepository;

	    @Test
	    public void findBySukunimiShouldReturnYhteystieto() {
	        List<Yhteystieto> yhteystiedot = repository.findBySukunimi("Kissa");
	        
	        assertThat(yhteystiedot).hasSize(1);
	        assertThat(yhteystiedot.get(0).getEtunimi()).isEqualTo("Bruno");
	    }
	    
	    @Test
	    public void createNewYhteystieto() {
	    	Yhteystieto yhteystieto = new Yhteystieto("Mikki", "Hiiri", "Hiirenkolo 2", "00190", "Ankkalinna", "02 357975");
	    	repository.save(yhteystieto);
	    	assertThat(yhteystieto.getId()).isNotNull();
	    }    
	    
	    @Test
	    public void deleteYhteystieto() {
	    	repository.deleteById((long) 1);
	    	List<Yhteystieto> yhteystiedot = repository.findBySukunimi("Kovaljeff");       
	        assertThat(yhteystiedot).hasSize(0);

	    }

	    @Test
	    public void createNewUser() {
	    	User user = new User("Millamagia", "$2a$10$0Oxiq6Rhph1QMufpASBMV.ANthdkAWy5hf5SLGXEtgFsg/0U4sZpq", "USER");
	    	userrepository.save(user);
	    	assertThat(user.getId()).isNotNull();
	    }    
	    
}
	    
	    
	
