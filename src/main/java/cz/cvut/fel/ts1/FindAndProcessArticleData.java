package cz.cvut.fel.ts1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class FindAndProcessArticleData {

    public ArrayList<String> articleNames;
    public ArrayList<String> articleDoiUrls;
    public ArrayList<String> articleDate;

    public FindAndProcessArticleData() {
        articleNames = new ArrayList<>();
        articleDoiUrls = new ArrayList<>();
        articleDate = new ArrayList<>();
    }

    public void startPagesProcessing() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/Imcheldon/Documents/JAVAPROJECTY/TESTOVANISOFT/chromedriver");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        // open home page and go to advanced search
        Thread.sleep(1000);
        homePage.acceptCOOOOOOCKIE.click();
        homePage.btnSearchOption.click();
        homePage.linkToAdvancedSearch.click();

        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);
        Thread.sleep(1000);
        //config search

        advancedSearchPage.inputFindWithAllOfTheWords.sendKeys("Page Object Model");
        advancedSearchPage.inputFindWithAtLeastOneOfTheWords.sendKeys("Sellenium Testing");
        advancedSearchPage.inputStartYear.sendKeys("2022");
        advancedSearchPage.inputEndYear.sendKeys("2022");

        Thread.sleep(1000);

        advancedSearchPage.submitBtnAdvancedSearch.click();


        Thread.sleep(1000);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Thread.sleep(1000);
        //select only articles
        searchResultPage.selectContentTypeArticle.click();
        Thread.sleep(1000);

        ArticlePage articlePage = new ArticlePage(driver);

        //process articles
        for (int i = 0; i < searchResultPage.linksToArticles.size(); i++) {
            searchResultPage.linksToArticles.get(i).click();
            Thread.sleep(1000);
            articleNames.add(articlePage.articleTitle.getAttribute("innerHTML"));
            articleDoiUrls.add(articlePage.doiUrl.getAttribute("innerHTML"));
            articleDate.add(articlePage.publishDate.getAttribute("innerHTML"));
            driver.navigate().back();
            Thread.sleep(1000);
        }

        driver.quit();
    }
}
