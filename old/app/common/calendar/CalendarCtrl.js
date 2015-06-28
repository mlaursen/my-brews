
angular.module('MyBeerApp')
  .controller('CalendarCtrl', function CalendarCtrl($scope, CalendarFactory) {
    'use strict';

    
    $scope.currentDate = moment();

    CalendarFactory.getEvents()
      .success(function(jsonData, statusCode) {
        console.log('The request was successful!', statusCode, jsonData);

        $scope.events = jsonData;
      });
    
    $scope.getRangedEvents = function(year, month) {
      CalendarFactory.getRangedEvents(year, month).success(function(data, code) {
        console.log('The request was successful!', code, data);
        
        $scope.events = data;
      });
    };
  });
