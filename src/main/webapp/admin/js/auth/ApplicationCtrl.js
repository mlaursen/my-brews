angular.module('AuthModule')
.controller('ApplicationCtrl', function($scope) {

  $scope.user = {
    authId: undefined,
    authToken: undefined,
    authPermission: undefined
  };

	$scope.$on('authChanged', function(event, args) {
	  console.log('Auth has changed!', event, args);
    $scope.user = args;
	});

  $scope.getUser = function() {
    return $scope.user;
  }
});
