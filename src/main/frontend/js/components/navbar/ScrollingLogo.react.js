var React = require('react');

var ScrollingLogo = React.createClass({
  render: function() {
    return (
      <div className="logo-container">
        <div className="marquee">
          <span className="overlay"></span>
          <img src="imgs/header.png" className="slider" />
          <div className="logo">
            <span>Mikali</span>
            <span>Brewing Company</span>
          </div>
        </div>
      </div>
    );
  }
});

module.exports = ScrollingLogo;
