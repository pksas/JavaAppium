package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

public class MVSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_TEXT_CLEAR_BUTTON = "css:button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text,'{TITLE}')]/..//*[contains(@text,'{DESCRIPTION}')]";
        SEARCH_PLATE_ELEMENT = "id:org.wikipedia:id/search_src_text";

        TITLES_AND_DESCRIPTIONS = new HashMap<>();
        TITLES_AND_DESCRIPTIONS.put("Best", "Wikimedia disambiguation page");
        TITLES_AND_DESCRIPTIONS.put("Best Buy", "Consumer electronics retailer");
        TITLES_AND_DESCRIPTIONS.put("Best of the Super Juniors", "NJPW tournament");
    }

    public MVSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
