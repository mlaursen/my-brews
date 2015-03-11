angular.module('AuthModule')
.factory('AuthFactory', ['$rootScope', '$http', function($rootScope, $http) {
  var authFactory = {
    authData: undefined
  };
  
  authFactory.login = function(credentials) {
    return $http.post('/my-brews/api/auth/login', credentials);
  }
  
  authFactory.setAuthData = function(authData) {
    if(authData == null || authData == undefined) {
      this.authData = undefined;
    } else {
      this.authData = {
        authId: authData.authId,
        authToken: authData.authToken,
        authPermission: authData.authPermission
      };
    }
    
    $rootScope.$broadcast('authChanged', this.authData);
  };
    
  authFactory.getAuthData = function() {
    return this.authData;
  };
  
  authFactory.isAuthenticated = function() {
    return !angular.isUndefined(this.getAuthData());
  };
  
  return authFactory;
}]);