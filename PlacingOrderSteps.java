package bdd.zadanieZaliczeniowe;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class PlacingOrderSteps {

    private WebDriver driver;

    @Given("^user is logged$")
    public void userIsLogged() {
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

    @When("^the user searches for a product Hummingbird Printed Sweater on the website$")
    public void theUserSearchesForAProductHummingbirdPrintedSweaterOnTheWebsite() {
        WebElement searchField = driver.findElement(By.name("s"));
        searchField.sendKeys("Hummingbird Printed Sweater");
        searchField.submit();
    }

    @And("^user is on product site$")
    public void userIsOnProductSite() {
        WebElement productPage = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/a/img"));
        productPage.click();
    }

    @And("^user selects size L$")
    public void userSelectsSizeL() {
        WebElement selectSizeButton = driver.findElement(By.name("group[1]"));
        selectSizeButton.sendKeys("L");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^user selects five pieces$")
    public void userSelectsFivePieces() {
        WebElement quantityBox = driver.findElement(By.name("qty"));
        quantityBox.clear();
        quantityBox.sendKeys("5");
    }

    @And("^user adds products to the cart$")
    public void userAddsProductsToTheCart() {
        WebElement addToTheCartButton = driver.findElement(By.cssSelector("[data-button-action='add-to-cart']"));
        addToTheCartButton.click();
    }

    @And("^user chooses checkout$")
    public void userChoosesCheckout() {
        WebElement checkoutButton = driver.findElement(By.cssSelector("#blockcart-modal a"));
        checkoutButton.click();
        WebElement proceedToCheckOut = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]"));
        proceedToCheckOut.click();
    }

    @And("^user submit shipping address$")
    public void userSubmitShippingAddress() {

        WebElement addressButton = driver.findElement(By.name("id_address_delivery"));
        addressButton.submit();

    }

    @And("^user clicks Continue button$")
    public void userClicksContinueButton() {

        WebElement continueButton = driver.findElement(By.name("confirm-addresses"));
        continueButton.click();
    }

    @And("^user choose PrestaShop pick up in-store shipiing method$")
    public void userChoosePrestaShopPickUpInStoreShipiingMethod() {

        WebElement confirmButton = driver.findElement(By.name("confirmDeliveryOption"));
        confirmButton.click();
    }

    @And("^user choose Pay by Check$")
    public void userChoosePayByCheck() {

        WebElement paymentMethodButton = driver.findElement(By.name("payment-option"));
        paymentMethodButton.click();
    }

    @And("^user choose to accept the regulations$")
    public void userChooseToAcceptTheRegulations() {

        WebElement regulationsBox = driver.findElement(By.name("conditions_to_approve[terms-and-conditions]"));
        regulationsBox.click();
    }

    @And("^user clicks order with an obligation to pay$")
    public void userClicksOrderWithAnObligationToPay() {

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        submitButton.click();
    }

    @Then("^user takes a screenshot$")
    public void userTakesAScreenshot() throws IOException {


        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D://Klaudia//Tester//TESTER AUTO//FullPageScreenshot.png"));

    }
}





