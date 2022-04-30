package cz.cvut.fel.ts1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpringerHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='search-options']/button")
    private WebElement btnSearchOption;

    @FindBy(xpath = "//*[@id='advanced-search-link']")
    private WebElement linkToAdvancedSearch;

    @FindBy(xpath = "//*[@id='header']/div[1]/div[1]/a")
    private WebElement linkToLogIn;

    public SpringerHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://link.springer.com/");
        PageFactory.initElements(driver, this);
    }

}
