angular.module('MyBeerApp')
  .directive('calendar', function() {
    restrict: 'E',
    templateUrl: 'templates/calendar.html',
    controllerAs: 'calendar',
    controller: 'CalendarCtrl',
    scope: {
      current: '='
    },
    link: function(scope) {
      scope.select = function(day) {
        console.log('Selected ' + day);
      }

      scope.next = function() {
        console.log('Next Month');
      }

      scope.previous = function() {
        console.log('Previous Month');
      }
    }
  });
