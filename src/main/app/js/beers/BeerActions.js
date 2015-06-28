var AppDispatcher = require('../common/AppDispatcher');
var BeerConstants = require('./BeerConstants');

var BeerActions = {
  retrieveAllBeers: function(data) {
    AppDispatcher.handleAction({
      actionType: BeerConstants.BEER_RETRIEVE_ALL,
      data: data
    });
  },

  retrieveBeer: function(data) {
    AppDispatcher.handleAction({
      actionType: BeerConstants.BEER_RETRIEVE,
      data: data
    });
  }
};

module.exports = BeerActions;
