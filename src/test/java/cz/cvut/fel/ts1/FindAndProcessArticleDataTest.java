package cz.cvut.fel.ts1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalIterator{
    static int globalIterator = 0;
}



public class FindAndProcessArticleDataTest {
    private static FindAndProcessArticleData findAndProcessArticleData;

    WebDriver driver;


    @BeforeMethod
    private static Stream<String> singleArguments() throws InterruptedException {
        findAndProcessArticleData = new FindAndProcessArticleData();
        findAndProcessArticleData.startPagesProcessing();
        return Stream.of(findAndProcessArticleData.articleNames.get(0),
                findAndProcessArticleData.articleNames.get(1),
                findAndProcessArticleData.articleNames.get(2),
                findAndProcessArticleData.articleNames.get(3));
    }



    @ParameterizedTest()
    @MethodSource("singleArguments")
    void checkIfProcessArticleDataIsCorrect(String name) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/Imcheldon/Documents/JAVAPROJECTY/TESTOVANISOFT/chromedriver");
        driver = new ChromeDriver();
        HomePage homePage;
        homePage = new HomePage(driver);
        homePage.acceptCOOOOOOCKIE.click();
        homePage.linkToLogIn.click();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);
        signUpLoginPage.inputLoginEmail.sendKeys("imcheldon23@yandex.ru");
        signUpLoginPage.inputLoginPass.sendKeys("14532sss");
        signUpLoginPage.btnLogIn.click();
        Thread.sleep(2000);

        homePage.inputSearchText.sendKeys(name);
        homePage.searchBtn.click();
        Thread.sleep(1000);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.linkToFirstArticle.click();

        Thread.sleep(1000);
        ArticlePage articlePage = new ArticlePage(driver);
        assertEquals(findAndProcessArticleData.articleDate.get(GlobalIterator.globalIterator), articlePage.publishDate.getAttribute("innerHTML"));
        assertEquals(findAndProcessArticleData.articleDoiUrls.get(GlobalIterator.globalIterator), articlePage.doiUrl.getAttribute("innerHTML"));
        GlobalIterator.globalIterator++;
        Thread.sleep(1000);
        driver.quit();
    }

}
