angular.module('MyBeerApp')
  .factory('BeerFactory', function BeerFactory($http) {
    var exports = {};

    exports.getBeers = function() {
      return $http.get('json/beers.json')
        .success(function(data) {
          console.log('Success!');
        })
        .error(function(data) {
          console.log('There was an error :/', data);
        });
    };

    return exports;
  });
