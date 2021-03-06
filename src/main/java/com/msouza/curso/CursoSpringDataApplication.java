package com.msouza.curso;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.msouza.curso.entity.Address;
import com.msouza.curso.entity.Address.TypeAddres;
import com.msouza.curso.entity.Document;
import com.msouza.curso.entity.Person;
import com.msouza.curso.entity.Phone;
import com.msouza.curso.entity.Phone.TypePhone;
import com.msouza.curso.entity.User;
import com.msouza.curso.repository.AddressRepository;
import com.msouza.curso.repository.DocumentRepository;
import com.msouza.curso.repository.PersonRepository;
import com.msouza.curso.repository.PhoneRepository;
import com.msouza.curso.repository.UserRepository;

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
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringDataApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// testConfiguration();
		// testSave();
		// testUpdate();
		// testDelete();
		// testSavePersons();
		// testDeletePersons();
		// testFindAndSort();
		// testFindByIds();
		// testExists();
		// testPagination();
		// testByAge();
		// testByFistNameLike();
		// testByandOr();
		// testByBetween();
		// testByLastNameAndBetween();
		// testByGreaterAndLess();
		// testByGreaterAndLessEqual();
		// testByFistNameGreaterThan();
		// testByStartAndAnd();
		// testByContaining();
		// testByAddressStartingAndEnding();
		// findByInAndNotIn();
		// testByOrderBy();
		// testIgnoreCase();
		// testByNotNullAndNull();
		// testPhonesByNumber();
		// testFindByGreaterThanAndOrder();
		// findFirstName();
		// findFirstNameOrAge();
		// findFirstNameAndAge();
		// findPersonByCpfEndsWith();
		// findPersonByAges();
		// findPersonByNames();
		// findDocumentByCpfStart();
		// findAddressPorCidade();
		// findAddressPorEndereco();
		// testFunctioAddress();
//		testProcedureCPF();
//		updatePhones();
//		deletePhone();
//		findFisrtLastName();
//		findTopAge();
//		findFirst3AndTop3();
		testUser();
		

	}

	private void testUser() {

		User user = new User();
		user.setUsername("marcio@email.com");
		user.setPasword("lqwy23553");
		
		if(user.isNew()){
			userRepository.save(user);
		}
		
		User user2 = userRepository.findOne(user.getId());
		
		System.out.println(user2.toString());
	}
	

	private void findFirst3AndTop3() {
		List<Person> first3 = personRepository.findFirst3ByOrderByLastNameAsc();
		first3.forEach(System.out::println);
		
		List<Person> top3 = personRepository.findTop3ByOrderByAgeAsc();
		top3.forEach(System.out::println);
		
	}

	private void findTopAge() {
		Person p1 = personRepository.findTopByOrderByAgeAsc();
		System.out.println(p1);
		
		Person p2 = personRepository.findTopByOrderByAgeDesc();
		System.out.println(p2);
		
	}

	private void findFisrtLastName() {
	Person p1 = personRepository.findFirstByOrderByLastNameAsc();
	System.out.println(p1);
	
	Person p2 = personRepository.findFirstByOrderByLastNameDesc();
	System.out.println(p2);
		
	}

	private void deletePhone() {
		int result  = phoneRepository.deleteByPhoneNumber("4456735");
		System.out.println("Result = " + result);
		
	}

	private void updatePhones() {
//		int result = phoneRepository.setPhoneNumber("33339999", 1L);
//		System.out.println("Result = " + result);
		
		int result = phoneRepository.setPhoneNumber(TypePhone.RESIDENCIAL, 1L);
		System.out.println("Result = " + result);
		
	}

	private void testProcedureCPF() {
		String cpf1 = documentRepository.replaceCPF(2L);
		System.out.println("CPF 1 - " + cpf1.toString());

		String cpf2 = documentRepository.procedureReplaceCPF(5L);
		System.out.println("CPF 2 - " + cpf2.toString());

	}

	private void testFunctioAddress() {
		String ad1 = addressRepository.functionConcatenaEndereco(7L);
		System.out.println(ad1.toString());

		String ad2 = addressRepository.functionNativeQueryConcatenaEndereco(2L);
		System.out.println(ad2.toString());
	}

	private void findAddressPorEndereco() {
		Address a = addressRepository.buscarPorEndereco("Rio de Janeiro", "Av copa cabana, 102");
		System.out.println(a.toString());

		Address a2 = addressRepository.buscaPorCidadeRua("Rio de Janeiro", "Av Ipanema, 36");
		System.out.println(a2.toString());
	}

	private void findAddressPorCidade() {
		List<Address> a = addressRepository.buscaPorCidade("Rio de Janeiro");
		a.forEach(System.out::println);
	}

	private void findDocumentByCpfStart() {
		List<Document> documents = documentRepository.findByCpfStartWith("67");
		documents.forEach(System.out::println);
	}

	private void findPersonByNames() {
		List<Person> p1 = personRepository.findByFirstNames("Aline", "Gilson", "Juliano");
		p1.forEach(System.out::println);

	}

	private void findPersonByAges() {
		List<Person> p1 = personRepository.findByAgeBetween(28, 36);
		p1.forEach(System.out::println);

	}

	private void findPersonByCpfEndsWith() {
		List<Person> p1 = personRepository.findByDocumentCPFEndsWith("89");
		p1.forEach(System.out::println);

	}

	private void findFirstNameAndAge() {
		List<Person> p1 = personRepository.findByFirstNameAndAge("Aline", 36);
		p1.forEach(System.out::println);

	}

	private void findFirstNameOrAge() {
		List<Person> p1 = personRepository.findByFirstNameOrAge("Aline", 36);
		p1.forEach(System.out::println);

	}

	private void findFirstName() {
		List<Person> p1 = personRepository.findByFirstName("Aline");
		p1.forEach(System.out::println);

	}

	private void testFindByGreaterThanAndOrder() {
		List<Person> p1 = personRepository.findByAgeGreaterThanOrderByFirstNameAscLastNameAsc(22);
		p1.forEach(System.out::println);

	}

	private void testPhonesByNumber() {
		List<Person> p1 = personRepository.findByPhonesNumberStartingWith("4");
		p1.forEach(System.out::println);

	}

	private void testByNotNullAndNull() {
		List<Person> p1 = personRepository.findByDocumentIsNull();
		p1.forEach(System.out::println);

		System.out.println("=== === === === === === === ===");

		List<Person> p2 = personRepository.findByDocumentIsNotNull();
		p2.forEach(System.out::println);

	}

	private void testIgnoreCase() {
		List<Person> p1 = personRepository.findByFirstNameIgnoreCase("ALINE");
		p1.forEach(System.out::println);

	}

	private void testByOrderBy() {
		List<Address> a1 = addressRepository.findByCityOrderByTypeDesc("Rio de Janeiro");
		a1.forEach(System.out::println);

	}

	private void findByInAndNotIn() {
		List<Person> p1 = personRepository.findByAgeIn(24, 28, 36, 45);
		p1.forEach(System.out::println);

		System.out.println("=== === === === === === === j");

		List<Person> p2 = personRepository.findByAgeNotIn(24, 28, 36, 45);
		p2.forEach(System.out::println);
	}

	private void testByAddressStartingAndEnding() {
		List<Address> a1 = addressRepository.findByCityStartingWithOrStreetEndingWith("Rio", "102");
		a1.forEach(System.out::println);

	}

	private void testByContaining() {
		List<Address> a1 = addressRepository.findByStreetContaining("Ipanema");
		a1.forEach(System.out::println);

	}

	private void testByStartAndAnd() {
		List<Address> a1 = addressRepository.findByCityStartingWith("Rio");
		a1.forEach(System.out::println);
		System.out.println("=========================");
		List<Address> a2 = addressRepository.findByStreetEndingWith("102");
		a2.forEach(System.out::println);
	}

	private void testByFistNameGreaterThan() {
		List<Person> p1 = personRepository.findByFirstNameGreaterThan("J");
		p1.forEach(System.out::println);

	}

	private void testByGreaterAndLessEqual() {
		List<Person> p1 = personRepository.findByAgeGreaterThanEqual(28);
		p1.forEach(System.out::println);

		System.out.println("=========================");

		List<Person> p2 = personRepository.findByAgeLessThanEqual(29);
		p2.forEach(System.out::println);

	}

	private void testByGreaterAndLess() {
		List<Person> p1 = personRepository.findByAgeGreaterThan(28);
		p1.forEach(System.out::println);

		System.out.println("=========================");

		List<Person> p2 = personRepository.findByAgeLessThan(28);
		p2.forEach(System.out::println);

	}

	private void testByLastNameAndBetween() {
		List<Person> p1 = personRepository.findByLastNameAndAgeBetween("Figueira", 25, 36);
		p1.forEach(System.out::println);

	}

	private void testByBetween() {
		List<Person> p1 = personRepository.findByAgeBetween(24, 29);
		p1.forEach(System.out::println);

	}

	private void testByandOr() {
		Person p1 = personRepository.findByFirstNameAndLastName("Aline", "Gomes");
		System.out.println(p1.toString());
		System.out.println("=========================");

		List<Person> p2 = personRepository.findByAgeOrFirstName(36, "Bruna");
		p2.forEach(System.out::println);
	}

	private void testByFistNameLike() {
		List<Person> p1 = personRepository.findByFirstNameLike("Aline");
		p1.forEach(System.out::println);

		System.out.println("=========================");

		List<Person> p2 = personRepository.findByFirstNameNotLike("Aline");
		p2.forEach(System.out::println);

	}

	private void testByAge() {
		List<Person> p1 = personRepository.findByAge(36);
		p1.forEach(System.out::println);

		System.out.println("=========================");

		List<Person> p2 = personRepository.findByAgeNot(36);
		p2.forEach(System.out::println);

	}

	private void testPagination() {

		Page<Person> pages = personRepository.findAll(new PageRequest(0, 2));
		pages.getContent().forEach(System.out::println);

		pages = personRepository.findAll(new PageRequest(1, 2));
		pages.getContent().forEach(System.out::println);

		pages = personRepository.findAll(new PageRequest(2, 2));
		pages.getContent().forEach(System.out::println);

	}

	private void testExists() {
		boolean p1 = personRepository.exists(5L);
		System.out.println("P1 is " + p1);

		boolean p2 = personRepository.exists(50L);
		System.out.println("P2 is " + p2);

	}

	private void testFindByIds() {
		List<Person> persons = personRepository.findAll(Arrays.asList(1L, 5L, 2L, 6L));
		persons.forEach(System.out::println);
	}

	private void testFindAndSort() {
		Order orderAsc = new Order(Direction.ASC, "lastName");

		Order orderDesc = new Order(Direction.ASC, "firstName");
		Sort sort = new Sort(orderAsc, orderDesc);
		List<Person> persons = personRepository.findAll(sort);

		persons.forEach(System.out::println);

	}

	private void testDeletePersons() {
		Person p1 = personRepository.findOne(14L);
		Person p2 = personRepository.findOne(15L);
		Person p3 = personRepository.findOne(16L);

		personRepository.delete(Arrays.asList(p1, p2, p3));

		System.out.println("========================================");

		Person p4 = personRepository.findOne(17L);
		Person p5 = personRepository.findOne(18L);
		Person p6 = personRepository.findOne(19L);

		personRepository.deleteInBatch(Arrays.asList(p4, p5, p6));
	}

	private void testSavePersons() {
		Person p1 = new Person();
		p1.setFirstName("Bruno");
		p1.setLastName("Pereira de Melo");
		p1.setAge(63);
		p1.setDocument(new Document("751.467.964-00", 345444249));

		Person p2 = new Person();
		p2.setFirstName("Alison");
		p2.setLastName("Souza do caralho");
		p2.setAge(25);
		p2.setDocument(new Document("741.467.800-65", 345680000));

		Person p3 = new Person();
		p3.setFirstName("Carlos Ricardo");
		p3.setLastName("Pereira");
		p3.setAge(45);
		p3.setDocument(new Document("743.467.111-75", 34555555));

		Person p4 = new Person();
		p4.setFirstName("Fábio");
		p4.setLastName("Guimarães");
		p4.setAge(25);
		p4.setDocument(new Document("711.467.444-90", 34113249));

		Person p5 = new Person();
		p5.setFirstName("Vinícius");
		p5.setLastName("Pereira");
		p5.setAge(25);
		p5.setDocument(new Document("741.467.333-33", 345683233));

		Person p6 = new Person();
		p6.setFirstName("Carla");
		p6.setLastName("Hibas");
		p6.setAge(28);
		p6.setDocument(new Document("331.467.222-65", 333383249));

		List<Person> persons = personRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6));

		persons.forEach(System.out::println);
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
