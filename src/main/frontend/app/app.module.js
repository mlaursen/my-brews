angular.module('MyBeerApp', [
  'ngRoute',
  'ngSanitize'
]).constant(
  'REST_URL', 'http://localhost:8080/my-brews/api/'
).config(['$httpProvider', function($httpProvider) {
  
  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
}]);
