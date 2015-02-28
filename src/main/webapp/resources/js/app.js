angular.module('MyBeerApp', [
    'ngRoute',
    'ngSanitize'
]).constant('REST_CALL', {
  'BASE': '/api',
  'BEER': '/beer'
}).config(function ($routeProvider) {
  'use strict';

  $routeProvider
    .when('/calendar', {
      templateUrl: 'views/calendar.html',
      controller: 'CalendarCtrl',
      controllerAs: 'calendar'
    })
    .when('/calendar/:date', {
      templateUrl: 'views/calendarDate.html',
      controller: 'CalendarDateCtrl',
      controllerAs: 'calendarDate'
    })
    .when('/beer', {
      templateUrl: 'views/beers.html',
      controller: 'BeerCtrl',
      controllerAs: 'beers'
    })
    .when('/beer/:id', {
      templateUrl: 'views/beer.html',
      controller: 'BeerCtrl',
      controllerAs: 'beer'
    })
    .otherwise({
      redirectTo: '/beer'
    });

});
