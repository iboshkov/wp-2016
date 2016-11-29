(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('GroupService', GroupServiceFn);

  GroupServiceFn.$inject = ['$log', '$timeout', '$q', "$resource"];

  /* @ngInject */
  function GroupServiceFn($log, $timeout, $q, $resource) {
    var groupsList = [];
    var groupIdSequence = 0;

    var res =  $resource('http://localhost:8080/servlet-showcase/api/groups/:id', { id: '@id' }, {
      getAll: { method: 'GET' },
      getById: { method: 'GET' },
      save: { method: 'POST' },
      update: { method: 'PUT' },
      remove: { method: 'DELETE' }
    });


    var service = {
      save: saveFn,
      update: updateFn,
      getById: getByIdFn,
      getAll: getAllFn,
      remove: removeFn
    };



    function getAllFn() {
      return res.query().$promise;
    }

    function updateFn(groupEntity) {
      return res.update(groupEntity).$promise;
    }

    function getByIdFn(groupId) {
      return res.query({id: groupId}).$promise;
    }

    return service;
  }

})(angular);

