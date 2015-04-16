var React = require('react');

var Navigation = require('./Navigation.react');
var ScrollingLogo = require('./ScrollingLogo.react');
var BeerSearch = require('../beer/BeerSearch.react');

var Navbar = React.createClass({
  render: function() {
    return (
      <div className="navbar flex centered auto">
        <Navigation />
        <ScrollingLogo />
        <BeerSearch />
      </div>
    );
  }
});

module.exports = Navbar;
