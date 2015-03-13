angular.module('MyBeerApp', [
  'ngRoute',
  'ngSanitize'
]).constant(
  'REST_URL', 'http://192.168.1.15:8080/my-brews/api/'
).config(function ($routeProvider) {
  'use strict';

  $routeProvider
    .when('/calendar', {
      templateUrl: 'views/calendar.html',
      controller: 'CalendarCtrl'
    })
    .when('/calendar/:date', {
      templateUrl: 'views/calendarDate.html',
      controller: 'CalendarDateCtrl'
    })
    .when('/beer', {
      templateUrl: 'views/beers.html',
      controller: 'BeerCtrl'
    })
    .when('/beer/:id', {
      templateUrl: 'views/beer.html',
      controller: 'BeerCtrl'
    })
    .otherwise({
      redirectTo: '/beer'
    });

}).config(['$httpProvider', function($httpProvider) {
  
  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
}]);
