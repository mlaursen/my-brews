
angular.module('MyBeerApp')
  .controller('CalendarCtrl', function CalendarCtrl($scope) {
    'use strict';

    
    $scope.current = new Date();
  });
