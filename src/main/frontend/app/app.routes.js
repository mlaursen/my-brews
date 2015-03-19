angular.module('MyBeerApp').config(function ($routeProvider) {
  'use strict';

  $routeProvider.when('/calendar', {
      templateUrl: 'app/common/calendar/calendar.html',
      controller: 'CalendarCtrl'
    }).when('/beer', {
      templateUrl: 'app/beer/beers.html',
      controller: 'BeersCtrl'
    }).when('/beer/:id', {
      templateUrl: 'app/beer/beer.html',
      controller: 'BeerCtrl'
    }).otherwise({
      redirectTo: '/beer'
    });

});
