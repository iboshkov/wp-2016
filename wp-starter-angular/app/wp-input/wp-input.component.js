(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .component('wpInput', {
      bindings : {
        wpType: '@',
        wpLabel: '@',
        wpModel: "=",
        wpFocus: "<",
      },
      controller: function() {
        console.log("Wp input ctrl");
      },
      templateUrl: "/app/wp-input/wp-input.view.html"
    });

})(angular);
