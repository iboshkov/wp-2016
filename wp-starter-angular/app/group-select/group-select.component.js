(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .component('groupSelect', {
      bindings : {
        grLabel: '@',
        grGroups: '<',
        grModel: "=",
      },
      controller: function() {
        console.log("Group select ctrl");
      },
      templateUrl: "/app/group-select/group-select.view.html"
    });

})(angular);
