//// Generated by Selenium IDE
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.JavascriptExecutor;
//
//import java.util.*;
//
//public class TestCadastroTest {
//  private WebDriver driver;
//  private Map<String, Object> vars;
//  JavascriptExecutor js;
//  @Before
//  public void setUp() {
//    driver = new ChromeDriver();
//    js = (JavascriptExecutor) driver;
//    vars = new HashMap<String, Object>();
//  }
//  @After
//  public void tearDown() {
//    driver.quit();
//  }
//  @Test
//  public void testCadastro() {
//    driver.get("https://front.serverest.dev/login");
//    driver.manage().window().setSize(new Dimension(1552, 880));
//    assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
//    driver.findElement(By.linkText("Cadastre-se")).click();
//    driver.findElement(By.id("nome")).click();
//    driver.findElement(By.id("nome")).sendKeys("Ulisses895");
//    driver.findElement(By.id("email")).sendKeys("evertont@uol.com.br");
//    driver.findElement(By.id("password")).sendKeys("12346");
//    driver.findElement(By.id("administrador")).click();
//    assertThat(driver.findElement(By.cssSelector(".btn-primary")).getText(), is("Cadastrar"));
//    driver.findElement(By.cssSelector(".btn-primary")).click();
//    driver.findElement(By.cssSelector(".btn-primary")).click();
//    assertThat(driver.findElement(By.cssSelector(".lead")).getText(), is("Este é seu sistema para administrar seu ecommerce."));
//  }
//}