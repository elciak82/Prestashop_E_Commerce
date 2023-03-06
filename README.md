<div id="header" align="center">
  <img src="https://media.giphy.com/media/xSM46ernAUN3y/giphy.gif"/>
</div>
<div id="badges" align="center">
  <a href="https://www.linkedin.com/in/ewelinqa/">
    <img src="https://img.shields.io/badge/LinkedIn-blue?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn Badge"/>
  </a>
</div>
<div id="visits" align="center">
  <img src="https://komarev.com/ghpvc/?username=elciak82&style=flat-square&color=blue" alt=""/>
</div>



# Prestashop_E_Commerce
Project for test automation covering UI acceptance for web and mobile.

## Concepts included
* Page Object pattern
* Common web page interaction methods
* Externalised test configuration

## Tools
* Maven
* TestNG
* Selenium Webdriver
* Allure

## Requirements
In order to utilise this project you need to have the following installed locally:

* Java 11
* Maven 3
* Chrome and Chromedriver (UI tests use Chrome by default, can be changed in config)
* 


start tests: mvn clean test
generate report: allure serve allure-results
clean old data: allure generate --clean --output allure-results

restart jenkins: http://localhost:8080/safeRestart - Allows all running jobs to complete. New jobs will remain in the queue to run after the restart is complete.
restart jenkins: http://localhost:8080/restart - Forces a restart without waiting for builds to complete.


