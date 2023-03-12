# Test automation framework using Selenium with Java
This project uses the Page Object Model pattern.
TestNG is used as test framework.

Dependency
Java
Maven

###libraries used
Selenium
TestNG


Overview:
This was completed quickly for the code test.  There is masses of technical debt here, but it does do as requested - well only for the UI.  I have run out of time.  It uses the Page Object Model pattern and there is a 'sortof' hint of the decorator pattern to 'wrap' the the UI elements so that we can perform synchronisation before each action - to reduce fragility.  It does this by, prior to an interaction with the UI, checking PageReady=complete for the page and all frames and then checking that any AJAX requests are complete.

Whats missing:
Due to time constraints, this is not complete.  This is what is missing or wrong:
1. It should have logging - so that you can diagnose faults.  Just dumping everything to console.

2. It should take a picture on failure and record details.

4. The data is hard-coded.

5. Liberal use of statics

6. There is not enough Exception handling.

7. I would provide re-usable methods (wrappers) for complex UI objects like, for example, Calendars.

8. Uses 'sortof' decorator pattern to 'wrap' webelements.

9. There is a Thread.sleep.  I try not to use these.

### Steps to clone execute the tests
```
git clone https://github.com/JohnPKent/TAFW_JavaSel_MVN.git
cd TAFW_JavaSel_MVN
mvn test
```
