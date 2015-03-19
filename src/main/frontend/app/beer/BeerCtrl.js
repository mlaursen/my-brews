
angular.module('MyBeerApp')
  .controller('BeerCtrl', function BeerCtrl($scope, $routeParams, BeerFactory) {
    'use strict';

    BeerFactory.getBeer($routeParams.id).success(function(jsonData, statusCode) {
      console.log('The single beer was retrieved!', statusCode, jsonData);

      $scope.beer = jsonData;
    });
  });
