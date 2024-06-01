// BIBLIOTECAS
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// CLASSE
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Teste de Login")
public class EstudoTest {

    // ATRIBUTOS
    private static WebDriver driver;

    // ANTES DO TESTE
    @BeforeAll
    public static void setUp() {
    WebDriverManager.chromedriver().setup();
    //WebDriverManager.firefoxdriver().setup();
    //WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    public void padraoCarregamento() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://front.serverest.dev/login");
    }

    // DEPOIS DO TESTE
    @AfterEach
    public void tearDown() {
          driver.quit();
    }

    @Test
    @Order(1)
    @DisplayName("Teste realizado no caminho feliz com sucesso")
    public void testCadastroSimplesComDadosValidos() {
        assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.id("nome")).sendKeys("ulisses52");
        driver.findElement(By.id("email")).sendKeys("ulisses52@uol.com.br");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("administrador")).click();
        assertEquals("Cadastrar", driver.findElement(By.cssSelector(".btn-primary")).getText(), "Texto esperado 'Cadastrar', mas foi exibido outro texto.");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertEquals("Cadastro realizado com sucesso", driver.findElement(By.cssSelector("a.alert-link")).getText(), "Texto esperado 'Cadastro realizado com sucesso', mas foi exibido outro texto");
    }

    @Test
    @Order(2)
    @DisplayName("Teste realizado com mensagem pra email ja existente")
    public void testCadastroComDadosJaUtilizados() {
        assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();
        driver.findElement(By.id("nome")).sendKeys("ulisses52");
        driver.findElement(By.id("email")).sendKeys("ulisses52@uol.com.br");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("administrador")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertEquals("Este email já está sendo usado", driver.findElement(By.cssSelector("div.alert.alert-secondary.alert-dismissible > span")).getText(), "Texto esperado 'Este email já está sendo usado', mas foi exibido outro texto");
    }

    @Test
    @Order(3)
    @DisplayName("Teste realizado com Login ja cadastrado")
    public void testLoginCaminhoFeliz() {
        driver.findElement(By.id("email")).sendKeys("ulisses52@uol.com.br");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.cssSelector("[data-testid='entrar']")).click();
        assertEquals("Este é seu sistema para administrar seu ecommerce.", driver.findElement(By.cssSelector("p.lead")).getText(), "Texto esperado 'Este é seu sistema para administrar seu ecommerce.', mas foi exibido outro texto");
    }

    @Test
    @Order(4)
    @DisplayName("Teste realizado com Login de usuario não cadastrado")
    public void testLoginDadosInvalidos() {
        driver.findElement(By.id("email")).sendKeys("ulisses52@uol.com.br");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.cssSelector("[data-testid='entrar']")).click();
    }
}