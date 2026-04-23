import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Data Driven Test
def testData = findTestData('Data Files/testData')
def firstname = testData.getObjectValue('firstname', 6)
def lastname = testData.getObjectValue('lastname', 6)
def email = testData.getObjectValue('email', 6)
def mobile = testData.getObjectValue('mobile', 6)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')

WebUI.setText(findTestObject('Object Repository/Form/input_Name_firstName'), firstname)

WebUI.setText(findTestObject('Object Repository/Form/input_Name_lastName'), lastname)

WebUI.setText(findTestObject('Object Repository/Form/input_Email_userEmail'), email)

// Pilih gender
WebUI.click(findTestObject('Object Repository/Form/input_Gender_gender-radio-1'))

// Input mobile number
WebUI.setText(findTestObject('Object Repository/Form/input_(10 Digits)_userNumber'), mobile)

// Pilih tanggal lahir (optional handling)
WebUI.click(findTestObject('Object Repository/Form/input_Date of Birth_dateOfBirthInput (1)'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Form/select_190019011902190319041905190619071908_246ee1'), '1995', false)

WebUI.selectOptionByValue(findTestObject('Object Repository/Form/select_JanuaryFebruaryMarchAprilMayJuneJuly_566629'), '6', false)

WebUI.click(findTestObject('Object Repository/Form/div_10'))

// Subject
WebUI.click(findTestObject('Object Repository/Form/div_Subjects_subjects-auto-complete__input-_3f4ff3'))

WebUI.setText(findTestObject('Object Repository/Form/input_subjectsInput'), 'd')

WebUI.click(findTestObject('Object Repository/Form/div_Hindi'))

// Hobby
WebUI.click(findTestObject('Object Repository/Form/input_Hobbies_hobbies-checkbox-1'))

// Upload file
String projectPath = RunConfiguration.getProjectDir()
String filePath = projectPath + '/Data Files/lop.jpg'

WebUI.uploadFile(findTestObject('Object Repository/Form/input_Picture_uploadPicture'), filePath)

// Address
WebUI.setText(findTestObject('Object Repository/Form/textarea_Current Address_currentAddress'), 'Jl.Bandung')

// State & City
WebUI.click(findTestObject('Object Repository/Form/svg_Select State_css-8mmkcg'))

WebUI.click(findTestObject('Object Repository/Form/div_NCR'))

WebUI.click(findTestObject('Object Repository/Form/svg_Select City_css-8mmkcg'))

WebUI.click(findTestObject('Object Repository/Form/div_Delhi'))

// Submit
WebUI.click(findTestObject('Object Repository/Form/button_Submit'))

WebUI.closeBrowser();