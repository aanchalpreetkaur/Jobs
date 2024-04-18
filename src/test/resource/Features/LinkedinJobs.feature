@Jobs
Feature: Jobs Functionality
  As a user
  I want to explore Jobs section on Linkedin
  So that I can find opportunities that match my skils and interests.

Background:
Given User is on Jobs page
  
  
   
 @scenario1
 Scenario: Sharing Job Preferences with recruiters
    When User clicks on Preferences
    And User clicks on Open To work
    And User enters title
    |Title|
    |Software Engineer|
    |Consultant|
    And User selects Location types
    And User enters Locations
    |Onsite| Remote|
    |Delhi| Amritsar|
    |Bangalore|Chandigarh|
    And User selects Employment types
    And User sets the visibility
    Then User should be able to save the preferences
    
    
    
  @scenario2
  Scenario: Sending Job Feedback to Linkedin    
     When User perform a job search 
     And User apply Company and Easy Apply filter
     And User clicks on Send Feedback option of Job
     And User clicks on send button after writing feedback
     Then a confirmation message should be displayed
   
   
  
  @scenario3
  Scenario: Practicing Interview Answers 
     When User clicks on Interview Prep in the left-hand menu
     And  User selects a specific interview question from the list
     And  User choose to write a text response for practice
     And  User enters the following answer
     |You should hire me because I have the qualifications, experience, and attitude to contribute to your company.|
     And User save the the answer
     Then User should be able to view saved answer 
    
  
  
  @scenario4
  Scenario Outline: Viewing Saved Job
    When User enters <keyword> in the first search bar
    And  User enters <location> in the second search bar
    And  User save a job from search results
    Then User should be able to view that saved Job in My Jobs
  
    Examples: 
      | keyword | location | 
      | "Teacher" | "Delhi" | 
      | "Consultant" | "Bangalore"|
      
  
  
  @scenario5 
  Scenario: To Test Company filter for Invalid CompanyName
    When the user performs a job search.
    And the user clicks on the AllFilter button.
    And the user applies the Company filter by adding a valid CompanyName.
    And the user applies the Company filter by adding an Invalid CompanyName.
    Then the addCompany textbox should not take invalid CompanyName
   
  
   
   
    
    
  
  
  
  
  
  
  