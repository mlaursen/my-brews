var Navigation = require('./Navigation.react');
var ScrollingLogo = require('./ScrollingLogo.react');
var BeerSearch = require('../beer/BeerSearch.react');

var Navbar = React.createClass({
  render: function() {
    return (
      <div className="navigation flex centered auto">
        <Navigation />
        <ScrollingLogo />
        <BeerSearch />
      </div>
    );
  }
});

module.exports = Navbar;
