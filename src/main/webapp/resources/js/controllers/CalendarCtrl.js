
angular.module('MyBeerApp')
  .controller('CalendarCtrl', function CalendarCtrl($scope) {
    'use strict';

    $scope.title = "Loading...";
    
    $scope.currentDate = new Date();
    $scope.currentYear = $scope.currentDate.getYear() + 1900;
    $scope.currentMonth = $scope.currentDate.getMonth();

    $scope.previousMonth = function() {
      console.log('Previous Month!');
    }

    $scope.nextMonth = function() {
      console.log('Next month!');
    }

    $scope.setMonth = function(month) {
      $scope.currentDate.setMonth(month);
    }

    $scope.setYear = function(year) {
      $scope.currentDate.setYear(year - 1900);
    }
  });
