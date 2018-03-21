Required already installed following technology:
- nodejs 8.3.0
- npm 5.3.0

Steps to run the test:
1. Execute **`npm install`** to download project modules listed as dependencies in package.json
2. Install protractor globally **`npm install -g protractor`** (project is created with 5.1.2). In global mode (e.g., with **-g** or **--global** appended to the command), it installs the protractor package as a global package instead of local one (current working directory).
3. Execute **`webdriver-manager update`** to download the selenium server jar and driver binaries (by default chromedriver binary). 
4. With the help of **`webdriver-manager start`** start Selenium Server. The selenium server will run on **http://localhost:4444/wd/hub**.
5. Run the test using **`protractor conf.js`**
6. Find reports under generated _reports_ directory.
