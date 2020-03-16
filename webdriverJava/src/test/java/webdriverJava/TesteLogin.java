package webdriverJava;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class TesteLogin {
	
	private WebDriver driver;

	@Before
	public void SetUp () {
		driver = GerenciandoChrome.AbrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	@Test
	public void TesteLoginSemSucesso () {
		PaginaInicial paginaInicial = new PaginaInicial(driver);
		paginaInicial.PreencherLogin("victor", "12345");
		assertEquals("Incorrect user name or password.", paginaInicial.EsperarPorMensagemDeValidacao());
	}
	
	//@Test
	public void PesquisaPelaLupa () {
		driver.findElement(By.id("menuSearch")).click();
		driver.findElement(By.id("autoComplete")).sendKeys("Mouse");
		driver.findElement(By.id("autoComplete")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='autoCompleteCover']//div//img")).click();
		driver.findElement(By.xpath("//a[contains(text(),'HP USB 3 Button Optical Mouse')]")).click();
	}
	
	//@After
	public void tearDown () {
		GerenciandoChrome.FecharChrome();
	}
	
}