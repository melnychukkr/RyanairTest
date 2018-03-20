- nodejs 8.3.0
- npm 5.3.0

Steps to run the test:
1. Execute `npm install` to download project dependencies
2. Install protractor globally `npm install -g protractor` (project is created with 5.1.2)
3. Execute `webdriver-manager update` and then with the help of `webdriver-manager start` start Selenium Server 
4. Run the test using `protractor conf.js`
5. Find reports under generated _reports_ directory.

