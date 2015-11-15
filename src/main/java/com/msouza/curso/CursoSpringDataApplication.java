package com.msouza.curso;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.msouza.curso.entity.Address;
import com.msouza.curso.entity.Address.TypeAddres;
import com.msouza.curso.entity.Phone.TypePhone;
import com.msouza.curso.entity.Document;
import com.msouza.curso.entity.Person;
import com.msouza.curso.entity.Phone;
import com.msouza.curso.repository.AddressRepository;
import com.msouza.curso.repository.DocumentRepository;
import com.msouza.curso.repository.PersonRepository;
import com.msouza.curso.repository.PhoneRepository;

@SpringBootApplication
// @ImportResource(value = "spring-data.xml")
public class CursoSpringDataApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private PhoneRepository phoneRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringDataApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// testConfiguration();
		// testSave();
//		testUpdate();
		testDelete();
	}

	private void testDelete() {
		personRepository.delete(13L);
		
		Person person = personRepository.findOne(12L);
		personRepository.delete(person);
		
		
		
	}

	private void testUpdate() {
		Person person = personRepository.findOne(13L);
		System.out.println(person.toString());

		person.setLastName("Aguiar");
		personRepository.save(person);

		Person p2 = personRepository.findOne(13L);

		System.out.println(p2.toString());
		
		List<Person> persons = personRepository.findAll();
		persons.forEach(System.out::println);
	}

	private void testSave() {
		Person person = new Person();
		person.setFirstName("João Luiz");
		person.setLastName("Rios");
		person.setAge(35);
		person.setDocument(new Document("987.765.543-12", 890765431));

		Address address = new Address();
		address.setCity("Manaus");
		address.setStreet("Rua das Valquirias, 32");
		address.setType(TypeAddres.RESIDENCIAL);

		person.setAddresses(Arrays.asList(address));
		person.addPhone(new Phone(TypePhone.RESIDENCIAL, "12345678"));

		personRepository.save(person);

		Person p2 = personRepository.findOne(person.getId());
		System.out.println(p2.toString());
	}

	private void testConfiguration() {
		long total = personRepository.count();
		System.out.println("Total of persons " + total);

		List<Person> persons = personRepository.findAll();
		persons.forEach(System.out::println);

		long t2 = addressRepository.count();
		System.out.println("Total of addresses " + t2);

		long t3 = documentRepository.count();
		System.out.println("Total of documents " + t3);

		long t4 = phoneRepository.count();
		System.out.println("Total of phones " + t4);

	}
}
