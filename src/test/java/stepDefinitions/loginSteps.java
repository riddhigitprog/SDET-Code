package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class loginSteps {
	WebDriver driver;
	@Given("login application should be launched")
	public void login_application_should_be_launched() {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\RiddhimanDe\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	  driver = new EdgeDriver();
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	  driver.manage().window().maximize();	  
	    System.out.println("precondition");
	    
	}

	@When("Enter Name,pwd and click submit")
	public void enter_name_pwd_and_click_submit() {
	   driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	   driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	   driver.findElement(By.id("btnLogin")).click();
	    System.out.println("login credentials");
	}

	@Then("login should be successful")
	public void login_should_be_successful() throws InterruptedException {
	  String user = driver.findElement(By.xpath("//a[text()='Welcome Linda']")).getText();
	  Assert.assertEquals("Welcome Linda", user);
	  driver.findElement(By.xpath("//a[text()='Welcome Linda']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[text()='Logout']")).click();
	  driver.close();
	  driver.quit();
	    System.out.println("Test Success");
	}

}
