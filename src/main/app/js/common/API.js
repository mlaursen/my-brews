var request = require('request');

module.exports.request = request.defaults({
  withCreentials: false,
  json: true
});

module.exports.uri = require('../config').API_URL;
