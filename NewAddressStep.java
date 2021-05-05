package bdd.zadanieZaliczeniowe;
// ZADANIE 1
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class NewAddressStep {

    private WebDriver driver;

    @Given("^user is logged in$")
    public void userIsLoggedIn() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("jdoe@ijnm.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("qwerty");

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"submit-login\"]"));
        signInButton.click();
    }

    @When("^user is on New Address Page$")
    public void userIsOnNewAddressPage() {
        WebElement addressesPage = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span"));
        addressesPage.click();

        WebElement createNewAddressButton = driver.findElement(By.cssSelector("#content > div.addresses-footer > a > i"));
        createNewAddressButton.click();
    }

    @And("^user added \\\"([^\\\"]*)\\\", \\\"([^\\\"]*)\\\", \\\"([^\\\"]*)\\\", \\\"([^\\\"]*)\\\" and \\\"([^\\\"]*)\\\"$")
    public void userAddedAliasAddressCityZipAndPhone(String alias, String address, String city, String zip, String phone) {

        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.sendKeys(alias);

        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.sendKeys(address);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(city);

        WebElement zipInput = driver.findElement(By.name("postcode"));
        zipInput.sendKeys(zip);

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys(phone);
    }

    @And("^user saves new address$")
    public void userSavesNewAddress() {

        WebElement saveButton = driver.findElement(By.cssSelector("#content button"));
        saveButton.click();
    }

    @Then("^data checking$")
    public void dataChecking() {

        List<WebElement> addressElements = driver.findElements(By.tagName("article"));
        WebElement lastaddress = addressElements.get(addressElements.size() - 1);
        System.out.println(lastaddress.getText());
    }
}