var Router = require('react-router');
var RouteHandler = Router.RouteHandler;
var Link = Router.Link;

var App = React.createClass({
  getInitialState: function() {
    return {
      isMenuVisible: false
    };
  },

  toggleMenu: function() {
    this.setState({
      isMenuVisible: !this.state.isMenuVisible
    });
  },

  closeMenu: function() {
    this.setState({
      isMenuVisible: false
    });
  },
  
  render: function() {
    return (
      <div className={this.state.isMenuVisible ? 'menu-visible' : ''}>
        <Link to="/">Home</Link>
        <Link to="/beers">Beers</Link>
        <RouteHandler />
      </div>
    );
  }
});

module.exports = App;
