var HomePage = function() {

  this.openHomePage = function() {
    browser.get('http://www.ryanair.com/ie/en/');
  };

  this.logIn = function(username, password) {
    element(by.css("a[ui-sref='login']")).click();
    element(by.css("div[class = 'modal-form-container ng-scope']")).isPresent().then(function () {
      element(by.css("input[name='emailAddress']")).sendKeys(username);
      element(by.css("password-input > input[name='password']")).sendKeys(password);
      element(by.css("[button-text='MYRYANAIR.AUTHORIZATION.LOGIN.LOGIN_AUTHORIZATION']")).click();
    });
  };

  this.enterDepartureAirport = function(departureCountry, departureCity) {
    var airport = element(by.css("input[placeholder='Departure airport']"));

    airport.click();
    if(!isPickerOpen) {
      airport.click();
    }

    var countryDeparture = element(by.cssContainingText('div.core-list-item', departureCountry));
    scrollIntoViewAndClick(countryDeparture);

    var cityDeparture = element(by.cssContainingText('span', departureCity));
    scrollIntoViewAndClick(cityDeparture);
  };

  this.enterDestinationAirport = function(destinationCountry, destinationCity) {
    var airportToInput = element(by.css("input[placeholder='Destination airport']"));

    if(!isPickerOpen) {
      airportToInput.click();
    }

    var countryDestination = element(by.cssContainingText('div.core-list-item', destinationCountry));
    scrollIntoViewAndClick(countryDestination);

    var cityDestination = element(by.cssContainingText('span', destinationCity));
    scrollIntoViewAndClick(cityDestination);
  };

  this.selectOneWayTrip = function() {
    element(by.css("div[class='flight-search-type-option one-way']")).click();
  };

  this.selectFlyOutDate = function(date) {
    var parsedDate = date.split("-");
    element(by.name("dateInput0")).sendKeys(parsedDate[0]);
    element(by.name("dateInput1")).sendKeys(parsedDate[1]);
    element(by.name("dateInput2")).sendKeys(parsedDate[2]);
  };

  this.setNumberOfPassengers = function(adults) {
    var passengersNumberDropdown = element(by.css("div.dropdown-handle"));
    passengersNumberDropdown.click();

    for(var i=0; i < adults - 1; i++) {
      element(by.css("div[value='paxInput.adults'] button[ng-click='$ctrl.increment()']")).click();
    }

  };

  this.clickLetsGoButton = function() {
    element(by.css("[ng-click='searchFlights()']")).click();
  };

  this.isUserLoggedIn = function(expectedUsername) {
    var username = element(by.cssContainingText('span.username', expectedUsername));
    return username.isDisplayed().then(function (isVisible) {
      return isVisible;
    });
  };

  isPickerOpen = function() {
    var airportsPicker = element(by.css('core-linked-list'));
    airportsPicker.isDisplayed().then(function (isVisible) {
      return isVisible;
    });
  };

  scrollIntoViewAndClick = function(element) {
    browser.executeScript("arguments[0].scrollIntoView();", element.getWebElement());
    element.click();
  };
};

module.exports = HomePage;
