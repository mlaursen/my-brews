var AppDispatcher = require('../common/AppDispatcher');
var EventEmitter = require('events').EventEmitter;
var BeerConstants = require('./BeerConstants');
var _ = require('underscore');

var Beer = require('../common/Beer.proto');

var _beers = {},
    _beer  = null;

function setBeers(json) {
  json.map(Beer.fromJson).forEach(function(data) {
    _beers[data.id] = data;
  });
}

function setBeer(json) {
  _beer = json;
}
  

var BeerStore = _.extend({}, EventEmitter.prototype, {
  getBeers: function() {
    return _beers;
  },
  
  getBeer: function() {
    return _beer;
  },
  
  emitChange: function() {
    this.emit('change');
  },

  addChangeListener: function(callback) {
    this.on('change', callback);
  },

  removeChangeListener: function(callback) {
    this.removeListener('change', callback);
  }
});

AppDispatcher.register(function(payload) {
  var action = payload.action;

  switch(action.actionType) {
    case BeerConstants.BEER_RETRIEVE:
      setBeer(action.data);
      break;
    case BeerConstants.BEER_RETRIEVE_ALL:
      setBeers(action.data);
      break;
    default:
      return true;
  }

  BeerStore.emitChange();
  return true;
});

module.exports = BeerStore;
