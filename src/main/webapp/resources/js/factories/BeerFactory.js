angular.module('MyBeerApp')
  .factory('BeerFactory', function BeerFactory($http) {
    var exports = {};

    exports.getBeers = function() {
      return $http.get('api/beers')
        .success(function(data) {
          console.log('Success!');
        })
        .error(function(data) {
          console.log('There was an error :/', data);
        });
    };

    exports.getBeer = function(id) {
      return $http.get('api/beers/' + id)
        .error(function(data) {
          console.log('There was an error getting the beer :/', data);
        });
    };

    return exports;
  });
