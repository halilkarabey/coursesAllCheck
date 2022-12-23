package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Checked extends BasePage{
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[.='Campaigns']")
    public WebElement campaigns;

    @FindBy(xpath = "//span[.='Courses']")
    public WebElement coursesButton;

    @FindBy(xpath = "//div[.='Load More']")
    public WebElement loadMoreButton;

    @FindBy(xpath = "//div[@class='card card2 surveyHomeGridItem m-0']")
    public List<WebElement> coursesSize;

    @FindBy(xpath = "(//a[.='Courses'])[1]")
    public WebElement courses;

    @FindBy(xpath = "//button[@aria-label='View more courses']")
    public WebElement buttonMoreLeo;

    @FindBy(xpath = "//div[.='Published']//..//..//..//..//div[contains(@class,'coursesHomeGridItem_Title')]")
    public List<WebElement> published;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-8c9258ce-0 flVutI MbXXh']//div[@data-portal-key='portal']//div[@class='sc-18ecabe2-0 sc-41cd1401-0 fYExGP itzDnN']")
    public List<WebElement>leoCourses;
//relatedCourses
    @FindBy(xpath = "//div[@class='card-heading']//..//..//div[@class='row']/div//div[@class='font-weight-bold line-clamp-2 secondary-color']")
    public List<WebElement>relatedCoursesAtCrm;

    @FindBy(xpath = "//h2[.='Related Courses']//../div/div//a//div[@class='sc-18ecabe2-0 sc-41cd1401-0 fYExGP itzDnN']")
    public List<WebElement>relatedCoursesAtLeo;
    @FindBy(xpath = "//h5/span")
    public WebElement nameOfCourse;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-41cd1401-0 gBSqXX jQsmDG']")
    public WebElement nameOfCourseAtLeo;

//PM
@FindBy(xpath = "//h3[.='Project Manager']//..//..//div[3]//span[2]")
public WebElement pmName;

    @FindBy(xpath = "//h3[.='Project Manager']//..//..//div[4]//span[2]")
    public WebElement pmEmail;

    @FindBy(xpath = "//h3[.='Project Manager']//..//..//div[5]//span[2]")
    public WebElement pmPhone;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 ikmWil fCWyKC']//div[@font-weight]")
    public WebElement pmNameOfMentor;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 ikmWil fCWyKC']//a[@aria-label='Send email']")
    public WebElement pmEmailLeo;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 ikmWil fCWyKC']//a[@aria-label='Contact']")
    public WebElement pmPhoneNumber;
//price
@FindBy(xpath = "//a[.='View All']")
public WebElement viewAll;

    @FindBy(xpath = "//td[@class='type table-value']")
    public List<WebElement> cellValue;

    @FindBy(xpath = "//h3[.='Price']//..//../div[2]//span[2]")
    public WebElement lvtPrice;

    @FindBy(xpath = "//h3[.='Price']//..//../div[2]//div[2]//span[2]")
    public WebElement face2FacePrice;

    @FindBy(xpath = "//span[.='Public']")
    public WebElement sessionPublic;

    @FindBy(xpath = "//span[.='LVT Public']")
    public WebElement sessionLvtPublic;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 kUTSms fCWyKC']/div[1]")
    public WebElement live;

    @FindBy(xpath = "//label")
    public List<WebElement> amountOfLeoCourses;
    @FindBy(xpath = "//button[@aria-label='Add to Cart Button']")
    public WebElement addToChart;
    @FindBy(xpath = "(//div[@class='sc-18ecabe2-0 jgezdZ sc-62e99d6a-0 cJEUGn'])[1]")
    public WebElement priceLvtLeo;
    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 cgxVwc closeDrawer']")
    public WebElement close;
    @FindBy(css = ".dEsIho")
    public WebElement delete;
    @FindBy(xpath = "(//a[@aria-label='to Cart'])[2]")
    public WebElement chart;
    @FindBy(xpath = "(//div[@class='sc-18ecabe2-0 jgezdZ sc-62e99d6a-0 cJEUGn'])[1]")
    public WebElement priceFace2FaceLeo;
    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 kUTSms fCWyKC']/div[2]")
    public WebElement faceToFace;
//academyName
@FindBy(xpath = "//figcaption")
public WebElement academyNameAtCrm;

    @FindBy(xpath = "//div[@class='sc-18ecabe2-0 dYMxHk']")
    public WebElement academyNameAtLeo;

    //overview

    @FindBy(xpath = "//div[@class='color-secondary mobile-small-text']")
    public WebElement overviewCrm;

    @FindBy(xpath = "//h2[.='Course Overview']//..//div")
    public WebElement overview;
 //takeAway
    @FindBy(xpath = "//h3[.='Key Takeaways']//..//..//ol//li")
    public List<WebElement>listTakeAway;

    @FindBy(xpath = "//h2[.='Key Takeaways']//..//..//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 hIEOve fCWyKC']")
    public List<WebElement>listTakeAwayLeo;
//courseOutline
@FindBy(xpath = "//div[.='Course Outlines']//..//div[@class='row']//a")
public List<WebElement>outlineDay;
    @FindBy(xpath = "//div[@class='tab-content']//div[@class='fade tab-pane active show']//button")
    public List<WebElement>buttons;
    @FindBy(xpath = "//div[.='Course Outlines']//..//div[@class='collapse show']")
    public WebElement ıntro;
    @FindBy(xpath = "//button[@aria-label='Show Button']")
    public WebElement viewMore;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailForOutline;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordForOutline;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sıgnIn;
    @FindBy(xpath = "//div[.='Course Outline']//..//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 sc-febde211-1 llIKEG fCWyKC hdjeYz']//div[@role='button']")
    public List<WebElement>buttonsLeo;

    @FindBy(xpath = "//div[.='Course Outline']//..//div[@class='sc-18ecabe2-0 sc-18ecabe2-1 dMSZwf fCWyKC']//div[@class='sc-18ecabe2-0 ctnvKC']")
    public List<WebElement>ıntroLeo;

}
