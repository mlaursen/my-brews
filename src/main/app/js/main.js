window.React = require('react/addons');
window.$ = require('jquery');
window.utils = require('./common/utils');


var Router = require('react-router');
var Route = Router.Route;
var DefaultRoute = Router.DefaultRoute;
var NotFoundRoute = Router.NotFoundRoute;

var App = require('./App.react');
var Beers = require('./beers/Beers.react');
var Beer = require('./beers/Beer.react');
var Home = require('./common/Home.react');
var NoContent = require('./common/NoContent.react');

/* Each time you nest, you will need the RouteHandler to be in the component. So the
 * nesting is if you want something to render in the same page
 */
var routes = (
  <Route handler={App}>
    <DefaultRoute handler={Home} />
    <Route path="beers" handler={Beers} />
    <Route path="beers/:id" handler={Beer} />
    <NotFoundRoute handler={NoContent} />
  </Route>
);

Router.run(routes, Router.HashLocation, function(Root) {
  React.render(<Root />, document.body);
});
