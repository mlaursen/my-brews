
angular.module('MyBeerApp')
  .controller('CalendarCtrl', function CalendarCtrl($scope, CalendarFactory) {
    'use strict';

    
    $scope.currentDate = moment();
  });
