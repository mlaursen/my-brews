
angular.module('MyBeerApp')
  .controller('BeerCtrl', function BeerCtrl($scope, BeerFactory) {
    'use strict';

    BeerFactory.getBeers()
      .success(function(jsonData, statusCode) {
        console.log('The request was successful!', statusCode, jsonData);

        $scope.beers = jsonData;
      });
    
    $scope.viewBeer = function(id) {
      BeerFactory.getBeer(id)
        .success(function(jsonData, statusCode) {
          console.log('The single beer was retrieved!', statusCode, jsonData);

          $scope.beer = jsonData;
        });
    };
  });
