package com.meetSky.pages;

import com.meetSky.utilities.BrowserUtils;
import com.meetSky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;//*
import java.awt.datatransfer.StringSelection;//*
import java.awt.event.KeyEvent; //*
import java.util.List;



public class FilesPage extends BasePage{

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAllCheckBox;

    @FindBy(xpath = "//input[contains(@id,'select-files')]")
    public List<WebElement> allCheckBoxes;

    @FindBy(xpath = "(//div[@id='headerName-container']//span)[1]")
    public WebElement totalNumberOfFoldersFiles;

    @FindBy(xpath = "//tr[@data-type='file']")
    public List<WebElement> files;

    @FindBy(xpath = "//tr[@data-type='dir']")
    public List<WebElement> folders;

    //Created by Oguz **************************************************

    //==========================1111111111111111111111111===============

    public void waitForFileListToLoad(int time){
        BrowserUtils.waitForVisibility(By.xpath("//table[@id='filestable']//tbody[@id='fileList']//tr"),time);

    }


    @FindBy(xpath = "//a[@class='button new']")
    public WebElement newButton;

    /**
     * Clicks the "New" button to initiate a new action or process.
     */
    public void clickNewButton(){
        newButton.click();
    }

    /**
     * Selects an option from a dropdown or selectable list by its visible text.
     *
     * @param option the visible text of the option to be selected
     */
    public void addSelectOption(String option) {
        WebElement optionElement = Driver.getDriver().findElement(By.xpath("//span[text()='" + option + "']"));
        optionElement.click();
    }

    /**
     * Uploads a file using Java Robot class by simulating keyboard actions.
     * This method copies the given file path to the clipboard,
     * pastes it into the file chooser dialog, and confirms the selection.
     *
     * @param filePath The full path of the file to be uploaded.
     * @throws AWTException If the platform configuration does not allow low-level input control.
     */
    public void uploadFileWithRobot(String filePath) throws AWTException {
        Robot robot = new Robot();

        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    /**
     * Generates a dynamic XPath locator for a file item in a table.
     *
     * @param itemName the name of the file to locate
     * @return a By object containing the XPath expression to find the file item
     */
    public By getItemLocator(String itemName){
        //return By.xpath("//tr[contains(@data-file, '" + itemName + "')]");
        return By.xpath("//span[contains(@class, 'innernametext') and text()='" + itemName + "']");

    }

    /**
     * Extracts the file name without its extension.
     *
     * @param fileName the full name of the file including extension
     * @return the file name without the extension, or the original name if no extension is found
     */
    public String getFileNameWithoutExtension(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return "";
        }
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return fileName;
        }
        return fileName.substring(0, lastDotIndex);
    }

    public boolean isItemPresent(String itemName) {
        return getAllNames().contains(itemName);
    }

    //==========================222222222222222===============

    public void enterFolderName(String folderName) {


        WebElement folderInput = Driver.getDriver().findElement(By.xpath("//input[@value='New folder']"));
        folderInput.sendKeys(folderName);
        WebElement confirmButton = Driver.getDriver().findElement(By.xpath("//input[@class='icon-confirm']"));
        confirmButton.click();
    }



    @FindBy(xpath = "//tr[@data-file]//span[@class='innernametext']")
    public List<WebElement> fileListAllNames;

    /**
     * returns all the fıles and folder names as Lıst of Strıng
     * @return
     */
    public List<String> getAllNames() {
        return BrowserUtils.getElementsText(fileListAllNames);
    }


    /*
        public voıd deleteItem(Strıng ıtemName) {
           // clıcksOnThreeDotBtn(ıtemName)
           // deleteBtn.clıck()
        }

     */


    //============================333333333333333==============
    @FindBy(xpath = "//tbody[@id='fileList']//tr[@data-file]")
    public List<WebElement> fileList;

    @FindBy(xpath = "//tr[@data-file='\"+name+\"']//a[@data-action='menu']")
    public WebElement threeDotsMenu;

    public void clickThreeDotsMenu(String itemName) {
        try {

            String xpath = "//tr[contains(.,'" + itemName + "')]//span[contains(@class, 'icon-more')]\n";


            WebElement threeDotsButton = Driver.getDriver().findElement(By.xpath(xpath));

            threeDotsButton.click();
            System.out.println("Clicked the three dots menu for "+itemName);
        } catch (NoSuchElementException e) {
            System.out.println("Error: Three Dots Menu  not found for "+ itemName);
        }
    }

    public void selectOptionFromThreeDotsMenu(String option){
        WebElement optionElement = Driver.getDriver().findElement(By.xpath("//a[@data-action='" + option + "']"));
        optionElement.click();
    }


    public WebElement getFileListElement(String itemName){

        return Driver.getDriver().findElement(By.xpath("//tbody[@id='fileList']//tr[@data-file='"+itemName+"']"));

    }

    //============================444444444444444444444444==============



    public int getDisplayedFolderCount(){
        WebElement countElement=Driver.getDriver().findElement(By.xpath("//td[@class='filesummary']//span//span[@class='dirinfo']"));
        String text=countElement.getText();
        System.out.println("text = " + text);
        String[] parts=text.split(" ");
        return Integer.parseInt(parts[0]);
    }

    public int getDisplayedFileCount(){
        WebElement countElement=Driver.getDriver().findElement(By.xpath("//td[@class='filesummary']//span//span[@class='fileinfo']"));
        String text=countElement.getText();
        System.out.println("text = " + text);
        String[] parts=text.split(" ");
        return Integer.parseInt(parts[0]);
    }

























    //^Created by Oguz







}
