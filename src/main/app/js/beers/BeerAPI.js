var request = require('request');

var apiUrl = require('../config').API_URL + '/beers';

var BeerActions = require('./BeerActions');

module.exports = {
  retrieveAllBeers: function() {
    request(apiUrl, function(error, response, data) {
      if(!error) {
        BeerActions.retrieveAllBeers(JSON.parse(data));
      }
    });
  },

  retrieveBeer: function(id) {
    request(apiUrl + '/' + id, function(error, response, data) {
      if(!error) {
        BeerActions.retrieveBeer(JSON.parse(data));
      }
    });
  }
};
