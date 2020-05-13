package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosMyListsPageObject extends MyListsPageObject
{
    static
    {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]";
        SYNC_YOUR_SAVED_ARTICLES_QUESTION_WINDOW_CLOSE_BUTTON = "id:Close";
        SWIPE_ACTION_DELETE_BUTTON = "id:swipe action delete";
    }

    public IosMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
