var React = require('react');

var BeerSearch = React.createClass({
  render: function() {
    return (
      <div className="search-container">
        <input type="text" placeholder="Belgian, Wheat, Stoute" id="main-search" name="main-search" />
        <button type="submit" className="search">
          <span className="fa fa-search"></span>
        </button>
      </div>
    );
  }
});

module.exports = BeerSearch;
