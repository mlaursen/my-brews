var Router = require('react-router');
var RouteHandler = Router.RouteHandler;
var Link = Router.Link;

var App = React.createClass({
  
  render: function() {
    return (
      <div>
        <h1>Hello, world!</h1>
        <Link to="/">Home</Link>
        <Link to="/beers">Beers</Link>
        <RouteHandler />
      </div>
    );
  }
});

module.exports = App;
