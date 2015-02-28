
angular.module('MyBeerApp')
  .controller('BeerCtrl', function BeerCtrl($scope, BeerFactory) {
    'use strict';

    BeerFactory.getBeers()
      .success(function(jsonData, statusCode) {
        console.log('The request was successful!', statusCode, jsonData);

        $scope.beers = jsonData;
      });

  });
