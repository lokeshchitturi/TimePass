Feature: Validating wishkarma functioalities 


#Scenario: Login and Logout 
#
#Given user navigated to application...Login:navigateToURL
#And user clicks login button...Login:clickLoginIcon
#When user enter credentials...Login:enterCredntials
#And user clicks on continue button...Login:clickContinue
#Then user validates the succesfull login...Login:validateLogin
#And user loguts from application...Login:logoutFromApplication


#Scenario Outline: Create New Project 
#
#	Given user login into application...Login:loginIntoApplication 
#	When user clicks on My Project Link...MyProjects:clickMyProjectLink 
#	And user enter details to create new project using data (<project name>;<project number>;<project type>;<description>)...MyProjects:createNewProject 
#	And user clicks on save button...MyProjects:clickSaveButton
#	Then user validates created project using data (<project name>)...MyProjects:validateCreateProject
#	Examples: 
#		|project name|project number|project type|description|
#		|Test Project 2|123455|Education|Test|
		
Scenario Outline: Validating Tabs 
Given user navigates to application...Login:navigateToURL
When user validates the tabs using data (<label list>)...MyProjects:validateTopNavigationLabels
And user clicks on each tab using data (<label list>)...MyProjects:clickTab

Examples:
|label list|
|BATH;MATERIALS;ELECTRICAL;EQUIPMENT;FIXTURES;FURNITURE;KITCHEN;MECHANICAL;OUTDOORS;PLUMBING;SAFETY|
|BATH;MATERIALS;ELECTRICAL;EQUIPMENT;FIXTURES;FURNITURE;KITCHEN;MECHANICAL;OUTDOORS;SAFETY;PLUMBING| 		
		