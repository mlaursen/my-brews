angular.module('AuthApp', [
  'ngRoute',
  'ui.router'
]).constant('AUTH_EVENTS', {
  loginSuccess: 'auth-login-success',
  loginFailed: 'auth-login-failed',
  logoutSuccess: 'auth-logout-success',
  sessionTimeout: 'auth-session-timeout',
  notAuthenticated: 'auth-not-authenticated',
  notAuthorized: 'auth-not-authorized'
}).constant(
  'USER_ROLES', {
    all: '*',
    admin: 'admin',
    guest: 'guest'
}).constant('SERVICES', {
    login: '/my-brews/api/auth/login'
}).config(function($stateProvider, USER_ROLES) {
  $stateProvider.state('dashboard', {
    url: '/dashboard',
    templateUrl: 'dashboard/index.html',
    data: {
      authorizedRoles: [USER_ROLES.admin, USER_ROLES.guest]
    }
  });
}).config(function($httpProvider) {
  $httpProvider.interceptors.push([
    '$injector',
    function($injector) {
      return $injector.get('AuthInterceptor');
    }
  ]);
}).factory('AuthInterceptor', function($rootScope, $q, AUTH_EVENTS) {
  return {
    responseError: function(response) {
      $rootScope.$broadcast({
        401: AUTH_EVENTS.notAuthenticated,
        403: AUTH_EVENTS.notAuthorized,
        419: AUTH_EVENTS.sessionTimeout,
        440: AUTH_EVENTS.sessionTimeout
      } [response.status], response);
      return $q.reject(response);
    }
  };
}).run(function($rootScope, AUTH_EVENTS, AuthService) {
  $rootScope.$on('$stateChangeStart', function(event, next) {
    var authorizedRoles = next.data.authorizedRoles;
    if(!AuthService.isAuthorized(authorizedRoles)) {
      event.preventDefault();
      
      if(AuthService.isAuthenticated()) {
        console.log('User is not allowed');
        $rootScope.$broadcast(AUTH_EVENTS.notAuthorized);
      } else {
        console.log('User is not logged in');
        $rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);
      }
    }
  });
});