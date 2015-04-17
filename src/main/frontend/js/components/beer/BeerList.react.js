var BeerStore = require('../../stores/BeerStore');

function getBeerListState() {
  return {
    allBeers: BeerStore.getAllBeers()
  };
}


var BeerList = React.createClass({
  getInitialState: function() {
    return getBeerListState();
  },

  componentDidMount: function() {
    BeerStore.addChangeListener(this._onChange);
  },

  componentWillUnmount: function() {
    BeerStore.removeChangeListener(this._onChange);
  },

  render: function() {
    return (
      <div className="fixed-content flex around">
        {this.state.allBeers.map(function(beer, index) {
          return <BeerItem beer={beer} key={index} />
        })}
      </div>
    );
  },

  _onChange: function() {
    this.setState(getBeerListState());
  }
});
module.exports = BeerList;

var BeerItem = React.createClass({
  render: function() {
    var beer = this.props.beer;
    return (
      <div key={'beer' + index} className={'beer-container clickable beer-' + beer.beerColor.name.toLowerCase()} onClick={selectBeer(beer.id)}>
        <header>
          {beer.name}
        </header>
        <div>
          <span>{beer.beerStyle.name}</span>
          <span className="separator"></span>
          <span>{beer.regionalStyle.name}</span>
        </div>
        <p>
          {beer.description}
        </p>
      </div>
    );
  }
});
