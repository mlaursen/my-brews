angular.module('MyBeerApp')
  .factory('CalendarFactory', function CalendarFactory($http) {
    var exports = {};

    exports.getEvents = function() {
      return $http.get('json/events.json')
        .success(function(data) {
          console.log('Success!', data);
        })
        .error(function(data) {
          console.log('There was an error..', data);
        });
    };

    return exports;
  });
