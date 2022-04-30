package cz.cvut.fel.ts1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='search-options']/button")
    WebElement btnSearchOption;

    @FindBy(xpath = "//*[@id='advanced-search-link']")
    WebElement linkToAdvancedSearch;

    @FindBy(xpath = "//*[@id='header']/div[1]/div[1]/a")
    WebElement linkToLogIn;

    @FindBy(xpath = "/html/body/section/div/div[2]/button[1]")
    WebElement acceptCOOOOOOCKIE;


    @FindBy(xpath = "//*[@id='search']")
    WebElement searchBtn;

    @FindBy(xpath = "//*[@id='query']")
    WebElement inputSearchText;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://link.springer.com/");
        PageFactory.initElements(driver, this);
    }

}
