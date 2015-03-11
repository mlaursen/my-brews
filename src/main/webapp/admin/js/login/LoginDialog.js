angular.module('AuthApp')
  .directive('loginDialog', function(AUTH_EVENTS) {
    return {
      restrict: 'A',
      template: '<div ng-if="visibile" ng-include="\'login-form.html\'">',
      link: function(scope) {
        var showDialog = function() {
          scope.visible = true;
        }
        
        scope.visible = false;
        scope.$on(AUTH_EVENTS.notAuthenticated, showDialog);
        scope.$on(AUTH_EVENTS.sessionTimeout, showDialog);
      }
    }
  });