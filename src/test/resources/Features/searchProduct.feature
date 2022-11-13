#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@author_asheesh
Feature: Search and place the order for Products

@Sanity @Regression
Scenario Outline: Serach Experience for product serach in both home and offers page
Given User is on Greenkart Lending Page
When user serached with Shortname <name> and extracted the actual product name
Then user serached for <name> shortname in offers page
And validate product name in offers page matches with Lending page

Examples:
|name|
|Tom|
|Beet|