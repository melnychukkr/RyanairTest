var BookingExtrasPage = function() {

  this.proceedToPayment = function() {
    element(by.className("core-btn-primary core-btn-block core-btn-medium")).click();
  };

  this.declineThePopUp = function() {
    element(by.css("button[ng-click='closeThisDialog()']")).click();
  };
};

module.exports = BookingExtrasPage;
