package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosArticlePageObject extends ArticlePageObject
{
    static
    {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTiONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        GO_TO_MAIN_PAGE_BUTTON = "id:W";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        SEARCH_BUTTON = "id:Search Wikipedia";
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        NAVIGATION_BAR = "xpath://XCUIElementTypeNavigationBar";
    }

    public IosArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
