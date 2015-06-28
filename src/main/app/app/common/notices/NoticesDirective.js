angular.module('MyBeerApp')
  .directive('notices', function() {
    return {
      restrict: 'E',
      templateUrl: 'app/common/notices/notices.html',
      link: function(scope) {

      }
    };
  });
