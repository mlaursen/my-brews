
angular.module('MyBeerApp')
  .controller('BeersCtrl', function BeersCtrl($scope, $location, BeerFactory) {
    'use strict';

    BeerFactory.getBeers().success(function(jsonData, statusCode) {
        $scope.beers = jsonData;
      });
    
    $scope.viewBeer = function(id) {
      $location.path('beer/' + id);
    };
  });
