angular.module('AuthModule')
.controller('LoginCtrl', function($scope, AuthFactory) {
  $scope.credentials = {
    username: '',
    password: ''
  };
  
  $scope.login = function(credentials) {
    AuthFactory.login(credentials).success(function(data) {
      AuthFactory.setAuthData(data);
      console.log('Logged in!', data);
    }).error(function(data) {
      AuthFactory.setAuthData(null);
      console.log('There was an authentication problem.', data)
    });
  }
});