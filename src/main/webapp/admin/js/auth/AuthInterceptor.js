angular.module('AuthModule')
.factory('AuthHttpRequestInterceptor', function($rootScope, $injector) {
  var authHttpRequestInterceptor = {
    request: function($request) {
      var authFactory = $injector.get('AuthFactory');
      if(authFactory.isAuthenticated()) {
        $request.headers['auth-id'] = authFactory.getAuthData().authId;
        $request.headers['auth-token'] = authFactory.getAuthData().authToken;
      }
      
      return $request;
    }
  };
  
  return authHttpRequestInterceptor;
});