angular.module('AuthModule', [])
.config(function($httpProvider) {
  $httpProvider.interceptors.push('AuthHttpRequestInterceptor');
});