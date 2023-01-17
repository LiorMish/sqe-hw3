package Moodle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoodleActuator {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public void initSession(String student_username, String student_pass){

        WebDriverManager.chromedriver().setup();
        // new chrome driver object
        this.webDriver = new ChromeDriver();
        this.webDriverWait = new WebDriverWait(webDriver, 60);

        // launch website -> localhost
        webDriver.get("http://localhost/");

        // maximize the window - some web apps look different in different sizes
        webDriver.manage().window().maximize();

        goToLogin();
        enterLoginInfo(student_username, student_pass);
        enterMyCourse();
        System.out.println("Driver setup finished for - " + webDriver.getTitle());
    }

    private void enterForumPage() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li/div/div[1]/div/div[1]/div/div[2]/div[2]/a")));
        webDriver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li/div/div[1]/div/div[1]/div/div[2]/div[2]/a")).click();
    }

    private void enterMyCourse() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/nav/div[1]/nav/ul/li[3]/a")));
        webDriver.findElement(By.xpath("/html/body/div[3]/nav/div[1]/nav/ul/li[3]/a")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/a/div")));
        webDriver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/a/div")).click();
    }


    public void goToLogin(){
        webDriver.findElement(By.linkText("Log in")).click();
    }

    public void enterLoginInfo(String username, String password) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(username);
        webDriver.findElement(By.xpath("//*[@name='password' and @type='password']")).sendKeys(password);
        webDriver.findElement(By.id("loginbtn")).click();
    }

    public void navigateTo_AddDiscussionTopic() {
        enterForumPage();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[1]/div/div[2]/a")));
        webDriver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[1]/div/div[2]/a")).click();
    }

    public void entersSubjectAndMessage(String subject, String message) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[2]/form/div[2]/div[2]/input"))).sendKeys(subject);
        webDriver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div[1]/div/div[3]/div")).sendKeys(message);

    }

    public void postToForum(){
        webDriver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[2]/form/div[4]/div[2]/fieldset/div/div[1]/span/input")).click();
    }

    public String successfullyPostMessage(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/span[1]/div/p[1]")));
        return webDriver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/span[1]/div/p[1]")).getText();
    }


    public void click_on_edit_mode() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/nav/div[2]/form/div/div/input")));
        webDriver.findElement(By.xpath("/html/body/div[3]/nav/div[2]/form/div/div/input")).click();
    }

    public void click_on_forum_options() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li/div/div[1]/div[2]/div/div/div/div/a/i")));
        webDriver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li/div/div[1]/div[2]/div/div/div/div/a/i")).click();
    }

    public void click_on_delete() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li/div/div[1]/div[2]/div/div/div/div/div/a[6]/span")));
        webDriver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[2]/ul/li/div/div[1]/div[2]/div/div/div/div/div/a[6]/span")).click();
    }

    public void click_on_yes() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[9]/div[2]/div/div/div[3]/button[2]")));
        webDriver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div/div[3]/button[2]")).click();
    }

}
