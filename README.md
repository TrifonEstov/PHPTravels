# PHPTravels
Some automated tests with Selenium web driver

This test plan is prepared to be run on Linux (Ubuntu) OS. It uses Chrome web driver for browser Version 99.0.4844.51 (Official Build) (64-bit).
In order to run the test on different browser version or OS, please download the exact driver from https://chromedriver.chromium.org/downloads
Then replace the "chromedriver" into folder: /PHPTravels/drivers. 
Also, please edit the path to the drive, located in java class StepsDefinitions, method setupDriver().

To run the tests locally, please clone the project using this link: https://github.com/TrifonEstov/PHPTravels.git

You can find additional information about how to clone the project here: https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository
Then open the cloned project in already installed IDE (e.g. IntelliJ IDEA), open php_travels_tests.feature file and run relevant scenario or the whole feature.


Test scenarios that are not implemented:
- Search for flights
- Apply for visa



Hints: In order to see step definition behind each test step in php_travels_tests.feature file, hold Ctrl + click on the relavant step.
