
angular.module('MyBeerApp')
  .controller('CalendarCtrl', function CalendarCtrl($scope, CalendarFactory) {
    'use strict';

    
    $scope.currentDate = moment();

    $scope.events2 = [
      {
        "name": "Test",
        "type": "brewing"
      },
      {
        "name": "Test Another",
        "type": "drink"
      }
    ];

    CalendarFactory.getEvents()
      .success(function(jsonData, statusCode) {
        console.log('The request was successful!', statusCode, jsonData);

        $scope.events = jsonData;
      });
  });
