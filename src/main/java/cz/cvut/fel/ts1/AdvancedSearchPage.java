package cz.cvut.fel.ts1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='all-words']")
    WebElement inputFindWithAllOfTheWords;

    @FindBy(xpath = "//*[@id='least-words']")
    WebElement inputFindWithAtLeastOneOfTheWords;

    @FindBy(xpath = "//*[@id='facet-start-year']")
    WebElement inputStartYear;

    @FindBy(xpath = "//*[@id='facet-end-year']")
    WebElement inputEndYear;

    @FindBy(xpath = "//*[@id='submit-advanced-search']")
    WebElement submitBtnAdvancedSearch;

    public AdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
