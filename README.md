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
This was completed quickly for a code test.  I blush as some of the code, but my time is limited.  There is masses of technical debt here, but it does do as requested.  For teh UI tests, it uses the Page Object Model pattern and there is a 'sortof' hint of the decorator pattern to 'wrap' the the UI elements so that we can perform synchronisation before each action - to reduce fragility.  It does this by, prior to an interaction with the UI, checking PageReady=complete for teh page and all frames and then checking that any AJAX requests are complete.

Whats missing:
Due to time constraints, this is not a complete framework.  This is what is missing or wrong:
1. It should have logging - so that you can diagnose faults.  Just dumping everything to console.

2. It should take a picture on failure and record details.

4. Asserts are not neccessarily in the right place.

5. The data is hard-coded.

6. Liberal use of statics

7. There is not enough Exception handling.

8. I would provide re-usable methods (wrappers) for complex UI objects like, for example, Calendars.

9. Uses 'sortof' decorator pattern to 'wrap' webelements.

10. There is a Thread.sleep.  I try not to use these.

### Steps to clone execute the tests
```
git clone https://github.com/naveenanimation20/PageObjectModel
cd PageObjectModel
mvn clean test
```
