angular.module('MyBeerApp')
  .factory('BeerFactory', function BeerFactory($http, REST_URL) {
    var exports = {};

    exports.getBeers = function() {
      return $http.get(REST_URL + 'beers')
        .success(function(data) {
          console.log('Success!');
        })
        .error(function(data) {
          console.log('There was an error :/', data);
        });
    };

    exports.getBeer = function(id) {
      return $http.get(REST_URL + 'beers/' + id)
        .error(function(data) {
          console.log('There was an error getting the beer :/', data);
        });
    };

    return exports;
  });
