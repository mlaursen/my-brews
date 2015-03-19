angular.module('AuthApp')
  .factory('AuthService', function($http, Session, SERVICES) {
    var authService = {};
    
    authService.login = function(credentials) {
      return $http.post(SERVICES.login, credentials).then(function(response) {
        var data = response.data;
        Session.create(data.id, data.user.id, data.user.role);
        return response.data.user;
      });
    };
    
    authService.isAuthenticated = function() {
      return !!Session.userid;
    };
    
    authService.isAuthorized = function(authorizedRoles) {
      if(!angular.isArray(authorizedRoles)) {
        authorizedRoles = [authorizedRoles];
      }
      
      return authService.isAuthenticated()
          && authorizedRoles.indexOf(Session.userRole !== -1);
    };
    
    return authService;
  });