var request = require('request');

var apiUri      = require('../config/config').ApiUri + '/beers';
var BeerActions = require('../actions/BeerActions');

module.exports = {
  fetchAllBeers: function() {
    request(apiUri, function(error, response, data) {
      if(!error) {
        BeerActions.fetchAllBeers(data);
      }
    });
  },

  fetchBeer: function(id) {
    request(apiUri + '/' + id, function(error, response, data) {
      if(!error) {
        BeerActions.fetchBeer(data);
      }
    });
  }
};
