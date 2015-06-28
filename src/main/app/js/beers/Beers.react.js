var FluxIt = require('../common/FluxIt.react');

var BeerStore = require('./BeerStore');
var BeerAPI = require('./BeerAPI');

var Beers = React.createClass({
  propTypes: {
    beers: React.PropTypes.object
  },

  render: function() {
    var beers = utils.toList(this.props.beers);
    return (
      <div className="beers-container">
        {beers.map(function(beer) {
          return (
            <Beer key={beer.id} beer={beer} />
          );
        })}
      </div>
    );
  }
});

Beers = 
  FluxIt.init(
    Beers,
    function() {
      return {
        beers: BeerStore.getBeers()
      };
    },
    [BeerStore],
    [BeerAPI.retrieveAllBeers]
  );

module.exports = Beers;




var Beer = React.createClass({
  
  render: function() {
    var beer = this.props.beer;
    return (
      <div className="spacing">
        <div className={'beer-container beer-' + beer.color.toLowerCase()}>
          <header>{beer.name}</header>
          <div>
            <span>{beer.beerStyle}</span>
            <span className="separator" />
            <span>{beer.regionalStyle}</span>
          </div>
          <p>{beer.description}</p>
        </div>
      </div>
    );
  }
});
