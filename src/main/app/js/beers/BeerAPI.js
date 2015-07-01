var API = require('../common/API');

var request = API.request;
var uri = API.uri + '/beers';

var BeerActions = require('./BeerActions');

module.exports = {
  retrieveAllBeers: function() {
    request(uri, function(error, response, data) {
      if(!error) {
        BeerActions.retrieveAllBeers(data);
      }
    });
  },

  retrieveBeer: function(id) {
    request(uri + '/' + id, function(error, response, data) {
      if(!error) {
        BeerActions.retrieveBeer(data);
      }
    });
  }
};
