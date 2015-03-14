angular.module('MyBeerApp')
  .factory('CalendarFactory', function CalendarFactory($http, REST_URL) {
    var exports = {};

    exports.getEvents = function() {
      return $http.get(REST_URL + 'events')
        .success(function(data) {
          console.log('Success!', data);
        })
        .error(function(data) {
          console.log('There was an error..', data);
        });
    };
    
    exports.getRangedEvents = function(year, month) {
      return $http.get(REST_URL + 'events/' + year + '/' + month)
        .success(function(data) {
          console.log('Success!', data);
        })
        .error(function(data) {
          console.log('There was an error..', data);
        });
    }

    return exports;
  });
