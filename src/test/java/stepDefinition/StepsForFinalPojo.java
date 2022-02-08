package stepDefinition;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.Given;

public class StepsForFinalPojo {

	private String companyName;
	private String companyHOCity;
	private String companyCEO;
	private List<String> supportedSalaryBanks;
	private List<Integer> pincodesOfCityOffice;
	private List<EmployeePojo> EmployeePojo;
	private List<ContractorPojo> ContractorPojo;
	private PfDetailsPojo PfDetailsPojo;
	
	
	
	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getCompanyHOCity() {
		return companyHOCity;
	}



	public void setCompanyHOCity(String companyHOCity) {
		this.companyHOCity = companyHOCity;
	}



	public String getCompanyCEO() {
		return companyCEO;
	}



	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}



	public List<String> getSupportedSalaryBanks() {
		return supportedSalaryBanks;
	}



	public void setSupportedSalaryBanks(List<String> supportedSalaryBanks) {
		this.supportedSalaryBanks = supportedSalaryBanks;
	}



	public List<Integer> getPincodesOfCityOffice() {
		return pincodesOfCityOffice;
	}



	public void setPincodesOfCityOffice(List<Integer> pincodesOfCityOffice) {
		this.pincodesOfCityOffice = pincodesOfCityOffice;
	}



	public List<EmployeePojo> getEmployeePojo() {
		return EmployeePojo;
	}



	public void setEmployeePojo(List<EmployeePojo> employeePojo) {
		EmployeePojo = employeePojo;
	}



	public List<ContractorPojo> getContractorPojo() {
		return ContractorPojo;
	}



	public void setContractorPojo(List<ContractorPojo> contractorPojo) {
		ContractorPojo = contractorPojo;
	}



	public PfDetailsPojo getPfDetailsPojo() {
		return PfDetailsPojo;
	}



	public void setPfDetailsPojo(PfDetailsPojo pfDetailsPojo) {
		PfDetailsPojo = pfDetailsPojo;
	}



	@Given("^user is hitting the given api$")
	public void user_is_hitting_the_given_api() throws Throwable {
		StepsForFinalPojo finalpojo=new StepsForFinalPojo(); 
		finalpojo.setCompanyName("MSE");
		finalpojo.setCompanyHOCity("Benagluru");
		finalpojo.setCompanyCEO("Amod");
		
		List<String> supp=new ArrayList<String>();
		supp.add("HDFC");
		supp.add("ICICI");
		supp.add("AXIS");
		
		finalpojo.setSupportedSalaryBanks(supp);
		
		List<Integer> pin=new ArrayList<Integer>();
		pin.add(560037);
		pin.add(360034);
		pin.add(456343);
		
		finalpojo.setPincodesOfCityOffice(pin);
		
		EmployeePojo emp=new EmployeePojo();
		emp.setFirstName("Amod");
		emp.setLastName("Mahajan");
		emp.setGender("Male");
		emp.setAge(28);
		emp.setSalary(10000.56);
		emp.setMarried("false");
		
		EmployeePojo emp1=new EmployeePojo();
		emp1.setFirstName("Amod");
		emp1.setLastName("Mahajan");
		emp1.setGender("Male");
		emp1.setAge(30);
		emp1.setSalary(10000.56);
		emp1.setMarried("false");
		
		EmployeePojo emp2=new EmployeePojo();
		emp2.setFirstName("Amod");
		emp2.setLastName("Mahajan");
		emp2.setGender("Male");
		emp2.setAge(26);
		emp2.setSalary(10000.56);
		emp2.setMarried("false");
		
		List<EmployeePojo> emplist =new ArrayList<EmployeePojo>();
		emplist.add(emp);
		emplist.add(emp1);
		emplist.add(emp2);
		finalpojo.setEmployeePojo(emplist);
		
		ContractorPojo con=new ContractorPojo();
		con.setFirstName("Seema");
		con.setLastName("Singh");
		con.setContractFrom("Jan-2019");
		con.setContractTo("JAN-2025");
		
		ContractorPojo con2=new ContractorPojo();
		con2.setFirstName("Hari");
		con2.setLastName("Prasad");
		con2.setContractFrom("Jan-2019");
		con2.setContractTo("JAN-2025");
		
		List<ContractorPojo> conlist =new ArrayList<ContractorPojo>();
		conlist.add(con);
		conlist.add(con2);
		finalpojo.setContractorPojo(conlist);
		
		PfDetailsPojo pf=new PfDetailsPojo();
		pf.setPfName("XYZ");
		pf.setPfCity("Benagluru");
		pf.setPfYear(2012);
		pf.setNoOfEmployees(10);
		
		finalpojo.setPfDetailsPojo(pf);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String nestedJsonPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(finalpojo);
		System.out.println(nestedJsonPayload);
	}

}
