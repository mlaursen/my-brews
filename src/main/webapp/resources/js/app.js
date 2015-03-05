angular.module('MyBeerApp', [
    'ngRoute',
    'ngSanitize'
]).config(function ($routeProvider) {
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

});
