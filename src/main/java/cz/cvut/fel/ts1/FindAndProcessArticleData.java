package cz.cvut.fel.ts1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAndProcessArticleDate {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/Imcheldon/Documents/JAVAPROJECTY/TESTOVANISOFT/chromedriver");
        WebDriver driver = new ChromeDriver();

        HomePage homePage = new HomePage(driver);

        homePage.btnSearchOption.click();
        homePage.linkToAdvancedSearch.click();

        Thread.sleep(2000);
        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);

        advancedSearchPage.inputFindWithAllOfTheWords.sendKeys("Page Object Model");
        advancedSearchPage.inputFindWithAtLeastOneOfTheWords.sendKeys("Sellenium Testing");
        advancedSearchPage.inputStartYear.sendKeys("2022");
        advancedSearchPage.inputEndYear.sendKeys("2022");

        Thread.sleep(2000);
        advancedSearchPage.submitBtnAdvancedSearch.click();


        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.selectContentTypeArticle.click();

        Thread.sleep(2000);
        

    }
}
