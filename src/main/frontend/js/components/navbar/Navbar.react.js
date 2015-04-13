var React = require('react');

var Navigation = require('./Navigation.react');
var ScrollingLogo = require('./ScrollingLogo.react');
var BeerSearch = require('../beer/BeerSearch.react');

var Navbar = React.createClass({
  render: function() {
    return (
      <header className="navbar">
        <Navigation />
        <ScrollingLogo />
        <BeerSearch />
      </header>
    );
  }
});

module.exports = Navbar;
