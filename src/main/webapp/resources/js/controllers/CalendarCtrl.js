
angular.module('MyBeerApp')
  .controller('CalendarCtrl', function CalendarCtrl($scope) {
    'use strict';

    
    $scope.currentDate = moment();
  });
