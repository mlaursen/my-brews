angular.module('MyBeerApp')
  .directive('modalDialog', function(CalendarFactory) {
    return {
      restrict: 'E',
      templateUrl: 'templates/dialog.html',
      replace: true,
      transclude: true,
      scope: {
        visible: '=visible',
        header: '=header',
      },
      link: function(scope, element, attrs) {
        scope.closeDialog = function() {
          scope.visible = false;
        };
      }
    }
  });
