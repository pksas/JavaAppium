package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MVArticlePageObject extends ArticlePageObject
{
    static
    {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTiONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#page-actions-watch";
        CLOSE_ARTICLE_BUTTON = "css:div.branding-box";
//        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
//        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
//        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
//        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
//        SEARCH_BUTTON = "xpath://android.widget.TextView[@content-desc='Search Wikipedia']";
//        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
    }

    public MVArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
