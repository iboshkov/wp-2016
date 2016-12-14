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

    var res =  $resource('/api/groups/:id', { id: '@id' }, {
      getAll: { method: 'GET' },
      getById: { method: 'GET' },
      save: { method: 'POST' },
      update: { method: 'PUT', url: "/api/groups/" },
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

    function saveFn(ent) {
      return res.save(ent).$promise;
    }


    function removeFn(ent) {
      return res.remove({id: ent.id}).$promise;
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

