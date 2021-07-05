package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLogoStepDefinition {


  WebDriver driver;
  
  @Before
  public void setUp() {
    
    String path = System.getProperty("user.dir"); 
    
    // to run on mac os
    System.setProperty("webdriver.chrome.driver",path+"/src/main/resources/chromedriver");
    
    // to run on windows
    // System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\chromedriver.exe");
  }
  
  @Given("user launches the browser")
  public void launch_the_browser() {
     
      this.driver = new ChromeDriver();
      
  }

  @When("user opens Google on browser")
  public void hit_Google_on_your_browser() {
      
    this.driver.get("http://google.com");
      System.out.println(this.driver.getTitle());
      
  }

  @Then("user searches for {string} in the search box")
  public void enter_in_the_search_text_box(String string) {
      
      this.driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("J. P. Morgan");
      this.driver.findElement(By.xpath("(//*[@name='btnK'])[2]")).click();
  }

  @Then("clicks on the first result")
  public void select_the_first_result() {
      WebDriverWait w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3")));
        this.driver.findElement(By.xpath("(//h3)[1]")).click();
  
  }
  @Then("J.P. Morgan official website should be launched")
  public void website_should_be_launched() {
      
      String expectedTitle = "J.P. Morgan | Official Website";
      String originalTitle = this.driver.getTitle();
      Assert.assertEquals(originalTitle, expectedTitle);
  }

  @Then("company logo should be displayed")
  public void company_logo_displayed() {
      
      WebElement logo = (WebElement) this.driver.findElement(By.xpath("(//*[@class='first-logo' and @alt='J.P. Morgan logo'])[1]"));
      
      // verify if the logo is rendered correctly
      Boolean logoPresent = (Boolean) ((JavascriptExecutor)this.driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logo);
      Assert.assertTrue(logoPresent);
  }

  @After
  public void tearDown() {
    this.driver.close();
  }
}
