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


public class FilesPage extends BasePage {

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





    @FindBy(xpath = "//a[@class='button new']")
    public WebElement newButton;

    /**
     * Clicks the "New" button to initiate a new action or process.
     */
    public void clickNewButton() {
        newButton.click();
    }

    /**
     * Selects an option from a dropdown or selectable list by its visible text.
     *
     * @param option the visible text of the option to be selected
     */
    public void selectOptionFromAddMenu(String option) {
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
        BrowserUtils.waitFor(2);
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
    public By getItemLocator(String itemName) {
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

    /**
     * Checks if a specific item is present in the list of all names.
     *
     * @param itemName the name of the item to check for presence
     * @return true if the item is present, false otherwise
     */
    public boolean isItemPresent(String itemName) {
        return getAllNames().contains(itemName);
    }





    /**
     * Enters a folder name into the input field and confirms the action.
     *
     * @param folderName the name of the folder to be entered
     */
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
     * Waits for 3 seconds before fetching the text to ensure elements are fully loaded.
     *
     * @return a list of strings containing the names of all items
     */
    public List<String> getAllNames() {
        BrowserUtils.waitFor(3);
        return BrowserUtils.getElementsText(fileListAllNames);
    }


    /**
     * Deletes a specified item by interacting with the three-dots menu.
     * First, it clicks the three-dots menu of the given item, then selects the "Delete" option.
     *
     * @param itemName the name of the item to be deleted
     */
    public void deleteItem(String itemName) {
        clickThreeDotsMenu(itemName);
        selectOptionFromThreeDotsMenu("Delete");
    }





    @FindBy(xpath = "//tbody[@id='fileList']//tr[@data-file]")
    public List<WebElement> fileList;

    /**
     * Clicks the three-dots menu for a specified item in the list.
     * Waits until the menu button is clickable before clicking.
     * If the menu is not found, an error message is printed.
     *
     * @param itemName the name of the item whose menu should be clicked
     */
    public void clickThreeDotsMenu(String itemName) {
        try {
            //String xpath = "//tr[contains(.,'" + itemName + "')]//span[contains(@class, 'icon-more')]\n";
            String xpath = "//tr[contains(.,'" + itemName + "')]//a[@data-action='menu']";
            BrowserUtils.waitForClickablility(By.xpath(xpath), 10);
            WebElement threeDotsButton = Driver.getDriver().findElement(By.xpath(xpath));
            threeDotsButton.click();
            System.out.println("Clicked the three dots menu for " + itemName);
        } catch (NoSuchElementException e) {
            System.out.println("Error: Three Dots Menu not found for " + itemName);
        }
    }

    /**
     * Selects an option from the three-dots menu by its action attribute.
     * Finds the menu option using its data-action value and clicks it.
     *
     * @param option the action name of the menu option to select
     */
    public void selectOptionFromThreeDotsMenu(String option) {
        WebElement optionElement = Driver.getDriver().findElement(By.xpath("//a[@data-action='" + option + "']"));
        optionElement.click();
    }

    /**
     * Adds an item (either a new folder or an uploaded file) based on the provided name.
     * - If the item name does not contain a dot (.), it is treated as a folder and created as a new folder.
     * - If the item name contains a dot (.), it is treated as a file and uploaded from a predefined directory.
     *
     * @param itemName the name of the item to be added (either a folder or a file)
     * @throws AWTException if an error occurs during file upload using the Robot class
     */
    public void addItem(String itemName) throws AWTException {
        clickNewButton();
        int lastDotIndex = itemName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            selectOptionFromAddMenu("New folder");
            enterFolderName(itemName);
        } else {
            selectOptionFromAddMenu("Upload file");
            uploadFileWithRobot("D:\\Cydeo\\" + itemName);
        }
    }





    /**
     * Retrieves the count of displayed folders from the file summary section.
     * Extracts the numeric value from the text inside the 'dirinfo' span element.
     *
     * @return the number of displayed folders as an integer
     */
    public int getDisplayedFolderCount() {
        WebElement countElement = Driver.getDriver().findElement(By.xpath("//td[@class='filesummary']//span//span[@class='dirinfo']"));
        String text = countElement.getText();
        System.out.println("Displayed folder count = " + text);
        String[] parts = text.split(" ");
        return Integer.parseInt(parts[0]);
    }

    /**
     * Retrieves the count of displayed files from the file summary section.
     * Extracts the numeric value from the text inside the 'fileinfo' span element.
     *
     * @return the number of displayed files as an integer
     */
    public int getDisplayedFileCount() {
        WebElement countElement = Driver.getDriver().findElement(By.xpath("//td[@class='filesummary']//span//span[@class='fileinfo']"));
        String text = countElement.getText();
        System.out.println("Displayed file count = " + text);
        String[] parts = text.split(" ");
        return Integer.parseInt(parts[0]);
    }




}
